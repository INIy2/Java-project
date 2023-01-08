import Conn.Conn;
import Param.Dir;
import Param.Edu;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import java.io.FileReader;
import java.util.List;

public class CsvReader {

    public static void main(String[] args) throws Exception
    {
        CsvToBean csv = new CsvToBean();
        Conn conn = new Conn();
        conn.Delete();
        String csvFilename = "src/main/resources/Школы.csv";

        CSVReader csvReader1 = new CSVReader(new FileReader(csvFilename));
        List list1 = csv.parse(setColumMapping(0), csvReader1);
        for (Object object : list1) {
            Edu edu = (Edu) object;
            try {conn.insert(0, edu,null);
            } catch (Exception e) {}
        }

        CSVReader csvReader2 = new CSVReader(new FileReader(csvFilename));
        List list2 = csv.parse(setColumMapping(1), csvReader2);
        for (Object object : list2) {
            Dir dir = (Dir) object;
            conn.insert(1,null , dir);
        }
    }

    private static ColumnPositionMappingStrategy setColumMapping(int i)
    {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        if (i == 1){strategy.setType(Dir.class);}
        else{strategy.setType(Edu.class);}
        String[] columns = new String[] {"id","dir", "school","country","grades","students",
                "teachers","calworks","lunch","computer","expenditure",
                "income","english","read","math"};
        strategy.setColumnMapping(columns);
        return strategy;
    }
}
