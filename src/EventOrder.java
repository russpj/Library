import java.util.Comparator;

public class EventOrder implements Comparator<Event>
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
