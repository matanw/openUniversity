
public class Time2 {


	private static final int MIN_VALUE_FOR_HOUR=0;
	private static final int MIN_VALUE_FOR_MINUTE=0;
	private static final int DEFAULT_VALUE_FOR_HOUR=0;
	private static final int DEFAULT_VALUE_FOR_MINUTE=0;
	private static final int MAX_VALUE_FOR_HOUR=23;
	private static final int MAX_VALUE_FOR_MINUTE=59;
	private static final int MINUTES_PER_HOURS=60;
	private static final int SMALLEST_TWO_DIGITS_NUMBER=10;

	private int _minFromMid;

	public Time2(int h, int m) {
		int hour = (h >= MIN_VALUE_FOR_HOUR && h <= MAX_VALUE_FOR_HOUR ? h : DEFAULT_VALUE_FOR_HOUR);
		int minute = (m >= MIN_VALUE_FOR_MINUTE && m <= MAX_VALUE_FOR_MINUTE ? m : DEFAULT_VALUE_FOR_MINUTE);
		_minFromMid = hour * MINUTES_PER_HOURS + minute;
	}

	public Time2(Time2 t) {
		_minFromMid = t._minFromMid;
	}

	public int getHour() {
		return _minFromMid / MINUTES_PER_HOURS;
	}

	public int getMinute() {
		return _minFromMid % MINUTES_PER_HOURS;
	}

	public void setHour(int num) {
		if (num >= MIN_VALUE_FOR_HOUR && num <= MAX_VALUE_FOR_HOUR) {
			_minFromMid = num * MINUTES_PER_HOURS + getMinute();
		}
	}

	public void setMinute(int num) {
		if (num >= MIN_VALUE_FOR_MINUTE && num <= MAX_VALUE_FOR_HOUR) {
			_minFromMid = getHour() * MINUTES_PER_HOURS + num;EJYKF
		}
	}

	public String toString() {
		return formatNumber(getHour()) + ":" + formatNumber(getMinute());
	}

	private String formatNumber(int num) {
		return (num >= SMALLEST_TWO_DIGITS_NUMBER ? "" : "0") + num;
	}

	public int minFromMidnight() {
		return _minFromMid;
	}

	public boolean equals(Time2 other) {
		return _minFromMid == other._minFromMid;
	}

	public boolean before(Time2 other) {
		return _minFromMid < other._minFromMid;
	}

	public boolean after(Time2 other) {
		return other.before(this);
	}

	public int different(Time2 other) {
		return _minFromMid - other._minFromMid;
	}
}
