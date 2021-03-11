public class Robot extends Person implements PersonAction{

    public Robot(String name, int runLength, int jumpHeight) {
        super(name, runLength, jumpHeight);
    }

    @Override
    public boolean jump(Wall wall) {
        int wallSize = wall.getSize();
        int jumpSize = super.getJumpHeight();

        if (jumpSize >= wallSize){
            System.out.printf("%s jump %d height of wall size %d\n", super.getName(), jumpSize, wallSize);
            return true;
        } else {
            System.out.printf("%s can`t jump upper wall size %d\n", super.getName(), jumpSize, wallSize);
            return false;
        }
    }

    @Override
    public boolean run(RunTrack track) {
        int trackSize = track.getSize();
        int runSize = super.getRunLength();

        if (runSize >= trackSize){
            System.out.printf("%s run %d length of track size %d\n", super.getName(), runSize, trackSize);
            return true;
        } else {
            System.out.printf("%s can`t run longer then track size %d\n", super.getName(), runSize, trackSize);
            return false;
        }
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
