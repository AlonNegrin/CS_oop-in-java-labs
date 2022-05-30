import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Cities {
    private final List<City> cityList;
    private final String sourceFilePath;

    public Cities() {
        this("cities.txt");
    }

    public Cities(String filePath)  {
        this.cityList = new ArrayList<>();
        this.sourceFilePath = filePath;
        init();
    }

    private void init() {
        BufferedReader reader;
        try {

            reader = new BufferedReader(new FileReader(this.sourceFilePath));
            String line = reader.readLine();

            while (line != null) {

                String[] fieldsParts = line.split("\t");

                if (fieldsParts.length != 4) {
                    line = reader.readLine();//קורא לשורה הבאה
                    continue;
                }
                String city = fieldsParts[0];
                String country = fieldsParts[1];
                String populationText = fieldsParts[2];
                int population = Integer.parseInt(populationText);

                String areaText = fieldsParts[3];
                int area = Integer.parseInt(areaText);

                City cityLineObj = new City(city, country, area, population);
                this.cityList.add(cityLineObj);

                line = reader.readLine();
            }

            reader.close();

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void listAlphabeticly(){
        List<City> cities = this.cityList.stream().toList();
        Collections.sort(cities);
        for (City city : cities){
            System.out.println(city.toString());
        }
    }

    public void listByPopulation(){

    }
    public void listByDensity(){

    }

    public void listByCountry(String country){

    }

    @Override
    public String toString() {
        StringBuilder citiesTextBuilder = new StringBuilder();
        for (City cityObj : this.cityList){
            citiesTextBuilder.append(cityObj).append("\n");
        }
        return citiesTextBuilder.toString();
    }
}
