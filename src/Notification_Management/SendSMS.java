package Notification_Management;

import com.clockworksms.ClockWorkSmsService;
import com.clockworksms.ClockworkException;
import com.clockworksms.ClockworkSmsResult;
import com.clockworksms.SMS;

public class SendSMS {
	public static String sendSms( String sendTo,String text)
	{
		try
	      {
	         ClockWorkSmsService clockWorkSmsService = new ClockWorkSmsService("0b82eb171f04e597aa92c339464e0c4a72ff9bbf");
	       //  ClockWorkSmsService clockWorkSmsService = new ClockWorkSmsService("ebebb8a6d181984f35b50ab3e7de92618bcb2108");

			SMS sms = new SMS(sendTo, text);
	         ClockworkSmsResult result = clockWorkSmsService.send(sms);

	         if(result.isSuccess())
	         {
	            System.out.println("Sent with ID: " + result.getId());
	            return "Done"	;
	         }
	         else
	         {
	            System.out.println("Error: " + result.getErrorMessage());
	         }
	      }
	      catch (ClockworkException e)
	      {
	         e.printStackTrace();
	         System.out.println(e.toString());
	      }

	return "Done dear"	;
		
	}
	
	
}
