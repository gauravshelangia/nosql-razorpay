package validator;

import storage.meta.ColumnMeta;
import storage.meta.TableInfo;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SchemaValidator {
    public static boolean validateSchema(TableInfo tableInfo, Map<String, String> data){
        // TODO  more validation can be added here.
        List<ColumnMeta> columnMetas = tableInfo.getColumnMetas();
        // This can be part of table info for opt.
        Set<String> columns = new HashSet<String>();
        for (ColumnMeta meta : columnMetas){
            columns.add(meta.getColumnName());
        }
        for (String key : data.keySet()){
            if(!columns.contains(key)){
                // extra column in data.
                return false;
            }
        }
        return data.size() <= columnMetas.size();
    }
}
