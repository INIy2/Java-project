package Param;

import com.opencsv.bean.CsvBindByPosition;
import javax.persistence.*;

public class Dir {
    @Id
    @CsvBindByPosition(position = 1)
    private String dir;
    @CsvBindByPosition(position = 2)
    private String school;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }
}
