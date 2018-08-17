package com.labsflix.api.notification.repository;

import java.util.List;

import com.labsflix.api.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

	List<Notification> findByNotiDate(String date);

}
