package MediatorPattern;
public class PassengerAircraft extends Aircraft {
    public PassengerAircraft(String id) {
        super(id);
    }

    @Override
    public void receive(String msg) {
        System.out.println("Passenger Aircraft " + id + " received: " + msg);
    }
}
