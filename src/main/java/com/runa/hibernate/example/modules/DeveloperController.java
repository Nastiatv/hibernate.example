package com.runa.hibernate.example.modules;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/developers/")
public class DeveloperController {

	private static final String ID = "{id}";
	@Autowired
	IDeveloperService developerService;

	@GetMapping
	public List<DeveloperDto> getAllDevelopers() {
		return developerService.getAllDevelopers();
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public DeveloperDto addDeveloper(@RequestBody DeveloperDto developerDto) {
		return developerService.addDeveloper(developerDto);
	}

	@PutMapping(value = ID, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateDeveloper(@PathVariable Long id, @RequestBody DeveloperDto developerDto) {
		developerService.updateDeveloper(id, developerDto);
	}

	@GetMapping(value = ID)
	public DeveloperDto getDeveloper(@PathVariable Long id) {
		return developerService.getDeveloperById(id);
	}

	@DeleteMapping(value = ID)
	public void deleteDeveloper(@PathVariable Long id) {
		developerService.deleteDeveloperById(id);
	}
}
