package bailam;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Window extends JFrame{
    public Window(NhanVat nv, int tocdo, int kichthuoc) {
        initComponent(nv, tocdo, kichthuoc);
        initEvent();
        initWindow(nv);
    }

    JMenuItem menuItem = new JMenuItem();
    JMenuItem exitItem = new JMenuItem();
    
    private void initComponent(NhanVat nv, int tocdo, int kichthuoc) {
        CreateSprite createsprite = new CreateSprite(this, nv, tocdo, kichthuoc);
        
        Container cp = this.getContentPane();
        cp.add(menuItem);
        cp.add(exitItem);
        cp.add(createsprite);
    }
    
    private void initEvent() {
  
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        menuItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                validate();
                repaint();
                removeAll();
                setVisible(false);
                new MainWindow();
            }
        });
  
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        exitItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
    }
    
    private void initWindow(NhanVat nv) {
        this.setIconImage(nv.initAnhNen());
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setAlwaysOnTop(true); 
        this.setSize(96, 96);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

