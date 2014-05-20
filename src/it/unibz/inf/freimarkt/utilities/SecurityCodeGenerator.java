package it.unibz.inf.freimarkt.utilities;

/**
 * This class is responsible for creating security code.
 * @author Dainius Jocas
 *
 */
public class SecurityCodeGenerator {
	/*
	 * Factory pattern
	 */
	private SecurityCodeGenerator() {}
	public static SecurityCodeGenerator newInstance() {
		return new SecurityCodeGenerator();
	}
	
	/**
	 * Generate four number security code
	 * @return
	 */
	public String generateSecurityCode() {
		// TODO(dainius): think about more clever approach for generating 
		// security codes.
		return "1234"; //String.valueOf(Math.round(Math.random() * 10000));
	}
}
