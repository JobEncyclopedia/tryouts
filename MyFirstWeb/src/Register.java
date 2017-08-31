import java.io.*;
import java.sql.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class Register extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
//		Map parameterMap =  request.getParameterMap();
		Enumeration parameterNames = request.getParameterNames();
		try {
			MongoClientURI uri = new MongoClientURI(
					   "mongodb://Admin:1JokesAcTs@yonmetier-shard-00-00-xgibl.mongodb.net:27017,yonmetier-shard-00-01-xgibl.mongodb.net:27017,yonmetier-shard-00-02-xgibl.mongodb.net:27017/SampleDatabase?ssl=true&replicaSet=YonMetier-shard-0&authSource=admin");

					MongoClient mongoClient = new MongoClient(uri);
					String test = mongoClient.listDatabaseNames().first();
					MongoDatabase database = mongoClient.getDatabase("SampleDatabase");
					MongoCollection<Document> collection = database.getCollection("SampleCollection");
					out.print("Thanks for the submission" + "\n");
					Document insertJSON = new Document();
					while(parameterNames.hasMoreElements())
					{
						String key = (String) parameterNames.nextElement();
						insertJSON.put(key, request.getParameter(key));
					}
					collection.insertOne(insertJSON);
		} catch (Exception e2) {
			System.out.println(e2);
		}

		out.close();
	}

}
