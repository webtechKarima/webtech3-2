package edu.karima.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import edu.karima.model.Product;

/**
 * Servlet implementation class ProductenServlet
 */
@WebServlet("/ProductenServlet")
public class ProductenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ArrayList<Product> productenList = getAllProducten();
		
		request.setAttribute("producten", productenList);
		RequestDispatcher view = 
				request.getRequestDispatcher("ShowProduct.jsp");
		
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

	public ArrayList<Product> getAllProducten() throws IOException {
		
		JsonReader reader = new JsonReader(
		        new InputStreamReader(new FileInputStream("/ProductenTwee/WebContent/producten.json")));
		JsonParser jsonParser = new JsonParser();
		
		JsonArray productarray= jsonParser.parse(reader).getAsJsonArray();
		
		ArrayList<Product> productList = new ArrayList<>();
		Gson gson = new Gson();
		for ( JsonElement aProduct : productarray ) {
		Product aProduct1 = gson.fromJson(aProduct, Product.class);
		productList.add(aProduct1);
		}
		
		return productList;
		
	}

}
