package com.hm.kraios.pages;

import java.util.Hashtable;

import org.openqa.selenium.By;

import com.hm.seleniumFactory.BaseTest;


public class KraiosLogin {
		
		public synchronized static void login(Hashtable<String, Object> data) {	
			
			if(data.get("IsUserMultiClientUser").toString().equals("Y")) {
			
				BaseTest.seleniumWrapperManager.get().openWebsite(
						"https://"+data.get("XL_ENV")+"/login?" + "id_token=" + data.get("UserIdToken").toString(),
						"MultiClientLoginPage");
				
				String clientGroupXpath="//li//div[contains(text(),'"+ data.get("ClientGroup").toString()+"')]";
				
				BaseTest.seleniumWrapperManager.get().click(By.xpath(clientGroupXpath),"CLIENT_GROUP_XPATH");
				
				String proceedButton="//button[contains(text(),' Proceed ')]";
				
				BaseTest.seleniumWrapperManager.get().click(By.xpath(proceedButton),"PROCEED_BUTTON");
			}
			else if(data.get("IsUserMultiClientUser").toString().equals("N")) {
				BaseTest.seleniumWrapperManager.get().openWebsite(
						"https://"+data.get("XL_ENV")+"/login?" + "id_token=" + data.get("UserIdToken").toString(),
						"LOGIN");
			}
		}
	}
