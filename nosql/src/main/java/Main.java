import constants.DataType;
import constraints.BaseColumnConstraint;
import constraints.IntColConstraint;
import constraints.StringColConstraint;
import manager.Manager;
import manager.Manager;
import storage.data.InMemoryStorage;
import storage.meta.ColumnMeta;
import storage.meta.DataBaseMeta;
import storage.meta.TableInfo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        DataBaseMeta dataBaseMeta = new DataBaseMeta(new HashMap<String, Map<String, TableInfo>>());
        InMemoryStorage memoryStorage = new InMemoryStorage();

        Manager manager = new Manager(dataBaseMeta, memoryStorage);

        System.out.println(manager.createDataBase("test"));

        ColumnMeta sName = new ColumnMeta(DataType.STRING, "name",
                new StringColConstraint());
        IntColConstraint intColConstraint = new IntColConstraint(0, 23, 18,false);

        ColumnMeta sRollNo = new ColumnMeta(DataType.INT, "roll_no",
                intColConstraint);
        TableInfo tableInfo = new TableInfo(Arrays.asList(sName, sRollNo));

        System.out.println(manager.createTable("test", "student", tableInfo));

        ColumnMeta tName = new ColumnMeta(DataType.STRING, "name",
                new StringColConstraint());
        StringColConstraint stringColConstraint = new StringColConstraint(1, "A");
        stringColConstraint.setNullAllowed(false);
        ColumnMeta tClass = new ColumnMeta(DataType.STRING, "class",
                stringColConstraint);
        ColumnMeta tAge = new ColumnMeta(DataType.INT, "age",
                new IntColConstraint());

        TableInfo teacherTableInfo = new TableInfo(Arrays.asList(tName, tAge, tClass));

        System.out.println(manager.createTable("test", "teacher", teacherTableInfo));

        System.out.println(manager.addRecord("test", "student",
                new HashMap<String, String>(){{put("name", "name1"); put("roll_no", "39");}}));

        System.out.println(manager.addRecord("test", "student",
                new HashMap<String, String>(){{put("name", "name2");}}));

        System.out.println(manager.addRecord("test", "student",
                new HashMap<String, String>(){{put("name", "name3"); put("roll_no", "J");}}));

        System.out.println(manager.addRecord("test", "student",
                new HashMap<String, String>(){{put("name", "name2");put("roll_no", "10");}}));

        System.out.println(manager.addRecord("test", "teacher",
                new HashMap<String, String>(){{put("name", "teacher1"); put("class", "AA");}}));
        System.out.println(manager.addRecord("test", "teacher",
                new HashMap<String, String>(){{put("name", "teacher1"); put("class", "1");}}));

        System.out.println("PRINT");
        manager.printTable("test", "student");

//        manager.printTable("test", "teacher");

        manager.filter("test", "student", "name", "name2");
        System.out.println("stop here");
    }
}
