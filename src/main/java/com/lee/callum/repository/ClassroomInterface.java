package com.lee.callum.repository;

public interface ClassroomInterface {
	
	String addEntry();
	String getAllEntries();
	String deleteEntry(long id);
	String updateEntry(long id, String name);

}
