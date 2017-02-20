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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typMiejscowosci == null) ? 0 : typMiejscowosci.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Miejscowosc other = (Miejscowosc) obj;
		if (typMiejscowosci != other.typMiejscowosci)
			return false;
		return true;
	}
	
}
