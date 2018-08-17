package com.labsflix.api.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "notifications")
public class Notification {

	@Id
	@GeneratedValue
	private int id;

	@NotNull
	private int content;

	@NotNull
	private String notiDate;

	@NotNull
	private String profile;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getContent() {
		return content;
	}

	public void setContent(int content) {
		this.content = content;
	}

	public String getNotiDate() {
		return notiDate;
	}

	public void setNotiDate(String notiDate) {
		this.notiDate = notiDate;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "Notification{" +
				"id=" + id +
				", content=" + content +
				", notiDate='" + notiDate + '\'' +
				", profile='" + profile + '\'' +
				'}';
	}
}