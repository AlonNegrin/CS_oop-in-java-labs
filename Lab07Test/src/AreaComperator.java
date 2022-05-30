import java.util.Comparator;

public class AreaComperator implements Comparator<City> {

    @Override
    public int compare(City city1, City city2) {
        return city1.getArea() - city2.getArea();
    }
}
