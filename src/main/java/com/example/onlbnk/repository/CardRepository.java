package com.example.onlbnk.repository;

import com.example.onlbnk.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    boolean existsCardByCardId(Long id);

}
