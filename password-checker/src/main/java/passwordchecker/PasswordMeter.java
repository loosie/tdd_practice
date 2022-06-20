package passwordchecker;

public class PasswordMeter {

	public PasswordStrength meter(String password) {
		checkPasswordInputIsEmpty(password);

		int metCount = calculateMetCount(password);

		if(metCount <= 1){
			return PasswordStrength.WEAK;
		} else if(metCount == 2) {
			return PasswordStrength.NORMAL;
		}

		return PasswordStrength.STRONG;
	}

	private int calculateMetCount(String password) {
		int metCount = 0;
		if(passwordLengthIsEightOrMore(password)) metCount++;
		if(containsUppercase(password)) metCount++;
		if(containsDigit(password)) metCount++;
		return metCount;
	}

	private void checkPasswordInputIsEmpty(String password) {
		if (password == null || password.isEmpty()) {
			throw new IllegalArgumentException();
		}
	}

	private boolean passwordLengthIsEightOrMore(String password) {
		return password.length() >= 8;
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
