class Continent {
    String continentName;

    Continent(String continentName) {
        this.continentName = continentName;
    }
}

class Country extends Continent {
    String countryName;

    Country(String continentName, String countryName) {
        super(continentName);
        this.countryName = countryName;
    }
}

class State extends Country {
    String stateName;
    String placeName;

    State(String continentName, String countryName, String stateName, String placeName) {
        super(continentName, countryName);
        this.stateName = stateName;
        this.placeName = placeName;
    }

    void display() {
        System.out.println("Place: " + placeName);
        System.out.println("State: " + stateName);
        System.out.println("Country: " + countryName);
        System.out.println("Continent: " + continentName);
    }
}

class Main {
    public static void main(String[] args) {
        State obj = new State("Asia", "India", "Maharashtra", "Pune");
        obj.display();
    }
}
