document.addEventListener("DOMContentLoaded", () => {
  const chatToggleBtn = document.getElementById("chatToggleBtn");
  const chatCloseBtn  = document.getElementById("chatCloseBtn");
  const chatContainer = document.getElementById("chatContainer");
  const chatBox       = document.getElementById("chatBox");
  const userInput     = document.getElementById("userInput");
  const sendBtn       = document.getElementById("sendBtn");
  
  let score = 0;
  let total = 0;
  let currentQuestions = [];
  let currentQuestionIndex = 0;
  let totalQuestionsInQuiz = 0;

  function toggleChat() {
    chatContainer.style.display = chatContainer.style.display === "flex" ? "none" : "flex";
    if (chatBox.children.length === 0) {
      botMsg(" &#128075;Welcome to CertiQuiz!");
      botMsg("Type: 'java', '4 python', '5 dbms', etc.");
      botMsg(`Score: ${score}/${total}`);
    }
  }
  
  chatToggleBtn.onclick = toggleChat;
  chatCloseBtn.onclick  = toggleChat;

  function botMsg(text) {
    addMessage(text, "bot");
  }

  function addMessage(text, type) {
    const div = document.createElement("div");
    div.className = "message " + type;
    div.innerHTML = text.replace(/\n/g, "<br>");
    chatBox.appendChild(div);
    chatBox.scrollTop = chatBox.scrollHeight;
  }

  function showQuestion(q, questionNumber) {
    const div = document.createElement("div");
    div.className = "message bot";
    let html = `<strong>Question ${questionNumber}/${totalQuestionsInQuiz}</strong><br>`;
    html += `<strong>${q.text}</strong><br><br>`;
    q.options.forEach((op, i) => {
      html += `<button class="quiz-option" data-i="${i}">
                 ${String.fromCharCode(65 + i)}. ${op}
               </button><br>`;
    });
    div.innerHTML = html;
    chatBox.appendChild(div);
    chatBox.scrollTop = chatBox.scrollHeight;
    
    div.querySelectorAll(".quiz-option").forEach(btn => {
      btn.onclick = () => checkAnswer(btn, q, div);
    });
  }

  function checkAnswer(btn, q, questionDiv) {
    const selected = parseInt(btn.dataset.i);
    total++;
    
    // Disable all options
    questionDiv.querySelectorAll(".quiz-option").forEach(b => b.disabled = true);
    
    if (selected === q.correctIndex) {
      score++;
      btn.classList.add("correct-answer");
      botMsg("&#9989; Correct!");
    } else {
      btn.classList.add("wrong-answer");
      botMsg(`&#10060; Wrong! Correct answer: ${String.fromCharCode(65 + q.correctIndex)}`);
    }
    
    // Show next question or finish quiz
    currentQuestionIndex++;
    if (currentQuestionIndex < currentQuestions.length) {
      // Show next question from batch
      setTimeout(() => {
        showQuestion(currentQuestions[currentQuestionIndex], currentQuestionIndex + 1);
      }, 800);
    } else {
      // Quiz finished - show final results
      setTimeout(() => {
        showFinalResults();
      }, 1000);
    }
  }

  function showFinalResults() {
    const percentage = ((score / total) * 100).toFixed(1);
    botMsg("&#127919; Quiz Completed!");
    botMsg(`    &#128202; Final Score: ${score}/${total} (${percentage}%)`);
    
    // Performance message
    if (percentage >= 80) {
      botMsg("&#127775; Excellent! Keep it up!");
    } else if (percentage >= 60) {
      botMsg("&#128077; Good job! Keep practicing!");
    } else if (percentage >= 40) {
      botMsg("&#128218; Not bad! Review the topics again.");
    } else {
      botMsg("&#128170; Keep learning! Practice makes perfect!");
    }
    
    botMsg("Type a new topic to start another quiz!");
    
    // Reset for new quiz
    score = 0;
    total = 0;
    currentQuestions = [];
    currentQuestionIndex = 0;
    totalQuestionsInQuiz = 0;
  }

  function sendMessage() {
    const msg = userInput.value.trim();
    if (!msg) return;
    
    addMessage(msg, "user");
    userInput.value = "";
    sendBtn.disabled = true;

    // Reset score for new quiz
    score = 0;
    total = 0;
    currentQuestions = [];
    currentQuestionIndex = 0;

    fetch("ChatBotServlet", {
      method: "POST",
      headers: { "Content-Type": "application/x-www-form-urlencoded" },
      body: "message=" + encodeURIComponent(msg)
    })
    .then(res => res.json())
    .then(data => {
      if (data.type === "questions") {
        currentQuestions = data.data;
        totalQuestionsInQuiz = data.totalQuestions || currentQuestions.length;
        currentQuestionIndex = 0;
        
        if (currentQuestions.length > 0) {
          botMsg(`  &#128221;Starting quiz with ${currentQuestions.length} question(s)!`);
          showQuestion(currentQuestions[0], 1);
        }
      } else if (data.type === "text") {
        botMsg(data.message);
      }
    })
    .catch(err => {
      console.error(err);
      botMsg("&#10060; Server not reachable");
    })
    .finally(() => sendBtn.disabled = false);
  }

  sendBtn.onclick = sendMessage;
  userInput.addEventListener("keypress", e => { 
    if (e.key === "Enter") sendMessage(); 
  });
});