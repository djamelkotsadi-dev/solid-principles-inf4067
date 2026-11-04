package inf4067.solid.test;

import static inf4067.solid.test.Check.*;

public class IspTest {
    public static void run() {
        section("ISP - AVANT : interface Worker (work + eat)");
        inf4067.solid.isp.before.Worker human = new inf4067.solid.isp.before.HumanWorker();
        isTrue("HumanWorker.eat() fonctionne",
            capture(human::eat).contains("Les humains mangent"));
        inf4067.solid.isp.before.Worker robot = new inf4067.solid.isp.before.RobotWorker();
        isTrue("RobotWorker.work() fonctionne",
            capture(robot::work).contains("sans fatigue"));
        throwsEx("RobotWorker.eat() : méthode imposée, lève UnsupportedOperationException",
            UnsupportedOperationException.class, robot::eat);

        section("ISP - APRÈS : Workable / Eatable extends Workable");
        inf4067.solid.isp.after.Eatable h = new inf4067.solid.isp.after.HumanWorker();
        isTrue("HumanWorker travaille", capture(h::work).contains("Les humains travaillent"));
        isTrue("HumanWorker mange", capture(h::eat).contains("Les humains mangent"));
        inf4067.solid.isp.after.Workable r = new inf4067.solid.isp.after.RobotWorker();
        isTrue("RobotWorker travaille", capture(r::work).contains("sans fatigue"));
        isTrue("RobotWorker n'est pas Eatable (plus de méthode inutile)",
            !(r instanceof inf4067.solid.isp.after.Eatable));
        isTrue("HumanWorker reste utilisable comme Workable", h instanceof inf4067.solid.isp.after.Workable);
    }
}
