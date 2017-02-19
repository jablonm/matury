package twu;

public class Miejscowosc {

	public enum TypMiejscowosci {
		A("Miasto"),
		B("Średnie miasto"),
		C("Wieś"),
		D("Mała wieś");
	
		private String typ;
		
		TypMiejscowosci(String typ) {
			this.typ = typ;
		}
		
		public String getTypMiejscowosci() {
			return typ;
		}	
	}
	
	private TypMiejscowosci typMiejscowosci;
	
	public TypMiejscowosci getTypMiejscowosci() {
		return typMiejscowosci;
	}
	public void setTypMiejscowosci(TypMiejscowosci typMiejscowosci) {
		this.typMiejscowosci = typMiejscowosci;
	}
	
	public Miejscowosc(TypMiejscowosci typMiejscowosci) {
		this.setTypMiejscowosci(typMiejscowosci);
	}
	
}
