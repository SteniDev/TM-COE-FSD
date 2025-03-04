document.addEventListener("DOMContentLoaded", () => {
    const routinesList = document.getElementById("routines-list");

    if (routinesList) {
        // Load routines from localStorage
        const routines = JSON.parse(localStorage.getItem("routines")) || [];

        if (routines.length === 0) {
            routinesList.innerHTML = "<p>No routines found. Create a new one!</p>";
            return;
        }

        // Display each routine
        routines.forEach((routine) => {
            const routineElement = document.createElement("div");
            routineElement.className = "routine-card";
            routineElement.innerHTML = `
                <h3>${routine.name}</h3>
                <button class="view-routine" data-id="${routine.id}">View Details</button>
                <button class="delete-routine" data-id="${routine.id}">Delete</button>
            `;
            routinesList.appendChild(routineElement);
        });

        // Add event listener for viewing details
        document.querySelectorAll(".view-routine").forEach((button) => {
            button.addEventListener("click", (e) => {
                const routineId = e.target.getAttribute("data-id");
                showRoutineDetails(routineId);
            });
        });

        // Add event listener for deleting routines
        document.querySelectorAll(".delete-routine").forEach((button) => {
            button.addEventListener("click", (e) => {
                const routineId = e.target.getAttribute("data-id");
                deleteRoutine(routineId);
            });
        });
    }
});

// Function to show routine details in the modal
function showRoutineDetails(routineId) {
    const routines = JSON.parse(localStorage.getItem("routines")) || [];
    const routine = routines.find((r) => r.id === routineId);

    if (!routine) return;

    document.getElementById("routine-detail-name").textContent = routine.name;
    const detailsContainer = document.getElementById("routine-detail-exercises");
    detailsContainer.innerHTML = "";

    routine.exercises.forEach((exercise) => {
        const exerciseElement = document.createElement("p");
        exerciseElement.textContent = `${exercise.name} - ${exercise.sets} sets, ${exercise.duration}s, ${exercise.restPeriod}s rest`;
        detailsContainer.appendChild(exerciseElement);
    });

    document.getElementById("routine-modal").style.display = "block";
}

// Function to delete routine
function deleteRoutine(routineId) {
    let routines = JSON.parse(localStorage.getItem("routines")) || [];
    routines = routines.filter((routine) => routine.id !== routineId);
    localStorage.setItem("routines", JSON.stringify(routines));
    alert("Routine deleted!");
    location.reload();
}

// Close the routine modal
document.getElementById("close-routine-modal").addEventListener("click", () => {
    document.getElementById("routine-modal").style.display = "none";
});
