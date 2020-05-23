import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

public class Main {
	public static void main(String[] args) throws IOException {
		pokeberry[] berryArry = new pokeberry[19];
		JSONObject berryNameJson = pokeberry.queryForJson("/berry");
		
		//Querying for name speed and size and saving to PBs in the array.  
		for (int i = 0; i <= berryArry.length - 1; i++) {
			berryArry[i] = new pokeberry();
			berryArry[i].setName((String) berryNameJson.query("/results/"+i+"/name"));
			JSONObject berrySizeJson = pokeberry.queryForJson("/berry/" + berryArry[i].getName() + "/");
			berryArry[i].setSpeed((int) berrySizeJson.query("/growth_time"));
			berryArry[i].setSize((int) berrySizeJson.query("/size"));
		}
		
		ArrayList<pokeberry> arrayList = new ArrayList<pokeberry>(Arrays.asList(berryArry));
		arrayList.sort(null);
		
		//Congratulating the beareys
		pokeberry winner = arrayList.get(0);
		pokeberry secondPlace = arrayList.get(1);
		pokeberry thirdPlace = arrayList.get(2);
		System.out.println(winner.getNameCapped() + " berry is the most efficient berry with an efficiency level of: " + winner.getEfficiency());
		System.out.println(secondPlace.getNameCapped() + " berry is the second most efficient berry with an efficiency level of: " + secondPlace.getEfficiency());
		System.out.println(thirdPlace.getNameCapped() + " berry is the third most efficient berry with an efficiency level of: " + thirdPlace.getEfficiency());

	}

}
