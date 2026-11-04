package inf4067.solid.isp.before;

/** Forcé d'implémenter eat() qu'il n'utilise pas (viole ISP). */
public class RobotWorker implements Worker {
    @Override public void work() { System.out.println("Les Robots travaillent sans fatigue"); }
    @Override public void eat() {
        throw new UnsupportedOperationException("Les Robots ne mangent pas");
    }
}
