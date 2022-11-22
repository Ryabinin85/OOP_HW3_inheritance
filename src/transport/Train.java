package transport;

import java.util.Objects;

public class Train extends Transport{
    private double tripPrice;
    private int tripTime;
    private final String startStationName;
    private final String finalStationName;
    private int numberOfWagons;
    private final String engineType;

    public Train(String brand, String model, int year, String country, String colour, double maxSpeed, double tripPrice,
                 int tripTime, String startStationName, String finalStationName, int numberOfWagons) {

        super(brand, model, year, country, colour, maxSpeed);
        this.tripPrice = validateTripPrice(tripPrice);
        this.tripTime = validateTripTime(tripTime);
        this.startStationName = Validator.validateString(startStationName);
        this.finalStationName = Validator.validateString(finalStationName);
        this.numberOfWagons = validateNumberOfWagons(numberOfWagons);
        this.engineType = "дизель";
    }

    private double validateTripPrice (double tripPrice){
        if (tripPrice <= 0)
            return this.tripPrice = 10000;
        else
            return this.tripPrice = tripPrice;
    }

    private int validateTripTime (int tripTime){
        if (tripTime <= 0)
            return this.tripTime = 10000;
        else
            return this.tripTime = tripTime;
    }

    private int validateNumberOfWagons (int numberOfWagons) {
        if (numberOfWagons <=0 )
            return this.numberOfWagons = 8;
        else
            return this.numberOfWagons = numberOfWagons;
    }

    public double getTripPrice() {
        return tripPrice;
    }

    public int getTripTime() {
        return tripTime;
    }

    public String getStartStationName() {
        return startStationName;
    }

    public String getFinalStationName() {
        return finalStationName;
    }

    public int getNumberOfWagons() {
        return numberOfWagons;
    }

    @Override
    public void refill() {
        System.out.printf("Поезд \"%s\" %s заправлен на 500 литров дизеля\n\n", getBrand(), getModel());
    }
    @Override
    public String toString() {
        return String.format ("Поезд \"%s\", модель %s, " +
                        "%d год выпуска, сборка: %s, максимальная скорость: %.1fкм/ч, тип двигателя: %s.\n" +
                        "Станция отправления: %s, станция назначения: %s.\n" +
                        "Стоимость поездки — %.2f рублей, в поезде %d вагонов. Время в пути %d часов.\n",
                getBrand(), getModel(), getYear(), getCountry(), getMaxSpeed(),engineType, startStationName, finalStationName,
                tripPrice, numberOfWagons, tripTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return Double.compare(train.tripPrice, tripPrice) == 0 && tripTime == train.tripTime &&
                numberOfWagons == train.numberOfWagons && Objects.equals(startStationName, train.startStationName) &&
                Objects.equals(finalStationName, train.finalStationName) && Objects.equals(engineType, train.engineType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tripPrice, tripTime, startStationName, finalStationName, numberOfWagons, engineType);
    }

    public static void main(String[] args) {
        Train lastochka = new Train("Ласточка", "B-901", 2011, "Россия", "",301,
                3500, 10, "Белорусский вокзал", "Минск-Пассажирский", 11);

        Train leningrad = new Train("Ленинград", "D-125", 2019, "Россия", "",270,
                1700, 8, "Ленинградский вокзал", "Ленинград-Пассажирский", 8);

        System.out.println(lastochka);
        lastochka.refill();
        System.out.println(leningrad);
    }
}