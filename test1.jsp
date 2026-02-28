<%@ page import="java.util.List" %>
<%@ page import="User.Question" %>
<%@ page import="java.lang.Character" %>

<% 
    // 1. Retrieve the randomized quiz list from the session
    List<Question> quizQuestions = (List<Question>) session.getAttribute("currentQuizQuestions");
    
    // Safety check in case the session list is empty or missing
    if (quizQuestions == null || quizQuestions.isEmpty()) {
        // Handle case where quiz hasn't been started (e.g., redirect to start page)
        response.sendRedirect("index1.jsp"); 
        return;
    }
%>

<!DOCTYPE html>
<html>
<head><style>

        /* Simple styling for visibility */
        .time-display {
            font-size: 23px;
            font-weight: bold;
          
            Color:Orange;
        }
        #current-local-time {
            color: green;
        }
        #quiz-timer {
            color: red;font-size:21px;
        }
  
.U
{
	border:4px solid lightblue;
	width:840px;
	font-size:31px;
	margin-left:0px;
	background-color:lightBlue;

	border-color:orange;
	padding-left:67px;
	padding-top:78px;}
	B{
	font-size:19px;}body{background-image:url("data-sciences.jpg");}
	</style>
    <title>Quiz</title>
    <style>
        body { background-image: url('data-sciences.jpg'); }
        /* Add any specific styles for B tags or input */
    </style>
    <script>
        function toggleRadio(radio) {
            // Placeholder function for your custom JavaScript logic (if any)
            // For a basic quiz, this function might be empty or handle visual changes.
            console.log("Radio clicked: " + radio.name + ", Value: " + radio.value);
        }
    </script>
</head>
<body>

    <div id="quiz-timer">Time Remaining: 13:00</div>
    <hr/>
    
    <form class="U action" method="POST" action="QuizCheckServlet">
    
        <% 
            int questionNum = 1;
            // 2. Loop through every Question object in the randomized list
            for (Question q : quizQuestions) { 
        %>
            <h5>Q<%= questionNum %>:<%= q.getQuestionText() %></h5>
            
            <% 
                int optionIndex = 0;
                // 4. Loop through the List<String> of options
                for (String optionText : q.getOptions()) { 
                    // Calculate the option letter (A=65, B=66, etc.)
                    char optionLetter = (char)('A' + optionIndex);
            %>
                <B>
                    <input type="radio" 
                           name="Q<%= questionNum %>" 
                           value="<%= optionIndex %>" 
                           onclick="toggleRadio(this)">
                    
                    <%= optionLetter %>. <%= optionText %>
                </B>
                <BR><BR>
            <% 
                    optionIndex++;
                } 
            %>
        <% 
                questionNum++;
            } 
        %>
        
        <Center><input type="Submit" style="height:49px;width:100px;border:3px solid Blue;color:Green;font-size:21px;Border-radius:21px;"></Center>

    </form>
    
    <script src="time.js"></script><script>
let R=null;
function toggleRadio(currentRadio)
{
	if(currentRadio===R){
		currentRadio.checked=false;
		R=null;
	}
	else{
		R=currentRadio;
	}}</script>
</body>
</html>