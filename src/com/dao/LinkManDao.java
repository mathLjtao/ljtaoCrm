package com.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.domain.LinkMan;

public interface LinkManDao {
	public void save(LinkMan lm);

	public List<LinkMan> getAll();

	public List<LinkMan> getAll(DetachedCriteria dc);

	public void deleteById(Long lkm_id);

	public LinkMan getById(Long lkm_id);

	public void update(LinkMan lm);
}
