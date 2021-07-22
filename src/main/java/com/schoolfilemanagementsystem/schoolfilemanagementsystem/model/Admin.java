package com.schoolfilemanagementsystem.schoolfilemanagementsystem.model;




import lombok.NonNull;
import org.hibernate.annotations.GeneratorType;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Id
    private Long id;
    @NonNull
    private String name;
    private String dob;
}
