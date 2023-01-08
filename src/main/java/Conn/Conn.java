package Conn;

import Param.Dir;
import Param.Edu;

import java.sql.*;
public class Conn {
    public static Statement statmt;
    public static ResultSet resSet;
    private Connection connect() {
        String url = "jdbc:sqlite:F:/USOPP/sqliteadmin/school.s3db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insert(int i, Edu edu, Dir dir) {
        if (i == 0)
        {
            String sql = "INSERT INTO edu (id,school,country,grades,students," +
                    "teachers,calworks,lunch,computer,expenditure," +
                    "income,english,read,math) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, edu.getId());
                pstmt.setString(2, edu.getSchool());
                pstmt.setString(3, edu.getCountry());
                pstmt.setString(4, edu.getGrades());
                pstmt.setString(5, edu.getStudents());
                pstmt.setString(6, edu.getTeachers());
                pstmt.setString(7, edu.getCalworks());
                pstmt.setString(8, edu.getLunch());
                pstmt.setString(9, edu.getComputer());
                pstmt.setString(10, edu.getExpenditure());
                pstmt.setString(11, edu.getIncome());
                pstmt.setString(12, edu.getEnglish());
                pstmt.setString(13, edu.getRead());
                pstmt.setString(14, edu.getMath());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        else{
            String sql = "INSERT INTO country (dir,school) VALUES(?,?)";

            try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, dir.getDir());
                pstmt.setString(2, dir.getSchool());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void Delete(){
        String sql = "DELETE FROM country;";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        sql = "DELETE FROM edu;";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void Task1()throws SQLException {
        String sql = "SELECT country,students FROM edu";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            statmt = conn.createStatement();
            resSet = statmt.executeQuery("SELECT country,students FROM edu");
            String[] country = new String[]{"Alameda","Butte","Fresno","San Joaquin","Kern",
                                            "Sacramento","Merced","Tulare","Los Angeles","Imperial"};
            float[] num = new float[10];
            for(int i = 0; i < 10; i++){
                statmt = conn.createStatement();
                resSet = statmt.executeQuery("SELECT country,students FROM edu WHERE country == \"" + country[i] + "\"");
                int n = 0;
                float stud = 0.0F;
                while(resSet.next()){
                    stud += resSet.getInt("students");
                    n += 1;
                }
                stud /= n;
                num[i] = stud;
                System.out.println(country[i] + " " + num[i]);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void Task2() throws SQLException {
        String sql = "SELECT country,expenditure FROM edu";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            statmt = conn.createStatement();
            resSet = statmt.executeQuery("SELECT country,expenditure FROM edu");
            String[] country = new String[]{"Fresno","Contra Costa","El Dorado","Glenn"};
            float[] num = new float[4];
            for(int i = 0; i < 4; i++){
                statmt = conn.createStatement();
                resSet = statmt.executeQuery("SELECT country,students FROM edu WHERE country == \"" + country[i] + "\"");
                int n = 0;
                float stud = 0.0F;
                while(resSet.next()){
                    stud += resSet.getInt("students");
                    n += 1;
                }
                stud /= n;
                num[i] = stud;
                System.out.println(country[i] + " " + num[i]);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void Task3() throws SQLException {
        String sql = "SELECT school,students,math FROM edu ORDER BY math DESC";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            statmt = conn.createStatement();
            resSet = statmt.executeQuery("SELECT school,students,math FROM edu ORDER BY math DESC");
            int i = 0;
            int n = 0;
            while(resSet.next()){
                String a = resSet.getString("school");
                int b = resSet.getInt("students");
                double c = resSet.getDouble("math");
                if (b >= 5000 && b <= 7500 && i == 0) {
                    System.out.println(a + "; Students = " + b + "; Math = " + c);
                    i += 1;
                }
                if (b >= 10000 && b <= 11000 && n == 0) {
                    System.out.println(a + "; Students = " + b + "; Math = " + c);
                    n += 1;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

