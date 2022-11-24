package com.example.onlbnk.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "card",schema = "public")
public class Card {
    @Id
    @SequenceGenerator(name = "card_seq",sequenceName = "cards_card_id_seq",allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "card_seq")
    @Column(name = "card_id",unique = true,nullable = false)
    private Long cardId;
    @ManyToOne
    @JoinColumn(name="user_id")
    private CustomUser user;
    @Column(name = "card_date")
    private Date cardDate;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "card_type")
    private String cardType;
    @Column(name="card_balance")
    private float cardBalance;
    @Column(name = "card_secret")
    private int cardSecret;


}