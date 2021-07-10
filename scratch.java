import java.util.Scanner;

class Area{
     int length;
     int breadth;

    Area(int length, int breadth){
        this.length = length;
        this.breadth = breadth;
    }

    int getArea(int length, int breadth){
        return length * breadth;
    }

    public static void main(String[] args) {
        Scanner keyIn = new Scanner(System.in);
        System.out.println("Enter length");
        int userLength = keyIn.nextInt();
        System.out.println("Enter breadth");
        int userBreadth = keyIn.nextInt();
        Area SquareArea = new Area(userBreadth,userLength);

        System.out.println(SquareArea.getArea(userLength, userBreadth));
        
        keyIn.close();
    }
}
