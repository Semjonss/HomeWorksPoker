package poker;
import static org.junit.Assert.*;

import org.junit.Test;


public class TestCard {

	@Test(expected = IllegalArgumentException.class)
	public void negativeConstructorParameter() throws Exception {
			new Card(-1);
	}
	

	
	@Test(expected = IllegalArgumentException.class)
	public void lageConstructorParameter() throws Exception {
			new Card(-1);
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
