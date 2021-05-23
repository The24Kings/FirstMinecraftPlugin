package pluginmadness;

public class BigFunni {
    public static boolean running;

    public static void toggle() {
        running = !running;
    }

    public static boolean isRunning() {
        return running;
    }

}
