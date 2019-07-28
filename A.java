import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Gui implements ActionListener {

    JTextField textField;
    public Gui() {
        JFrame frame = new JFrame("counter");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JButton button = new JButton("press me");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(100, 24));

        panel.add(textField);
        panel.add(button);

        frame.add(panel);

        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

        button.addActionListener(this);

    }

    public static void main(String[] args) {
        Gui gui = new Gui();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Thread thread = new Thread(new ShirsRunnable());
        thread.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<10; i++) {
                    textField.setText(String.valueOf(i));
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

class ShirsRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("hello world");
    }
}
