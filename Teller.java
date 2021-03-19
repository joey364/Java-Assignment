import java.util.Scanner;

public class Teller {
    int option;
    int numberOfGumsSold;
    int numberOfChocolateSold;
    int numberOfJuiceSold;
    int numberOfPopcornSold;

    public int getOption() {
        return this.option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public int getNumberOfGumsSold() {
        return this.numberOfGumsSold;
    }

    public void incrementNumberOfGumsSold() {
        this.numberOfGumsSold++;
    }

    public int getNumberOfChocolateSold() {
        return this.numberOfChocolateSold;
    }

    public void incrementNumberOfChocolateSold() {
        this.numberOfChocolateSold++;
    }

    public int getNumberOfJuiceSold() {
        return this.numberOfJuiceSold;
    }

    public void incrementNumberOfJuiceSold() {
        this.numberOfJuiceSold++;
    }

    public int getNumberOfPopcornSold() {
        return this.numberOfPopcornSold;
    }

    public void incrementNumberOfPopcornSold() {
        this.numberOfPopcornSold++;
    }

    public static void main(String[] args) {

        Scanner keyIn = new Scanner(System.in);

        Teller teller = new Teller();

        System.out.println("Enter what you want");

        while (keyIn.hasNextInt()) {
            teller.setOption(keyIn.nextInt());

            switch (teller.option) {
            case 1:
                teller.incrementNumberOfGumsSold();
                System.out.println("Getting gum");
                break;
            case 2:
                teller.incrementNumberOfChocolateSold();
                System.out.println("Getting chocolate");
                break;

            case 3:
                teller.incrementNumberOfPopcornSold();
                System.out.println("Getting popcorn ");
                break;
            case 4:
                teller.incrementNumberOfJuiceSold();
                System.out.println("Getting juice");
                break;
            case 5:
                System.out.println(teller.getNumberOfGumsSold() + " items of gum were sold");
                System.out.println(teller.getNumberOfChocolateSold() + " items of chocolate were sold");
                System.out.println(teller.getNumberOfPopcornSold() + " items of popcorn were sold");
                System.out.println(teller.getNumberOfJuiceSold() + " items of juice were sold");
                break;
            case 6:
                System.out.println("\nExting the program gracefully");
                System.exit(0);
                break;
            default:
                break;
            }

        }

        keyIn.close();
    }

}