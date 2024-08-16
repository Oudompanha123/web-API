package com.kosign.dev.domain.todo.user;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "user_tb")
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column( name = "user_name" ,nullable = false)
    private String username;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Builder
    public User(String username, String gender) {
        this.username = username;
        this.gender = gender;
    }

}
