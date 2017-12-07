//	The Event class contains the information for the checkin
//  and checkout Events.

import java.util.List;
import java.util.ArrayList;

public class Event {
	enum DeskEvent {
		checkout,
		checkin
	}
	
	Event(String nameIn, int dayIn, DeskEvent eventIn)
	{
		bookName = nameIn;
		day = dayIn;
		deskEvent = eventIn;
	}
	
	public static int MaxCheckedOut(List<Event> events)
	{
		int maxCount = 0;
		int countCheckedOut = 0;
		
		for (int i=0; i < events.size(); i++)
		{
			Event event = events.get(i);
			switch (event.deskEvent)
			{
			case checkout:
				countCheckedOut++;
				break;
				
			case checkin:
				countCheckedOut--;
			}
			
			if (countCheckedOut > maxCount)
			{
				maxCount = countCheckedOut;
			}
		}
		
		return maxCount;
	}
	
	public static List<Event> EventsFromTrans(List<BookTransaction> trans)
	{
		ArrayList<Event> events = new ArrayList<Event>();
		
		for (int i = 0; i < trans.size(); i++)
		{
			BookTransaction tran = trans.get(i);
			if (tran.dayIn >= 0)
			{
				events.add(new Event(tran.name, tran.dayIn, Event.DeskEvent.checkin));
			}
			if (tran.dayOut >= 0)
			{
				events.add(new Event(tran.name, tran.dayOut, Event.DeskEvent.checkout));
			}
		}
		return events;
	}

	public String bookName;
	public int day;
	public DeskEvent deskEvent; 
}
