package com.arthurhan.tiniyib.dtos;

import com.arthurhan.tiniyib.entities.Topic;

public class TopicDTO
{
	private String title;
	private String body;

	public TopicDTO()
	{

	}

	public TopicDTO(String title, String body)
	{
		super();
		this.title = title;
		this.body = body;
	}

	public TopicDTO(Topic topic)
	{
		title = topic.getTitle();
		body = topic.getBody();
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

}
