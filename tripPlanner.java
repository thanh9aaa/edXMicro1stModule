import java.util.Scanner;

public class tripPlanner {
    public static void main(String [] args){
        intro();
        budget();
        time();
        distance();
    }

    public static void intro(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name? ");
        String name = sc.nextLine();
        System.out.print("Nice to meet you " + name + ", where are you travelling to? ");
        String location = sc.nextLine();
        System.out.println("Great! " + location + "sounds like a great trip");
        System.out.println("***********\n\n");
    }

    public static void budget() {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many days are you going to spend travelling? ");
        int days = sc.nextInt();
        System.out.print("How much money, in USD, are you planning to spend on your trip? ");
        int usd = sc.nextInt();
        System.out.print("What is the three letter currency symbol for your travel destination? ");
        String curr = sc.next();
        System.out.print("How many " + curr + " are there in 1 USD? ");
        double exchange = sc.nextDouble();

        int hours = days * 24;
        int minutes = hours * 60;
        double currEx = (double)usd*exchange;
        double usdPerDay = (double)usd / days;
        String usdPD = String.format("%.2f", usdPerDay);
        String currEPD = String.format("%.2f", currEx/days);

        System.out.println("\n\nIf you are travelling for "+days + "days in the same as "+hours+" hours or "+minutes + " minutes");
        System.out.println("If you are going to spend $"+usd+" USD that means per day you can spend up to $"+usdPD +" USD");
        System.out.println("Your total budget in "+curr+" is "+ currEx +" "+ curr+", which per day is "+ currEPD+ " "+ curr);
        System.out.println("***********\n\n");
    }

    public static void time(){
        Scanner sc = new Scanner(System.in);
        System.out.print("What is the time difference, in hours, between your home and your destination? ");
        int time = sc.nextInt();
        System.out.println("That means that when it is midnight at home it will be "+ time +":00 in your travel destination");
        System.out.println("and when it is noon at home it will be "+(time +12) +":00");
        System.out.println("***********\n\n");
    }

    public static void distance(){
        Scanner sc = new Scanner(System.in);
        System.out.print("What is the square area of your destination country in km2? ");
        int area = sc.nextInt();
        String areaEx = String.format("%.2f", area *0.38610215854245);
        System.out.println("In miles that is "+ areaEx);
    }
}
