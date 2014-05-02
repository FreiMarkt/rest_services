package it.unibz.inf.freimarkt.entities;

/**
 * Factory class.
 * @author Dainius Jocas
 *
 */
public class ItemFactory {

	public static IItem createUser() {
		return Member.getInstance();
	}
}
