class ClockTime {
    int hour;
    int minute;

    public ClockTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int compare(ClockTime t) {
        return (this.hour * 60 + this.minute) - (t.hour * 60 + t.minute);
    }

    @Override
    public String toString() {
        return hour + ":" + (minute < 10 ? "0" : "") + minute;
    }
}

class Schedule {
    ClockTime departure;
    ClockTime arrival;

    public Schedule(ClockTime departure, ClockTime arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }

    public int time() {
        int dep = departure.hour * 60 + departure.minute;
        int arr = arrival.hour * 60 + arrival.minute;

        if (arrival.compare(departure) < 0) {
            arr += 24 * 60;
        }
        return arr - dep;
    }
}

class Route {
    String origin;
    String destination;

    public Route(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public boolean isRoundTrip(Route r) {
        return this.origin.equals(r.destination)
                && this.destination.equals(r.origin);
    }
}

class Train {
    Route r;
    Schedule s;
    boolean local;

    public Train(String origin, String destination,
                 int depHour, int depMinute,
                 int arrHour, int arrMinute,
                 boolean local) {
        this.r = new Route(origin, destination);
        this.s = new Schedule(new ClockTime(depHour, depMinute),
                new ClockTime(arrHour, arrMinute));
        this.local = local;
    }

    public int getPrice() {
        int x = local ? 1 : 2;
        return x * s.time();
    }

    @Override
    public String toString() {
        return (local ? "Intern " : "International ")
                + r.origin + " (" + s.departure + ") -> "
                + r.destination + " (" + s.arrival + ")";
    }

    public static void main(String[] args) {
        Train t1 = new Train("Bucuresti Nord", "Constanta", 9, 35, 12, 2, true);
        Train t2 = new Train("Bucuresti Nord", "Iasi", 5, 45, 12, 49, true);
        Train t3 = new Train("Bucuresti Nord", "Sofia", 23, 45, 17, 0, false);

        Train[] trenuri = {t1, t2, t3};
        for (Train t : trenuri) {
            System.out.println(t);
            System.out.println("  Durata: " + t.s.time() + " min");
            System.out.println("  Pret bilet: " + t.getPrice());
        }

        Route a = new Route("Bucuresti Nord", "Constanta");
        Route b = new Route("Constanta", "Bucuresti Nord");
        System.out.println("Tur-retur a,b: " + a.isRoundTrip(b));
        System.out.println("Tur-retur t1,t2: " + t1.r.isRoundTrip(t2.r));

        ClockTime c1 = new ClockTime(9, 35);
        ClockTime c2 = new ClockTime(12, 2);
        System.out.println("compare(9:35, 12:02) = " + c1.compare(c2));
        System.out.println("compare(12:02, 9:35) = " + c2.compare(c1));
        System.out.println("compare(9:35, 9:35) = " + c1.compare(c1));
    }
}