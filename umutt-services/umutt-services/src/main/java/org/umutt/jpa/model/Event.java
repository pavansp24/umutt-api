package org.umutt.jpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UMUTT_EVT")
public class Event {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="EVT_ID")
	private Long sid;
	
	@Column(name="EVT_NAME")
	private String eventName;
	
	@Column(name="EVT_ST_DT")
	private Date startDate;
	
	@Column(name="EVT_END_DT")
	private Date endDate;
	
	@Column(name="EVT_PLACE")
	private String place;
	
	public Event() {
		// TODO Auto-generated constructor stub
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	
	
}
