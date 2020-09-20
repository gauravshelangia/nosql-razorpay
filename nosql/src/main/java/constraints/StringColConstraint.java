package constraints;

public class StringColConstraint extends BaseColumnConstraint{
    //Default value
    private int maxLength=20;
    private String defaultValue;

    public StringColConstraint() {
    }

    public StringColConstraint(int maxLength, String defaultValue) {
        this.maxLength = maxLength;
        this.defaultValue = defaultValue;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
