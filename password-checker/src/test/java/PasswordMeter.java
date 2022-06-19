public class PasswordMeter {

	public PasswordStrength meter(String password) {
		if (password == null || password.isEmpty()) {
			throw new IllegalArgumentException();
		}

		if (password.length() < 8) {
			return PasswordStrength.NORMAL;
		}

		return PasswordStrength.STRONG;
	}
}
