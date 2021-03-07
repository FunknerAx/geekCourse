public class Plate {
    private int foodCount;

    public Plate(int foodCount){
        this.foodCount = foodCount;
    }

    public void reduceFood(int foodCount){
        this.foodCount -= foodCount;
    }

    public void increaseFood(int foodCount){
        this.foodCount += foodCount;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(int foodCount) {
        this.foodCount = foodCount;
    }

    public void info(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Plate{" +
                "foodCount=" + foodCount +
                '}';
    }
}
