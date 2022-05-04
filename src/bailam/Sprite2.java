package bailam;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Sprite2 extends NhanVat{

    @Override
    public BufferedImage initImage() {
        try {
            return ImageIO.read(getClass().getResource("\\anh\\anh2_msms.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    
    @Override
    public Image initAnhNen() {
           Image imageIcon = new ImageIcon(getClass().getResource("\\anhnen\\anhnen2.png")).getImage();
        
        return imageIcon;

    }
    
    @Override
    public Image initHieuUng() {
        Image imageIcon2 = new ImageIcon(getClass().getResource("\\hieuung\\hiclipart.com (1).png")).getImage();
        
        return imageIcon2;
    }
}