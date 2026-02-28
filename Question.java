package User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "quiz_question")
public class Question implements Serializable { 
    
    private static final long serialVersionUID = 1L; 

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "question_text", length = 500, nullable = false)
    private String questionText;

    // FIELD: Used to categorize questions by course (e.g., "Python", "Indian Constitution")
    @Column(name = "course_name", nullable = false, length = 100)
    private String courseName; 

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
        name = "question_options", 
        joinColumns = @JoinColumn(name = "question_id")
    )
    @Column(name = "option_text", length = 255)
    @OrderColumn(name = "option_index")
    private List<String> options; 

    @Column(name = "correct_answer_index", nullable = false)
    private int correctAnswerIndex; 

    // Constructors
    public Question() {
    }

    // Constructor used by your Initializer to set the courseName
    public Question(String questionText, List<String> options, int correctAnswerIndex, String courseName) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
        this.courseName = courseName;
    }

    // Getters and Setters (omitted for brevity)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getQuestionText() { return questionText; }
    public void setQuestionText(String questionText) { this.questionText = questionText; }
    public List<String> getOptions() { return options; }
    public void setOptions(List<String> options) { this.options = options; }
    public int getCorrectAnswerIndex() { return correctAnswerIndex; }
    public void setCorrectAnswerIndex(int correctAnswerIndex) { this.correctAnswerIndex = correctAnswerIndex; }
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
}