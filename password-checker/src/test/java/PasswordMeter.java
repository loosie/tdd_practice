public class PasswordMeter {

	public PasswordStrength meter(String password) {
		if (password == null || password.isEmpty()) {
			throw new IllegalArgumentException();
		}

		boolean lengthRule = password.length() >= 8;
		if (!lengthRule) {
			return PasswordStrength.NORMAL;
		}

		boolean containsUp = containsUppercase(password);
		if(!containsUp){
			return PasswordStrength.NORMAL;
		}

		return PasswordStrength.STRONG;
	}

	private boolean containsUppercase(String password) {
		for(char ch : password.toCharArray()){
			if('A' <= ch && ch <= 'Z'){
				return true;
			}
		}
		return false;
	}
}
