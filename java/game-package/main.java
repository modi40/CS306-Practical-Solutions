package game;

class Indoor {
    String gameName;
    String[] players;

    Indoor() {
        gameName = "Badminton";
        players = new String[]{"Saina Nehwal", "PV Sindhu"};
    }

    Indoor(String gameName, String[] players) {
        this.gameName = gameName;
        this.players = players;
    }

    void display() {
        System.out.println("Indoor Game: " + gameName);
        System.out.println("Players List:");
        for (int i = 0; i < players.length; i++) {
            System.out.println("  " + (i + 1) + ". " + players[i]);
        }
    }
}

class Outdoor {
    String gameName;
    String[] players;

    Outdoor() {
        gameName = "Cricket";
        players = new String[]{"Rohit", "Virat", "Shubman"};
    }

    Outdoor(String gameName, String[] players) {
        this.gameName = gameName;
        this.players = players;
    }

    void display() {
        System.out.println("Outdoor Game: " + gameName);
        System.out.println("Players List:");
        for (int i = 0; i < players.length; i++) {
            System.out.println("  " + (i + 1) + ". " + players[i]);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Indoor g1 = new Indoor();
        g1.display();

        Indoor g2 = new Indoor("Chess", new String[]{"Praggnanandhaa", "Gukesh"});
        g2.display();

        Outdoor g3 = new Outdoor();
        g3.display();

        Outdoor g4 = new Outdoor("Football", new String[]{"Sunil Chhetri", "Gurpreet Singh"});
        g4.display();
    }
}
