package bailam;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CreateSprite extends JPanel implements ActionListener{
    int i = 0;
    
    private Window owns;
    private NhanVat nv;
    private int tocdo;
    private int kichthuoc;
    
    public CreateSprite(Window owns, NhanVat nv, int tocdo, int kichthuoc) {
        this.owns = owns;
        this.nv = nv;
        this.tocdo = tocdo;
        this.kichthuoc = kichthuoc;
        initTimer();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        this.setOpaque(false);

        //lấy kích thước của ảnh lớn
        int crHinh = nv.initImage().getWidth(null);
        int cdHinh = nv.initImage().getHeight(null);
        
        //kích thước của 1 ảnh nhỏ trong ảnh lớn
        int xDich = crHinh / 4;
        int yDich = cdHinh / 8;

        if(i < 3)
            i++;
        else 
            i = 0;

        //lấy vị trí của con trỏ chuột
        PointerInfo info = MouseInfo.getPointerInfo();
        Point point = info.getLocation();
        int x = point.x;
        int y = point.y;
        
        int vtXWindow = owns.getX();
        int vtYWindow = owns.getY();

        int xDistance = x - vtXWindow - (kichthuoc / 2 + 3);
        int yDistance = y - vtYWindow - (kichthuoc / 2 + 3);

        double distance = Math.sqrt(xDistance * xDistance + yDistance * yDistance);
        
        int crHieuUng = nv.initHieuUng().getWidth(null);
        int cdHieuUng = nv.initHieuUng().getHeight(null);
        int kthuocHU = crHieuUng / 4;
            
        if (distance - kichthuoc > 1) {
            vtXWindow += xDistance * 0.05;
            vtYWindow += yDistance * 0.05;

            owns.setLocation(vtXWindow, vtYWindow);
            
            if(y > vtYWindow && vtXWindow <= x && x <= vtXWindow + kichthuoc)
                g.drawImage(nv.initImage(), 0, 0, kichthuoc, kichthuoc, i * xDich, 0, xDich * (i + 1), yDich, this);
            else if(y < vtYWindow  && vtXWindow <= x && x <= vtXWindow + kichthuoc)
                g.drawImage(nv.initImage(), 0, 0, kichthuoc, kichthuoc, i * xDich, yDich * 3, xDich * (i + 1), yDich * 4, this);
            else if(x < vtXWindow && vtYWindow <= y && y <= vtYWindow + kichthuoc)
                g.drawImage(nv.initImage(), 0, 0, kichthuoc, kichthuoc, i * xDich, yDich, xDich * (i + 1), yDich * 2, this);
            else if(x > vtXWindow && vtYWindow <= y && y <= vtYWindow + kichthuoc)
                g.drawImage(nv.initImage(), 0, 0, kichthuoc, kichthuoc, i * xDich, yDich * 2, xDich * (i + 1), yDich * 3, this);
            else if(y < vtYWindow && x > vtXWindow)
                g.drawImage(nv.initImage(), 0, 0, kichthuoc, kichthuoc, i * xDich, yDich * 7, xDich * (i + 1), yDich * 8, this);
            else if(y < vtYWindow && x < vtXWindow)
                g.drawImage(nv.initImage(), 0, 0, kichthuoc, kichthuoc, i * xDich, yDich * 5, xDich * (i + 1), yDich * 6, this);
            else if(y > vtYWindow && x < vtXWindow)
                g.drawImage(nv.initImage(), 0, 0, kichthuoc, kichthuoc, i * xDich, yDich * 4, xDich * (i + 1), yDich * 5, this);
            else if(y > vtYWindow && x > vtXWindow)
                g.drawImage(nv.initImage(), 0, 0, kichthuoc, kichthuoc, i * xDich, yDich * 6, xDich * (i + 1), yDich * 7, this);
        }
        else 
        {
            g.drawImage(nv.initImage(), 0, 0, kichthuoc, kichthuoc, 0, 0, xDich, yDich, this);
            g.drawImage(nv.initHieuUng(), 0, 0, kichthuoc, kichthuoc + 4, i * kthuocHU, 0, kthuocHU * (i + 1), cdHieuUng, this);
        }
    }
    
    private Timer timer;
    
    private void initTimer() {
        timer = new Timer(this.tocdo, this);
        timer.setInitialDelay(100);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    } 
}