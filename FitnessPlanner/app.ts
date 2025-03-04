import { Chart } from "chart.js";

interface Exercise {
    id: string;
    name: string;
    duration: number;
    sets: number;
    restPeriod: number;
}

interface Routine {
    id: string;
    name: string;
    exercises: Exercise[];
    createdAt: Date;
}

interface ProgressEntry {
    id: string;
    routineId: string;
    date: Date;
    completed: boolean;
    duration: number;
}

// State Management
class FitnessPlanner {
    private routines: Routine[] = [];
    private progress: ProgressEntry[] = [];

    constructor() {
        this.loadFromLocalStorage();
        this.initializeEventListeners();
    }

    private loadFromLocalStorage(): void {
        const savedRoutines = localStorage.getItem('routines');
        const savedProgress = localStorage.getItem('progress');

        if (savedRoutines) {
            this.routines = JSON.parse(savedRoutines);
        }

        if (savedProgress) {
            this.progress = JSON.parse(savedProgress);
        }
    }

    private saveToLocalStorage(): void {
        localStorage.setItem('routines', JSON.stringify(this.routines));
        localStorage.setItem('progress', JSON.stringify(this.progress));
    }

    private initializeEventListeners(): void {
        // Mobile menu toggle
        const mobileMenu = document.querySelector('.mobile-menu');
        const navLinks = document.querySelector('.nav-links');

        if (mobileMenu && navLinks) {
            mobileMenu.addEventListener('click', () => {
                navLinks.classList.toggle('active');
            });
        }

        // Form submissions
        const routineForm = document.getElementById('routine-form');
        if (routineForm) {
            routineForm.addEventListener('submit', this.handleRoutineSubmit.bind(this));
        }
    }

    private handleRoutineSubmit(e: Event): void {
        e.preventDefault();
        const form = e.target as HTMLFormElement;
        const formData = new FormData(form);

        const routine: Routine = {
            id: crypto.randomUUID(),
            name: formData.get('routineName') as string,
            exercises: [],
            createdAt: new Date()
        };

        this.routines.push(routine);
        this.saveToLocalStorage();
        this.updateRoutinesList();
    }

    private updateRoutinesList(): void {
        const routinesList = document.getElementById('routines-list');
        if (!routinesList) return;

        routinesList.innerHTML = '';
        this.routines.forEach(routine => {
            const routineElement = document.createElement('div');
            routineElement.className = 'routine-card';
            routineElement.innerHTML = `
                <h3>${routine.name}</h3>
                <p>Exercises: ${routine.exercises.length}</p>
                <p>Created: ${routine.createdAt.toLocaleDateString()}</p>
                <button onclick="deleteRoutine('${routine.id}')">Delete</button>
            `;
            routinesList.appendChild(routineElement);
        });
    }

    public deleteRoutine(id: string): void {
        this.routines = this.routines.filter(routine => routine.id !== id);
        this.saveToLocalStorage();
        this.updateRoutinesList();
    }

    public addProgress(routineId: string): void {
        const progress: ProgressEntry = {
            id: crypto.randomUUID(),
            routineId,
            date: new Date(),
            completed: true,
            duration: 0
        };

        this.progress.push(progress);
        this.saveToLocalStorage();
        this.updateProgressChart();
    }

    private updateProgressChart(): void {
        const ctx = document.getElementById('progress-chart') as HTMLCanvasElement;
        if (!ctx) return;

        const progressData = this.getProgressData();

        new Chart(ctx, {
            type: 'line',
            data: {
                labels: progressData.labels,
                datasets: [{
                    label: 'Workouts Completed',
                    data: progressData.data,
                    borderColor: '#3498db',
                    tension: 0.1
                }]
            },
            options: {
                responsive: true,
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });
    }

    private getProgressData() {
        const last7Days = Array.from({length: 7}, (_, i) => {
            const d = new Date();
            d.setDate(d.getDate() - i);
            return d.toISOString().split('T')[0];
        }).reverse();

        const data = last7Days.map(date => {
            return this.progress.filter(p => 
                p.date.toISOString().split('T')[0] === date
            ).length;
        });

        return {
            labels: last7Days,
            data
        };
    }
}

// Initialize the application
const app = new FitnessPlanner();