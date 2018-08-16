package com.labsflix.api.promotion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.labsflix.api.contents.vo.Content;
import com.labsflix.api.promotion.service.PromotionsService;

@RestController
@RequestMapping("/v1")
public class PromotionsController {

	private static Logger logger = LoggerFactory.getLogger(PromotionsController.class);

	private PromotionsService promotionsService;

	@Autowired
	public PromotionsController(PromotionsService promotionsService) {
		this.promotionsService = promotionsService;
	}

	@GetMapping("/promotions")
	public Content getPromotions() {
		logger.debug("getPromotions() called!!");
		return promotionsService.getPromotion();
	}
}
