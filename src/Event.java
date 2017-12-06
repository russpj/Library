//	The Event class contains the information for the checkin
//  and checkout Events.

import java.util.List;

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

	public String bookName;
	public int day;
	public DeskEvent deskEvent; 
}
