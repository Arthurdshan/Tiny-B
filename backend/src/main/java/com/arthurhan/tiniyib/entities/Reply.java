package com.arthurhan.tiniyib.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reply implements Serializable
{
	private static final long serialVersionUID = -4354414317446567082L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant date;

	@Column(columnDefinition = "TEXT")
	private String body;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private Topic topic;

	public Reply()
	{

	}

	public Reply(Long id, Instant date, String body, Topic topic)
	{
		super();
		this.id = id;
		this.date = date;
		this.body = body;
		this.topic = topic;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Instant getDate()
	{
		return date;
	}

	public void setDate(Instant date)
	{
		this.date = date;
	}

	public String getBody()
	{
		return body;
	}

	public void setBody(String body)
	{
		this.body = body;
	}

	public Topic getTopic()
	{
		return topic;
	}

	public void setTopic(Topic topic)
	{
		this.topic = topic;
	}

}
