package main;

public class Mod {
	private String modName;
	private String modVersion;
	private String factorioVersion;
	private String zipLocation;

	Mod(String modName, String modVersion, String factorioVersion, String zipLocation){
		this.modName = modName;
		this.modVersion = modVersion;
		this.factorioVersion = factorioVersion;
		this.zipLocation = zipLocation;
	}

	public String getZipLocation() {
		return zipLocation;
	}

	public String getFactorioVersion() {
		return factorioVersion;
	}

	public String getModVersion() {
		return modVersion;
	}

	public String getModName() {
		return modName;
	}
}
