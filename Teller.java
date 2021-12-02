import java.util.Scanner;

public class Teller {
    int option;
    int numberOfGumsSold;
    int numberOfChocolateSold;
    int numberOfJuiceSold;
    int numberOfPopcornSold;

    
    /** 
     * @return int
     */
    public int getOption() {
        return this.option;
    }

    
    /** 
     * @param option
     */
    public void setOption(int option) {
        this.option = option;
    }

    
    /** 
     * @return int
     */
    public int getNumberOfGumsSold() {
        return this.numberOfGumsSold;
    }

    public void incrementNumberOfGumsSold() {
        this.numberOfGumsSold++;
    }

    
    /** 
     * @return int
     */
    public int getNumberOfChocolateSold() {
        return this.numberOfChocolateSold;
    }

    public void incrementNumberOfChocolateSold() {
        this.numberOfChocolateSold++;
    }

    
    /** 
     * @return int
     */
    public int getNumberOfJuiceSold() {
        return this.numberOfJuiceSold;
    }

    public void incrementNumberOfJuiceSold() {
        this.numberOfJuiceSold++;
    }

    
    /** 
     * @return int
     */
    public int getNumberOfPopcornSold() {
        return this.numberOfPopcornSold;
    }

    public void incrementNumberOfPopcornSold() {
        this.numberOfPopcornSold++;
    }

    
    /** 
     * @param args
     */
    public static void main(String[] args) {

        Scanner keyIn = new Scanner(System.in);

        Teller teller = new Teller();

        System.out.println("Enter what you want");
        System.out.println("[1] -> Get gum");
        System.out.println("[2] -> Get chocolate");
        System.out.println("[3] -> Get popcorn");
        System.out.println("[4] -> Get juice");
        System.out.println("[5] -> Get number of items sold");
        System.out.println("[6] -> Exit the program ");

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
                System.out.println("");
                break;
            }

        }

        keyIn.close();
    }

}