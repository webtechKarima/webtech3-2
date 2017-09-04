import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

import edu.karima.model.*;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Product prod1 = new Product();
		
		prod1.setNaam("appels" );
		prod1.setProducent(" boer");
		prod1.setPrijs(2);
		Gson gson = new Gson();
        String json = gson.toJson(prod1);
        
        System.out.println(json);

        gson.toJson(json, new FileWriter("/ProductenTwee/WebContent/producten.json"));
		
	}

}
