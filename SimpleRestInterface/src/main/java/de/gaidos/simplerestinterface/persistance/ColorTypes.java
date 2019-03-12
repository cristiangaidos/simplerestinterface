package de.gaidos.simplerestinterface.persistance;

public enum ColorTypes {
	
	NOT_DEFINED(0),
	BLAU(1),
	GRUN(2),
	LILA(3),
	ROT(4),
	ZITRONGELB(5),
	TURKIS(6),
	WEISS(7);
	
	private final int colorCode;
	
	ColorTypes(int colorCode) {
		this.colorCode = colorCode;
	}
	
	public int getColorCode() {
        return this.colorCode;
    }
	
	public static ColorTypes getColorByCode(int colorCode) {
		for(ColorTypes type : ColorTypes.values()) {
			if(type.getColorCode() == colorCode) {
				return type;
			}
		}
		return NOT_DEFINED;
	}

}
