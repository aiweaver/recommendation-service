package com.labsflix.api.promotion.service;

import com.labsflix.api.promotion.dao.EpisodeMapper;
import com.labsflix.api.promotion.dao.PromotionMapper;
import com.labsflix.api.promotion.vo.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.labsflix.api.contents.vo.Content;

@Service
public class PromotionsService {

	@Value("${promotion}")
	private String promotion;

	private EpisodeMapper episodeMapper;

	private PromotionMapper promotionMapper;

	@Autowired
	public PromotionsService(EpisodeMapper episodeMapper, PromotionMapper promotionMapper) {
		this.episodeMapper = episodeMapper;
		this.promotionMapper = promotionMapper;
	}

	public Content getPromotion() {
		String categoryId = promotion;
		Promotion promotion = promotionMapper.findByCategoryId(categoryId);
		if (promotion != null) {
			return episodeMapper.findById(promotion.getContent());
		} else {
			return null;
		}
	}

}
