package com.labsflix.api.notification.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.labsflix.api.notification.vo.Notification;

@Mapper
public interface NotificationMapper {

	@Select("select * from notifications where notiDate=#{notiDate}")
	List<Notification> findByNotiDate(String notiDate);

}
