package com.arthurhan.tiniyib.services;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arthurhan.tiniyib.dtos.TopicDTO;
import com.arthurhan.tiniyib.entities.Topic;
import com.arthurhan.tiniyib.repositories.TopicRepository;
import com.arthurhan.tiniyib.services.exception.ObjectNotFoundException;

@Service
public class TopicService
{
	@Autowired
	private TopicRepository topicRepository;

	private Topic fromDTO(TopicDTO dto)
	{
		return new Topic(null, Instant.now(), dto.getTitle(), dto.getBody());
	}

	@Transactional(readOnly = true)
	public Page<Topic> findAll(Pageable pageable)
	{
		Pageable page = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Direction.DESC, "id"));
		return topicRepository.findAll(page);
	}

	@Transactional(readOnly = true)
	public Topic findById(Long id)
	{
		Optional<Topic> obj = topicRepository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("TOPIC NOT FOUND"));
	}

	public Topic save(TopicDTO obj)
	{
		return topicRepository.save(fromDTO(obj));
	}
}
