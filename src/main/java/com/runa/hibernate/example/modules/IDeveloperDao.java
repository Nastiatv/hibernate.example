package com.runa.hibernate.example.modules;

import java.util.List;


public interface IDeveloperDao{

	Developer create(Developer developer);
	Developer get(Long id);
	void update (Developer developer);
	void delete (Long id);
	List<Developer> getAll();
}
