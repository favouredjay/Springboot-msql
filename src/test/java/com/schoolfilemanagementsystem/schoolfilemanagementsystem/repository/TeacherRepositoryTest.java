package com.schoolfilemanagementsystem.schoolfilemanagementsystem.repository;

import com.schoolfilemanagementsystem.schoolfilemanagementsystem.model.Student;
import com.schoolfilemanagementsystem.schoolfilemanagementsystem.model.Subject;
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
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @Test
    void testThatTeacherHasASetOfStudent(){
        Teacher teacher = new Teacher("Inyene Peter", LocalDate.of(1990, 8, 1));
        Student student1 = new Student("rayst fhsdgh", LocalDate.of(2005, 6, 9));
        Student student2 = new Student("ddgfs ytdf", LocalDate.of(2003, 6, 3));
        teacherRepository.save(teacher);
        studentRepository.save(student1);
        studentRepository.save(student2);
        Set<Student> students = new HashSet<Student>();
        students.add(student1);
        students.add(student2);
        teacher.setStudent(students);
        teacherRepository.save(teacher);
    }
    @Test
    void testThatTeachersCanTeachASubject(){
        Teacher teacher = new Teacher("Inyene Peters", LocalDate.of(1980,9, 29));
        Subject firstSubject = new Subject("Java", "JDK11");
        teacherRepository.save(teacher);
        subjectRepository.save(firstSubject);
        Set<Subject> subjects = new HashSet<>();
        subjects.add(firstSubject);
        teacher.setSubjects(subjects);
        teacherRepository.save(teacher);
    }


    @Test
    void canSaveTeachers(){
        Teacher teacher = new Teacher("Inyene Peters", LocalDate.of(1990, 9, 10));
        teacherRepository.save(teacher);
        assertEquals(1, teacherRepository.count());
    }

    @Test
    void canUpdateStudentData(){
      Teacher teacher = new Teacher("Chukwu Yahaya", LocalDate.of(2020, 01, 23));
        teacherRepository.save(teacher);
        teacher.setName("Musa Adeniyi Toni");
        teacherRepository.save(teacher);
        assertEquals("Musa Adeniyi Toni", teacherRepository.findById(1L).get().getName());

    }

    @Test
    void testCanDeleteTeacherData(){
        Teacher teacher = new Teacher("Chukwu Yahaya", LocalDate.of(2020, 01, 23));
        teacherRepository.save(teacher);
        teacherRepository.delete(teacher);
        assertEquals(0, teacherRepository.count());
    }

    @Test
    void canFindTeacher(){
        Teacher teacher = new Teacher("Chukwu Yahaya", LocalDate.of(2020, 01, 23));
        teacherRepository.save(teacher);

        Optional<Teacher> teacherToFind = teacherRepository.findById(1L);
        String name = null;
        if (teacherToFind != null){
            name = teacherToFind.get().getName();
        }
        assertNotNull(name);
        assertEquals("Chukwu Yahaya", name);
    }



}