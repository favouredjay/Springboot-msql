package com.schoolfilemanagementsystem.schoolfilemanagementsystem.model;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class Parent {
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Id
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private LocalDate dob;


    @OneToMany(mappedBy = "student_parent")
    private Set<Student> students;
}
