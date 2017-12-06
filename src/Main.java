import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		ArrayList<Event> events = new ArrayList<Event>();
		
		System.out.println("Using hand-rolled Events");
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
		
		System.out.println("Using Book Transactions");
		
		ArrayList<BookTransaction> trans = new ArrayList<BookTransaction>();
		
		trans.add(new BookTransaction("Head First Java", 1, 7));
		trans.add(new BookTransaction("Head First Java", 1, 3));
		trans.add(new BookTransaction("Head First Java", 2, 3));
		trans.add(new BookTransaction("Head First Java", 4, -1));
		trans.add(new BookTransaction("Head First Java", 5, 10));
		trans.add(new BookTransaction("Head First Java", 8, 9));
		trans.add(new BookTransaction("Head First Java", 8, -1));
		
		List<Event> eventsFromTrans = Event.EventsFromTrans(trans);
		System.out.println(eventsFromTrans.size());
	}
}
