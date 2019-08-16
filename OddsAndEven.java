import java.util.Scanner;

public class OddsAndEven {
    public static String playerChoice, compChoice, name, result;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String [] args){
        preStart();
        dash();
        leGame();

    }

    public static void preStart(){
        System.out.println("Let's play a game called \"Odds and Evens\"");
        System.out.print("What is your name? ");
        name = sc.nextLine();
        System.out.print("Hi "+ name +", which do you choose? (O)dds or (E)vens? ");
        String s = sc.nextLine();

        if (s.equals("O")){
            playerChoice = "odds";
            compChoice = "evens";
            System.out.println(name + " has picked "+ playerChoice+ "! The computer will be "+ compChoice +".");
        }
        else if(s.equals("E")) {
            playerChoice = "evens";
            compChoice = "odds";
            System.out.println(name + " has picked " + playerChoice + "! The computer will be " + compChoice + ".");
        }

    }

    public static void dash(){
        for(int i = 0; i < 40; i++) System.out.print("-");
        System.out.println();
        System.out.println();
    }

    public static void leGame(){
        System.out.print("How many \"fingers\" do you put out? ");
        int pFingers = sc.nextInt();
        int compFingers = (int) Math.random()*6 + 1;
        System.out.println("The computer plays "+compFingers +"\"fingers\".");
        OddsAndEven.dash();

        int sum = pFingers + compFingers;
        if ( sum % 2 == 0){
            result = "evens";
        }
        else result = "odd";
        System.out.println(pFingers +" + " + compFingers + " = "+ sum);
        System.out.println(sum+" is ..."+ result +"!");
        if(result.equals(playerChoice)){
            System.out.println("That means "+ name +" wins! :)");
        }
        else System.out.println("The Computer wins! :(");
    }

}
