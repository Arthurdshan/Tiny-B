package com.arthurhan.tiniyib.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.arthurhan.tiniyib.dtos.TopicDTO;
import com.arthurhan.tiniyib.entities.Topic;
import com.arthurhan.tiniyib.services.TopicService;

@RestController
@RequestMapping("/topics")
public class TopicController
{
	@Autowired
	private TopicService service;

	@GetMapping
	public ResponseEntity<Page<Topic>> findAll(Pageable pageable)
	{
		Page<Topic> page = service.findAll(pageable);

		return ResponseEntity.ok().body(page);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Topic> findById(@PathVariable Long id)
	{
		Topic obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Topic> saveTopic(@RequestBody TopicDTO dto)
	{
		Topic obj = service.save(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).body(obj);
	}
}
