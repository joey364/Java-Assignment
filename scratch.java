// import java.util.Scanner;

// class Area{
//      int length;
//      int breadth;

//     Area(int length, int breadth){
//         this.length = length;
//         this.breadth = breadth;
//     }

//     int getArea(int length, int breadth){
//         return length * breadth;
//     }

//     public static void main(String[] args) {
//         Scanner keyIn = new Scanner(System.in);
//         System.out.println("Enter length");
//         int userLength = keyIn.nextInt();
//         System.out.println("Enter breadth");
//         int userBreadth = keyIn.nextInt();
//         Area SquareArea = new Area(userBreadth,userLength);

//         System.out.println(SquareArea.getArea(userLength, userBreadth));

//         keyIn.close();
//     }
// }

import java.util.Scanner;

class LargestNumber {

    private int arraySize;
    private int[] array;

    public LargestNumber() {
        this.arraySize = 0;
        this.array = new int[this.arraySize];

    }

    /**
     * @param array
     * @param arraySize
     * @return int
     */
    public int determineLargestNumber(int[] array, int arraySize) {
        this.array = array;
        this.arraySize = arraySize;
        int largestNumber = array[0];
        for (int index = 0; index < arraySize; index++) {
            if (largestNumber < array[index]) {
                largestNumber = array[index];
            }
        }
        return largestNumber;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LargestNumber largestNumber1 = new LargestNumber();
        Scanner keyIn = new Scanner(System.in);

        System.out.println("Enter the array size: ");
        largestNumber1.arraySize = keyIn.nextInt();

        largestNumber1.array = new int[largestNumber1.arraySize];

        System.out.println("Enter array elements: ");
        for (int index = 0; index < largestNumber1.arraySize; index++) {
            // largestNumber1.array[largestNumber1.arraySize] = keyIn.nextInt();
            largestNumber1.array[index] = keyIn.nextInt();
        }

        int largestNumber = largestNumber1.determineLargestNumber(largestNumber1.array, largestNumber1.arraySize);
        System.out.println("The largest number is: " + largestNumber);
        keyIn.close();
    }
}
