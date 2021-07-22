package com.schoolfilemanagementsystem.schoolfilemanagementsystem.repository;

import com.schoolfilemanagementsystem.schoolfilemanagementsystem.model.Parent;
import com.schoolfilemanagementsystem.schoolfilemanagementsystem.model.Student;
import com.schoolfilemanagementsystem.schoolfilemanagementsystem.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParentRepositoryTest {
    @Autowired
    ParentRepository parentRepository;


    @Test
    void testThatTeacherHasASetOfStudent(){
        Parent parent = new Parent("Inyene Peter", LocalDate.of(1990, 8, 1));
        Student student1 = new Student("rayst fhsdgh", LocalDate.of(2005, 6, 9));
        Student student2 = new Student("ddgfs ytdf", LocalDate.of(2003, 6, 3));
        Set<Student> students = new HashSet<>();
        students.add(student1);
        students.add(student2);
        parent.setStudents(students);
       
    }

    @Test
    void canSaveTeachers(){
      Parent parent = new Parent("Inyene Peters", LocalDate.of(1990, 9, 10));
        parentRepository.save(parent);
        assertEquals(1, parentRepository.count());
    }

    @Test
    void canUpdateStudentData(){
        Parent parent = new Parent("Chukwu Yahaya", LocalDate.of(2020, 01, 23));
       parentRepository.save(parent);
        parent.setName("Musa Adeniyi Toni");
        parentRepository.save(parent);
        assertEquals("Musa Adeniyi Toni", parentRepository.findById(1L).get().getName());

    }

    @Test
    void testCanDeleteParentData(){
        Parent parent = new Parent("Chukwu Yahaya", LocalDate.of(2020, 01, 23));
        parentRepository.save(parent);
        parentRepository.delete(parent);
        assertEquals(0, parentRepository.count());
    }

    @Test
    void canFindParent(){
       Parent parent = new Parent("Chukwu Yahaya", LocalDate.of(2020, 01, 23));
        parentRepository.save(parent);

        Optional<Parent> parentToFind = parentRepository.findById(1L);
        String name = null;
        if (parentToFind != null){
            name = parentToFind.get().getName();
        }
        assertNotNull(name);
        assertEquals("Chukwu Yahaya", name);
    }



}