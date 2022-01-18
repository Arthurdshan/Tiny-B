package com.arthurhan.tiniyib.dtos;

public class ReplyDTO
{
	private Long topicId;
	private String body;

	public ReplyDTO()
	{

	}

	public ReplyDTO(Long topicId, String body)
	{
		super();
		this.topicId = topicId;
		this.body = body;
	}

	public Long getTopicId()
	{
		return topicId;
	}

	public void setTopicId(Long topicId)
	{
		this.topicId = topicId;
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
