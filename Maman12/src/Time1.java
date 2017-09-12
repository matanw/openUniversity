
public class Time1 {
	private int _hour;
	private int _minute;

	public Time1(int h, int m) {
		_hour = (h >= 0 && h <= 23 ? h : 0);
		_minute = (m >= 0 && m <= 59 ? m : 0);
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
		if (num >= 0 && num <= 23) {
			_hour = num;
		}
	}

	public void setMinute(int num) {
		if (num >= 0 && num <= 59) {
			_minute = num;
		}
	}

	public String toString() {
		return formatNumber(_hour) + ":" + formatNumber(_minute);
	}

	private String formatNumber(int num) {
		return (num >= 10 ? "" : "0") + num;
	}

	public int minFromMidnight() {
		return 60 * _hour + _minute;
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

	public int different(Time1 other) {
		return minFromMidnight() - other.minFromMidnight();
	}
}
