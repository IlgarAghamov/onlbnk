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
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private CustomUser user;
    @Column(name = "carddate")
    private Date cardDate;
    @Column(name = "cardnumber" )
    private String cardNumber;
    @Column(name = "cardtype")
    private String cardType;
    @Column(name="cardbalanse")
    private Long cardBalance;




}