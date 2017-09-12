
public class Flight {

	private String _origin;
	private String _destination;
	private Time1 _departure;
	private int _flightDuration;
	private int _noOfPassengers;
	private boolean _isFull;
	private int _price;

	// TODO:GETTERS,SETTERS

	private static int MAX_CAPACITY = 250;

	public Flight(String origin, String destination, int departureHour, int departureMinute, int flightDuration,
			int noOfPassengers, int price) {
		_origin = origin;
		_destination = destination;
		_departure = new Time1(departureHour, departureMinute);
		_flightDuration = Math.max(0, flightDuration);
		_noOfPassengers = (noOfPassengers > MAX_CAPACITY ? MAX_CAPACITY : Math.max(0, noOfPassengers));
		_isFull = (_noOfPassengers == MAX_CAPACITY);
		_price = Math.max(0, price);
	}

	public Flight(Flight other) {
		_origin = other._origin;
		_destination = other._destination;
		_departure = other._departure;
		_flightDuration = other._flightDuration;
		_noOfPassengers = other._noOfPassengers;
		_isFull = other._isFull;
		_price = other._price;
	}

	public boolean equals(Flight other) {
		return _origin.equals(other._origin) && _destination.equals(other._destination)
				&& _departure.equals(other._departure);
	}

	public Time1 getArrivalTime() {
		int arrivalMinFromMid = _departure.minFromMidnight() + _flightDuration;
		return new Time1(arrivalMinFromMid / 60, arrivalMinFromMid % 60);
	}

	public boolean addPassenger(int num) {
		if (_noOfPassengers + num <= MAX_CAPACITY) {
			_noOfPassengers = _noOfPassengers + num;
			_isFull = (_noOfPassengers == MAX_CAPACITY);
			return true;
		}
		return false;
	}

	public boolean isCheaper(Flight other) {
		return _price < other._price;
	}

	public boolean landsEarlier(Flight other) {
		return this.getArrivalTime().before(other.getArrivalTime());
	}

	public String toString() {
		return "Flight from " + _origin + " to " + _destination + " departs at " + _departure + ". Flight is "
				+ (_isFull ? "full." : "not full.");
		// TODO:
	}

}
