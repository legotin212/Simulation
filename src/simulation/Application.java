package simulation;

import java.util.Scanner;

public class Application {
    public void start(){
        SimulationFactory factory = new SimulationFactory();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter map height: ");
        int height  =  scanner.nextInt();
        System.out.println("Enter map width: .");
        int width  = scanner.nextInt();
        Simulation simulation = factory.getSimulation(height, width);
        UIThread thread = new UIThread(simulation);
        thread.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        simulation.run();
    }
}
