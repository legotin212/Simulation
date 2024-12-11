package simulation;

import java.util.Scanner;

public class UI {
    public void start(Simulation simulation){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Minimum size of the map is 6x6");
        System.out.println("Enter map size from where 1 is 6x6 square, 2 is 12x12 square, 3 is 18x18 etc.");
        simulation.setMapSize(scanner.nextInt()*6);////передавать в конструктор а не сеттер
        UIThread thread = new UIThread(simulation);
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        simulation.run();
    }
}
