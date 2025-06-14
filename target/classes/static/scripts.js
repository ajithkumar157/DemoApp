function enterDetails() {
    let studentData = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        technology: document.getElementById("technology").value
    };

    fetch("http://localhost:8080/api/add/student", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(studentData)
    })
    .then(response => {
        if (!response.ok) {
            return response.text().then(errorMessage => { throw new Error(errorMessage); });
        }
        return response.json();
    })
    .then(data => {
        console.log("Student added:", data);
        alert("Student successfully registered!");
    })
.catch(error => {
    console.error("Error adding student:", error);
    
    // Extract the error message from the backend response
    let simpleMessage = error.message.includes("already registered")
        ? "This email is already registered. Please use a different one!"
        : error.message.includes("Invalid technology")
        ? "Please select a valid technology from the available courses!"
        : "Something went wrong. Please try again.";

    alert(simpleMessage);
});
}

function courseAvailable() {
    fetch("http://localhost:8080/api/courses")
    .then(response => response.json())
    .then(data => {
        let table = document.getElementById("coursesTable");
        table.innerHTML = "<tr><th>Course Name</th><th>Duration</th></tr>"; // Reset table

        data.forEach(course => {
            let row = table.insertRow();
            row.insertCell(0).innerText = course.name;
            row.insertCell(1).innerText = course.duration;
        });
    })
    .catch(error => console.error("Error fetching courses:", error));
}

function fetchEnrolledStudents() {
    fetch("http://localhost:8080/api/enrolled")
    .then(response => response.json())
    .then(data => {
        let table = document.getElementById("enrolledStudentsTable");
        table.innerHTML = "<tr><th>Name</th><th>Email</th><th>Technology</th></tr>"; // Reset table

        data.forEach(student => {
            let row = table.insertRow();
            row.insertCell(0).innerText = student.name;
            row.insertCell(1).innerText = student.email;
            row.insertCell(2).innerText = student.technology;
        });
    })
    .catch(error => console.error("Error fetching students:", error));
}
