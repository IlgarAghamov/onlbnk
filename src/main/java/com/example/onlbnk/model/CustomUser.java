package com.example.onlbnk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user",schema = "public")
public class CustomUser {
    @Id
    @SequenceGenerator(name = "user_seq",sequenceName = "user_user_id_seq",allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq")
    @Column(name = "user_id",unique = true,nullable = false)
    private Long userId;
    @Column(name ="login")
    private String userLogin;
    @Column(name="password")
    private String userPassword;

    @OneToMany(mappedBy = "user")
    private List<Card>cards;


}