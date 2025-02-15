package com.devsuperior.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	@Autowired
	private Environment env;
	
	@Value("${test.config}")
	private String testConfig;
	
	@Autowired
	private WorkerRepository respository;
	
	
	@GetMapping(value="/configs")
	public ResponseEntity<Void> getConfigs() {
		
	 logger.info("CONFIG = " + testConfig);
	 return ResponseEntity.noContent().build();
		
	}
	
	
	
	@GetMapping
	public ResponseEntity<List<Worker>> fidAll() {
		
		List<Worker> list = respository.findAll();
		return ResponseEntity.ok(list);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> fidById(@PathVariable Long id) {
		
	
		try {
			Thread.sleep(2000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
		Worker obj = respository.findById(id).get();
		return ResponseEntity.ok(obj);
		
	}
	
}
