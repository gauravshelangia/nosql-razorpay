package constraints;

public class IntColConstraint extends BaseColumnConstraint{
    // adding default limit
    private Integer minValue=-1024;
    private Integer maxValue=1024;
    private Integer defaultValue;

    public IntColConstraint() {
        super();
        // default constructor 0-arg
    }

    public IntColConstraint(Integer minValue, Integer maxValue, Integer defaultValue) {
        this();
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.defaultValue = defaultValue;
    }

    public IntColConstraint(Integer minValue, Integer maxValue, Integer defaultValue, boolean nullAllowed) {
        super(nullAllowed);
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.defaultValue = defaultValue;
    }

    public Integer getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public Integer getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(int defaultValue) {
        this.defaultValue = defaultValue;
    }
}
