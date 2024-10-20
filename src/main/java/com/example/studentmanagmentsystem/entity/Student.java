package com.example.studentmanagmentsystem.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;

    public Student(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private String email;
    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;

    @OneToOne
    private Address addressEntity;

    
   @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Book> bookEntity;

    @ManyToMany
    private List<Course> courseIdentity;


}
