package businessobjects;

/**
 * Created by Maryia_Shynkarenka on 7/13/2017.
 */
public class CarHireDetails {
    private String city="dublin";

    public CarHireDetails(String city) {
        this.city = city;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
