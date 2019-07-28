import javax.swing.*;
import java.awt.*;

class MyPanel extends JPanel{
    private boolean firstCall = true;

    public MyPanel() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(400, 400));
        frame.setVisible(true);

        frame.add(this);
        frame.repaint();
    }
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        int x[] = {0,             getWidth()/2, getWidth(),    getWidth()/2};
        int y[] = {getHeight()/2, 0,            getHeight()/2, getHeight()};
        if (firstCall) {
            graphics.setColor(Color.RED);
            firstCall = false;
        } else {
            graphics.setColor(Color.BLUE);
        }
        graphics.drawPolygon(x, y, x.length);
    }

    public static void main(String[] args) {
        MyPanel frame = new MyPanel();
        int x = 5;
        System.out.println(Integer.valueOf(x));
    }
}
