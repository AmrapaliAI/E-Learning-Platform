<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assessment Result</title>
<link rel="stylesheet" type="text/css" href="Chat.css">
<style>
    body {
        margin: 0;
        padding: 0;
        height: 100vh;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(
            rgba(0,0,0,0.65),
            rgba(0,0,0,0.65)
        ), url("data-sciences.jpg");
        background-size: cover;
        background-position: center;
        display: flex;
        justify-content: center;
        align-items: center;
        color: white;
    }

    .result-card {
        width: 650px;
        background: rgba(255, 255, 255, 0.12);
        backdrop-filter: blur(12px);
        border-radius: 25px;
        padding: 35px 45px;
        text-align: center;
        box-shadow: 0 25px 60px rgba(0,0,0,0.6);
        animation: fadeIn 1.2s ease;
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(30px); }
        to { opacity: 1; transform: translateY(0); }
    }

    .result-card h1 {
        color: #ff9800;
        font-size: 42px;
        margin-bottom: 10px;
        text-shadow: 2px 2px 6px black;
    }

    .result-card h2 {
        color: #ffcc80;
        font-weight: 500;
        margin-bottom: 30px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin: 25px 0;
        background: rgba(255,255,255,0.85);
        color: #1e293b;
        border-radius: 15px;
        overflow: hidden;
    }

    th {
        background: #2563eb;
        color: white;
        padding: 14px;
        font-size: 16px;
    }

    td {
        padding: 14px;
        font-size: 20px;
        font-weight: bold;
        color: #f97316;
        text-align: center;
    }

    .message {
        margin-top: 25px;
        font-size: 18px;
        color: #22c55e;
        font-style: italic;
    }

    .retry-btn {
        display: inline-block;
        margin-top: 25px;
        padding: 12px 28px;
        background: linear-gradient(135deg, #f97316, #ef4444);
        color: white;
        text-decoration: none;
        border-radius: 30px;
        font-size: 17px;
        font-weight: bold;
        transition: all 0.3s ease;
        box-shadow: 0 12px 25px rgba(0,0,0,0.4);
    }

    .retry-btn:hover {
        transform: translateY(-3px);
        box-shadow: 0 18px 35px rgba(0,0,0,0.6);
    }
</style>
</head>

<body>

<div class="result-card">
    <h1>&#x1F615;Try Again Later</h1>
    <h2>You haven't qualified the assessment</h2>

    <table>
        <tr>
            <th>Total Score</th>
            <th>Wrong Answers</th>
            <th>Not Attempted</th>
        </tr>
        <tr>
            <td><%= session.getAttribute("MarkGet") %></td>
            <td><%= session.getAttribute("Get") %></td>
            <td><%= session.getAttribute("Mark") %></td>
        </tr>
    </table>

    <div class="message">
        Please answer at least <b>30 questions</b> correctly to qualify.
    </div>

    <a href="test.jsp" class="retry-btn">  &#x1F501; Retry Assessment</a>
    
<p style="font-size:19px;opacity:0.8;Color:White;Border:2px Solid Blue;Height:100px; Width:400px;BackgrouNd-Color:Blue;">
Ask to JavaBot Examples: "Explain this question", "Give correct answer", "Help with JavaBot"
</p>
<button id="chat-btn">&#x1F916;</button>
    <div id="chatbox">
    <div id="chat-header">
        AI JavaBot
        <span id="close-btn">&#10005;</span>
    </div>
    <div id="chat"></div>
    <div id="chat-input">
        <input id="q" placeholder="Type your message..." autocomplete="off" />
        <button id="send-btn">Send</button>
    </div>
</div>
    
</div>
<script>
// Open / Close chat
const chatBtn = document.getElementById("chat-btn");
const chatBox = document.getElementById("chatbox");
const closeBtn = document.getElementById("close-btn");
chatBtn.onclick = () => chatBox.style.display = "flex";
closeBtn.onclick = () => chatBox.style.display = "none";

// Send message function
function send() {
    let question = document.getElementById("q").value.trim();
    if (!question) return;

    const chat = document.getElementById("chat");

    // Add user message
    const userMsg = document.createElement("div");
    userMsg.className = "message user";
    userMsg.innerText = question;
    chat.appendChild(userMsg);

    document.getElementById("q").value = "";
    chat.scrollTop = chat.scrollHeight;

    // Add bot typing placeholder
    const botMsg = document.createElement("div");
    botMsg.className = "message bot";
    botMsg.innerText = "Bot is thinking...";
    chat.appendChild(botMsg);
    chat.scrollTop = chat.scrollHeight;

    // Fetch response from your servlet
    fetch("ChattahC", {
        method: "POST",
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body: "question=" + encodeURIComponent(question)
    })
    .then(res => res.json())
    .then(data => {
        botMsg.innerText = data.answer;
        chat.scrollTop = chat.scrollHeight;
    })
    .catch(err => {
        botMsg.innerText = `Error: ${err.message}`;
        chat.scrollTop = chat.scrollHeight;
    });
}

// Send on Enter key
document.getElementById("q").addEventListener("keypress", function(e){
    if(e.key === "Enter") send();
});
document.getElementById("send-btn").addEventListener("click", send);
chatBtn.onclick = () => {
    chatBox.style.display = "flex";
    chatBox.style.width = "500px";
    chatBox.style.height = "70vh";
};

closeBtn.onclick = () => {
    chatBox.style.display = "none";
};

</script>
</body>
</html>
