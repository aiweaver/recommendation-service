package com.labsflix.api.promotion.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.labsflix.api.promotion.vo.Promotion;

@Mapper
public interface PromotionMapper {

	@Select("select * from promotions where category=#{category}")
	Promotion findByCategoryId(String categoryId);
}
