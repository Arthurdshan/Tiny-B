package com.arthurhan.tiniyib.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Topic implements Serializable
{
	private static final long serialVersionUID = 5040776173925153987L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant date;
	private String title;

	@Column(columnDefinition = "TEXT")
	private String body;
	
	@OneToMany(mappedBy = "topic")
	private List<Reply> replies = new ArrayList<>();
	
	public Topic()
	{

	}

	public Topic(Long id, Instant date, String title, String body)
	{
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
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

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getBody()
	{
		return body;
	}

	public void setBody(String body)
	{
		this.body = body;
	}

	public List<Reply> getReplies()
	{
		return replies;
	}

}
