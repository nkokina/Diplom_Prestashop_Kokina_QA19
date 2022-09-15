# **Diplom_Prestashop_Kokina_QA19**
The site was tested in this project http://prestashop.qatestlab.com.ua/ru/
This is an online clothing store

## **Clone the repository into your projects directory:**
https://github.com/nkokina/Diplom_Prestashop_Kokina_QA19.git

## **Installation:**
*	IDE: IntelliJ
*	Programming Language: JAVA
*	Project Type: Maven

## **Frameworks:**
*	Selenium
*	TestNG
*	lombok
*	Test listener
*	Faker

## **Design Patterns used:**
*	POM (Page Object Module)

## **Reporting:**
*	Allure reporting

## **Global Usage:**
*	GitHub

## **Project structure:**

**pages**
*	BasePage
*	ItemDetailsPage
*	BasketPage
*	HomePage
*	LoginPage
*	ProductsPage
*	SearchPage
*	WomenPage
*	MyAccountPage
*	AuthrnticationPage
*	*Modals*
*      - BaseModal
*      - NewAuthenticationModal
*      - NewAddressesModal

**models**
*  Addresses
*  User

**enums**
* Title

**elements**
*   BaseElement
*   Input
*   Year
*   Radio
*   Select

**tests**
*	BaseTest
*	IyemDetailsTest
*	LoginTest
*	SearchTest

## **Check list**

Website "prestashop.qatestlab.com.ua"	

- **Account**			
   * Registration		                                      	
   * Authorization		                                      	
- **Catalog**			
   * Search 		                                           				
   * View product details			
- **Basket** 			
   * Adding a product		                              	
   * Product removal		                                  	
			
## **Running tests:**

*	**TestNG command for run:** - mvn clean test
*	**Running Specific Tests and Methods:** 
 -      mvn clean test -DsuiteXmlFile=’smokeTest.xml’
 -      mvn clean test -DsuiteXmlFile=’regressionTest.xml’
 -      mvn clean test -DsuiteXmlFile=’negativeTest.xml’
*	**Command to run tests from one class:**  mvn clean test -Dtest=’LoginTest’ 
*	**Command to run one test from a class:** 
mvn clean test -Dtest=’LoginTest#newUserRegistrationTest’
*	**Allure command for run:** - mvn allure:serve - mvn allure:report
*	**Jenkins**
