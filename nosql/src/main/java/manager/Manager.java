package manager;

import constants.DataType;
import storage.data.InMemoryStorage;
import storage.meta.ColumnMeta;
import storage.meta.DataBaseMeta;
import storage.meta.TableInfo;
import validator.BaseColValidator;
import validator.IntColValidator;
import validator.SchemaValidator;
import validator.StringColValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manager {
    private static final String SEPARATOR="-";
    private DataBaseMeta dataBaseMeta;
    private InMemoryStorage memoryStorage;
    private Map<DataType, BaseColValidator> validatorMap;

    public Manager(DataBaseMeta dataBaseMeta, InMemoryStorage memoryStorage) {
        this.dataBaseMeta = dataBaseMeta;
        this.memoryStorage = memoryStorage;
        validatorMap = new HashMap<DataType, BaseColValidator>();
        validatorMap.put(DataType.INT, new IntColValidator());
        validatorMap.put(DataType.STRING, new StringColValidator());
    }

    public DataBaseMeta getDataBaseMeta() {
        return dataBaseMeta;
    }

    public void setDataBaseMeta(DataBaseMeta dataBaseMeta) {
        this.dataBaseMeta = dataBaseMeta;
    }

    public InMemoryStorage getMemoryStorage() {
        return memoryStorage;
    }

    public void setMemoryStorage(InMemoryStorage memoryStorage) {
        this.memoryStorage = memoryStorage;
    }

    public String createDataBase(String databaseName){
        if(dataBaseMeta == null){
            return "MetaStore doesn't exists can't create db";
        }
        if(databaseName != null &&
                dataBaseMeta.getDatabaseMeta().get(databaseName) != null){
            return "can't create db";
        }

        dataBaseMeta.getDatabaseMeta().put(databaseName, new HashMap<String, TableInfo>());

        return "success";
    }

    public String createTable(String databaseName, String tableName, TableInfo tableInfo){
        if(dataBaseMeta == null){
            return "MetaStore doesn't exists";
        }
        if(dataBaseMeta.getDatabaseMeta().get(databaseName) == null){
            return "Db doesn't exists";
        }
        Map<String, TableInfo> tableInfoMap = dataBaseMeta.getDatabaseMeta().get(databaseName);
        if(tableInfoMap.get(tableName) != null){
            return "table already exists";
        }else {
            // TODO should create a new tableInfo to avoid issues from reference udpate
            tableInfoMap.put(tableName, tableInfo);
            memoryStorage.getDataStore().put(databaseName+SEPARATOR+tableName, new ArrayList<Map<String, String>>());
        }
        return "success";
    }

    public String deleteTable(String database, String table){
        if (dataBaseMeta.getDatabaseMeta().get(database)==null){
            return "DB doesn't exists";
        }

        if (dataBaseMeta.getDatabaseMeta().get(database).get(table)==null){
            return "table doesn't exists";
        }

        memoryStorage.getDataStore().remove(database+SEPARATOR+table);
        dataBaseMeta.getDatabaseMeta().get(database).remove(table);
        return "success";
    }

    private String deleteDataBase(String dataBase){
        if (dataBaseMeta.getDatabaseMeta().get(dataBase)==null){
            return "DB doesn't exists";
        }
        Map<String, TableInfo> tables = dataBaseMeta.getDatabaseMeta().get(dataBase);

        for (String table: tables.keySet()){
            memoryStorage.getDataStore().remove(dataBase+SEPARATOR+table);
        }
        dataBaseMeta.getDatabaseMeta().remove(dataBase);
        return "success";
    }



    private boolean validateMeta(String dataBase, String table){
        return dataBaseMeta != null && dataBaseMeta.getDatabaseMeta().containsKey(dataBase) &&
                dataBaseMeta.getDatabaseMeta().get(dataBase).containsKey(table)
                && dataBaseMeta.getDatabaseMeta().get(dataBase).get(table) != null;
    }

    // this can be changed factory pattern
    private boolean validateField(ColumnMeta meta, String val){
        return validatorMap.get(meta.getDataType()).validate(meta, val);
    }

    public String addRecord(String dataBaseName, String tableName, Map<String, String> data){
        if(!validateMeta(dataBaseName, tableName)){
            return "Can't add data";
        }
        TableInfo tableInfo = dataBaseMeta.getDatabaseMeta().get(dataBaseName).get(tableName);
        if(!SchemaValidator.validateSchema(tableInfo, data)) {
            return "Can't add some extra data present";
        }

        for(ColumnMeta meta : tableInfo.getColumnMetas()){
            if(data.containsKey(meta.getColumnName())){
                if(!validateField(meta, data.get(meta.getColumnName()))){
                    return "Validation failed";
                }
            }
        }

        List<Map<String, String>> records =
                memoryStorage.getDataStore().get(dataBaseName+SEPARATOR+tableName);
        if (records == null){
            records = new ArrayList<Map<String, String>>();
        }
        records.add(data);
        return "success";
    }

    public void printTable(String database, String table){
        //TODO add null check on memstore

        List<Map<String, String>> records =
                memoryStorage.getDataStore().get(database+SEPARATOR+table);
        if(records!=null){
            for (Map<String, String> record : records)
                System.out.println(record);
        }
    }

    public void filter(String database, String table, String column, String val){
        //TODO Validate input value first

        List<Map<String, String>> records =
                memoryStorage.getDataStore().get(database+SEPARATOR+table);
        boolean exists = false;
        if(records!=null){
            for (Map<String, String> record : records)
                if (record.containsKey(column)){
                        exists = true;
                        System.out.println(record);
                }
        }
        if (!exists)
            System.out.println("No Matching record");
    }
}
