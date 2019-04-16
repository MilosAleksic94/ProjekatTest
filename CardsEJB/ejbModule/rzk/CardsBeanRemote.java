package rzk;

import javax.ejb.Remote;

@Remote
public interface CardsBeanRemote {
	
	 public void sendQueueMessage(String userFrom,String toUser,String email,String cardType);


}
