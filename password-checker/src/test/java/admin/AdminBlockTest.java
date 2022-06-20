package admin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AdminBlockTest {

	@DisplayName("새로 생성한 관리자는 차단 상태가 아님")
	@Test
	void newCreateAdmin_NoBlock() {
		Admin admin = new Admin();
		assertFalse(admin.isBlocked());
	}

	@DisplayName("차단되지 않은 관리자 계정 차단하기")
	@Test
	void block_whenUnblocked() {
		Admin admin = new Admin();
		admin.block();
		assertTrue(admin.isBlocked());
	}

	@DisplayName("이미 차단당한 관리자 계정 차단하기 - 예외 발생")
	@Test
	void block_WhenAlreadyBlocked_ThrowsException(){
		Admin admin = new Admin();
		admin.block();
		assertThrows(AlreadyBlockedException.class,
			() -> admin.block());
	}

	@DisplayName("차단당하지 않은 관리자 계정 차단 해제하기 - 예외 발생")
	@Test
	void unblock_WhenNotBlocked_ThrowsException()	{
		Admin admin = new Admin();
		assertThrows(NonBlockedException.class , () -> admin.unblock());
	}

	@DisplayName("차단당한 관리자 계정 차단 해제하기")
	@Test
	void unblock_WhenBlocked()	{
		Admin admin = new Admin();
		admin.block();
		assertTrue(admin.isBlocked());

		admin.unblock();
		assertFalse(admin.isBlocked());
	}

}
