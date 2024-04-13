package com.hm.kraios.pages;

import java.util.Hashtable;
import org.openqa.selenium.By;
import com.hm.seleniumFactory.BaseTest;

public class WorkFlowPage {

	public static class ActivitiesPage {

		public static By ACTIVITIES_TAB_LOCATOR = By.xpath("//span[text()='Activities']");
		public static By SEARCHBOX_LOCATOR = By.xpath("//input[@id='searchInput']");
		public static By FIRST_ACTIVITIES_LOCATOR = By.xpath("(//table/tbody/tr/td[1]/a/div)[1]");


		public synchronized static void clickOnActivitiesTab() {
			BaseTest.seleniumWrapperManager.get().forceClick(ACTIVITIES_TAB_LOCATOR, "ACTIVITIES_TAB_LOCATOR");
		}
		
		public static boolean searchforPresenceOfActivitiesID() {
			boolean result = false;
			BaseTest.seleniumWrapperManager.get().forceClick(ActionsPage.OVERDUE_TAB_LOCATOR, "OVERDUE_TAB_LOCATOR");
			if (BaseTest.seleniumWrapperManager.get().isVisible(FIRST_ACTIVITIES_LOCATOR, "FIRST_ACTIVITIES_LOCATOR")) {
				BaseTest.seleniumWrapperManager.get().click(FIRST_ACTIVITIES_LOCATOR, "FIRST_ACTIVITIES_LOCATOR");
			} else {
				BaseTest.seleniumWrapperManager.get().click(ActionsPage.INPROGRESS_TAB_LOCATOR, "INPROGRESS_TAB_LOCATOR");
				BaseTest.seleniumWrapperManager.get().click(FIRST_ACTIVITIES_LOCATOR, "FIRST_ACTIVITIES_LOCATOR");
			}
			return result;
		}
	}

	public static class ActionsPage {

		public static By ACTIONS_TAB_LOCATOR = By.xpath("//span[text()='Actions']");
		public static By ACTIONS_DROPDOWN_LOCATOR = By.xpath("//*[text()='All Types ']/..//span[@class='down-arrow']");
		public static By COLLECT_VALUE_LOCATOR = By.xpath("//ul/li/a[text()='Collect']");
		public static By REVIEW_VALUE_LOCATOR = By.xpath("//ul/li/a[text()='Review']");

		public static By FIRST_ACTION_LOCATOR = By.xpath("//table/tbody/tr[1]/td[1]/a");
		public static By COMMENT_BOX_LOCATOR = By.xpath("//textarea[@placeholder='Type your comments here..']");
		public static By COMMENT_BOX_DISABLED_LOCATOR = By.xpath("//textarea[@placeholder='Comments Disabled']");
		public static By ATTACH_FILE_ICON_LOCATOR = By.xpath("//span[@class='icon-attach']");
		public static By ASSIGN_THREE_DOTS_ICON_LOCATOR = By.xpath("(//span[@class='icon-more'])[position()=2]");
		public static By ASSIGN_ICON_LOCATOR = By.xpath("//*[text()=' Assign ']");
		public static By NO_DATA_FOUND_LOCATOR = By.xpath("//span[text()=' No data found ']");
		public static By INPROGRESS_TAB_LOCATOR = By.xpath("//span[text()='In Progress']");
		public static By OVERDUE_TAB_LOCATOR = By.xpath("//span[text()='Overdue']");

		public static By PROCESS_TYPE_LOCATOR = By.xpath("(//div[@class='value textoverflow'])[1]");
		public static By COLLECT_ACTION_TYPE_TEXT_LOCATOR = By
				.xpath("//label[text()='Action Type']/../*[contains(text(),'Collect')]");
		public static By REVIEW_ACTION_TYPE_TEXT_LOCATOR = By
				.xpath("//label[text()='Action Type']/../*[contains(text(),'Review')]");
		public static By SAVE_BUTTON_LOCATOR = By.xpath("//button[text()=' Save ']");
		public static By SUBMIT_BUTTON_LOCATOR = By.xpath("//button[text()=' Submit ']");
		public static By COMMENTS_LOCATOR = By.xpath("//textarea[@name='comments']");
		public static By USER_NOT_ACCESS_LOCATOR = By
				.xpath("//span[text()=' You do not have permissions to manage this action ']");
		public static By REVIEW_ACTION_APPROVE_BUTTON = By.xpath("//span[text()='Approve']");
		public static By REVIEW_ACTION_APPROVE_WITH_COMMENTS_BUTTON = By
				.xpath("//span[contains(text(),'Approve with Comments')]");
		public static By REVIEW_ACTION_REJECT_BUTTON = By.xpath("//span[contains(text(),'Reject')]");
		public static By ACTION_COMMENT_CANCEL_BUTTON = By.xpath("//button[contains(text(),' Cancel')]");

		public synchronized static void clickOnActionsTab() {
			BaseTest.seleniumWrapperManager.get().click(ACTIONS_TAB_LOCATOR, "ACTIONS_TAB_LOCATOR");
		}

		public static void clickOnActionsDropdown() {
			BaseTest.seleniumWrapperManager.get().click(ACTIONS_DROPDOWN_LOCATOR, "ACTION_DROPDOWN_LOCATOR");
		}

		public static void clickOnCollectValue() {
			BaseTest.seleniumWrapperManager.get().click(COLLECT_VALUE_LOCATOR, "COLLECT_VALUE_LOCATOR");
		}

		public static void clickOnReviewValue() {
			BaseTest.seleniumWrapperManager.get().click(REVIEW_VALUE_LOCATOR, "REVIEW_VALUE_LOCATOR");
		}

		public synchronized static void clickOnFirstAction() {
			BaseTest.seleniumWrapperManager.get().click(FIRST_ACTION_LOCATOR, "FIRST_ACTION_LOCATOR");
		}

		public synchronized static void isVisibleNoDataFound() {
			BaseTest.seleniumWrapperManager.get().click(NO_DATA_FOUND_LOCATOR, "NO_DATA_FOUND_LOCATOR");
		}
		
		public static boolean searchforPresenceOfActionsID() {
			boolean result = false;
			BaseTest.seleniumWrapperManager.get().forceClick(ActionsPage.OVERDUE_TAB_LOCATOR, "OVERDUE_TAB_LOCATOR");
			if (BaseTest.seleniumWrapperManager.get().isVisible(FIRST_ACTION_LOCATOR, "FIRST_ACTION_LOCATOR")) {
				BaseTest.seleniumWrapperManager.get().click(FIRST_ACTION_LOCATOR, "FIRST_ACTION_LOCATOR");
			} else {
				BaseTest.seleniumWrapperManager.get().click(ActionsPage.INPROGRESS_TAB_LOCATOR, "INPROGRESS_TAB_LOCATOR");
				BaseTest.seleniumWrapperManager.get().click(FIRST_ACTION_LOCATOR, "FIRST_ACTION_LOCATOR");
			}
			return result;
		}

	}

	public static class RequestsPage {

		public static By REQUESTS_TAB_LOCATOR = By.xpath("//span[text()='Requests']");
		public static By ALL_REQUEST_DROPDOWN_LOCATOR = By.xpath("//span[text()='All Requests']");
		public static By SERVICE_REQUEST_LOCATOR = By.xpath("//A[text()='Service']");
		public static By SUPPORT_REQUEST_LOCATOR = By.xpath("//A[text()='Support']");
		public static By CREATE_NEW_REQUEST_LOCATOR = By.xpath("//span[text()='Create New Request']");
		public static By ENTITY_NAME_DROPDOWN = By
				.xpath("//ng-multiselect-dropdown/div/div[1]/span//span[@class='dropdown-down'][1]");
		public static By ENTITY_NAME_SEARCHBOX = By.xpath("(//input[@placeholder='Type for suggestions...'])");
		public static By ENTITY_NAME = By.xpath("//label[text()='Select Entity ']");
		public static By SERVICE_REQUEST_TITLE = By.xpath("(//input[@type='text'])[3]");
		public static By SUPPORT_REQUEST_TITLE = By.xpath("(//input[@type='text'])[2]");
		public static By REQUEST_DISCRIPTION = By.xpath("//textarea");
		public static By NEW_REQUEST_SAVE_BUTTON = By.xpath("//span[text()='Save']");
		public static By NEW_REQUEST_SUBMIT_BUTTON = By.xpath("//span[text()='Submit']");
		public static By NEW_REQUEST_KRAIOS_SUPPORT_LOCATOR = By
				.xpath("//div//div//div[contains(text(),'KRAIOS Support')]");
		public static By NEW_REQUEST_PAGE_CLOSE_BUTTON = By.xpath("//span[@class='icon-close']");

		public synchronized static void clickOnRequestsTab() {
			BaseTest.seleniumWrapperManager.get().click(REQUESTS_TAB_LOCATOR, "REQUESTS_TAB_LOCATOR");
		}

		public static class CreateNewRequest {

			public static void clickOnCreateNewRequest() {
				BaseTest.seleniumWrapperManager.get().click(CREATE_NEW_REQUEST_LOCATOR, "CREATE_NEW_REQUEST_LOCATOR");
			}

			public static void clickOnServiceLine(Hashtable<String, Object> data) {
				BaseTest.seleniumWrapperManager.get().forceClick(serviceLine(data), "SERVICELINE");
			}

			public static boolean isVisibleServiceLine(Hashtable<String, Object> data) {
				return BaseTest.seleniumWrapperManager.get().isVisible(serviceLine(data), "SERVICELINE");
			}

			public static void clickOnSelectEntityNameDropdown() {
				BaseTest.seleniumWrapperManager.get().click(ENTITY_NAME_DROPDOWN, "ENTITY_NAME_DROPDOWN");
			}

			public static void clickOnEntityNameTitle() {
				BaseTest.seleniumWrapperManager.get().click(ENTITY_NAME, "ENTITY_NAME");
			}

			public static boolean clickOnSelectEntityNameCheckbox(Hashtable<String, Object> data) {
				return BaseTest.seleniumWrapperManager.get().isVisible(entityNameCheckbox(data), "ENTITY_NAME_CHECKBOX");
			}

			public static void EnterServiceRequestsTitle() {
				BaseTest.seleniumWrapperManager.get().enterText(SERVICE_REQUEST_TITLE, "ACL Testing", "SERVICE_REQUEST_TITLE");
			}

			public static void EnterSupportRequestsTitle() {
				BaseTest.seleniumWrapperManager.get().enterText(SUPPORT_REQUEST_TITLE, "ACL Testing", "SUPPORT_REQUEST_TITLE");
			}

			public static void EnterRequestsDescription() {
				BaseTest.seleniumWrapperManager.get().enterText(REQUEST_DISCRIPTION, "TicketDiscription", "REQUEST_DISCRIPTION");
			}

			public static void clickOnNewRequestSaveButton() {
				BaseTest.seleniumWrapperManager.get().click(NEW_REQUEST_SAVE_BUTTON, "NEW_REQUEST_SAVE_BUTTON");
			}

			public static void clickOnNewRequestSubmitButton() {
				BaseTest.seleniumWrapperManager.get().click(NEW_REQUEST_SUBMIT_BUTTON, "NEW_REQUEST_SUBMIT_BUTTON");
			}

			public static void clickOnNewRequestKraiosSupport() {
				BaseTest.seleniumWrapperManager.get().forceClick(NEW_REQUEST_KRAIOS_SUPPORT_LOCATOR, "NEW_REQUEST_KRAIOS_SUPPORT_LOCATOR");
			}

			public static boolean isVisibleNewRequestKraiosSupport() {
				return BaseTest.seleniumWrapperManager.get().isVisible(NEW_REQUEST_KRAIOS_SUPPORT_LOCATOR,
						"NEW_REQUEST_KRAIOS_SUPPORT_LOCATOR");
			}

			public static void clickOnNewRequestPageClose() {
				BaseTest.seleniumWrapperManager.get().click(NEW_REQUEST_PAGE_CLOSE_BUTTON, "NEW_REQUEST_PAGE_CLOSE_BUTTON");
			}

		}

		public static class RequestTypeDropdown {

			public static void clickOnDropdown() {
				BaseTest.seleniumWrapperManager.get().click(ALL_REQUEST_DROPDOWN_LOCATOR, "ALL_REQUEST_DROPDOWN_LOCATOR");
			}

			public static void clickOnServiceRequestsValue() {
				BaseTest.seleniumWrapperManager.get().click(SERVICE_REQUEST_LOCATOR, "SERVICE_REQUEST_LOCATOR");
			}

			public static void clickOnSupportRequestsValue() {
				BaseTest.seleniumWrapperManager.get().click(SUPPORT_REQUEST_LOCATOR, "SUPPORT_REQUEST_LOCATOR");
			}

		}

		public static By searchOtherRequestID(Hashtable<String, Object> data) {
			By search_Other_Request_ID = By.xpath(
					"//*/tr/td[position()=7 and not(contains(text(),'" + data.get("EmailID") + "'))]//..//td[1]/a");
			return search_Other_Request_ID;
		}

		public static By searchOwnRequestID(Hashtable<String, Object> data) {
			By search_Own_Request_ID = By
					.xpath("//*/tr/td[position()=7 and (contains(text(),'" + data.get("EmailID") + "'))]//..//td[1]/a");
			return search_Own_Request_ID;
		}

		public static By otherEmailID(Hashtable<String, Object> data) {
			By OHTER_MAIL_ID = By.xpath("//div[not(contains(text(),'" + data.get("EmailID") + "'))]");
			return OHTER_MAIL_ID;
		}

		public static By ownEmailID(Hashtable<String, Object> data) {
			By OWN_MAIL_ID = By.xpath("//div[(contains(text(),'" + data.get("EmailID") + "'))]");
			return OWN_MAIL_ID;
		}

		public static By serviceLine(Hashtable<String, Object> data) {
			By SERVICE_LINE = By.xpath("//div[contains(text(),'" + data.get("ServiceLine") + "')]");
			return SERVICE_LINE;
		}

		public static By entityName(Hashtable<String, Object> data) {
			By ENTITY_NAME = By.xpath("(//ng-multiselect-dropdown/*//div[contains(text(),'"
					+ (data.get("EntityName").toString().split("\\|"))[0] + "')]/../input)[1]");
			return ENTITY_NAME;
		}

		public static By entityNameCheckbox(Hashtable<String, Object> data) {
			By ENTITY_NAME_CHECKBOX = By
					.xpath("(//div[text()='" + (data.get("EntityName").toString().split("\\|"))[0] + "'])[1]");
			return ENTITY_NAME_CHECKBOX;
		}

		public static void clickOnSearchedOtherRequestID(Hashtable<String, Object> data) {
			BaseTest.seleniumWrapperManager.get().click(searchOtherRequestID(data), "SEARCH_OTHER_REQUEST");
		}

		public static void clickOnSearchedOwnRequestID(Hashtable<String, Object> data) {
			BaseTest.seleniumWrapperManager.get().click(searchOwnRequestID(data), "SEARCH_OWN_REQUEST");
		}

		public static boolean searchforPresenceOfotherRequestID(Hashtable<String, Object> data) {
			boolean result = false;
			BaseTest.seleniumWrapperManager.get().click(ActionsPage.INPROGRESS_TAB_LOCATOR, "INPROGRESS_TAB_LOCATOR");
			if (BaseTest.seleniumWrapperManager.get().isVisible(searchOtherRequestID(data), "SEARCH_OTHER_REQUEST_ID")) {
				result = BaseTest.seleniumWrapperManager.get().isVisible(searchOtherRequestID(data), "SEARCH_OTHER_REQUEST_ID");
			} else {
				BaseTest.seleniumWrapperManager.get().click(ActionsPage.OVERDUE_TAB_LOCATOR, "OVERDUE_TAB_LOCATOR");
				result = BaseTest.seleniumWrapperManager.get().isVisible(searchOtherRequestID(data), "SEARCH_OTHER_REQUEST_ID");
			}
			return result;
		}

		public static boolean searchforPresenceOfownRequestID(Hashtable<String, Object> data) {
			boolean result = false;
			BaseTest.seleniumWrapperManager.get().enterText(ActivitiesPage.SEARCHBOX_LOCATOR, data.get("EmailID").toString() , "SEARCHBOX_LOCATOR");
			BaseTest.seleniumWrapperManager.get().click(ActionsPage.INPROGRESS_TAB_LOCATOR, "INPROGRESS_TAB_LOCATOR");
			if (BaseTest.seleniumWrapperManager.get().isVisible(searchOwnRequestID(data), "SEARCH_OWN_REQUEST_ID")) {
				result = BaseTest.seleniumWrapperManager.get().isVisible(searchOwnRequestID(data), "SEARCH_OWN_REQUEST_ID");
			} else {
				BaseTest.seleniumWrapperManager.get().click(ActionsPage.OVERDUE_TAB_LOCATOR, "OVERDUE_TAB_LOCATOR");
				result = BaseTest.seleniumWrapperManager.get().isVisible(searchOwnRequestID(data), "SEARCH_OWN_REQUEST_ID");
			}

			return result;
		}

	}

	public static class GlobalFilter {

		public static By GLOBAL_FILTER_LOCATOR = By.xpath("//span[contains(@class,'icon-filter')]");
		public static By GLOBAL_FILTER_CLOSE_LOCATOR = By.xpath("//span[@class='icon-close']");
		public static By SELECT_ENTITY_DROPDOWN_LOCATOR = By.xpath("//span[text()='Select Entity']");
		public static By SELECT_ENTITY_CHECKBOX_LOCATOR = By
				.xpath("//div[3]/ng-multiselect-dropdown/div/div[2]/ul[2]/li/div");
		public static By SELECT_ACTIVITY_DROPDOWN_LOCATOR = By.xpath("(//span[@class='dropdown-down'])[3]");
		public static By SELECT_ACTIVITY_CHECKBOX_LOCATOR = By
				.xpath("//div[4]/ng-multiselect-dropdown/div/div[2]/ul[2]/li/div");
		public static By SELECT_ENTITY_SEARCHBOX_LOCATOR = By.xpath("(//input[@placeholder='Search'])[3]");
		public static By SELECT_ACTIVITY_SEARCHBOX_LOCATOR = By.xpath("(//input[@placeholder='Search'])[4]");

		public static void clickOnFilter() {
			BaseTest.seleniumWrapperManager.get().click(GLOBAL_FILTER_LOCATOR, "GLOBAL_FILTER_LOCATOR");
		}

		public static void clickOnGlobalFilterclose() {
			BaseTest.seleniumWrapperManager.get().click(GLOBAL_FILTER_CLOSE_LOCATOR, "GLOBAL_FILTER_CLOSE_LOCATOR");
		}

		public static void clickOnSelectEntityDropdown() {
			BaseTest.seleniumWrapperManager.get().click(SELECT_ENTITY_DROPDOWN_LOCATOR, "SELECT_ENTITY_DROPDOWN_LOCATOR");
		}

		public static void clickOnSelectEntitySearchbox() {
			BaseTest.seleniumWrapperManager.get().click(SELECT_ENTITY_SEARCHBOX_LOCATOR, "SELECT_ENTITY_SEARCHBOX_LOCATOR");
		}

		public static void EnterEntityNameInSelectEntitySearchbox(Hashtable<String, Object> data) {
			BaseTest.seleniumWrapperManager.get().enterText(SELECT_ENTITY_SEARCHBOX_LOCATOR,
					(data.get("EntityName").toString().split("\\|"))[0], "SELECT_ENTITY_SEARCHBOX_LOCATOR");
		}

		public static void clickOnSelectEntityCheckbox() {
			BaseTest.seleniumWrapperManager.get().click(SELECT_ENTITY_CHECKBOX_LOCATOR, "SELECT_ENTITY_CHECKBOX_LOCATOR");
		}

		public static void clickOnSelectActivityDropdown() {
			BaseTest.seleniumWrapperManager.get().click(SELECT_ACTIVITY_DROPDOWN_LOCATOR, "SELECT_ACTIVITY_DROPDOWN_LOCATOR");
		}

		public static void clickOnSelectActivitySearchbox() {
			BaseTest.seleniumWrapperManager.get().click(SELECT_ACTIVITY_SEARCHBOX_LOCATOR, "SELECT_ACTIVITY_SEARCHBOX_LOCATOR");
		}

		public static void EnterActivityNameInSelectActivitySearchbox(Hashtable<String, Object> data) {
			BaseTest.seleniumWrapperManager.get().enterText(SELECT_ACTIVITY_SEARCHBOX_LOCATOR,
					(data.get("L2Servicename").toString().split("\\|"))[0], "SELECT_ACTIVITY_SEARCHBOX_LOCATOR");
		}

		public static void clickOnSelectActivityCheckboxbox() {

			BaseTest.seleniumWrapperManager.get().click(SELECT_ACTIVITY_CHECKBOX_LOCATOR, "SELECT_ACTIVITY_DROPDOWN_CHECKBOX_LOCATOR");
		}

		public synchronized static void applyEntityAndServiceLineFilterData(Hashtable<String, Object> data) {
			WorkFlowPage.GlobalFilter.clickOnFilter();
			WorkFlowPage.GlobalFilter.clickOnSelectEntityDropdown();
			WorkFlowPage.GlobalFilter.clickOnSelectEntitySearchbox();
			WorkFlowPage.GlobalFilter.EnterEntityNameInSelectEntitySearchbox(data);
			WorkFlowPage.GlobalFilter.clickOnSelectEntityCheckbox();
			WorkFlowPage.GlobalFilter.clickOnSelectActivityDropdown();
			WorkFlowPage.GlobalFilter.clickOnSelectActivitySearchbox();
			WorkFlowPage.GlobalFilter.EnterActivityNameInSelectActivitySearchbox(data);
			WorkFlowPage.GlobalFilter.clickOnSelectActivityCheckboxbox();
		}

		public synchronized static void applyEntityFilterData(Hashtable<String, Object> data) {
			WorkFlowPage.GlobalFilter.clickOnFilter();
			WorkFlowPage.GlobalFilter.clickOnSelectEntityDropdown();
			WorkFlowPage.GlobalFilter.clickOnSelectEntitySearchbox();
			WorkFlowPage.GlobalFilter.EnterEntityNameInSelectEntitySearchbox(data);
			WorkFlowPage.GlobalFilter.clickOnSelectEntityCheckbox();
		}
	}

	public static class Export {

		public static By EXPORT_THREE_DOTS_ICON_LOCATOR = By.xpath("//app-export/div/div/span");
		public static By EXPORT_ICON_LOCATOR = By.xpath("//a[text()='Export']");

		public static void clickOnExportThreeDots() {
			BaseTest.seleniumWrapperManager.get().click(EXPORT_THREE_DOTS_ICON_LOCATOR, "EXPORT_THREE_DOTS_ICON_LOCATOR");
		}

		public synchronized static boolean verifyIsUserHavingAccesToExport() {
			boolean result = false;

			BaseTest.seleniumWrapperManager.get().click(EXPORT_THREE_DOTS_ICON_LOCATOR, "EXPORT_THREE_DOTS_ICON_LOCATOR");
			if (BaseTest.seleniumWrapperManager.get().isVisible(EXPORT_ICON_LOCATOR, "EXPORT_ICON_LOCATOR")) {
			}
			result = true;

			return result;
		}

	}

}
