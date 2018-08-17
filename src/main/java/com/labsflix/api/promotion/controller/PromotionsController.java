package com.labsflix.api.promotion.controller;

import com.labsflix.api.domain.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labsflix.api.promotion.service.PromotionsService;

import java.time.LocalDate;

@RestController
@RequestMapping("/v1")
public class PromotionsController {

	private PromotionsService promotionsService;

	@Autowired
	public PromotionsController(PromotionsService promotionsService) {
		this.promotionsService = promotionsService;
	}

	@GetMapping("/promotions")
	public Content getPromotion() {
		LocalDate date = LocalDate.now();
		return promotionsService.getPromotion(date.getMonthValue());
	}
}
