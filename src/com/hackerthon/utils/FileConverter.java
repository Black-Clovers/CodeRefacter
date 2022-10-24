package com.hackerthon.utils;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileConverter {

	//create arraylist to store the employee details
	private static final ArrayList<Map<String, String>> employeeList = new ArrayList<Map<String, String>>();

	//create map to store the xpaths
	private static Map<String, String> map = null;

	public static void getRequestTransform()
			throws Exception { //create method to transform the xml file and throw exception
		// get EmployeeRequest.xml file
		Source employeeRequest = new StreamSource(new File("src/com/hackerthon/utils/EmployeeRequest.xml"));
		// get Employee-modified.xsl file
		Source employeeModified = new StreamSource(new File("src/com/hackerthon/utils/Employee-modified.xsl"));
		// get EmployeeResponse.xml file
		Result employeeResponse = new StreamResult(new File("src/com/hackerthon/utils/EmployeeResponse.xml"));
		// create TransformerFactory instance and transform
		TransformerFactory.newInstance().newTransformer(employeeModified).transform(employeeRequest, employeeResponse);
	}

	public static ArrayList<Map<String, String>> getXmlXPaths()
			throws Exception { //create method to get the xpaths and throw exception

		//create DocumentBuilderFactory instance and parse the xml file
		Document d = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse("src/com/hackerthon/utils/EmployeeResponse.xml");

		//create XPathFactory instance and create new XPath
		XPath xPath = XPathFactory.newInstance().newXPath();

		//pass count of string value to int
		int count = Integer.parseInt(
				(String) xPath.compile("count(//Employees/Employee)").evaluate(d, XPathConstants.STRING));

		for (int i = 1; i <= count; i++) {//iterate the count
			map = new HashMap<String, String>();//create new map
			map.put("XpathEmployeeIDKey", (String) xPath.compile("//Employees/Employee[" + i + "]/EmployeeID/text()")
					.evaluate(d, XPathConstants.STRING));//get the xpath of employee id
			map.put("XpathEmployeeNameKey",
					(String) xPath.compile("//Employees/Employee[" + i + "]/EmployeeFullName/text()")
							.evaluate(d, XPathConstants.STRING));//get the xpath of employee name
			map.put("XpathEmployeeAddressKey",
					(String) xPath.compile("//Employees/Employee[" + i + "]/EmployeeFullAddress/text()")
							.evaluate(d, XPathConstants.STRING));//get the xpath of employee address
			map.put("XpathFacultyNameKey", (String) xPath.compile("//Employees/Employee[" + i + "]/FacultyName/text()")
					.evaluate(d, XPathConstants.STRING));//get the xpath of faculty name
			map.put("XpathDepartmentKey", (String) xPath.compile("//Employees/Employee[" + i + "]/Department/text()")
					.evaluate(d, XPathConstants.STRING));//get the xpath of department
			map.put("XpathDesignationKey", (String) xPath.compile("//Employees/Employee[" + i + "]/Designation/text()")
					.evaluate(d, XPathConstants.STRING));//get the xpath of designation
			employeeList.add(map);//add the map to the arraylist
		}
		return employeeList;//return the arraylist
	}
}
