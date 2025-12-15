package com.skillnext1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USER = "root";
    private static final String PASSWORD = "8837"; 

    
    public void addStudent(Student st) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "INSERT INTO students (name, sem, dept) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, st.getName());
        stmt.setInt(2, st.getSem());
        stmt.setString(3, st.getDept());
        stmt.executeUpdate();
        conn.close();
    }

    public List<Student> getAllStudents() throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM students");

        List<Student> list = new ArrayList<>();
        while (rs.next()) {
            Student s = new Student();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setSem(rs.getInt("sem"));
            s.setDept(rs.getString("dept"));
            list.add(s);
        }
        conn.close();
        return list;
    }


    public void deleteStudent(int id) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "DELETE FROM students WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        conn.close();
    }

  
    public void updateStudent(Student st) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "UPDATE students SET name=?, sem=?, dept=? WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, st.getName());
        stmt.setInt(2, st.getSem());
        stmt.setString(3, st.getDept());
        stmt.setInt(4, st.getId());
        stmt.executeUpdate();
        conn.close();
    }
}
// import java.sql.*;
// import java.util.ArrayList;
// import java.util.List;


// public class StudentDAO{
//     private Connection getConnection() throws Exception{
//         String url="jdbc:mysql://localhost:3306/studentdb";
//         String username="root";
//         String password="8837";
//         return DriverManager.getConnection(url,username,password);
//     }
//     public boolean exists(int id) throws Exception{
//         Connection conn=getConnection();
//         String sql="SELECT id FROM student WHERE id=?";
//         PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
//         ps.setInt(1, id);
//         ResultSet rs=ps.executeQuery();
//         boolean present=rs.next();
//         conn.close();
//         return present;
//     }
//     public void insert(Student s) throws Exception{
//         Connection conn=getConnection();
//         String query="INSERT INTO student(name,sem,dept) VALUES(?,?,?)";
//         PreparedStatement ps=(PreparedStatement) conn.prepareStatement(query);
//         ps.setString(1, s.getName());
//         ps.setInt(2, s.getSem());
//         ps.setString(3, s.getDept());
//         ps.executeUpdate();
//         conn.close();
//     }
//     public void update(Student s) throws Exception{
//         Connection conn=getConnection();
//         String query="UPDATE student SET name=?,sem=?,dept=? WHERE id=?";
//         PreparedStatement ps=(PreparedStatement) conn.prepareStatement(query);
//         ps.setString(1, s.getName());
//         ps.setInt(2, s.getSem());
//         ps.setString(3, s.getDept());
//         ps.setInt(4, s.getId());
//         ps.executeUpdate();
//         conn.close();
//     }
//     public void delete(int id) throws Exception{
//         Connection conn=getConnection();
//         String query="DELETE FROM student WHERE id=?";
//         PreparedStatement ps=(PreparedStatement) conn.prepareStatement(query);
//         ps.setInt(1, id);
//         ps.executeUpdate();
//         conn.close();
//     }
//     public List<Student> selectAll() throws Exception{
//         Connection conn=getConnection();
//         String query="SELECT * FROM student";
//         PreparedStatement ps=(PreparedStatement) conn.prepareStatement(query);
//         ResultSet rs=ps.executeQuery();
//         List<Student> list=new ArrayList<>();
//         while(rs.next()){
//             Student s=new Student();
//             s.setId(rs.getInt("id"));
//             s.setName(rs.getString("name"));
//             s.setSem(rs.getInt("sem"));
//             s.setDept(rs.getString("dept"));
//             list.add(s);
//         }
//         conn.close();
//         return list;
//     }

// }