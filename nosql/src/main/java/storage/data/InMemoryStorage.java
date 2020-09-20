package storage.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryStorage {

    private Map<String, List<Map<String, String>>> dataStore;

    public InMemoryStorage() {
        this.dataStore = new HashMap<String, List<Map<String, String>>>();
    }

    public InMemoryStorage(Map<String, List<Map<String, String>>> dataStore) {
        this.dataStore = dataStore;
    }

    public Map<String, List<Map<String, String>>> getDataStore() {
        return dataStore;
    }

    public void setDataStore(Map<String, List<Map<String, String>>> dataStore) {
        this.dataStore = dataStore;
    }
}
