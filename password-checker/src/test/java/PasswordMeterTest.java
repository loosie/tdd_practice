import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PasswordMeterTest {

	private PasswordMeter passwordMeter = new PasswordMeter();

	@DisplayName("null 입력이면 IllegalArgumentException 발생")
	@Test
	void nullInput() {
		assertThrows(IllegalArgumentException.class,
			() -> passwordMeter.meter(null));
	}

	@DisplayName("빈 값 입력이면 IllegalArgumentException 발생")
	@Test
	void emptyInput() {
		assertThrows(IllegalArgumentException.class,
			() -> passwordMeter.meter(""));
	}

	@DisplayName("모든 조건을 충족하는 경우 상태는 강함")
	@Test
	void passwordMatchesAllConditions(){
		assertPasswordStrength("abcABC123", PasswordStrength.STRONG);
		assertPasswordStrength("123aAbBcC", PasswordStrength.STRONG);
	}

	@DisplayName("길이가 8미만, 다른 조건 충족하면 상태는 보통")
	@Test
	void passwordLenLessThanEight_AllOtherConditionsAreMatches(){
		assertPasswordStrength("abcA123", PasswordStrength.NORMAL);
		assertPasswordStrength("123abcC", PasswordStrength.NORMAL);
		assertPasswordStrength("Cabc12", PasswordStrength.NORMAL);
	}

	@DisplayName("대문자 없음, 다른 조건 충족하면 상태는 보통")
	@Test
	void passwordNotIncludeUpperCase_AllOtherConditionsAreMatches(){
		assertPasswordStrength("abcd1234", PasswordStrength.NORMAL);
		assertPasswordStrength("1234abcdef", PasswordStrength.NORMAL);
	}

	@DisplayName("숫자 없음, 다른 조건 충족하면 상태는 보통")
	@Test
	void passwordNotIncludeDigit_AllOtherConditionsAreMatches(){
		assertPasswordStrength("ABCDEFGHabcde", PasswordStrength.NORMAL);
		assertPasswordStrength("abcdeFGHIGK", PasswordStrength.NORMAL);
	}

	@DisplayName("길이만 충족, 다른 조건 충족하지 않은 경우 상태는 약함")
	@Test
	void passwordOnlyMatchesLengthRule_AllOtherConditionsAreNotMatches(){
		assertPasswordStrength("abcdefgh", PasswordStrength.WEAK);
	}

	@DisplayName("대문자만 충족, 다른 조건 충족하지 않은 경우 상태는 약함")
	@Test
	void passwordOnlyMatchesUpperCase_AllOtherConditionsAreNotMatches(){
		assertPasswordStrength("abcABC", PasswordStrength.WEAK);
	}

	@DisplayName("숫자만 충족, 다른 조건 충족하지 않은 경우 상태는 약함")
	@Test
	void passwordOnlyMatchesDigit_AllOtherConditionsAreNotMatches(){
		assertPasswordStrength("abc123", PasswordStrength.WEAK);
	}

	private void assertPasswordStrength(String password, PasswordStrength expected) {
		PasswordStrength result = passwordMeter.meter(password);
		assertEquals(result, expected);
	}
}
