
public class Flight {

	private String _origin;
	private String _destination;
	private Time1 _departure;
	private int _flightDuration;
	private int _noOfPassengers;
	private boolean _isFull;
	private int _price;

	private static int MAX_CAPACITY = 250;
	private static final int MINUTES_PER_HOURS = 60;

	public String getOrigin() {
		return _origin;
	}

	public void setOrigin(String origin) {
		this._origin = origin;
	}

	public String getDestination() {
		return _destination;
	}

	public void setDestination(String destination) {
		this._destination = destination;
	}

	public Time1 getDeparture() {
		return new Time1(_departure);
	}

	public void setDeparture(Time1 departure) {
		this._departure = new Time1(departure);
	}

	public int getFlightDuration() {
		return _flightDuration;
	}

	public void setFlightDuration(int flightDuration) {
		if (flightDuration >= 0) {
			this._flightDuration = flightDuration;
		}
	}

	public int getNoOfPassengers() {
		return _noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		if (noOfPassengers >= 0 && noOfPassengers <= MAX_CAPACITY) {
			this._noOfPassengers = noOfPassengers;
		}
	}

	public boolean getIsFull() {
		return _isFull;
	}

	public void setIsFull(boolean isFull) {
		this._isFull = isFull;
	}

	public int getPrice() {
		return _price;
	}

	public void setPrice(int price) {
		this._price = price;
	}

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
		_departure = new Time1(other._departure);
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
		return new Time1(arrivalMinFromMid / MINUTES_PER_HOURS, arrivalMinFromMid % MINUTES_PER_HOURS);
	}

	public boolean addPassengers(int num) {
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

	public int totalPrice() {
		return _price * _noOfPassengers;
	}

	public String toString() {
		return "Flight from " + _origin + " to " + _destination + " departs at " + _departure + ". Flight is "
				+ (_isFull ? "full." : "not full.");
	}

}
