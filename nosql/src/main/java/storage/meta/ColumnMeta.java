package storage.meta;

import constants.DataType;
import constraints.BaseColumnConstraint;

public class ColumnMeta {
    private DataType dataType;
    private String columnName;
    private BaseColumnConstraint constraint;



    public ColumnMeta(DataType dataType, String columnName, BaseColumnConstraint constraint) {
        this.dataType = dataType;
        this.columnName = columnName;
        this.constraint = constraint;

        //TODO add default constructor based on type;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public BaseColumnConstraint getConstraint() {
        return constraint;
    }

    public void setConstraint(BaseColumnConstraint constraint) {
        this.constraint = constraint;
    }
}
