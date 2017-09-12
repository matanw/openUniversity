
public class Time2 {
	private int _minFromMid;

	public Time2(int h, int m) {
		int hour = (h >= 0 && h <= 23 ? h : 0);
		int minute = (m >= 0 && m <= 59 ? m : 0);
		_minFromMid = hour * 60 + minute;
	}

	public Time2(Time2 t) {
		_minFromMid = t._minFromMid;
	}

	public int getHour() {
		return _minFromMid / 60;
	}

	public int getMinute() {
		return _minFromMid % 60;
	}

	public void setHour(int num) {
		if (num >= 0 && num <= 23) {
			_minFromMid = num * 60 + getMinute();
		}
	}

	public void setMinute(int num) {
		if (num >= 0 && num <= 59) {
			_minFromMid = getHour() * 60 + num;
		}
	}

	public String toString() {
		return formatNumber(getHour()) + ":" + formatNumber(getMinute());
	}

	private String formatNumber(int num) {
		return (num >= 10 ? "" : "0") + num;
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
