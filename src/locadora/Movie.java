package locadora;

public abstract class Movie {
	
	public static final int CHILDRENS = 2;

	public static final int REGULAR = 0;

	public static final int NEW_RELEASE = 1;

	private String _title;

	public static Movie createMovie(String title, int _priceCode){
		if(_priceCode == REGULAR)
			return new Regular(title);
		else if(_priceCode == NEW_RELEASE)
			return new NewRelease(title);
		else if (_priceCode == CHILDRENS)
			return new Children(title);
		throw new RuntimeException("Não existe essa categoria");
	}

	public Movie(String title) {
		_title = title;
	}

	public abstract int getFrequentRenterPoints(int daysRented);

	public abstract double getAmount(int daysRented) ;

	public String getTitle() {
		return _title;
	};
}