import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: rustoj01
 * Date: 03/10/2012
 * Time: 13:18
 * To change this template use File | Settings | File Templates.
 */
public class CustomerTest {

    private static final String CUSTOMER_NAME = "Dave";
    private static final Topic TOPIC = new Topic("trains and boats");
    private static TopicManager topicManager = TopicManager.getInstance();
    private static Message message = new Message("i'm a message");

    static Customer customer = new Customer(CUSTOMER_NAME);

    @BeforeClass
    public static void setUp(){
        topicManager.addTopic(TOPIC);
        customer.addSubscription(TOPIC.getName());
        message.setAuthor("james");
    }
    @Test
    public void setValidName(){
        assertEquals(CUSTOMER_NAME,customer.getName());
    }

    @Test
    public void customerSubscribesToTopic(){
        assertFalse(customer.addSubscription("trains and elephants"));
    }

    @Test
    public void customerSubscribedForATopicAndSubsequentlyReceivedAMessageFromSaidTopic(){
        assertEquals(0, customer.messageCount());
        TOPIC.publishMessage(message);
        assertEquals(1, customer.messageCount());
        assertEquals(message,customer.getLastMessage());
    }

    @Test
    public void customerDoesntReceiveMessageFromBlacklistedAuthor(){
        customer.clearMessages();
        customer.addBlacklistAuthor("james");
        assertEquals(0,customer.messageCount());

    }

    @Test
    public void customerAddsMoneyToAccountAndReceivesAMessageFromAPaidAccountAndTheMoneyIsSubtractedFromTheirBalance(){
        assertEquals(0.0,customer.getBalance());
        TOPIC.setPrice(1);
        TOPIC.publishMessage(new Message("Paid Message"));
        assertNull(customer.getLastMessage().getName());
        customer.addFunds(10);
        TOPIC.publishMessage(new Message("Paid Message"));
        assertTrue(customer.getLastMessage().getName().equals("Paid Message"));

    }

}
