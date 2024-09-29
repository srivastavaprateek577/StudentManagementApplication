package com.springjdbc.SpringJdbc.repo;

import com.springjdbc.SpringJdbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private JdbcTemplate jdbc;

    public void save(Student student) {
      String sql = "insert into student (roll_no,name, marks) values (?,?,?)";
    int rows =  jdbc.update(sql,student.getRoll_no(), student.getName(),student.getMarks());
        System.out.println(rows+" Affected");
    }

    public List<Student> findAll() {
        String sql = "select * from student";
        RowMapper<Student> mapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
               Student student = new Student();
                student.setRoll_no(rs.getInt("roll_no"));
                student.setName(rs.getString("name"));
                student.setMarks(rs.getInt("marks"));

                return student;
            }
        };

      return   jdbc.query(sql,mapper);
    }
}
