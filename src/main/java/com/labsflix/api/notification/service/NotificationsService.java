package com.labsflix.api.notification.service;

import java.util.ArrayList;
import java.util.List;

import com.labsflix.api.domain.Content;
import com.labsflix.api.notification.repository.NotificationRepository;
import com.labsflix.api.domain.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationsService {

	@Value("${api.services.contents-service}")
	private String contentsServiceURL;

	private RestTemplate restTemplate;

	private NotificationRepository notificationRepository;

	@Autowired
	public NotificationsService(RestTemplate restTemplate, NotificationRepository notificationRepository) {
		this.restTemplate = restTemplate;
		this.notificationRepository = notificationRepository;
	}

	public List<Content> getNotifications(String date) {
		List<Content> contents = new ArrayList<>();
		List<Notification> list = notificationRepository.findByNotiDate(date);
		list.forEach(notification -> {
			Content content = restTemplate.getForObject(String.format("%s/v1/contents/%s", contentsServiceURL, notification.getId()), Content.class, notification.getContent());
			contents.add(content);
		});
		return contents;
	}
	
}
