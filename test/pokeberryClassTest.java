import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.json.JSONObject;
import org.junit.Assert.*;

import org.junit.Test;

public class pokeberryClassTest {

	pokeberry pb = new pokeberry();
	
	
	@Test
	public void testNameMutator() {
	pb.setName("blue");
	assertEquals("blue" , pb.getName());	
	}

	@SuppressWarnings("deprecation")
	@Test
	
	public void testEfficiency() {
		pb.setSize(500);
		pb.setSpeed(9);
		assertEquals(55, pb.getEfficiency(),1e-3);
	}
	@Test
	
	public void testQuery() throws IOException {
		String name = "skitty"; //ID is 300
		int baseXP = 52;
		int weight = 110;
		int height = 6;
		JSONObject testJSON = pokeberry.queryForJson("/pokemon/300");
		
		int baseXpFromJSON = (int) testJSON.query("/base_experience");
		String nameFromJSON = (String) testJSON.query("/name");
		int weightFromJSON = (int) testJSON.query("/weight");
		int heightFromJSON = (int) testJSON.query("/height");
		
		assertEquals(name, nameFromJSON);
		assertEquals(weight, weightFromJSON);
		assertEquals(baseXP, baseXpFromJSON);
		assertEquals(height, heightFromJSON);
	}
	@Test
	
	public void testSorting() {
		pokeberry myBerries = new pokeberry();
		pokeberry godBerries = new pokeberry();
		myBerries.setName("Sucky berries"); myBerries.setSize(35); myBerries.setSpeed(15);
		godBerries.setName("Dank berries"); godBerries.setSize(3500); godBerries.setSpeed(5);
		ArrayList<pokeberry> arrayList = new ArrayList<pokeberry>();
		arrayList.add(myBerries);
		arrayList.add(godBerries);
		arrayList.sort(null);
		assertEquals("Dank berries", arrayList.get(0).getName());
	}
	@Test
	
	public void testNameCapitalization() {
		pb.setName("punk");
		assertEquals("Punk", pb.getNameCapped());
	}
	
}
