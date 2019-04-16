package rzk;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Card;

/**
 * Message-Driven Bean implementation class for: Queue
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/queue/CARDS"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "java:/jms/queue/CARDS")
public class Queue implements MessageListener {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
	
	@Inject
	JMSContext context;
	
	//posalji u topic
	
	@Resource(mappedName="java:/jms/topic/CARDS")
	private javax.jms.Destination destinationTopic;
	
    public Queue() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        // TODO Auto-generated method stub	
        
    	
    	JMSProducer producer=context.createProducer();
    	producer.send(destinationTopic, message);
    }
    
   
    
    public void insert(String fromUser,String toUser,String userEmail){
    	
    	Card c=new Card();
    	c.setFromUser(fromUser);
    	c.setToUser(toUser);
    	c.setUserEmail(userEmail);
    	em.persist(c);
    	
    	
    }

}
