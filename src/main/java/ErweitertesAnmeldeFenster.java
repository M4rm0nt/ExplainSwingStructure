import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ErweitertesAnmeldeFenster {

    private static boolean isDispatchingEvent = false;

    public static void main(String[] args) {

        JFrame fenster = new JFrame("Erweitertes AnmeldeFenster");
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setSize(400, 300);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Optionen");
        JMenuItem menuItem = new JMenuItem("Beenden");
        menuItem.addActionListener(e -> System.exit(0));
        menu.add(menuItem);
        menuBar.add(menu);
        fenster.setJMenuBar(menuBar);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        fenster.setContentPane(contentPane);

        JLabel benutzerLabel = new JLabel("Benutzername:");
        benutzerLabel.setBounds(10, 20, 100, 25);
        contentPane.add(benutzerLabel);

        JTextField benutzerText = new JTextField(20);
        benutzerText.setBounds(120, 20, 165, 25);
        contentPane.add(benutzerText);

        JButton bestaetigenKnopf = new JButton("Bestätigen");
        bestaetigenKnopf.setBounds(10, 60, 120, 25);
        bestaetigenKnopf.addActionListener(e -> {
            JOptionPane.showMessageDialog(fenster, "Willkommen, " + benutzerText.getText() + "!");
            benutzerText.setText("");
        });
        contentPane.add(bestaetigenKnopf);

        JPanel glassPane = new JPanel() {
            public void paintComponent(Graphics g) {
                g.setColor(new Color(255, 255, 255, 100));
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };

        glassPane.setOpaque(false);
        AWTEventListener listener = event -> {
            if (event instanceof MouseEvent) {
                MouseEvent me = (MouseEvent) event;
                if (SwingUtilities.isDescendingFrom(me.getComponent(), fenster)) {
                    Point point = SwingUtilities.convertPoint(me.getComponent(), me.getPoint(), contentPane);
                    Component component = SwingUtilities.getDeepestComponentAt(contentPane, point.x, point.y);
                    if (component != null && component != me.getComponent()) {
                        Point componentPoint = SwingUtilities.convertPoint(contentPane, point, component);
                        component.dispatchEvent(new MouseEvent(component, me.getID(), me.getWhen(), me.getModifiersEx(), componentPoint.x, componentPoint.y, me.getClickCount(), me.isPopupTrigger(), me.getButton()));
                    }
                }
            }
        };

        Toolkit.getDefaultToolkit().addAWTEventListener(listener, AWTEvent.MOUSE_EVENT_MASK);
        fenster.setGlassPane(glassPane);
        glassPane.setVisible(true);
        Toolkit.getDefaultToolkit().addAWTEventListener(listener, AWTEvent.MOUSE_EVENT_MASK);
        fenster.setGlassPane(glassPane);
        glassPane.setVisible(true);

        fenster.setVisible(true);
    }
}
