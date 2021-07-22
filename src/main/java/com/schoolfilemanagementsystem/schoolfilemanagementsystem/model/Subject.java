package com.schoolfilemanagementsystem.schoolfilemanagementsystem.model;



import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Subject {
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Id
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String courseDescription;

    @ManyToMany(mappedBy = "subjects", fetch = FetchType.LAZY)
    private Set<Student> students;

    @ManyToMany(mappedBy = "subjects", fetch = FetchType.LAZY)
    private Set<Teacher> teachers;
}
