package com.build.dapmaster.DAPMASTER;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.build.dapmaster.DAPMASTER.batchcreateiondetails.BatchCreationDetails;
import com.build.dapmaster.DAPMASTER.batchcreateiondetails.Items;
import com.build.dapmaster.DAPMASTER.batchdetails.BatchDetails;
import com.build.dapmaster.DAPMASTER.batchgroup.DAPMaster;
import com.yodlee.buildautomation.BuildAutomation.BuildAutomationApplication;
import com.yodlee.buildautomation.BuildAutomation.controller.BuildOperation;
import com.yodlee.buildautomation.BuildAutomation.serverurl.URLFactory;
import com.yodlee.buildautomation.BuildAutomation.utilities.Utility;

@SpringBootApplication
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
		
		
	}
	
	

	
	
    
}
