package MeetingRoomBooking;

import java.util.*;

public class RoomScheduler {
    private static final String ROOM_ADDED_MESSAGE = "Room added: %s, ID: %s";
    private static final String ROOM_BOOKED_MESSAGE = "Room %s booked successfully.";
    private static final String ROOM_NOT_AVAILABLE_MESSAGE = "Room %s does not meet the required features.";
    private static final String AVAILABLE_ROOMS_MESSAGE = "Available rooms with %s: %s";

    private final Map<String, MeetingRoom> meetingRooms;

    public RoomScheduler() {
        this.meetingRooms = new HashMap<>();
    }

    // Adds a new meeting room to the scheduler
    public void addMeetingRoom(MeetingRoom room) {
        meetingRooms.put(room.getRoomId(), room);
        System.out.println(String.format(ROOM_ADDED_MESSAGE, room.getRoomName(), room.getRoomId()));
    }

    // Attempts to book a meeting room with required features
    public void bookRoom(String roomId, EnumSet<RoomFeature> requiredFeatures) {
        MeetingRoom room = meetingRooms.get(roomId);
        if (room != null && room.getFeatures().containsAll(requiredFeatures)) {
            System.out.println(String.format(ROOM_BOOKED_MESSAGE, roomId));
        } else {
            System.out.println(String.format(ROOM_NOT_AVAILABLE_MESSAGE, roomId));
        }
    }

    // Lists available rooms that match all required features
    public void listAvailableRooms(EnumSet<RoomFeature> requiredFeatures) {
        List<String> availableRooms = new ArrayList<>();
        for (MeetingRoom room : meetingRooms.values()) {
            if (room.getFeatures().containsAll(requiredFeatures)) {
                availableRooms.add(room.getRoomName());
            }
        }
        System.out.println(String.format(AVAILABLE_ROOMS_MESSAGE, requiredFeatures, availableRooms));
    }
}
