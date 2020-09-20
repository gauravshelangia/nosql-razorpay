package validator;

import constraints.IntColConstraint;
import storage.meta.ColumnMeta;

public class IntColValidator extends BaseColValidator {

    public boolean validate(ColumnMeta columnMeta, String value) {
        return validateNullity(columnMeta, value) && validateRange(columnMeta, value);
    }

    private boolean validateRange(ColumnMeta columnMeta, String value){
        Integer val = Integer.parseInt(value);
        Integer max = ((IntColConstraint) columnMeta.getConstraint()).getMaxValue();
        Integer min = ((IntColConstraint) columnMeta.getConstraint()).getMinValue();
        return val >= min && val <= max;
    }
}
