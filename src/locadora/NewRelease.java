package locadora;

public class NewRelease extends Movie{

    public NewRelease(String title) {
        super(title);
    }

    @Override
    public double getAmount(int daysRented) {
        double thisAmount = 0;
        thisAmount += daysRented* 3;
        return thisAmount;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        if(daysRented > 1)
            return 2;
        return 1;
    }
}
