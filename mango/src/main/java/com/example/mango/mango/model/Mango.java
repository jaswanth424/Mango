package com.example.mango.mango.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Mango {

    @Id
    @Column(name = "collegeId")
    String id;
    @Column(name = "collegeName")
    String name;
    @Column(name = "collegeLocation")
    String location;

}
