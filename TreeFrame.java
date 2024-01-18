import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TreeFrame extends JFrame {
    private TreePanel treePanel;

    public TreeFrame() {

        super("Four Seasons");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        treePanel = new TreePanel();
        add(treePanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);

        JButton spring_button = new JButton("Spring");
        JButton summer_button = new JButton("Summer");
        JButton fall_button = new JButton("Fall");
        JButton winter_button = new JButton("Winter");

        buttonPanel.add(spring_button);
        buttonPanel.add(summer_button);
        buttonPanel.add(fall_button);
        buttonPanel.add(winter_button);

        spring_button.addActionListener(new SeasonButtonListener(TreePanel.spring));
        summer_button.addActionListener(new SeasonButtonListener(TreePanel.summer));
        fall_button.addActionListener(new SeasonButtonListener(TreePanel.fall));
        winter_button.addActionListener(new SeasonButtonListener(TreePanel.winter));


        setSize(600, 700);

        this.pack();

    }

    private class SeasonButtonListener implements ActionListener {
        private int season;

        public SeasonButtonListener(int season) {
            this.season = season;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
            treePanel.changeCurrentSeason(season);

            repaint();
        }
    }

    public static void main(String[] args) {

        TreeFrame frame = new TreeFrame();


        frame.setVisible(true);
        frame.pack();


    }
}

