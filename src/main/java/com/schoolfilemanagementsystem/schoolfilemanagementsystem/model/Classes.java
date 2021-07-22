package com.schoolfilemanagementsystem.schoolfilemanagementsystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Data
public class Classes {
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Id
    private Long id;
    @NonNull
    private String name;
    private Integer numberOfStudents;

    @ManyToMany
    @JoinTable(name = "class_teacher",
            joinColumns= @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id"))
    private Set<Teacher> teachers;

    @OneToMany(mappedBy = "student_class", fetch = FetchType.LAZY)
    private Set<Student>students;

}
