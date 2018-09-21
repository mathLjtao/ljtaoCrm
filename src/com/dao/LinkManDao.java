package com.dao;

import java.util.List;

import com.domain.LinkMan;

public interface LinkManDao {
	public void save(LinkMan lm);

	public List<LinkMan> getAll();
}
