package admin;

public class Admin {
	private boolean blocked = false;
	public boolean isBlocked() {
		return blocked;
	}

	public void block() {
		if(blocked){
			throw new AlreadyBlockedException();
		}
		blocked = true;
	}

	public void unblock() {
		if(!blocked){
			throw new NonBlockedException();
		}

		blocked = false;
	}
}
