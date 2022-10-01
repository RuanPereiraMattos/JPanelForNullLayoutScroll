import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JFrameForJPanelForNullLayoutScroll extends JFrame {

    public JFrameForJPanelForNullLayoutScroll() {
        setLayout(new AGroupLayout(this.getContentPane()));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);
    }

    private class AGroupLayout extends GroupLayout {

        public AGroupLayout(Container host) {
            super(host);
            setAutoCreateGaps(true);
            setAutoCreateContainerGaps(true);
            setHorizontalGroup(setHorizontalGroup());
            setVerticalGroup(setVerticalGroup());
            jpfnls.setLayout(null);
            jsp.getVerticalScrollBar().setUnitIncrement(8);
            Insets insets = jpfnls.getInsets();
            JLabel[] lbl = new JLabel[100];
            int y = 5 + insets.top;
            for (int i = 0; i < 100; i++) {
                lbl[i] = new JLabel("JLabel Num: " + i);
                Dimension d = lbl[i].getPreferredSize();
                lbl[i].setBounds(5 + insets.left, y, d.width, d.height);
                y += (5 + d.height);
                jpfnls.add(lbl[i]);
            }
        }

        private Group setHorizontalGroup() {
            return createSequentialGroup().addComponent(jsp);
        }

        private Group setVerticalGroup() {
            return createSequentialGroup().addComponent(jsp);
        }

        private JPanelForNullLayoutScroll jpfnls = new JPanelForNullLayoutScroll();
        private JScrollPane jsp = new JScrollPane(jpfnls, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        private class JPanelForNullLayoutScroll extends JPanel {

            int h;

            @Override
            public Dimension getPreferredSize() {
                if (getComponentCount() > 0) {
                    h = 0;
                    for (Component c : getComponents()) {
                        h += c.getHeight();
                    }
                } else {
                    h = 0;
                }
                Dimension d = new Dimension(getHeight(), h);
                return d;
            }

        }

    }

    public static void main(String[] args) {
        new A();
    }

}
