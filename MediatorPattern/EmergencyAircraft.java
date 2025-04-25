package MediatorPattern;
public class EmergencyAircraft extends Aircraft {
    public EmergencyAircraft(String id) {
        super(id);
    }

    @Override
    public void receive(String msg) {
        System.out.println("Emergency Aircraft " + id + " received: " + msg);
    }
}
