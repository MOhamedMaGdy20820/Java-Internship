package com.momg;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/task2")
public class task2  extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        
        String dobStr = req.getParameter("dob");
        String currentDateStr = req.getParameter("currentDate");


        LocalDate dob = LocalDate.parse(dobStr);
        LocalDate currentDate = LocalDate.parse(currentDateStr);

        Period period = Period.between(dob, currentDate);
        long totalDays = ChronoUnit.DAYS.between(dob, currentDate);
        long totalHours = ChronoUnit.HOURS.between(dob.atStartOfDay(), currentDate.atStartOfDay());
        long totalMinutes = ChronoUnit.MINUTES.between(dob.atStartOfDay(), currentDate.atStartOfDay());
        long totalSeconds = ChronoUnit.SECONDS.between(dob.atStartOfDay(), currentDate.atStartOfDay());

        out.println("<html><body>");
        out.println("<h3>Result</h3>");
        out.println("<p>Age: " + period.getYears() + " years, " + period.getMonths() + " months, " + period.getDays() + " days</p>");
        out.println("<p>or " + totalDays + " days</p>");
        out.println("<p>or " + totalHours + " hours</p>");
        out.println("<p>or " + totalMinutes + " minutes</p>");
        out.println("<p>or " + totalSeconds + " seconds</p>");
        out.println("</body></html>");

	}

}
