public class PasswordMeter {

	public PasswordStrength meter(String password) {
		if (password == null || password.isEmpty()) {
			throw new IllegalArgumentException();
		}

		boolean lengthRule = password.length() >= 8;
		boolean containsUp = containsUppercase(password);
		boolean containsDi = containsDigit(password);

		int metCount = 0;
		if(lengthRule) metCount++;
		if(containsUp) metCount++;
		if(containsDi) metCount++;

		if(metCount <= 1){
			return PasswordStrength.WEAK;
		} else if(metCount == 2) {
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
