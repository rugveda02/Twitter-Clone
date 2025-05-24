package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "users") // You can name the table explicitly if you want
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "google_id")
    private String googleId;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(nullable = false, unique = true)
    private String username;

    // No-arg constructor required by JPA
    public User() {}

    // All-args constructor (optional)
    public User(String name, String email, String googleId, String contactNo, String username) {
        this.name = name;
        this.email = email;
        this.googleId = googleId;
        this.contactNo = contactNo;
        this.username = username;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Optional: for logging/debugging
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", googleId='" + googleId + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
