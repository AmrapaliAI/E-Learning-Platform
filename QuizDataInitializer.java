package User;

import java.util.Arrays;
import java.util.List;

public class QuizDataInitializer {

    // ==========================================================
    //                 1. Course Constants (Defined at Class Level)
    // ==========================================================
    public static final String COURSE_JSP_SERVLET = "JSP Fundamentals";
    public static final String COURSE_DOTNET_CORE = ".NET Core";
    public static final String COURSE_PYTHON = "Python";
    public static final String COURSE_DBMS = "Database Management System";
    public static final String COURSE_INDIAN_CONSTITUTION = "Indian Constitution";
    public static final String COURSE_JAVA = "Core Java";
    public static final String COURSE_WEB_DEV = "HTML/CSS/JavaScript";
    public static final String COURSE_AI = "Artificial Intelligence";
    public static final String COURSE_AWS = "AWS Fundamentals";public static final String COURSE_AZURE = "Azure Fundamentals";



    public static void main(String[] args) {
        // Initialize DAO once
        QuestionDAO dao = new QuestionDAO();

        // ----------------------------------------------------------
        //             JSP/Servlet Course Questions (Q1 - Q60)
        // ----------------------------------------------------------
        System.out.println("Initializing JSP/Servlet Questions (Q1-Q60)...");
        
        // Q1
        Question q1 = new Question(
            "What is a JSP page compiled into before execution?",
            Arrays.asList("HTML", "CSS", "Servlet", "JSP"),
            2, // Correct Answer is "Servlet" (index 2)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q1);

        // Q2
        Question q2 = new Question(
            "Which JSP element is used to include the content of another file during the translation phase(Compile time)?",
            Arrays.asList("<@jsp:include page=\"..\"/>", "<%@include file=\"..\"%>", "<%@page import=\"..\" %>", "<%include file=\"..\" %>"),
            1, // Correct Answer is "<%@include file=\"..\"%>" (index 1)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q2);

        // Q3
        Question q3 = new Question(
            "What is the life cycle method of a JSP that is equivalent to the init()method in a Servlet?",
            Arrays.asList("jspInit()", "_jspService()", "jspDestroy()", "jspLoad()"),
            0, // Correct Answer is "jspInit()" (index 0)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q3);

        // Q4
        Question q4 = new Question(
            "Which implicit object in JSP is used to represent the current HTTP session for the user?",
            Arrays.asList("request", "response", "session", "application"),
            2, // Correct Answer is "session" (index 2)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q4);
        
        // Q5
        Question q5 = new Question(
            "What is the correct syntax for a JSP Expression, which is used to output a value directly to the response stream?",
            Arrays.asList("<%out.print(\"value\"); %>", "<%=expression %>", "<%!declaration %>", "None of the ABove"),
            1, // Correct Answer is "<%=expression %>" (index 1)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q5);
        
    
        Question q6 = new Question(
            "Which JSP element is compiled into a method within the generated Servlet and is used for writing Java code logic?",
            Arrays.asList("Declaration(<%!..%>)", "Expression(<%=.. %>)", "Directive(<%@.. %>)", "Scriptlet(<%..%>)"),
            3, // Correct Answer is "Scriptlet(<%..%>)" (index 3)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q6);

        // Q7
        Question q7 = new Question(
            "Which Scope is used to Share data Across all users and all requests within a single web application?",
            Arrays.asList("page scope", "request scope", "session scope", "application scope"),
            3, // Correct Answer is "application scope" (index 3)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q7);

        // Q8
        Question q8 = new Question(
            "What is the purpose of the isErrorPage=\"true\" attribute in the JSP page directive?",
            Arrays.asList(
                "To redirect the user to a login page if an error occurs",
                "To specify that this page will handle and display errors from other JSP", 
                "To force the server to restart if an exception is thrown", 
                "To disable all exception handling on the current page"
            ),
            1, // Correct Answer is "To Specify that this page will handle and display errors from other JSP" (index 1)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q8);

        // Q9
        Question q9 = new Question(
            "Which implicit object in JSP is used to write content to the client's browser?",
            Arrays.asList("config", "pageContext", "out", "page"),
            2, // Correct Answer is "out" (index 2)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q9);
        
        // Q10
        Question q10 = new Question(
            "Which JSP implicit object provides access to all other implicit objects and is often used by tag handlers and expression language?",
            Arrays.asList("config", "page", "pageContext", "exception"),
            2, // Correct Answer is "pageContext" (index 2)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q10);
        
        // Q11
        Question q11 = new Question(
            "Which life cycle method is called exactly once when a Servlet is first loaded?",
            Arrays.asList(
                "service()",
                "doGet()",
                "init()",
                "destroy()"
            ),
            2, // Correct Answer is "init()" (index 2)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q11);

        // Q12
        Question q12 = new Question(
            "Which method is responsible for handling all client requests to a Servlet?",
            Arrays.asList(
                "service()",
                "doPost()",
                "doGet()",
                "handleRequest()"
            ),
            0, // Correct Answer is "service()" (index 0)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q12);

        // Q13
        Question q13 = new Question(
            "What is the default scope for an object created inside a JSP Scriptlet without explicit declaration?",
            Arrays.asList(
                "request scope",
                "session scope",
                "page scope",
                "application scope"
            ),
            2, // Correct Answer is "page scope" (index 2)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q13);

        // Q14
        Question q14 = new Question(
            "Which file is used to map a Servlet name to a URL pattern in older Java EE applications (pre-Servlet 3.0)?",
            Arrays.asList(
                "servlet-config.xml",
                "web.properties",
                "context.xml",
                "web.xml"
            ),
            3, // Correct Answer is "web.xml" (index 3)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q14);

        // Q15
        Question q15 = new Question(
            "Which implicit object in JSP allows one to get or set initialization parameters for the Servlet?",
            Arrays.asList(
                "config",
                "application",
                "page",
                "pageContext"
            ),
            0, // Correct Answer is "config" (index 0)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q15);

        // Q16
        Question q16 = new Question(
            "What is the output of the JSP expression <%= 2 + 2 * 3 %>?",
            Arrays.asList(
                "8",
                "10",
                "2 + 2 * 3",
                "5"
            ),
            0, // Correct Answer is "8" (index 0)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q16);

        // Q17
        Question q17 = new Question(
            "Which interface must a class implement to intercept and modify requests before they reach the Servlet?",
            Arrays.asList(
                "HttpSessionListener",
                "ServletConfig",
                "Filter",
                "GenericServlet"
            ),
            2, // Correct Answer is "Filter" (index 2)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q17);

        // Q18
        Question q18 = new Question(
            "What is the difference between `<jsp:forward>` and `response.sendRedirect()`?",
            Arrays.asList(
                "Forward uses the browser, Redirect uses the server",
                "Forward is an internal server action, Redirect is a new client request",
                "Forward allows cross-context communication, Redirect does not",
                "They are functionally identical"
            ),
            1, // Correct Answer is "Forward is an internal server action, Redirect is a new client request" (index 1)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q18);

        // Q19
        Question q19 = new Question(
            "Which JSP directive is used to import Java classes for use in scriptlets and declarations?",
            Arrays.asList(
                "<%@ include file=\"...\" %>",
                "<%@ taglib prefix=\"...\" %>",
                "<%@ page import=\"...\" %>",
                "<%@ page session=\"...\" %>"
            ),
            2, // Correct Answer is "<%@ page import=\"...\" %>" (index 2)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q19);

        // Q20
        Question q20 = new Question(
            "The Servlet container terminates a Servlet by calling which method?",
            Arrays.asList(
                "service()",
                "close()",
                "destroy()",
                "finalize()"
            ),
            2, // Correct Answer is "destroy()" (index 2)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q20);

        // Q21: JSTL
        Question q21 = new Question(
            "Which JSTL tag is used to iterate over a collection like a List or Array?",
            Arrays.asList(
                "<c:if>",
                "<c:set>",
                "<c:out>",
                "<c:forEach>"
            ),
            3, // Correct Answer is "<c:forEach>" (index 3)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q21);

        // Q22: Servlets
        Question q22 = new Question(
            "The HttpServletRequest method used to retrieve an attribute stored by a Controller is:",
            Arrays.asList(
                "getAttribute()",
                "getParameter()",
                "getHeaders()",
                "getSession()"
            ),
            0, // Correct Answer is "getAttribute()" (index 0)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q22);

        // Q23: JSP Directives
        Question q23 = new Question(
            "What is the function of the `<%@ taglib prefix=\"c\" uri=\"...\" %>` directive?",
            Arrays.asList(
                "To define a new JSP tag",
                "To include a standard tag library (like JSTL) for use on the page",
                "To declare a Java class",
                "To set the page encoding"
            ),
            1, // Correct Answer is "To include a standard tag library..." (index 1)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q23);

        // Q24: Session Management
        Question q24 = new Question(
            "Which HTTP status code is typically returned by `response.sendRedirect(url)`?",
            Arrays.asList(
                "200 (OK)",
                "404 (Not Found)",
                "302 (Found/Redirect)",
                "500 (Internal Error)"
            ),
            2, // Correct Answer is "302 (Found/Redirect)" (index 2)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q24);

        // Q25: Scope Access
        Question q25 = new Question(
            "When a user logs out, which two scopes are typically invalidated or destroyed?",
            Arrays.asList(
                "page and request",
                "session and application",
                "request and session",
                "page and application"
            ),
            2, // Correct Answer is "request and session" (index 2)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q25);

        // Q26: EL
        Question q26 = new Question(
            "What is the purpose of Expression Language (EL) in JSPs (e.g., `${user.name}`)?",
            Arrays.asList(
                "To write complex business logic",
                "To access scoped variables and object properties without using scriptlets",
                "To handle database connections",
                "To define HTML styles"
            ),
            1, // Correct Answer is "To access scoped variables and object properties..." (index 1)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q26);

        // Q27: Context Initialization
        Question q27 = new Question(
            "Which listener interface is used to execute code when the entire web application starts up?",
            Arrays.asList(
                "HttpSessionListener",
                "ServletContextListener",
                "ServletRequestListener",
                "Filter"
            ),
            1, // Correct Answer is "ServletContextListener" (index 1)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q27);

        // Q28: Servlet Configuration
        Question q28 = new Question(
            "What is the annotation used to configure the URL mapping of a Servlet in modern Java EE/Jakarta EE?",
            Arrays.asList(
                "@ServletConfig",
                "@WebServlet",
                "@ContextPath",
                "@URLMapping"
            ),
            1, // Correct Answer is "@WebServlet" (index 1)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q28);

        // Q29: Filters
        Question q29 = new Question(
            "In a Servlet Filter, which method allows the request to continue down the chain to the target resource?",
            Arrays.asList(
                "process()",
                "doFilter()",
                "chain.doFilter()",
                "passRequest()"
            ),
            2, // Correct Answer is "chain.doFilter()" (index 2)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q29);

        // Q30: Security/Authentication
        Question q30 = new Question(
            "Which component is primarily responsible for the user authentication and authorization logic in a Java Web App?",
            Arrays.asList(
                "JSP View",
                "HTML Form",
                "Database",
                "Servlet/Controller"
            ),
            3, // Correct Answer is "Servlet/Controller" (index 3)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q30);

        // Q31: JSP Includes
        Question q31 = new Question(
            "What is the difference between `<%@ include file=\"...\" %>` and `<jsp:include page=\"...\" />`?",
            Arrays.asList(
                "The first is dynamic (runtime), the second is static (compile time)",
                "The first is static (compile time), the second is dynamic (runtime)",
                "They are functionally identical, just different syntax",
                "Only the first one can pass parameters"
            ),
            1, // Correct Answer is "The first is static (compile time), the second is dynamic (runtime)" (index 1)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q31);

        // Q32: Request Parameters
        Question q32 = new Question(
            "How does a Servlet retrieve data submitted via an HTML form's GET or POST method?",
            Arrays.asList(
                "request.getAttribute()",
                "request.getParameter()",
                "request.getSession()",
                "request.getFormValue()"
            ),
            1, // Correct Answer is "request.getParameter()" (index 1)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q32);

        // Q33: Scopes Duration
        Question q33 = new Question(
            "Which scope object has the shortest life span?",
            Arrays.asList(
                "application",
                "session",
                "page",
                "request"
            ),
            2, // Correct Answer is "page" (index 2)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q33);

        // Q34: Servlet Thread Safety
        Question q34 = new Question(
            "Servlets are inherently multithreaded. Which component must NOT be used as an instance variable in a Servlet to maintain thread safety?",
            Arrays.asList(
                "QuestionDAO (or other stateless DAO)",
                "ServletConfig",
                "A counter variable or other mutable state",
                "ServletContext"
            ),
            2, // Correct Answer is "A counter variable or other mutable state" (index 2)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q34);

        // Q35: Response Handling
        Question q35 = new Question(
            "The implicit object used in JSPs to set HTTP response headers (like content type) is:",
            Arrays.asList(
                "request",
                "out",
                "response",
                "session"
            ),
            2, // Correct Answer is "response" (index 2)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q35);

        // Q36: JSTL Conditional
        Question q36 = new Question(
            "Which JSTL tag is equivalent to the Java `if` statement?",
            Arrays.asList(
                "<c:set>",
                "<c:when>",
                "<c:choose>",
                "<c:if>"
            ),
            3, // Correct Answer is "<c:if>" (index 3)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q36);

        // Q37: Servlet Life Cycle
        Question q37 = new Question(
            "When a Servlet is being shut down or undeployed, which method is guaranteed to be called?",
            Arrays.asList(
                "shutdown()",
                "destroy()",
                "doClose()",
                "service()"
            ),
            1, // Correct Answer is "destroy()" (index 1)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q37);

        // Q38: Application Context
        Question q38 = new Question(
            "Which object represents the entire web application and provides context-wide initialization parameters?",
            Arrays.asList(
                "HttpServletRequest",
                "ServletContext",
                "HttpSession",
                "ServletConfig"
            ),
            1, // Correct Answer is "ServletContext" (index 1)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q38);

        // Q39: EL Operators
        Question q39 = new Question(
            "In Expression Language (EL), what is the safe access operator used to prevent `NullPointerException` if a property is null?",
            Arrays.asList(
                "?. (Safe Navigation Operator)",
                ":? (Ternary Operator)",
                "!! (Double Bang)",
                "!! (Double Bang)"
            ),
            0, // Correct Answer is "?. (Safe Navigation Operator)" (index 0)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q39);

        // Q40: Form Submission Default
        Question q40 = new Question(
            "If an HTML form uses `<form action=\"...\" method=\"...\">` without specifying the method, which HTTP method is used by default?",
            Arrays.asList(
                "POST",
                "PUT",
                "GET",
                "HEAD"
            ),
            2, // Correct Answer is "GET" (index 2)
            COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q40);

        // Q41: Cookies
        Question q41 = new Question(
           "How does a Servlet send a new Cookie to the client's browser?",
           Arrays.asList(
               "request.setCookie()",
               "response.addCookie()",
               "session.createCookie()",
               "cookie.save()"
           ),
           1, // Correct Answer is "response.addCookie()" (index 1)
           COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q41);

        // Q42: Error Handling
        Question q42 = new Question(
           "Which JSP implicit object is available only when the page is declared as an error page?",
           Arrays.asList(
               "config",
               "exception",
               "pageContext",
               "request"
           ),
           1, // Correct Answer is "exception" (index 1)
           COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q42);

        // Q43: Dispatching
        Question q43 = new Question(
           "The Servlet method used to transfer the request and response objects to another resource (like a JSP) within the same application is:",
           Arrays.asList(
               "response.sendRedirect()",
               "request.forward()",
               "dispatcher.include()",
               "dispatcher.forward()"
           ),
           3, // Correct Answer is "dispatcher.forward()" (index 3)
           COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q43);

        // Q44: Servlet Mapping
        Question q44 = new Question(
           "In web.xml, what XML element is used to associate a URL pattern with a Servlet name?",
           Arrays.asList(
               "<servlet-name>",
               "<url-mapping>",
               "<servlet-mapping>",
               "<context-param>"
           ),
           2, // Correct Answer is "<servlet-mapping>" (index 2)
           COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q44);

        // Q45: JSTL Output
        Question q45 = new Question(
           "What is the function of the JSTL `<c:out value=\"...\" />` tag?",
           Arrays.asList(
               "To define a new variable in a specific scope",
               "To conditionally execute a block of code",
               "To securely display data from a variable, often escaping HTML characters",
               "To iterate over an array"
           ),
           2, // Correct Answer is "To securely display data..." (index 2)
           COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q45);

        // Q46: Servlet Hierarchy
        Question q46 = new Question(
           "Which abstract class is the direct superclass of HttpServlet and provides basic Servlet methods?",
           Arrays.asList(
               "GenericServlet",
               "ServletBase",
               "AbstractServlet",
               "ServletConfig"
           ),
           0, // Correct Answer is "GenericServlet" (index 0)
           COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q46);

        // Q47: Listener Scope
        Question q47 = new Question(
           "Which listener tracks when an object is bound to or unbound from the HTTP session?",
           Arrays.asList(
               "HttpSessionListener",
               "HttpSessionAttributeListener",
               "ServletContextListener",
               "ServletRequestListener"
           ),
           1, // Correct Answer is "HttpSessionAttributeListener" (index 1)
           COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q47);

        // Q48: URL Rewriting
        Question q48 = new Question(
           "What session tracking mechanism is primarily used when the client has disabled cookies?",
           Arrays.asList(
               "Hidden Form Fields",
               "HTTP Headers",
               "URL Rewriting",
               "IP Address Tracking"
           ),
           2, // Correct Answer is "URL Rewriting" (index 2)
           COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q48);

        // Q49: JSP Scopes
        Question q49 = new Question(
           "Which scope persists data for the life of the web application until the server is shut down?",
           Arrays.asList(
               "request",
               "session",
               "application",
               "page"
           ),
           2, // Correct Answer is "application" (index 2)
           COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q49);

        // Q50: Request Parameters
        Question q50 = new Question(
           "When a user selects multiple options from a checkbox group, how does the Servlet retrieve all values?",
           Arrays.asList(
               "request.getParameter()",
               "request.getAttribute()",
               "request.getParameterValues()",
               "request.getCheckboxValues()"
           ),
           2, // Correct Answer is "request.getParameterValues()" (index 2)
           COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q50);

        // Q51: Filter Configuration
        Question q51 = new Question(
           "Which XML element in web.xml is used to define a Filter?",
           Arrays.asList(
               "<filter-mapping>",
               "<filter>",
               "<listener>",
               "<servlet>"
           ),
           1, // Correct Answer is "<filter>" (index 1)
           COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q51);

        // Q52: JSP Action Tag
        Question q52 = new Question(
           "Which JSP action tag is used to instantiate a JavaBean and make it available in a specific scope?",
           Arrays.asList(
               "<jsp:useBean>",
               "<jsp:setProperty>",
               "<jsp:forward>",
               "<jsp:param>"
           ),
           0, // Correct Answer is "<jsp:useBean>" (index 0)
           COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q52);

        // Q53: Error Code
        Question q53 = new Question(
           "The default HTTP status code for a resource that requires authentication is:",
           Arrays.asList(
               "403 (Forbidden)",
               "401 (Unauthorized)",
               "400 (Bad Request)",
               "408 (Request Timeout)"
           ),
           1, // Correct Answer is "401 (Unauthorized)" (index 1)
           COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q53);

        // Q54: JSTL Variable
        Question q54 = new Question(
           "Which JSTL tag is used to create and set a variable in a specified scope?",
           Arrays.asList(
               "<c:declare>",
               "<c:define>",
               "<c:set>",
               "<c:var>"
           ),
           2, // Correct Answer is "<c:set>" (index 2)
           COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q54);

        // Q55: Filter Life Cycle
        Question q55 = new Question(
           "Which method of the Filter interface is called once to initialize the Filter?",
           Arrays.asList(
               "init()",
               "setup()",
               "doStart()",
               "create()"
           ),
           0, // Correct Answer is "init()" (index 0)
           COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q55);

        // Q56: Forward vs Redirect
        Question q56 = new Question(
           "When using `RequestDispatcher.forward()`, the URL in the browser address bar:",
           Arrays.asList(
               "Changes to the target resource's URL",
               "Remains unchanged",
               "Shows a 302 redirect error",
               "Shows the context root path"
           ),
           1, // Correct Answer is "Remains unchanged" (index 1)
           COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q56);

        // Q57: EL Operators
        Question q57 = new Question(
           "What is the Expression Language (EL) equivalent of the logical AND operator (&&)?",
           Arrays.asList(
               "&",
               "and",
               "&&",
               "is and"
           ),
           1, // Correct Answer is "and" (index 1)
           COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q57);

        // Q58: Session Invalidation
        Question q58 = new Question(
           "How can a Servlet explicitly terminate an HTTP session?",
           Arrays.asList(
               "session.close()",
               "session.end()",
               "session.invalidate()",
               "response.endSession()"
           ),
           2, // Correct Answer is "session.invalidate()" (index 2)
           COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q58);

        // Q59: Character Encoding
        Question q59 = new Question(
           "To prevent garbled characters when processing form data, the Servlet should set the request's character encoding using:",
           Arrays.asList(
               "request.setEncoding()",
               "request.setCharacterEncoding()",
               "response.setEncoding()",
               "request.setCharset()"
           ),
           1, // Correct Answer is "request.setCharacterEncoding()" (index 1)
           COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q59);

        // Q60: Init Params
        Question q60 = new Question(
           "Which configuration parameter is specific to a single Servlet instance and not shared across the entire application?",
           Arrays.asList(
               "Context Parameter",
               "Filter Parameter",
               "Init Parameter",
               "Application Parameter"
           ),
           2, // Correct Answer is "Init Parameter" (index 2)
           COURSE_JSP_SERVLET
        );
        dao.saveQuestion(q60);Question q61 = new Question(
        	    "Which method in HttpServlet is called to handle GET requests?",
        	    Arrays.asList("doPost()", "doGet()", "service()", "init()"),
        	    1, // Correct: doGet()
        	    COURSE_JSP_SERVLET
        	);
        	dao.saveQuestion(q61);

        	Question q62 = new Question(
        	    "Which method is called only once when a servlet is first loaded?",
        	    Arrays.asList("init()", "service()", "doGet()", "destroy()"),
        	    0, // Correct: init()
        	    COURSE_JSP_SERVLET
        	);
        	dao.saveQuestion(q62);

        	Question q63 = new Question(
        	    "Which implicit object in JSP represents the client request?",
        	    Arrays.asList("response", "request", "session", "application"),
        	    1, // Correct: request
        	    COURSE_JSP_SERVLET
        	);
        	dao.saveQuestion(q63);

        	Question q64 = new Question(
        	    "Which JSP directive is used to include reusable code?",
        	    Arrays.asList("include", "page", "taglib", "import"),
        	    0, // Correct: include
        	    COURSE_JSP_SERVLET
        	);
        	dao.saveQuestion(q64);

        	Question q65 = new Question(
        	    "Which method in HttpServlet is called to handle POST requests?",
        	    Arrays.asList("doPost()", "doGet()", "service()", "init()"),
        	    0, // Correct: doPost()
        	    COURSE_JSP_SERVLET
        	);
        	dao.saveQuestion(q65);

        	Question q66 = new Question(
        	    "Which JSP implicit object is used to send output to the client?",
        	    Arrays.asList("request", "response", "out", "session"),
        	    2, // Correct: out
        	    COURSE_JSP_SERVLET
        	);
        	dao.saveQuestion(q66);

        	Question q67 = new Question(
        	    "Which lifecycle method is called before a servlet is removed from service?",
        	    Arrays.asList("init()", "service()", "destroy()", "finalize()"),
        	    2, // Correct: destroy()
        	    COURSE_JSP_SERVLET
        	);
        	dao.saveQuestion(q67);

        	Question q68 = new Question(
        	    "Which JSP directive is used to define page-level settings?",
        	    Arrays.asList("page", "include", "taglib", "import"),
        	    0, // Correct: page
        	    COURSE_JSP_SERVLET
        	);
        	dao.saveQuestion(q68);

        	Question q69 = new Question(
        	    "Which object in JSP represents the servlet context?",
        	    Arrays.asList("application", "session", "request", "config"),
        	    0, // Correct: application
        	    COURSE_JSP_SERVLET
        	);
        	dao.saveQuestion(q69);

        	Question q70 = new Question(
        	    "Which JSP directive is used to declare a tag library?",
        	    Arrays.asList("page", "include", "taglib", "import"),
        	    2, // Correct: taglib
        	    COURSE_JSP_SERVLET
        	);
        	dao.saveQuestion(q70);
        	Question q71 = new Question(
        		    "The method _________ in HttpServlet is used to handle GET requests.",
        		    Arrays.asList("doGet", "doPost", "service", "init"),
        		    0,
        		    COURSE_JSP_SERVLET
        		);
        		dao.saveQuestion(q71);

        		Question q72 = new Question(
        		    "The method _________ in HttpServlet is used to handle POST requests.",
        		    Arrays.asList("doPost", "doGet", "service", "destroy"),
        		    0,
        		    COURSE_JSP_SERVLET
        		);
        		dao.saveQuestion(q72);

        		Question q73 = new Question(
        		    "The method _________ is called only once when a servlet is first loaded.",
        		    Arrays.asList("init", "doGet", "doPost", "service"),
        		    0,
        		    COURSE_JSP_SERVLET
        		);
        		dao.saveQuestion(q73);

        		Question q74 = new Question(
        		    "The method _________ is called before a servlet is removed from service.",
        		    Arrays.asList("destroy", "init", "doGet", "doPost"),
        		    0,
        		    COURSE_JSP_SERVLET
        		);
        		dao.saveQuestion(q74);

        		Question q75 = new Question(
        		    "The JSP implicit object _________ is used to send output to the client.",
        		    Arrays.asList("out", "request", "response", "session"),
        		    0,
        		    COURSE_JSP_SERVLET
        		);
        		dao.saveQuestion(q75);

        		Question q76 = new Question(
        		    "The JSP implicit object _________ represents the client request.",
        		    Arrays.asList("request", "response", "out", "application"),
        		    0,
        		    COURSE_JSP_SERVLET
        		);
        		dao.saveQuestion(q76);

        		Question q77 = new Question(
        		    "The JSP implicit object _________ represents the servlet context.",
        		    Arrays.asList("application", "session", "config", "request"),
        		    0,
        		    COURSE_JSP_SERVLET
        		);
        		dao.saveQuestion(q77);

        		Question q78 = new Question(
        		    "The JSP directive _________ is used to include reusable code.",
        		    Arrays.asList("include", "page", "taglib", "import"),
        		    0,
        		    COURSE_JSP_SERVLET
        		);
        		dao.saveQuestion(q78);

        		Question q79 = new Question(
        		    "The JSP directive _________ is used to define page-level settings.",
        		    Arrays.asList("page", "include", "taglib", "config"),
        		    0,
        		    COURSE_JSP_SERVLET
        		);
        		dao.saveQuestion(q79);

        		Question q80 = new Question(
        		    "The JSP directive _________ is used to declare a tag library.",
        		    Arrays.asList("taglib", "page", "include", "library"),
        		    0,
        		    COURSE_JSP_SERVLET
        		);
        		dao.saveQuestion(q80);



        // ----------------------------------------------------------
        //             .NET Core Course Questions (Example)
        // ----------------------------------------------------------
        System.out.println("Initializing .NET Core Questions...");

        
                // --- C# FUNDAMENTALS (QDN1 - QDN40) ---

                // QDN1 (Original Q1): Value Type
                Question qDN1 = new Question(
                    "Which of the following is a value type in C#?",
                    Arrays.asList("String", "Int", "Object", "Array"),
                    1, // Correct: Int
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN1);

                // QDN2 (Original Q2): Interface Keyword
                Question qDN2 = new Question(
                    "What keyword is used to define an interface in C#?",
                    Arrays.asList("class", "interface", "abstract", "delegate"),
                    1, // Correct: interface
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN2);

                // QDN3 (Original Q3): Public Access Specifier
                Question qDN3 = new Question(
                    "Which access specifier makes a member accessible everywhere?",
                    Arrays.asList("Private", "Protected", "Internal", "Public"),
                    3, // Correct: Public
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN3);

                // QDN4 (Original Q4): Cannot Be Inherited
                Question qDN4 = new Question(
                    "Which of the following cannot be inherited?",
                    Arrays.asList("Abstract", "Sealed", "Concrete", "Interface"),
                    1, // Correct: Sealed
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN4);

                // QDN5 (Original Q5): Delegate Returning Boolean
                Question qDN5 = new Question(
                    "Which delegate type always returns a boolean?",
                    Arrays.asList("Func", "Action", "Predicate", "MultiCast"),
                    2, // Correct: Predicate
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN5);

                // QDN6 (Original Q6): Prevent Inheritance Keyword
                Question qDN6 = new Question(
                    "Which keyword is used to prevent a class from being inherited?",
                    Arrays.asList("sealed", "abstract", "static", "readonly"),
                    0, // Correct: sealed
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN6);

                // QDN7 (Original Q7): NOT a Value Type
                Question qDN7 = new Question(
                    "Which of the following is NOT a value type?",
                    Arrays.asList("Int", "Double", "String", "Char"),
                    2, // Correct: String
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN7);

                // QDN8 (Original Q8): Delegate Not Returning Value
                Question qDN8 = new Question(
                    "Which built-in delegate type does not return a value?",
                    Arrays.asList("Func", "Action", "Predicate", "Thread"),
                    1, // Correct: Action
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN8);

                // QDN9 (Original Q9): Define Interface Keyword
                Question qDN9 = new Question(
                    "Which keyword is used to define an interface?",
                    Arrays.asList("class", "interface", "abstract", "delegate"),
                    1, // Correct: interface
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN9);

                // QDN10 (Original Q10): Threads True Statement
                Question qDN10 = new Question(
                    "Which of the following is true about threads?",
                    Arrays.asList("They run sequentially only", "They allow concurrent execution", "They cannot be created", "They are same as tasks"),
                    1, // Correct: They allow concurrent execution
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN10);

                // QDN11 (Original Q11): Higher-level Abstraction
                Question qDN11 = new Question(
                    "Which of the following is a higher-level abstraction built on threads?",
                    Arrays.asList("Task", "Thread", "Delegate", "Interface"),
                    0, // Correct: Task
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN11);

                // QDN12 (Original Q12): Querying Collections
                Question qDN12 = new Question(
                    "Which of the following is used for querying collections in C#?",
                    Arrays.asList("LINQ", "Thread", "Delegate", "Task"),
                    0, // Correct: LINQ
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN12);

                // QDN13 (Original Q13): Access in Derived Classes Only
                Question qDN13 = new Question(
                    "Which access specifier allows access in derived classes only?",
                    Arrays.asList("Public", "Private", "Protected", "Internal"),
                    2, // Correct: Protected
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN13);
                
                // QDN14 (Original Q14): Sealed Class Keyword
                Question qDN14 = new Question(
                    "Which keyword is used to define a sealed class?",
                    Arrays.asList("sealed", "abstract", "static", "readonly"),
                    0, // Correct: sealed
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN14);

                // QDN15 (Original Q15): Static Class Property
                Question qDN15 = new Question(
                    "Which of the following is a static class property?",
                    Arrays.asList("Can be inherited", "Cannot be instantiated", "Can contain instance members", "Must be abstract"),
                    1, // Correct: Cannot be instantiated
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN15);

                // QDN16 (Original Q16): Reference Type
                Question qDN16 = new Question(
                    "Which of the following is a reference type?",
                    Arrays.asList("Int", "String", "Double", "Char"),
                    1, // Correct: String
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN16);

                // QDN17 (Original Q17): Static Class Keyword
                Question qDN17 = new Question(
                    "Which keyword is used to define a static class?",
                    Arrays.asList("sealed", "abstract", "static", "readonly"),
                    2, // Correct: static
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN17);

                // QDN18 (Original Q18): Abstract Class True Statement
                Question qDN18 = new Question(
                    "Which of the following is true about abstract classes?",
                    Arrays.asList("Cannot be inherited", "Cannot be instantiated", "Must contain only static methods", "Always sealed"),
                    1, // Correct: Cannot be instantiated
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN18);

                // QDN19 (Original Q19): Access within Same Class Only
                Question qDN19 = new Question(
                    "Which access specifier allows access only within the same class?",
                    Arrays.asList("Public", "Private", "Protected", "Internal"),
                    1, // Correct: Private
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN19);

                // QDN20 (Original Q20): Delegates True Statement
                Question qDN20 = new Question(
                    "Which of the following is true about delegates?",
                    Arrays.asList("Can reference methods with specific signature", "Cannot be used for events", "Always abstract", "Stores data only"),
                    0, // Correct: Can reference methods with specific signature
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN20);

                // QDN21 (Original Q21): Delegate Calling Multiple Methods
                Question qDN21 = new Question(
                    "Which delegate type can call multiple methods?",
                    Arrays.asList("Single-cast", "Multi-cast", "Func", "Action"),
                    1, // Correct: Multi-cast
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN21);

                // QDN22 (Original Q22): Delegate Returning Any Type
                Question qDN22 = new Question(
                    "Which built-in delegate type can return any type?",
                    Arrays.asList("Func", "Action", "Predicate", "Thread"),
                    0, // Correct: Func
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN22);

                // QDN23 (Original Q23): LINQ True Statement
                Question qDN23 = new Question(
                    "Which of the following is true about LINQ?",
                    Arrays.asList("Used for threads", "Used for querying collections", "Used for delegates", "Used for access specifiers"),
                    1, // Correct: Used for querying collections
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN23);

                // QDN24 (Original Q24): Define Delegate Keyword
                Question qDN24 = new Question(
                    "Which keyword is used to define a delegate?",
                    Arrays.asList("delegate", "class", "interface", "abstract"),
                    0, // Correct: delegate
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN24);

                // QDN25 (Original Q25): Tasks True Statement
                Question qDN25 = new Question(
                    "Which of the following is true about tasks?",
                    Arrays.asList("Lower-level than threads", "Higher-level abstraction built on threads", "Same as thread", "Cannot run asynchronously"),
                    1, // Correct: Higher-level abstraction built on threads
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN25);

                // QDN26 (Original Q26): Value Type
                Question qDN26 = new Question(
                    "Which of the following is a value type?",
                    Arrays.asList("Int", "String", "Object", "Array"),
                    0, // Correct: Int
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN26);

                // QDN27 (Original Q27): Sealed Class True Statement
                Question qDN27 = new Question(
                    "Which of the following is true about sealed classes?",
                    Arrays.asList("Cannot be inherited", "Must be abstract", "Can be instantiated", "Only static"),
                    0, // Correct: Cannot be inherited
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN27);

                // QDN28 (Original Q28): Static Class True Statement
                Question qDN28 = new Question(
                    "Which of the following is true about static classes?",
                    Arrays.asList("Cannot be instantiated", "Can be inherited", "Can contain instance members", "Must be abstract"),
                    0, // Correct: Cannot be instantiated
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN28);

                // QDN29 (Original Q29): Interfaces True Statement
                Question qDN29 = new Question(
                    "Which of the following is true about interfaces?",
                    Arrays.asList("Can contain implementation", "Can only contain method signatures", "Cannot be inherited", "Must be sealed"),
                    1, // Correct: Can only contain method signatures
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN29);

                // QDN30 (Original Q30): Correct Built-in Delegate Types
                Question qDN30 = new Question(
                    "Which of the following is a correct built-in delegate type?",
                    Arrays.asList("Func", "Action", "Predicate", "All of the above"),
                    3, // Correct: All of the above
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN30);

                // QDN31 (Original Q31): Access within Same Assembly Only
                Question qDN31 = new Question(
                    "Which access specifier allows access within the same assembly only?",
                    Arrays.asList("Public", "Internal", "Private", "Protected"),
                    1, // Correct: Internal
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN31);

                // QDN32 (Original Q32): Purpose of Thread Join()
                Question qDN32 = new Question(
                    "Which of the following is the primary purpose of calling the Join() method on a C# thread instance?",
                    Arrays.asList("to Block the calling thread until the thread on which Join() is called has finished its execution.", "to immediately terminate the execution of the thread.", "to pause the currently executing thread for a specified amount of time.", "to prevent the garbage collector from collecting the thread object."),
                    0, // Correct: to Block the calling thread...
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN32);
                
                // QDN33 (Original Q33): Tasks True Statement
                Question qDN33 = new Question(
                    "Which of the following is true about tasks?",
                    Arrays.asList("Higher-level abstraction built on threads", "Lower-level than threads", "Same as thread", "Cannot run asynchronously"),
                    0, // Correct: Higher-level abstraction built on threads
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN33);

                // QDN34 (Original Q34): Correct LINQ Query Keyword
                Question qDN34 = new Question(
                    "Which of the following is a correct LINQ query keyword?",
                    Arrays.asList("select", "insert", "update", "delete"),
                    0, // Correct: select
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN34);

                // QDN35 (Original Q35): Windows Forms in .NET Core
                Question qDN35 = new Question(
                    "Which of the following is true about Windows Forms in .NET Core?",
                    Arrays.asList("Used for console apps", "Used for GUI applications", "Used for threads", "Used for delegates"),
                    1, // Correct: Used for GUI applications
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN35);

                // QDN36 (Original Q36): Abstract Methods True Statement
                Question qDN36 = new Question(
                    "Which of the following is true about abstract methods?",
                    Arrays.asList("Must be implemented in derived classes", "Can have a body", "Always static", "Cannot be inherited"),
                    0, // Correct: Must be implemented in derived classes
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN36);

                // QDN37 (Original Q37): Multi-cast Delegates True Statement
                Question qDN37 = new Question(
                    "Which of the following is true about multi-cast delegates?",
                    Arrays.asList("Can call only one method", "Can call multiple methods", "Cannot be created", "Always abstract"),
                    1, // Correct: Can call multiple methods
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN37);

                // QDN38 (Original Q38): Func Delegate True Statement
                Question qDN38 = new Question(
                    "Which of the following is true about Func delegate?",
                    Arrays.asList("Returns a value", "Does not return a value", "Always returns boolean", "Used for threads"),
                    0, // Correct: Returns a value
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN38);

                // QDN39 (Original Q39): Action Delegate True Statement
                Question qDN39 = new Question(
                    "Which of the following is true about Action delegate?",
                    Arrays.asList("Returns a value", "Does not return a value", "Always returns boolean", "Used for LINQ"),
                    1, // Correct: Does not return a value
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN39);

                // QDN40 (Original Q40): Predicate Delegate True Statement
                Question qDN40 = new Question(
                    "Which of the following is true about Predicate delegate?",
                    Arrays.asList("Returns a value of any type", "Does not return a value", "Always returns a boolean", "Used for threads"),
                    2, // Correct: Always returns a boolean
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN40);
                
                // QDN41 (Original QDN1): Dotnet Run Command
                Question qDN41 = new Question(
                    "Which command is used to run a .NET Core application from the command line?",
                    Arrays.asList("dotnet build", "dotnet start", "dotnet run", "dotnet execute"),
                    2, // Correct: dotnet run
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN41);

                // --- ASP.NET CORE & EF CORE (QDN42 - QDN81) ---

                // QDN42 (Original Q1): What is Kestrel?
                Question qDN42 = new Question(
                    "What is the name of the cross-platform, open-source web server used by default in ASP.NET Core?",
                    Arrays.asList("IIS", "Apache", "Kestrel", "Nginx"),
                    2, // Correct: Kestrel
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN42);

                // QDN43 (Original Q2): Where is the request pipeline configured?
                Question qDN43 = new Question(
                    "In a typical ASP.NET Core application, which class contains the logic to configure the HTTP request processing pipeline?",
                    Arrays.asList("Program.cs", "Startup.cs", "Controller.cs", "Middleware.cs"),
                    1, // Correct: Startup.cs
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN43);

                // QDN44 (Original Q3): Dependency Injection (DI)
                Question qDN44 = new Question(
                    "Which pattern is central to ASP.NET Core, allowing components to receive dependencies through their constructors?",
                    Arrays.asList("Factory Pattern", "Singleton Pattern", "Dependency Injection", "Observer Pattern"),
                    2, // Correct: Dependency Injection
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN44);

                // QDN45 (Original Q4): Short-lived service scope
                Question qDN45 = new Question(
                    "In ASP.NET Core DI, which service lifetime is created once per client request (within the scope)?",
                    Arrays.asList("Singleton", "Transient", "Scoped", "Static"),
                    2, // Correct: Scoped
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN45);

                // QDN46 (Original Q5): The entry point
                Question qDN46 = new Question(
                    "Which method is the entry point for configuring the services used by the application and its dependency injection container?",
                    Arrays.asList("Configure", "ConfigureServices", "Run", "BuildWebHost"),
                    1, // Correct: ConfigureServices
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN46);

                // QDN47 (Original Q6): Middleware
                Question qDN47 = new Question(
                    "A software component that is assembled into the application pipeline to handle requests and responses is known as:",
                    Arrays.asList("Controller", "Middleware", "View Engine", "Razor Page"),
                    1, // Correct: Middleware 
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN47);

                // QDN48 (Original Q7): Routing
                Question qDN48 = new Question(
                    "The default URL routing convention for MVC applications follows which format?",
                    Arrays.asList("{action}/{controller}/{id}", "{id}/{controller}/{action}", "{controller}/{action}/{id}", "{area}/{controller}/{action}"),
                    2, // Correct: {controller}/{action}/{id}
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN48);

                // QDN49 (Original Q8): Tag Helpers
                Question qDN49 = new Question(
                    "What is the feature in Razor Views that enables server-side code to participate in creating and rendering HTML elements?",
                    Arrays.asList("Web Forms", "Server Controls", "Tag Helpers", "View Components"),
                    2, // Correct: Tag Helpers
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN49);

                // QDN50 (Original Q9): Razor Pages vs MVC
                Question qDN50 = new Question(
                    "Which feature organizes UI logic and server-side code into a single file and is better suited for page-centric scenarios?",
                    Arrays.asList("Web API", "MVC Controllers", "Razor Pages", "SignalR"),
                    2, // Correct: Razor Pages
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN50);

                // QDN51 (Original Q10): Configuration System
                Question qDN51 = new Question(
                    "ASP.NET Core uses a flexible configuration system often loading settings from which file by default?",
                    Arrays.asList("web.config", "Global.asax", "appsettings.json", "styles.css"),
                    2, // Correct: appsettings.json
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN51);

                // QDN52 (Original Q11): MVC Pattern Component
                Question qDN52 = new Question(
                    "In the Model-View-Controller (MVC) pattern, which component handles user input, updates the model, and selects the view?",
                    Arrays.asList("Model", "View", "Controller", "Service"),
                    2, // Correct: Controller
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN52);

                // QDN53 (Original Q12): View Data Transfer
                Question qDN53 = new Question(
                    "What is a dictionary-like object used to transfer a small amount of data from a Controller to a View, which only persists for a single request?",
                    Arrays.asList("TempData", "Session", "ViewBag", "Application"),
                    2, // Correct: ViewBag (or ViewData)
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN53);

                // QDN54 (Original Q13): State Management Across Redirects
                Question qDN54 = new Question(
                    "Which mechanism is used to persist data between two sequential HTTP requests, typically when redirecting from one action to another?",
                    Arrays.asList("ViewData", "TempData", "ViewModel", "Cookie"),
                    1, // Correct: TempData
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN54);

                // QDN55 (Original Q14): Model Binding
                Question qDN55 = new Question(
                    "The process where incoming HTTP request data is mapped to action method parameters is called:",
                    Arrays.asList("Route Matching", "Model Binding", "Action Filtering", "Dependency Resolution"),
                    1, // Correct: Model Binding
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN55);

                // QDN56 (Original Q15): Action Filters
                Question qDN56 = new Question(
                    "Which attribute is used to apply pre-processing or post-processing logic to a controller action method?",
                    Arrays.asList("`[Middleware]`", "`[Filter]`", "`[ActionFilter]`", "`[HttpGet]`"),
                    2, // Correct: [ActionFilter]
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN56);

                // QDN57 (Original Q16): View Component
                Question qDN57 = new Question(
                    "What is the feature that allows you to reuse pieces of the UI logic, acting like a mini-MVC pattern (Controller-View)?",
                    Arrays.asList("Partial View", "Layout Page", "View Component", "Tag Helper"),
                    2, // Correct: View Component
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN57);

                // QDN58 (Original Q17): HTTP GET Attribute
                Question qDN58 = new Question(
                    "Which HTTP verb attribute is typically used for a controller action that retrieves data and does not change the state of the application?",
                    Arrays.asList("`[HttpPut]`", "`[HttpPost]`", "`[HttpGet]`", "`[HttpDelete]`"),
                    2, // Correct: [HttpGet]
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN58);

                // QDN59 (Original Q18): Anti-Forgery Token
                Question qDN59 = new Question(
                    "What mechanism is used to prevent Cross-Site Request Forgery (CSRF) attacks in MVC forms?",
                    Arrays.asList("Session ID", "Anti-Forgery Token", "CORS Headers", "Model Validation"),
                    1, // Correct: Anti-Forgery Token
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN59);

                // QDN60 (Original Q19): Authorization
                Question qDN60 = new Question(
                    "Which attribute is applied to a Controller or action method to restrict access only to authenticated users?",
                    Arrays.asList("`[Authenticate]`", "`[Authorize]`", "`[Restrict]`", "`[Secured]`"),
                    1, // Correct: [Authorize]
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN60);

                // QDN61 (Original Q20): Static Content Serving
                Question qDN61 = new Question(
                    "Which middleware is required to serve files like CSS, JavaScript, and images from the wwwroot folder?",
                    Arrays.asList("`UseRouting()`", "`UseEndpoints()`", "`UseStaticFiles()`", "`UseAuthentication()`"),
                    2, // Correct: UseStaticFiles()
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN61);

                // QDN62 (Original Q21): ORM Definition
                Question qDN62 = new Question(
                    "What does ORM stand for, which Entity Framework Core is an example of?",
                    Arrays.asList("Object Relational Manager", "Output Resource Mapping", "Object-Relational Mapping", "Operational Runtime Module"),
                    2, // Correct: Object-Relational Mapping
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN62);

                // QDN63 (Original Q22): Context Class
                Question qDN63 = new Question(
                    "The primary class in EF Core that manages the database connection and session (unit of work) is derived from:",
                    Arrays.asList("DbContext", "ModelBuilder", "DbSet", "DatabaseProvider"),
                    0, // Correct: DbContext
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN63);

                // QDN64 (Original Q23): Representing Tables
                Question qDN64 = new Question(
                    "In EF Core, database tables are represented in the DbContext class by collections of type:",
                    Arrays.asList("List<T>", "DbSet<T>", "IQueryable<T>", "ICollection<T>"),
                    1, // Correct: DbSet<T>
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN64);

                // QDN65 (Original Q24): Migrations Tool
                Question qDN65 = new Question(
                    "What feature of EF Core allows you to evolve your database schema as your model classes change?",
                    Arrays.asList("Scaffolding", "Seeding", "Migrations", "Mapping"),
                    2, // Correct: Migrations
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN65);

                // QDN66 (Original Q25): Query execution
                Question qDN66 = new Question(
                    "In an EF Core query, adding which method typically causes the query to be executed immediately against the database?",
                    Arrays.asList("`Where()`", "`Select()`", "`OrderBy()`", "`ToList()`"),
                    3, // Correct: ToList()
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN66);

                // QDN67 (Original Q26): Saving Changes
                Question qDN67 = new Question(
                    "Which method is called on the DbContext to persist all changes (inserts, updates, deletes) to the database?",
                    Arrays.asList("`SaveChanges()`", "`Commit()`", "`Persist()`", "`UpdateDatabase()`"),
                    0, // Correct: SaveChanges()
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN67);

                // QDN68 (Original Q27): Eager Loading
                Question qDN68 = new Question(
                    "Which extension method is used to retrieve related entities in the same query (Eager Loading)?",
                    Arrays.asList("`Load()`", "`Include()`", "`Join()`", "`ThenInclude()`"),
                    1, // Correct: Include()
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN68);

                // QDN69 (Original Q28): Database-First Command
                Question qDN69 = new Question(
                    "Which command is used to automatically generate entity classes and a DbContext from an existing database schema?",
                    Arrays.asList("`Add-Migration`", "`Scaffold-DbContext`", "`Update-Database`", "`Remove-Migration`"),
                    1, // Correct: Scaffold-DbContext
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN69);

                // QDN70 (Original Q29): Tracking State
                Question qDN70 = new Question(
                    "The ability of the DbContext to keep track of changes made to entity instances is called:",
                    Arrays.asList("State Machine", "Change Tracker", "Context Loader", "Snapshotting"),
                    1, // Correct: Change Tracker
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN70);

                // QDN71 (Original Q30): Configuring Fluent API
                Question qDN71 = new Question(
                    "Which protected method in the DbContext class is overridden to use the Fluent API for configuring the model?",
                    Arrays.asList("`OnConfiguring()`", "`OnModelCreating()`", "`ModelCreating()`", "`BuildModel()`"),
                    1, // Correct: OnModelCreating()
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN71);

                // QDN72 (Original Q31): SignalR Purpose
                Question qDN72 = new Question(
                    "What technology is used in ASP.NET Core for real-time, bi-directional communication between server and client?",
                    Arrays.asList("Web API", "Blazor", "SignalR", "gRPC"),
                    2, // Correct: SignalR
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN72);

                // QDN73 (Original Q32): Action Result Type
                Question qDN73 = new Question(
                    "Which `ActionResult` type is typically returned from a Web API controller action to indicate success with no content?",
                    Arrays.asList("`OkResult`", "`NotFoundResult`", "`NoContentResult`", "`BadRequestResult`"),
                    2, // Correct: NoContentResult (HTTP 204)
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN73);

                // QDN74 (Original Q33): HTTP Status Code for Not Found
                Question qDN74 = new Question(
                    "What HTTP status code is represented by the `NotFoundResult` in MVC/Web API?",
                    Arrays.asList("200", "404", "500", "401"),
                    1, // Correct: 404
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN74);

                // QDN75 (Original Q34): Hosted Services
                Question qDN75 = new Question(
                    "For running long-running background tasks in ASP.NET Core, the recommended interface to implement is:",
                    Arrays.asList("`IRuntimeTask`", "`IBackgroundWorker`", "`IHostedService`", "`IBackgroundTask`"),
                    2, // Correct: IHostedService
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN75);

                // QDN76 (Original Q35): Health Checks
                Question qDN76 = new Question(
                    "What feature is used to monitor the operational status of services and dependencies in an ASP.NET Core app?",
                    Arrays.asList("Monitoring", "Diagnostics", "Health Checks", "Logging"),
                    2, // Correct: Health Checks
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN76);

                // QDN77 (Original Q36): Identity Default Storage
                Question qDN77 = new Question(
                    "By default, ASP.NET Core Identity uses which type of storage to manage users, roles, and profiles?",
                    Arrays.asList("XML Files", "EF Core (Database)", "Session State", "In-Memory Cache"),
                    1, // Correct: EF Core (Database)
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN77);

                // QDN78 (Original Q37): Action Result vs IActionResult
                Question qDN78 = new Question(
                    "The `IActionResult` interface in MVC is preferred over a concrete `ActionResult` class because:",
                    Arrays.asList("It allows returning any type of object.", "It is faster to execute.", "It provides flexibility and testability by decoupling the controller from the result type.", "It is only used for asynchronous actions."),
                    2, // Correct: It provides flexibility and testability...
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN78);

                // QDN79 (Original Q38): FromBody Attribute
                Question qDN79 = new Question(
                    "In a Web API controller, which attribute is used to force Model Binding to deserialize a complex object from the HTTP request body?",
                    Arrays.asList("`[FromQuery]`", "`[FromRoute]`", "`[FromBody]`", "`[FromHeader]`"),
                    2, // Correct: [FromBody]
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN79);

                // QDN80 (Original Q39): Data Annotation for Primary Key
                Question qDN80 = new Question(
                    "In EF Core, which Data Annotation attribute is typically used to explicitly mark a property as the primary key if it doesn't follow naming conventions?",
                    Arrays.asList("`[ForeignKey]`", "`[PrimaryKey]`", "`[Key]`", "`[Identity]`"),
                    2, // Correct: [Key]
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN80);

                // QDN81 (Original Q40): Unit of Work
                Question qDN81 = new Question(
                    "In Entity Framework Core, the `DbContext` object typically represents which design pattern?",
                    Arrays.asList("Repository Pattern", "Factory Pattern", "Unit of Work", "Adapter Pattern"),
                    2, // Correct: Unit of Work
                    COURSE_DOTNET_CORE
                );
                dao.saveQuestion(qDN81);
                Question qDN82 = new Question(
                	    "In Entity Framework Core, the `DbContext` class acts as a _________ of the database connection and operations.",
                	    Arrays.asList("abstraction", "instance", "controller", "repository"),
                	    0, // Correct: abstraction
                	    COURSE_DOTNET_CORE
                	);
                	dao.saveQuestion(qDN82);

                	Question qDN83 = new Question(
                	    "ASP.NET Core applications use _________ to manage dependencies and services across the application.",
                	    Arrays.asList("Dependency Injection", "Service Locator", "Singleton Pattern", "Factory Pattern"),
                	    0, // Correct: Dependency Injection
                	    COURSE_DOTNET_CORE
                	);
                	dao.saveQuestion(qDN83);

                	Question qDN84 = new Question(
                	    "Middleware components in ASP.NET Core are executed in a _________ order.",
                	    Arrays.asList("pipeline", "random", "hierarchical", "parallel"),
                	    0, // Correct: pipeline
                	    COURSE_DOTNET_CORE
                	);
                	dao.saveQuestion(qDN84);

                	Question qDN85 = new Question(
                	    "The `IConfiguration` interface in .NET Core is used to access _________ settings.",
                	    Arrays.asList("application", "database", "network", "security"),
                	    0, // Correct: application
                	    COURSE_DOTNET_CORE
                	);
                	dao.saveQuestion(qDN85);

                	Question qDN86 = new Question(
                	    "Razor Pages in ASP.NET Core are built on top of the _________ framework.",
                	    Arrays.asList("MVC", "WebForms", "Blazor", "WCF"),
                	    0, // Correct: MVC
                	    COURSE_DOTNET_CORE
                	);
                	dao.saveQuestion(qDN86);

                	Question qDN87 = new Question(
                		    "In .NET Core, `DbContext` implements the Unit of Work pattern.",
                		    Arrays.asList("True", "False"), 
                		    0, // Correct: True
                		    COURSE_DOTNET_CORE
                		);
                		dao.saveQuestion(qDN87);

                		Question qDN88 = new Question(
                		    "ASP.NET Core applications cannot run on Linux or macOS.",
                		    Arrays.asList("True", "False"), 
                		    1, // Correct: False
                		    COURSE_DOTNET_CORE
                		);
                		dao.saveQuestion(qDN88);

                		Question qDN89 = new Question(
                		    "Middleware in ASP.NET Core can short-circuit the request pipeline.",
                		    Arrays.asList("True", "False"), 
                		    0, // Correct: True
                		    COURSE_DOTNET_CORE
                		);
                		dao.saveQuestion(qDN89);

                		Question qDN90 = new Question(
                		    "The `Startup.cs` file is optional in ASP.NET Core applications.",
                		    Arrays.asList("True", "False"), 
                		    1, // Correct: False
                		    COURSE_DOTNET_CORE
                		);
                		dao.saveQuestion(qDN90);

                		Question qDN91 = new Question(
                		    "Dependency Injection is built-in and natively supported in ASP.NET Core.",
                		    Arrays.asList("True", "False"), 
                		    0, // Correct: True
                		    COURSE_DOTNET_CORE
                		);
                		dao.saveQuestion(qDN91);
                		Question qDN92 = new Question(
                			    "ASP.NET Core applications are configured using the _________ file by default.",
                			    Arrays.asList("appsettings.json", "web.config", "settings.xml", "config.json"),
                			    0,
                			    COURSE_DOTNET_CORE
                			);
                			dao.saveQuestion(qDN92);

                			Question qDN93 = new Question(
                			    "The default dependency injection container in ASP.NET Core is _________.",
                			    Arrays.asList("built-in", "Autofac", "Ninject", "Unity"),
                			    0,
                			    COURSE_DOTNET_CORE
                			);
                			dao.saveQuestion(qDN93);

                			Question qDN94 = new Question(
                			    "In ASP.NET Core, services are registered in the _________ method of Startup.cs.",
                			    Arrays.asList("ConfigureServices", "Configure", "Main", "Init"),
                			    0,
                			    COURSE_DOTNET_CORE
                			);
                			dao.saveQuestion(qDN94);

                			Question qDN95 = new Question(
                			    "The _________ method in Startup.cs defines the HTTP request pipeline.",
                			    Arrays.asList("Configure", "ConfigureServices", "Main", "Build"),
                			    0,
                			    COURSE_DOTNET_CORE
                			);
                			dao.saveQuestion(qDN95);

                			Question qDN96 = new Question(
                			    "ASP.NET Core uses _________ hosting model to run applications.",
                			    Arrays.asList("Kestrel", "IIS Express", "Apache", "Nginx"),
                			    0,
                			    COURSE_DOTNET_CORE
                			);
                			dao.saveQuestion(qDN96);

                			Question qDN97 = new Question(
                			    "Entity Framework Core supports _________ migrations to update the database schema.",
                			    Arrays.asList("code-first", "database-first", "model-first", "manual"),
                			    0,
                			    COURSE_DOTNET_CORE
                			);
                			dao.saveQuestion(qDN97);

                			Question qDN98 = new Question(
                			    "ASP.NET Core Identity provides built-in support for _________ management.",
                			    Arrays.asList("user", "session", "cache", "thread"),
                			    0,
                			    COURSE_DOTNET_CORE
                			);
                			dao.saveQuestion(qDN98);

                			Question qDN99 = new Question(
                			    "The _________ pattern is commonly used with repositories in EF Core.",
                			    Arrays.asList("Repository", "Singleton", "Factory", "Observer"),
                			    0,
                			    COURSE_DOTNET_CORE
                			);
                			dao.saveQuestion(qDN99);

                			Question qDN100 = new Question(
                			    "ASP.NET Core applications can be deployed as _________-contained or framework-dependent.",
                			    Arrays.asList("self", "cloud", "portable", "shared"),
                			    0,
                			    COURSE_DOTNET_CORE
                			);
                			dao.saveQuestion(qDN100);

                			Question qDN101 = new Question(
                			    "The _________ tag helper in Razor Pages is used to generate forms.",
                			    Arrays.asList("form", "input", "button", "select"),
                			    0,
                			    COURSE_DOTNET_CORE
                			);
                			dao.saveQuestion(qDN101);

                			Question qDN102 = new Question(
                			    "ASP.NET Core uses Kestrel as its default web server.",
                			    Arrays.asList("True", "False"),
                			    0,
                			    COURSE_DOTNET_CORE
                			);
                			dao.saveQuestion(qDN102);


                				Question qDN103 = new Question(
                				    "Entity Framework Core does not support LINQ queries.",
                				    Arrays.asList("True", "False"),
                				    1,
                				    COURSE_DOTNET_CORE
                				);
                				dao.saveQuestion(qDN103);

                				Question qDN104 = new Question(
                				    "ASP.NET Core applications can run on Windows, Linux, and macOS.",
                				    Arrays.asList("True", "False"),
                				    0,
                				    COURSE_DOTNET_CORE
                				);
                				dao.saveQuestion(qDN104);

                				Question qDN105 = new Question(
                				    "Middleware in ASP.NET Core must always call the next delegate in the pipeline.",
                				    Arrays.asList("True", "False"),
                				    1,
                				    COURSE_DOTNET_CORE
                				);
                				dao.saveQuestion(qDN105);

                				Question qDN106 = new Question(
                				    "The ConfigureServices method is used to register services with the DI container.",
                				    Arrays.asList("True", "False"),
                				    0,
                				    COURSE_DOTNET_CORE
                				);
                				dao.saveQuestion(qDN106);

                				Question qDN107 = new Question(
                				    "ASP.NET Core MVC supports both Razor Pages and Controllers.",
                				    Arrays.asList("True", "False"),
                				    0,
                				    COURSE_DOTNET_CORE
                				);
                				dao.saveQuestion(qDN107);

                				Question qDN108 = new Question(
                				    "EF Core supports lazy loading of related entities.",
                				    Arrays.asList("True", "False"),
                				    0,
                				    COURSE_DOTNET_CORE
                				);
                				dao.saveQuestion(qDN108);

                				Question qDN109 = new Question(
                				    "ASP.NET Core Identity can be integrated with external login providers like Google and Facebook.",
                				    Arrays.asList("True", "False"),
                				    0,
                				    COURSE_DOTNET_CORE
                				);
                				dao.saveQuestion(qDN109);

                				Question qDN110 = new Question(
                				    "ASP.NET Core applications cannot be containerized using Docker.",
                				    Arrays.asList("True", "False"),
                				    1,
                				    COURSE_DOTNET_CORE
                				);
                				dao.saveQuestion(qDN110);

                				Question qDN111 = new Question(
                				    "The appsettings.json file supports hierarchical configuration using JSON objects.",
                				    Arrays.asList("True", "False"),
                				    0,
                				    COURSE_DOTNET_CORE
                				);
                				dao.saveQuestion(qDN111);

                			System.out.println("81 .NET Core questions (QDN1 to QDN81) saved to the database with course name 'Course.NET Core'.");
            


        // ----------------------------------------------------------
        //                 Python Course Questions (Example)
        // ----------------------------------------------------------
        System.out.println("Initializing Python Questions...");

       
        		        // qP1 (Original Q1): Dynamically Typed Language
        		        Question qP1 = new Question(
        		            "Which of the following is a dynamically typed language?",
        		            Arrays.asList("Python", "Java", "C++", "C#"),
        		            0, // Correct: Python
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP1);

        		        // qP2 (Original Q2): Define Function Keyword
        		        Question qP2 = new Question(
        		            "Which keyword is used to define a function in Python?",
        		            Arrays.asList("func", "def", "function", "define"),
        		            1, // Correct: def
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP2);

        		        // qP3 (Original Q3): NOT a Python data type
        		        Question qP3 = new Question(
        		            "Which of the following is NOT a Python data type?",
        		            Arrays.asList("List", "Dictionary", "Tuple", "Pointer"),
        		            3, // Correct: Pointer
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP3);

        		        // qP4 (Original Q4): Multithreading Module
        		        Question qP4 = new Question(
        		            "Which module in Python is used for multithreading?",
        		            Arrays.asList("threading", "multiprocessing", "asyncio", "os"),
        		            0, // Correct: threading
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP4);

        		        // qP5 (Original Q5): GIL Stand for
        		        Question qP5 = new Question(
        		            "What does GIL stand for in Python?",
        		            Arrays.asList("Global Interpreter Lock", "General Input Library", "Global Internal Loop", "General Interpreter Language"),
        		            0, // Correct: Global Interpreter Lock
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP5);

        		        // qP6 (Original Q6): CPU-bound tasks
        		        Question qP6 = new Question(
        		            "Which of the following is best suited for CPU-bound tasks in Python?",
        		            Arrays.asList("Multithreading", "Multiprocessing", "Asyncio", "Tkinter"),
        		            1, // Correct: Multiprocessing
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP6);

        		        // qP7 (Original Q7): Django Architecture Pattern
        		        Question qP7 = new Question(
        		            "Django follows which architecture pattern?",
        		            Arrays.asList("MVC", "MVT", "MVVM", "OOP"),
        		            1, // Correct: MVT (Model-View-Template) 
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP7);

        		        // qP8 (Original Q8): Django’s ORM purpose
        		        Question qP8 = new Question(
        		            "Which of the following is Django’s ORM used for?",
        		            Arrays.asList("Database queries", "File handling", "Networking", "GUI design"),
        		            0, // Correct: Database queries
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP8);

        		        // qP9 (Original Q9): NOT a feature of Django
        		        Question qP9 = new Question(
        		            "Which of the following is NOT a feature of Django?",
        		            Arrays.asList("Admin interface", "Authentication system", "Cross-platform GUI", "Security features"),
        		            2, // Correct: Cross-platform GUI
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP9);

        		        // qP10 (Original Q10): Tkinter Primary Use
        		        Question qP10 = new Question(
        		            "Tkinter is primarily used for?",
        		            Arrays.asList("Web development", "GUI development", "Data analysis", "Machine learning"),
        		            1, // Correct: GUI development
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP10);

        		        // qP11 (Original Q11): Tkinter Grid Manager
        		        Question qP11 = new Question(
        		            "Which geometry manager in Tkinter arranges widgets in a grid-like structure?",
        		            Arrays.asList("pack", "grid", "place", "align"),
        		            1, // Correct: grid 
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP11);

        		        // qP12 (Original Q12): Keep Tkinter Window Running
        		        Question qP12 = new Question(
        		            "Which of the following is used to keep a Tkinter window running?",
        		            Arrays.asList("loop()", "mainloop()", "run()", "execute()"),
        		            1, // Correct: mainloop()
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP12);

        		        // qP13 (Original Q13): NOT a Tkinter Widget
        		        Question qP13 = new Question(
        		            "Which of the following is NOT a Tkinter widget?",
        		            Arrays.asList("Label", "Button", "Frame", "Router"),
        		            3, // Correct: Router
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP13);

        		        // qP14 (Original Q14): Tkinter Event Handling
        		        Question qP14 = new Question(
        		            "Which of the following is used to handle events in Tkinter?",
        		            Arrays.asList("bind()", "connect()", "attach()", "listen()"),
        		            0, // Correct: bind()
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP14);

        		        // qP15 (Original Q15): Python Web Framework
        		        Question qP15 = new Question(
        		            "Which of the following is a Python web framework?",
        		            Arrays.asList("Django", "Tkinter", "NumPy", "Pandas"),
        		            0, // Correct: Django
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP15);

        		        // qP16 (Original Q16): Django Model Creation
        		        Question qP16 = new Question(
        		            "Which of the following is used to create models in Django?",
        		            Arrays.asList("Python classes", "SQL queries", "HTML forms", "JavaScript objects"),
        		            0, // Correct: Python classes
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP16);

        		        // qP17 (Original Q17): Run Django Server Command
        		        Question qP17 = new Question(
        		            "Which of the following is used to run a Django development server?",
        		            Arrays.asList("python manage.py runserver", "django runserver", "python runserver", "django-admin runserver"),
        		            0, // Correct: python manage.py runserver
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP17);

        		        // qP18 (Original Q18): NOT a feature of Django ORM
        		        Question qP18 = new Question(
        		            "Which of the following is NOT a feature of Django ORM?",
        		            Arrays.asList("Database abstraction", "Automatic SQL generation", "GUI creation", "Cross-database support"),
        		            2, // Correct: GUI creation
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP18);

        		        // qP19 (Original Q19): Create New Django App Command
        		        Question qP19 = new Question(
        		            "Which of the following is used to create a new Django app?",
        		            Arrays.asList("python manage.py startapp", "django-admin startapp", "python startapp", "django startapp"),
        		            0, // Correct: python manage.py startapp
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP19);

        		        // qP20 (Original Q20): Secure against CSRF
        		        Question qP20 = new Question(
        		            "Which of the following is used to secure Django applications against CSRF?",
        		            Arrays.asList("CSRF token", "SQL injection filter", "XSS filter", "Firewall"),
        		            0, // Correct: CSRF token
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP20);

        		        // qP21 (Original Q21): URL Patterns file
        		        Question qP21 = new Question(
        		            "Which of the following is used to define URL patterns in Django?",
        		            Arrays.asList("urls.py", "views.py", "models.py", "settings.py"),
        		            0, // Correct: urls.py
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP21);

        		        // qP22 (Original Q22): HTML Templates folder
        		        Question qP22 = new Question(
        		            "Which of the following is used to create HTML templates in Django?",
        		            Arrays.asList("templates folder", "static folder", "media folder", "admin folder"),
        		            0, // Correct: templates folder
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP22);

        		        // qP23 (Original Q23): Static Files Management
        		        Question qP23 = new Question(
        		            "Which of the following is used to manage static files in Django?",
        		            Arrays.asList("STATIC_URL", "MEDIA_URL", "STATICFILES_DIRS", "STATIC_ROOT"),
        		            0, // Correct: STATIC_URL (as the access point, though all are related)
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP23);

        		        // qP24 (Original Q24): Create Forms module
        		        Question qP24 = new Question(
        		            "Which of the following is used to create forms in Django?",
        		            Arrays.asList("django.forms", "django.models", "django.views", "django.admin"),
        		            0, // Correct: django.forms
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP24);

        		        // qP25 (Original Q25): Create New Django Project Command
        		        Question qP25 = new Question(
        		            "Which of the following is used to create a new Django project?",
        		            Arrays.asList("django-admin startproject", "python manage.py startproject", "django startproject", "python startproject"),
        		            0, // Correct: django-admin startproject
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP25);

        		        // qP26 (Original Q26): Responsive Tkinter Applications
        		        Question qP26 = new Question(
        		            "Which technique is often necessary to create responsive Tkinter applications by keeping long-running tasks off the main GUI thread?",
        		            Arrays.asList("Multithreading", "Multiprocessing", "Asyncio", "ORM"),
        		            0, // Correct: Multithreading
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP26);

        		        // qP27 (Original Q27): Draw Shapes in Tkinter
        		        Question qP27 = new Question(
        		            "Which of the following is used to draw shapes in Tkinter?",
        		            Arrays.asList("Canvas", "Frame", "Label", "Button"),
        		            0, // Correct: Canvas
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP27);

        		        // qP28 (Original Q28): Create Menus in Tkinter
        		        Question qP28 = new Question(
        		            "Which of the following is used to create menus in Tkinter?",
        		            Arrays.asList("Menu", "Label", "Button", "Frame"),
        		            0, // Correct: Menu
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP28);

        		        // qP29 (Original Q29): Create Message Boxes in Tkinter
        		        Question qP29 = new Question(
        		            "Which of the following is used to create message boxes in Tkinter?",
        		            Arrays.asList("messagebox", "alertbox", "dialogbox", "infobox"),
        		            0, // Correct: messagebox
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP29);

        		        // qP30 (Original Q30): Create Multiple Threads
        		        Question qP30 = new Question(
        		            "Which of the following is used to create multiple threads in Python?",
        		            Arrays.asList("Thread class", "Process class", "Task class", "Job class"),
        		            0, // Correct: Thread class
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP30);

        		        // qP31 (Original Q31): Prevent Race Conditions
        		        Question qP31 = new Question(
        		            "Which of the following is used to prevent race conditions in multithreading?",
        		            Arrays.asList("Lock", "Semaphore", "Queue", "All of the above"),
        		            3, // Correct: All of the above 
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP31);

        		        // qP32 (Original Q32): Background Tasks in Django
        		        Question qP32 = new Question(
        		            "Which of the following is used to run background tasks in Django?",
        		            Arrays.asList("Celery", "Tkinter", "NumPy", "Pandas"),
        		            0, // Correct: Celery
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP32);

        		        // qP33 (Original Q33): Asynchronous Tasks in Python
        		        Question qP33 = new Question(
        		            "Which of the following is used to handle asynchronous tasks in Python?",
        		            Arrays.asList("asyncio", "threading", "multiprocessing", "tkinter"),
        		            0, // Correct: asyncio
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP33);

        		        // qP34 (Original Q34): REST APIs in Django
        		        Question qP34 = new Question(
        		            "Which of the following is used to create REST APIs in Django?",
        		            Arrays.asList("Django REST Framework", "Tkinter", "NumPy", "Pandas"),
        		            0, // Correct: Django REST Framework
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP34);

        		        // qP35 (Original Q35): Responsive GUIs in Tkinter (Geometry Managers)
        		        Question qP35 = new Question(
        		            "Which of the following are geometry managers used to organize widgets in Tkinter?",
        		            Arrays.asList("pack", "grid", "place", "All of the above"),
        		            3, // Correct: All of the above
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP35);

        		        // qP36 (Original Q36): Admin Panels in Django
        		        Question qP36 = new Question(
        		            "Which of the following is used to create admin panels in Django?",
        		            Arrays.asList("Admin interface", "Tkinter interface", "NumPy interface", "Pandas interface"),
        		            0, // Correct: Admin interface
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP36);

        		        // qP37 (Original Q37): Customize Admin Interface
        		        Question qP37 = new Question(
        		            "Which of the following is used to customize the admin interface in Django?",
        		            Arrays.asList("admin.py", "views.py", "models.py", "settings.py"),
        		            0, // Correct: admin.py
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP37);

        		        // qP38 (Original Q38): Precise Placement Geometry Manager
        		        Question qP38 = new Question(
        		            "Which geometry manager in Tkinter allows precise placement of widgets using x and y coordinates?",
        		            Arrays.asList("pack", "grid", "place", "anchor"),
        		            2, // Correct: place
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP38);

        		        // qP39 (Original Q39): Create Database Tables Command
        		        Question qP39 = new Question(
        		            "What command is typically used to create the initial Django database tables based on your models?",
        		            Arrays.asList("python manage.py createsuperuser", "python manage.py makemigrations", "python manage.py migrate", "python manage.py syncdb"),
        		            2, // Correct: python manage.py migrate (after makemigrations)
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP39);

        		        // qP40 (Original Q40): Multithreading Inefficiency for CPU-bound tasks
        		        Question qP40 = new Question(
        		            "What is the main characteristic that makes multithreading inefficient for CPU-bound tasks in standard Python (CPython)?",
        		            Arrays.asList("Memory overhead", "The GIL (Global Interpreter Lock)", "Lack of proper syntax", "OS thread limitations"),
        		            1, // Correct: The GIL (Global Interpreter Lock) 
        		            COURSE_PYTHON
        		        );
        		        dao.saveQuestion(qP40);

        		       

        		                // qP41: Python decorator definition
        		                Question qP41 = new Question(
        		                    "What is a Python decorator primarily used for?",
        		                    Arrays.asList("Defining class properties", "Modifying or wrapping functions/methods", "Creating immutable data structures", "Handling file I/O operations"),
        		                    1, // Correct: Modifying or wrapping functions/methods
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP41);

        		                // qP42: Lambda Function
        		                Question qP42 = new Question(
        		                    "What is a Python 'lambda' function best described as?",
        		                    Arrays.asList("A named function that is recursive", "An anonymous single-expression function", "A method for handling exceptions", "A loop structure for iteration"),
        		                    1, // Correct: An anonymous single-expression function
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP42);

        		                // qP43: Context Manager purpose
        		                Question qP43 = new Question(
        		                    "The 'with' statement in Python is used to implement which feature?",
        		                    Arrays.asList("Multi-threading synchronization", "Function overriding", "Context management (e.g., resource handling)", "Dynamic type checking"),
        		                    2, // Correct: Context management (e.g., resource handling)
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP43);

        		                // qP44: Django signals
        		                Question qP44 = new Question(
        		                    "In Django, what are 'signals' primarily used for?",
        		                    Arrays.asList("Defining database schema fields", "Implementing custom template tags", "Allowing decoupled applications to get notified of events", "Managing static file assets"),
        		                    2, // Correct: Allowing decoupled applications to get notified of events
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP44);

        		                // qP45: Django QuerySet Lazy Evaluation
        		                Question qP45 = new Question(
        		                    "Which statement is true about Django QuerySets?",
        		                    Arrays.asList("They are executed immediately upon creation.", "They are stored entirely in memory.", "They are lazily evaluated (executed only when results are needed).", "They only support SELECT queries."),
        		                    2, // Correct: They are lazily evaluated (executed only when results are needed).
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP45);

        		                // qP46: Python generators
        		                Question qP46 = new Question(
        		                    "What is the key advantage of using a Python 'generator' (using the 'yield' keyword)?",
        		                    Arrays.asList("They execute faster than regular functions.", "They use less memory by calculating and yielding values one at a time.", "They are thread-safe by default.", "They allow multiple return values in a single call."),
        		                    1, // Correct: They use less memory by calculating and yielding values one at a time.
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP46);

        		                // qP47: Abstract Base Classes (ABCs)
        		                Question qP47 = new Question(
        		                    "Which module is typically used to create Abstract Base Classes (ABCs) in Python?",
        		                    Arrays.asList("os", "sys", "abc", "re"),
        		                    2, // Correct: abc
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP47);

        		                // qP48: Decorator to protect class methods
        		                Question qP48 = new Question(
        		                    "Which standard Python decorator is used to define a method that belongs to a class but does not access instance or class state?",
        		                    Arrays.asList("@classmethod", "@staticmethod", "@property", "@wrapper"),
        		                    1, // Correct: @staticmethod
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP48);

        		                // qP49: Django Template Language (DTL)
        		                Question qP49 = new Question(
        		                    "In Django's Template Language, what surrounds a variable that needs to be displayed?",
        		                    Arrays.asList("{% ... %}", "{{ ... }}", "{# ... #}", "$$ ... $$"),
        		                    1, // Correct: {{ ... }}
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP49);

        		                // qP50: Django Form validation
        		                Question qP50 = new Question(
        		                    "Which method is typically called on a Django Form instance to check if the submitted data is valid?",
        		                    Arrays.asList("validate_data()", "is_valid()", "check_errors()", "clean()"),
        		                    1, // Correct: is_valid()
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP50);

        		                // qP51: Python MRO
        		                Question qP51 = new Question(
        		                    "What does MRO stand for in the context of Python object-oriented programming, especially regarding inheritance?",
        		                    Arrays.asList("Method Resolution Order", "Module Reference Object", "Main Return Operation", "Memory Allocation Routine"),
        		                    0, // Correct: Method Resolution Order
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP51);

        		                // qP52: Django URL namespace
        		                Question qP52 = new Question(
        		                    "In Django, why would you use the 'namespace' argument when including URL configurations?",
        		                    Arrays.asList("To improve query performance.", "To prevent URL name conflicts between different apps.", "To enable lazy loading of views.", "To secure the URL paths."),
        		                    1, // Correct: To prevent URL name conflicts between different apps.
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP52);

        		                // qP53: Django Many-to-Many field
        		                Question qP53 = new Question(
        		                    "Which Django model field is used to define a relationship where two objects can be associated with multiple instances of each other?",
        		                    Arrays.asList("ForeignKey", "OneToOneField", "ManyToManyField", "RelatedField"),
        		                    2, // Correct: ManyToManyField
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP53);

        		                // qP54: Django Management Command
        		                Question qP54 = new Question(
        		                    "To create a custom command that runs via `python manage.py`, where should the command script be placed?",
        		                    Arrays.asList("In the views folder", "In a 'management/commands' subdirectory of an app", "In the main settings.py file", "In the templates folder"),
        		                    1, // Correct: In a 'management/commands' subdirectory of an app
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP54);

        		                // qP55: Python Pass Statement
        		                Question qP55 = new Question(
        		                    "What is the function of the 'pass' statement in Python?",
        		                    Arrays.asList("To terminate a loop or function.", "To skip the current iteration of a loop.", "It is a null operation; nothing happens when it executes.", "To raise a custom exception."),
        		                    2, // Correct: It is a null operation; nothing happens when it executes.
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP55);

        		                // qP56: Django Admin customization
        		                Question qP56 = new Question(
        		                    "Which class is used in Django's `admin.py` to customize the appearance and functionality of a model in the admin interface?",
        		                    Arrays.asList("ModelAdmin", "AdminView", "AdminController", "ModelForm"),
        		                    0, // Correct: ModelAdmin
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP56);

        		                // qP57: Python Classmethod
        		                Question qP57 = new Question(
        		                    "When a class method is called, what is the first parameter automatically passed to it?",
        		                    Arrays.asList("self (the instance)", "cls (the class itself)", "instance (the object)", "None"),
        		                    1, // Correct: cls (the class itself)
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP57);

        		                // qP58: Django View Types
        		                Question qP58 = new Question(
        		                    "Django provides two main styles for writing views: Function-Based Views (FBVs) and which other type?",
        		                    Arrays.asList("Template-Based Views (TBVs)", "Model-Based Views (MBVs)", "Class-Based Views (CBVs)", "API-Based Views (ABVs)"),
        		                    2, // Correct: Class-Based Views (CBVs)
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP58);

        		                // qP59: Python set
        		                Question qP59 = new Question(
        		                    "Which of the following describes a Python 'set' data type?",
        		                    Arrays.asList("Ordered, mutable, allows duplicates", "Ordered, immutable, allows duplicates", "Unordered, mutable, unique elements", "Unordered, immutable, unique elements"),
        		                    2, // Correct: Unordered, mutable, unique elements
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP59);

        		                // qP60: Python docstring
        		                Question qP60 = new Question(
        		                    "In Python, what is the official term for the string literal that occurs as the first statement in a module, function, class, or method definition?",
        		                    Arrays.asList("Comment", "Annotation", "Docstring", "Decorator"),
        		                    2, // Correct: Docstring
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP60);

        		                // --- DATA SCIENCE (NUMPY & PANDAS) (qP61 - qP80) ---

        		                // qP61: NumPy core object
        		                Question qP61 = new Question(
        		                    "What is the fundamental object in NumPy that is a fast, flexible container for large datasets?",
        		                    Arrays.asList("DataFrame", "Series", "ndarray", "List"),
        		                    2, // Correct: ndarray
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP61);

        		                // qP62: Pandas core object
        		                Question qP62 = new Question(
        		                    "What is the primary Pandas data structure used to represent a two-dimensional table with labeled rows and columns?",
        		                    Arrays.asList("Series", "Panel", "DataFrame", "array"),
        		                    2, // Correct: DataFrame
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP62);

        		                // qP63: NumPy array slicing
        		                Question qP63 = new Question(
        		                    "If `arr` is a NumPy array, what does the expression `arr[1:5, 2]` select?",
        		                    Arrays.asList("Rows 1 to 5 (exclusive) and column 2.", "Rows 1 to 4 (exclusive) and column 2.", "Rows 1 to 5 (inclusive) and column 2.", "Rows 1 to 4 (inclusive) and column 2."),
        		                    1, // Correct: Rows 1 to 4 (exclusive) and column 2. (Python slicing excludes the end index)
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP63);

        		                // qP64: Pandas Series
        		                Question qP64 = new Question(
        		                    "A Pandas Series is essentially a one-dimensional labeled array. What does its label array represent?",
        		                    Arrays.asList("The values", "The index", "The data type", "The shape"),
        		                    1, // Correct: The index
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP64);

        		                // qP65: Handling missing data in Pandas
        		                Question qP65 = new Question(
        		                    "Which Pandas method is commonly used to remove rows or columns containing missing values (NaN)?",
        		                    Arrays.asList("fill_na()", "replace_na()", "drop_na()", "remove_missing()"),
        		                    2, // Correct: drop_na()
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP65);

        		                // qP66: NumPy array creation from a list
        		                Question qP66 = new Question(
        		                    "Which function is used in NumPy to convert a standard Python list into an ndarray?",
        		                    Arrays.asList("np.list_to_array()", "np.create_array()", "np.array()", "np.make_array()"),
        		                    2, // Correct: np.array()
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP66);

        		                // qP67: Pandas loc accessor
        		                Question qP67 = new Question(
        		                    "In Pandas, which accessor is primarily used for label-based indexing of a DataFrame?",
        		                    Arrays.asList(".iloc", ".loc", ".at", ".ix"),
        		                    1, // Correct: .loc
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP67);

        		                // qP68: Boolean Masking
        		                Question qP68 = new Question(
        		                    "What technique is commonly used in both NumPy and Pandas for selecting data based on a conditional expression?",
        		                    Arrays.asList("SQL Join", "Boolean Masking", "MapReduce", "Vectorization"),
        		                    1, // Correct: Boolean Masking
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP68);

        		                // qP69: NumPy reshape
        		                Question qP69 = new Question(
        		                    "If `arr` is a 1D NumPy array of 12 elements, what method call would convert it into a 3x4 2D array?",
        		                    Arrays.asList("arr.transpose((3,4))", "arr.change(3,4)", "arr.reshape(3,4)", "arr.resize(3,4)"),
        		                    2, // Correct: arr.reshape(3,4)
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP69);

        		                // qP70: Pandas GroupBy
        		                Question qP70 = new Question(
        		                    "Which Pandas operation is analogous to the GROUP BY clause in SQL, typically used for aggregating data?",
        		                    Arrays.asList("df.aggregate()", "df.pivot()", "df.merge()", "df.groupby()"),
        		                    3, // Correct: df.groupby()
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP70);

        		                // qP71: Data Type in NumPy
        		                Question qP71 = new Question(
        		                    "What property of a NumPy ndarray specifies the data type (e.g., int32, float64) of its elements?",
        		                    Arrays.asList(".type", ".dtype", ".data", ".kind"),
        		                    1, // Correct: .dtype
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP71);

        		                // qP72: Pandas Data Ingestion
        		                Question qP72 = new Question(
        		                    "Which Pandas function is used to read data directly from a CSV file into a DataFrame?",
        		                    Arrays.asList("pd.read_csv()", "pd.import_csv()", "pd.load_data()", "pd.from_file()"),
        		                    0, // Correct: pd.read_csv()
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP72);

        		                // qP73: Vectorization
        		                Question qP73 = new Question(
        		                    "The concept of applying operations on entire arrays at once, rather than iterating through elements, is known as:",
        		                    Arrays.asList("Broadcasting", "Vectorization", "Serialization", "Hashing"),
        		                    1, // Correct: Vectorization
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP73);

        		                // qP74: Pandas Merge
        		                Question qP74 = new Question(
        		                    "In Pandas, the operation that combines two DataFrames based on a common column or index is called:",
        		                    Arrays.asList("Concatenation", "Union", "Merging", "Joining"),
        		                    2, // Correct: Merging (via pd.merge() or df.merge())
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP74);

        		                // qP75: NumPy broadcasting
        		                Question qP75 = new Question(
        		                    "What is the term for NumPy's mechanism that allows arrays of different shapes to be used in arithmetic operations?",
        		                    Arrays.asList("Vectorization", "Slicing", "Broadcasting", "Mapping"),
        		                    2, // Correct: Broadcasting 
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP75);

        		                // qP76: Pandas Time Series Index
        		                Question qP76 = new Question(
        		                    "Which specialized index type in Pandas is optimized for handling time-related data?",
        		                    Arrays.asList("CategoricalIndex", "MultiIndex", "DatetimeIndex", "Float64Index"),
        		                    2, // Correct: DatetimeIndex
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP76);

        		                // qP77: Pandas Fillna
        		                Question qP77 = new Question(
        		                    "Which Pandas method is used to substitute missing (NaN) values with a specified constant or a calculated value (like the mean)?",
        		                    Arrays.asList("replace_na()", "interpolate()", "fillna()", "substitute()"),
        		                    2, // Correct: fillna()
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP77);

        		                // qP78: NumPy Random
        		                Question qP78 = new Question(
        		                    "Which NumPy sub-module is used for generating pseudo-random numbers, often used in simulations or model initialization?",
        		                    Arrays.asList("np.math", "np.random", "np.generate", "np.seed"),
        		                    1, // Correct: np.random
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP78);

        		                // qP79: Pandas iloc accessor
        		                Question qP79 = new Question(
        		                    "In Pandas, which accessor is primarily used for **integer-based position** indexing of a DataFrame?",
        		                    Arrays.asList(".loc", ".iloc", ".pos", ".at"),
        		                    1, // Correct: .iloc
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP79);

        		                // qP80: Efficiency of NumPy/Pandas
        		                Question qP80 = new Question(
        		                    "The high speed and efficiency of NumPy and Pandas operations are mainly due to their reliance on optimized code written in which language?",
        		                    Arrays.asList("Java", "Assembly", "C and Fortran", "Python (pure)"),
        		                    2, // Correct: C and Fortran
        		                    COURSE_PYTHON
        		                );
        		                dao.saveQuestion(qP80);
        		                
        		                Question qP81 = new Question(
        		                	    "Which of the following is the correct way to define a function in Python?",
        		                	    Arrays.asList("function myFunc():", "def myFunc():", "func myFunc():", "define myFunc():"),
        		                	    1, // Correct: def myFunc():
        		                	    COURSE_PYTHON
        		                	);
        		                	dao.saveQuestion(qP81);

        		                	Question qP82 = new Question(
        		                	    "Which data type in Python is immutable?",
        		                	    Arrays.asList("List", "Dictionary", "Tuple", "Set"),
        		                	    2, // Correct: Tuple
        		                	    COURSE_PYTHON
        		                	);
        		                	dao.saveQuestion(qP82);

        		                	Question qP83 = new Question(
        		                	    "What is the output of len('Python')?",
        		                	    Arrays.asList("5", "6", "7", "Error"),
        		                	    1, // Correct: 6
        		                	    COURSE_PYTHON
        		                	);
        		                	dao.saveQuestion(qP83);

        		                	Question qP84 = new Question(
        		                	    "Which keyword is used to handle exceptions in Python?",
        		                	    Arrays.asList("catch", "try", "except", "error"),
        		                	    2, // Correct: except
        		                	    COURSE_PYTHON
        		                	);
        		                	dao.saveQuestion(qP84);

        		                	Question qP85 = new Question(
        		                	    "Which of the following is used to install external Python packages?",
        		                	    Arrays.asList("npm", "pip", "install", "pkg"),
        		                	    1, // Correct: pip
        		                	    COURSE_PYTHON
        		                	);
        		                	dao.saveQuestion(qP85);

        		                	Question qP86 = new Question(
        		                	    "Which operator is used for floor division in Python?",
        		                	    Arrays.asList("/", "//", "%", "**"),
        		                	    1, // Correct: //
        		                	    COURSE_PYTHON
        		                	);
        		                	dao.saveQuestion(qP86);

        		                	Question qP87 = new Question(
        		                	    "Which of the following is NOT a valid Python data structure?",
        		                	    Arrays.asList("List", "Array", "Tuple", "Set"),
        		                	    1, // Correct: Array (not built-in)
        		                	    COURSE_PYTHON
        		                	);
        		                	dao.saveQuestion(qP87);

        		                	Question qP88 = new Question(
        		                	    "Which Python library is primarily used for data visualization?",
        		                	    Arrays.asList("NumPy", "Matplotlib", "Pandas", "Scikit-learn"),
        		                	    1, // Correct: Matplotlib
        		                	    COURSE_PYTHON
        		                	);
        		                	dao.saveQuestion(qP88);

        		                	Question qP89 = new Question(
        		                	    "Which of the following methods is used to add an element to a list?",
        		                	    Arrays.asList("append()", "add()", "insert()", "push()"),
        		                	    0, // Correct: append()
        		                	    COURSE_PYTHON
        		                	);
        		                	dao.saveQuestion(qP89);

        		                	Question qP90 = new Question(
        		                	    "Which of the following is the correct file extension for Python files?",
        		                	    Arrays.asList(".py", ".python", ".pt", ".pyt"),
        		                	    0, // Correct: .py
        		                	    COURSE_PYTHON
        		                	);
        		                	dao.saveQuestion(qP90);

        		                	Question qP91 = new Question(
        		                		    "In Python, the keyword used to define a function is _________.",
        		                		    Arrays.asList("def"),
        		                		    0,
        		                		    COURSE_PYTHON
        		                		);
        		                		dao.saveQuestion(qP91);

        		 
        		                				Question qP92 = new Question(
        		                					    "The built-in function _________ is used to get the length of a list or string.",
        		                					    Arrays.asList("len", "size", "length", "count"),
        		                					    0,
        		                					    COURSE_PYTHON
        		                					);
        		                					dao.saveQuestion(qP92);

        		                					Question qP93 = new Question(
        		                					    "Python uses _________ indentation to define code blocks.",
        		                					    Arrays.asList("whitespace", "tab", "braces", "semicolon"),
        		                					    0,
        		                					    COURSE_PYTHON
        		                					);
        		                					dao.saveQuestion(qP93);

        		                					Question qP94 = new Question(
        		                					    "The _________ keyword in Python is used to create a generator.",
        		                					    Arrays.asList("yield", "return", "async", "generate"),
        		                					    0,
        		                					    COURSE_PYTHON
        		                					);
        		                					dao.saveQuestion(qP94);

        		                					Question qP95 = new Question(
        		                					    "The _________ operator in Python is used for exponentiation.",
        		                					    Arrays.asList("**", "^", "exp", "//"),
        		                					    0,
        		                					    COURSE_PYTHON
        		                					);
        		                					dao.saveQuestion(qP95);

        		                					Question qP96 = new Question(
        		                					    "The built-in data type _________ is used to store key-value pairs in Python.",
        		                					    Arrays.asList("dictionary", "list", "tuple", "set"),
        		                					    0,
        		                					    COURSE_PYTHON
        		                					);
        		                					dao.saveQuestion(qP96);

        		                					Question qP97 = new Question(
        		                					    "The _________ function in Python is used to display output on the console.",
        		                					    Arrays.asList("print", "echo", "write", "display"),
        		                					    0,
        		                					    COURSE_PYTHON
        		                					);
        		                					dao.saveQuestion(qP97);

        		                					Question qP98 = new Question(
        		                					    "Python’s _________ keyword is used to handle exceptions.",
        		                					    Arrays.asList("try", "catch", "except", "finally"),
        		                					    0,
        		                					    COURSE_PYTHON
        		                					);
        		                					dao.saveQuestion(qP98);

        		                					Question qP99 = new Question(
        		                					    "The _________ module in Python is commonly used for regular expressions.",
        		                					    Arrays.asList("re", "regex", "regexp", "pattern"),
        		                					    0,
        		                					    COURSE_PYTHON
        		                					);
        		                					dao.saveQuestion(qP99);

        		                					Question qP100 = new Question(
        		                					    "Python’s _________ keyword is used to import external modules.",
        		                					    Arrays.asList("import", "include", "require", "using"),
        		                					    0,
        		                					    COURSE_PYTHON
        		                					);
        		                					dao.saveQuestion(qP100);

        		                
        		                System.out.println("40 Advanced Python/Django/Data Science questions (qP41-qP80) saved to the database with course name 'course python'.");
        		     

        // ----------------------------------------------------------
        //             DBMS Course Questions (Example)
        // ----------------------------------------------------------
        System.out.println("Initializing DBMS Questions...");

        // Q_D1
        Question qD1 = new Question(
        	    "Which of the following is a primary key property?",
        	    Arrays.asList("Unique", "Duplicate", "Nullable", "Optional"),
        	    0, // Correct: Unique
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD1);

        	Question qD2 = new Question(
        	    "Which SQL command is used to remove a table?",
        	    Arrays.asList("DROP", "DELETE", "REMOVE", "TRUNCATE"),
        	    0, // Correct: DROP
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD2);

        	Question qD3 = new Question(
        	    "Which of the following is a Data Manipulation Language (DML) command?",
        	    Arrays.asList("INSERT", "CREATE", "DROP", "ALTER"),
        	    0, // Correct: INSERT
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD3);

        	Question qD4 = new Question(
        	    "Which of the following ensures data consistency in transactions?",
        	    Arrays.asList("ACID properties", "BASE properties", "Normalization", "Indexing"),
        	    0, // Correct: ACID properties
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD4);

        	Question qD5 = new Question(
        	    "Which normal form eliminates transitive dependency?",
        	    Arrays.asList("Third Normal Form (3NF)", "First Normal Form (1NF)", "Second Normal Form (2NF)", "BCNF"),
        	    0, // Correct: 3NF
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD5);

        	Question qD6 = new Question(
        	    "Which of the following is NOT a type of database model?",
        	    Arrays.asList("Relational", "Hierarchical", "Network", "Circular"),
        	    3, // Correct: Circular
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD6);

        	Question qD7 = new Question(
        	    "Which SQL clause is used to filter records?",
        	    Arrays.asList("WHERE", "ORDER BY", "GROUP BY", "HAVING"),
        	    0, // Correct: WHERE
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD7);

        	Question qD8 = new Question(
        	    "Which of the following is used to speed up data retrieval?",
        	    Arrays.asList("Index", "Trigger", "View", "Cursor"),
        	    0, // Correct: Index
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD8);

        	Question qD9 = new Question(
        	    "Which of the following is a property of foreign keys?",
        	    Arrays.asList("Ensures referential integrity", "Must be unique", "Acts as primary key", "Always nullable"),
        	    0, // Correct: Ensures referential integrity
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD9);

        	Question qD10 = new Question(
        	    "Which SQL keyword is used to combine rows from two tables?",
        	    Arrays.asList("JOIN", "UNION", "MERGE", "INTERSECT"),
        	    0, // Correct: JOIN
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD10);

        	Question qD11 = new Question(
        	    "Which SQL statement is used to remove all rows from a table but keep its structure?",
        	    Arrays.asList("TRUNCATE", "DROP", "DELETE", "REMOVE"),
        	    0, // Correct: TRUNCATE
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD11);

        	Question qD12 = new Question(
        	    "Which of the following is a Data Control Language (DCL) command?",
        	    Arrays.asList("GRANT", "SELECT", "INSERT", "UPDATE"),
        	    0, // Correct: GRANT
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD12);

        	Question qD13 = new Question(
        	    "Which of the following commands is used to save a transaction permanently?",
        	    Arrays.asList("COMMIT", "ROLLBACK", "SAVEPOINT", "CHECKPOINT"),
        	    0, // Correct: COMMIT
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD13);

        	Question qD14 = new Question(
        	    "Which of the following is used to enforce referential integrity?",
        	    Arrays.asList("Foreign Key", "Primary Key", "Index", "Trigger"),
        	    0, // Correct: Foreign Key
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD14);

        	Question qD15 = new Question(
        	    "Which SQL clause is used to group rows that have the same values?",
        	    Arrays.asList("GROUP BY", "ORDER BY", "HAVING", "WHERE"),
        	    0, // Correct: GROUP BY
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD15);

        	Question qD16 = new Question(
        	    "Which of the following is NOT part of ACID properties?",
        	    Arrays.asList("Atomicity", "Consistency", "Isolation", "Reliability"),
        	    3, // Correct: Reliability
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD16);

        	Question qD17 = new Question(
        	    "Which SQL keyword is used to remove duplicate rows in a result set?",
        	    Arrays.asList("DISTINCT", "UNIQUE", "REMOVE", "FILTER"),
        	    0, // Correct: DISTINCT
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD17);

        	Question qD18 = new Question(
        	    "Which of the following is used to define a default value for a column?",
        	    Arrays.asList("DEFAULT", "CHECK", "NOT NULL", "PRIMARY KEY"),
        	    0, // Correct: DEFAULT
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD18);

        	Question qD19 = new Question(
        	    "Which of the following is used to create a virtual table?",
        	    Arrays.asList("VIEW", "INDEX", "TRIGGER", "CURSOR"),
        	    0, // Correct: VIEW
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD19);

        	Question qD20 = new Question(
        	    "Which of the following is used to automatically perform an action when an event occurs?",
        	    Arrays.asList("Trigger", "Index", "View", "Procedure"),
        	    0, // Correct: Trigger
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD20);

        	Question qD21 = new Question(
        	    "Which SQL keyword is used to sort results?",
        	    Arrays.asList("ORDER BY", "GROUP BY", "HAVING", "WHERE"),
        	    0, // Correct: ORDER BY
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD21);

        	Question qD22 = new Question(
        	    "Which of the following is used to ensure a column cannot have NULL values?",
        	    Arrays.asList("NOT NULL", "DEFAULT", "CHECK", "UNIQUE"),
        	    0, // Correct: NOT NULL
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD22);

        	Question qD23 = new Question(
        	    "Which SQL command is used to change the structure of a table?",
        	    Arrays.asList("ALTER", "UPDATE", "MODIFY", "CHANGE"),
        	    0, // Correct: ALTER
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD23);

        	Question qD24 = new Question(
        	    "Which of the following is used to enforce a condition on a column?",
        	    Arrays.asList("CHECK", "DEFAULT", "NOT NULL", "INDEX"),
        	    0, // Correct: CHECK
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD24);

        	Question qD25 = new Question(
        	    "Which SQL keyword is used to combine the results of two queries?",
        	    Arrays.asList("UNION", "JOIN", "INTERSECT", "MERGE"),
        	    0, // Correct: UNION
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD25);

        	Question qD26 = new Question(
        	    "Which of the following is used to rollback part of a transaction?",
        	    Arrays.asList("SAVEPOINT", "ROLLBACK", "COMMIT", "CHECKPOINT"),
        	    0, // Correct: SAVEPOINT
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD26);

        	Question qD27 = new Question(
        	    "Which SQL keyword is used to rename a column or table in the result set?",
        	    Arrays.asList("AS", "RENAME", "CHANGE", "ALTER"),
        	    0, // Correct: AS
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD27);

        	Question qD28 = new Question(
        	    "Which of the following is used to remove duplicate rows when combining queries?",
        	    Arrays.asList("UNION", "UNION ALL", "JOIN", "INTERSECT"),
        	    0, // Correct: UNION
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD28);

        	Question qD29 = new Question(
        	    "Which SQL keyword is used to count the number of rows?",
        	    Arrays.asList("COUNT", "SUM", "AVG", "MAX"),
        	    0, // Correct: COUNT
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD29);

        	Question qD30 = new Question(
        	    "Which SQL function is used to find the highest value in a column?",
        	    Arrays.asList("MAX", "MIN", "SUM", "AVG"),
        	    0, // Correct: MAX
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD30);

        	Question qD31 = new Question(
        	    "Which SQL clause is used to filter groups after aggregation?",
        	    Arrays.asList("HAVING", "WHERE", "GROUP BY", "ORDER BY"),
        	    0, // Correct: HAVING
        	    COURSE_DBMS
        	);
        	dao.saveQuestion(qD31);

        	Question qD32 = new Question(
        		    "Which SQL keyword is used to remove a database entirely?",
        		    Arrays.asList("DROP DATABASE", "DELETE DATABASE", "REMOVE DATABASE", "TRUNCATE DATABASE"),
        		    0, // Correct: DROP DATABASE
        		    COURSE_DBMS
        		);
        		dao.saveQuestion(qD32);

        		Question qD33 = new Question(
        		    "Which SQL keyword is used to create a new database?",
        		    Arrays.asList("CREATE DATABASE", "NEW DATABASE", "MAKE DATABASE", "ADD DATABASE"),
        		    0, // Correct: CREATE DATABASE
        		    COURSE_DBMS
        		);
        		dao.saveQuestion(qD33);

        		Question qD34 = new Question(
        		    "Which SQL keyword is used to update existing data in a table?",
        		    Arrays.asList("UPDATE", "ALTER", "INSERT", "MODIFY"),
        		    0, // Correct: UPDATE
        		    COURSE_DBMS
        		);
        		dao.saveQuestion(qD34);

        		Question qD35 = new Question(
        		    "Which SQL keyword is used to delete specific rows from a table?",
        		    Arrays.asList("DELETE", "DROP", "TRUNCATE", "REMOVE"),
        		    0, // Correct: DELETE
        		    COURSE_DBMS
        		);
        		dao.saveQuestion(qD35);

        		Question qD36 = new Question(
        		    "Which SQL function is used to calculate the average of values in a column?",
        		    Arrays.asList("AVG", "SUM", "COUNT", "MAX"),
        		    0, // Correct: AVG
        		    COURSE_DBMS
        		);
        		dao.saveQuestion(qD36);

        		Question qD37 = new Question(
        		    "Which SQL keyword is used to remove all rows from a table without logging individual row deletions?",
        		    Arrays.asList("TRUNCATE", "DELETE", "DROP", "REMOVE"),
        		    0, // Correct: TRUNCATE
        		    COURSE_DBMS
        		);
        		dao.saveQuestion(qD37);

        		Question qD38 = new Question(
        		    "Which SQL keyword is used to add new rows into a table?",
        		    Arrays.asList("INSERT", "UPDATE", "ALTER", "ADD"),
        		    0, // Correct: INSERT
        		    COURSE_DBMS
        		);
        		dao.saveQuestion(qD38);

        		Question qD39 = new Question(
        		    "Which SQL keyword is used to remove a column from a table?",
        		    Arrays.asList("ALTER TABLE DROP COLUMN", "DELETE COLUMN", "REMOVE COLUMN", "TRUNCATE COLUMN"),
        		    0, // Correct: ALTER TABLE DROP COLUMN
        		    COURSE_DBMS
        		);
        		dao.saveQuestion(qD39);

        		Question qD40 = new Question(
        		    "Which SQL keyword is used to assign permissions to users?",
        		    Arrays.asList("GRANT", "REVOKE", "ALLOW", "PERMIT"),
        		    0, // Correct: GRANT
        		    COURSE_DBMS
        		);
        		dao.saveQuestion(qD40);
        		Question qD41 = new Question(
        			    "Which SQL keyword is used to remove duplicate values from a SELECT query?",
        			    Arrays.asList("DISTINCT", "UNIQUE", "REMOVE", "FILTER"),
        			    0, // Correct: DISTINCT
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD41);

        			Question qD42 = new Question(
        			    "Which type of JOIN returns all rows from the left table, and the matched rows from the right table?",
        			    Arrays.asList("INNER JOIN", "RIGHT JOIN", "FULL JOIN", "LEFT JOIN"),
        			    3, // Correct: LEFT JOIN
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD42);

        			Question qD43 = new Question(
        			    "Which SQL keyword is used to create an index?",
        			    Arrays.asList("CREATE INDEX", "ADD INDEX", "MAKE INDEX", "ALTER INDEX"),
        			    0, // Correct: CREATE INDEX
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD43);

        			Question qD44 = new Question(
        			    "Which SQL command is used to remove an index?",
        			    Arrays.asList("DROP INDEX", "DELETE INDEX", "REMOVE INDEX", "TRUNCATE INDEX"),
        			    0, // Correct: DROP INDEX
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD44);

        			Question qD45 = new Question(
        			    "Which SQL keyword is used to create a new table?",
        			    Arrays.asList("CREATE TABLE", "NEW TABLE", "ADD TABLE", "MAKE TABLE"),
        			    0, // Correct: CREATE TABLE
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD45);

        			Question qD46 = new Question(
        			    "Which SQL keyword is used to rename a table?",
        			    Arrays.asList("RENAME TABLE", "ALTER TABLE", "CHANGE TABLE", "UPDATE TABLE"),
        			    0, // Correct: RENAME TABLE
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD46);

        			Question qD47 = new Question(
        			    "Which SQL keyword is used to check a condition before inserting data?",
        			    Arrays.asList("CHECK", "DEFAULT", "NOT NULL", "CONSTRAINT"),
        			    0, // Correct: CHECK
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD47);

        			Question qD48 = new Question(
        			    "Which SQL keyword is used to enforce uniqueness in a column?",
        			    Arrays.asList("UNIQUE", "PRIMARY KEY", "NOT NULL", "INDEX"),
        			    0, // Correct: UNIQUE
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD48);

        			Question qD49 = new Question(
        			    "Which SQL keyword is used to rollback a transaction?",
        			    Arrays.asList("ROLLBACK", "COMMIT", "SAVEPOINT", "CHECKPOINT"),
        			    0, // Correct: ROLLBACK
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD49);

        			Question qD50 = new Question(
        			    "Which SQL keyword is used to grant permissions?",
        			    Arrays.asList("GRANT", "REVOKE", "ALLOW", "PERMIT"),
        			    0, // Correct: GRANT
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD50);

        			Question qD51 = new Question(
        			    "Which SQL keyword is used to revoke permissions?",
        			    Arrays.asList("REVOKE", "GRANT", "DENY", "REMOVE"),
        			    0, // Correct: REVOKE
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD51);

        			Question qD52 = new Question(
        			    "Which SQL clause is used to specify the source table in a query?",
        			    Arrays.asList("FROM", "WHERE", "SELECT", "TABLE"),
        			    0, // Correct: FROM
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD52);

        			Question qD53 = new Question(
        			    "Which SQL keyword is used to select all columns from a table?",
        			    Arrays.asList("*", "ALL", "SELECT ALL", "EVERY"),
        			    0, // Correct: *
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD53);

        			Question qD54 = new Question(
        			    "Which SQL keyword is used to find the lowest value in a column?",
        			    Arrays.asList("MIN", "MAX", "LOW", "LEAST"),
        			    0, // Correct: MIN
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD54);

        			Question qD55 = new Question(
        			    "Which SQL keyword is used to calculate the sum of values in a column?",
        			    Arrays.asList("SUM", "COUNT", "AVG", "TOTAL"),
        			    0, // Correct: SUM
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD55);

        			Question qD56 = new Question(
        			    "Which SQL keyword is used to calculate the number of distinct values?",
        			    Arrays.asList("COUNT(DISTINCT)", "COUNT", "UNIQUE COUNT", "DISTINCT"),
        			    0, // Correct: COUNT(DISTINCT)
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD56);

        			Question qD57 = new Question(
        			    "Which SQL keyword is used to combine conditions in a WHERE clause?",
        			    Arrays.asList("AND", "OR", "NOT", "BETWEEN"),
        			    0, // Correct: AND
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD57);

        			Question qD58 = new Question(
        			    "Which SQL keyword is used to exclude rows that match a condition?",
        			    Arrays.asList("NOT", "EXCEPT", "EXCLUDE", "IGNORE"),
        			    0, // Correct: NOT
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD58);

        			Question qD59 = new Question(
        			    "Which SQL keyword is used to test if a value is within a range?",
        			    Arrays.asList("BETWEEN", "IN", "RANGE", "WITHIN"),
        			    0, // Correct: BETWEEN
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD59);

        			Question qD60 = new Question(
        			    "Which SQL keyword is used to test if a value is in a list?",
        			    Arrays.asList("IN", "BETWEEN", "ANY", "LIST"),
        			    0, // Correct: IN
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD60);

        			Question qD61 = new Question(
        			    "Which SQL keyword is used to test for NULL values?",
        			    Arrays.asList("IS NULL", "NULL", "CHECK NULL", "EMPTY"),
        			    0, // Correct: IS NULL
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD61);

        			Question qD62 = new Question(
        			    "Which SQL keyword is used to replace NULL values with a default?",
        			    Arrays.asList("COALESCE", "NVL", "DEFAULT", "REPLACE"),
        			    0, // Correct: COALESCE
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD62);

        			Question qD63 = new Question(
        			    "Which SQL keyword is used to return the current system date?",
        			    Arrays.asList("CURRENT_DATE", "SYSDATE", "NOW", "DATE()"),
        			    0, // Correct: CURRENT_DATE
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD63);

        			Question qD64 = new Question(
        			    "Which SQL keyword is used to return the current system time?",
        			    Arrays.asList("CURRENT_TIME", "NOW", "SYSDATE", "TIME()"),
        			    0, // Correct: CURRENT_TIME
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD64);

        			Question qD65 = new Question(
        			    "Which SQL keyword is used to return both current date and time?",
        			    Arrays.asList("CURRENT_TIMESTAMP", "NOW", "SYSDATE", "DATETIME"),
        			    0, // Correct: CURRENT_TIMESTAMP
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD65);

        			Question qD66 = new Question(
        			    "Which SQL keyword is used to create a stored procedure?",
        			    Arrays.asList("CREATE PROCEDURE", "NEW PROCEDURE", "MAKE PROCEDURE", "ADD PROCEDURE"),
        			    0, // Correct: CREATE PROCEDURE
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD66);

        			Question qD67 = new Question(
        			    "Which SQL keyword is used to remove a stored procedure?",
        			    Arrays.asList("DROP PROCEDURE", "DELETE PROCEDURE", "REMOVE PROCEDURE", "TRUNCATE PROCEDURE"),
        			    0, // Correct: DROP PROCEDURE
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD67);

        			Question qD68 = new Question(
        			    "Which SQL keyword is used to create a function?",
        			    Arrays.asList("CREATE FUNCTION", "NEW FUNCTION", "MAKE FUNCTION", "ADD FUNCTION"),
        			    0, // Correct: CREATE FUNCTION
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD68);

        			Question qD69 = new Question(
        			    "Which SQL keyword is used to remove a function?",
        			    Arrays.asList("DROP FUNCTION", "DELETE FUNCTION", "REMOVE FUNCTION", "TRUNCATE FUNCTION"),
        			    0, // Correct: DROP FUNCTION
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD69);

        			Question qD70 = new Question(
        			    "Which SQL keyword is used to create a trigger?",
        			    Arrays.asList("CREATE TRIGGER", "NEW TRIGGER", "MAKE TRIGGER", "ADD TRIGGER"),
        			    0, // Correct: CREATE TRIGGER
        			    COURSE_DBMS
        			);
        			dao.saveQuestion(qD70);

        			Question qD71 = new Question(
        				    "Which SQL keyword is used to remove a trigger?",
        				    Arrays.asList("DROP TRIGGER", "DELETE TRIGGER", "REMOVE TRIGGER", "TRUNCATE TRIGGER"),
        				    0, // Correct: DROP TRIGGER
        				    COURSE_DBMS
        				);
        				dao.saveQuestion(qD71);

        				Question qD72 = new Question(
        				    "Which SQL keyword is used to create a view?",
        				    Arrays.asList("CREATE VIEW", "NEW VIEW", "MAKE VIEW", "ADD VIEW"),
        				    0, // Correct: CREATE VIEW
        				    COURSE_DBMS
        				);
        				dao.saveQuestion(qD72);

        				Question qD73 = new Question(
        				    "Which SQL keyword is used to remove a view?",
        				    Arrays.asList("DROP VIEW", "DELETE VIEW", "REMOVE VIEW", "TRUNCATE VIEW"),
        				    0, // Correct: DROP VIEW
        				    COURSE_DBMS
        				);
        				dao.saveQuestion(qD73);

        				Question qD74 = new Question(
        				    "Which SQL keyword is used to create a schema?",
        				    Arrays.asList("CREATE SCHEMA", "NEW SCHEMA", "MAKE SCHEMA", "ADD SCHEMA"),
        				    0, // Correct: CREATE SCHEMA
        				    COURSE_DBMS
        				);
        				dao.saveQuestion(qD74);

        				Question qD75 = new Question(
        				    "Which SQL keyword is used to remove a schema?",
        				    Arrays.asList("DROP SCHEMA", "DELETE SCHEMA", "REMOVE SCHEMA", "TRUNCATE SCHEMA"),
        				    0, // Correct: DROP SCHEMA
        				    COURSE_DBMS
        				);
        				dao.saveQuestion(qD75);

        				Question qD76 = new Question(
        				    "Which SQL keyword is used to rename a column?",
        				    Arrays.asList("ALTER TABLE RENAME COLUMN", "CHANGE COLUMN", "UPDATE COLUMN", "RENAME"),
        				    0, // Correct: ALTER TABLE RENAME COLUMN
        				    COURSE_DBMS
        				);
        				dao.saveQuestion(qD76);

        				Question qD77 = new Question(
        				    "Which SQL keyword is used to add a column to a table?",
        				    Arrays.asList("ALTER TABLE ADD COLUMN", "INSERT COLUMN", "CREATE COLUMN", "NEW COLUMN"),
        				    0, // Correct: ALTER TABLE ADD COLUMN
        				    COURSE_DBMS
        				);
        				dao.saveQuestion(qD77);

        				Question qD78 = new Question(
        				    "Which SQL keyword is used to enforce a foreign key constraint?",
        				    Arrays.asList("FOREIGN KEY", "PRIMARY KEY", "CHECK", "UNIQUE"),
        				    0, // Correct: FOREIGN KEY
        				    COURSE_DBMS
        				);
        				dao.saveQuestion(qD78);

        				Question qD79 = new Question(
        				    "Which SQL keyword is used to enforce a primary key constraint?",
        				    Arrays.asList("PRIMARY KEY", "FOREIGN KEY", "UNIQUE", "CHECK"),
        				    0, // Correct: PRIMARY KEY
        				    COURSE_DBMS
        				);
        				dao.saveQuestion(qD79);

        				Question qD80 = new Question(
        				    "Which SQL keyword is used to enforce a NOT NULL constraint?",
        				    Arrays.asList("NOT NULL", "DEFAULT", "CHECK", "UNIQUE"),
        				    0, // Correct: NOT NULL
        				    COURSE_DBMS
        				);
        				dao.saveQuestion(qD80);
        				
        				Question qD81 = new Question(
        					    "Which SQL command is used to remove a table from a database?",
        					    Arrays.asList("DELETE", "DROP", "REMOVE", "TRUNCATE"),
        					    1, // Correct: DROP
        					    COURSE_DBMS
        					);
        					dao.saveQuestion(qD81);

        					Question qD82 = new Question(
        					    "Which normal form eliminates transitive dependency?",
        					    Arrays.asList("1NF", "2NF", "3NF", "BCNF"),
        					    2, // Correct: 3NF
        					    COURSE_DBMS
        					);
        					dao.saveQuestion(qD82);

        					Question qD83 = new Question(
        					    "Which SQL clause is used to filter rows returned by a query?",
        					    Arrays.asList("WHERE", "GROUP BY", "ORDER BY", "HAVING"),
        					    0, // Correct: WHERE
        					    COURSE_DBMS
        					);
        					dao.saveQuestion(qD83);

        					Question qD84 = new Question(
        					    "Which of the following is a DML command?",
        					    Arrays.asList("CREATE", "ALTER", "INSERT", "DROP"),
        					    2, // Correct: INSERT
        					    COURSE_DBMS
        					);
        					dao.saveQuestion(qD84);

        					Question qD85 = new Question(
        					    "Which key uniquely identifies each record in a table?",
        					    Arrays.asList("Foreign Key", "Primary Key", "Candidate Key", "Super Key"),
        					    1, // Correct: Primary Key
        					    COURSE_DBMS
        					);
        					dao.saveQuestion(qD85);

        					Question qD86 = new Question(
        					    "Which SQL keyword is used to sort the result set?",
        					    Arrays.asList("ORDER BY", "SORT", "GROUP BY", "ARRANGE"),
        					    0, // Correct: ORDER BY
        					    COURSE_DBMS
        					);
        					dao.saveQuestion(qD86);

        					Question qD87 = new Question(
        					    "Which of the following is NOT a valid SQL aggregate function?",
        					    Arrays.asList("SUM", "COUNT", "AVERAGE", "MAX"),
        					    2, // Correct: AVERAGE (should be AVG)
        					    COURSE_DBMS
        					);
        					dao.saveQuestion(qD87);

        					Question qD88 = new Question(
        					    "Which SQL statement is used to update data in a table?",
        					    Arrays.asList("MODIFY", "UPDATE", "CHANGE", "ALTER"),
        					    1, // Correct: UPDATE
        					    COURSE_DBMS
        					);
        					dao.saveQuestion(qD88);

        					Question qD89 = new Question(
        					    "Which of the following ensures referential integrity?",
        					    Arrays.asList("Primary Key", "Foreign Key", "Unique Key", "Check Constraint"),
        					    1, // Correct: Foreign Key
        					    COURSE_DBMS
        					);
        					dao.saveQuestion(qD89);

        					Question qD90 = new Question(
        					    "Which SQL command is used to remove all rows from a table but keep its structure?",
        					    Arrays.asList("DELETE", "DROP", "TRUNCATE", "REMOVE"),
        					    2, // Correct: TRUNCATE
        					    COURSE_DBMS
        					);
        					dao.saveQuestion(qD90);
        					Question qD91 = new Question(
        						    "The SQL command used to add new rows into a table is _________.",
        						    Arrays.asList("INSERT"),
        						    0,
        						    COURSE_DBMS
        						);
        						dao.saveQuestion(qD91);

        						Question qD92 = new Question(
        							    "The _________ clause in SQL is used to group rows that have the same values.",
        							    Arrays.asList("GROUP BY", "ORDER BY", "HAVING", "WHERE"),
        							    0,
        							    COURSE_DBMS
        							);
        							dao.saveQuestion(qD92);

        							Question qD93 = new Question(
        							    "The _________ key is used to uniquely identify each record in a table.",
        							    Arrays.asList("Primary", "Foreign", "Unique", "Composite"),
        							    0,
        							    COURSE_DBMS
        							);
        							dao.saveQuestion(qD93);

        							Question qD94 = new Question(
        							    "The SQL command _________ is used to permanently delete a table.",
        							    Arrays.asList("DROP", "DELETE", "TRUNCATE", "REMOVE"),
        							    0,
        							    COURSE_DBMS
        							);
        							dao.saveQuestion(qD94);

        							Question qD95 = new Question(
        							    "The _________ clause in SQL is used to filter groups after aggregation.",
        							    Arrays.asList("HAVING", "WHERE", "GROUP BY", "ORDER BY"),
        							    0,
        							    COURSE_DBMS
        							);
        							dao.saveQuestion(qD95);

        							Question qD96 = new Question(
        							    "The SQL command _________ is used to change existing data in a table.",
        							    Arrays.asList("UPDATE", "ALTER", "INSERT", "MODIFY"),
        							    0,
        							    COURSE_DBMS
        							);
        							dao.saveQuestion(qD96);

        							Question qD97 = new Question(
        							    "The SQL keyword _________ is used to remove duplicate rows from a result set.",
        							    Arrays.asList("DISTINCT", "UNIQUE", "FILTER", "ONLY"),
        							    0,
        							    COURSE_DBMS
        							);
        							dao.saveQuestion(qD97);

        							Question qD98 = new Question(
        							    "The _________ constraint ensures that a column cannot have duplicate values.",
        							    Arrays.asList("UNIQUE", "PRIMARY KEY", "NOT NULL", "CHECK"),
        							    0,
        							    COURSE_DBMS
        							);
        							dao.saveQuestion(qD98);

        							Question qD99 = new Question(
        							    "The SQL command _________ is used to define a new table.",
        							    Arrays.asList("CREATE", "ALTER", "INSERT", "DEFINE"),
        							    0,
        							    COURSE_DBMS
        							);
        							dao.saveQuestion(qD99);

        							Question qD100 = new Question(
        							    "The _________ clause in SQL is used to sort rows in ascending or descending order.",
        							    Arrays.asList("ORDER BY", "GROUP BY", "HAVING", "SORT"),
        							    0,
        							    COURSE_DBMS
        							);
        							dao.saveQuestion(qD100);


        // ----------------------------------------------------------
        System.out.println("Initializing Indian Constitution Questions...");

        // Q_IC1
        Question qIC1 = new Question(
        	    "Which article of the Indian Constitution grants the Right to Equality?",
        	    Arrays.asList("Article 19", "Article 14", "Article 21", "Article 32"),
        	    1, // Correct: Article 14
        	    COURSE_INDIAN_CONSTITUTION
        	);
        	dao.saveQuestion(qIC1);

        	Question qIC2 = new Question(
        	    "Which part of the Constitution contains Directive Principles of State Policy?",
        	    Arrays.asList("Part III", "Part IV", "Part V", "Part VI"),
        	    1, // Correct: Part IV
        	    COURSE_INDIAN_CONSTITUTION
        	);
        	dao.saveQuestion(qIC2);

        	Question qIC3 = new Question(
        	    "Fundamental Duties were added to the Constitution by which amendment?",
        	    Arrays.asList("42nd Amendment", "44th Amendment", "52nd Amendment", "73rd Amendment"),
        	    0, // Correct: 42nd Amendment
        	    COURSE_INDIAN_CONSTITUTION
        	);
        	dao.saveQuestion(qIC3);

        	Question qIC4 = new Question(
        	    "Which principle ensures that no one is above the law?",
        	    Arrays.asList("Rule of Law", "Judicial Review", "Federalism", "Secularism"),
        	    0, // Correct: Rule of Law
        	    COURSE_INDIAN_CONSTITUTION
        	);
        	dao.saveQuestion(qIC4);

        	Question qIC5 = new Question(
        	    "Which organ of government interprets the Constitution?",
        	    Arrays.asList("Legislature", "Executive", "Judiciary", "President"),
        	    2, // Correct: Judiciary
        	    COURSE_INDIAN_CONSTITUTION
        	);
        	dao.saveQuestion(qIC5);

        	Question qIC6 = new Question(
        	    "Which article provides the Right to Constitutional Remedies?",
        	    Arrays.asList("Article 32", "Article 21", "Article 19", "Article 14"),
        	    0, // Correct: Article 32
        	    COURSE_INDIAN_CONSTITUTION
        	);
        	dao.saveQuestion(qIC6);

        	Question qIC7 = new Question(
        	    "Which fundamental duty requires citizens to protect the environment?",
        	    Arrays.asList("To protect environment", "To defend nation", "To safeguard public property", "To respect Constitution"),
        	    0, // Correct: To protect environment
        	    COURSE_INDIAN_CONSTITUTION
        	);
        	dao.saveQuestion(qIC7);

        	Question qIC8 = new Question(
        	    "Which principle divides power among Legislature, Executive, and Judiciary?",
        	    Arrays.asList("Separation of Powers", "Federalism", "Democracy", "Secularism"),
        	    0, // Correct: Separation of Powers
        	    COURSE_INDIAN_CONSTITUTION
        	);
        	dao.saveQuestion(qIC8);

        	Question qIC9 = new Question(
        	    "Which part of the Constitution deals with Fundamental Rights?",
        	    Arrays.asList("Part II", "Part III", "Part IV", "Part V"),
        	    1, // Correct: Part III
        	    COURSE_INDIAN_CONSTITUTION
        	);
        	dao.saveQuestion(qIC9);

        	Question qIC10 = new Question(
        	    "Which constitutional principle ensures state neutrality in religion?",
        	    Arrays.asList("Secularism", "Democracy", "Federalism", "Rule of Law"),
        	    0, // Correct: Secularism
        	    COURSE_INDIAN_CONSTITUTION
        	);
        	dao.saveQuestion(qIC10);

        	Question qIC11 = new Question(
        		    "Which principle prevents concentration of power in one branch of government?",
        		    Arrays.asList("Separation of Powers", "Federalism", "Secularism", "Democracy"),
        		    0, // Correct: Separation of Powers
        		    COURSE_INDIAN_CONSTITUTION
        		);
        		dao.saveQuestion(qIC11);

        		Question qIC12 = new Question(
        		    "Which principle ensures equality before law?",
        		    Arrays.asList("Rule of Law", "Judicial Review", "Federalism", "Secularism"),
        		    0, // Correct: Rule of Law
        		    COURSE_INDIAN_CONSTITUTION
        		);
        		dao.saveQuestion(qIC12);

        		Question qIC13 = new Question(
        		    "Which principle states that ultimate power rests with citizens?",
        		    Arrays.asList("Sovereignty of the People", "Federalism", "Secularism", "Rule of Law"),
        		    0, // Correct: Sovereignty of the People
        		    COURSE_INDIAN_CONSTITUTION
        		);
        		dao.saveQuestion(qIC13);

        		Question qIC14 = new Question(
        		    "Which constitutional fundamental aims to reduce inequalities in society?",
        		    Arrays.asList("Social and Economic Justice", "Federalism", "Democracy", "Secularism"),
        		    0, // Correct: Social and Economic Justice
        		    COURSE_INDIAN_CONSTITUTION
        		);
        		dao.saveQuestion(qIC14);

        		Question qIC15 = new Question(
        		    "Which principle ensures state neutrality in matters of religion?",
        		    Arrays.asList("Secularism", "Federalism", "Democracy", "Rule of Law"),
        		    0, // Correct: Secularism
        		    COURSE_INDIAN_CONSTITUTION
        		);
        		dao.saveQuestion(qIC15);

        		Question qIC16 = new Question(
        		    "Which principle divides power between Union and State governments?",
        		    Arrays.asList("Federalism", "Separation of Powers", "Democracy", "Secularism"),
        		    0, // Correct: Federalism
        		    COURSE_INDIAN_CONSTITUTION
        		);
        		dao.saveQuestion(qIC16);

        		Question qIC17 = new Question(
        		    "Which organ of government safeguards fundamental rights?",
        		    Arrays.asList("Judiciary", "Legislature", "Executive", "President"),
        		    0, // Correct: Judiciary
        		    COURSE_INDIAN_CONSTITUTION
        		);
        		dao.saveQuestion(qIC17);

        		Question qIC18 = new Question(
        		    "Which principle ensures courts are free from political influence?",
        		    Arrays.asList("Independent Judiciary", "Rule of Law", "Federalism", "Secularism"),
        		    0, // Correct: Independent Judiciary
        		    COURSE_INDIAN_CONSTITUTION
        		);
        		dao.saveQuestion(qIC18);

        		Question qIC19 = new Question(
        		    "Which principle protects cultural, linguistic, and religious minorities?",
        		    Arrays.asList("Protection of Minorities", "Federalism", "Democracy", "Secularism"),
        		    0, // Correct: Protection of Minorities
        		    COURSE_INDIAN_CONSTITUTION
        		);
        		dao.saveQuestion(qIC19);

        		Question qIC20 = new Question(
        		    "Which principle commits nations to peace and cooperation globally?",
        		    Arrays.asList("International Outlook", "Federalism", "Democracy", "Secularism"),
        		    0, // Correct: International Outlook
        		    COURSE_INDIAN_CONSTITUTION
        		);
        		dao.saveQuestion(qIC20);

        		Question qIC21 = new Question(
        		    "Which principle ensures accountability of government to people?",
        		    Arrays.asList("Sovereignty of the People", "Federalism", "Rule of Law", "Secularism"),
        		    0, // Correct: Sovereignty of the People
        		    COURSE_INDIAN_CONSTITUTION
        		);
        		dao.saveQuestion(qIC21);

        		Question qIC22 = new Question(
        		    "Which principle balances rights and duties of citizens?",
        		    Arrays.asList("Fundamental Duties", "Federalism", "Democracy", "Secularism"),
        		    0, // Correct: Fundamental Duties
        		    COURSE_INDIAN_CONSTITUTION
        		);
        		dao.saveQuestion(qIC22);

        		Question qIC23 = new Question(
        		    "Which principle ensures no one is above the law?",
        		    Arrays.asList("Rule of Law", "Federalism", "Democracy", "Secularism"),
        		    0, // Correct: Rule of Law
        		    COURSE_INDIAN_CONSTITUTION
        		);
        		dao.saveQuestion(qIC23);

        		Question qIC24 = new Question(
        		    "Which principle divides power among Legislature, Executive, and Judiciary?",
        		    Arrays.asList("Separation of Powers", "Federalism", "Democracy", "Secularism"),
        		    0, // Correct: Separation of Powers
        		    COURSE_INDIAN_CONSTITUTION
        		);
        		dao.saveQuestion(qIC24);

        		Question qIC25 = new Question(
        		    "Which principle ensures impartial justice by courts?",
        		    Arrays.asList("Independent Judiciary", "Rule of Law", "Federalism", "Democracy"),
        		    0, // Correct: Independent Judiciary
        		    COURSE_INDIAN_CONSTITUTION
        		);
        		dao.saveQuestion(qIC25);

        		Question qIC26 = new Question(
        		    "Which principle emphasizes reducing inequalities and protecting marginalized groups?",
        		    Arrays.asList("Social and Economic Justice", "Federalism", "Secularism", "Democracy"),
        		    0, // Correct: Social and Economic Justice
        		    COURSE_INDIAN_CONSTITUTION
        		);
        		dao.saveQuestion(qIC26);

        		Question qIC27 = new Question(
        		    "Which principle ensures freedom of belief and expression?",
        		    Arrays.asList("Liberty", "Federalism", "Rule of Law", "Secularism"),
        		    0, // Correct: Liberty
        		    COURSE_INDIAN_CONSTITUTION
        		);
        		dao.saveQuestion(qIC27);

        		Question qIC28 = new Question(
        		    "Which principle ensures harmony in diverse societies?",
        		    Arrays.asList("Secularism", "Federalism", "Democracy", "Rule of Law"),
        		    0, // Correct: Secularism
        		    COURSE_INDIAN_CONSTITUTION
        		);
        		dao.saveQuestion(qIC28);

        		Question qIC29 = new Question(
        		    "Which principle guides the state to promote welfare policies?",
        		    Arrays.asList("Directive Principles of State Policy", "Fundamental Rights", "Fundamental Duties", "Federalism"),
        		    0, // Correct: Directive Principles of State Policy
        		    COURSE_INDIAN_CONSTITUTION
        		);
        		dao.saveQuestion(qIC29);

        		Question qIC30 = new Question(
        		    "Which principle ensures citizens actively contribute to national unity?",
        		    Arrays.asList("Fundamental Duties", "Federalism", "Democracy", "Rule of Law"),
        		    0, // Correct: Fundamental Duties
        		    COURSE_INDIAN_CONSTITUTION
        		);
        		dao.saveQuestion(qIC30);

        		Question qIC31 = new Question(
        		    "Which principle ensures stability while allowing flexibility for progress?",
        		    Arrays.asList("Constitutional Fundamentals", "Federalism", "Democracy", "Secularism"),
        		    0, // Correct: Constitutional Fundamentals
        		    COURSE_INDIAN_CONSTITUTION
        		);
        		dao.saveQuestion(qIC31);

        		Question qIC32 = new Question(
        		    "Which principle ensures government policies reflect the will of the majority?",
        		    Arrays.asList("Sovereignty of the People", "Federalism", "Rule of Law", "Secularism"),
        		    0, // Correct: Sovereignty of the People
        		    COURSE_INDIAN_CONSTITUTION
        		);
        		dao.saveQuestion(qIC32);

        		Question qIC33 = new Question(
        		    "Which principle ensures citizens respect the Constitution?",
        		    Arrays.asList("Fundamental Duties", "Federalism", "Democracy", "Rule of Law"),
        		    0, // Correct: Fundamental Duties
        		    COURSE_INDIAN_CONSTITUTION
        		);
        		dao.saveQuestion(qIC33);

        		Question qIC34 = new Question(
        		    "Which principle ensures protection of cultural and linguistic minorities?",
        		    Arrays.asList("Protection of Minorities", "Federalism", "Democracy", "Secularism"),
        		    0, // Correct: Protection of Minorities
        		    COURSE_INDIAN_CONSTITUTION
        		);
        		dao.saveQuestion(qIC34);

        		Question qIC35 = new Question(
        		    "Which principle ensures impartial interpretation of laws?",
        		    Arrays.asList("Independent Judiciary", "Rule of Law", "Federalism", "Democracy"),
        		    0, // Correct: Independent Judiciary
        		    COURSE_INDIAN_CONSTITUTION
        		);
        		dao.saveQuestion(qIC35);

        		Question qIC36 = new Question(
        		    "Which principle ensures harmony among citizens of different religions?",
        		    Arrays.asList("Secularism", "Federalism", "Democracy", "Rule of Law"),
        		    0, // Correct: Secularism
        		    COURSE_INDIAN_CONSTITUTION
        		);
        		dao.saveQuestion(qIC36);

        		Question qIC37 = new Question(
        		    "Which principle ensures government policies aim at welfare of people?",
        		    Arrays.asList("Directive Principles of State Policy", "Fundamental Rights", "Fundamental Duties", "Federalism"),
        		    0, // Correct: Directive Principles of State Policy
        		    COURSE_INDIAN_CONSTITUTION
        		);
        		dao.saveQuestion(qIC37);

        		Question qIC38 = new Question(
        			    "Which principle ensures citizens protect public property?",
        			    Arrays.asList("Fundamental Duties", "Federalism", "Democracy", "Rule of Law"),
        			    0, // Correct: Fundamental Duties
        			    COURSE_INDIAN_CONSTITUTION
        			);
        			dao.saveQuestion(qIC38);

        			Question qIC39 = new Question(
        			    "Which principle ensures citizens defend the nation?",
        			    Arrays.asList("Fundamental Duties", "Federalism", "Democracy", "Secularism"),
        			    0, // Correct: Fundamental Duties
        			    COURSE_INDIAN_CONSTITUTION
        			);
        			dao.saveQuestion(qIC39);

        			Question qIC40 = new Question(
        			    "Which principle ensures the Constitution acts as the supreme law of the land?",
        			    Arrays.asList("Supremacy of the Constitution", "Federalism", "Democracy", "Rule of Law"),
        			    0, // Correct: Supremacy of the Constitution
        			    COURSE_INDIAN_CONSTITUTION
        			);
        			dao.saveQuestion(qIC40);

        			Question qIC41 = new Question(
        			    "Which article guarantees freedom of speech and expression?",
        			    Arrays.asList("Article 14", "Article 19", "Article 21", "Article 32"),
        			    1, // Correct: Article 19
        			    COURSE_INDIAN_CONSTITUTION
        			);
        			dao.saveQuestion(qIC41);

        			Question qIC42 = new Question(
        			    "Which article provides protection of life and personal liberty?",
        			    Arrays.asList("Article 14", "Article 19", "Article 21", "Article 32"),
        			    2, // Correct: Article 21
        			    COURSE_INDIAN_CONSTITUTION
        			);
        			dao.saveQuestion(qIC42);

        			Question qIC43 = new Question(
        			    "Which article deals with abolition of untouchability?",
        			    Arrays.asList("Article 15", "Article 16", "Article 17", "Article 18"),
        			    2, // Correct: Article 17
        			    COURSE_INDIAN_CONSTITUTION
        			);
        			dao.saveQuestion(qIC43);

        			Question qIC44 = new Question(
        			    "Which article abolishes titles except military and academic distinctions?",
        			    Arrays.asList("Article 17", "Article 18", "Article 19", "Article 20"),
        			    1, // Correct: Article 18
        			    COURSE_INDIAN_CONSTITUTION
        			);
        			dao.saveQuestion(qIC44);

        			Question qIC45 = new Question(
        			    "Which article provides free and compulsory education for children?",
        			    Arrays.asList("Article 19", "Article 21A", "Article 32", "Article 45"),
        			    1, // Correct: Article 21A
        			    COURSE_INDIAN_CONSTITUTION
        			);
        			dao.saveQuestion(qIC45);

        			Question qIC46 = new Question(
        			    "Which article prohibits discrimination on grounds of religion, race, caste, sex, or place of birth?",
        			    Arrays.asList("Article 14", "Article 15", "Article 16", "Article 17"),
        			    1, // Correct: Article 15
        			    COURSE_INDIAN_CONSTITUTION
        			);
        			dao.saveQuestion(qIC46);

        			Question qIC47 = new Question(
        			    "Which article provides equality of opportunity in public employment?",
        			    Arrays.asList("Article 14", "Article 15", "Article 16", "Article 17"),
        			    2, // Correct: Article 16
        			    COURSE_INDIAN_CONSTITUTION
        			);
        			dao.saveQuestion(qIC47);

        			Question qIC48 = new Question(
        			    "Which article provides protection in respect of conviction for offences?",
        			    Arrays.asList("Article 20", "Article 21", "Article 22", "Article 23"),
        			    0, // Correct: Article 20
        			    COURSE_INDIAN_CONSTITUTION
        			);
        			dao.saveQuestion(qIC48);

        			Question qIC49 = new Question(
        			    "Which article provides protection against arrest and detention in certain cases?",
        			    Arrays.asList("Article 20", "Article 21", "Article 22", "Article 23"),
        			    2, // Correct: Article 22
        			    COURSE_INDIAN_CONSTITUTION
        			);
        			dao.saveQuestion(qIC49);

        			Question qIC50 = new Question(
        			    "Which article prohibits traffic in human beings and forced labour?",
        			    Arrays.asList("Article 22", "Article 23", "Article 24", "Article 25"),
        			    1, // Correct: Article 23
        			    COURSE_INDIAN_CONSTITUTION
        			);
        			dao.saveQuestion(qIC50);

        			Question qIC51 = new Question(
        			    "Which article prohibits employment of children in factories?",
        			    Arrays.asList("Article 23", "Article 24", "Article 25", "Article 26"),
        			    1, // Correct: Article 24
        			    COURSE_INDIAN_CONSTITUTION
        			);
        			dao.saveQuestion(qIC51);

        			Question qIC52 = new Question(
        			    "Which article guarantees freedom of conscience and free profession, practice, and propagation of religion?",
        			    Arrays.asList("Article 25", "Article 26", "Article 27", "Article 28"),
        			    0, // Correct: Article 25
        			    COURSE_INDIAN_CONSTITUTION
        			);
        			dao.saveQuestion(qIC52);

        			Question qIC53 = new Question(
        			    "Which article gives freedom to manage religious affairs?",
        			    Arrays.asList("Article 25", "Article 26", "Article 27", "Article 28"),
        			    1, // Correct: Article 26
        			    COURSE_INDIAN_CONSTITUTION
        			);
        			dao.saveQuestion(qIC53);

        			Question qIC54 = new Question(
        			    "Which article provides freedom from payment of taxes for promotion of any religion?",
        			    Arrays.asList("Article 25", "Article 26", "Article 27", "Article 28"),
        			    2, // Correct: Article 27
        			    COURSE_INDIAN_CONSTITUTION
        			);
        			dao.saveQuestion(qIC54);

        			Question qIC55 = new Question(
        			    "Which article provides freedom as to attendance at religious instruction in educational institutions?",
        			    Arrays.asList("Article 25", "Article 26", "Article 27", "Article 28"),
        			    3, // Correct: Article 28
        			    COURSE_INDIAN_CONSTITUTION
        			);
        			dao.saveQuestion(qIC55);

        			Question qIC56 = new Question(
        			    "Which article deals with protection of interests of minorities?",
        			    Arrays.asList("Article 29", "Article 30", "Article 31", "Article 32"),
        			    0, // Correct: Article 29
        			    COURSE_INDIAN_CONSTITUTION
        			);
        			dao.saveQuestion(qIC56);

        			Question qIC57 = new Question(
        			    "Which article gives minorities the right to establish and administer educational institutions?",
        			    Arrays.asList("Article 29", "Article 30", "Article 31", "Article 32"),
        			    1, // Correct: Article 30
        			    COURSE_INDIAN_CONSTITUTION
        			);
        			dao.saveQuestion(qIC57);

        			Question qIC58 = new Question(
        			    "Which article provides the right to constitutional remedies?",
        			    Arrays.asList("Article 32", "Article 33", "Article 34", "Article 35"),
        			    0, // Correct: Article 32
        			    COURSE_INDIAN_CONSTITUTION
        			);
        			dao.saveQuestion(qIC58);

        			Question qIC59 = new Question(
        			    "Which article empowers Parliament to restrict or abrogate fundamental rights during martial law?",
        			    Arrays.asList("Article 33", "Article 34", "Article 35", "Article 36"),
        			    1, // Correct: Article 34
        			    COURSE_INDIAN_CONSTITUTION
        			);
        			dao.saveQuestion(qIC59);

        			Question qIC60 = new Question(
        			    "Which article empowers Parliament to make laws to give effect to fundamental rights?",
        			    Arrays.asList("Article 32", "Article 33", "Article 34", "Article 35"),
        			    3, // Correct: Article 35
        			    COURSE_INDIAN_CONSTITUTION
        			);
        			dao.saveQuestion(qIC60);

        			Question qIC61 = new Question(
        			    "Which article deals with the uniform civil code?",
        			    Arrays.asList("Article 44", "Article 45", "Article 46", "Article 47"),
        			    0, // Correct: Article 44
        			    COURSE_INDIAN_CONSTITUTION
        			);
        			dao.saveQuestion(qIC61);

        			Question qIC62 = new Question(
        			    "Which article directs the State to promote educational and economic interests of weaker sections?",
        			    Arrays.asList("Article 45", "Article 46", "Article 47", "Article 48"),
        			    1, // Correct: Article 46
        			    COURSE_INDIAN_CONSTITUTION
        			);
        			dao.saveQuestion(qIC62);

        			Question qIC63 = new Question(
        			    "Which article directs the State to raise the level of nutrition and standard of living?",
        			    Arrays.asList("Article 45", "Article 46", "Article 47", "Article 48"),
        			    2, // Correct: Article 47
        			    COURSE_INDIAN_CONSTITUTION
        			);
        			dao.saveQuestion(qIC63);

        			Question qIC64 = new Question(
        			    "Which article directs the State to organize agriculture and animal husbandry on modern lines?",
        			    Arrays.asList("Article 47", "Article 48", "Article 49", "Article 50"),
        			    1, // Correct: Article 48
        			    COURSE_INDIAN_CONSTITUTION
        			);
        			dao.saveQuestion(qIC64);
        			Question qIC65 = new Question(
        				    "Which article directs the State to raise the level of nutrition and standard of living?",
        				    Arrays.asList("Article 45", "Article 46", "Article 47", "Article 48"),
        				    2, // Correct: Article 47
        				    COURSE_INDIAN_CONSTITUTION
        				);
        				dao.saveQuestion(qIC65);

        				Question qIC66 = new Question(
        				    "Which article directs the State to organize agriculture and animal husbandry on modern lines?",
        				    Arrays.asList("Article 47", "Article 48", "Article 49", "Article 50"),
        				    1, // Correct: Article 48
        				    COURSE_INDIAN_CONSTITUTION
        				);
        				dao.saveQuestion(qIC66);

        				Question qIC67 = new Question(
        				    "Which article protects monuments and places of national importance?",
        				    Arrays.asList("Article 48", "Article 49", "Article 50", "Article 51"),
        				    1, // Correct: Article 49
        				    COURSE_INDIAN_CONSTITUTION
        				);
        				dao.saveQuestion(qIC67);

        				Question qIC68 = new Question(
        				    "Which article separates the judiciary from the executive?",
        				    Arrays.asList("Article 49", "Article 50", "Article 51", "Article 52"),
        				    1, // Correct: Article 50
        				    COURSE_INDIAN_CONSTITUTION
        				);
        				dao.saveQuestion(qIC68);

        				Question qIC69 = new Question(
        				    "Which article promotes international peace and security?",
        				    Arrays.asList("Article 50", "Article 51", "Article 52", "Article 53"),
        				    1, // Correct: Article 51
        				    COURSE_INDIAN_CONSTITUTION
        				);
        				dao.saveQuestion(qIC69);

        				Question qIC70 = new Question(
        				    "Which article establishes the office of the President of India?",
        				    Arrays.asList("Article 51", "Article 52", "Article 53", "Article 54"),
        				    1, // Correct: Article 52
        				    COURSE_INDIAN_CONSTITUTION
        				);
        				dao.saveQuestion(qIC70);

        				Question qIC71 = new Question(
        				    "Which article vests executive power of the Union in the President?",
        				    Arrays.asList("Article 52", "Article 53", "Article 54", "Article 55"),
        				    1, // Correct: Article 53
        				    COURSE_INDIAN_CONSTITUTION
        				);
        				dao.saveQuestion(qIC71);

        				Question qIC72 = new Question(
        				    "Which article deals with the election of the President?",
        				    Arrays.asList("Article 53", "Article 54", "Article 55", "Article 56"),
        				    1, // Correct: Article 54
        				    COURSE_INDIAN_CONSTITUTION
        				);
        				dao.saveQuestion(qIC72);

        				Question qIC73 = new Question(
        				    "Which article deals with the manner of election of the President?",
        				    Arrays.asList("Article 54", "Article 55", "Article 56", "Article 57"),
        				    1, // Correct: Article 55
        				    COURSE_INDIAN_CONSTITUTION
        				);
        				dao.saveQuestion(qIC73);

        				Question qIC74 = new Question(
        				    "Which article deals with the term of office of the President?",
        				    Arrays.asList("Article 55", "Article 56", "Article 57", "Article 58"),
        				    1, // Correct: Article 56
        				    COURSE_INDIAN_CONSTITUTION
        				);
        				dao.saveQuestion(qIC74);

        				Question qIC75 = new Question(
        				    "Which article deals with the eligibility for re-election of the President?",
        				    Arrays.asList("Article 56", "Article 57", "Article 58", "Article 59"),
        				    1, // Correct: Article 57
        				    COURSE_INDIAN_CONSTITUTION
        				);
        				dao.saveQuestion(qIC75);

        				Question qIC76 = new Question(
        				    "Which article deals with the qualifications for election as President?",
        				    Arrays.asList("Article 57", "Article 58", "Article 59", "Article 60"),
        				    1, // Correct: Article 58
        				    COURSE_INDIAN_CONSTITUTION
        				);
        				dao.saveQuestion(qIC76);

        				Question qIC77 = new Question(
        				    "Which article deals with the conditions of President’s office?",
        				    Arrays.asList("Article 58", "Article 59", "Article 60", "Article 61"),
        				    1, // Correct: Article 59
        				    COURSE_INDIAN_CONSTITUTION
        				);
        				dao.saveQuestion(qIC77);

        				Question qIC78 = new Question(
        				    "Which article deals with the oath or affirmation by the President?",
        				    Arrays.asList("Article 59", "Article 60", "Article 61", "Article 62"),
        				    1, // Correct: Article 60
        				    COURSE_INDIAN_CONSTITUTION
        				);
        				dao.saveQuestion(qIC78);

        				Question qIC79 = new Question(
        				    "Which article deals with the procedure for impeachment of the President?",
        				    Arrays.asList("Article 60", "Article 61", "Article 62", "Article 63"),
        				    1, // Correct: Article 61
        				    COURSE_INDIAN_CONSTITUTION
        				);
        				dao.saveQuestion(qIC79);

        				Question qIC80 = new Question(
        				    "Which article deals with the time of holding election to fill the vacancy in the office of President?",
        				    Arrays.asList("Article 61", "Article 62", "Article 63", "Article 64"),
        				    1, // Correct: Article 62
        				    COURSE_INDIAN_CONSTITUTION
        				);
        				dao.saveQuestion(qIC80);
        				Question qIC81 = new Question(
        					    "Which article of the Indian Constitution deals with the impeachment of the President?",
        					    Arrays.asList("Article 61", "Article 62", "Article 63", "Article 64"),
        					    0, // Correct: Article 61
        					    COURSE_INDIAN_CONSTITUTION
        					);
        					dao.saveQuestion(qIC81);

        					Question qIC82 = new Question(
        					    "Which article provides that India shall be a Union of States?",
        					    Arrays.asList("Article 1", "Article 2", "Article 3", "Article 4"),
        					    0, // Correct: Article 1
        					    COURSE_INDIAN_CONSTITUTION
        					);
        					dao.saveQuestion(qIC82);

        					Question qIC83 = new Question(
        					    "Which article of the Constitution deals with the Fundamental Duties?",
        					    Arrays.asList("Article 51A", "Article 52", "Article 53", "Article 54"),
        					    0, // Correct: Article 51A
        					    COURSE_INDIAN_CONSTITUTION
        					);
        					dao.saveQuestion(qIC83);

        					Question qIC84 = new Question(
        					    "Which article of the Constitution deals with the Directive Principles of State Policy?",
        					    Arrays.asList("Article 36", "Article 37", "Article 38", "Article 39"),
        					    1, // Correct: Article 37
        					    COURSE_INDIAN_CONSTITUTION
        					);
        					dao.saveQuestion(qIC84);

        					Question qIC85 = new Question(
        					    "Which article of the Constitution deals with the Council of Ministers headed by the Prime Minister?",
        					    Arrays.asList("Article 74", "Article 75", "Article 76", "Article 77"),
        					    0, // Correct: Article 74
        					    COURSE_INDIAN_CONSTITUTION
        					);
        					dao.saveQuestion(qIC85);

        					Question qIC86 = new Question(
        					    "Which article of the Constitution deals with the Supreme Court of India?",
        					    Arrays.asList("Article 124", "Article 125", "Article 126", "Article 127"),
        					    0, // Correct: Article 124
        					    COURSE_INDIAN_CONSTITUTION
        					);
        					dao.saveQuestion(qIC86);

        					Question qIC87 = new Question(
        					    "Which article of the Constitution deals with the Finance Commission?",
        					    Arrays.asList("Article 280", "Article 281", "Article 282", "Article 283"),
        					    0, // Correct: Article 280
        					    COURSE_INDIAN_CONSTITUTION
        					);
        					dao.saveQuestion(qIC87);

        					Question qIC88 = new Question(
        					    "Which article of the Constitution deals with the Election Commission?",
        					    Arrays.asList("Article 324", "Article 325", "Article 326", "Article 327"),
        					    0, // Correct: Article 324
        					    COURSE_INDIAN_CONSTITUTION
        					);
        					dao.saveQuestion(qIC88);

        					Question qIC89 = new Question(
        					    "Which article of the Constitution deals with the official language of the Union?",
        					    Arrays.asList("Article 343", "Article 344", "Article 345", "Article 346"),
        					    0, // Correct: Article 343
        					    COURSE_INDIAN_CONSTITUTION
        					);
        					dao.saveQuestion(qIC89);

        					Question qIC90 = new Question(
        					    "Which article of the Constitution deals with the amendment procedure?",
        					    Arrays.asList("Article 368", "Article 369", "Article 370", "Article 371"),
        					    0, // Correct: Article 368
        					    COURSE_INDIAN_CONSTITUTION
        					);
        					dao.saveQuestion(qIC90);
        					Question qIC91 = new Question(
        						    "The _________ article of the Constitution deals with the impeachment of the President.",
        						    Arrays.asList("61", "62", "63", "64"),
        						    0,
        						    COURSE_INDIAN_CONSTITUTION
        						);
        						dao.saveQuestion(qIC91);

        						Question qIC92 = new Question(
        						    "India shall be a Union of States as per Article _________.",
        						    Arrays.asList("1", "2", "3", "4"),
        						    0,
        						    COURSE_INDIAN_CONSTITUTION
        						);
        						dao.saveQuestion(qIC92);

        						Question qIC93 = new Question(
        						    "Fundamental Duties are mentioned in Article _________.",
        						    Arrays.asList("51A", "52", "53", "54"),
        						    0,
        						    COURSE_INDIAN_CONSTITUTION
        						);
        						dao.saveQuestion(qIC93);

        						Question qIC94 = new Question(
        						    "Directive Principles of State Policy are mentioned in Article _________.",
        						    Arrays.asList("37", "38", "39", "40"),
        						    0,
        						    COURSE_INDIAN_CONSTITUTION
        						);
        						dao.saveQuestion(qIC94);

        						Question qIC95 = new Question(
        						    "The Council of Ministers headed by the Prime Minister is mentioned in Article _________.",
        						    Arrays.asList("74", "75", "76", "77"),
        						    0,
        						    COURSE_INDIAN_CONSTITUTION
        						);
        						dao.saveQuestion(qIC95);

        						Question qIC96 = new Question(
        						    "The Supreme Court of India is established under Article _________.",
        						    Arrays.asList("124", "125", "126", "127"),
        						    0,
        						    COURSE_INDIAN_CONSTITUTION
        						);
        						dao.saveQuestion(qIC96);

        						Question qIC97 = new Question(
        						    "The Finance Commission is constituted under Article _________.",
        						    Arrays.asList("280", "281", "282", "283"),
        						    0,
        						    COURSE_INDIAN_CONSTITUTION
        						);
        						dao.saveQuestion(qIC97);

        						Question qIC98 = new Question(
        						    "The Election Commission is mentioned in Article _________.",
        						    Arrays.asList("324", "325", "326", "327"),
        						    0,
        						    COURSE_INDIAN_CONSTITUTION
        						);
        						dao.saveQuestion(qIC98);

        						Question qIC99 = new Question(
        						    "The official language of the Union is mentioned in Article _________.",
        						    Arrays.asList("343", "344", "345", "346"),
        						    0,
        						    COURSE_INDIAN_CONSTITUTION
        						);
        						dao.saveQuestion(qIC99);

        						Question qIC100 = new Question(
        						    "The procedure for amendment of the Constitution is laid down in Article _________.",
        						    Arrays.asList("368", "369", "370", "371"),
        						    0,
        						    COURSE_INDIAN_CONSTITUTION
        						);
        						dao.saveQuestion(qIC100);

        // ----------------------------------------------------------
        //                Core Java Questions (Example)
        // ----------------------------------------------------------
        System.out.println("Initializing Core Java Questions...");

        // Q_J1
        Question qJ1 = new Question(
        	    "Which component is responsible for converting Java bytecode into machine code at runtime?",
        	    Arrays.asList("JVM", "JRE", "JIT Compiler", "JDK"),
        	    2, // Correct: JIT Compiler
        	    COURSE_JAVA
        	);
        	dao.saveQuestion(qJ1);

        	Question qJ2 = new Question(
        	    "Which component executes Java bytecode?",
        	    Arrays.asList("JVM", "JDK", "Compiler", "Operating System"),
        	    0, // Correct: JVM
        	    COURSE_JAVA
        	);
        	dao.saveQuestion(qJ2);

        	Question qJ3 = new Question(
        	    "Which keyword is used to define a class in Java?",
        	    Arrays.asList("class", "object", "define", "new"),
        	    0, // Correct: class
        	    COURSE_JAVA
        	);
        	dao.saveQuestion(qJ3);

        	Question qJ4 = new Question(
        	    "Which of the following is NOT a primitive data type in Java?",
        	    Arrays.asList("int", "String", "boolean", "double"),
        	    1, // Correct: String
        	    COURSE_JAVA
        	);
        	dao.saveQuestion(qJ4);

        	Question qJ5 = new Question(
        	    "Which operator is used for logical AND in Java?",
        	    Arrays.asList("&&", "||", "!", "&"),
        	    0, // Correct: &&
        	    COURSE_JAVA
        	);
        	dao.saveQuestion(qJ5);

        	Question qJ6 = new Question(
        	    "Which feature of Java makes it platform-independent?",
        	    Arrays.asList("Bytecode", "Compiler", "JVM", "Garbage Collection"),
        	    0, // Correct: Bytecode
        	    COURSE_JAVA
        	);
        	dao.saveQuestion(qJ6);

        	Question qJ7 = new Question(
        	    "Which keyword is used to create an object in Java?",
        	    Arrays.asList("new", "class", "object", "create"),
        	    0, // Correct: new
        	    COURSE_JAVA
        	);
        	dao.saveQuestion(qJ7);

        	Question qJ8 = new Question(
        	    "Which method is the entry point of a Java program?",
        	    Arrays.asList("main()", "start()", "run()", "init()"),
        	    0, // Correct: main()
        	    COURSE_JAVA
        	);
        	dao.saveQuestion(qJ8);

        	Question qJ9 = new Question(
        	    "Which package contains fundamental classes like String and Object?",
        	    Arrays.asList("java.lang", "java.util", "java.io", "java.sql"),
        	    0, // Correct: java.lang
        	    COURSE_JAVA
        	);
        	dao.saveQuestion(qJ9);

        	Question qJ10 = new Question(
        	    "Which keyword is used to define a constant in Java?",
        	    Arrays.asList("final", "const", "static", "immutable"),
        	    0, // Correct: final
        	    COURSE_JAVA
        	);
        	dao.saveQuestion(qJ10);

        	Question qJ11 = new Question(
        	    "Which keyword is used to inherit a class in Java?",
        	    Arrays.asList("extends", "implements", "inherits", "super"),
        	    0, // Correct: extends
        	    COURSE_JAVA
        	);
        	dao.saveQuestion(qJ11);

        	Question qJ12 = new Question(
        	    "Which keyword is used to implement an interface?",
        	    Arrays.asList("extends", "implements", "interface", "inherit"),
        	    1, // Correct: implements
        	    COURSE_JAVA
        	);
        	dao.saveQuestion(qJ12);

        	Question qJ13 = new Question(
        	    "Which access modifier makes a member visible only within the same class?",
        	    Arrays.asList("private", "public", "protected", "default"),
        	    0, // Correct: private
        	    COURSE_JAVA
        	);
        	dao.saveQuestion(qJ13);

        	Question qJ14 = new Question(
        	    "Which OOP concept allows the same method name with different implementations?",
        	    Arrays.asList("Polymorphism", "Inheritance", "Encapsulation", "Abstraction"),
        	    0, // Correct: Polymorphism
        	    COURSE_JAVA
        	);
        	dao.saveQuestion(qJ14);

        	Question qJ15 = new Question(
        	    "Which OOP principle hides implementation details?",
        	    Arrays.asList("Abstraction", "Encapsulation", "Inheritance", "Polymorphism"),
        	    0, // Correct: Abstraction
        	    COURSE_JAVA
        	);
        	dao.saveQuestion(qJ15);

        	Question qJ16 = new Question(
        	    "Which OOP concept allows code reuse through hierarchy?",
        	    Arrays.asList("Inheritance", "Polymorphism", "Encapsulation", "Abstraction"),
        	    0, // Correct: Inheritance
        	    COURSE_JAVA
        	);
        	dao.saveQuestion(qJ16);

        	Question qJ17 = new Question(
        	    "Which keyword is used to call the parent class constructor?",
        	    Arrays.asList("super", "this", "parent", "base"),
        	    0, // Correct: super
        	    COURSE_JAVA
        	);
        	dao.saveQuestion(qJ17);

        	Question qJ18 = new Question(
        	    "Which keyword is used to prevent inheritance?",
        	    Arrays.asList("final", "static", "private", "sealed"),
        	    0, // Correct: final
        	    COURSE_JAVA
        	);
        	dao.saveQuestion(qJ18);

        	Question qJ19 = new Question(
        	    "Which keyword is used to define an abstract class?",
        	    Arrays.asList("abstract", "interface", "virtual", "base"),
        	    0, // Correct: abstract
        	    COURSE_JAVA
        	);
        	dao.saveQuestion(qJ19);

        	Question qJ20 = new Question(
        	    "Which keyword is used to define an interface?",
        	    Arrays.asList("interface", "abstract", "class", "implements"),
        	    0, // Correct: interface
        	    COURSE_JAVA
        	);
        	dao.saveQuestion(qJ20);
        	Question qJ21 = new Question(
        		    "Which interface allows duplicate elements and maintains order?",
        		    Arrays.asList("List", "Set", "Map", "Queue"),
        		    0, // Correct: List
        		    COURSE_JAVA
        		);
        		dao.saveQuestion(qJ21);

        		Question qJ22 = new Question(
        		    "Which collection does not allow duplicate elements?",
        		    Arrays.asList("Set", "List", "Map", "ArrayList"),
        		    0, // Correct: Set
        		    COURSE_JAVA
        		);
        		dao.saveQuestion(qJ22);

        		Question qJ23 = new Question(
        		    "Which class implements a dynamic array?",
        		    Arrays.asList("ArrayList", "LinkedList", "HashSet", "TreeSet"),
        		    0, // Correct: ArrayList
        		    COURSE_JAVA
        		);
        		dao.saveQuestion(qJ23);

        		Question qJ24 = new Question(
        		    "Which collection stores key-value pairs?",
        		    Arrays.asList("Map", "List", "Set", "Queue"),
        		    0, // Correct: Map
        		    COURSE_JAVA
        		);
        		dao.saveQuestion(qJ24);

        		Question qJ25 = new Question(
        		    "Which utility class provides methods like sort() and shuffle()?",
        		    Arrays.asList("Collections", "Arrays", "List", "HashMap"),
        		    0, // Correct: Collections
        		    COURSE_JAVA
        		);
        		dao.saveQuestion(qJ25);

        		Question qJ26 = new Question(
        		    "Which class is used to represent mutable strings?",
        		    Arrays.asList("StringBuilder", "StringBuffer", "String", "CharSequence"),
        		    0, // Correct: StringBuilder
        		    COURSE_JAVA
        		);
        		dao.saveQuestion(qJ26);

        		Question qJ27 = new Question(
        		    "Which class is thread-safe for mutable strings?",
        		    Arrays.asList("StringBuilder", "StringBuffer", "String", "CharSequence"),
        		    1, // Correct: StringBuffer
        		    COURSE_JAVA
        		);
        		dao.saveQuestion(qJ27);

        		Question qJ28 = new Question(
        		    "Which method is used to compare two strings ignoring case?",
        		    Arrays.asList("equals()", "equalsIgnoreCase()", "compareTo()", "=="),
        		    1, // Correct: equalsIgnoreCase()
        		    COURSE_JAVA
        		);
        		dao.saveQuestion(qJ28);

        		Question qJ29 = new Question(
        		    "Which method is used to find the length of a string?",
        		    Arrays.asList("length()", "size()", "count()", "getLength()"),
        		    0, // Correct: length()
        		    COURSE_JAVA
        		);
        		dao.saveQuestion(qJ29);

        		Question qJ30 = new Question(
        		    "Which method is used to convert a string to uppercase?",
        		    Arrays.asList("toUpperCase()", "upper()", "convertUpper()", "makeUpper()"),
        		    0, // Correct: toUpperCase()
        		    COURSE_JAVA
        		);
        		dao.saveQuestion(qJ30);

        		Question qJ31 = new Question(
        		    "Which method is used to split a string?",
        		    Arrays.asList("split()", "divide()", "tokenize()", "break()"),
        		    0, // Correct: split()
        		    COURSE_JAVA
        		);
        		dao.saveQuestion(qJ31);

        		Question qJ32 = new Question(
        		    "Which method is used to remove leading and trailing spaces?",
        		    Arrays.asList("trim()", "strip()", "clean()", "removeSpaces()"),
        		    0, // Correct: trim()
        		    COURSE_JAVA
        		);
        		dao.saveQuestion(qJ32);

        		Question qJ33 = new Question(
        		    "Which method is used to check if a string starts with a prefix?",
        		    Arrays.asList("startsWith()", "begins()", "prefix()", "checkStart()"),
        		    0, // Correct: startsWith()
        		    COURSE_JAVA
        		);
        		dao.saveQuestion(qJ33);

        		Question qJ34 = new Question(
        		    "Which method is used to check if a string ends with a suffix?",
        		    Arrays.asList("endsWith()", "finish()", "suffix()", "checkEnd()"),
        		    0, // Correct: endsWith()
        		    COURSE_JAVA
        		);
        		dao.saveQuestion(qJ34);

        		Question qJ35 = new Question(
        		    "Which method is used to replace characters in a string?",
        		    Arrays.asList("replace()", "change()", "substitute()", "modify()"),
        		    0, // Correct: replace()
        		    COURSE_JAVA
        		);
        		dao.saveQuestion(qJ35);

        		Question qJ36 = new Question(
        		    "Which method is used to convert a string to a character array?",
        		    Arrays.asList("toCharArray()", "getChars()", "splitChars()", "convertChars()"),
        		    0, // Correct: toCharArray()
        		    COURSE_JAVA
        		);
        		dao.saveQuestion(qJ36);

        		Question qJ37 = new Question(
        		    "Which method is used to parse a string into an integer?",
        		    Arrays.asList("Integer.parseInt()", "Integer.valueOf()", "parseInt()", "toInt()"),
        		    0, // Correct: Integer.parseInt()
        		    COURSE_JAVA
        		);
        		dao.saveQuestion(qJ37);

        		Question qJ38 = new Question(
        		    "Which method is used to parse a string into a double?",
        		    Arrays.asList("Double.parseDouble()", "Double.valueOf()", "parseDouble()", "toDouble()"),
        		    0, // Correct: Double.parseDouble()
        		    COURSE_JAVA
        		);
        		dao.saveQuestion(qJ38);

        		Question qJ39 = new Question(
        		    "Which method is used to convert an integer to a string?",
        		    Arrays.asList("String.valueOf()", "Integer.toString()", "toString()", "convertString()"),
        		    0, // Correct: String.valueOf()
        		    COURSE_JAVA
        		);
        		dao.saveQuestion(qJ39);

        		Question qJ40 = new Question(
        		    "Which method is used to convert a string to lowercase?",
        		    Arrays.asList("toLowerCase()", "lower()", "convertLower()", "makeLower()"),
        		    0, // Correct: toLowerCase()
        		    COURSE_JAVA
        		);
        		dao.saveQuestion(qJ40);
        		Question qJ41 = new Question(
        			    "Which keyword is used to handle exceptions?",
        			    Arrays.asList("try", "catch", "throw", "throws"),
        			    0, // Correct: try
        			    COURSE_JAVA
        			);
        			dao.saveQuestion(qJ41);

        			Question qJ42 = new Question(
        			    "Which keyword is used to declare an exception?",
        			    Arrays.asList("throw", "throws", "catch", "try"),
        			    1, // Correct: throws
        			    COURSE_JAVA
        			);
        			dao.saveQuestion(qJ42);

        			Question qJ43 = new Question(
        			    "Which keyword is used to explicitly raise an exception?",
        			    Arrays.asList("throw", "throws", "raise", "error"),
        			    0, // Correct: throw
        			    COURSE_JAVA
        			);
        			dao.saveQuestion(qJ43);

        			Question qJ44 = new Question(
        			    "Which block always executes whether an exception occurs or not?",
        			    Arrays.asList("finally", "catch", "throw", "try"),
        			    0, // Correct: finally
        			    COURSE_JAVA
        			);
        			dao.saveQuestion(qJ44);

        			Question qJ45 = new Question(
        			    "Which class is the superclass of all exceptions?",
        			    Arrays.asList("Throwable", "Exception", "Error", "RuntimeException"),
        			    0, // Correct: Throwable
        			    COURSE_JAVA
        			);
        			dao.saveQuestion(qJ45);

        			Question qJ46 = new Question(
        			    "Which method starts a thread in Java?",
        			    Arrays.asList("start()", "run()", "execute()", "begin()"),
        			    0, // Correct: start()
        			    COURSE_JAVA
        			);
        			dao.saveQuestion(qJ46);

        			Question qJ47 = new Question(
        			    "Which method is executed when a thread is started?",
        			    Arrays.asList("start()", "run()", "execute()", "begin()"),
        			    1, // Correct: run()
        			    COURSE_JAVA
        			);
        			dao.saveQuestion(qJ47);

        			Question qJ48 = new Question(
        			    "Which interface must be implemented to create a thread?",
        			    Arrays.asList("Runnable", "Thread", "Callable", "Executor"),
        			    0, // Correct: Runnable
        			    COURSE_JAVA
        			);
        			dao.saveQuestion(qJ48);

        			Question qJ49 = new Question(
        			    "Which class is used to create a thread directly?",
        			    Arrays.asList("Thread", "Runnable", "Executor", "Future"),
        			    0, // Correct: Thread
        			    COURSE_JAVA
        			);
        			dao.saveQuestion(qJ49);

        			Question qJ50 = new Question(
        			    "Which method pauses a thread for a specified time?",
        			    Arrays.asList("sleep()", "wait()", "pause()", "delay()"),
        			    0, // Correct: sleep()
        			    COURSE_JAVA
        			);
        			dao.saveQuestion(qJ50);

        			Question qJ51 = new Question(
        			    "Which method waits until another thread completes?",
        			    Arrays.asList("join()", "wait()", "sleep()", "notify()"),
        			    0, // Correct: join()
        			    COURSE_JAVA
        			);
        			dao.saveQuestion(qJ51);

        			Question qJ52 = new Question(
        			    "Which method wakes up a waiting thread?",
        			    Arrays.asList("notify()", "wake()", "resume()", "start()"),
        			    0, // Correct: notify()
        			    COURSE_JAVA
        			);
        			dao.saveQuestion(qJ52);

        			Question qJ53 = new Question(
        			    "Which method wakes up all waiting threads?",
        			    Arrays.asList("notifyAll()", "wakeAll()", "resumeAll()", "startAll()"),
        			    0, // Correct: notifyAll()
        			    COURSE_JAVA
        			);
        			dao.saveQuestion(qJ53);

        			Question qJ54 = new Question(
        			    "Which method releases the lock and waits?",
        			    Arrays.asList("wait()", "sleep()", "join()", "pause()"),
        			    0, // Correct: wait()
        			    COURSE_JAVA
        			);
        			dao.saveQuestion(qJ54);

        			Question qJ55 = new Question(
        			    "Which keyword ensures only one thread can access a block at a time?",
        			    Arrays.asList("synchronized", "volatile", "static", "final"),
        			    0, // Correct: synchronized
        			    COURSE_JAVA
        			);
        			dao.saveQuestion(qJ55);

        			Question qJ56 = new Question(
        			    "Which keyword ensures a variable is read from main memory?",
        			    Arrays.asList("volatile", "synchronized", "final", "transient"),
        			    0, // Correct: volatile
        			    COURSE_JAVA
        			);
        			dao.saveQuestion(qJ56);

        			Question qJ57 = new Question(
        			    "Which class is used for thread-safe collections?",
        			    Arrays.asList("ConcurrentHashMap", "HashMap", "TreeMap", "Hashtable"),
        			    0, // Correct: ConcurrentHashMap
        			    COURSE_JAVA
        			);
        			dao.saveQuestion(qJ57);

        			Question qJ58 = new Question(
        			    "Which interface is used for tasks that return results?",
        			    Arrays.asList("Callable", "Runnable", "Future", "Executor"),
        			    0, // Correct: Callable
        			    COURSE_JAVA
        			);
        			dao.saveQuestion(qJ58);

        			Question qJ59 = new Question(
        			    "Which interface is used for tasks that do not return results?",
        			    Arrays.asList("Runnable", "Callable", "Future", "Executor"),
        			    0, // Correct: Runnable
        			    COURSE_JAVA
        			);
        			dao.saveQuestion(qJ59);

        			
        			Question qJ60 = new Question(
        				    "Which class provides thread pool management?",
        				    Arrays.asList("ExecutorService", "ThreadPool", "FutureTask", "Scheduler"),
        				    0, // Correct: ExecutorService
        				    COURSE_JAVA
        				);
        				dao.saveQuestion(qJ60);

        				Question qJ61 = new Question(
        				    "Which package provides JDBC classes?",
        				    Arrays.asList("java.sql", "java.util", "java.io", "java.net"),
        				    0, // Correct: java.sql
        				    COURSE_JAVA
        				);
        				dao.saveQuestion(qJ61);

        				Question qJ62 = new Question(
        				    "Which interface is used to execute SQL queries?",
        				    Arrays.asList("Statement", "PreparedStatement", "ResultSet", "Connection"),
        				    0, // Correct: Statement
        				    COURSE_JAVA
        				);
        				dao.saveQuestion(qJ62);

        				Question qJ63 = new Question(
        				    "Which interface is used for precompiled SQL queries?",
        				    Arrays.asList("Statement", "PreparedStatement", "CallableStatement", "ResultSet"),
        				    1, // Correct: PreparedStatement
        				    COURSE_JAVA
        				);
        				dao.saveQuestion(qJ63);

        				Question qJ64 = new Question(
        				    "Which interface is used to call stored procedures?",
        				    Arrays.asList("CallableStatement", "PreparedStatement", "Statement", "ResultSet"),
        				    0, // Correct: CallableStatement
        				    COURSE_JAVA
        				);
        				dao.saveQuestion(qJ64);

        				Question qJ65 = new Question(
        				    "Which interface represents the result of a query?",
        				    Arrays.asList("ResultSet", "Statement", "PreparedStatement", "Connection"),
        				    0, // Correct: ResultSet
        				    COURSE_JAVA
        				);
        				dao.saveQuestion(qJ65);

        				Question qJ66 = new Question(
        				    "Which method moves the cursor to the next row in ResultSet?",
        				    Arrays.asList("next()", "move()", "advance()", "forward()"),
        				    0, // Correct: next()
        				    COURSE_JAVA
        				);
        				dao.saveQuestion(qJ66);

        				Question qJ67 = new Question(
        				    "Which method closes a JDBC connection?",
        				    Arrays.asList("close()", "disconnect()", "end()", "terminate()"),
        				    0, // Correct: close()
        				    COURSE_JAVA
        				);
        				dao.saveQuestion(qJ67);

        				Question qJ68 = new Question(
        				    "Which feature of Java 8 allows functional programming?",
        				    Arrays.asList("Lambda Expressions", "Streams", "Optional", "All of the above"),
        				    3, // Correct: All of the above
        				    COURSE_JAVA
        				);
        				dao.saveQuestion(qJ68);

        				Question qJ69 = new Question(
        				    "Which Java 8 feature is used to process collections in a functional style?",
        				    Arrays.asList("Streams", "Lambda", "Optional", "Collectors"),
        				    0, // Correct: Streams
        				    COURSE_JAVA
        				);
        				dao.saveQuestion(qJ69);

        				Question qJ70 = new Question(
        				    "Which Java 8 feature provides a container for null values?",
        				    Arrays.asList("Optional", "Stream", "Lambda", "Collector"),
        				    0, // Correct: Optional
        				    COURSE_JAVA
        				);
        				dao.saveQuestion(qJ70);

        				Question qJ71 = new Question(
        				    "Which method in Optional returns a value if present, else a default?",
        				    Arrays.asList("orElse()", "get()", "ifPresent()", "isPresent()"),
        				    0, // Correct: orElse()
        				    COURSE_JAVA
        				);
        				dao.saveQuestion(qJ71);

        				Question qJ72 = new Question(
        				    "Which method in Stream is used to filter elements?",
        				    Arrays.asList("filter()", "map()", "reduce()", "collect()"),
        				    0, // Correct: filter()
        				    COURSE_JAVA
        				);
        				dao.saveQuestion(qJ72);

        				Question qJ73 = new Question(
        				    "Which method in Stream is used to transform elements?",
        				    Arrays.asList("map()", "filter()", "reduce()", "collect()"),
        				    0, // Correct: map()
        				    COURSE_JAVA
        				);
        				dao.saveQuestion(qJ73);

        				Question qJ74 = new Question(
        				    "Which method in Stream is used to reduce elements to a single value?",
        				    Arrays.asList("reduce()", "map()", "filter()", "collect()"),
        				    0, // Correct: reduce()
        				    COURSE_JAVA
        				);
        				dao.saveQuestion(qJ74);

        				Question qJ75 = new Question(
        				    "Which method in Stream is used to collect results?",
        				    Arrays.asList("collect()", "reduce()", "map()", "filter()"),
        				    0, // Correct: collect()
        				    COURSE_JAVA
        				);
        				dao.saveQuestion(qJ75);

        				Question qJ76 = new Question(
        				    "Which functional interface represents a function that takes one argument and returns a result?",
        				    Arrays.asList("Function", "Consumer", "Supplier", "Predicate"),
        				    0, // Correct: Function
        				    COURSE_JAVA
        				);
        				dao.saveQuestion(qJ76);

        				Question qJ77 = new Question(
        				    "Which functional interface represents a function that takes one argument and returns boolean?",
        				    Arrays.asList("Predicate", "Function", "Consumer", "Supplier"),
        				    0, // Correct: Predicate
        				    COURSE_JAVA
        				);
        				dao.saveQuestion(qJ77);

        				Question qJ78 = new Question(
        				    "Which functional interface represents a function that consumes a value but returns nothing?",
        				    Arrays.asList("Consumer", "Supplier", "Function", "Predicate"),
        				    0, // Correct: Consumer
        				    COURSE_JAVA
        				);
        				dao.saveQuestion(qJ78);

        				Question qJ79 = new Question(
        				    "Which functional interface represents a function that supplies a value?",
        				    Arrays.asList("Supplier", "Consumer", "Function", "Predicate"),
        				    0, // Correct: Supplier
        				    COURSE_JAVA
        				);
        				dao.saveQuestion(qJ79);

        				Question qJ80 = new Question(
        				    "Which Java keyword is used to define a package?",
        				    Arrays.asList("package", "import", "namespace", "module"),
        				    0, // Correct: package
        				    COURSE_JAVA
        				);
        				dao.saveQuestion(qJ80);
        				Question qJ81 = new Question(
        					    "Which keyword in Java is used to inherit a class?",
        					    Arrays.asList("extends", "implements", "inherits", "super"),
        					    0, // Correct: extends
        					    COURSE_JAVA
        					);
        					dao.saveQuestion(qJ81);

        					Question qJ82 = new Question(
        					    "Which of the following is not a primitive data type in Java?",
        					    Arrays.asList("int", "float", "boolean", "String"),
        					    3, // Correct: String
        					    COURSE_JAVA
        					);
        					dao.saveQuestion(qJ82);

        					Question qJ83 = new Question(
        					    "Which method is the entry point of a Java program?",
        					    Arrays.asList("start()", "main()", "run()", "init()"),
        					    1, // Correct: main()
        					    COURSE_JAVA
        					);
        					dao.saveQuestion(qJ83);

        					Question qJ84 = new Question(
        					    "Which keyword in Java is used to prevent inheritance?",
        					    Arrays.asList("final", "static", "private", "protected"),
        					    0, // Correct: final
        					    COURSE_JAVA
        					);
        					dao.saveQuestion(qJ84);

        					Question qJ85 = new Question(
        					    "Which Java collection class allows duplicate elements?",
        					    Arrays.asList("Set", "Map", "List", "HashSet"),
        					    2, // Correct: List
        					    COURSE_JAVA
        					);
        					dao.saveQuestion(qJ85);

        					Question qJ86 = new Question(
        					    "Which keyword is used to define an interface in Java?",
        					    Arrays.asList("interface", "abstract", "implements", "protocol"),
        					    0, // Correct: interface
        					    COURSE_JAVA
        					);
        					dao.saveQuestion(qJ86);

        					Question qJ87 = new Question(
        					    "Which of the following is used to handle exceptions in Java?",
        					    Arrays.asList("try-catch", "error-handler", "exception-block", "catcher"),
        					    0, // Correct: try-catch
        					    COURSE_JAVA
        					);
        					dao.saveQuestion(qJ87);

        					Question qJ88 = new Question(
        					    "Which Java keyword is used to create an object?",
        					    Arrays.asList("new", "create", "object", "instance"),
        					    0, // Correct: new
        					    COURSE_JAVA
        					);
        					dao.saveQuestion(qJ88);

        					Question qJ89 = new Question(
        					    "Which Java keyword is used to define a constant?",
        					    Arrays.asList("const", "final", "static", "constant"),
        					    1, // Correct: final
        					    COURSE_JAVA
        					);
        					dao.saveQuestion(qJ89);

        					Question qJ90 = new Question(
        					    "Which Java keyword is used to implement multiple inheritance through interfaces?",
        					    Arrays.asList("extends", "implements", "inherits", "super"),
        					    1, // Correct: implements
        					    COURSE_JAVA
        					);
        					dao.saveQuestion(qJ90);
        					Question qJ91 = new Question(
        						    "The keyword _________ is used to define a class in Java.",
        						    Arrays.asList("class", "struct", "define", "object"),
        						    0,
        						    COURSE_JAVA
        						);
        						dao.saveQuestion(qJ91);

        						Question qJ92 = new Question(
        						    "The keyword _________ is used to declare a method that belongs to the class rather than an instance.",
        						    Arrays.asList("static", "final", "abstract", "public"),
        						    0,
        						    COURSE_JAVA
        						);
        						dao.saveQuestion(qJ92);

        						Question qJ93 = new Question(
        						    "The keyword _________ is used to inherit a class in Java.",
        						    Arrays.asList("extends", "implements", "inherits", "super"),
        						    0,
        						    COURSE_JAVA
        						);
        						dao.saveQuestion(qJ93);

        						Question qJ94 = new Question(
        						    "The keyword _________ is used to define an interface in Java.",
        						    Arrays.asList("interface", "abstract", "implements", "protocol"),
        						    0,
        						    COURSE_JAVA
        						);
        						dao.saveQuestion(qJ94);

        						Question qJ95 = new Question(
        						    "The keyword _________ is used to handle exceptions in Java.",
        						    Arrays.asList("try", "catch", "throw", "throws"),
        						    0,
        						    COURSE_JAVA
        						);
        						dao.saveQuestion(qJ95);

        						Question qJ96 = new Question(
        						    "The keyword _________ is used to create an object in Java.",
        						    Arrays.asList("new", "create", "object", "instance"),
        						    0,
        						    COURSE_JAVA
        						);
        						dao.saveQuestion(qJ96);

        						Question qJ97 = new Question(
        						    "The keyword _________ is used to prevent inheritance in Java.",
        						    Arrays.asList("final", "static", "private", "sealed"),
        						    0,
        						    COURSE_JAVA
        						);
        						dao.saveQuestion(qJ97);

        						Question qJ98 = new Question(
        						    "The keyword _________ is used to import a package in Java.",
        						    Arrays.asList("import", "include", "using", "require"),
        						    0,
        						    COURSE_JAVA
        						);
        						dao.saveQuestion(qJ98);

        						Question qJ99 = new Question(
        						    "The keyword _________ is used to define a constant in Java.",
        						    Arrays.asList("final", "const", "static", "immutable"),
        						    0,
        						    COURSE_JAVA
        						);
        						dao.saveQuestion(qJ99);

        						Question qJ100 = new Question(
        						    "The keyword _________ is used to implement an interface in Java.",
        						    Arrays.asList("implements", "extends", "interface", "apply"),
        						    0,
        						    COURSE_JAVA
        						);
        						dao.saveQuestion(qJ100);


        // ----------------------------------------------------------
        //             Web Dev (HTML/CSS/JS) Questions (Example)
        // ----------------------------------------------------------
        System.out.println("Initializing Web Dev Questions...");

        // Q_W1
        Question qW1 = new Question(
        	    "Which HTML tag is used to create an ordered list?",
        	    Arrays.asList("<ul>", "<li>", "<ol>", "<dl>"),
        	    2, // Correct: <ol>
        	    COURSE_WEB_DEV
        	);
        	dao.saveQuestion(qW1);

        	Question qW2 = new Question(
        	    "Which HTML tag is used to create an unordered list?",
        	    Arrays.asList("<ul>", "<li>", "<ol>", "<dl>"),
        	    0, // Correct: <ul>
        	    COURSE_WEB_DEV
        	);
        	dao.saveQuestion(qW2);

        	Question qW3 = new Question(
        	    "Which HTML tag is used to insert an image?",
        	    Arrays.asList("<img>", "<image>", "<picture>", "<src>"),
        	    0, // Correct: <img>
        	    COURSE_WEB_DEV
        	);
        	dao.saveQuestion(qW3);

        	Question qW4 = new Question(
        	    "Which HTML tag is used to create a hyperlink?",
        	    Arrays.asList("<link>", "<a>", "<href>", "<hyper>"),
        	    1, // Correct: <a>
        	    COURSE_WEB_DEV
        	);
        	dao.saveQuestion(qW4);

        	Question qW5 = new Question(
        	    "Which HTML5 element defines navigation links?",
        	    Arrays.asList("<nav>", "<menu>", "<header>", "<footer>"),
        	    0, // Correct: <nav>
        	    COURSE_WEB_DEV
        	);
        	dao.saveQuestion(qW5);

        	Question qW6 = new Question(
        	    "Which HTML tag is used to define a paragraph?",
        	    Arrays.asList("<para>", "<p>", "<text>", "<pg>"),
        	    1, // Correct: <p>
        	    COURSE_WEB_DEV
        	);
        	dao.saveQuestion(qW6);

        	Question qW7 = new Question(
        	    "Which HTML tag is used to define the largest heading?",
        	    Arrays.asList("<h1>", "<h6>", "<head>", "<header>"),
        	    0, // Correct: <h1>
        	    COURSE_WEB_DEV
        	);
        	dao.saveQuestion(qW7);

        	Question qW8 = new Question(
        	    "Which HTML tag is used to define a table row?",
        	    Arrays.asList("<tr>", "<td>", "<th>", "<row>"),
        	    0, // Correct: <tr>
        	    COURSE_WEB_DEV
        	);
        	dao.saveQuestion(qW8);

        	Question qW9 = new Question(
        	    "Which HTML tag is used to define a table cell?",
        	    Arrays.asList("<td>", "<tr>", "<th>", "<cell>"),
        	    0, // Correct: <td>
        	    COURSE_WEB_DEV
        	);
        	dao.saveQuestion(qW9);

        	Question qW10 = new Question(
        	    "Which HTML tag is used to define a table header cell?",
        	    Arrays.asList("<th>", "<td>", "<tr>", "<header>"),
        	    0, // Correct: <th>
        	    COURSE_WEB_DEV
        	);
        	dao.saveQuestion(qW10);

        	Question qW11 = new Question(
        	    "Which HTML tag is used to embed a video?",
        	    Arrays.asList("<video>", "<media>", "<movie>", "<embed>"),
        	    0, // Correct: <video>
        	    COURSE_WEB_DEV
        	);
        	dao.saveQuestion(qW11);

        	Question qW12 = new Question(
        	    "Which HTML tag is used to embed audio?",
        	    Arrays.asList("<audio>", "<sound>", "<music>", "<embed>"),
        	    0, // Correct: <audio>
        	    COURSE_WEB_DEV
        	);
        	dao.saveQuestion(qW12);

        	Question qW13 = new Question(
        	    "Which HTML tag is used to define a form?",
        	    Arrays.asList("<form>", "<input>", "<fieldset>", "<submit>"),
        	    0, // Correct: <form>
        	    COURSE_WEB_DEV
        	);
        	dao.saveQuestion(qW13);

        	Question qW14 = new Question(
        	    "Which HTML tag is used to define an input field?",
        	    Arrays.asList("<input>", "<form>", "<field>", "<textbox>"),
        	    0, // Correct: <input>
        	    COURSE_WEB_DEV
        	);
        	dao.saveQuestion(qW14);

        	Question qW15 = new Question(
        	    "Which HTML tag is used to define a dropdown list?",
        	    Arrays.asList("<select>", "<option>", "<list>", "<dropdown>"),
        	    0, // Correct: <select>
        	    COURSE_WEB_DEV
        	);
        	dao.saveQuestion(qW15);

        	Question qW16 = new Question(
        	    "Which HTML tag is used to define options in a dropdown?",
        	    Arrays.asList("<option>", "<select>", "<choice>", "<item>"),
        	    0, // Correct: <option>
        	    COURSE_WEB_DEV
        	);
        	dao.saveQuestion(qW16);

        	Question qW17 = new Question(
        	    "Which HTML tag is used to define a checkbox?",
        	    Arrays.asList("<input type='checkbox'>", "<check>", "<box>", "<tick>"),
        	    0, // Correct: <input type='checkbox'>
        	    COURSE_WEB_DEV
        	);
        	dao.saveQuestion(qW17);

        	Question qW18 = new Question(
        	    "Which HTML tag is used to define a radio button?",
        	    Arrays.asList("<input type='radio'>", "<radio>", "<button>", "<circle>"),
        	    0, // Correct: <input type='radio'>
        	    COURSE_WEB_DEV
        	);
        	dao.saveQuestion(qW18);

        	Question qW19 = new Question(
        	    "Which HTML tag is used to define a submit button?",
        	    Arrays.asList("<input type='submit'>", "<submit>", "<button>", "<form>"),
        	    0, // Correct: <input type='submit'>
        	    COURSE_WEB_DEV
        	);
        	dao.saveQuestion(qW19);

        	Question qW20 = new Question(
        	    "Which HTML tag is used to define metadata?",
        	    Arrays.asList("<meta>", "<head>", "<title>", "<info>"),
        	    0, // Correct: <meta>
        	    COURSE_WEB_DEV
        	);
        	dao.saveQuestion(qW20);
        	Question qW21 = new Question(
        		    "What does CSS stand for?",
        		    Arrays.asList("Cascading Style Sheets", "Creative Style System", "Computer Style Sheets", "Colorful Style Sheets"),
        		    0, // Correct: Cascading Style Sheets
        		    COURSE_WEB_DEV
        		);
        		dao.saveQuestion(qW21);

        		Question qW22 = new Question(
        		    "Which property controls text size?",
        		    Arrays.asList("font-style", "font-size", "text-size", "size"),
        		    1, // Correct: font-size
        		    COURSE_WEB_DEV
        		);
        		dao.saveQuestion(qW22);

        		Question qW23 = new Question(
        		    "Which property changes text color?",
        		    Arrays.asList("background-color", "text-color", "color", "font-color"),
        		    2, // Correct: color
        		    COURSE_WEB_DEV
        		);
        		dao.saveQuestion(qW23);

        		Question qW24 = new Question(
        		    "Which property controls spacing outside an element?",
        		    Arrays.asList("padding", "margin", "border", "spacing"),
        		    1, // Correct: margin
        		    COURSE_WEB_DEV
        		);
        		dao.saveQuestion(qW24);

        		Question qW25 = new Question(
        		    "Which property controls spacing inside an element?",
        		    Arrays.asList("padding", "margin", "border", "spacing"),
        		    0, // Correct: padding
        		    COURSE_WEB_DEV
        		);
        		dao.saveQuestion(qW25);

        		Question qW26 = new Question(
        		    "Which property sets the background color?",
        		    Arrays.asList("background-color", "color", "bgcolor", "background"),
        		    0, // Correct: background-color
        		    COURSE_WEB_DEV
        		);
        		dao.saveQuestion(qW26);

        		Question qW27 = new Question(
        		    "Which property sets the font style?",
        		    Arrays.asList("font-style", "font-size", "text-style", "style"),
        		    0, // Correct: font-style
        		    COURSE_WEB_DEV
        		);
        		dao.saveQuestion(qW27);

        		Question qW28 = new Question(
        		    "Which property sets the font weight?",
        		    Arrays.asList("font-weight", "bold", "weight", "text-weight"),
        		    0, // Correct: font-weight
        		    COURSE_WEB_DEV
        		);
        		dao.saveQuestion(qW28);

        		Question qW29 = new Question(
        		    "Which property sets the text alignment?",
        		    Arrays.asList("text-align", "align", "alignment", "justify"),
        		    0, // Correct: text-align
        		    COURSE_WEB_DEV
        		);
        		dao.saveQuestion(qW29);

        		Question qW30 = new Question(
        		    "Which property sets the line height?",
        		    Arrays.asList("line-height", "height", "spacing", "line-spacing"),
        		    0, // Correct: line-height
        		    COURSE_WEB_DEV
        		);
        		dao.saveQuestion(qW30);

        		Question qW31 = new Question(
        		    "Which property sets the width of an element?",
        		    Arrays.asList("width", "size", "element-width", "box-width"),
        		    0, // Correct: width
        		    COURSE_WEB_DEV
        		);
        		dao.saveQuestion(qW31);

        		Question qW32 = new Question(
        		    "Which property sets the height of an element?",
        		    Arrays.asList("height", "size", "element-height", "box-height"),
        		    0, // Correct: height
        		    COURSE_WEB_DEV
        		);
        		dao.saveQuestion(qW32);

        		Question qW33 = new Question(
        		    "Which property sets the border color?",
        		    Arrays.asList("border-color", "color", "border", "outline-color"),
        		    0, // Correct: border-color
        		    COURSE_WEB_DEV
        		);
        		dao.saveQuestion(qW33);

        		Question qW34 = new Question(
        		    "Which property sets the border width?",
        		    Arrays.asList("border-width", "width", "border-size", "outline-width"),
        		    0, // Correct: border-width
        		    COURSE_WEB_DEV
        		);
        		dao.saveQuestion(qW34);

        		Question qW35 = new Question(
        		    "Which property sets the border style?",
        		    Arrays.asList("border-style", "style", "border-type", "outline-style"),
        		    0, // Correct: border-style
        		    COURSE_WEB_DEV
        		);
        		dao.saveQuestion(qW35);

        		Question qW36 = new Question(
        		    "Which property sets the maximum width of an element?",
        		    Arrays.asList("max-width", "width", "limit-width", "element-width"),
        		    0, // Correct: max-width
        		    COURSE_WEB_DEV
        		);
        		dao.saveQuestion(qW36);

        		Question qW37 = new Question(
        		    "Which property sets the minimum height of an element?",
        		    Arrays.asList("min-height", "height", "limit-height", "element-height"),
        		    0, // Correct: min-height
        		    COURSE_WEB_DEV
        		);
        		dao.saveQuestion(qW37);

        		Question qW38 = new Question(
        		    "Which property sets the visibility of an element?",
        		    Arrays.asList("visibility", "display", "hidden", "show"),
        		    0, // Correct: visibility
        		    COURSE_WEB_DEV
        		);
        		dao.saveQuestion(qW38);

        		Question qW39 = new Question(
        		    "Which property sets whether an element is displayed or not?",
        		    Arrays.asList("display", "visibility", "show", "hidden"),
        		    0, // Correct: display
        		    COURSE_WEB_DEV
        		);
        		dao.saveQuestion(qW39);

        		Question qW40 = new Question(
        		    "Which property sets the position of an element?",
        		    Arrays.asList("position", "align", "float", "place"),
        		    0, // Correct: position
        		    COURSE_WEB_DEV
        		);
        		dao.saveQuestion(qW40);
        		Question qW41 = new Question(
        			    "What does JavaScript add to web pages?",
        			    Arrays.asList("Structure", "Styling", "Interactivity", "None of the above"),
        			    2, // Correct: Interactivity
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW41);

        			Question qW42 = new Question(
        			    "Which keyword declares a block-scoped variable in JavaScript?",
        			    Arrays.asList("var", "let", "const", "define"),
        			    1, // Correct: let
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW42);

        			Question qW43 = new Question(
        			    "Which method selects the first matching element in the DOM?",
        			    Arrays.asList("getElementById()", "querySelector()", "getElementsByClassName()", "queryAll()"),
        			    1, // Correct: querySelector()
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW43);

        			Question qW44 = new Question(
        			    "Which event is triggered when a user clicks an element?",
        			    Arrays.asList("onchange", "onmouseover", "onclick", "onload"),
        			    2, // Correct: onclick
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW44);

        			Question qW45 = new Question(
        			    "Which operator is used for strict equality in JavaScript?",
        			    Arrays.asList("==", "===", "!=", "=>"),
        			    1, // Correct: ===
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW45);

        			Question qW46 = new Question(
        			    "Which feature was introduced in ES6?",
        			    Arrays.asList("Arrow Functions", "Classes", "Template Literals", "All of the above"),
        			    3, // Correct: All of the above
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW46);

        			Question qW47 = new Question(
        			    "Which method is used to convert JSON string into JavaScript object?",
        			    Arrays.asList("JSON.parse()", "JSON.stringify()", "JSON.convert()", "parseJSON()"),
        			    0, // Correct: JSON.parse()
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW47);

        			Question qW48 = new Question(
        			    "Which storage mechanism allows saving data across browser sessions?",
        			    Arrays.asList("SessionStorage", "LocalStorage", "Cookies", "Cache"),
        			    1, // Correct: LocalStorage
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW48);

        			Question qW49 = new Question(
        			    "Which keyword is used to handle errors in JavaScript?",
        			    Arrays.asList("catch", "error", "throw", "try...catch"),
        			    3, // Correct: try...catch
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW49);

        			Question qW50 = new Question(
        			    "Which API is used to fetch data from servers?",
        			    Arrays.asList("Fetch API", "LocalStorage API", "Session API", "Cache API"),
        			    0, // Correct: Fetch API
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW50);

        			Question qW51 = new Question(
        			    "What does DOM stand for?",
        			    Arrays.asList("Document Object Model", "Data Object Method", "Document Order Map", "None of the above"),
        			    0, // Correct: Document Object Model
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW51);

        			Question qW52 = new Question(
        			    "Which property returns the parent node of an element?",
        			    Arrays.asList("parentNode", "childNode", "nextSibling", "previousNode"),
        			    0, // Correct: parentNode
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW52);

        			Question qW53 = new Question(
        			    "Which method creates a new HTML element?",
        			    Arrays.asList("createElement()", "appendChild()", "newElement()", "insertElement()"),
        			    0, // Correct: createElement()
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW53);

        			Question qW54 = new Question(
        			    "Which method adds a new child node to a parent element?",
        			    Arrays.asList("appendChild()", "createChild()", "insertNode()", "addNode()"),
        			    0, // Correct: appendChild()
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW54);

        			Question qW55 = new Question(
        			    "What is event bubbling in JavaScript?",
        			    Arrays.asList("Event flows from child to parent", "Event flows from parent to child", "Event stops at target", "Event only triggers once"),
        			    0, // Correct: Event flows from child to parent
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW55);

        			Question qW56 = new Question(
        			    "Which technique allows handling events efficiently on multiple child elements?",
        			    Arrays.asList("Event Delegation", "Event Bubbling", "Event Capturing", "Event Loop"),
        			    0, // Correct: Event Delegation
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW56);

        			Question qW57 = new Question(
        			    "Which method is used to change the text inside an element?",
        			    Arrays.asList("innerHTML", "textContent", "innerText", "All of the above"),
        			    3, // Correct: All of the above
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW57);

        			Question qW58 = new Question(
        			    "Which method is used to fetch data from an API?",
        			    Arrays.asList("fetch()", "getData()", "ajax()", "request()"),
        			    0, // Correct: fetch()
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW58);

        			Question qW59 = new Question(
        			    "Which format is commonly used for API data exchange?",
        			    Arrays.asList("XML", "JSON", "CSV", "HTML"),
        			    1, // Correct: JSON
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW59);

        			Question qW60 = new Question(
        			    "Which method converts a JavaScript object into a JSON string?",
        			    Arrays.asList("JSON.stringify()", "JSON.parse()", "objectToJSON()", "stringifyJSON()"),
        			    0, // Correct: JSON.stringify()
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW60);

        			Question qW61 = new Question(
        			    "Which method removes the last element from an array?",
        			    Arrays.asList("pop()", "push()", "shift()", "splice()"),
        			    0, // Correct: pop()
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW61);

        			Question qW62 = new Question(
        			    "Which loop is best for iterating over arrays?",
        			    Arrays.asList("for loop", "while loop", "for...of loop", "do...while loop"),
        			    2, // Correct: for...of loop
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW62);

        			Question qW63 = new Question(
        			    "Which keyword is used to define a JavaScript class?",
        			    Arrays.asList("class", "function", "object", "define"),
        			    0, // Correct: class
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW63);

        			Question qW64 = new Question(
        			    "Which keyword is used to inherit from another class?",
        			    Arrays.asList("extends", "inherits", "superclass", "prototype"),
        			    0, // Correct: extends
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW64);

        			Question qW65 = new Question(
        			    "Which statement is used to stop a loop in JavaScript?",
        			    Arrays.asList("break", "stop", "exit", "halt"),
        			    0, // Correct: break
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW65);

        			Question qW66 = new Question(
        			    "Which statement is used to skip the current iteration of a loop?",
        			    Arrays.asList("break", "continue", "skip", "next"),
        			    1, // Correct: continue
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW66);

        			Question qW67 = new Question(
        			    "Which method adds an element at the end of an array?",
        			    Arrays.asList("push()", "pop()", "shift()", "unshift()"),
        			    0, // Correct: push()
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW67);

        			Question qW68 = new Question(
        			    "Which JavaScript function is used to print messages to the console?",
        			    Arrays.asList("alert()", "console.log()", "print()", "document.write()"),
        			    1, // Correct: console.log()
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW68);

        			Question qW69 = new Question(
        			    "Which JavaScript method is used to attach an event handler to an element?",
        			    Arrays.asList("addEventListener()", "attachEvent()", "onEvent()", "bindEvent()"),
        			    0, // Correct: addEventListener()
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW69);

        			Question qW70 = new Question(
        			    "Which JavaScript object is used to work with browser windows?",
        			    Arrays.asList("document", "window", "navigator", "screen"),
        			    1, // Correct: window
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW70);

        			Question qW71 = new Question(
        			    "Which JavaScript object is used to work with the DOM?",
        			    Arrays.asList("document", "window", "navigator", "screen"),
        			    0, // Correct: document
        			    COURSE_WEB_DEV
        			);
        			dao.saveQuestion(qW71);

        			Question qW72 = new Question(
        				    "Which property returns the number of elements in an array?",
        				    Arrays.asList("length", "size", "count", "elements"),
        				    0, // Correct: length
        				    COURSE_WEB_DEV
        				);
        				dao.saveQuestion(qW72);

        				Question qW73 = new Question(
        				    "Which method is used to sort elements of an array?",
        				    Arrays.asList("sort()", "order()", "arrange()", "sequence()"),
        				    0, // Correct: sort()
        				    COURSE_WEB_DEV
        				);
        				dao.saveQuestion(qW73);

        				Question qW74 = new Question(
        				    "Which method is used to reverse elements of an array?",
        				    Arrays.asList("reverse()", "invert()", "flip()", "back()"),
        				    0, // Correct: reverse()
        				    COURSE_WEB_DEV
        				);
        				dao.saveQuestion(qW74);

        				Question qW75 = new Question(
        				    "Which ES6 feature allows defining variables with block scope?",
        				    Arrays.asList("let", "var", "const", "define"),
        				    0, // Correct: let
        				    COURSE_WEB_DEV
        				);
        				dao.saveQuestion(qW75);

        				Question qW76 = new Question(
        				    "Which ES6 feature allows defining constants?",
        				    Arrays.asList("const", "let", "final", "static"),
        				    0, // Correct: const
        				    COURSE_WEB_DEV
        				);
        				dao.saveQuestion(qW76);

        				Question qW77 = new Question(
        				    "Which ES6 feature allows writing multi-line strings easily?",
        				    Arrays.asList("Template Literals", "StringBuilder", "Concatenation", "Quotes"),
        				    0, // Correct: Template Literals
        				    COURSE_WEB_DEV
        				);
        				dao.saveQuestion(qW77);

        				Question qW78 = new Question(
        				    "Which ES6 feature allows concise function syntax?",
        				    Arrays.asList("Arrow Functions", "Anonymous Functions", "Lambda", "Inline Functions"),
        				    0, // Correct: Arrow Functions
        				    COURSE_WEB_DEV
        				);
        				dao.saveQuestion(qW78);

        				Question qW79 = new Question(
        				    "Which JavaScript object provides information about the browser?",
        				    Arrays.asList("navigator", "window", "document", "screen"),
        				    0, // Correct: navigator
        				    COURSE_WEB_DEV
        				);
        				dao.saveQuestion(qW79);

        				Question qW80 = new Question(
        				    "Which JavaScript object provides information about the user's screen?",
        				    Arrays.asList("screen", "window", "navigator", "document"),
        				    0, // Correct: screen
        				    COURSE_WEB_DEV
        				);
        				dao.saveQuestion(qW80);

        				Question qW81 = new Question(
        					    "Which HTML tag is used to create a hyperlink?",
        					    Arrays.asList("<link>", "<a>", "<href>", "<hyper>"),
        					    1, // Correct: <a>
        					    COURSE_WEB_DEV
        					);
        					dao.saveQuestion(qW81);

        					Question qW82 = new Question(
        					    "Which CSS property is used to change text color?",
        					    Arrays.asList("font-color", "color", "text-color", "background-color"),
        					    1, // Correct: color
        					    COURSE_WEB_DEV
        					);
        					dao.saveQuestion(qW82);

        					Question qW83 = new Question(
        					    "Which JavaScript method is used to select an element by ID?",
        					    Arrays.asList("getElementById()", "querySelector()", "getElementsByClassName()", "getElementByTag()"),
        					    0, // Correct: getElementById()
        					    COURSE_WEB_DEV
        					);
        					dao.saveQuestion(qW83);

        					Question qW84 = new Question(
        					    "Which HTTP status code indicates 'Not Found'?",
        					    Arrays.asList("200", "301", "404", "500"),
        					    2, // Correct: 404
        					    COURSE_WEB_DEV
        					);
        					dao.saveQuestion(qW84);

        					Question qW85 = new Question(
        					    "Which HTML5 element is used for drawing graphics via scripting?",
        					    Arrays.asList("<canvas>", "<svg>", "<img>", "<graphic>"),
        					    0, // Correct: <canvas>
        					    COURSE_WEB_DEV
        					);
        					dao.saveQuestion(qW85);

        					Question qW86 = new Question(
        					    "Which CSS property controls the size of text?",
        					    Arrays.asList("font-size", "text-size", "size", "font-style"),
        					    0, // Correct: font-size
        					    COURSE_WEB_DEV
        					);
        					dao.saveQuestion(qW86);

        					Question qW87 = new Question(
        					    "Which JavaScript keyword is used to declare a constant?",
        					    Arrays.asList("var", "let", "const", "static"),
        					    2, // Correct: const
        					    COURSE_WEB_DEV
        					);
        					dao.saveQuestion(qW87);

        					Question qW88 = new Question(
        					    "Which protocol is used for secure communication over the web?",
        					    Arrays.asList("HTTP", "HTTPS", "FTP", "SMTP"),
        					    1, // Correct: HTTPS
        					    COURSE_WEB_DEV
        					);
        					dao.saveQuestion(qW88);

        					Question qW89 = new Question(
        					    "Which HTML tag is used to display tabular data?",
        					    Arrays.asList("<table>", "<tr>", "<td>", "<tab>"),
        					    0, // Correct: <table>
        					    COURSE_WEB_DEV
        					);
        					dao.saveQuestion(qW89);

        					Question qW90 = new Question(
        					    "Which JavaScript method is used to parse a JSON string?",
        					    Arrays.asList("JSON.parse()", "JSON.stringify()", "parseJSON()", "stringifyJSON()"),
        					    0, // Correct: JSON.parse()
        					    COURSE_WEB_DEV
        					);
        					dao.saveQuestion(qW90);
        					Question qW91 = new Question(
        						    "The HTML tag _________ is used to insert an image.",
        						    Arrays.asList("<img>", "<image>", "<picture>", "<src>"),
        						    0,
        						    COURSE_WEB_DEV
        						);
        						dao.saveQuestion(qW91);

        						Question qW92 = new Question(
        						    "The CSS property _________ is used to set the background color of an element.",
        						    Arrays.asList("background-color", "color", "background-image", "border-color"),
        						    0,
        						    COURSE_WEB_DEV
        						);
        						dao.saveQuestion(qW92);

        						Question qW93 = new Question(
        						    "The JavaScript keyword _________ is used to declare a variable with block scope.",
        						    Arrays.asList("let", "var", "const", "static"),
        						    0,
        						    COURSE_WEB_DEV
        						);
        						dao.saveQuestion(qW93);

        						Question qW94 = new Question(
        						    "The HTML tag _________ is used to create an ordered list.",
        						    Arrays.asList("<ol>", "<ul>", "<li>", "<list>"),
        						    0,
        						    COURSE_WEB_DEV
        						);
        						dao.saveQuestion(qW94);

        						Question qW95 = new Question(
        						    "The CSS property _________ is used to make text bold.",
        						    Arrays.asList("font-weight", "text-style", "font-bold", "text-weight"),
        						    0,
        						    COURSE_WEB_DEV
        						);
        						dao.saveQuestion(qW95);

        						Question qW96 = new Question(
        						    "The JavaScript method _________ is used to write content into the HTML document.",
        						    Arrays.asList("document.write", "console.log", "alert", "innerHTML"),
        						    0,
        						    COURSE_WEB_DEV
        						);
        						dao.saveQuestion(qW96);

        						Question qW97 = new Question(
        						    "The HTML tag _________ is used to define a division or section.",
        						    Arrays.asList("<div>", "<section>", "<span>", "<p>"),
        						    0,
        						    COURSE_WEB_DEV
        						);
        						dao.saveQuestion(qW97);

        						Question qW98 = new Question(
        						    "The CSS property _________ is used to align text horizontally.",
        						    Arrays.asList("text-align", "align", "horizontal-align", "justify"),
        						    0,
        						    COURSE_WEB_DEV
        						);
        						dao.saveQuestion(qW98);

        						Question qW99 = new Question(
        						    "The JavaScript method _________ is used to convert an object into a JSON string.",
        						    Arrays.asList("JSON.stringify", "JSON.parse", "toString", "Object.convert"),
        						    0,
        						    COURSE_WEB_DEV
        						);
        						dao.saveQuestion(qW99);

        						Question qW100 = new Question(
        						    "The HTML tag _________ is used to create a line break.",
        						    Arrays.asList("<br>", "<lb>", "<break>", "<newline>"),
        						    0,
        						    COURSE_WEB_DEV
        						);
        						dao.saveQuestion(qW100);

        // ----------------------------------------------------------
        //             Artificial Intelligence Questions (Example)
        // ----------------------------------------------------------
        System.out.println("Initializing AI Questions...");

        // Q_A1
        Question qA1 = new Question(
        	    "Which subfield of AI focuses on enabling computers to learn from data without being explicitly programmed?",
        	    Arrays.asList("Natural Language Processing", "Robotics", "Machine Learning", "Computer Vision"),
        	    2, // Correct: Machine Learning
        	    COURSE_AI
        	);
        	dao.saveQuestion(qA1);

        	Question qA2 = new Question(
        	    "Which programming language is most widely used in AI?",
        	    Arrays.asList("Python", "C++", "Java", "PHP"),
        	    0, // Correct: Python
        	    COURSE_AI
        	);
        	dao.saveQuestion(qA2);

        	Question qA3 = new Question(
        	    "Which mathematical concept is essential for neural networks?",
        	    Arrays.asList("Linear Algebra", "Geometry", "Trigonometry", "Arithmetic"),
        	    0, // Correct: Linear Algebra
        	    COURSE_AI
        	);
        	dao.saveQuestion(qA3);

        	Question qA4 = new Question(
        	    "Which Python library is used for data analysis?",
        	    Arrays.asList("Pandas", "NumPy", "Matplotlib", "TensorFlow"),
        	    0, // Correct: Pandas
        	    COURSE_AI
        	);
        	dao.saveQuestion(qA4);

        	Question qA5 = new Question(
        	    "Who proposed the Turing Test?",
        	    Arrays.asList("Alan Turing", "John McCarthy", "Marvin Minsky", "Geoffrey Hinton"),
        	    0, // Correct: Alan Turing
        	    COURSE_AI
        	);
        	dao.saveQuestion(qA5);

        	Question qA6 = new Question(
        	    "Which year marked the Dartmouth Conference (birth of AI)?",
        	    Arrays.asList("1956", "1960", "1945", "1970"),
        	    0, // Correct: 1956
        	    COURSE_AI
        	);
        	dao.saveQuestion(qA6);

        	Question qA7 = new Question(
        	    "Which type of AI is specialized for one task?",
        	    Arrays.asList("Narrow AI", "General AI", "Superintelligence", "Symbolic AI"),
        	    0, // Correct: Narrow AI
        	    COURSE_AI
        	);
        	dao.saveQuestion(qA7);

        	Question qA8 = new Question(
        	    "Which search algorithm is used for shortest path?",
        	    Arrays.asList("A*", "K-Means", "Naive Bayes", "Gradient Descent"),
        	    0, // Correct: A*
        	    COURSE_AI
        	);
        	dao.saveQuestion(qA8);

        	Question qA9 = new Question(
        	    "Which is NOT a core AI technique?",
        	    Arrays.asList("Knowledge Representation", "Heuristic Search", "Data Cleaning", "Reasoning"),
        	    2, // Correct: Data Cleaning
        	    COURSE_AI
        	);
        	dao.saveQuestion(qA9);

        	Question qA10 = new Question(
        	    "Which is a key ethical concern in AI?",
        	    Arrays.asList("Bias", "Transparency", "Privacy", "All of the above"),
        	    3, // Correct: All of the above
        	    COURSE_AI
        	);
        	dao.saveQuestion(qA10);
        	Question qA11 = new Question(
        		    "Which ML type uses labeled data?",
        		    Arrays.asList("Supervised Learning", "Unsupervised Learning", "Reinforcement Learning", "Semi-Supervised Learning"),
        		    0, // Correct: Supervised Learning
        		    COURSE_AI
        		);
        		dao.saveQuestion(qA11);

        		Question qA12 = new Question(
        		    "Which ML algorithm is used for classification?",
        		    Arrays.asList("Logistic Regression", "Linear Regression", "K-Means", "PCA"),
        		    0, // Correct: Logistic Regression
        		    COURSE_AI
        		);
        		dao.saveQuestion(qA12);

        		Question qA13 = new Question(
        		    "Which metric is used for regression models?",
        		    Arrays.asList("Mean Squared Error", "Accuracy", "Precision", "Recall"),
        		    0, // Correct: Mean Squared Error
        		    COURSE_AI
        		);
        		dao.saveQuestion(qA13);

        		Question qA14 = new Question(
        		    "Which network is best for image recognition?",
        		    Arrays.asList("CNN", "RNN", "GAN", "SVM"),
        		    0, // Correct: CNN
        		    COURSE_AI
        		);
        		dao.saveQuestion(qA14);

        		Question qA15 = new Question(
        		    "Which algorithm enables training of deep networks?",
        		    Arrays.asList("Backpropagation", "Forward Propagation", "Gradient Boosting", "Clustering"),
        		    0, // Correct: Backpropagation
        		    COURSE_AI
        		);
        		dao.saveQuestion(qA15);

        		Question qA16 = new Question(
        		    "Which activation function is most widely used today?",
        		    Arrays.asList("ReLU", "Sigmoid", "Tanh", "Softmax"),
        		    0, // Correct: ReLU
        		    COURSE_AI
        		);
        		dao.saveQuestion(qA16);

        		Question qA17 = new Question(
        		    "Which architecture is used for sequential data?",
        		    Arrays.asList("RNN", "CNN", "GAN", "Decision Tree"),
        		    0, // Correct: RNN
        		    COURSE_AI
        		);
        		dao.saveQuestion(qA17);

        		Question qA18 = new Question(
        		    "Which model introduced attention mechanism?",
        		    Arrays.asList("Transformer", "CNN", "RNN", "GAN"),
        		    0, // Correct: Transformer
        		    COURSE_AI
        		);
        		dao.saveQuestion(qA18);

        		Question qA19 = new Question(
        		    "Which framework is developed by Google?",
        		    Arrays.asList("TensorFlow", "PyTorch", "Keras", "MXNet"),
        		    0, // Correct: TensorFlow
        		    COURSE_AI
        		);
        		dao.saveQuestion(qA19);

        		Question qA20 = new Question(
        		    "Which deep learning model generates synthetic data?",
        		    Arrays.asList("GAN", "CNN", "RNN", "SVM"),
        		    0, // Correct: GAN
        		    COURSE_AI
        		);
        		dao.saveQuestion(qA20);

        		Question qA21 = new Question(
        		    "Which chatbot was developed in the 1960s?",
        		    Arrays.asList("ELIZA", "Siri", "Alexa", "Copilot"),
        		    0, // Correct: ELIZA
        		    COURSE_AI
        		);
        		dao.saveQuestion(qA21);

        		Question qA22 = new Question(
        		    "Which technique converts text into numerical form?",
        		    Arrays.asList("Word Embeddings", "Parsing", "Named Entity Recognition", "Stop-word Removal"),
        		    0, // Correct: Word Embeddings
        		    COURSE_AI
        		);
        		dao.saveQuestion(qA22);

        		Question qA23 = new Question(
        		    "Which metric is used for machine translation?",
        		    Arrays.asList("BLEU Score", "Accuracy", "Precision", "Recall"),
        		    0, // Correct: BLEU Score
        		    COURSE_AI
        		);
        		dao.saveQuestion(qA23);

        		Question qA24 = new Question(
        		    "Which model powers GPT-style systems?",
        		    Arrays.asList("Transformer", "CNN", "RNN", "GAN"),
        		    0, // Correct: Transformer
        		    COURSE_AI
        		);
        		dao.saveQuestion(qA24);

        		Question qA25 = new Question(
        		    "Which task identifies people and places in text?",
        		    Arrays.asList("Named Entity Recognition", "Parsing", "Summarization", "Sentiment Analysis"),
        		    0, // Correct: Named Entity Recognition
        		    COURSE_AI
        		);
        		dao.saveQuestion(qA25);

        		Question qA26 = new Question(
        		    "Which is a challenge in NLP?",
        		    Arrays.asList("Ambiguity", "Bias", "Low-resource Languages", "All of the above"),
        		    3, // Correct: All of the above
        		    COURSE_AI
        		);
        		dao.saveQuestion(qA26);

        		Question qA27 = new Question(
        		    "Which technique detects edges in images?",
        		    Arrays.asList("Edge Detection", "Clustering", "NER", "Parsing"),
        		    0, // Correct: Edge Detection
        		    COURSE_AI
        		);
        		dao.saveQuestion(qA27);

        		Question qA28 = new Question(
        		    "Which network is core to vision tasks?",
        		    Arrays.asList("CNN", "RNN", "GAN", "SVM"),
        		    0, // Correct: CNN
        		    COURSE_AI
        		);
        		dao.saveQuestion(qA28);

        		Question qA29 = new Question(
        		    "Which application uses computer vision?",
        		    Arrays.asList("Object Detection", "Sentiment Analysis", "Machine Translation", "Speech Recognition"),
        		    0, // Correct: Object Detection
        		    COURSE_AI
        		);
        		dao.saveQuestion(qA29);

        		Question qA30 = new Question(
        		    "Which recent model is used in vision tasks?",
        		    Arrays.asList("Vision Transformer", "CNN", "RNN", "GAN"),
        		    0, // Correct: Vision Transformer
        		    COURSE_AI
        		);
        		dao.saveQuestion(qA30);
        		Question qA31 = new Question(
        			    "Which is a major ethical concern in AI?",
        			    Arrays.asList("Bias", "Transparency", "Privacy", "All of the above"),
        			    3, // Correct: All of the above
        			    COURSE_AI
        			);
        			dao.saveQuestion(qA31);

        			Question qA32 = new Question(
        			    "What does Explainable AI aim to achieve?",
        			    Arrays.asList("Interpretability of models", "Faster training", "More data collection", "Better storage"),
        			    0, // Correct: Interpretability of models
        			    COURSE_AI
        			);
        			dao.saveQuestion(qA32);

        			Question qA33 = new Question(
        			    "Which issue arises when AI discriminates unfairly?",
        			    Arrays.asList("Bias", "Overfitting", "Interpretability", "Scalability"),
        			    0, // Correct: Bias
        			    COURSE_AI
        			);
        			dao.saveQuestion(qA33);

        			Question qA34 = new Question(
        			    "Which AI application is used in healthcare?",
        			    Arrays.asList("Medical Imaging", "Fraud Detection", "Recommendation Systems", "Traffic Prediction"),
        			    0, // Correct: Medical Imaging
        			    COURSE_AI
        			);
        			dao.saveQuestion(qA34);

        			Question qA35 = new Question(
        			    "Which AI application is used in finance?",
        			    Arrays.asList("Fraud Detection", "Medical Diagnosis", "Speech Recognition", "Object Detection"),
        			    0, // Correct: Fraud Detection
        			    COURSE_AI
        			);
        			dao.saveQuestion(qA35);

        			Question qA36 = new Question(
        			    "Which AI application is used in transportation?",
        			    Arrays.asList("Self-driving Cars", "Medical Imaging", "Recommendation Systems", "Named Entity Recognition"),
        			    0, // Correct: Self-driving Cars
        			    COURSE_AI
        			);
        			dao.saveQuestion(qA36);

        			Question qA37 = new Question(
        			    "Which AI application is used in retail?",
        			    Arrays.asList("Recommendation Systems", "Medical Imaging", "Fraud Detection", "Traffic Prediction"),
        			    0, // Correct: Recommendation Systems
        			    COURSE_AI
        			);
        			dao.saveQuestion(qA37);

        			Question qA38 = new Question(
        			    "Which AI application is used in cybersecurity?",
        			    Arrays.asList("Intrusion Detection", "Medical Imaging", "Recommendation Systems", "NER"),
        			    0, // Correct: Intrusion Detection
        			    COURSE_AI
        			);
        			dao.saveQuestion(qA38);

        			Question qA39 = new Question(
        			    "What is the final project in the syllabus called?",
        			    Arrays.asList("Capstone Project", "Mini Project", "Final Exam", "Assignment"),
        			    0, // Correct: Capstone Project
        			    COURSE_AI
        			);
        			dao.saveQuestion(qA39);

        			Question qA40 = new Question(
        			    "Which language is primarily used for coding assignments in the syllabus?",
        			    Arrays.asList("Python", "Java", "C++", "R"),
        			    0, // Correct: Python
        			    COURSE_AI
        			);
        			dao.saveQuestion(qA40);

        			Question qA41 = new Question(
        			    "Which AI technique is used for speech recognition?",
        			    Arrays.asList("Natural Language Processing", "Computer Vision", "Reinforcement Learning", "Clustering"),
        			    0, // Correct: Natural Language Processing
        			    COURSE_AI
        			);
        			dao.saveQuestion(qA41);

        			Question qA42 = new Question(
        			    "Which AI technique is used for image classification?",
        			    Arrays.asList("CNN", "RNN", "GAN", "SVM"),
        			    0, // Correct: CNN
        			    COURSE_AI
        			);
        			dao.saveQuestion(qA42);

        			Question qA43 = new Question(
        			    "Which AI technique is used for anomaly detection?",
        			    Arrays.asList("Outlier Detection", "Regression", "Classification", "Clustering"),
        			    0, // Correct: Outlier Detection
        			    COURSE_AI
        			);
        			dao.saveQuestion(qA43);

        			Question qA44 = new Question(
        			    "Which AI technique is used for recommendation systems?",
        			    Arrays.asList("Collaborative Filtering", "Clustering", "Regression", "Decision Trees"),
        			    0, // Correct: Collaborative Filtering
        			    COURSE_AI
        			);
        			dao.saveQuestion(qA44);

        			Question qA45 = new Question(
        			    "Which AI technique is used for machine translation?",
        			    Arrays.asList("Neural Networks", "Decision Trees", "Regression", "Clustering"),
        			    0, // Correct: Neural Networks
        			    COURSE_AI
        			);
        			dao.saveQuestion(qA45);

        			Question qA46 = new Question(
        			    "Which AI technique is used for fraud detection?",
        			    Arrays.asList("Anomaly Detection", "Regression", "Classification", "Clustering"),
        			    0, // Correct: Anomaly Detection
        			    COURSE_AI
        			);
        			dao.saveQuestion(qA46);

        			Question qA47 = new Question(
        			    "Which AI technique is used for sentiment analysis?",
        			    Arrays.asList("Natural Language Processing", "Computer Vision", "Reinforcement Learning", "Clustering"),
        			    0, // Correct: Natural Language Processing
        			    COURSE_AI
        			);
        			dao.saveQuestion(qA47);

        			Question qA48 = new Question(
        			    "Which AI technique is used for object detection?",
        			    Arrays.asList("CNN", "RNN", "GAN", "SVM"),
        			    0, // Correct: CNN
        			    COURSE_AI
        			);
        			dao.saveQuestion(qA48);

        			Question qA49 = new Question(
        			    "Which AI technique is used for handwriting recognition?",
        			    Arrays.asList("CNN", "RNN", "GAN", "SVM"),
        			    1, // Correct: RNN
        			    COURSE_AI
        			);
        			dao.saveQuestion(qA49);

        			Question qA50 = new Question(
        			    "Which AI technique is used for time series forecasting?",
        			    Arrays.asList("RNN", "CNN", "GAN", "SVM"),
        			    0, // Correct: RNN
        			    COURSE_AI
        			);
        			dao.saveQuestion(qA50);
        			Question qA51 = new Question(
        				    "Which AI technique is used for clustering?",
        				    Arrays.asList("K-Means", "Regression", "Classification", "Decision Trees"),
        				    0, // Correct: K-Means
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA51);

        				Question qA52 = new Question(
        				    "Which AI technique is used for dimensionality reduction?",
        				    Arrays.asList("PCA", "Regression", "Classification", "Clustering"),
        				    0, // Correct: PCA
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA52);

        				Question qA53 = new Question(
        				    "Which AI technique is used for reinforcement learning?",
        				    Arrays.asList("Q-Learning", "Regression", "Classification", "Clustering"),
        				    0, // Correct: Q-Learning
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA53);

        				Question qA54 = new Question(
        				    "Which AI technique is used for game playing?",
        				    Arrays.asList("Minimax Algorithm", "Regression", "Classification", "Clustering"),
        				    0, // Correct: Minimax Algorithm
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA54);

        				Question qA55 = new Question(
        				    "Which AI technique is used for pathfinding?",
        				    Arrays.asList("A*", "Regression", "Classification", "Clustering"),
        				    0, // Correct: A*
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA55);

        				Question qA56 = new Question(
        				    "Which AI technique is used for optimization?",
        				    Arrays.asList("Genetic Algorithms", "Regression", "Classification", "Clustering"),
        				    0, // Correct: Genetic Algorithms
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA56);

        				Question qA57 = new Question(
        				    "Which AI technique is used for feature selection?",
        				    Arrays.asList("Information Gain", "Regression", "Classification", "Clustering"),
        				    0, // Correct: Information Gain
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA57);

        				Question qA58 = new Question(
        				    "Which AI technique is used for ensemble learning?",
        				    Arrays.asList("Random Forest", "Regression", "Classification", "Clustering"),
        				    0, // Correct: Random Forest
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA58);

        				Question qA59 = new Question(
        				    "Which AI technique is used for boosting?",
        				    Arrays.asList("AdaBoost", "Regression", "Classification", "Clustering"),
        				    0, // Correct: AdaBoost
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA59);

        				Question qA60 = new Question(
        				    "Which AI technique is used for bagging?",
        				    Arrays.asList("Bootstrap Aggregating", "Regression", "Classification", "Clustering"),
        				    0, // Correct: Bootstrap Aggregating
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA60);

        				Question qA61 = new Question(
        				    "Which AI technique is used for decision making under uncertainty?",
        				    Arrays.asList("Bayesian Networks", "Regression", "Classification", "Clustering"),
        				    0, // Correct: Bayesian Networks
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA61);

        				Question qA62 = new Question(
        				    "Which AI technique is used for probabilistic reasoning?",
        				    Arrays.asList("Naive Bayes", "Regression", "Classification", "Clustering"),
        				    0, // Correct: Naive Bayes
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA62);

        				Question qA63 = new Question(
        				    "Which AI technique is used for knowledge representation?",
        				    Arrays.asList("Semantic Networks", "Regression", "Classification", "Clustering"),
        				    0, // Correct: Semantic Networks
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA63);

        				Question qA64 = new Question(
        				    "Which AI technique is used for logical reasoning?",
        				    Arrays.asList("Propositional Logic", "Regression", "Classification", "Clustering"),
        				    0, // Correct: Propositional Logic
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA64);

        				Question qA65 = new Question(
        				    "Which AI technique is used for constraint satisfaction problems?",
        				    Arrays.asList("Backtracking", "Regression", "Classification", "Clustering"),
        				    0, // Correct: Backtracking
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA65);

        				Question qA66 = new Question(
        				    "Which AI technique is used for heuristic search?",
        				    Arrays.asList("Greedy Algorithm", "Regression", "Classification", "Clustering"),
        				    0, // Correct: Greedy Algorithm
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA66);

        				Question qA67 = new Question(
        				    "Which AI technique is used for adversarial search?",
        				    Arrays.asList("Minimax Algorithm", "Regression", "Classification", "Clustering"),
        				    0, // Correct: Minimax Algorithm
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA67);

        				Question qA68 = new Question(
        				    "Which AI technique is used for swarm intelligence?",
        				    Arrays.asList("Ant Colony Optimization", "Regression", "Classification", "Clustering"),
        				    0, // Correct: Ant Colony Optimization
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA68);

        				Question qA69 = new Question(
        				    "Which AI technique is used for fuzzy logic?",
        				    Arrays.asList("Fuzzy Sets", "Regression", "Classification", "Clustering"),
        				    0, // Correct: Fuzzy Sets
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA69);

        				Question qA70 = new Question(
        				    "Which AI technique is used for evolutionary computation?",
        				    Arrays.asList("Genetic Algorithms", "Regression", "Classification", "Clustering"),
        				    0, // Correct: Genetic Algorithms
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA70);

        				Question qA71 = new Question(
        				    "Which AI technique is used for deep reinforcement learning?",
        				    Arrays.asList("Deep Q-Networks", "Regression", "Classification", "Clustering"),
        				    0, // Correct: Deep Q-Networks
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA71);

        				Question qA72 = new Question(
        				    "Which AI technique is used for transfer learning?",
        				    Arrays.asList("Pretrained Models", "Regression", "Classification", "Clustering"),
        				    0, // Correct: Pretrained Models
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA72);

        				Question qA73 = new Question(
        				    "Which AI technique is used for federated learning?",
        				    Arrays.asList("Distributed Training", "Regression", "Classification", "Clustering"),
        				    0, // Correct: Distributed Training
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA73);

        				Question qA74 = new Question(
        				    "Which AI technique is used for meta-learning?",
        				    Arrays.asList("Learning to Learn", "Regression", "Classification", "Clustering"),
        				    0, // Correct: Learning to Learn
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA74);

        				Question qA75 = new Question(
        				    "Which AI technique is used for explainable AI?",
        				    Arrays.asList("Model Interpretability", "Regression", "Classification", "Clustering"),
        				    0, // Correct: Model Interpretability
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA75);

        				Question qA76 = new Question(
        				    "Which AI technique is used for adversarial examples?",
        				    Arrays.asList("Adversarial Training", "Regression", "Classification", "Clustering"),
        				    0, // Correct: Adversarial Training
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA76);

        				Question qA77 = new Question(
        				    "Which AI technique is used for generative modeling?",
        				    Arrays.asList("GAN", "Regression", "Classification", "Clustering"),
        				    0, // Correct: GAN
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA77);

        				Question qA78 = new Question(
        				    "Which AI technique is used for self-supervised learning?",
        				    Arrays.asList("Pretext Tasks", "Regression", "Classification", "Clustering"),
        				    0, // Correct: Pretext Tasks
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA78);

        				Question qA79 = new Question(
        				    "Which AI technique is used for continual learning?",
        				    Arrays.asList("Incremental Learning", "Regression", "Classification", "Clustering"),
        				    0, // Correct: Incremental Learning
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA79);

        				Question qA80 = new Question(
        				    "Which AI technique is used for multimodal learning?",
        				    Arrays.asList("Combining Text and Images", "Regression", "Classification", "Clustering"),
        				    0, // Correct: Combining Text and Images
        				    COURSE_AI
        				);
        				dao.saveQuestion(qA80);
        				Question qA81 = new Question(
        					    "Which AI technique is commonly used for image recognition?",
        					    Arrays.asList("Convolutional Neural Networks", "Decision Trees", "Naive Bayes", "Linear Regression"),
        					    0, // Correct: Convolutional Neural Networks
        					    COURSE_AI
        					);
        					dao.saveQuestion(qA81);

        					Question qA82 = new Question(
        					    "Which algorithm is widely used for reinforcement learning?",
        					    Arrays.asList("Q-Learning", "K-Means", "SVM", "Apriori"),
        					    0, // Correct: Q-Learning
        					    COURSE_AI
        					);
        					dao.saveQuestion(qA82);

        					Question qA83 = new Question(
        					    "Which AI technique is used for dimensionality reduction?",
        					    Arrays.asList("PCA", "Regression", "Clustering", "Classification"),
        					    0, // Correct: PCA
        					    COURSE_AI
        					);
        					dao.saveQuestion(qA83);

        					Question qA84 = new Question(
        					    "Which AI model is best suited for sequential data like text?",
        					    Arrays.asList("CNN", "RNN", "Decision Tree", "KNN"),
        					    1, // Correct: RNN
        					    COURSE_AI
        					);
        					dao.saveQuestion(qA84);

        					Question qA85 = new Question(
        					    "Which AI concept refers to systems that can learn from experience?",
        					    Arrays.asList("Machine Learning", "Deep Learning", "Expert Systems", "Knowledge Graphs"),
        					    0, // Correct: Machine Learning
        					    COURSE_AI
        					);
        					dao.saveQuestion(qA85);

        					Question qA86 = new Question(
        					    "Which AI technique is used for clustering unlabeled data?",
        					    Arrays.asList("K-Means", "SVM", "Decision Trees", "Naive Bayes"),
        					    0, // Correct: K-Means
        					    COURSE_AI
        					);
        					dao.saveQuestion(qA86);

        					Question qA87 = new Question(
        					    "Which AI model is inspired by the human brain?",
        					    Arrays.asList("Neural Networks", "Decision Trees", "Regression Models", "Bayesian Networks"),
        					    0, // Correct: Neural Networks
        					    COURSE_AI
        					);
        					dao.saveQuestion(qA87);

        					Question qA88 = new Question(
        					    "Which AI technique is used for anomaly detection?",
        					    Arrays.asList("Isolation Forest", "Linear Regression", "Naive Bayes", "KNN"),
        					    0, // Correct: Isolation Forest
        					    COURSE_AI
        					);
        					dao.saveQuestion(qA88);

        					Question qA89 = new Question(
        					    "Which AI technique is used for natural language processing?",
        					    Arrays.asList("Transformers", "Decision Trees", "K-Means", "Regression"),
        					    0, // Correct: Transformers
        					    COURSE_AI
        					);
        					dao.saveQuestion(qA89);

        					Question qA90 = new Question(
        					    "Which AI technique is used for recommendation systems?",
        					    Arrays.asList("Collaborative Filtering", "Clustering", "Regression", "Classification"),
        					    0, // Correct: Collaborative Filtering
        					    COURSE_AI
        					);
        					dao.saveQuestion(qA90);
        					Question qA91 = new Question(
        						    "The AI technique _________ is used for image recognition tasks.",
        						    Arrays.asList("CNN", "SVM", "Decision Tree", "Naive Bayes"),
        						    0,
        						    COURSE_AI
        						);
        						dao.saveQuestion(qA91);

        						Question qA92 = new Question(
        						    "The reinforcement learning algorithm _________ is used to maximize rewards.",
        						    Arrays.asList("Q-Learning", "K-Means", "PCA", "Gradient Descent"),
        						    0,
        						    COURSE_AI
        						);
        						dao.saveQuestion(qA92);

        						Question qA93 = new Question(
        						    "The dimensionality reduction technique _________ is used to reduce features.",
        						    Arrays.asList("PCA", "LDA", "t-SNE", "Autoencoder"),
        						    0,
        						    COURSE_AI
        						);
        						dao.saveQuestion(qA93);

        						Question qA94 = new Question(
        						    "The AI model _________ is used for sequential data like text.",
        						    Arrays.asList("RNN", "CNN", "GAN", "DBN"),
        						    0,
        						    COURSE_AI
        						);
        						dao.saveQuestion(qA94);

        						Question qA95 = new Question(
        						    "The concept of _________ refers to systems that learn from experience.",
        						    Arrays.asList("Machine Learning", "Deep Learning", "Artificial Intelligence", "Data Mining"),
        						    0,
        						    COURSE_AI
        						);
        						dao.saveQuestion(qA95);

        						Question qA96 = new Question(
        						    "The clustering algorithm _________ is used for unlabeled data.",
        						    Arrays.asList("K-Means", "DBSCAN", "Hierarchical Clustering", "Gaussian Mixture"),
        						    0,
        						    COURSE_AI
        						);
        						dao.saveQuestion(qA96);

        						Question qA97 = new Question(
        						    "The AI model _________ is inspired by the human brain.",
        						    Arrays.asList("Neural Networks", "Decision Trees", "Support Vector Machines", "Bayesian Networks"),
        						    0,
        						    COURSE_AI
        						);
        						dao.saveQuestion(qA97);

        						Question qA98 = new Question(
        						    "The technique _________ is used for anomaly detection in AI.",
        						    Arrays.asList("Isolation Forest", "K-Means", "Linear Regression", "Naive Bayes"),
        						    0,
        						    COURSE_AI
        						);
        						dao.saveQuestion(qA98);

        						Question qA99 = new Question(
        						    "The AI architecture _________ is widely used in NLP.",
        						    Arrays.asList("Transformers", "RNN", "CNN", "GAN"),
        						    0,
        						    COURSE_AI
        						);
        						dao.saveQuestion(qA99);

        						Question qA100 = new Question(
        						    "The technique _________ is used in recommendation systems.",
        						    Arrays.asList("Collaborative Filtering", "Content-Based Filtering", "Association Rules", "Matrix Factorization"),
        						    0,
        						    COURSE_AI
        						);// MCQ: AWS Compute
        						// Compute
        						Question qAWS1 = new Question(
        						    "Which AWS service provides scalable virtual servers in the cloud?",
        						    Arrays.asList("Amazon EC2", "Amazon S3", "Amazon RDS", "Amazon DynamoDB"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS1);

        						Question qAWS2 = new Question(
        						    "True or False: Amazon Lightsail is designed for simple workloads with easy setup.",
        						    Arrays.asList("True", "False"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS2);

        						Question qAWS3 = new Question(
        						    "AWS service _________ is used for running serverless compute functions.",
        						    Arrays.asList("AWS Lambda", "Amazon EC2", "Amazon S3", "Amazon CloudFront"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS3);

        						Question qAWS4 = new Question(
        						    "Which AWS service provides managed Kubernetes?",
        						    Arrays.asList("Amazon EKS", "Amazon ECS", "AWS Lambda", "Amazon RDS"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS4);

        						// Storage
        						Question qAWS5 = new Question(
        						    "Which AWS service is used for object storage?",
        						    Arrays.asList("Amazon S3", "Amazon EC2", "Amazon RDS", "Amazon DynamoDB"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS5);

        						Question qAWS6 = new Question(
        						    "True or False: Amazon Glacier is used for archival storage.",
        						    Arrays.asList("True", "False"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS6);

        						Question qAWS7 = new Question(
        						    "AWS service _________ provides block storage volumes for EC2.",
        						    Arrays.asList("Amazon EBS", "Amazon S3", "Amazon DynamoDB", "Amazon CloudFront"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS7);

        						Question qAWS8 = new Question(
        						    "Which AWS service is a managed file storage service for EC2?",
        						    Arrays.asList("Amazon EFS", "Amazon S3", "Amazon RDS", "Amazon CloudWatch"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS8);

        						// Networking
        						Question qAWS9 = new Question(
        						    "Which AWS service lets you create isolated networks?",
        						    Arrays.asList("Amazon VPC", "Amazon EC2", "Amazon RDS", "Amazon CloudFront"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS9);

        						Question qAWS10 = new Question(
        						    "True or False: AWS Route 53 is a DNS service.",
        						    Arrays.asList("True", "False"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS10);

        						Question qAWS11 = new Question(
        						    "AWS service _________ is used to connect on-premises networks to AWS securely.",
        						    Arrays.asList("AWS VPN", "Amazon S3", "Amazon DynamoDB", "Amazon CloudFront"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS11);

        						Question qAWS12 = new Question(
        						    "Which AWS service accelerates content delivery globally?",
        						    Arrays.asList("Amazon CloudFront", "Amazon S3", "Amazon RDS", "Amazon DynamoDB"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS12);

        						// Databases
        						Question qAWS13 = new Question(
        						    "Which AWS service is a managed relational database?",
        						    Arrays.asList("Amazon RDS", "Amazon DynamoDB", "Amazon S3", "Amazon CloudWatch"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS13);

        						Question qAWS14 = new Question(
        						    "True or False: Amazon DynamoDB is a NoSQL database.",
        						    Arrays.asList("True", "False"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS14);

        						Question qAWS15 = new Question(
        						    "AWS service _________ is used for data warehousing.",
        						    Arrays.asList("Amazon Redshift", "Amazon RDS", "Amazon S3", "Amazon CloudFront"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS15);

        						Question qAWS16 = new Question(
        						    "Which AWS service provides in-memory caching?",
        						    Arrays.asList("Amazon ElastiCache", "Amazon S3", "Amazon RDS", "Amazon CloudWatch"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS16);

        						// Security
        						Question qAWS17 = new Question(
        						    "Which AWS service manages user identities and permissions?",
        						    Arrays.asList("AWS IAM", "Amazon S3", "Amazon EC2", "Amazon CloudFront"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS17);

        						Question qAWS18 = new Question(
        						    "True or False: AWS Shield provides DDoS protection.",
        						    Arrays.asList("True", "False"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS18);

        						Question qAWS19 = new Question(
        						    "AWS service _________ is used for managing encryption keys.",
        						    Arrays.asList("AWS KMS", "Amazon S3", "Amazon DynamoDB", "Amazon CloudFront"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS19);

        						Question qAWS20 = new Question(
        						    "Which AWS service provides centralized logging and auditing?",
        						    Arrays.asList("AWS CloudTrail", "Amazon S3", "Amazon RDS", "Amazon CloudWatch"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS20);

        						// Monitoring
        						Question qAWS21 = new Question(
        						    "Which AWS service monitors resources and applications?",
        						    Arrays.asList("Amazon CloudWatch", "Amazon S3", "Amazon RDS", "Amazon DynamoDB"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS21);

        						Question qAWS22 = new Question(
        						    "True or False: AWS Config tracks resource configurations over time.",
        						    Arrays.asList("True", "False"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS22);

        						Question qAWS23 = new Question(
        						    "AWS service _________ is used for application performance monitoring.",
        						    Arrays.asList("AWS X-Ray", "Amazon S3", "Amazon DynamoDB", "Amazon CloudFront"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS23);

        						Question qAWS24 = new Question(
        						    "Which AWS service provides operational dashboards?",
        						    Arrays.asList("Amazon CloudWatch Dashboards", "Amazon S3", "Amazon RDS", "Amazon DynamoDB"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS24);

        						// Serverless
        						Question qAWS25 = new Question(
        						    "Which AWS service is used for event-driven serverless compute?",
        						    Arrays.asList("AWS Lambda", "Amazon EC2", "Amazon S3", "Amazon CloudFront"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS25);

        						Question qAWS26 = new Question(
        						    "True or False: AWS Step Functions orchestrate multiple serverless workflows.",
        						    Arrays.asList("True", "False"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS26);

        						Question qAWS27 = new Question(
        						    "AWS service _________ is used for serverless APIs.",
        						    Arrays.asList("Amazon API Gateway", "Amazon S3", "Amazon DynamoDB", "Amazon CloudFront"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS27);

        						Question qAWS28 = new Question(
        						    "Which AWS service is used for serverless data integration?",
        						    Arrays.asList("AWS Glue", "Amazon S3", "Amazon RDS", "Amazon CloudWatch"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS28);

        						// Containers
        						Question qAWS29 = new Question(
        						    "Which AWS service runs Docker containers?",
        						    Arrays.asList("Amazon ECS", "Amazon S3", "Amazon RDS", "Amazon CloudWatch"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS29);

        						Question qAWS30 = new Question(
        						    "True or False: Amazon EKS is a managed Kubernetes service.",
        						    Arrays.asList("True", "False"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS30);

        						Question qAWS31 = new Question(
        						    "AWS service _________ is used for container image storage.",
        						    Arrays.asList("Amazon ECR", "Amazon S3", "Amazon DynamoDB", "Amazon CloudFront"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS31);

        						Question qAWS32 = new Question(
        						    "Which AWS service provides serverless container execution?",
        						    Arrays.asList("AWS Fargate", "Amazon EC2", "Amazon RDS", "Amazon CloudWatch"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS32);

        						// Cost Management
        						Question qAWS33 = new Question(
        						    "Which AWS service helps estimate monthly costs?",
        						    Arrays.asList("AWS Pricing Calculator", "Amazon S3", "Amazon RDS", "Amazon DynamoDB"),
        						    0,
        						    COURSE_AWS
        						); dao.saveQuestion(qAWS33);

        						// Cost Management
        						Question qAWS34 = new Question(
        						    "True or False: AWS Budgets allows you to set custom cost and usage alerts.",
        						    Arrays.asList("True", "False"),
        						    0, // Correct: True
        						    COURSE_AWS
        						);
        						dao.saveQuestion(qAWS34);

        						Question qAWS35 = new Question(
        						    "AWS service _________ provides detailed billing and usage reports.",
        						    Arrays.asList("AWS Cost Explorer", "Amazon S3", "Amazon RDS", "Amazon CloudFront"),
        						    0,
        						    COURSE_AWS
        						);
        						dao.saveQuestion(qAWS35);

        						Question qAWS36 = new Question(
        						    "Which AWS service helps optimize costs by recommending reserved instances?",
        						    Arrays.asList("AWS Cost Explorer", "Amazon EC2", "Amazon DynamoDB", "Amazon CloudWatch"),
        						    0,
        						    COURSE_AWS
        						);
        						dao.saveQuestion(qAWS36);

        						Question qAWS37 = new Question(
        						    "True or False: AWS Pricing Calculator can estimate monthly costs before deploying resources.",
        						    Arrays.asList("True", "False"),
        						    0,
        						    COURSE_AWS
        						);
        						dao.saveQuestion(qAWS37);

        						// Hybrid & Migration
        						Question qAWS38 = new Question(
        						    "AWS service _________ is used for migrating databases to AWS.",
        						    Arrays.asList("AWS DMS", "Amazon RDS", "Amazon S3", "Amazon CloudFront"),
        						    0,
        						    COURSE_AWS
        						);
        						dao.saveQuestion(qAWS38);

        						Question qAWS39 = new Question(
        						    "Which AWS service is used for transferring large amounts of data physically to AWS?",
        						    Arrays.asList("AWS Snowball", "Amazon S3", "Amazon EC2", "Amazon CloudWatch"),
        						    0,
        						    COURSE_AWS
        						);
        						dao.saveQuestion(qAWS39);

        						Question qAWS40 = new Question(
        						    "True or False: AWS Outposts extends AWS infrastructure and services to on-premises environments.",
        						    Arrays.asList("True", "False"),
        						    0, // Correct: True
        						    COURSE_AWS
        						);
        						dao.saveQuestion(qAWS40);
        						// Compute
        						Question qAZ1 = new Question(
        						    "Which Azure service provides scalable virtual machines in the cloud?",
        						    Arrays.asList("Azure Virtual Machines", "Azure Blob Storage", "Azure SQL Database", "Azure Functions"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ1);

        						Question qAZ2 = new Question(
        						    "True or False: Azure App Service is used to host web applications.",
        						    Arrays.asList("True", "False"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ2);

        						Question qAZ3 = new Question(
        						    "Azure service _________ is used to run serverless compute functions.",
        						    Arrays.asList("Azure Functions", "Azure Virtual Machines", "Azure Blob Storage", "Azure Cosmos DB"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ3);

        						Question qAZ4 = new Question(
        						    "Which Azure service provides managed Kubernetes?",
        						    Arrays.asList("Azure Kubernetes Service", "Azure Blob Storage", "Azure SQL Database", "Azure Functions"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ4);

        						// Storage
        						Question qAZ5 = new Question(
        						    "Which Azure service is used for object storage?",
        						    Arrays.asList("Azure Blob Storage", "Azure SQL Database", "Azure Functions", "Azure Cosmos DB"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ5);

        						Question qAZ6 = new Question(
        						    "True or False: Azure Files provides shared file storage accessible via SMB protocol.",
        						    Arrays.asList("True", "False"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ6);

        						Question qAZ7 = new Question(
        						    "Azure service _________ is used for NoSQL document storage.",
        						    Arrays.asList("Azure Cosmos DB", "Azure Blob Storage", "Azure SQL Database", "Azure Functions"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ7);

        						Question qAZ8 = new Question(
        						    "Which Azure service provides disk storage for VMs?",
        						    Arrays.asList("Azure Disk Storage", "Azure Blob Storage", "Azure SQL Database", "Azure Cosmos DB"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ8);

        						// Networking
        						Question qAZ9 = new Question(
        						    "Which Azure service lets you create isolated networks?",
        						    Arrays.asList("Azure Virtual Network", "Azure Blob Storage", "Azure SQL Database", "Azure Functions"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ9);

        						Question qAZ10 = new Question(
        						    "True or False: Azure DNS is used to host domain name services.",
        						    Arrays.asList("True", "False"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ10);

        						Question qAZ11 = new Question(
        						    "Azure service _________ is used to connect on-premises networks to Azure securely.",
        						    Arrays.asList("Azure VPN Gateway", "Azure Blob Storage", "Azure SQL Database", "Azure Functions"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ11);

        						Question qAZ12 = new Question(
        						    "Which Azure service accelerates content delivery globally?",
        						    Arrays.asList("Azure CDN", "Azure Blob Storage", "Azure SQL Database", "Azure Cosmos DB"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ12);

        						// Databases
        						Question qAZ13 = new Question(
        						    "Which Azure service is a managed relational database?",
        						    Arrays.asList("Azure SQL Database", "Azure Blob Storage", "Azure Functions", "Azure Cosmos DB"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ13);

        						Question qAZ14 = new Question(
        						    "True or False: Azure Cosmos DB supports multiple data models including key-value and graph.",
        						    Arrays.asList("True", "False"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ14);

        						Question qAZ15 = new Question(
        						    "Azure service _________ is used for large-scale data warehousing.",
        						    Arrays.asList("Azure Synapse Analytics", "Azure SQL Database", "Azure Blob Storage", "Azure Functions"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ15);

        						Question qAZ16 = new Question(
        						    "Which Azure service provides in-memory caching?",
        						    Arrays.asList("Azure Cache for Redis", "Azure Blob Storage", "Azure SQL Database", "Azure Cosmos DB"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ16);

        						// Security
        						Question qAZ17 = new Question(
        						    "Which Azure service manages user identities and permissions?",
        						    Arrays.asList("Azure Active Directory", "Azure Blob Storage", "Azure SQL Database", "Azure Functions"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ17);

        						Question qAZ18 = new Question(
        						    "True or False: Azure Security Center provides unified security management.",
        						    Arrays.asList("True", "False"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ18);

        						Question qAZ19 = new Question(
        						    "Azure service _________ is used for managing encryption keys.",
        						    Arrays.asList("Azure Key Vault", "Azure Blob Storage", "Azure SQL Database", "Azure Functions"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ19);

        						Question qAZ20 = new Question(
        						    "Which Azure service provides centralized logging and auditing?",
        						    Arrays.asList("Azure Monitor Logs", "Azure Blob Storage", "Azure SQL Database", "Azure Functions"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ20);

        						// Monitoring
        						Question qAZ21 = new Question(
        						    "Which Azure service monitors resources and applications?",
        						    Arrays.asList("Azure Monitor", "Azure Blob Storage", "Azure SQL Database", "Azure Functions"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ21);

        						Question qAZ22 = new Question(
        						    "True or False: Azure Application Insights tracks application performance.",
        						    Arrays.asList("True", "False"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ22);

        						Question qAZ23 = new Question(
        						    "Azure service _________ is used for tracking resource configurations.",
        						    Arrays.asList("Azure Policy", "Azure Blob Storage", "Azure SQL Database", "Azure Functions"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ23);

        						Question qAZ24 = new Question(
        						    "Which Azure service provides operational dashboards?",
        						    Arrays.asList("Azure Monitor Dashboards", "Azure Blob Storage", "Azure SQL Database", "Azure Functions"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ24);

        						// Serverless
        						Question qAZ25 = new Question(
        						    "Which Azure service is used for event-driven serverless compute?",
        						    Arrays.asList("Azure Functions", "Azure Virtual Machines", "Azure Blob Storage", "Azure Cosmos DB"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ25);

        						Question qAZ26 = new Question(
        						    "True or False: Azure Logic Apps orchestrate workflows across services.",
        						    Arrays.asList("True", "False"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ26);

        						Question qAZ27 = new Question(
        						    "Azure service _________ is used for serverless APIs.",
        						    Arrays.asList("Azure API Management", "Azure Blob Storage", "Azure SQL Database", "Azure Functions"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ27);

        						Question qAZ28 = new Question(
        						    "Which Azure service is used for serverless data integration?",
        						    Arrays.asList("Azure Data Factory", "Azure Blob Storage", "Azure SQL Database", "Azure Functions"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ28);

        						// Containers
        						Question qAZ29 = new Question(
        						    "Which Azure service runs Docker containers?",
        						    Arrays.asList("Azure Container Instances", "Azure Blob Storage", "Azure SQL Database", "Azure Functions"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ29);

        						Question qAZ30 = new Question(
        						    "True or False: Azure Kubernetes Service is a managed Kubernetes service.",
        						    Arrays.asList("True", "False"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ30);

        						Question qAZ31 = new Question(
        						    "Azure service _________ is used for container image storage.",
        						    Arrays.asList("Azure Container Registry", "Azure Blob Storage", "Azure SQL Database", "Azure Functions"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ31);

        						Question qAZ32 = new Question(
        						    "Which Azure service provides serverless container execution?",
        						    Arrays.asList("Azure Container Instances", "Azure Virtual Machines", "Azure SQL Database", "Azure Functions"),
        						    0,
        						    COURSE_AZURE
        						); dao.saveQuestion(qAZ32);

        						// Cost Management
        						// Cost Management
        						Question qAZ33 = new Question(
        						    "Which Azure service helps estimate monthly costs?",
        						    Arrays.asList("Azure Pricing Calculator", "Azure Blob Storage", "Azure SQL Database", "Azure Functions"),
        						    0,
        						    COURSE_AZURE
        						);
        						dao.saveQuestion(qAZ33);

        						Question qAZ34 = new Question(
        						    "True or False: Azure Cost Management + Billing allows you to track and control spending.",
        						    Arrays.asList("True", "False"),
        						    0, // Correct: True
        						    COURSE_AZURE
        						);
        						dao.saveQuestion(qAZ34);

        						Question qAZ35 = new Question(
        						    "Azure service _________ provides detailed billing and usage reports.",
        						    Arrays.asList("Azure Cost Management", "Azure Blob Storage", "Azure SQL Database", "Azure Functions"),
        						    0,
        						    COURSE_AZURE
        						);
        						dao.saveQuestion(qAZ35);

        						Question qAZ36 = new Question(
        						    "Which Azure service helps optimize costs by recommending reserved instances?",
        						    Arrays.asList("Azure Advisor", "Azure Blob Storage", "Azure SQL Database", "Azure Functions"),
        						    0,
        						    COURSE_AZURE
        						);
        						dao.saveQuestion(qAZ36);

        						Question qAZ37 = new Question(
        						    "True or False: Azure Pricing Calculator can estimate monthly costs before deploying resources.",
        						    Arrays.asList("True", "False"),
        						    0, // Correct: True
        						    COURSE_AZURE
        						);
        						dao.saveQuestion(qAZ37);

        						// Migration & Hybrid
        						Question qAZ38 = new Question(
        						    "Azure service _________ is used for migrating databases to Azure.",
        						    Arrays.asList("Azure Database Migration Service", "Azure Blob Storage", "Azure SQL Database", "Azure Functions"),
        						    0,
        						    COURSE_AZURE
        						);
        						dao.saveQuestion(qAZ38);

        						Question qAZ39 = new Question(
        						    "Which Azure service is used for transferring large amounts of data physically to Azure?",
        						    Arrays.asList("Azure Data Box", "Azure Blob Storage", "Azure Virtual Machines", "Azure Functions"),
        						    0,
        						    COURSE_AZURE
        						);
        						dao.saveQuestion(qAZ39);

        						Question qAZ40 = new Question(
        						    "True or False: Azure Stack extends Azure services to on-premises environments.",
        						    Arrays.asList("True", "False"),
        						    0, // Correct: True
        						    COURSE_AZURE
        						);
        						dao.saveQuestion(qAZ40);

        System.out.println("\nDatabase initialization complete. Total unique questions saved across all courses.");
    }
}