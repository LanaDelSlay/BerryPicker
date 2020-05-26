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
				
		Pokeberry winner = arrayList.get(0);
		Pokeberry secondPlace = arrayList.get(1);
		Pokeberry thirdPlace = arrayList.get(2);
		
		System.out.println(winner.congratulate(1));
		System.out.println(secondPlace.congratulate(2));
		System.out.println(thirdPlace.congratulate(3));
	}

}
