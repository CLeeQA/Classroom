package com.lee.callum.business;

public interface BusinessInterface {
	
	String addEntry();
	String getAllEntries();
	String deleteEntry(long id);
	String updateEntry(long id, String name);

}
