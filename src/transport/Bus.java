package transport;

import java.util.Objects;

public class Bus extends Transport{
    private double tripPrice;
    private int tripTime;
    private final String startStationName;
    private final String finalStationName;
    private int numberOfSeats;
    private int numberOfStandingPlaces;
    private final String routeNumber;
    private String engineType;


    public Bus(String brand, String model, int year, String country, String colour, double maxSpeed,
               double tripPrice, int tripTime, String startStationName, String finalStationName,
               int numberOfSeats, int numberOfStandingPlaces, String routeNumber, String engineType) {
        super(brand, model, year, country, colour, maxSpeed);
        this.tripPrice = validateTripPrice(tripPrice);
        this.tripTime = validateTripTime(tripTime);
        this.startStationName = Validator.validateString(startStationName);
        this.finalStationName = Validator.validateString(finalStationName);
        this.numberOfSeats = validateNumberOfSeats(numberOfSeats);
        this.numberOfStandingPlaces = validateNumberOfStandingPlaces(numberOfStandingPlaces);
        this.routeNumber = Validator.validateString(routeNumber);
        this.engineType = validateEngineType(engineType);
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

    private int validateNumberOfSeats (int numberOfSeats) {
        if (numberOfSeats <=0 )
            return this.numberOfSeats = 20;
        else
            return this.numberOfSeats = numberOfSeats;
    }
    private int validateNumberOfStandingPlaces (int numberOfStandingPlaces) {
        if (numberOfStandingPlaces <=0 )
            return this.numberOfStandingPlaces = 50;
        else
            return this.numberOfStandingPlaces = numberOfStandingPlaces;
    }

    private String validateEngineType(String engineType) {
        if (engineType == null || engineType.isEmpty() || engineType.isBlank())
            return this.engineType = "дизель";

        else if (engineType.equalsIgnoreCase("ДИЗЕЛЬ") || engineType.equalsIgnoreCase("БЕНЗИН"))
            return this.engineType = engineType.toLowerCase();
        else
            return this.engineType = "дизель";
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

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public int getNumberOfStandingPlaces() {
        return numberOfStandingPlaces;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    @Override
    void refill() {
        if (engineType.equals("дизель"))
            System.out.printf("Автобус \"%s\" %s заправлен на 50 литров дизеля\n\n", getBrand(), getModel());
        else
            System.out.printf("Автобус \"%s\" %s заправлен на 50 литров бензина\n\n", getBrand(), getModel());
    }

    @Override
    public String toString() {
        return String.format ("Автобус \"%s\", модель %s, " +
                        "%d год выпуска, сборка: %s, максимальная скорость: %.1fкм/ч, тип двигателя: %s.\n" +
                        "Маршрут: \"%s\". Станция отправления: %s, станция назначения: %s.\n" +
                        "Стоимость поездки — %.2f рублей. Число сидячих мест %d, число стоячих мест %d.\n" +
                        "Время в пути %d часов.\n",
                getBrand(), getModel(), getYear(), getCountry(), getMaxSpeed(), engineType, routeNumber, startStationName,
                finalStationName, tripPrice, numberOfSeats, numberOfStandingPlaces, tripTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return Double.compare(bus.tripPrice, tripPrice) == 0 && tripTime == bus.tripTime &&
                numberOfSeats == bus.numberOfSeats && numberOfStandingPlaces == bus.numberOfStandingPlaces &&
                Objects.equals(startStationName, bus.startStationName) && Objects.equals(finalStationName, bus.finalStationName) &&
                Objects.equals(routeNumber, bus.routeNumber) && Objects.equals(engineType, bus.engineType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tripPrice, tripTime, startStationName, finalStationName, numberOfSeats,
                numberOfStandingPlaces, routeNumber, engineType);
    }

    public static void main(String[] args) {
        Bus nefaz5299 = new Bus("НефАЗ", "5299", 2018, "Россия", "",70,
                65, 2, "Павелецкий вокзал", "Павелецкий вокзал",
                35, 40, "Б", "disel");

        Bus maz206 = new Bus("МАЗ", "206", 2016, "Россия", "",65,
                70, 1, "Метро Царицыно", "Метро Автозаводская",
                30, 38, "КМ1", "ДиЗель");

        Bus gazeleCity = new Bus("ГАЗель", "City", 2019, "Россия", "",165,
                55, 3, "Беловежская улица", "Метро Петровско-Разумовская",
                15, 15, "300", "Бензин");

        System.out.println(nefaz5299);
        nefaz5299.refill();
        System.out.println(maz206);
        maz206.refill();
        System.out.println(gazeleCity);
        gazeleCity.refill();
    }
}