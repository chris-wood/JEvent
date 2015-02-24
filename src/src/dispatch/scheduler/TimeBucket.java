package dispatch.scheduler;

import java.util.ArrayList;
import java.util.List;

import dispatch.event.EventPacket;

public class TimeBucket<T> {

	private long eventTime;
	private List<T> events;
	
	public TimeBucket(long time) {
		eventTime = time;
		this.events = new ArrayList<T>();
	}
	
	public void addEvent(T packet) {
		events.add(packet);
	}
	
	public long getEventTime() {
		return eventTime;
	}
	
//	public boolean hasNext() {
//		return !events.isEmpty();
//	}
//	
//	public T pop() {
//		T packet = events.get(0);
//		events.remove(0);
//		return packet;
//	}
//	
//	public T next() {
//		return events.get(0);
//	}
//	
//	public void remove() {
//		events.remove(0);
//	}
	
	public List<T> getContents() {
		return events;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("TimeBucket[" + eventTime + "] = [");
		if (!events.isEmpty()) {
			for (int i = 0; i < events.size() - 1; i++) {
				builder.append(events.get(i) + ",");
			}
			builder.append(events.get(events.size() - 1));
		}
		builder.append("]");
		
		return builder.toString();
	}
	
}