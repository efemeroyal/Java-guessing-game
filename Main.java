import java.util.Random;
import java.util.Scanner;

/* KEY NOTES
* 1. Update the second do-while loop to stop after a certain amount of trials
* 2. Correct the random generator to generate after every level
* 3. Correct the player name to be inputted then passed as a parameter in the player class
* */

class Player{
    String name;
    String ID;
    int currentLevel = 1;
    int range = 10;
    int score = 0;
    int randomNumber = this.generateRandomNumber(this.range);



    public Player(String name, String ID){
        this.name = name;
        this.ID = ID;
    }

    private int generateRandomNumber(int max){
        Random random = new Random();
        int randomNumber = random.nextInt(max) + 1;
        return randomNumber;
    }

    private int getChoice(){
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
//        scanner.close();
        return  choice;
    }
    private String getName(){
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
//        scanner.close();
        return  name;
    }

    void play(){
        System.out.print("Enter your name: ");
        this.name = this.getName();
        int userChoice;
        int trials = 0;
        do{
            System.out.println("Level " + this.currentLevel);
            do {
                System.out.print("Guess the number: ");
                userChoice = this.getChoice();

                if (userChoice > this.randomNumber) {
                    System.out.println("Too high!!");
                }
                if (userChoice < this.randomNumber) {
                    System.out.println("Too low!!");
                }
                trials++;
            } while (!(userChoice == this.randomNumber) && trials < 3);

            if (this.currentLevel == 1) {
                this.score += 10;
                this.range = 10;
                System.out.println(this.score);
            }
            if (this.currentLevel == 2) {
                this.score += 15;
                this.range = 20;
                System.out.println("Your score: " + this.score);
            }
            if (this.currentLevel == 3) {
                this.score += 20;
                this.range = 100;
                System.out.println(this.score);
            }
            System.out.println("Correct!!");
            System.out.println("Moving to level " + ++this.currentLevel);
            randomNumber = this.generateRandomNumber(this.range);

        }while(this.currentLevel <= 3);
    }



}

public class Main {



    public static void welcome(){
        System.out.println("====== Welcome to Tk's Guessing Game ======");
        System.out.println("Where a random number will be generated based on your level and you are " +
                "supposed to guess that number");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Your score will increase after correctly guessing the number and your level " +
                "will increase\n The higher the level the more difficult it gets to guess that number");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("GOOD LUCK!!");


    }

    public static void main(String[] args) {

        welcome();
        int[] highestScore;
       Player player1 = new Player("Royal Tk", "PGG-1234");
       player1.play();
    }
}