import java.text.DecimalFormat;

public class Wall {
    public static final DecimalFormat df = new DecimalFormat("0.00");
    float width;
    float base;
    float height;
    int coats;
    float paintCost;

    float totalPaintRequired;

    int doors;

    //Getters********************************************
    public float getWidth(){
        return width;
    }

    public float getBase(){
        return base;
    }

    public float getHeight(){
        return height;
    }

    public int getCoats(){
        return coats;
    }

    public float getPaintCost(){
        return paintCost;
    }

    public int getDoors(){
        return doors;
    }

    //Setters********************************************
    public void setWidth(float newWidth){
       this.width = newWidth;
    }

    public void setBase(float newBase){
        this.base = newBase;
    }

    public void setHeight(float newHeight){
        this.height = newHeight;
    }

    public void setCoats(int newCoats){
        this.coats = newCoats;
    }

    public void setPaintCost(float newSetPaintCost){
        this.paintCost = newSetPaintCost;
    }

    public void setDoors(int newDoors){
        this.doors = newDoors;
    }

    //Calculations*******************************************************************************************************************
    public static float calculateRectangle(float width, float height, int coats, float paintCost, int doors, float wasteFactor){
        float canvasSize = (width*height) - (doors * 1.51f);
        float requiredPaint = (canvasSize/6.5f) * wasteFactor;
        float totalPaintRequired = requiredPaint * coats;
        float totalWallCost = requiredPaint * coats * paintCost;


        //Output canvas size, amount of paint needed and the cost
        System.out.println("\nSize of the canvas in square meters: " + canvasSize);
        System.out.println("Paint required per coat in litres: " + requiredPaint);
        System.out.println("Total Paint required in litres: " + totalPaintRequired);
        System.out.println("Cost of paint required: £" + df.format(totalWallCost) + "\n");

        return totalWallCost;
    }

    public static float calculateRectanglePaint(float width, float height, int coats, float paintCost, int doors, float wasteFactor){
        float canvasSize = (width*height) - (doors * 1.51f);
        float requiredPaint = (canvasSize/6.5f) * wasteFactor;
        float totalPaintRequired = requiredPaint * coats;

        return totalPaintRequired;
    }

    public static float calculateTriangle(float height, float base, int coats, float paintCost, int doors, float wasteFactor){
        float canvasSize = ((base*height)/2) - (doors * 1.51f);
        float requiredPaint = (canvasSize/6.5f) * wasteFactor;
        float totalPaintRequired = requiredPaint * coats;
        float totalWallCost = requiredPaint * coats * paintCost;

        //Output canvas size, amount of paint needed and the cost
        System.out.println("\nSize of the canvas in square meters: " + canvasSize);
        System.out.println("Paint required per coat in litres: " + requiredPaint);
        System.out.println("Total Paint required in litres: " + totalPaintRequired);
        System.out.println("Cost of paint required: £" + df.format(totalWallCost) + "\n");

        return totalWallCost;
    }

    public static float calculateTrianglePaint(float height, float base, int coats, float paintCost, int doors, float wasteFactor){
        float canvasSize = ((base*height)/2) - (doors * 1.51f);
        float requiredPaint = (canvasSize/6.5f) * wasteFactor;
        float totalPaintRequired = requiredPaint * coats;


        return totalPaintRequired;
    }
}
