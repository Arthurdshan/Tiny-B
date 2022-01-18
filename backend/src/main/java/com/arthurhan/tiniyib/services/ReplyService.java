package com.arthurhan.tiniyib.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthurhan.tiniyib.dtos.ReplyDTO;
import com.arthurhan.tiniyib.entities.Reply;
import com.arthurhan.tiniyib.repositories.ReplyRepository;
import com.arthurhan.tiniyib.repositories.TopicRepository;

@Service
public class ReplyService
{
	@Autowired
	private ReplyRepository replyRepository;

	@Autowired
	private TopicRepository topicRepository;

	private Reply fromDTO(ReplyDTO dto)
	{
		return new Reply(null, Instant.now(), dto.getBody(), topicRepository.findById(dto.getTopicId()).get());
	}

	public Reply saveReply(ReplyDTO dto)
	{
		return replyRepository.save(fromDTO(dto));
	}
}
