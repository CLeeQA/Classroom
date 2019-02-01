package com.lee.callum.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import com.lee.callum.persistence.domain.Room;
import com.lee.callum.util.JSONUtil;

public class RoomRepository implements ClassroomInterface {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	private Map<Long, Room> roomMap = new HashMap<>();

	@POST
	public String addEntry() {
		Query query = manager.createQuery("Select a FROM Room a");
		Collection<Room> rooms = (Collection<Room>) query.getResultList();
		return util.getJSONForObject(rooms);
	}

	@GET
	public String getAllEntries() {
		Query query = manager.createQuery("Select a FROM Room a");
		Collection<Room> rooms = (Collection<Room>) query.getResultList();
		return util.getJSONForObject(rooms);
	}

	@DELETE
	public String deleteEntry(long roomID) {
		Room roomInDB = getRoomID(roomID);
		if (roomInDB != null) {
			manager.remove(roomInDB);
		}
		return "Classroom Deleted!";
	}

	@PUT
	public String updateEntry(long id, String name) {
		Room selectedRoom = util.getObjectForJSON(name, Room.class);
		roomMap.put(id, selectedRoom);
		return "Classroom Updated!";
	}

	private Room getRoomID(long roomID) {
		return manager.find(Room.class, roomID);
	}

}
