import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

public class Main {
	public static void main(String[] args) throws IOException {
		Pokeberry[] berryArry = new Pokeberry[19];
		JSONObject berryNameJson = Pokeberry.queryForJson("/berry");
		
		//Querying for name speed and size and saving to PBs in the array.  
		for (int i = 0; i <= berryArry.length - 1; i++) {
			berryArry[i] = new Pokeberry();
			berryArry[i].setName((String) berryNameJson.query("/results/"+i+"/name"));
			JSONObject berrySizeJson = Pokeberry.queryForJson("/berry/" + berryArry[i].getName() + "/");
			berryArry[i].setSpeed((int) berrySizeJson.query("/growth_time"));
			berryArry[i].setSize((int) berrySizeJson.query("/size"));
		}
		
		ArrayList<Pokeberry> arrayList = new ArrayList<Pokeberry>(Arrays.asList(berryArry));
		arrayList.sort(null);
		
		//Congratulating the beareys
		Pokeberry winner = arrayList.get(0);
		Pokeberry secondPlace = arrayList.get(1);
		Pokeberry thirdPlace = arrayList.get(2);
		System.out.println(winner.getNameCapped() + " berry is the most efficient berry with an efficiency level of: " + winner.getEfficiency());
		System.out.println(secondPlace.getNameCapped() + " berry is the second most efficient berry with an efficiency level of: " + secondPlace.getEfficiency());
		System.out.println(thirdPlace.getNameCapped() + " berry is the third most efficient berry with an efficiency level of: " + thirdPlace.getEfficiency());

	}

}
