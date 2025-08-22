package com.gamertings.backend.user;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="users")
public class User {

    @Getter
    @Setter
    @Id
    @GeneratedValue
    private Long user_id;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String email;

}
