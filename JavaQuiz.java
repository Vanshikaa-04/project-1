import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String text;
    private String[] options;
    private int correctAnswer;

    public Question(String text, String[] options, int correctAnswer) {
        this.text = text;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getText() {
        return text;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

class Quiz {
    private List<Question> questions;

    public Quiz() {
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void takeQuiz() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + question.getText());
            for (int j = 0; j < question.getOptions().length; j++) {
                System.out.println((j + 1) + ". " + question.getOptions()[j]);
            }

            System.out.print("Enter your answer (1-" + question.getOptions().length + "): ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == question.getCorrectAnswer()) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is " + question.getCorrectAnswer());
            }

            System.out.println();
        }

        System.out.println("Your final score is " + score + " out of " + questions.size());

        System.out.print("Would you like to provide feedback? (yes/no): ");
        String feedbackResponse = scanner.next();

        if (feedbackResponse.equalsIgnoreCase("yes")) {
            System.out.print("Please enter your feedback: ");
            String feedback = scanner.next();
            System.out.println("Thank you for your feedback!");
        }
    }
}

public class JavaQuiz {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        // Add questions to the quiz
        quiz.addQuestion(new Question("Java is which type of language ?", new String[] {"Object Oriented", "Procedural", "High level", "Structural"}, 1));
        quiz.addQuestion(new Question("Which of the following java does not support ?", new String[] {"Array", "Loops", "Structure", "Inheritance"}, 3));
        quiz.addQuestion(new Question("Java was invented by ?", new String[] {"James Gosling", "Dennis Ritchie", "Bjarne Stoustrope", " Rahul Thomas "}, 1));
        quiz.addQuestion(new Question("Which keyword is used to declare constant in java ?", new String[] {"Final", "Static", "Private", "Enum"}, 1));

        // Take the quiz
        quiz.takeQuiz();
    }
}