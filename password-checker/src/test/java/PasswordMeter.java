public class PasswordMeter {

	public PasswordStrength meter(String password) {
		if(password == null || password.isEmpty()){
			throw new IllegalArgumentException();
		}

		return PasswordStrength.STRONG;
	}
}
