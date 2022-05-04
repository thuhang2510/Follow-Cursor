package bailam;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Sprite3 extends NhanVat{

    @Override
    public BufferedImage initImage() {
        try {
            return ImageIO.read(getClass().getResource("\\anh\\anh4.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
        
    @Override
    public Image initAnhNen() {
        Image imageIcon = new ImageIcon(getClass().getResource("\\anhnen\\anhnen3.png")).getImage();
        
        return imageIcon;

    }
    
    @Override
    public Image initHieuUng() {
        Image imageIcon2 = new ImageIcon(getClass().getResource("\\hieuung\\hieuung2.png")).getImage();
        
        return imageIcon2;
    }
}
