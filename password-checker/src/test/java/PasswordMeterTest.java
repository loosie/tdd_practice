import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PasswordMeterTest {

	@DisplayName("null 입력이면 IllegalArgumentException 발생")
	@Test
	void nullInput() {
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> new PasswordMeter().meter(null));
	}
}
