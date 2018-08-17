package com.labsflix.api.notification.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.labsflix.api.domain.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labsflix.api.notification.service.NotificationsService;

@RestController
@RequestMapping("/v1")
public class NotificationsController {

	private NotificationsService notificationsService;

	@Autowired
	public NotificationsController(NotificationsService notificationsService) {
		this.notificationsService = notificationsService;
	}

	@GetMapping("/notifications")
	public List<Content> getNotifications() {
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date()); //"2017-02-07";
		System.out.println(date);
		return notificationsService.getNotifications(date);
	}
}
