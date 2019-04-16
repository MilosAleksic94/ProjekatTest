package rzk;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Card;

/**
 * Session Bean implementation class CardsBean
 */
@Stateless
@LocalBean
public class CardsBean implements CardsBeanRemote {

    /**
     * Default constructor. 
     */
	;	
	@Inject
	JMSContext context;
	
	@PersistenceContext
	EntityManager em;
	
	@Resource(mappedName="java:/jms/queue/CARDS")
	private javax.jms.Destination destinationQueue;
	
	
	
    public CardsBean() {
        // TODO Auto-generated constructor stub
    }
    
    public void sendQueueMessage(String userFrom,String toUser,String email,String cardType){
    	try{
    		ObjectMessage message = context.createObjectMessage();
			
    		Card c= new Card();//(Card) message.getObject();
    		c.setFromUser(userFrom);
    		c.setToUser(toUser);
    		c.setUserEmail(email);
    		c.setCardType(cardType);
    		em.persist(c);
    		message.setObject(c);
    		
			JMSProducer producer = context.createProducer();
			producer.send(destinationQueue, message);
    		
    	}catch(JMSException e){
    		e.printStackTrace();
    	}
    	
    	
    	
    }
    
    

}
