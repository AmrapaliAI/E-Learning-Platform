<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Floating ChatBot</title>

<link rel="stylesheet" type="text/css" href="Chat.css">
</head>
<body>

<!-- Floating Chat Button -->
<button id="chat-btn">&#x1F916;</button>

<!-- Chatbox -->
<div id="chatbox">
    <div id="chat-header">
        AI ChatBot
        <span id="close-btn">&#10005;</span>
    </div>
    <div id="chat"></div>
    <div id="chat-input">
        <input id="q" placeholder="Type your message..." autocomplete="off" />
        <button id="send-btn">Send</button>
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
