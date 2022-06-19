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
		PasswordStrength result = passwordMeter.meter("abcABC123");
		assertEquals(result, PasswordStrength.STRONG);
	}
}
