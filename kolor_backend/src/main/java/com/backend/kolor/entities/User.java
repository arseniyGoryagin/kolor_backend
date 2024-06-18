package com.backend.kolor.entities;


import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity()
@Table(name = "user_table")
public class User {




    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Integer id;

    private String username;
    private String password;
    private String email;
    private Long coins;
    private Long gems;

    public User(String username, String password, String email, Long coins, Long gems){
        this.id= 0;
        this.username = username;
        this.password = password;
        this.email = email;
        this.coins = coins;
        this.gems = gems;
    }

    public User(String username, String password, String email){
        this.id = 0;
        this.username = username;
        this.password = password;
        this.email = email;
        this.coins = 0L;
        this.gems = 0L;
    }

}
