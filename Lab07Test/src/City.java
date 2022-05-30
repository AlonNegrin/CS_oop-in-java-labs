public class City implements Comparable<City>{

    private String name;
    private String country;
    private int population;
    private int area;

    public City(String name, String country, int population, int area) {
        this.name = name;
        this.country = country;
        this.population = population;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

    public int getArea() {
        return area;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "City {" +
                "name = " + name +
                ", country = " + country +
                ", population = " + population +
                ", area = " + area +
                '}';
    }


    @Override
    public int compareTo(City otherCityObj) {
       return this.name.compareTo(otherCityObj.name);
    }
}
