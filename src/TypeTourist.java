
public enum TypeTourist {

    ADT("10"),
    CHD("8"),
    INF("7");

    private String description;

    private TypeTourist(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}




