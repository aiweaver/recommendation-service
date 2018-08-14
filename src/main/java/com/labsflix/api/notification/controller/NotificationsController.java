package com.labsflix.api.notification.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.labsflix.api.contents.vo.Content;
import com.labsflix.api.notification.service.NotificationsService;

@RestController
@RequestMapping("/v1")
public class NotificationsController {
	
	private static Logger logger = LoggerFactory.getLogger(NotificationsController.class);

	@Autowired
	private NotificationsService notificationsService;
	
	@RequestMapping(path="/notifications", method=RequestMethod.GET, name="getNotifications")
	public List<Content> getNotifications() throws Exception {
		logger.debug("getNotifications() called!!");
		
		String notiDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date()); //"2017-02-07";
		List<Content> notifications = notificationsService.getNotifications(notiDate);
		return notifications;
	}
}
