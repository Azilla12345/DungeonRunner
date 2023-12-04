public class Floors {
    int floor;
    String floorName;
    public Floors(int floor) {
        this.floor = floor;
    }

    public Floors(int floor , String floorName) {
        this.floor = floor;
        this.floorName = floorName;
    }

    public int getFloor () {
        return floor;
    }

    public void setFloor (int set) {
        floor = set;
    }

    public void addFloor() {
        floor++;
    }

}
