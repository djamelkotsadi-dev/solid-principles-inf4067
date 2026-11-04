package inf4067.solid.isp.after;

/** APRÈS : ne dépend que de ce qu'il utilise. */
public class RobotWorker implements Workable {
    @Override public void work() { System.out.println("Les Robots travaillent sans fatigue"); }
}
