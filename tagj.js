
    function toggleVisibility() {
        var syllabus = document.getElementById("syllabus-content-area");
        var button = document.getElementById("show-syllabus-btn");

        // Toggle the display property
        if (syllabus.style.display === "none" || syllabus.style.display === "") {
            syllabus.style.display = "block"; 
            button.textContent = "Hide Course Syllabus";
        } else {
            syllabus.style.display = "none";
            button.textContent = "Show Course Syllabus";
        }
    }
