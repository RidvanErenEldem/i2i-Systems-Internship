package main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.tempuri.Calculator;


/**
 * Servlet implementation class Index
 */
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger  = LogManager.getLogger(Index.class);

    /**
     * Default constructor. 
     */
    public Index() {
    	// Empty
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			String deafultResult = "Sonuç => ";
			logger.debug("doGet Started\r\n");
			logger.info(response.getStatus()+"\r\n");
			logger.info(request.getParameterNames());
			request.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			int op = Integer.parseInt(request.getParameter("operation"));
			int number1 = Integer.parseInt(request.getParameter("number1"));
			int number2 = Integer.parseInt(request.getParameter("number2"));
			logger.info(op + ", "+ number1 +", " + number2);
			Calculator calc = new Calculator();
			if(op == 0)
				out.println(deafultResult+ calc.getCalculatorSoap12().add(number1, number2));
			else if(op == 1)
				out.println(deafultResult+ calc.getCalculatorSoap12().subtract(number1, number2));
			else if(op == 2)
				out.println(deafultResult+ calc.getCalculatorSoap12().multiply(number1, number2));
			else if(op == 3)
			{
				if(number2 == 0)
				{
					out.println("Tanýmsýzdýr !!");
					return;
				}
				else if(number2 > number1)
					out.println(deafultResult+ calc.getCalculatorSoap12().divide(number2, number1));
				else
					out.println(deafultResult+ calc.getCalculatorSoap12().divide(number1, number2));
			}
			else
			{
				out.println("Hatalý Ýþlem");
				return;
			}
			logger.info("doGet Ended");
		} catch (Exception e) {
			logger.error(e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}*/

}
