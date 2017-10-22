
public class Time1 {

	private static final int MIN_VALUE_FOR_HOUR = 0;
	private static final int MIN_VALUE_FOR_MINUTE = 0;
	private static final int DEFAULT_VALUE_FOR_HOUR = 0;
	private static final int DEFAULT_VALUE_FOR_MINUTE = 0;
	private static final int MAX_VALUE_FOR_HOUR = 23;
	private static final int MAX_VALUE_FOR_MINUTE = 59;
	private static final int MINUTES_PER_HOURS = 60;
	private static final int SMALLEST_TWO_DIGITS_NUMBER = 10;

	private int _hour;
	private int _minute;

	public Time1(int h, int m) {
		_hour = (h >= MIN_VALUE_FOR_HOUR && h <= MAX_VALUE_FOR_HOUR ? h : DEFAULT_VALUE_FOR_HOUR);
		_minute = (m >= MIN_VALUE_FOR_MINUTE && m <= MAX_VALUE_FOR_MINUTE ? m : DEFAULT_VALUE_FOR_MINUTE);
	}

	public Time1(Time1 t) {
		_hour = t._hour;
		_minute = t._minute;
	}

	public int getHour() {
		return _hour;
	}

	public int getMinute() {
		return _minute;
	}

	public void setHour(int num) {
		if (num >= MIN_VALUE_FOR_HOUR && num <= MAX_VALUE_FOR_HOUR) {
			_hour = num;
		}
	}

	public void setMinute(int num) {
		if (num >= MIN_VALUE_FOR_MINUTE && num <= MAX_VALUE_FOR_MINUTE) {
			_minute = num;
		}
	}

	public String toString() {
		return formatNumber(_hour) + ":" + formatNumber(_minute);
	}

	private String formatNumber(int num) {
		return (num >= SMALLEST_TWO_DIGITS_NUMBER ? "" : "0") + num;
	}

	public int minFromMidnight() {
		return MINUTES_PER_HOURS * _hour + _minute;
	}

	public boolean equals(Time1 other) {
		return _hour == other._hour && _minute == other._minute;
	}

	public boolean before(Time1 other) {
		return _hour < other._hour || (_hour == other._hour && _minute < other._minute);
	}

	public boolean after(Time1 other) {
		return other.before(this);
	}

	public int difference(Time1 other) {
		return minFromMidnight() - other.minFromMidnight();
	}
}
