package com.labsflix.api.notification.service;

import java.util.ArrayList;
import java.util.List;

import com.labsflix.api.notification.dao.NotificationMapper;
import com.labsflix.api.notification.vo.Notification;
import com.labsflix.api.contents.vo.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationsService {

	private RestTemplate restTemplate;

	private NotificationMapper notificationMapper;

	@Autowired
	public NotificationsService(RestTemplate restTemplate, NotificationMapper notificationMapper) {
		this.restTemplate = restTemplate;
		this.notificationMapper = notificationMapper;
	}

	public List<Content> getNotifications(String notiDate) {
		List<Content> contents = new ArrayList<Content>();
		
		List<Notification> list = notificationMapper.findByNotiDate(notiDate);
		list.forEach(notification -> {
			Content content = restTemplate.getForObject("http://localhost:8082/v1/contents/{content_id}", Content.class, notification.getContent());
			contents.add(content);
		});
		
		return contents;
	}
	
}
