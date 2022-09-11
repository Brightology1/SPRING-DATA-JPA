package com.brightology.springdatajpa.repository;

import com.brightology.springdatajpa.entity.Guardian;
import com.brightology.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){

        Student student = Student.builder()
                .emailId("brightology2@gmail.com")
                .firstName("Bright")
                .lastName("Ugochukwu")
                //.guardianName("Okechukwu")
                //.guardianEmail("okechwu@gmail.com")
                //.guardianMobile("08030000000")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWIthGuardian(){

        Guardian guardian = Guardian.builder()
                .email("okechwu@gmail.com")
                .name("Okechukwu")
                .mobile("08030000000")
                .build();

        Student student = Student.builder()
                .firstName("Jacy")
                .emailId("jacy@gmail.com")
                .lastName("Elo")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList =
                studentRepository.findAll();

        System.out.println("StudentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students =
                studentRepository.findByFirstName("Jacy");

        System.out.println("StudentList = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students =
                studentRepository.findByFirstNameContaining("J");

        System.out.println("StudentList = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students =
                studentRepository.findByGuardianName("Okechukwu");

        System.out.println("StudentList = " + students);
    }

    @Test
    public void printgetStudentByEmailAddress(){
        Student student =
                studentRepository.getStudentByEmailAddress(
                        "brightology2@gmail.com"
                );

        System.out.println("StudentList = " + student);
    }

    @Test
    public void printgetStudentFirstNameByEmailAddress(){
        String firstName =
                studentRepository.getStudentFirstNameByEmailAddress(
                        "jacy@gmail.com"
                );

        System.out.println("StudentList = " + firstName);
    }

    @Test
    public void printgetStudentByEmailAddressNative(){

        Student student =
                studentRepository.getStudentByEmailAddressNative(
                        "brightology2@gmail.com"
                );

        System.out.println("StudentList = " + student);

    }

    @Test
    public void printgetStudentByEmailAddressNativeNamedParam(){

        Student student =
                studentRepository.getStudentByEmailAddressNativeNamedParam(
                        "brightology2@gmail.com"
                );

        System.out.println("StudentList = " + student);

    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId(
                "Sampson",
                "brightology2@gmail.com");
    }
}
