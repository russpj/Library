//	The Event class contains the information for the checkin
//  and checkout Events.

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Event {
	enum Stamp {
		checkout,
		checkin
	}
	
	Event(String nameIn, int dayIn, Stamp stampIn)
	{
		bookName = nameIn;
		day = dayIn;
		stamp = stampIn;
	}
	
	public static int MaxCheckedOut(List<Event> events)
	{
		int maxCount = 0;
		int countCheckedOut = 0;
		
		for (int i=0; i < events.size(); i++)
		{
			Event event = events.get(i);
			switch (event.stamp)
			{
			case checkout:
				countCheckedOut++;
				break;
				
			case checkin:
				countCheckedOut--;
				break;
			}
			
			if (countCheckedOut > maxCount)
			{
				maxCount = countCheckedOut;
			}
		}
		
		return maxCount;
	}
	
	private static class Order implements Comparator<Event>
	{
		public int compare(Event event1, Event event2)
		{
			if (event1.day != event2.day)
				return event1.day - event2.day;
			else if (event1.stamp != event2.stamp)
				return (event1.stamp == Event.Stamp.checkin) ? -1 : 1;
			else
				return (event1.bookName.compareTo(event2.bookName));
		}
	}
	
	public static List<Event> EventsFromTrans(List<Slip> slips)
	{
		ArrayList<Event> events = new ArrayList<Event>();
		
		for (int i = 0; i < slips.size(); i++)
		{
			Slip slip = slips.get(i);
			if (slip.dayIn >= 0)
			{
				events.add(new Event(slip.name, slip.dayIn, Stamp.checkin));
			}
			if (slip.dayOut >= 0)
			{
				events.add(new Event(slip.name, slip.dayOut, Stamp.checkout));
			}
		}
		
		events.sort(new Order());
		
		return events;
	}
	
	@Override
	public String toString() {
		String result = new String(bookName);
		result += " ";
		result += String.valueOf(day);
		result += " ";
		result += stamp.toString();
		return result;
	}

	public String bookName;
	public int day;
	public Stamp stamp; 
}
