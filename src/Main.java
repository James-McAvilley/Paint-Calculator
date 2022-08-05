import java.awt.*;
import java.util.Scanner;

class Main {
    public static float overallCost;

    public static void main(String[] args) {

        //Take inputs
        Scanner scan = new Scanner(System.in);
        System.out.println("How many walls are you painting?");
        int walls = scan.nextInt();

        System.out.println("Would you like to account for paint that might be wasted?");
        System.out.println("Enter Y for yes or N for No");
        String waste = scan.next();
        waste = waste.toUpperCase();

        float wasteFactor;

        while(!waste.equals("Y") && !waste.equals("N")){
            System.out.println("Enter Y for yes or N for No");
            waste = scan.next();
            waste = waste.toUpperCase();
        }

        if(waste.equals("Y")){
            wasteFactor = 1.1f;
        }

        else{
            wasteFactor = 1.0f;
        }

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

            if(shape.equals("R")){
                System.out.println("Enter width in meters: ");
                float width = scan.nextFloat();
                System.out.println("Enter Height in meters: ");
                float height = scan.nextFloat();
                System.out.println("How many coats of paint will the wall have: ");
                int coats = scan.nextInt();
                System.out.println("How much does the paint cost per litre in gbp: ");
                float paintCost = scan.nextFloat();
                System.out.println("How many doors are on this wall? (enter 2 for double doors)");
                int doors = scan.nextInt();

                overallCost += calculateRectangle(width, height, coats, paintCost, doors, wasteFactor);
            }

            else if(shape.equals("T")){
                System.out.println("Enter height in meters: ");
                float height = scan.nextFloat();
                System.out.println("Enter base in meters: ");
                float base = scan.nextFloat();
                System.out.println("How many coats of paint will the wall have: ");
                int coats = scan.nextInt();
                System.out.println("How much does the paint cost per litre in gbp: ");
                float paintCost = scan.nextFloat();
                System.out.println("How many doors are on this wall? (enter 2 for double doors)");
                int doors = scan.nextInt();

                overallCost += calculateTriangle(height, base, coats, paintCost, doors, wasteFactor);
            }




        }

        System.out.println("Total cost for all paint required: " + overallCost);
    }

    public static float calculateRectangle(float width, float height, int coats, float paintCost, int doors, float wasteFactor){
        float canvasSize = (width*height) - (doors * 1.51f);
        float requiredPaint = (canvasSize/6.5f) * wasteFactor;
        float totalPaintRequired = requiredPaint * coats;
        float totalWallCost = requiredPaint * coats * paintCost;

        //Output canvas size and the amount of paint needed
        System.out.println("Size of the canvas in square meters " + canvasSize);
        System.out.println("Paint required per coat in litres: " + requiredPaint);
        System.out.println("Total Paint required in litres: " + totalPaintRequired);
        System.out.println("Cost of paint required " + totalWallCost);

        return totalWallCost;
    }

    public static float calculateTriangle(float height, float base, int coats, float paintCost, int doors, float wasteFactor){
        float canvasSize = ((base*height)/2) - (doors * 1.51f);
        float requiredPaint = (canvasSize/6.5f) * wasteFactor;
        float totalPaintRequired = requiredPaint * coats;
        float totalWallCost = requiredPaint * coats * paintCost;

        //Output canvas size and the amount of paint needed
        System.out.println("Size of the canvas in square meters " + canvasSize);
        System.out.println("Paint required per coat in litres: " + requiredPaint);
        System.out.println("Total Paint required in litres: " + totalPaintRequired);
        System.out.println("Cost of paint required " + totalWallCost);

        return totalWallCost;
    }
}