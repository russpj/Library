import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Event> events = new ArrayList<Event>();
		
		events.add(new Event("Head First Java", 1, Event.DeskEvent.checkout));
		events.add(new Event("Head First Java", 1, Event.DeskEvent.checkout));
		events.add(new Event("Head First Java", 2, Event.DeskEvent.checkout));
		events.add(new Event("Head First Java", 3, Event.DeskEvent.checkin));
		events.add(new Event("Head First Java", 4, Event.DeskEvent.checkout));
		events.add(new Event("Head First Java", 5, Event.DeskEvent.checkout));
		events.add(new Event("Head First Java", 7, Event.DeskEvent.checkin));
		events.add(new Event("Head First Java", 8, Event.DeskEvent.checkout));
		events.add(new Event("Head First Java", 8, Event.DeskEvent.checkout));
		events.add(new Event("Head First Java", 9, Event.DeskEvent.checkin));
		events.add(new Event("Head First Java", 10, Event.DeskEvent.checkin));
		events.add(new Event("Head First Java", 12, Event.DeskEvent.checkin));
		
		int maxCheckedOut = Event.MaxCheckedOut(events);
		
		System.out.print("There were at most ");
		System.out.print(maxCheckedOut);
		
		System.out.println(" books checked out");  
	}
}
