package locadora;

public class Rental {
	
	private static Movie _movie;

	private static int _daysRented;

	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	static double getAmount(Rental each) {
		return _movie.getAmount(each.getDaysRented());
	}

	public static int getFrequentRenterPoints(Rental each) {
		return _movie.getFrequentRenterPoints(each.getDaysRented());
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}
}