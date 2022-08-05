import java.util.Scanner;
import java.text.DecimalFormat;

class Main {
    //To calculate the cost of all walls combined, a global variable is needed
    public static float overallCost;
    //Used to convert monetary values to two decimal places
    public static final DecimalFormat df = new DecimalFormat("0.00");


    public static void main(String[] args) {

        //Take initial values
        Scanner scan = new Scanner(System.in);
        System.out.println("How many walls are you painting?");
        int walls = scan.nextInt();

        //Asks the user if they'd like a buffer in case there are any mistakes or errors while painting
        System.out.println("Would you like a 10% increase to account for paint that might be wasted?");
        System.out.println("Enter Y for yes or N for No");
        String waste = scan.next();
        waste = waste.toUpperCase();

        //This will be set based on the answer to the previous questing
        float wasteFactor;

        //Make sure the input for waste is valid
        while(!waste.equals("Y") && !waste.equals("N")){
            System.out.println("Enter Y for yes or N for No");
            waste = scan.next();
            waste = waste.toUpperCase();
        }

        //Applies a 10% increase of required paint
        if(waste.equals("Y")){
            wasteFactor = 1.1f;
        }

        //Does not increase required paint
        else{
            wasteFactor = 1.0f;
        }

        //Loops for each wall the user wants to paint
        for (int x = 0; x < walls; x++) {
            System.out.println("Is the wall a triangle or rectangular? ");
            System.out.println("Enter R for rectangular or T for Triangular");
            String shape = scan.next();
            shape = shape.toUpperCase();

            while(!shape.equals("T") && !shape.equals("R")){
                System.out.println("Please enter R for rectangular or T for Triangular");
                shape = scan.next();
                shape = shape.toUpperCase();
            }

            //Collects initial values to calculate paint for a rectangular wall
            if(shape.equals("R")){
                System.out.println("Enter width in meters: ");
                float width = scan.nextFloat();
                System.out.println("Enter Height in meters: ");
                float height = scan.nextFloat();
                System.out.println("How many coats of paint will the wall have: ");
                int coats = scan.nextInt();
                System.out.println("How much does the paint cost per litre in gbp: ");
                float paintCost = scan.nextFloat();
                //As doors are not part of the wall and unlikely to be painted with the same paint
                //The user can input to remove them from the equation
                System.out.println("How many doors are on this wall? (enter 2 for double doors)");
                int doors = scan.nextInt();

                //Calculates the cost of the wall and adds it to the overall cost
                overallCost += calculateRectangle(width, height, coats, paintCost, doors, wasteFactor);
            }

            //Collects initial values to calculate paint for a triangular wall
            else{
                System.out.println("Enter height in meters: ");
                float height = scan.nextFloat();
                System.out.println("Enter base in meters: ");
                float base = scan.nextFloat();
                System.out.println("How many coats of paint will the wall have: ");
                int coats = scan.nextInt();
                System.out.println("How much does the paint cost per litre in gbp: ");
                float paintCost = scan.nextFloat();
                //As doors are not part of the wall and unlikely to be painted with the same paint
                //The user can input to remove them from the equation
                System.out.println("How many doors are on this wall? (enter 2 for double doors)");
                int doors = scan.nextInt();

                //Calculates the cost of the wall and adds it to the overall cost
                overallCost += calculateTriangle(height, base, coats, paintCost, doors, wasteFactor);
            }
        }

        //Outputs the cost of all the required paint
        System.out.println("Total cost for all paint required: £" + df.format(overallCost));
    }

    public static float calculateRectangle(float width, float height, int coats, float paintCost, int doors, float wasteFactor){
        float canvasSize = (width*height) - (doors * 1.51f);
        float requiredPaint = (canvasSize/6.5f) * wasteFactor;
        float totalPaintRequired = requiredPaint * coats;
        float totalWallCost = requiredPaint * coats * paintCost;


        //Output canvas size, amount of paint needed and the cost
        System.out.println("Size of the canvas in square meters: " + canvasSize);
        System.out.println("Paint required per coat in litres: " + requiredPaint);
        System.out.println("Total Paint required in litres: " + totalPaintRequired);
        System.out.println("Cost of paint required: £" + df.format(totalWallCost));

        return totalWallCost;
    }

    public static float calculateTriangle(float height, float base, int coats, float paintCost, int doors, float wasteFactor){
        float canvasSize = ((base*height)/2) - (doors * 1.51f);
        float requiredPaint = (canvasSize/6.5f) * wasteFactor;
        float totalPaintRequired = requiredPaint * coats;
        float totalWallCost = requiredPaint * coats * paintCost;

        //Output canvas size, amount of paint needed and the cost
        System.out.println("Size of the canvas in square meters: " + canvasSize);
        System.out.println("Paint required per coat in litres: " + requiredPaint);
        System.out.println("Total Paint required in litres: " + totalPaintRequired);
        System.out.println("Cost of paint required: £" + df.format(totalWallCost));

        return totalWallCost;
    }
}
