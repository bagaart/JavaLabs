package lab6;

import java.awt.*;
import java.util.Random;

public class Figure {
    private static int nextId = 1;
    private final int id;
    private int x, y;
    private int dx, dy;
    private Color color;
    private Color fillColor;
    private final String type;
    private int speed;

    public Figure(String type, int speed, Color color, Color fillColor) {
        this.id = nextId++;
        this.type = type;
        this.speed = speed;
        this.color = color;
        this.fillColor = fillColor;
        this.x = 0;
        this.y = 0;
        Random rand = new Random();
        this.dx = rand.nextInt(5) + 1;
        this.dy = rand.nextInt(5) + 1;
    }

    public void move(Rectangle bounds) {
        x += dx * speed;
        y += dy * speed;
        checkCollision(bounds);
    }

    private void checkCollision(Rectangle bounds) {
        if (x < 0 || x + 50 > bounds.width) dx = -dx;
        if (y < 0 || y + 50 > bounds.height) dy = -dy;
    }

    public void draw(Graphics g) {
        g.setColor(fillColor);
        switch (type) {
            case "круг" -> g.fillOval(x, y, 50, 50);
            case "овал" -> g.fillOval(x, y, 60, 40);
            case "квадрат" -> g.fillRect(x, y, 50, 50);
            case "прямоугольник" -> g.fillRect(x, y, 60, 40);
            case "треугольник" -> {
                int[] xPoints = {x + 25, x, x + 50};
                int[] yPoints = {y, y + 50, y + 50};
                g.fillPolygon(xPoints, yPoints, 3);
            }
            default -> g.fillOval(x, y, 50, 50);
        }
        g.setColor(color);
        g.drawString(String.valueOf(id), x + 25, y + 25);
    }

    @Override
    public String toString() {
        return "Фигура #" + id;
    }

    public int getId() { return id; }
    public Color getColor() { return color; }
    public Color getFillColor() { return fillColor; }
    public int getSpeed() { return speed; }
    public void setSpeed(int speed) { this.speed = speed; }
    public void setColor(Color color) { this.color = color; }
    public void setFillColor(Color fillColor) { this.fillColor = fillColor; }
}
