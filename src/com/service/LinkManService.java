package com.service;

import java.util.List;

import com.domain.LinkMan;

public interface LinkManService {
	public void saveLinkMan(LinkMan lm);

	public List<LinkMan> getAll();
}
