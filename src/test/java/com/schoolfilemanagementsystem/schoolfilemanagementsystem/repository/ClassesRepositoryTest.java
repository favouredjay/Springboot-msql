package com.schoolfilemanagementsystem.schoolfilemanagementsystem.repository;

import com.schoolfilemanagementsystem.schoolfilemanagementsystem.model.Classes;
import com.schoolfilemanagementsystem.schoolfilemanagementsystem.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ClassesRepositoryTest {
    @Autowired
    ClassesRepository classesRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;

    @Test
    void testThatClassesCanBeSaved(){
        Classes classes1 = new Classes("Cohort 1");
        classesRepository.save(classes1);
        assertEquals(1, classesRepository.count());
    }
    @Test
    void testThatAClassCanHaveStudents(){
        Student student = new Student("Yahaya Bello", LocalDate.of(2003, 4, 8));
        Classes classes1 = new Classes("Cohort 1");
        studentRepository.save(student);
        classesRepository.save(classes1);
        Set<Student>students = new HashSet<>();
        students.add(student);
        classes1.setStudents(students);
        classesRepository.save(classes1);

    }



}