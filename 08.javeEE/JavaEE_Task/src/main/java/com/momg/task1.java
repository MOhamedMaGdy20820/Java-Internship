package com.momg;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.awt.PrintGraphics;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/task1")
public class task1 extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		PrintWriter out = res.getWriter();
		
		long Factorial=1;
		
		out.print("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<style>\r\n"
				+ "table, th, td {\r\n"
				+ "  border:1px solid black;\r\n"
				+ "}\r\n"
				+ "</style>\r\n"
				+ "<body>\r\n"
				+ "");
		
		out.print("<table>\r\n"
				+ "  <tr>\r\n"
				+ "    <th>Number</th>\r\n"
				+ "    <th>Factorial</th>\r\n"
				+ "  </tr>\n");
		
		out.print( "<tr>\r\n"
				+ "    <td>"+0+"</td>\r\n"
				+ "    <td>"+1+"</td>\r\n"
				+ "  </tr>\n"
					);
		
		
		for(long i = 1 ;i<=10;i++) {
			
		   Factorial*=i;
		   out.print( "<tr>\r\n"
					+ "    <td>"+i+"</td>\r\n"
					+ "    <td>"+Factorial+"</td>\r\n"
					+ "  </tr>\n"
						);
		}

		out.print("</table>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>");
		

	}

}
