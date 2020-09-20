package validator;

import constraints.StringColConstraint;
import storage.meta.ColumnMeta;

public class StringColValidator extends BaseColValidator {

    public boolean validate(ColumnMeta columnMeta, String value) {
        return validateNullity(columnMeta, value) && validateLength(columnMeta, value);
    }

    boolean validateLength(ColumnMeta meta, String value){
        return value.length() <= ((StringColConstraint) meta.getConstraint()).getMaxLength();
    }
}

