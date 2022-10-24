package com.hackerthon.dao;

import com.hackerthon.db.DBConnection;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudUtil {
	public static PreparedStatement getPreparedStatement(String sql, Object... data)
			throws ClassNotFoundException, SQLException, IOException { // create a method to get the prepared statement
		Connection connection = DBConnection.getInstance().getConnection();// get the connection
		PreparedStatement pstm = connection.prepareStatement(sql);// create a prepared statement
		for (int i = 0; i < data.length; i++) {// loop through the data
			pstm.setObject(i + 1, data[i]);// set the data to the prepared statement
		}
		return pstm;// return the prepared statement
	}

	public static boolean executeUpdate(String sql, Object... data)
			throws ClassNotFoundException, SQLException, IOException {
		return getPreparedStatement(sql, data).executeUpdate() > 0;// execute the update
	}

	public static ResultSet executeQuery(String sql, Object... data)
			throws ClassNotFoundException, SQLException, IOException {
		return getPreparedStatement(sql, data).executeQuery();// execute the query
	}

	public static String getEmployeeQueryById(String id)
			throws ClassNotFoundException, SQLException, ParserConfigurationException, IOException, SAXException {
		NodeList nodeList;// create a node list
		Element element = null;// create an element
		nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder()// get the document builder
				.parse(new File("src/com/hackerthon/config/EmployeeQuery.xml")).getElementsByTagName("query");
		for (int x = 0; x < nodeList.getLength(); x++) {// loop through the node list
			element = (Element) nodeList.item(x);// get the element
			if (element.getAttribute("id").equals(id))// check if the id is equal to the id passed
				break;// break the loop
		}
		return element.getTextContent().trim();// return the text content
	}
}
