package com.schoolfilemanagementsystem.schoolfilemanagementsystem.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Id
    private Long id;

    @ManyToMany(mappedBy = "student", fetch = FetchType.LAZY)
    Set <Teacher>teacher;

    @NonNull
    private String name;

    @NonNull
    private LocalDate dateOfBirth;

    @ManyToMany
    @JoinTable(name = "student_subject", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<Subject> subjects;

    @JoinColumn(name = "class_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Classes student_class;

    @JoinColumn(name = "parent_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Parent student_parent;
}
