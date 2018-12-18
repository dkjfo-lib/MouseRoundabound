import java.awt.*;

public class MouseRoundabout {

    static final int ITERATIONS_PER_CIRCLE = 100;
    static final int RADIUS = 100;
    static final int DELAY = 10;
    static final int CIRCLES = 5;

    public static void main(String[] args) {
        try {
            Robot robot = new Robot();

            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            int centerX = (int) screenRect.getWidth() / 2;
            int centerY = (int) screenRect.getHeight() / 2;

            int x;
            int y;

            for (int i = 0; i < ITERATIONS_PER_CIRCLE * CIRCLES; i++) {
                x = (int) (Math.cos(i / (float) ITERATIONS_PER_CIRCLE * CIRCLES * Math.PI * 2) * RADIUS);
                y = (int) (Math.sin(i / (float) ITERATIONS_PER_CIRCLE * CIRCLES * Math.PI * 2) * RADIUS);
                synchronized (robot) {

                    try {
                        robot.wait(DELAY);
                    } catch (InterruptedException ie) {
                        System.err.println("Wait was interrupted");
                    }
                }
                robot.mouseMove(centerX + x, centerY + y);
                System.out.println("iteration : " + i + " / " + ITERATIONS_PER_CIRCLE * CIRCLES);
                System.out.println("mouse coordinates are : ");
                System.out.println("\tX : (" + centerX + " + " + x + ") px");
                System.out.println("\tY : (" + centerY + " + " + y + ") px");
                System.out.println();

            }
        } catch (AWTException awte) {
            System.err.println("Can not crate robot : " + awte);
        }
    }
}
