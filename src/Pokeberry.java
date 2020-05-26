import java.io.IOException;
import org.json.JSONObject;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class Pokeberry implements Comparable<Pokeberry>{

	private String name;
	private int size;
	private int speed;
	private double efficiency;
	
	
	@Override
	public int compareTo(Pokeberry pb2) {
		//Highest to lowest 
		return (int) (pb2.getEfficiency() - this.getEfficiency());
	}
	
	public static JSONObject queryForJson(String path) throws IOException {
		OkHttpClient client = new OkHttpClient();
		
		Request request = new Request.Builder()
			.url("https://pokeapi.co/api/v2/" + path)
			.get()
			.build();
		
		Response response = client.newCall(request).execute();
		String json = response.body().string();
		JSONObject jsonObj = new JSONObject(json);
		return jsonObj;
	}
	
	public double getEfficiency() {
		efficiency = size / speed;
		return efficiency;
	}
	
	public void setName(String name) {

		this.name = name;
	}
	
	public String getName () {
		return this.name;
	}
	
	public String getNameCapped() {
		return this.name.substring(0, 1).toUpperCase() + name.substring(1);
	}
	
	public void  setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public String congratulate(int position) {
		String term = "";
		switch(position)
		{
			case 1:
			 	  term = "most ";
			 	  break;
			 case 2:
				  term = "second most ";
				  break;
			 case 3:
				  term = "third most ";
				  break;
		}
		return this.getNameCapped() + " berry is the " + term + "efficient berry with an efficiency level of: " + this.getEfficiency();
	}
	
	public String toString() {
		efficiency = size / speed;
		return "Berry name: " + name + ", Berry size: " + size + ", Berry speed is: " + speed + ", Efficiency level: " + efficiency + "\n";
	}

}
