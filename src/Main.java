import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		ArrayList<Event> events = new ArrayList<Event>();
		
		System.out.println("Using hand-rolled Events");
		events.add(new Event("Head First Java", 1, Event.Stamp.checkout));
		events.add(new Event("Head First Java", 1, Event.Stamp.checkout));
		events.add(new Event("Head First Java", 2, Event.Stamp.checkout));
		events.add(new Event("Head First Java", 3, Event.Stamp.checkin));
		events.add(new Event("Head First Java", 4, Event.Stamp.checkout));
		events.add(new Event("Head First Java", 5, Event.Stamp.checkout));
		events.add(new Event("Head First Java", 7, Event.Stamp.checkin));
		events.add(new Event("Head First Java", 8, Event.Stamp.checkout));
		events.add(new Event("Head First Java", 8, Event.Stamp.checkout));
		events.add(new Event("Head First Java", 9, Event.Stamp.checkin));
		events.add(new Event("Head First Java", 10, Event.Stamp.checkin));
		events.add(new Event("Head First Java", 12, Event.Stamp.checkin));
		
		int maxCheckedOut = Event.MaxCheckedOut(events);
		
		System.out.print("There were at most ");
		System.out.print(maxCheckedOut);
		System.out.println(" books checked out"); 
		
		System.out.println("Using Book Transactions");
		
		ArrayList<Slip> trans = new ArrayList<Slip>();
		
		trans.add(new Slip("Head First Java", 1, 8));
		trans.add(new Slip("Head First Java", 1, 3));
		trans.add(new Slip("Head First Java", 2, 3));
		trans.add(new Slip("Head First Java", 4, -1));
		trans.add(new Slip("Head First Java", 5, 10));
		trans.add(new Slip("Head First Java", 8, 9));
		trans.add(new Slip("Head First Java", 8, -1));
		
		List<Event> eventsFromTrans = Event.EventsFromTrans(trans);
		System.out.println(eventsFromTrans.size());
		for (int i = 0; i < eventsFromTrans.size(); i++)
		{
			Event event = eventsFromTrans.get(i);
			System.out.println(event.toString());
		}
		
		maxCheckedOut = Event.MaxCheckedOut(events);
		System.out.print("There were at most ");
		System.out.print(maxCheckedOut);
		System.out.println(" books checked out"); 
	}
}
