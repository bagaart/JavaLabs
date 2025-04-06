package lab6;

import javax.swing.*;

public class Main {
    public static void main (String[] args) {
        SwingUtilities.invokeLater(() -> {
            DemoWindow demoWindow = new DemoWindow();
            ControlWindow controlWindow = new ControlWindow(demoWindow);
            demoWindow.setVisible(true);
        });
    }
}
