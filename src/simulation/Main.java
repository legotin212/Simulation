package simulation;

public class Main {
    public static void main(String[] args) {
        SimulationFactory factory = new SimulationFactory();
        Simulation simulation = factory.getSimulation();
        UI ui = new UI();
        ui.start(simulation);
    }



}
