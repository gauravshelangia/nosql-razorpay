package validator;

import constants.DataType;
import constraints.BaseColumnConstraint;
import storage.meta.ColumnMeta;

public abstract class BaseColValidator {

    public abstract boolean validate(ColumnMeta columnMeta, String value);

    boolean validateNullity(ColumnMeta columnMeta, String value){
        if (columnMeta.getConstraint().isNullAllowed()){
            if(value == null){
                return true;
            } else {
              // continue with other checks
            }
        }
        // type check
        if(columnMeta.getDataType().equals(DataType.INT)){
            try {
                Integer.parseInt(value);
            } catch (NumberFormatException e){
                // log msg here
                return false;
            }
        }
        return true;
    }
}
