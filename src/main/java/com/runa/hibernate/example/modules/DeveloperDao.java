package com.runa.hibernate.example.modules;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeveloperDao implements IDeveloperDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Developer create(Developer developer) {
		getSession().save(developer);
		return developer;
	}

	private Session getSession() {
		return sf.getCurrentSession();
	}

	@Override
	public Developer get(Long id) {
		return getSession().get(Developer.class, id);
	}

	@Override
	public void update(Developer developer) {
		getSession().update(developer);

	}

	@Override
	public void delete(Long id) {
		getSession().delete(get(id));
	}

	@Override
	public List<Developer> getAll() {
		Session session = getSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Developer> cq = cb.createQuery(Developer.class);
		Root<Developer> rootEntry = cq.from(Developer.class);
		cq.select(rootEntry);
		TypedQuery<Developer> result = session.createQuery(cq);
		return result.getResultList();
	}
}