import java.time.LocalDate;

public class Tourist {

    private Enum<TypeTourist> typeTourist;
    private LocalDate birthday;
    private String name, lastName, prefix;

    public Tourist() {
    }

    public Tourist(Enum<TypeTourist> typeTourist, LocalDate birthday, String name, String lastName, String prefix) {
        this.typeTourist = typeTourist;
        this.birthday = birthday;
        this.name = name;
        this.lastName = lastName;
        this.prefix = prefix;
    }

    public Enum<TypeTourist> getTypeTourist() {
        return typeTourist;
    }

    public void setTypeTourist(Enum<TypeTourist> typeTourist) {
        this.typeTourist = typeTourist;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String toString() {
        return "Tourist{" +
                "typeTourist=" + typeTourist +
                ", birthday=" + birthday +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", prefix='" + prefix + '\'' +
                '}';
    }
}
