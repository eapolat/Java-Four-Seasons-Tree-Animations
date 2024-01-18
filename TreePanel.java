import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.w3c.dom.events.Event;

import java.awt.Polygon;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TreePanel extends JPanel {

    int current_season;

    public static final int spring = 0;
    public static final int summer = 1;
    public static final int fall = 2;
    public static final int winter = 3;

    Color green = new Color(0, 204, 0);
    Color other_green = new Color(0,180,0);  
    Color light_blue = new Color(51,204,255);
    Color other_blue = new Color (51,204,220);
    Color dark_blue = new Color (83, 130, 161);
    Color brown = new Color (102,51,0);
    Color bad_brown = new Color (238,132,66);
    Color darkest_blue = new Color (2, 56, 110);
    Color grey = new Color (128, 128, 128);

    Polygon trapezoid2 = new Polygon(new int[] {200, 230, 270, 300}, new int[] {450, 370, 370, 450}, 4);

    Polygon trapezoid1 = new Polygon(new int[] {150, 200, 300, 350}, new int[] {500, 450, 450, 500}, 4);

    Polygon triangle = new Polygon(new int[] {230, 260 , 270}, new int[] {370, 320, 370}, 3);

    Polygon trapezoid3 = new Polygon(new int[] {200, 230, 260, 240}, new int[] {310, 370, 320, 270}, 4);

    Polygon triangle2 = new Polygon(new int[] {200, 230, 240}, new int[] {310, 250, 270}, 3);

    Polygon trapezoid4 = new Polygon(new int[] {200, 100, 130, 230}, new int[] {310, 230, 230, 250}, 4);

    Polygon triangle3 = new Polygon(new int[] {100, 90, 130}, new int[] {230, 100, 230}, 3);

    Polygon trapezoid5 = new Polygon(new int[] {260, 270, 400, 380}, new int[] {320, 370, 260, 230}, 4);

    Polygon triangle4 = new Polygon(new int[] {400, 380, 420}, new int[] {260, 230, 140}, 3);

    Polygon triangle5 = new Polygon(new int[] {190, 250, 230}, new int[] {250, 110, 250}, 3);


    int x = 0;
    int y = 0;

    public TreePanel() {

    }


    public void paintComponent (Graphics g) {

        super.paintComponent(g);

        if (current_season == summer) {

            g.setColor(green);

            g.fillRect(0, 500, 500, 20);

            g.setColor(light_blue);

            g.fillRect(0, 0, 500, 500);

            g.setColor(green);

            display_leaves(g);

            display_tree(g);

            display_fruits(g);

        }
        else if (current_season == spring) {

            g.setColor(other_green);

            g.fillRect(0, 500, 500, 20);

            g.setColor(other_blue);
            
            g.fillRect(0, 0, 500, 500);

            g.setColor(other_green);

            display_leaves(g);

            display_tree(g);

        }
        else if (current_season == fall) {

            g.setColor(bad_brown);

            g.fillRect(0, 500, 500, 20);

            g.setColor(dark_blue);

            g.fillRect(0, 0, 500, 500);

            g.setColor(bad_brown);

            display_leaves(g);

            display_tree(g);

            Timer treeMoveTimer = new Timer(1, new ActionListener() {

            public void actionPerformed(ActionEvent event) {

                movePolygonBy(trapezoid1, 1);
                movePolygonBy(trapezoid2,1);
                movePolygonBy(triangle,1);
                movePolygonBy(trapezoid3,1);
                movePolygonBy(triangle2,1);
                movePolygonBy(trapezoid4,1);
                movePolygonBy(triangle3,1);
                movePolygonBy(trapezoid5,1);
                movePolygonBy(triangle4,1);
                movePolygonBy(triangle5,1);
                
                repaint();

            }
            });

        treeMoveTimer.start();

            Timer treeMoveTimer2 = new Timer(1, new ActionListener() {

            public void actionPerformed(ActionEvent event) {

                movePolygonBy(trapezoid1, -1);
                movePolygonBy(trapezoid2,-1);
                movePolygonBy(triangle,-1);
                movePolygonBy(trapezoid3,-1);
                movePolygonBy(triangle2,-1);
                movePolygonBy(trapezoid4,-1);
                movePolygonBy(triangle3,-1);
                movePolygonBy(trapezoid5,-1);
                movePolygonBy(triangle4,-1);
                movePolygonBy(triangle5,-1);

                repaint();

            }
            });

        treeMoveTimer2.start();

        }
        
        
        else if (current_season == winter) {

            g.setColor(grey);

            g.fillRect(0, 500, 500, 20);

            g.setColor(darkest_blue);

            g.fillRect(0, 0, 500, 500);

            display_tree(g);

        }

    }

    public void movePolygonBy (Polygon P, int dx) {

        for (int i = 0; i<P.xpoints.length; i++) {

            P.xpoints[i] = P.xpoints[i] + dx;

        }

        repaint();

    }


    class TimerListener implements ActionListener {


        public void actionPerformed(ActionEvent event) {

            movePolygonBy(trapezoid1, 1);
            movePolygonBy(trapezoid2,1);
            movePolygonBy(triangle,1);
            movePolygonBy(trapezoid3,1);
            movePolygonBy(triangle2,1);
            movePolygonBy(trapezoid4,1);
            movePolygonBy(triangle3,1);
            movePolygonBy(trapezoid5,1);
            movePolygonBy(triangle4,1);
            movePolygonBy(triangle5,1);

        }

    }

    public void changeCurrentSeason (int new_season) {

        current_season = new_season;

    }

    public void display_fruits (Graphics g) {

        g.setColor(Color.RED);

        g.fillOval(60, 200, 20, 20);

        g.fillOval(130, 150, 20, 20);

        g.fillOval(200, 100, 20, 20);

        g.fillOval(270, 150, 20, 20);

        g.fillOval(350, 100, 20, 20);

        g.fillOval(340, 200, 20, 20);

    }

    public void display_leaves (Graphics g) {


        g.fillOval(40, 50, 170, 160);

        g.fillOval(120, 60, 170, 160);

        g.fillOval(200, 90, 180, 180);

        g.fillOval(200, 60, 150, 150);

        g.fillOval(250, 60, 180, 180);

        g.fillOval(300, 90, 170, 170);

        g.fillOval(20, 110, 150, 150);

    }

    public void display_tree (Graphics g) {

        g.setColor(brown);
        g.fillPolygon(trapezoid1);
        g.fillPolygon(trapezoid2);
        g.fillPolygon(triangle);
        g.fillPolygon(trapezoid3);
        g.fillPolygon(triangle2);
        g.fillPolygon(trapezoid4);
        g.fillPolygon(triangle3);
        g.fillPolygon(trapezoid5);
        g.fillPolygon(triangle4);
        g.fillPolygon(triangle5);

    }
    
}

