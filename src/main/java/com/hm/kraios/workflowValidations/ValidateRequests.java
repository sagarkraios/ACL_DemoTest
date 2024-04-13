package com.hm.kraios.workflowValidations;

import java.util.Hashtable;
import com.hm.kraios.pages.EntityDetailsPage;
import com.hm.kraios.pages.KraiosMyWorkSpaceMenuPage;
import com.hm.kraios.pages.WorkFlowPage;
import com.hm.seleniumFactory.BaseTest;

public class ValidateRequests {
	
	public boolean validateRequestsExport(Hashtable<String, Object> data) throws InterruptedException {

		boolean result = false;

		if (data.get("Workflow_Menu").equals("Y")) {

			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			result = BaseTest.seleniumWrapperManager.get().isVisible(KraiosMyWorkSpaceMenuPage.WORKFLOW_LOCATOR, "WORKFLOW_LOCATOR");
			KraiosMyWorkSpaceMenuPage.navigateToWorkflowPage(data);

			if (data.get("Request_Tab").equals("Y")) {
				WorkFlowPage.RequestsPage.clickOnRequestsTab();

				if (data.get("Workflow_Request_Export_Link").equals("Y")) {

					result = WorkFlowPage.Export.verifyIsUserHavingAccesToExport();
					if (result == true) {

						BaseTest.passTest("User has access To Request Export and Validation got passed");

					} else {

						BaseTest.failTest(
								"Expected: User has access To Request Export, Actual: User  doesn't has the  access To Request Export",
								data);
					}

				} else if (data.get("Workflow_Request_Export_Link").equals("N")) {

					result = BaseTest.seleniumWrapperManager.get().isNotVisible(WorkFlowPage.Export.EXPORT_THREE_DOTS_ICON_LOCATOR,
							"EXPORT_THREE_DOTS_ICON_LOCATOR");

					if (result == true) {

						BaseTest.passTest("User shoud not have access To Request Export and Validation got passed");

					} else {

						BaseTest.failTest(
								"Expected: User shoud not have access To Request Export, Actual: User has access To Request Export",
								data);
					}
				}

			} else if (data.get("Request_Tab").equals("N")) {
				result = BaseTest.seleniumWrapperManager.get().isNotVisible(WorkFlowPage.RequestsPage.REQUESTS_TAB_LOCATOR,
						"REQUESTS_TAB_LOCATOR");
				if (result == true) {
					BaseTest.passTest("User shoud not have access To Request Tab and Validation got passed");
				} else {
					BaseTest.failTest(
							"Expected: User shoud not have access To Request Tab, Actual: User has access To Request Tab",
							data);
				}
			}
		} else if (data.get("Workflow_Menu").equals("N")) {
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			result = BaseTest.seleniumWrapperManager.get().isNotVisible(KraiosMyWorkSpaceMenuPage.WORKFLOW_LOCATOR, "WORKFLOW_LOCATOR");
			if (result == true) {
				BaseTest.passTest("User shoud not have access To Workflow Menu and Validation got passed");
			} else {
				BaseTest.failTest(
						"Expected: User shoud not have access To Workflow Menu, Actual: User has access To Workflow Menu",
						data);
			}
		}
		return result;

	}
	

	static boolean validateManageOtherServiceRequestYesAccess(Hashtable<String, Object> data) {
		boolean result = false;

		if (BaseTest.seleniumWrapperManager.get().isVisible(WorkFlowPage.RequestsPage.otherEmailID(data), "OTHER_EMAIL_ID")
				&& BaseTest.seleniumWrapperManager.get().isVisible(WorkFlowPage.ActionsPage.COMMENT_BOX_LOCATOR, "COMMENT_BOX_LOCATOR")) {
			result = true;

		}
		return result;
	}
	static boolean validateManageOtherServiceRequestNoAccess(Hashtable<String, Object> data) {
		boolean result = false;

		if (BaseTest.seleniumWrapperManager.get().isVisible(WorkFlowPage.RequestsPage.otherEmailID(data), "OTHER_EMAIL_ID")
				&& BaseTest.seleniumWrapperManager.get().isVisible(WorkFlowPage.ActionsPage.COMMENT_BOX_DISABLED_LOCATOR, "COMMENT_BOX_DISABLED_LOCATOR")) {
			result = true;

		}
		return result;
	}


	public static boolean validateViewOtherServiceRequestAccess(Hashtable<String, Object> data) {

		boolean result = false;
		WorkFlowPage.RequestsPage.RequestTypeDropdown.clickOnDropdown();
		WorkFlowPage.RequestsPage.RequestTypeDropdown.clickOnServiceRequestsValue();
		WorkFlowPage.GlobalFilter.applyEntityFilterData(data);

		if (WorkFlowPage.RequestsPage.searchforPresenceOfotherRequestID(data)) {

			WorkFlowPage.RequestsPage.clickOnSearchedOtherRequestID(data);
			result = true;
		}

		return result;
	}

	public boolean validateMyActivitiesViewManageOtherServiceRequests(Hashtable<String, Object> data)
			throws InterruptedException {

		boolean result = false;

		if (data.get("Workflow_Menu").equals("Y")) {

			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();

			result = BaseTest.seleniumWrapperManager.get().isVisible(KraiosMyWorkSpaceMenuPage.WORKFLOW_LOCATOR, "WORKFLOW_LOCATOR");
			KraiosMyWorkSpaceMenuPage.navigateToWorkflowPage(data);

			if (data.get("Request_Tab").equals("Y")) {

				WorkFlowPage.RequestsPage.clickOnRequestsTab();

				if (data.get("MyActivities_ViewOthersServiceRequests").equals("Y")) {

					if (data.get("MyActivities_ManageOthersServiceRequests").equals("Y")) {
						
						boolean viewAccess = validateViewOtherServiceRequestAccess(data);
						
						boolean manageYesAccess = validateManageOtherServiceRequestYesAccess(data);


						if (viewAccess == true && manageYesAccess == true) {

							BaseTest.passTest(
									"User has access To View and Manage Other Service Requests and Validation got passed");

						} else {

							BaseTest.failTest(
									"Expected: User has access To View and Manage Other Service Requests, Actual: User  doesn't has the  access To View and Manage Other Service Requests==> View Access: "
											+ viewAccess + " manageYesAccess: " + manageYesAccess,
									data);
						}
					} else if (data.get("MyActivities_ManageOthersServiceRequests").equals("N")) {
						
						boolean viewAccess = validateViewOtherServiceRequestAccess(data);
						
						boolean manageNoAccess = validateManageOtherServiceRequestNoAccess(data);

						if (viewAccess == true && manageNoAccess == true ) {

							BaseTest.passTest(
									"User shoud not have access To View and Manage Other Service Requests and Validation got passed");

						} else {

							BaseTest.failTest(
									"Expected: User has access To View and Manage Other Service Requests, Actual: User  doesn't has the access To View and Manage Other Service Requests==> View Access: "
											+ viewAccess + "  manageNoAccess: " + manageNoAccess,
									data);
						}}

				} else if (data.get("MyActivities_ViewOthersServiceRequests").equals("N")) {
					WorkFlowPage.RequestsPage.searchforPresenceOfotherRequestID(data);

					BaseTest.passTest(
							"Passing the validation of this Test Case , Since user is not having Acces to View Other Service Requests");
				}

			} else if (data.get("Request_Tab").equals("N")) {
				result = BaseTest.seleniumWrapperManager.get().isNotVisible(WorkFlowPage.RequestsPage.REQUESTS_TAB_LOCATOR,
						"REQUESTS_TAB_LOCATOR");
				if (result == true) {
					BaseTest.passTest("User shoud not have access To Request Tab and Validation got passed");
				} else {
					BaseTest.failTest(
							"Expected: User shoud not have access To Request Tab, Actual: User has access To Request Tab",
							data);
				}
			}
		} else if (data.get("Workflow_Menu").equals("N")) {
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			result = BaseTest.seleniumWrapperManager.get().isNotVisible(KraiosMyWorkSpaceMenuPage.WORKFLOW_LOCATOR, "WORKFLOW_LOCATOR");
			if (result == true) {
				BaseTest.passTest("User shoud not have access To Workflow Menu and Validation got passed");
			} else {
				BaseTest.failTest(
						"Expected: User shoud not have access To Workflow Menu, Actual: User has access To Workflow Menu",
						data);
			}
		}
		return result;

	}

	static boolean validateManageOtherSupportRequestYesAccess(Hashtable<String, Object> data) {
		boolean result = false;

		if (BaseTest.seleniumWrapperManager.get().isVisible(WorkFlowPage.RequestsPage.otherEmailID(data), "OTHER_EMAIL_ID")
				&& BaseTest.seleniumWrapperManager.get().isVisible(WorkFlowPage.ActionsPage.COMMENT_BOX_LOCATOR, "COMMENT_BOX_LOCATOR")) {
			result = true;

		}
		return result;
	}
	static boolean validateManageOtherSupportRequestNoAccess(Hashtable<String, Object> data) {
		boolean result = false;

		if (BaseTest.seleniumWrapperManager.get().isVisible(WorkFlowPage.RequestsPage.otherEmailID(data), "OTHER_EMAIL_ID")
				&& BaseTest.seleniumWrapperManager.get().isVisible(WorkFlowPage.ActionsPage.COMMENT_BOX_DISABLED_LOCATOR, "COMMENT_BOX_DISABLED_LOCATOR")) {
			result = true;

		}
		return result;
	}


	public static boolean validateViewOtherSupportRequestAccess(Hashtable<String, Object> data) {

		boolean result = false;
		WorkFlowPage.RequestsPage.RequestTypeDropdown.clickOnDropdown();
		WorkFlowPage.RequestsPage.RequestTypeDropdown.clickOnSupportRequestsValue();

		if (WorkFlowPage.RequestsPage.searchforPresenceOfotherRequestID(data)) {

			WorkFlowPage.RequestsPage.clickOnSearchedOtherRequestID(data);
			result = true;

		}

		return result;
	}


	public boolean validateMyActivitiesViewManageOtherSupportRequests(Hashtable<String, Object> data)
			throws InterruptedException {

		boolean result = false;

		if (data.get("Workflow_Menu").equals("Y")) {

			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			result = BaseTest.seleniumWrapperManager.get().isVisible(KraiosMyWorkSpaceMenuPage.WORKFLOW_LOCATOR, "WORKFLOW_LOCATOR");
			KraiosMyWorkSpaceMenuPage.navigateToWorkflowPage(data);

			if (data.get("Request_Tab").equals("Y")) {

				WorkFlowPage.RequestsPage.clickOnRequestsTab();

				if (data.get("MyActivities_ViewOthersSupportRequests").equals("Y")) {

					if (data.get("MyActivities_ManageOthersSupportRequests").equals("Y")) {

						boolean viewAccess = validateViewOtherSupportRequestAccess(data);

						boolean manageYesAccess = validateManageOtherSupportRequestYesAccess(data);


						if (viewAccess == true && manageYesAccess == true) {

							BaseTest.passTest(
									"User has access To View and Manage Other Support Requests and Validation got passed");

						} else {

							BaseTest.failTest(
									"Expected: User has access To View and Manage Other Support Requests, Actual: User  doesn't has the  access To View and Manage Other Support Requests==> View Access: "
											+ viewAccess + "  manageYesAccess: " + manageYesAccess,
									data);
						}
					} else if (data.get("MyActivities_ManageOthersSupportRequests").equals("N")) {

						boolean viewAccess = validateViewOtherSupportRequestAccess(data);

						boolean manageNoAccess = validateManageOtherSupportRequestNoAccess(data);

						if (viewAccess == true && manageNoAccess == true) {

							BaseTest.passTest(
									"User shoud not have access To View and Manage Other Support Requests and Validation got passed");

						} else {

							BaseTest.failTest(
									"Expected: User has access To View and Manage Other Support Requests, Actual: User  doesn't has the  access To View and Manage Other Support Requests==> View Access: "
											+ viewAccess + "  manageNoAccess: " + manageNoAccess,
									data);
						}}

				} else if (data.get("MyActivities_ViewOthersSupportRequests").equals("N")) {
					WorkFlowPage.RequestsPage.searchforPresenceOfotherRequestID(data);
					BaseTest.passTest(
							"Passing the validation of this Test Case , Since user is not having Access to View Other Support Requests");
				}

			} else if (data.get("Request_Tab").equals("N")) {
				result = BaseTest.seleniumWrapperManager.get().isNotVisible(WorkFlowPage.RequestsPage.REQUESTS_TAB_LOCATOR,
						"REQUESTS_TAB_LOCATOR");
				if (result == true) {
					BaseTest.passTest("User shoud not have access To Request Tab and Validation got passed");
				} else {
					BaseTest.failTest(
							"Expected: User shoud not have access To Request Tab, Actual: User has access To Request Tab",
							data);
				}
			}
		} else if (data.get("Workflow_Menu").equals("N")) {
			result = BaseTest.seleniumWrapperManager.get().isNotVisible(KraiosMyWorkSpaceMenuPage.WORKFLOW_LOCATOR, "WORKFLOW_LOCATOR");
			if (result == true) {
				BaseTest.passTest("User shoud not have access To Workflow Menu and Validation got passed");
			} else {
				BaseTest.failTest(
						"Expected: User shoud not have access To Workflow Menu, Actual: User has access To Workflow Menu",
						data);
			}
		}
		return result;

	}
	
	static boolean verifyIsUserHavingAccesToManageOwnRequestsYesAccess(Hashtable<String, Object> data) {
		boolean result = false;

		if (BaseTest.seleniumWrapperManager.get().isVisible(WorkFlowPage.RequestsPage.ownEmailID(data), "OWN_EMAIL_ID")
				&& BaseTest.seleniumWrapperManager.get().isVisible(WorkFlowPage.ActionsPage.COMMENT_BOX_LOCATOR, "COMMENT_BOX_LOCATOR")) {
			result = true;

		}
		return result;
	}
	static boolean verifyIsUserHavingAccesToManageOwnRequestsNoAccess(Hashtable<String, Object> data) {
		boolean result = false;

		if (BaseTest.seleniumWrapperManager.get().isVisible(WorkFlowPage.RequestsPage.ownEmailID(data), "OWN_EMAIL_ID")
				&& BaseTest.seleniumWrapperManager.get().isVisible(WorkFlowPage.ActionsPage.COMMENT_BOX_DISABLED_LOCATOR, "COMMENT_BOX_DISABLED_LOCATOR")) {
			result = true;

		}
		return result;
	}

	static boolean verifyIsUserHavingAccesToSaveAndSubmitCreateNewRequests(Hashtable<String, Object> data) {
		boolean result = false;

		if (BaseTest.seleniumWrapperManager.get().isVisible(WorkFlowPage.RequestsPage.NEW_REQUEST_SAVE_BUTTON, "NEW_REQUEST_SAVE_BUTTON")
				&& BaseTest.seleniumWrapperManager.get().isVisible(WorkFlowPage.RequestsPage.NEW_REQUEST_SUBMIT_BUTTON,
						"NEW_REQUEST_SUBMIT_BUTTON")) {
			result = true;

		}
		return result;
	}

	public static boolean validateCreateOwnServiceRequest(Hashtable<String, Object> data) {
		boolean result = false;
		WorkFlowPage.RequestsPage.CreateNewRequest.clickOnSelectEntityNameDropdown();
		boolean entityAcces = WorkFlowPage.RequestsPage.CreateNewRequest.clickOnSelectEntityNameCheckbox(data);

		boolean visibiltyOfSaveAndSubmitButton = verifyIsUserHavingAccesToSaveAndSubmitCreateNewRequests(data);

		if (entityAcces && visibiltyOfSaveAndSubmitButton) {
			result = true;
		}
		return result;

	}

	public static boolean validateViewOwnServiceRequestAccess(Hashtable<String, Object> data) {

		boolean result = false;
		WorkFlowPage.RequestsPage.RequestTypeDropdown.clickOnDropdown();
		WorkFlowPage.RequestsPage.RequestTypeDropdown.clickOnServiceRequestsValue();
		WorkFlowPage.GlobalFilter.applyEntityFilterData(data);

		if (WorkFlowPage.RequestsPage.searchforPresenceOfownRequestID(data)) {

			WorkFlowPage.RequestsPage.clickOnSearchedOwnRequestID(data);
			result = true;

		}

		return result;
	}

	public boolean validateMyActivitiesViewManageOwnServiceRequests(Hashtable<String, Object> data)
			throws InterruptedException {

		boolean result = false;

		if (data.get("Workflow_Menu").equals("Y")) {

			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			result = BaseTest.seleniumWrapperManager.get().isVisible(KraiosMyWorkSpaceMenuPage.WORKFLOW_LOCATOR, "WORKFLOW_LOCATOR");
			KraiosMyWorkSpaceMenuPage.navigateToWorkflowPage(data);

			if (data.get("Request_Tab").equals("Y")) {
				WorkFlowPage.RequestsPage.clickOnRequestsTab();

				if (data.get("Create_New_Request_Link").equals("Y")) {

					WorkFlowPage.RequestsPage.CreateNewRequest.clickOnCreateNewRequest();

					if (data.get("ServiceLine_Access_WorkflowRequest").equals("Y")) {

						WorkFlowPage.RequestsPage.CreateNewRequest.clickOnServiceLine(data);
						
						if (data.get("Entity_Access_WorkFlowRequest").equals("Y")) {

							if (data.get("MyActivities_ViewManageOwnServiceRequests").equals("Y")) {

							boolean createRequestAccess = validateCreateOwnServiceRequest(data);

							WorkFlowPage.RequestsPage.CreateNewRequest.clickOnNewRequestPageClose();

							boolean viewAccess = validateViewOwnServiceRequestAccess(data);

							boolean ManageYesAccess = verifyIsUserHavingAccesToManageOwnRequestsYesAccess(data);

							if (createRequestAccess == true && viewAccess == true && ManageYesAccess==true) {

								BaseTest.passTest(
										"User has access To View and Manage Own Service Requests and Validation got passed");

							} else {

								BaseTest.failTest(
										"Expected: User has access To View and Manage Own Service Requests, Actual: User  doesn't has the  access To View and Manage Own Service Requests==> createRequestAccess : "
												+ createRequestAccess + "  viewAccess : " + viewAccess+"  ManageYesAccess : " + ManageYesAccess,data);
							}
						} else if (data.get("MyActivities_ViewManageOwnServiceRequests").equals("N")) {

							boolean createRequestAccess = validateCreateOwnServiceRequest(data);

							WorkFlowPage.RequestsPage.CreateNewRequest.clickOnNewRequestPageClose();

							boolean viewAccess = validateViewOwnServiceRequestAccess(data);
							
							boolean ManageNoAccess = verifyIsUserHavingAccesToManageOwnRequestsNoAccess(data);


							if (createRequestAccess == true && viewAccess == true && ManageNoAccess==true) {

								BaseTest.passTest(
										"User shoud not have access To View and Manage Own Service Requests and Validation got passed");

							} else {

								BaseTest.failTest(
										"Expected: User has access To View and Manage Own Service Requests, Actual: User  doesn't has the  access To View and Manage Own Service Requests==> createRequestAccess :"
												+ createRequestAccess + "  viewAccess : " + viewAccess+"  ManageAccess : " + ManageNoAccess,data);
							}
						}
					}
						 else if (data.get("Entity_Access_WorkFlowRequest").equals("N")) {
								BaseTest.passTest(
										"Passing the validation of this Test Case , Since user is not having Access to Entity Access WorkflowRequest");
						}
						
					} else if (data.get("ServiceLine_Access_WorkflowRequest").equals("N")) {
						BaseTest.passTest(
								"Passing the validation of this Test Case , Since user is not having Access to ServiceLine Access WorkflowRequest");
					}

				} else if (data.get("Create_New_Request_Link").equals("N")) {
					BaseTest.passTest(
							"Passing the validation of this Test Case , Since user is not having Acces to Create New Request Link");
				}
			} else if (data.get("Request_Tab").equals("N")) {
				result = BaseTest.seleniumWrapperManager.get().isNotVisible(WorkFlowPage.RequestsPage.REQUESTS_TAB_LOCATOR,
						"REQUESTS_TAB_LOCATOR");
				if (result == true) {
					BaseTest.passTest("User shoud not have access To Request Tab and Validation got passed");
				} else {
					BaseTest.failTest(
							"Expected: User shoud not have access To Request Tab, Actual: User has access To Request Tab",
							data);
				}
			}
		} else if (data.get("Workflow_Menu").equals("N")) {
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			result = BaseTest.seleniumWrapperManager.get().isNotVisible(KraiosMyWorkSpaceMenuPage.WORKFLOW_LOCATOR, "WORKFLOW_LOCATOR");
			if (result == true) {
				BaseTest.passTest("User shoud not have access To Workflow Menu and Validation got passed");
			} else {
				BaseTest.failTest(
						"Expected: User shoud not have access To Workflow Menu, Actual: User has access To Workflow Menu",
						data);
			}
		}
		return result;

	}

	
	public static boolean validateCreateOwnSupportRequest(Hashtable<String, Object> data) {
		boolean result = false;
		boolean visibiltyOfSaveAndSubmitButton = verifyIsUserHavingAccesToSaveAndSubmitCreateNewRequests(data);

		if (visibiltyOfSaveAndSubmitButton) {
			result = true;
		}
		return result;

	}

	public static boolean validateViewOwnSupportRequestAccess(Hashtable<String, Object> data) {

		boolean result = false;
		WorkFlowPage.RequestsPage.RequestTypeDropdown.clickOnDropdown();
		WorkFlowPage.RequestsPage.RequestTypeDropdown.clickOnSupportRequestsValue();

		if (WorkFlowPage.RequestsPage.searchforPresenceOfownRequestID(data)) {

			WorkFlowPage.RequestsPage.clickOnSearchedOwnRequestID(data);
			result = true;
		}

		return result;
	}
	

	public boolean validateMyActivitiesViewManageOwnSupportRequests(Hashtable<String, Object> data)
			throws InterruptedException {

		boolean result = false;

		if (data.get("Workflow_Menu").equals("Y")) {

			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			result = BaseTest.seleniumWrapperManager.get().isVisible(KraiosMyWorkSpaceMenuPage.WORKFLOW_LOCATOR, "WORKFLOW_LOCATOR");
			KraiosMyWorkSpaceMenuPage.navigateToWorkflowPage(data);

			if (data.get("Request_Tab").equals("Y")) {
				WorkFlowPage.RequestsPage.clickOnRequestsTab();

				if (data.get("Create_New_Request_Link").equals("Y")) {

					WorkFlowPage.RequestsPage.CreateNewRequest.clickOnCreateNewRequest();

					if (data.get("MyActivities_ViewManageOwnSupportRequests").equals("Y")) {

						boolean createrequestaccess = validateCreateOwnSupportRequest(data);

						WorkFlowPage.RequestsPage.CreateNewRequest.clickOnNewRequestPageClose();

						boolean viewAccess = validateViewOwnSupportRequestAccess(data);
						
						boolean ManageYesAccess = verifyIsUserHavingAccesToManageOwnRequestsYesAccess(data);


						if (createrequestaccess == true && viewAccess == true && ManageYesAccess==true) {

							BaseTest.passTest(
									"User has access To View and Manage Own Support Requests and Validation got passed");

						} else {

							BaseTest.failTest(
									"Expected: User has access To View and Manage Own Support Requests, Actual: User  doesn't has the  access To View and Manage Own Support Requests==> createrequestaccess : "
											+ createrequestaccess + "  viewAccess :" + viewAccess +"  ManageYesAccess : " + ManageYesAccess,data);
						}
					} else if (data.get("MyActivities_ViewManageOwnSupportRequests").equals("N")) {

						boolean createRequestAccess = validateCreateOwnSupportRequest(data);

						WorkFlowPage.RequestsPage.CreateNewRequest.clickOnNewRequestPageClose();

						boolean viewAccess = validateViewOwnSupportRequestAccess(data);
						
						boolean ManageNoAccess = verifyIsUserHavingAccesToManageOwnRequestsNoAccess(data);

						if (createRequestAccess == true && viewAccess == true && ManageNoAccess==true) {

							BaseTest.passTest(
									"User shoud not have access To View and Manage Own Support Requests and Validation got passed");

						} else {

							BaseTest.failTest(
									"Expected: User has access To View and Manage Own Service Requests, Actual: User  doesn't has the  access To View and Manage Own Service Requests==> createRequestAccess :"
											+ createRequestAccess + "  viewAccess : " + viewAccess+"  ManageNoAccess : " + ManageNoAccess,data);
						}
					} 
				} else if (data.get("Create_New_Request_Link").equals("N")) {
					BaseTest.passTest(
							"Passing the validation of this Test Case , Since user is not having Acces to Create New Request Link");

				}

			} else if (data.get("Request_Tab").equals("N")) {
				result = BaseTest.seleniumWrapperManager.get().isNotVisible(WorkFlowPage.RequestsPage.REQUESTS_TAB_LOCATOR,
						"REQUESTS_TAB_LOCATOR");
				if (result == true) {
					BaseTest.passTest("User shoud not have access To Request Tab and Validation got passed");
				} else {
					BaseTest.failTest(
							"Expected: User shoud not have access To Request Tab, Actual: User has access To Request Tab",
							data);
				}
			}
		} else if (data.get("Workflow_Menu").equals("N")) {
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			result = BaseTest.seleniumWrapperManager.get().isNotVisible(KraiosMyWorkSpaceMenuPage.WORKFLOW_LOCATOR, "WORKFLOW_LOCATOR");
			if (result == true) {
				BaseTest.passTest("User shoud not have access To Workflow Menu and Validation got passed");
			} else {
				BaseTest.failTest(
						"Expected: User shoud not have access To Workflow Menu, Actual: User has access To Workflow Menu",
						data);
			}
		}
		return result;

	}

}