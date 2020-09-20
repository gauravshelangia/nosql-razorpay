package constraints;

public class BaseColumnConstraint {
    boolean isNullAllowed=true;

    public BaseColumnConstraint(boolean isNullAllowed) {
        this.isNullAllowed = isNullAllowed;
    }

    public BaseColumnConstraint() {
    }

    public boolean isNullAllowed() {
        return isNullAllowed;
    }

    public void setNullAllowed(boolean nullAllowed) {
        isNullAllowed = nullAllowed;
    }
}
