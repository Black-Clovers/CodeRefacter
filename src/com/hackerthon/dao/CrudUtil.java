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
	private static PreparedStatement getPreparedStatement(String sql, Object... data)
			throws ClassNotFoundException, SQLException, IOException {
		Connection connection = DBConnection.getInstance().getConnection();
		PreparedStatement pstm = connection.prepareStatement(sql);
		for (int i = 0; i < data.length; i++) {
			pstm.setObject(i + 1, data[i]);
		}
		return pstm;
	}

	public static boolean executeUpdate(String sql, Object... data)
			throws ClassNotFoundException, SQLException, IOException {
		return getPreparedStatement(sql, data).executeUpdate() > 0;
	}

	public static ResultSet executeQuery(String sql, Object... data)
			throws ClassNotFoundException, SQLException, IOException {
		return getPreparedStatement(sql, data).executeQuery();
	}

	public static String getEmployeeQueryById(String id)
			throws ClassNotFoundException, SQLException, ParserConfigurationException, IOException, SAXException {
		NodeList nodeList;
		Element element = null;
		nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new File("src/com/hackerthon/utils/EmployeeQuery.xml")).getElementsByTagName("query");
		for (int x = 0; x < nodeList.getLength(); x++) {
			element = (Element) nodeList.item(x);
			if (element.getAttribute("id").equals(id))
				break;
		}
		return element.getTextContent().trim();
	}
}
