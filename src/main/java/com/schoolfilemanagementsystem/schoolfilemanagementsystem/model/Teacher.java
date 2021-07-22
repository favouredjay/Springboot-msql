package com.schoolfilemanagementsystem.schoolfilemanagementsystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@RequiredArgsConstructor
@Data

@Entity
public class Teacher {
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Id
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private LocalDate dob;

    @ManyToMany
    @JoinTable(name = "student_teacher", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private Set<Student> student;

    @ManyToMany
    @JoinTable(name = "subject_teacher", joinColumns = @JoinColumn(name = "subject_id"), inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private Set<Subject> subjects;

    @ManyToMany(mappedBy = "teachers", fetch = FetchType.LAZY)
    private Set<Classes>classes;


}
