package sg.edu.rp.id19037610.p02_classjournal;

import java.io.Serializable;

public class DailyCA implements Serializable {
    String dgGrade;
    String moduleCode;
    int week;

    public DailyCA(String dgGrade, String moduleCode, int week) {
        this.dgGrade = dgGrade;
        this.moduleCode = moduleCode;
        this.week = week;
    }

    public String getDgGrade() {
        return dgGrade;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public int getWeek() {
        return week;
    }
}
