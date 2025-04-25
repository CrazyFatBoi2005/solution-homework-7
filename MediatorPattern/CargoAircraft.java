package MediatorPattern;
public class CargoAircraft extends Aircraft {
    public CargoAircraft(String id) {
        super(id);
    }

    @Override
    public void receive(String msg) {
        System.out.println("Cargo Aircraft " + id + " received: " + msg);
    }
}
