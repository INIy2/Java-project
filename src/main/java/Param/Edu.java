package Param;

import com.opencsv.bean.CsvBindByPosition;
import javax.persistence.*;

public class Edu {

    @CsvBindByPosition(position = 0)
    @Id
    private String id;

    @CsvBindByPosition(position = 2)
    private String school;

    @CsvBindByPosition(position = 3)
    private String country;

    @CsvBindByPosition(position = 4)
    private String grades;

    @CsvBindByPosition(position = 5)
    private String students;

    @CsvBindByPosition(position = 6)
    private String teachers;

    @CsvBindByPosition(position = 7)
    private String calworks;

    @CsvBindByPosition(position = 8)
    private String lunch;

    @CsvBindByPosition(position = 9)
    private String computer;

    @CsvBindByPosition(position = 10)
    private String expenditure;

    @CsvBindByPosition(position = 11)
    private String income;

    @CsvBindByPosition(position = 12)
    private String english;

    @CsvBindByPosition(position = 13)
    private String read;
    @CsvBindByPosition(position = 14)
    private String math;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }

    public String getStudents() {
        return students;
    }

    public void setStudents(String students) {
        this.students = students;
    }

    public String getTeachers() {
        return teachers;
    }

    public void setTeachers(String teachers) {
        this.teachers = teachers;
    }

    public String getCalworks() {
        return calworks;
    }

    public void setCalworks(String calworks) {
        this.calworks = calworks;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getComputer() {
        return computer;
    }

    public void setComputer(String computer) {
        this.computer = computer;
    }

    public String getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(String expenditure) {
        this.expenditure = expenditure;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }

    public String getMath() {
        return math;
    }

    public void setMath(String math) {this.math = math;}
}
