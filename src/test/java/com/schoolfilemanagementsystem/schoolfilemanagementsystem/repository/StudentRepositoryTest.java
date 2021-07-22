package com.schoolfilemanagementsystem.schoolfilemanagementsystem.repository;

import com.schoolfilemanagementsystem.schoolfilemanagementsystem.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    void canSaveStudent(){
        Student studentOne = new Student("Chukwu Yahaya", LocalDate.of(2020, 01, 23));
        studentRepository.save(studentOne);
        assertEquals(1, studentRepository.count());
    }

    @Test
    void canUpdateStudentData(){
        Student studentOne = new Student("Chukwu Yahaya", LocalDate.of(2020, 01, 23));
        studentRepository.save(studentOne);
        studentOne.setName("Musa Adeniyi Toni");
        studentRepository.save(studentOne);
        assertEquals("Musa Adeniyi Toni", studentRepository.findById(1L).get().getName());

    }

    @Test
    void testCanDeleteStudentData(){
        Student studentOne = new Student("Chukwu Yahaya", LocalDate.of(2020, 01, 23));
        studentRepository.save(studentOne);
        studentRepository.delete(studentOne);
        assertEquals(0, studentRepository.count());
    }

    @Test
    void canFindStudent(){
        Student studentOne = new Student("Chukwu Yahaya", LocalDate.of(2020, 01, 23));
        studentRepository.save(studentOne);

        Optional<Student> studentToFind = studentRepository.findById(1L);
        String name = null;
        if (studentToFind != null){
            name = studentToFind.get().getName();
        }
        assertNotNull(name);
        assertEquals("Chukwu Yahaya", name);
    }
}