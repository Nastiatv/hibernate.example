package com.runa.hibernate.example.modules;

import java.util.List;

public interface IDeveloperService {
	
	List<DeveloperDto> getAllDevelopers();
	DeveloperDto addDeveloper(DeveloperDto developerDto);
	DeveloperDto getDeveloperById(Long id);
	void deleteDeveloperById(Long id);
	void updateDeveloper(Long id, DeveloperDto developerDto);

}
