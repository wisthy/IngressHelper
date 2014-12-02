package models;

/**
 * enum representing an Ingress team. It cannot be grey
 * @author wisthler
 *
 */
public enum ETeam {
	BLUE(EExtendedTeam.BLUE),
	GREEN(EExtendedTeam.GREEN);
	
	final EExtendedTeam value;

	/**
	 * @param value
	 */
	private ETeam(EExtendedTeam value) {
		this.value = value;
	}
}