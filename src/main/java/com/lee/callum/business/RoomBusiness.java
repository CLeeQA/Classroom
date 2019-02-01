package com.lee.callum.business;

import javax.inject.Inject;

import com.lee.callum.repository.RoomRepository;

public class RoomBusiness implements BusinessInterface {

	@Inject
	private RoomRepository repo;

	@Override
	public String addEntry() {
		return repo.addEntry();
	}

	@Override
	public String getAllEntries() {
		return repo.getAllEntries();
	}

	@Override
	public String deleteEntry(long id) {
		return repo.deleteEntry(id);
	}

	@Override
	public String updateEntry(long id, String name) {
		return repo.updateEntry(id, name);
	}

}
