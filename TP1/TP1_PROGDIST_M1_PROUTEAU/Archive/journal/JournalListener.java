/*
 * JournalListener.java
 *
 * Created on 5 juillet 2007, 10:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package journal;

import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import journal.JournalPersistance;

/**
 *
 * @author lemeunie
 */
public class JournalListener implements MessageListener {
    
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {                        
            TextMessage messageText = (TextMessage) message;
            //JournalPersistance jp = new JournalPersistance();
            //jp.start();
            //jp.tracer();
            //jp.stop();
            try {
            	System.out.println("Received : "+messageText.getText());
            	 try{
            	 		//Log data in file
            		    // Create file 
            		    FileWriter fstream = new FileWriter(System.currentTimeMillis() + "log.txt");
            		        BufferedWriter out = new BufferedWriter(fstream);
            		    out.write("Heure:"+messageText.getJMSTimestamp()+"\n");
            		    out.write("Destination:"+messageText.getJMSDestination()+"\n");
            		    out.write("Login :"+messageText.getJMSCorrelationID()+"\n");
            		    out.write("Message:"+messageText.getText()+"\n");
            		    out.write("Concerne:"+messageText.getJMSReplyTo()+"\n");
            		    
            		    //Close the output stream
            		    out.close();
            		    }catch (Exception e){//Catch exception if any
            		      System.err.println("Error: " + e.getMessage());
            		    }
            }
            catch(JMSException e) {
            	
            	System.err.println("Unable to get message text"+e);
            }
            
        }
    }
    
}
