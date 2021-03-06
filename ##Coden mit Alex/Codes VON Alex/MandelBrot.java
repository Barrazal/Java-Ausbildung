import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class MandelBrot extends JFrame {

    public MandelBrot() {
        super("Mandelbrot Baum");
        setBounds(100, 100, 1800, 1600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
        if (depth == 0) return;
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 10.0);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * 10.0);
        g.drawLine(x1, y1, x2, y2);
        drawTree(g, x2, y2, angle - 30, depth - 1);
        drawTree(g, x2, y2, angle + 30, depth - 1);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        drawTree(g, 900, 1000, -90, 14);
    }

    public static void main(String[] args) {
        new MandelBrot().setVisible(true);
    }
}