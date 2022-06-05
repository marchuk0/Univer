package com.marchuk0;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.BasicStroke;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainPanel extends JPanel {
    private static final int RADIUS = 5;
    
    private final Canvas canvas = new Canvas();
    private int randomSize = 1;
    
    private final List<Point> points = new ArrayList<>();

    public MainPanel() {
        super();
        setBackground(Color.LIGHT_GRAY);

        GridBagLayout gbl = new GridBagLayout();
        gbl.columnWeights = new double[] {1, 2};
        gbl.rowWeights = new double[] {1, 1, 10};
        setLayout(gbl);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipadx = 10;
        gbc.ipady = 20;
        gbc.fill = GridBagConstraints.NONE;
        Button resetButton = new Button("Reset");
        resetButton.setBackground(Color.GRAY);
        resetButton.addActionListener(e -> onReset());
        this.add(resetButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipadx = 10;
        gbc.ipady = 20;
        gbc.fill = GridBagConstraints.NONE;
        Button generateRandomButton = new Button("Generate random points");
        generateRandomButton.setBackground(Color.GRAY);
        generateRandomButton.addActionListener(e -> onGenerateRandom());
        this.add(generateRandomButton, gbc);

        JSpinner randomSizeSpinner = new JSpinner();
        randomSizeSpinner.setModel(new SpinnerNumberModel(1, 1, 10000, 1));
        randomSizeSpinner.addChangeListener(e -> randomSize = (int) randomSizeSpinner.getValue());
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipadx = 10;
        gbc.ipady = 20;
        gbc.anchor = GridBagConstraints.PAGE_START;
        this.add(randomSizeSpinner, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipady = 0;
        canvas.setBackground(Color.WHITE);
        this.add(canvas, gbc);


        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                onMousePressedOnCanvas(e.getX(), e.getY());
            }
        });
    }

    private void onReset() {
        points.clear();
        drawPoints();
    }

    private void onGenerateRandom() {
        points.clear();
        Random random = new Random();
        for (int i = 0; i < randomSize; i++) {
            int x = random.nextInt(canvas.getWidth());
            int y = random.nextInt(canvas.getHeight());

            points.add(new Point(x, y));
        }
        drawPoints();
    }
    
    private void onMousePressedOnCanvas(int x, int y) {
        Point point = new Point(x, y);
        if (!points.contains(point)) {
            points.add(point);
            drawPoints();
        }
    }
    
    private void drawPoints() {
        Graphics2D g = (Graphics2D) canvas.getGraphics();
        g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        List<Point> convexHull = GrahamScan.buildConvexHull(points);
        List<Point> triangle = null;
        if (points.size() >= 3) {
            triangle = MaxAreaTriangle.getMaxAreaTriangle(convexHull);
        }
        
        Point previous = null;
        g.setColor(Color.ORANGE);
        g.setStroke(new BasicStroke(5));
        for (Point p : convexHull) {
            if (previous != null) {
                g.drawLine(previous.x, previous.y, p.x, p.y);
            }
            previous = p;
        }

        if (convexHull.size() > 0) {
            g.drawLine(previous.x, previous.y, convexHull.get(0).x, convexHull.get(0).y);
        }


        g.setColor(Color.RED);
        for (Point p : points) {
            g.fillOval(p.x - RADIUS, p.y - RADIUS, 2 * RADIUS, 2 * RADIUS);
        }
        if (triangle != null) {
            drawTriangle(triangle.get(0), triangle.get(1), triangle.get(2), g);
        }
    }
    
    private void drawTriangle(Point a, Point b, Point c, Graphics2D g) {
        g.setColor(Color.GREEN);
        g.setStroke(new BasicStroke(3));
        g.drawLine(a.x, a.y, b.x, b.y);
        g.drawLine(b.x, b.y, c.x, c.y);
        g.drawLine(a.x, a.y, c.x, c.y);
    }
    
    
}
