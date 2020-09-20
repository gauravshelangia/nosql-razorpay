package storage.meta;

import java.util.List;

public class TableInfo {
    private List<ColumnMeta> columnMetas;

    public TableInfo(List<ColumnMeta> columnMetas) {
        this.columnMetas = columnMetas;
    }

    public List<ColumnMeta> getColumnMetas() {
        return columnMetas;
    }

    public void setColumnMetas(List<ColumnMeta> columnMetas) {
        this.columnMetas = columnMetas;
    }
}
