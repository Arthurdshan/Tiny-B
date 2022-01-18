package com.arthurhan.tiniyib.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.arthurhan.tiniyib.dtos.ReplyDTO;
import com.arthurhan.tiniyib.entities.Reply;
import com.arthurhan.tiniyib.services.ReplyService;

@RestController
@RequestMapping("/replies")
public class ReplyController
{
	@Autowired
	private ReplyService service;
	
	@PostMapping
	public ResponseEntity<Reply> saveReply(@RequestBody ReplyDTO dto)
	{
		Reply obj = service.saveReply(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}
}
