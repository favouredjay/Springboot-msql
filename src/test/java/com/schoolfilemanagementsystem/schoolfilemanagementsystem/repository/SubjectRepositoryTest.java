package com.schoolfilemanagementsystem.schoolfilemanagementsystem.repository;

import com.schoolfilemanagementsystem.schoolfilemanagementsystem.model.Student;
import com.schoolfilemanagementsystem.schoolfilemanagementsystem.model.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SubjectRepositoryTest {
    @Autowired
   private SubjectRepository subjectRepository;

    @Test
    void testThatSchoolHasSubjects(){
        Subject firstSubject = new Subject("Java", "JDK11");
        subjectRepository.save(firstSubject);
        assertEquals(1, subjectRepository.count());
    }
    @Test
    void testThatSubjectCanBeUpdated(){
        Subject firstSubject = new Subject("Java", "JDK11");
        subjectRepository.save(firstSubject);
       firstSubject.setName("Python");
       subjectRepository.save(firstSubject);
       assertEquals("Python", subjectRepository.findById(1L).get().getName());
    }

    @Test
    void testThatSubjectCanBeFound(){
        Subject firstSubject = new Subject("Java", "JDK11");
        subjectRepository.save(firstSubject);

        Optional<Subject> subjectToFind = subjectRepository.findById(1L);
        String name = null;
        if (subjectToFind != null){
            name = subjectToFind.get().getName();
        }
        assertNotNull(name);
        assertEquals("Java", name);
    }
    }


