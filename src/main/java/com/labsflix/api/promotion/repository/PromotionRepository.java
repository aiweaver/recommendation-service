package com.labsflix.api.promotion.repository;

import com.labsflix.api.domain.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

    Promotion findByPromotionMonth(int promotionMonth);

}
