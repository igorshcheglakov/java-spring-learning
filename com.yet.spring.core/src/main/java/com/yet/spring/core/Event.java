package com.yet.spring.core;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.format.datetime.DateFormatter;

public class Event {
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", msg=" + msg + ", date=" + df.format(date) + "]";
	}

	private int id;
	
	private String msg;
	
	private Date date;
	private DateFormat df;

	public Event(Date date, DateFormat df) {
		super();
		this.id = new Random().nextInt();
		this.date = date;
		this.df = df;
	}

}
