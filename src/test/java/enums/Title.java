package enums;

public enum Title {
   MR("1"),
   MS("2");
    public final String name;

    Title(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name();
    }
    public static Title fromString(String value) {
        for (Title contactIndustry : Title.values()) {
            if (contactIndustry.name.equals(value)) {
                return contactIndustry;
            }
        }
        return null;
    }
}
