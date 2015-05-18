package poker;
import static org.junit.Assert.*;

import org.junit.Test;


public class TestCard {

	@Test
	public void negativeConstructorParameter() throws Exception {
		try {
			new Card(-1);
			fail("illigal argument");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	public void LageConstructorParameter() throws Exception {
		try {
			new Card(52);
			fail("illigal argument");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	public void rankCardInConstructor() {
		Card c1 = new Card(1);
		assertEquals(1, c1.getRank());
		Card c2 = new Card(23);
		assertEquals(10, c2.getRank());
	}
	
	@Test
	public void verticesStoredInConstructor() {
		Card c1 = new Card(1);
		assertEquals(0, c1.getSuit());
		Card c2 = new Card(23);
		assertEquals(1, c2.getSuit());
	}

}
