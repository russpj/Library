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
		
		events.sort(new EventOrder());
		
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
