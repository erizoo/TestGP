
public class TouristFromXml {

    private String tourists;

    public TouristFromXml(String tourists) {
        this.tourists = tourists;
    }

    public TouristFromXml() {
    }

    public String getTourists() {
        return tourists;
    }

    public void setTourists(String tourists) {
        this.tourists = tourists;
    }

    @Override
    public String toString() {
        return "TouristFromXml{" +
                "tourists='" + tourists + '\'' +
                '}';
    }
}
