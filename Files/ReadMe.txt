Overview
This project aims to automate the Practo web application using Selenium WebDriver.
The automation process involves navigating through the Practo web application, and then to Find Doctors page, entering the required details, 
extracting the number of doctors count, applying filters, again extracting the number of doctors count and also the top 5 doctors names, 
navigating to Health & Wellness page and validating the details in it.

Libraries and Dependencies
	Maven Repository: Maven 3.12.1
	Apache POI: 5.2.3/5.2.5
	TestNG: 7.4.0
	Extent Report: 5.1.1
	Selenium WebDriver: 4.15.0
	Loggers: 2.22.0
Automation Flow
	Go to www.practo.com site.
	Click on Find Doctors button present in the navbar. 
	Verify the presence of Location textbox and Search bar.
	Search Bangalore in the Location Textbox (Remove the existing location if it is not Bangalore otherwise leave it).
	Get the places appeared in the dropdown after entering bangalore.
	Search "ent" in the search bar and select the "ear-nose-throat (ent) specialist" option.
	Get the No.of doctors available in bangalore.
	Now apply the below filters: 
		Gender - Male
		Patient Stories - 40+ Patient Stories
		Experience - 10+
		Availability - Available in next 7 days
		sort by Relevance - "Experience - High to Low"
	Get the No.of doctors and the names of top 5 doctors after applying the filters.
	Now click on "For Corporates" dropdown on top of the page and select "Health & Wellness Plans".
	In the "Health & Wellness" page fill the invalid details in the "Schedule a demo" form and check whether the "Submit" button is disabled or not.

Libraries Explanation
	Maven Repository: Used for project management and dependency resolution.
	Apache POI: Handles Excel operations for data-driven testing.
	TestNG: Facilitates test case organization and execution.
	TestNG Report: Generates comprehensive test reports.
	Selenium WebDriver: Automates browser interactions.
	Loggers: Facilitates logging for better debugging.

Screenshots
	Screenshots are captured at relevant steps for documentation and analysis.

How to Run
	Open Eclipse IDE:
		Launch Eclipse IDE on your machine.
	
	Import Project:
		Select File -> Import from the menu.
		Choose Existing Maven Projects and click Next.
		Browse to the directory where you cloned the repository and select the project.
	
	Update Maven Project:
		Right-click on the project in the Project Explorer.
		Choose Maven -> Update Project.
		Click OK to update dependencies.

	Set Up Configuration:
		Open the src/test/resources/config.properties file.
		Update any configuration parameters like browser type, URLs, etc., as needed.

	Run Test Suite:
		Locate the test suite file (testng.xml)
		Right-click on the file and choose Run As -> TestNG Suite.
	
	View Reports:
		After execution, open the test-output folder.
		Find the TestNG file (index.html) for detailed test case reports.
Reporting
	Locate Test Reports:
		After the execution, navigate to the test-output folder in the project directory.
	
	Open Extent Report:
		Inside the test-output folder, find the Extent Report HTML file named index.html.

	View Test Reports:
		Open the index.html file using any web browser. This report provides a detailed overview of test executions, including passed and failed tests, test duration, and any exceptions encountered.

	Screenshots and Logs:
		screenshots captured during test execution and relevant logs for test cases.

	Analyze Results:
		Utilize the visual representation in the TestNG Report to quickly identify test status and any issues encountered during the test run.
