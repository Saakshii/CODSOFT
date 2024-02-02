package codsoft;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizApp {
    private static final String[] questions = {
            "What is the chemical symbol for the element gold?",
            "Who wrote the play 'Romeo and Juliet'?",
            "What is the capital of France?",
            "Who painted the Mona Lisa?",
            "What is the largest planet in our solar system?",
            "What is the National Fruit of India?"
    };

    private static final String[][] options = {
            {"a) Go" ,"b) Au","c) Gd","d) Ag"},
            {"a) William Shakespeare","b) Charles Dickens","c) Jane Austen","d) Mark Twain"},
            {"a) London", "b) Paris", "c) Berlin", "d) Madrid"},
            {"a) Vincent van Gogh", "b) Leonardo da Vinci", "c) Pablo Picasso", "d) Michelangelo"},
            {"a) Earth", "b) Jupiter", "c) Mars", "d) Saturn"},
            {"a) Apple", "b) Guava", "c) Mango", "d) Litchi"}
    };

    private static final char[] answers = {'b','a','b', 'b', 'b','c'};

    private static int score = 0;
    private static int currentQuestion = 0;
    private static int incorrectAnswer;
    private static Timer timer;
    private static final int TIME_LIMIT = 10; // Time limit for each question in seconds

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        timer = new Timer();

        displayQuestionAndStartTimer();

        while (currentQuestion < questions.length) {
            System.out.print("Enter your answer (a, b, c, or d): ");
            char userAnswer = scanner.next().charAt(0);
            checkAnswerAndProceed(userAnswer);
        }

        timer.cancel(); // Cancel the timer after all questions are answered

        System.out.println("\nQuiz completed! Your final score is: " + score + "/" + questions.length);
        System.out.println("Correct Answer: "+score);
        incorrectAnswer=questions.length-score;
        System.out.println("Incorrect Answer: "+incorrectAnswer);
    }

    private static void displayQuestionAndStartTimer() {
        System.out.println("Question " + (currentQuestion + 1) + ": " + questions[currentQuestion]);
        for (String option : options[currentQuestion]) {
            System.out.println(option);
        }

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up!");
                checkAnswerAndProceed(' '); // Proceed with no answer when time's up
            }
        }, TIME_LIMIT * 1000); // Convert time limit to milliseconds
    }

    private static void checkAnswerAndProceed(char userAnswer) {
        if (userAnswer == answers[currentQuestion]) {
            System.out.println("Correct!");
            score++;
        } else if (userAnswer !=' ') {
            System.out.println("Incorrect!");
        }

        currentQuestion++;
        if (currentQuestion < questions.length) {
            displayQuestionAndStartTimer();
        }
    }
}