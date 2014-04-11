package items;

/**
 * Factory class.
 * @author Dainius Jocas
 *
 */
public class ItemFactory {

	public static IItem createUser() {
		return PassiveMember.getInstance();
	}
}
