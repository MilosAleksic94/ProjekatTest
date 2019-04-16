package rzk;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import model.Card;

/**
 * Message-Driven Bean implementation class for: GraduateMDB
 */
@MessageDriven(name = "GraduateMDB", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/topic/CARDS") })
public class GraduateMDB implements MessageListener {

    /**
     * Default constructor. 
     */
    public GraduateMDB() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
    	try {
    		ObjectMessage Omessage= (ObjectMessage) message;
			Card c= (Card) Omessage.getObject();
			if(c.getCardType().equals("diplomski")){
				System.out.println("Srecan diplomski");
			}
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
        
    }


