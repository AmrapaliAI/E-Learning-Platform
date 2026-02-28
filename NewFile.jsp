<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Unified ChatBot</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
body {
  font-family: Arial, sans-serif;
  background: #f1f5f9;
  margin: 0;
}
/* Toggle Button */
.chat-toggle {
  position: fixed;
  bottom: 30px;
  right: 30px;
  width: 65px;
  height: 65px;
  border-radius: 50%;
  background: #2563eb;
  color: white;
  border: none;
  font-size: 26px;
  cursor: pointer;
  box-shadow: 0 4px 12px rgba(37, 99, 235, 0.4);
  transition: transform 0.2s;
}
.chat-toggle:hover {
  transform: scale(1.05);
}
/* Chat Container */
.chat-container {
  position: fixed;
  bottom: 110px;
  right: 30px;
  width: 380px;
  height: 520px;
  background: white;
  border-radius: 16px;
  box-shadow: 0 20px 50px rgba(0,0,0,.3);
  display: none;
  flex-direction: column;
}
/* Header */
.chat-header {
  background: #2563eb;
  color: white;
  padding: 15px;
  text-align: center;
  font-weight: bold;
  border-radius: 16px 16px 0 0;
}
/* Messages */
.chat-messages {
  flex: 1;
  padding: 15px;
  overflow-y: auto;
  background: #f8fafc;
}
.message {
  max-width: 80%;
  padding: 10px 14px;
  margin: 8px 0;
  border-radius: 14px;
  font-size: 14px;
  word-wrap: break-word;
  animation: fadeIn 0.3s;
}
@keyframes fadeIn {
  from { opacity: 0; transform: translateY(10px); }
  to { opacity: 1; transform: translateY(0); }
}
.user {
  background: #2563eb;
  color: white;
  margin-left: auto;
  border-bottom-right-radius: 4px;
}
.bot {
  background: white;
  border: 1px solid #e5e7eb;
  border-bottom-left-radius: 4px;
}
.error {
  background: #fee;
  border: 1px solid #fcc;
  color: #c33;
}
/* Input */
.chat-input {
  display: flex;
  padding: 12px;
  border-top: 1px solid #e5e7eb;
  background: white;
  border-radius: 0 0 16px 16px;
}
.chat-input input {
  flex: 1;
  padding: 10px;
  border-radius: 8px;
  border: 1px solid #cbd5e1;
  outline: none;
  font-size: 14px;
}
.chat-input input:focus {
  border-color: #2563eb;
}
.chat-input button {
  margin-left: 8px;
  padding: 10px 16px;
  background: #2563eb;
  color: white;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  font-weight: 500;
  transition: background 0.2s;
}
.chat-input button:hover {
  background: #1d4ed8;
}
.chat-input button:disabled {
  background: #94a3b8;
  cursor: not-allowed;
}
</style>
</head>
<body>
<button class="chat-toggle" onclick="toggleChat()">💬</button>
<div class="chat-container" id="chat">
  <div class="chat-header">🤖 Knowledge ChatBot</div>
  <div class="chat-messages" id="messages">
    <div class="message bot">
      👋 Ask me Programming or Math questions!
    </div>
  </div>
  <div class="chat-input">
    <input id="userInput" placeholder="Type here..." autocomplete="off">
    <button id="sendBtn" onclick="sendMessage()">Send</button>
  </div>
</div>
<script>
function toggleChat() {
  const chat = document.getElementById("chat");
  chat.style.display = chat.style.display === "flex" ? "none" : "flex";
  if (chat.style.display === "flex") {
    document.getElementById("userInput").focus();
  }
}

function addMessage(text, sender) {
  const messages = document.getElementById("messages");
  const div = document.createElement("div");
  div.className = "message " + sender;
  div.textContent = text;
  messages.appendChild(div);
  messages.scrollTop = messages.scrollHeight;
}

// Mock response function - simulates bot intelligence
function getBotResponse(userMessage) {
  const msg = userMessage.toLowerCase();
  
  // Programming responses
  if (msg.includes("python") || msg.includes("programming")) {
    return "Python is a versatile language! It's great for web development, data science, automation, and more. What specific topic would you like to explore?";
  }
  if (msg.includes("javascript") || msg.includes("js")) {
    return "JavaScript powers the web! It runs in browsers and on servers (Node.js). Need help with a specific concept?";
  }
  if (msg.includes("loop") || msg.includes("for loop")) {
    return "Loops let you repeat code. For example in Python: for i in range(5): print(i) - This prints 0 to 4.";
  }
  
  // Math responses
  if (msg.includes("math") || msg.includes("calculate")) {
    return "I can help with math! Try asking about algebra, calculus, geometry, or give me a calculation.";
  }
  if (msg.match(/\d+\s*[\+\-\*\/]\s*\d+/)) {
    try {
      const result = eval(msg.match(/[\d\+\-\*\/\(\)\s\.]+/)[0]);
      return `The answer is: ${result}`;
    } catch(e) {
      return "I couldn't calculate that. Try a simpler expression like 5 + 3";
    }
  }
  
  // Greetings
  if (msg.match(/^(hi|hello|hey)/)) {
    return "Hello! How can I help you with programming or math today?";
  }
  
  // Default
  return "I'm specialized in Programming and Math questions. Could you ask me something specific about coding or mathematics?";
}

async function sendMessage() {
  const input = document.getElementById("userInput");
  const sendBtn = document.getElementById("sendBtn");
  const userMessage = input.value.trim();
  
  if (!userMessage) return;
  
  // Disable input while processing
  input.disabled = true;
  sendBtn.disabled = true;
  
  // Add user message
  addMessage(userMessage, "user");
  input.value = "";
  
  // Simulate thinking delay
  setTimeout(() => {
    try {
      // For demo: using mock responses
      // To use real backend, replace this with your fetch call:
      // fetch("UnifiedChatServlet?message=" + encodeURIComponent(userMessage))
      
      const reply = getBotResponse(userMessage);
      addMessage(reply, "bot");
    } catch(error) {
      addMessage("⚠️ Sorry, something went wrong. Please try again.", "error");
    } finally {
      input.disabled = false;
      sendBtn.disabled = false;
      input.focus();
    }
  }, 500);
}

// Enter key support
document.getElementById("userInput").addEventListener("keypress", e => {
  if (e.key === "Enter" && !e.shiftKey) {
    e.preventDefault();
    sendMessage();
  }
});
</script>
</body>
</html>