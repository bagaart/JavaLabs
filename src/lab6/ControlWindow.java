package lab6;

import javax.swing.*;
import java.awt.*;

public class ControlWindow extends JFrame{
    private final DemoWindow demoWindow;
    private final JTextField figureTypeField = new JTextField(10);
    private final JTextField speedField = new JTextField(5);
    private final JComboBox<Figure> figureSelector = new JComboBox<>();
    private final JTextField editSpeedField = new JTextField(5);
    private Color currentTextColor = Color.BLACK;
    private Color currentFillColor = Color.WHITE;
    private Color selectedTextColor = Color.BLACK;
    private Color selectedFillColor = Color.WHITE;

    public ControlWindow(DemoWindow demoWindow) {
        this.demoWindow = demoWindow;
        setTitle("Управляющее окно");
        setSize(700, 400);
        setLocation(0, 100);
        setLayout(new GridLayout(0, 2, 5, 5));

        JPanel creationPanel = createCreationPanel();

        JPanel editPanel = createEditPanel();

        add(creationPanel);
        add(editPanel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createCreationPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Создание фигуры"));

        panel.add(new JLabel("Тип фигуры:"));
        panel.add(figureTypeField);

        panel.add(new JLabel("Скорость (1-6):"));
        panel.add(speedField);

        JButton textColorBtn = new JButton("Цвет текста");
        textColorBtn.addActionListener(e ->
                currentTextColor = JColorChooser.showDialog(null, "Выберите цвет", currentTextColor));

        JButton fillColorBtn = new JButton("Цвет заливки");
        fillColorBtn.addActionListener(e ->
                currentFillColor = JColorChooser.showDialog(null, "Выберите цвет", currentFillColor));

        JButton startBtn = new JButton("Пуск");
        startBtn.addActionListener(e -> createFigure());

        panel.add(textColorBtn);
        panel.add(fillColorBtn);
        panel.add(startBtn);

        return panel;
    }

    private JPanel createEditPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Редактирование фигур"));

        panel.add(new JLabel("Выбор фигуры:"));
        figureSelector.addActionListener(e -> updateSelection());
        panel.add(figureSelector);

        JButton editTextColorBtn = new JButton("Изменить цвет текста");
        editTextColorBtn.addActionListener(e -> {
            selectedTextColor = JColorChooser.showDialog(null, "Выберите цвет", selectedTextColor);
            updateTextColor();
        });

        JButton editFillColorBtn = new JButton("Изменить цвет заливки");
        editFillColorBtn.addActionListener(e -> {
            selectedFillColor = JColorChooser.showDialog(null, "Выберить цвет", selectedFillColor);
            updateFillColor();
        });

        panel.add(new JLabel("Новая скорость:"));
        panel.add(editSpeedField);

        JButton speedBtn = new JButton("Изменить скорость");
        speedBtn.addActionListener(e -> updateSpeed());

        panel.add(editTextColorBtn);
        panel.add(editFillColorBtn);
        panel.add(speedBtn);

        return panel;
    }

    private void createFigure() {
        try {
            int speed = Integer.parseInt(speedField.getText());
            if (speed < 1 || speed > 6) throw new NumberFormatException();

            Figure figure = new Figure(
                    figureTypeField.getText().trim(),
                    speed,
                    currentTextColor,
                    currentFillColor
            );
            demoWindow.figureAdded(figure);
            figureSelector.addItem(figure);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Некорректная скорость! Введите число от 1 до 6");
        }
    }

    private void updateSelection() {
        Figure selected = (Figure) figureSelector.getSelectedItem();
        if (selected != null) {
            selectedTextColor = selected.getColor();
            selectedFillColor = selected.getFillColor();
            editSpeedField.setText(String.valueOf(selected.getSpeed()));
        }
    }

    private void updateTextColor() {
        Figure selected = (Figure) figureSelector.getSelectedItem();
        if (selected != null) {
            selected.setColor(selectedTextColor);
            demoWindow.figureUpdated(selected);
        }
    }

    private void updateFillColor() {
        Figure selected = (Figure) figureSelector.getSelectedItem();
        if (selected != null) {
            selected.setFillColor(selectedFillColor);
            demoWindow.figureUpdated(selected);
        }
    }

    private void updateSpeed() {
        try {
            int newSpeed = Integer.parseInt(editSpeedField.getText());
            Figure selected = (Figure) figureSelector.getSelectedItem();
            if (selected != null) {
                selected.setSpeed(newSpeed);
                demoWindow.figureUpdated(selected);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Некорректная скорость!");
        }
    }

}
