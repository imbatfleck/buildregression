package com.build.dapmaster.DAPMASTER;

import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedHashSet;
import javax.mail.MessagingException;

import com.build.dapmaster.DAPMASTER.batchdetails.BatchDetails;
import com.build.dapmaster.DAPMASTER.batchgroup.DAPMaster;
import com.yodlee.buildautomation.BuildAutomation.BuildAutomationApplication;


public class DapMasterApplication{
	
	public static void main(String[] args) throws IOException, InterruptedException, MessagingException, ParseException {
			
			BuildAutomationApplication.createAuthPool();
			BuildAutomationApplication.createRouteList();
			
			DAPMaster dapMaster=new DAPMaster();
			LinkedHashSet<BatchDetails> batchList=dapMaster.getBatchDetailsInfo();
			BuildAutomationApplication.batchProcessCount=batchList.size();
			for(BatchDetails bdetails:batchList)
			{
				BuildAutomationApplication.setBatchParams(bdetails.getBatchName(), bdetails.getBatchID(), args);
				Thread.sleep(2000);
			}
		/*BuildAutomationApplication.createAuthPool();
		BuildAutomationApplication.createBatch();*/
		
		
	}
	
	

	
	
    
}
