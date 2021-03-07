public class Cat {
    private String name;
    private boolean satiety;
    private int appetite;

    public Cat(String name, int appetite){
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Plate plate){
        plate.reduceFood(appetite);
    }

    public void tryEat(Plate plate){
        if(checkFood(plate) && !satiety){
            eat(plate);
            setSatiety(true);
            System.out.printf("%s eat\n",name);
        }
    }

    public boolean checkFood(Plate plate){
        return plate.getFoodCount() >= appetite;
    }

    public void info(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", satiety=" + satiety +
                ", appetite=" + appetite +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean getSatiety(){
        return satiety;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }
}
