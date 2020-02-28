package com.runa.hibernate.example.modules;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DeveloperService implements IDeveloperService {

	@Autowired
	private IDeveloperDao developerDao;

	@Override
	public List<DeveloperDto> getAllDevelopers() {
		return DeveloperDto.convertList(developerDao.getAll());
	}

	@Override
	public DeveloperDto addDeveloper(DeveloperDto developerDto) {
		Developer developer = new Developer();
		developer.setFirstName(developerDto.getFirstName());
		developer.setLastName(developerDto.getLastName());
		developer.setExperience(developerDto.getExperience());
		return DeveloperDto.entityToDto(developerDao.create(developer));
	}

	@Override
	public DeveloperDto getDeveloperById(Long id) {
		return DeveloperDto.entityToDto(developerDao.get(id));
	}

	@Override
	public void deleteDeveloperById(Long id) {
		developerDao.delete(id);
	}

	@Override
	public void updateDeveloper(Long id, DeveloperDto developerDto) {
		Developer existingDeveloper = Optional.ofNullable(developerDao.get(id)).orElse(new Developer());
		existingDeveloper.setExperience(developerDto.getExperience());
		existingDeveloper.setFirstName(developerDto.getFirstName());
		existingDeveloper.setLastName(developerDto.getLastName());
		developerDao.update(existingDeveloper);
	}
}