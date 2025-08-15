package quizApp;
import java.util.*;

class Question {
    String questionText;
    List<String> options;
    int correctOption;

    public Question(String questionText, List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public void display() {
        System.out.println("\n" + questionText);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctOption;
    }
}
public class QuizApp {

	 static Scanner sc = new Scanner(System.in);
	    static Map<String, List<Question>> quizCategories = new HashMap<>();

	public static void main(String[] args) {
		
		 loadQuestions();
	        System.out.println(" Welcome to the  Quiz Game!");
	        System.out.println("Note :: Click Enter For Skipping Question!");

	        while (true) {
	            System.out.println("\nAvailable Quiz Categories:");
	            for (String key : quizCategories.keySet()) {
	                System.out.println("- " + key);
	            }

	            System.out.print("\nEnter quiz name to start or 'exit' to quit: ");
	            String choice = sc.nextLine().trim();

	            if (choice.equalsIgnoreCase("exit")) {
	                System.out.println(" Exiting the game. Thanks for playing!");
	                break;
	            }

	            if (quizCategories.containsKey(choice)) {
	                startQuiz(quizCategories.get(choice));
	            } else {
	                System.out.println(" Invalid quiz name. Please try again.");
	            }
	        }
	    }

	    public static void startQuiz(List<Question> questions) {
	        int score = 0, correct = 0, skipped = 0;

	        System.out.println("\n Quiz Started! Type:");
	        System.out.println("- Answer (1-4)");
	        System.out.println("- 'skip' to skip");
	        System.out.println("- 'end' to quit quiz early");

	        for (int i = 0; i < questions.size(); i++) {
	            Question q = questions.get(i);
	            q.display();

	            System.out.print("Your choice: ");
	            String input = sc.nextLine().trim();

	            if (input.equalsIgnoreCase("end")) {
	                break;
	            } else if (input.equalsIgnoreCase("skip")) {
	                skipped++;
	                continue;
	            }

	            try {
	                int answer = Integer.parseInt(input);
	                if (q.isCorrect(answer)) {
	                    System.out.println(" Correct!");
	                    score++;
	                    correct++;
	                } else {
	                    System.out.println(" Incorrect.");
	                }
	            } catch (NumberFormatException e) {
	                System.out.println(" Invalid input. Skipping question.");
	                skipped++;
	            }
	        }

	        System.out.println("\n Quiz Completed!");
	        System.out.println("Total Questions: " + questions.size());
	        System.out.println("Correct Answers: " + correct);
	        System.out.println("Skipped Questions: " + skipped);
	        System.out.println("Final Score: " + score + "/" + questions.size());
	    }

	    public static void loadQuestions() {
	        // Existing categories
	        quizCategories.put("Java", Arrays.asList(
	            new Question("What is JVM?", Arrays.asList("Java Virtual Machine", "Java Variable Method", "Just Virtual Method", "None"), 1),
	            new Question("Keyword for inheritance in Java?", Arrays.asList("super", "this", "extends", "inherits"), 3),
	            new Question("Who developed Java?", Arrays.asList("Oracle", "Google", "Sun Microsystems", "IBM"), 3),
	            new Question("Non-primitive datatype?", Arrays.asList("int", "boolean", "String", "double"), 3),
	            new Question("Default boolean value?", Arrays.asList("true", "false", "0", "null"), 2),
	            new Question("Java supports?", Arrays.asList("OOP", "Functional", "Procedural", "All"), 4),
	            new Question("Constructor name should be?", Arrays.asList("Same as class", "Any name", "Static", "void"), 1),
	            new Question("Which is not a loop?", Arrays.asList("for", "while", "do-while", "switch"), 4),
	            new Question("Can we overload main()?", Arrays.asList("Yes", "No", "Maybe", "Only once"), 1),
	            new Question("Default package in Java?", Arrays.asList("java.io", "java.lang", "java.util", "java.default"), 2)
	        ));

	        quizCategories.put("GK", Arrays.asList(
	            new Question("Capital of India?", Arrays.asList("Mumbai", "Delhi", "Kolkata", "Chennai"), 2),
	            new Question("President of India (2025)?", Arrays.asList("Narendra Modi", "Droupadi Murmu", "Kovind", "Shah"), 2),
	            new Question("National Animal?", Arrays.asList("Lion", "Tiger", "Elephant", "Horse"), 2),
	            new Question("Largest ocean?", Arrays.asList("Indian", "Pacific", "Atlantic", "Arctic"), 2),
	            new Question("Discovered gravity?", Arrays.asList("Newton", "Einstein", "Galileo", "Tesla"), 1),
	            new Question("States in India?", Arrays.asList("28", "29", "27", "26"), 1),
	            new Question("First Indian in space?", Arrays.asList("Rakesh Sharma", "Kalpana", "Sunita", "APJ Kalam"), 1),
	            new Question("Currency of Japan?", Arrays.asList("Yuan", "Yen", "Won", "Dollar"), 2),
	            new Question("Largest planet?", Arrays.asList("Mars", "Earth", "Jupiter", "Saturn"), 3),
	            new Question("Sun rises from?", Arrays.asList("North", "West", "East", "South"), 3)
	        ));

	        // New Categories 👇

	        quizCategories.put("Sports", Arrays.asList(
	            new Question("How many players in a cricket team?", Arrays.asList("10", "11", "12", "9"), 2),
	            new Question("Who won FIFA 2022?", Arrays.asList("France", "Argentina", "Germany", "Brazil"), 2),
	            new Question("Which sport uses a shuttlecock?", Arrays.asList("Tennis", "Badminton", "Squash", "Golf"), 2),
	            new Question("Olympics are held every?", Arrays.asList("2 years", "3 years", "4 years", "5 years"), 3),
	            new Question("Sachin Tendulkar is known as?", Arrays.asList("Wall", "Captain Cool", "God of Cricket", "Master"), 3),
	            new Question("Which country hosts Wimbledon?", Arrays.asList("USA", "France", "UK", "Australia"), 3),
	            new Question("Which sport is PV Sindhu from?", Arrays.asList("Badminton", "Tennis", "Wrestling", "Hockey"), 1),
	            new Question("Which sport is Messi known for?", Arrays.asList("Rugby", "Football", "Tennis", "Cricket"), 2),
	            new Question("How many rings in Olympics logo?", Arrays.asList("4", "5", "6", "7"), 2),
	            new Question("Full form of IPL?", Arrays.asList("India Pro League", "Indian Premier League", "International Premier League", "Indian Players League"), 2)
	        ));

	        quizCategories.put("English", Arrays.asList(
	            new Question("Plural of 'Child'?", Arrays.asList("Childs", "Children", "Childes", "Childrens"), 2),
	            new Question("Synonym of 'Happy'?", Arrays.asList("Sad", "Glad", "Mad", "Angry"), 2),
	            new Question("Antonym of 'Fast'?", Arrays.asList("Quick", "Slow", "Speed", "Light"), 2),
	            new Question("Word for one who reads books?", Arrays.asList("Reader", "Booker", "Wiser", "Thinker"), 1),
	            new Question("Correct spelling?", Arrays.asList("Definately", "Definetely", "Definitely", "Defanitely"), 3),
	            new Question("'He ___ going home.'", Arrays.asList("is", "are", "am", "were"), 1),
	            new Question("Past tense of 'Go'?", Arrays.asList("Gone", "Went", "Go", "Goes"), 2),
	            new Question("Article used before vowel?", Arrays.asList("a", "an", "the", "none"), 2),
	            new Question("Synonym of 'Begin'?", Arrays.asList("Stop", "Start", "Leave", "End"), 2),
	            new Question("Opposite of 'Victory'?", Arrays.asList("Lose", "Loss", "Defeat", "Win"), 3)
	        ));

	        quizCategories.put("Bollywood", Arrays.asList(
	            new Question("Which actor is known as King Khan?", Arrays.asList("Salman", "SRK", "Aamir", "Akshay"), 2),
	            new Question("Movie with 'Bajrangi' character?", Arrays.asList("Dangal", "PK", "Bajrangi Bhaijaan", "Sultan"), 3),
	            new Question("Director of '3 Idiots'?", Arrays.asList("KJo", "Raju Hirani", "Rohit Shetty", "Anurag"), 2),
	            new Question("Who played 'Munna Bhai'?", Arrays.asList("Sanjay Dutt", "Salman Khan", "SRK", "Irrfan"), 1),
	            new Question("Movie: 'All is Well' dialogue?", Arrays.asList("3 Idiots", "PK", "Tamasha", "DDLJ"), 1),
	            new Question("Actor of 'Uri'?", Arrays.asList("Varun", "Vicky Kaushal", "Ranbir", "Rajkumar Rao"), 2),
	            new Question("Movie: 'Tujh Mein Rab Dikhta Hai'?", Arrays.asList("Fan", "Rab Ne Bana Di Jodi", "Veer Zaara", "Kal Ho Na Ho"), 2),
	            new Question("Which actor was in 'Pathaan'?", Arrays.asList("SRK", "Salman", "Aamir", "John"), 1),
	            new Question("Amitabh Bachchan's debut?", Arrays.asList("Zanjeer", "Anand", "Saat Hindustani", "Sholay"), 3),
	            new Question("Which movie had 'Naatu Naatu'?", Arrays.asList("RRR", "Pushpa", "Baahubali", "Jawan"), 1)
	        ));
	    }
	}

		  
	
	
	

