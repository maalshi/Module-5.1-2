package businessobjects;

public class Route {

    private String origin = "dublin";
    private String destination = "paris";

    public Route(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public String getOrigin(){
        return origin;
    }

    public String getDestination(){
        return destination;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
