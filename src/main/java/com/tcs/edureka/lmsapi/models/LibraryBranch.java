package com.tcs.edureka.lmsapi.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "library-branch")
public class LibraryBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libraryName;
    private String address;
    private String phoneNumber;
    private String email;
}
