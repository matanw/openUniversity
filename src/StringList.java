// n- nums of node m-nums of char

public class StringList {
	private CharNode _head;

	public StringList() {
		_head = null;
	}

	public StringList(CharNode node) {
		_head = node;
	}

	public char charAt(int i) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	public StringList concat(String str) {
		throw new UnsupportedOperationException("str?");
	}

	public int indexOf(int ch) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	public int indexOf(int ch, int fromIndex) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	public boolean equals(String s) {
		throw new UnsupportedOperationException("Not implemented yet.only recursive.str? assume other correct?");
	}

	public StringList subString(int i) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	// O(n)
	public int length() {
		CharNode pos = _head;
		int result = 0;
		while (pos != null) {
			result += pos.getValue();
			pos = pos.getNext();
		}
		return result;
	}
}
