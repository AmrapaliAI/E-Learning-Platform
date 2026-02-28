let timeLimitSeconds = 40 * 60; // 780 seconds
    
    // Get references to the HTML elements
    const timerDisplay = document.getElementById('quiz-timer');
    const quizForm = document.getElementById('mcq-form');
    
    // Function to format total seconds into MM:SS format
    function formatTime(totalSeconds) {
        const minutes = Math.floor(totalSeconds / 60);
        const seconds = totalSeconds % 60;
        // padStart ensures "05" instead of "5"
        const formattedMinutes = String(minutes).padStart(2, '0');
        const formattedSeconds = String(seconds).padStart(2, '0');
        return formattedMinutes + ":" + formattedSeconds;
    }

    // Function that runs every 1000 milliseconds (1 second)
    function updateQuizTimer() {
        if (timeLimitSeconds <= 0) {
            // --- TIME EXPIRED ACTIONS ---
            clearInterval(timerInterval); // Stop the timer from counting further
            timerDisplay.textContent = "TIME EXPIRED! Submitting...";
            
            // 1. Disable all form elements to lock answers
            if (quizForm) {
                Array.from(quizForm.elements).forEach(element => {
                    element.disabled = true;
                });
                
                // 2. Automatically submit the form
                quizForm.submit(); 
            }

        } else {
            // Update the display with the new formatted time
            timerDisplay.textContent = "Time Remaining: " + formatTime(timeLimitSeconds);
            // Decrement the timer by 1 second
            timeLimitSeconds--;
        }
    }

    // Initialize the display before starting the countdown (shows 13:00 immediately)
    timerDisplay.textContent = "Time Remaining: " + formatTime(timeLimitSeconds);
    
    // Start the interval: runs the updateQuizTimer function every 1 second
    const timerInterval = setInterval(updateQuizTimer, 1000);
/**
 * 
 */