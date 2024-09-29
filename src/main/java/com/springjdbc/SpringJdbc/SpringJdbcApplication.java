package com.springjdbc.SpringJdbc;

import com.springjdbc.SpringJdbc.model.Student;
import com.springjdbc.SpringJdbc.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
	ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
		Student student = context.getBean(Student.class);
       student.setRoll_no(107);
	   student.setName("Atharva");
	   student.setMarks(84);

		StudentService service = context.getBean(StudentService.class);
	   service.addStudent(student);

		List<Student> students = service.getStudents();
		System.out.println(students);


	}

}
