package transport;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Car extends Transport{
    private final String carBodyType;
    private int numberOfSeats;
    private double engineVolume;
    private String transmission;
    private String registrationNumber;
    private String tyresType;
    private Insurance insurance;
    private Key key;
    private String engineType;

    public Car(String brand, String model, double engineVolume, String colour, int year,
               String country, String transmission, String carBodyType, String registrationNumber,
               int numberOfSeats, String tyresType, Key key, Insurance insurance, double maxSpeed, String engineType) {
        super(brand, model,year, country, colour, maxSpeed);
        this.carBodyType = Validator.validateString(carBodyType);
        this.registrationNumber = validateRegNumber(registrationNumber);
        this.engineVolume = validateEngineVolume(engineVolume);
        this.transmission = validateTransmission(transmission);
        this.numberOfSeats = validateNumberOfSeats(numberOfSeats);
        this.tyresType = validateTyresType(tyresType);
        this.key = key;
        this.insurance = insurance;
        this.engineType = validateEngineType(engineType);
    }
    private String validateRegNumber(String registrationNumber) {
        String checkedString = registrationNumber.trim();
        Pattern pattern = Pattern
                .compile("^[авекмнорстухАВЕКМНОРСТУХ][0-9]{3}[авекмнорстухАВЕКМНОРСТУХ]{2}[0-9]{2,3}$");
        Matcher matcher = pattern.matcher(checkedString);
        if (matcher.matches())
            return checkedString.toUpperCase() + "RUS";
        else
            return "Invalid input";
    }

    private double validateEngineVolume(double engineVolume) {
        if (engineVolume <= 0)
            return this.engineVolume = 1.5;
        else
            return this.engineVolume = engineVolume;
    }

    private String validateTransmission(String transmission) {
        return transmission == null
                || transmission.isEmpty()
                || transmission.isBlank() ? "manual transmission" : transmission;
    }

    private int validateNumberOfSeats(int numberOfSeats) {
        if (numberOfSeats <= 3 || numberOfSeats > 7)
            return this.numberOfSeats = 5;
        else
            return this.numberOfSeats = numberOfSeats;
    }

    private String validateTyresType (String tyresType) {
        if (tyresType == null || tyresType.isEmpty() || tyresType.isBlank())
            return this.tyresType = "зимние";
        else
            return this.tyresType = tyresType;
    }
    private String validateEngineType(String engineType) {
        if (engineType == null || engineType.isEmpty() || engineType.isBlank())
            return this.engineType = "дизель";

        else if (engineType.equalsIgnoreCase("ДИЗЕЛЬ") || engineType.equalsIgnoreCase("БЕНЗИН")
                || engineType.equalsIgnoreCase("ЭЛЕКТРОМОТОР"))
            return this.engineType = engineType.toLowerCase();
        else
            return this.engineType = "бензин";
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getCarBodyType() {
        return carBodyType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public String getTyresType() {
        return tyresType;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public Key getKey() {
        return key;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = validateEngineVolume(engineVolume);
    }

    public void setTransmission(String transmission) {
        this.transmission = validateTransmission(transmission);
    }
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = validateRegNumber(registrationNumber);
    }

    public void setWinterTyres() {
        this.tyresType = "летние";
    }
    public void setSummerTyres() {
        this.tyresType = "зимние";
    }

    @Override
    void refill() {
        if (engineType.equals("дизель"))
            System.out.printf("Автомобиль \"%s\" %s заправлен на 30 литров дизеля\n\n", getBrand(), getModel());
        else if (engineType.equals("бензин"))
            System.out.printf("Автомобиль \"%s\" %s заправлен на 30 литров бензина\n\n", getBrand(), getModel());
        else
            System.out.printf("Автомобиль \"%s\" %s заряжен на 100 %%\n\n", getBrand(), getModel());
    }

    @Override
    public String toString() {
        return String.format ("%s %s:\n" +
                        "%d год выпуска, сборка: %s, цвет: %s, объем двигателя: %.01f л, тип двигателя: %s\n" +
                        "Коробка передач: %s, максимальная скорость: %.1fкм/ч.\n" +
                        "Кузов: %s, регистрационный номер: %s, число сидений %d, тип шин: %s",
                getBrand(), getModel(),
                getYear(), getCountry(), getColour(), engineVolume, engineType, transmission, getMaxSpeed(),
                carBodyType, registrationNumber, numberOfSeats, tyresType + getKey() + getInsurance());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return numberOfSeats == car.numberOfSeats && Double.compare(car.engineVolume, engineVolume) == 0 &&
                Objects.equals(carBodyType, car.carBodyType) && Objects.equals(transmission, car.transmission) &&
                Objects.equals(registrationNumber, car.registrationNumber) && Objects.equals(tyresType, car.tyresType) &&
                Objects.equals(insurance, car.insurance) && Objects.equals(key, car.key) && Objects.equals(engineType, car.engineType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carBodyType, numberOfSeats, engineVolume, transmission,
                registrationNumber, tyresType, insurance, key, engineType);
    }

    public static class Key {
        private final Boolean remoteStart;
        private final Boolean keylessAccess;
        private final String enabled = "доступна";
        private final String disabled = "недоступна";
        public Key(Boolean remoteStart, Boolean keylessAccess) {
            this.remoteStart = Validator.validateBoolean(remoteStart);
            this.keylessAccess = Validator.validateBoolean(keylessAccess);
        }

        public Boolean getRemoteStart() {
            return remoteStart;
        }

        public Boolean getKeylessAccess() {
            return keylessAccess;
        }
        private String remoteStart(Boolean remoteStart) {
            return remoteStart ? enabled: disabled;
        }
        private String keylessAccess(Boolean keylessAccess) {
            return keylessAccess ? enabled: disabled;
        }

        @Override
        public String toString() {
            return String.format("\nОпция автозапуска: %s\nОпция бесключевого доступа: %s\n",
                    remoteStart(remoteStart),keylessAccess(keylessAccess));
        }
    }

    public static class Insurance {
        private final int validityPeriodInMonth; //«Срок действия» страховки, по количеству месяцев
        private final double insurancePriceForOneMonth; //«Стоимость» страховки
        private final String insuranceID; //«Номер» страховки

        public Insurance(int validityPeriodInMonth, double insurancePriceForOneMonth, String insuranceID) {

            if (validityPeriodInMonth > 0)
                this.validityPeriodInMonth = validityPeriodInMonth;
            else
                this.validityPeriodInMonth = 1;
            if (insurancePriceForOneMonth > 1000)
                this.insurancePriceForOneMonth = insurancePriceForOneMonth * this.validityPeriodInMonth;
            else
                this.insurancePriceForOneMonth = 1000.0;

            this.insuranceID = validateInsuranceID(insuranceID);
        }
        private String validateInsuranceID(String insuranceID) {  //Y023HE999
            String checkedString = insuranceID.trim();

            if (Pattern.matches("^[a-zA-Z0-9]{9}$", checkedString))
                return checkedString.toUpperCase();
            else
                return "Invalid input";
        }

        public int getValidityPeriodInMonth() {
            return validityPeriodInMonth;
        }

        public double getInsurancePriceForOneMonth() {
            return insurancePriceForOneMonth;
        }

        public String getInsuranceID() {
            return insuranceID;
        }

        @Override
        public String toString() {
            return String.format("\nСтраховка выдана на %d месяцев\nСтоимость страховки: %.2f рублей\nНомер страховки: %s\n\n",
                    validityPeriodInMonth, insurancePriceForOneMonth, insuranceID);
        }
    }

    public static void main(String[] args) {

        Car.Key keyOn = new Car.Key(true, true);
        Car.Key keyOff = new Car.Key(false, false);

        Car.Insurance insuranceSixMonth = new Car.Insurance(6,
                2000, "659QWe621");
        Car.Insurance insuranceOneYear = new Car.Insurance(12,
                1800, "659QWe622");

        Car granta = new Car("Lada", "Granta", 1.7,
                "yellow", 2015, "Russia", "automatic", "sedan",
                "   у023не999      ", 5, "winter", keyOff, insuranceSixMonth, 220, "бензин");

        granta.setRegistrationNumber("к654рС750");
        granta.setSummerTyres();

        transport.Car a8 = new transport.Car("Audi", "A8 50 L TDI quattro", 3.0,
                "black", 2020, "Germany", "automatic", "sedan",
                "   у111уу999      ", 5, "winter", keyOn, insuranceOneYear, 320, "дизель");

        transport.Car z8 = new transport.Car("BMW", "Z8", 3.0,
                "yellow", 2021, "Germany", "automatic", "sedan",
                "   х888хр999      ", 5, "winter", keyOn, insuranceOneYear, 340, "бензин");

        transport.Car sportage = new transport.Car("Kia", "Sportage 4", 1.7,
                "red", 2018, "South Korea", "automatic", "sedan",
                "   е681рк071      ", 5, "winter", keyOn, insuranceOneYear, 250, "бензин");
        sportage.setSummerTyres();

        transport.Car avante = new transport.Car("Hyundai", "Avante", 1.6,
                "orange", 2016, "South Korea", "automatic", "sedan",
                "   р030во063      ", 5, "winter", keyOn, insuranceOneYear, 230, "ЭЛЕКТРОМОТОР");
        avante.setWinterTyres();

        System.out.println(granta);
        granta.refill();
        System.out.println(a8);
        a8.refill();
        System.out.println(z8);
        z8.refill();
        System.out.println(sportage);
        sportage.refill();
        System.out.println(avante);
        avante.refill();
    }
}