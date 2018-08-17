package com.labsflix.api.promotion.service;

import com.labsflix.api.domain.Content;
import com.labsflix.api.promotion.repository.PromotionRepository;
import com.labsflix.api.domain.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PromotionsService {

	@Value("${api.services.contents-service}")
	private String contentsServiceURL;

	private RestTemplate restTemplate;

	private PromotionRepository promotionRepository;

	@Autowired
	public PromotionsService(RestTemplate restTemplate, PromotionRepository promotionRepository) {
		this.promotionRepository = promotionRepository;
		this.restTemplate = restTemplate;
	}

	public Content getPromotion(int promotionMonth) {
		Promotion promotion = promotionRepository.findByPromotionMonth(promotionMonth);
		return restTemplate.getForObject(String.format("%s/v1/contents/%s", contentsServiceURL, promotion.getId()), Content.class);
	}

}
