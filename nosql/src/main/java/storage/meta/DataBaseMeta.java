package storage.meta;

import java.util.HashMap;
import java.util.Map;

public class DataBaseMeta {
    private Map<String, Map<String, TableInfo>> databaseMeta;

    public DataBaseMeta() {
        this.databaseMeta = new HashMap<String, Map<String, TableInfo>>();
    }

    public DataBaseMeta(Map<String, Map<String, TableInfo>> databaseMeta) {
        this.databaseMeta = databaseMeta;
    }

    public Map<String, Map<String, TableInfo>> getDatabaseMeta() {
        return databaseMeta;
    }

    public void setDatabaseMeta(Map<String, Map<String, TableInfo>> databaseMeta) {
        this.databaseMeta = databaseMeta;
    }

}
