package com.epam.task1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Data
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message = "Title may not be empty") 
    @Size(max = 100, message = "Title may not be greater than 100 characters") 
    private String title;
    
    @NotEmpty(message = "Description may not be empty") 
    private String description;

}