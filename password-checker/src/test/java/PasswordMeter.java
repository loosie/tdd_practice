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

		boolean containsDi = containsDigit(password);
		if(!containsDi){
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

	private boolean containsDigit(String password) {
		for(char ch : password.toCharArray()){
			if('0' <= ch && ch <= '9'){
				return true;
			}
		}
		return false;
	}
}
