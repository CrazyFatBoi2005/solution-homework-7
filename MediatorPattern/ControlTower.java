package MediatorPattern;
import java.util.ArrayList;
import java.util.List;

public class ControlTower implements TowerMediator {
    private final List<Aircraft> aircrafts = new ArrayList<>();
    private final List<Aircraft> landingQueue = new ArrayList<>();
    private final List<Aircraft> takeOffQueue = new ArrayList<>();

    public void addAircraft(Aircraft aircraft) {
        aircrafts.add(aircraft);
    }

    @Override
    public void broadcast(String msg, Aircraft sender) {
        for (Aircraft a : aircrafts) {
            if (!a.equals(sender)) {
                a.receive(msg);
            }
        }
    }

    @Override
    public boolean requestRunway(Aircraft aircraft) {
        if (aircraft instanceof EmergencyAircraft) {
            if (takeOffQueue.size() > 0) takeOffQueue.remove(0);
            if (landingQueue.size() > 0) landingQueue.remove(0);
            return true;
        }
        if (aircraft instanceof PassengerAircraft) {
            landingQueue.add(aircraft);
            return false;
        } else if (aircraft instanceof CargoAircraft) {
            takeOffQueue.add(aircraft);
            return false;
        }
        return false;
    }
}
