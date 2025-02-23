interface Exercise {
    id: string;
    name: string;
    sets: number;
    duration: number;
    restPeriod: number;
}

class ExerciseModal {
    private modal: HTMLElement | null;
    private form: HTMLFormElement | null;
    private closeButton: HTMLElement | null;

    constructor() {
        this.modal = document.getElementById('exercise-modal');
        this.form = document.getElementById('exercise-form') as HTMLFormElement;
        this.closeButton = document.getElementById('close-modal');
        this.initializeEventListeners();
    }

    private initializeEventListeners(): void {
        if (this.form) {
            this.form.addEventListener('submit', this.handleSubmit.bind(this));
        }

        if (this.closeButton) {
            this.closeButton.addEventListener('click', this.close.bind(this));
        }
    }

    public open(): void {
        if (this.modal) {
            this.modal.style.display = 'block';
        }
    }

    public close(): void {
        if (this.modal) {
            this.modal.style.display = 'none';
        }
        if (this.form) {
            this.form.reset();
        }
    }

    private handleSubmit(e: Event): void {
        e.preventDefault();
        const formData = new FormData(this.form as HTMLFormElement);
        const exercise: Exercise = {
            id: crypto.randomUUID(),
            name: formData.get('exerciseName') as string,
            sets: parseInt(formData.get('sets') as string),
            duration: parseInt(formData.get('duration') as string),
            restPeriod: parseInt(formData.get('rest') as string)
        };

        const event = new CustomEvent('exerciseAdded', { detail: exercise });
        document.dispatchEvent(event);
        this.close();
    }
}

// Drag and Drop Functionality
class DragAndDrop {
    private container: HTMLElement | null;

    constructor(containerId: string) {
        this.container = document.getElementById(containerId);
        this.initializeDragAndDrop();
    }

    private initializeDragAndDrop(): void {
        if (!this.container) return;

        this.container.addEventListener('dragstart', (e: DragEvent) => {
            const target = e.target as HTMLElement;
            target.classList.add('dragging');
        });

        this.container.addEventListener('dragend', (e: DragEvent) => {
            const target = e.target as HTMLElement;
            target.classList.remove('dragging');
        });

        this.container.addEventListener('dragover', (e: DragEvent) => {
            e.preventDefault();
            const afterElement = this.getDragAfterElement(e.clientY);
            const draggable = document.querySelector('.dragging');
            if (draggable && this.container) {
                if (afterElement) {
                    this.container.insertBefore(draggable, afterElement);
                } else {
                    this.container.appendChild(draggable);
                }
            }
        });
    }

    private getDragAfterElement(y: number): Element | null {
        if (!this.container) return null;

        const draggableElements = [...this.container.querySelectorAll('.draggable:not(.dragging)')];

        return draggableElements.reduce((closest, child) => {
            const box = child.getBoundingClientRect();
            const offset = y - box.top - box.height / 2;
            if (offset < 0 && offset > closest.offset) {
                return { offset, element: child };
            } else {
                return closest;
            }
        }, { offset: Number.NEGATIVE_INFINITY, element: null } as { offset: number; element: Element | null }).element;
    }
}

// Initialize components
document.addEventListener('DOMContentLoaded', () => {
    const exerciseModal = new ExerciseModal();
    const dragAndDrop = new DragAndDrop('exercise-list');

    // Add exercise button
    const addExerciseButton = document.getElementById('add-exercise');
    if (addExerciseButton) {
        addExerciseButton.addEventListener('click', () => {
            exerciseModal.open();
        });
    }

    // Handle exercise added event
    document.addEventListener('exerciseAdded', (e) => {
        const event = e as CustomEvent<Exercise>;
        const exerciseList = document.getElementById('exercise-list');
        if (exerciseList) {
            const exerciseElement = document.createElement('div');
            exerciseElement.className = 'exercise-item draggable';
            exerciseElement.draggable = true;
            exerciseElement.setAttribute('data-id', event.detail.id);
            exerciseElement.innerHTML = `
                <span>${event.detail.name}</span>
                <span>${event.detail.sets} sets, ${event.detail.duration}s, ${event.detail.restPeriod}s rest</span>
                <button class="secondary-button" onclick="deleteExercise('${event.detail.id}')">Delete</button>
            `;
            exerciseList.appendChild(exerciseElement);
        }
    });
    ;
});

// Delete function
function deleteExercise(id: string) {
    const exerciseList = document.getElementById('exercise-list');
    if (exerciseList) {
        const exerciseItem = exerciseList.querySelector(`[data-id="${id}"]`);
        if (exerciseItem) {
            exerciseList.removeChild(exerciseItem);
        }
    }
}
