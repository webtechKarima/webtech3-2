package edu.karima.web;

import edu.karima.model.Product;

import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher view = 
				request.getRequestDispatcher("ShowProduct.jsp");
		
		
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		Product prod = new Product();
		
		String naam = request.getParameter("naam" );
		String producent = request.getParameter("producent" );
		Float prijs = Float.parseFloat(request.getParameter("prijs" ));
		
		prod.setNaam(naam);
		prod.setProducent(producent);
		prod.setPrijs(prijs);
		
		saveProduct(prod);
		
		
	}
	
	public void saveProduct(Product product) {
		Gson gson = new Gson();
        String json = gson.toJson(product);
        System.out.println(json);

        //2. Convert object to JSON string and save into a file directly
        try (FileWriter writer = new FileWriter("/ProductenTwee/WebContent/producten.json")) {

            gson.toJson(product, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
