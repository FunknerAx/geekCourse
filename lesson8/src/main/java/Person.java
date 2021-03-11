public abstract class Person {
    private String name;
    private int runLength;
    private int jumpHeight;

    public Person(String name, int runLength, int jumpHeight){
        this.jumpHeight = jumpHeight;
        this.name = name;
        this.runLength = runLength;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJumpHeight(int jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    public void setRunLength(int runLength) {
        this.runLength = runLength;
    }

    public String getName() {
        return name;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public int getRunLength() {
        return runLength;
    }
}
