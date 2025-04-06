package lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

public class DemoWindow extends JFrame implements FigureListener {
    private final List<Figure> figures = new ArrayList<>();
    private final JPanel canvas;

    public DemoWindow() {
        setTitle("Демонстрационное окно");
        setSize(700, 700);
        setLocation(700, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Figure figure : figures) {
                    figure.draw(g);
                }
            }
        };
        canvas.setBackground(Color.WHITE);
        add(canvas);

        Timer timer = new Timer(50, e -> {
           Rectangle bounds = canvas.getBounds();
           for (Figure figure : figures) {
               figure.move(bounds);
           }
           canvas.repaint();
        });
        timer.start();

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                canvas.repaint();
            }
        });
    }

    @Override
    public void figureAdded(Figure figure) {
        figures.add(figure);
    }

    @Override
    public void figureUpdated(Figure figure) {
        canvas.repaint();
    }
}
