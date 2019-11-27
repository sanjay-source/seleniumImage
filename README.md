# seleniumImage
Hi there! Welcome to my Git profile. :)
Following repository has been created by me to show case my skills around automation Testing.

I have incorporated TestNG, Cucumber, Java, Maven, Extent Reports, Log4j with test data driven from excel sheet using Apache POI.

Notes: 

src Folder- 1) src/test/java folder contains

                                1) feature: which contains feature file (Note: single feature file has been added to demonstrate cucumber operation
                                          more test cases will be added in the future)
																					
                                2) Selenium: this folder contains actual test cases which has used testNG as framework (not cucumber)
																
                                3) stepDefinitions: this folder contains stepdefintions file for our features.
while       2) src/main/java contains 
		 
                                1) resources folder -which contains 1.1 ExtendReportsNG: for report generation
                                                                    1.2 suiteListeners: for test case failure screenshots
                                                                    1.3 TestRunner: contains cucumberoptions for cucumber test cases
                                                                    1.4 Utilities: common global methods.
                                                                    1.5 chromdriver: to execute Test cases.
                                                                    1.6 datsheet: this stores all the test data used.
                                                                    
                                2) pageObject- which contians all the WebElement used in the framework                                    
                                
                                3) commonUtilitiesMethods: which contains reusable methods for various operations like checkbox, drop downs, web tables
                                                           etc.
																													 
/logs/ folder - contains 

                               1) screenshot for failed test cases, Log4j and log file generated from the framework
																
					
						                                                          
                                                           
                                                                    
