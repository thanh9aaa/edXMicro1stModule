import java.util.Scanner;

public class MazeRunner {
    public static Scanner sc = new Scanner(System.in);
    public static Maze myMap = new Maze();
    public static int stepCount, misStep = 0;
    public static String userMove;

    public static void main(String[] args){
        intro();
        while (!myMap.didIWin()) {
            System.out.print("Where do you want to move? ");
            userMove = sc.next();
            //Take user input and move them
            if (userMove.matches("R|L|U|D")) {
                userChoice();
            }
            stepCounter();
            if (misStepCount() == true) {
                System.out.print(misStep);
                break;
            }

        }
        if (myMap.didIWin() && stepCount < 101) {
            Win();
        }
    }

    public static void intro(){
        System.out.println("Welcome to the maze, try your best to leave or you will be haunted by me!");
        System.out.println("REMEMBER: you only have 100 steps to make, more than that, welp!");
        System.out.println("Now, let 's face your destiny!");
        System.out.println("Ah, please press nothing but R|L|U|D or more than 5 random shiet, you lose");
        myMap.printMap();
    }

    public static void userChoice(){
            if (userMove.equals("R") && myMap.canIMoveRight()) {
                myMap.moveRight();
                stepCount++;
            } else if (userMove.equals("L") && myMap.canIMoveLeft()) {
                myMap.moveLeft();
                stepCount++;
            } else if (userMove.equals("U") && myMap.canIMoveUp()) {
                myMap.moveUp();
                stepCount++;
            } else if (userMove.equals("D") && myMap.canIMoveDown()) {
                myMap.moveDown();
                stepCount++;
            }
            else if (myMap.isThereAPit(userMove)) pit(userMove);
            myMap.printMap();
    }

    public static boolean misStepCount() {
        if (!userMove.equals("R") && !userMove.equals("L") && !userMove.equals("U") && !userMove.equals("D")) {
            misStep++;
            if (misStep == 5) {
                return true;
            }
        }
        return false;
    }

    public static void Win(){
        System.out.println("AAAAARRRRGGGGg, my bad, i will have my revenge next time!!!");

    }
    public static void Lose(){
        System.out.println("CONGRATULATION, you are not failed me at all!");
    }

    public static void pit(String userMove){
        //Check for pit
        System.out.print("A hole apeals ahead, wanna discover it? (y|n) Kappa");
            String jump = sc.next();
            if(jump.equalsIgnoreCase("y")){
                System.out.println("You lose");
                Lose();}

            else if(jump.equalsIgnoreCase("n")){
                myMap.jumpOverPit(userMove);
                stepCount += 2;}
            else if (!jump.matches("y|n")){
                System.out.print("A hole apeals ahead, wanna discover it? (y|n) Kappa");
                jump = sc.next();
                if (!jump.matches("y|n"))
                Lose();
                System.exit(0);
            }
    }

    public static void stepCounter(){
        switch (stepCount){
            case 50: System.out.println("Half of your chances are gone ( : ");
            case 75: System.out.println("25 more moves");
            case 90: System.out.println("10!");
            case 101: Lose();
            break;
        }
    }
}
