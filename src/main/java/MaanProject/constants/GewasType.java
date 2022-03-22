package MaanProject.constants;

public enum GewasType implements GenericType
{
	TOMAAT(false), KOMKOMMER(false), RADIJS(false), SLA(false), PAPRIKA(false), CANNABIS(true), MAANZAAD(true);

	private final boolean isOpiaat;

	GewasType(boolean isOpiaat)
	{
		this.isOpiaat = isOpiaat;
	}

	public boolean isOpiaat()
	{
		return isOpiaat;
	}
}

