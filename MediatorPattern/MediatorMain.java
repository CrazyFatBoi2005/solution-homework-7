package MediatorPattern;

public class MediatorMain {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();

        Aircraft plane1 = new PassengerAircraft("Plane 1");
        Aircraft plane2 = new CargoAircraft("Plane 2");
        Aircraft plane3 = new EmergencyAircraft("Emergency 1");
        Aircraft plane4 = new PassengerAircraft("Plane 3");

        tower.addAircraft(plane1);
        tower.addAircraft(plane2);
        tower.addAircraft(plane3);
        tower.addAircraft(plane4);

        plane1.send("Requesting runway for landing.", tower);
        plane2.send("Requesting runway for takeoff.", tower);
        plane3.send("MAYDAY! Emergency landing request.", tower);
        plane4.send("Requesting runway for landing.", tower);

        tower.requestRunway(plane1);
        tower.requestRunway(plane2);
        tower.requestRunway(plane3);
        tower.requestRunway(plane4);
    }
}
