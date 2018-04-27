package rapport;

public class ScrapParProjet implements Comparable<ScrapParProjet> {
	
	private Double scrap;
    private String projet;
    
	
	public String getProjet() {
		return projet;
	}
	public void setProjet(String projet) {
		this.projet = projet;
	}
	public Double getScrap() {
		return scrap;
	}
	public void setScrap(Double scrap) {
		this.scrap = scrap;
	}
	@Override
	public int compareTo(ScrapParProjet o) {
		if(this.getScrap() < o.getScrap()) return 1;
		if(this.getScrap() > o.getScrap()) return -1;
        return 0;	
 }
    
    

}
