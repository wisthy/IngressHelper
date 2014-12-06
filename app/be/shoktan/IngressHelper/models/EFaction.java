package be.shoktan.IngressHelper.models;

/**
 * enum representing an Ingress team. It cannot be grey
 * @author wisthler
 *
 */
public enum EFaction {
	BLUE(EExtendedFaction.BLUE),
	GREEN(EExtendedFaction.GREEN);
	
	final EExtendedFaction value;

	/**
	 * @param value
	 */
	private EFaction(EExtendedFaction value) {
		this.value = value;
	}
}