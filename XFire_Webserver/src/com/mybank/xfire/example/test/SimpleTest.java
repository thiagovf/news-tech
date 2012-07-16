package com.mybank.xfire.example.test;

import java.net.MalformedURLException;
import org.apache.log4j.Logger;

import org.codehaus.xfire.XFire;
import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;

import com.mybank.xfire.example.IBankingService;

public class SimpleTest {
	
	static Logger log = Logger.getLogger(SimpleTest.class);
	
	public static void main(String[] args) throws MalformedURLException, Exception {
		System.out.println(callWebService("teste1", "teste2", 2500, "R$"));
	}
	
	/* Call the Web service
    *
    */
    public static String callWebService(
        String fromAccount, String toAccount, double amount, String currency) 
        throws MalformedURLException, Exception {
        
        //Create a metadata of the service      
        Service serviceModel = new ObjectServiceFactory().create(IBankingService.class);        
        log.debug("callSoapServiceLocal(): got service model." );
   
        //Create a proxy for the deployed service
        XFire xfire = XFireFactory.newInstance().getXFire();
        XFireProxyFactory factory = new XFireProxyFactory(xfire);      
    
        String serviceUrl = "http://localhost:8080/XFire_Webserver/services/Banking";
        
        IBankingService client = null;
        try {
            client = (IBankingService) factory.create(serviceModel, serviceUrl);
        } catch (MalformedURLException e) {
            log.error("WsClient.callWebService(): EXCEPTION: " + e.toString());
        }    
               
        //Invoke the service
        String serviceResponse = "";
        try { 
            serviceResponse = client.transferFunds(fromAccount, toAccount, amount, currency);
       } catch (Exception e){
            log.error("WsClient.callWebService(): EXCEPTION: " + e.toString());                 
            serviceResponse = e.toString();
        }        
        log.debug("WsClient.callWebService(): status=" + serviceResponse);            
  

        //Return the response
        return serviceResponse;
    } 
}
