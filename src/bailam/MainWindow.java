package bailam;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainWindow extends JFrame{
    public MainWindow() {
        initComponent();
        initEvent();
        initWindow();
    }
    
    ChooseNhanvat lcSprite = new ChooseNhanvat();

    int sl = lcSprite.slSprite();
    JRadioButton[] rb = new JRadioButton[sl];
    
    JLabel labAnhNen = new JLabel();
    JSlider sliTocDo = new JSlider(0, 200, 0);
    JSlider sliKichThuoc = new JSlider(32, 96, 32);
    JButton btnOK = new JButton("OK");
    JButton btnCancel = new JButton("Cancel");
    ButtonGroup bg = new ButtonGroup();
    Image image;

    private void initComponent() {
        JPanel tagcon = new JPanel();
        JPanel tag2 = new JPanel();
        JPanel tag1 = new JPanel();

        for(int i = 0; i < sl; ++i)
        {
            rb[i] = new JRadioButton("hình" + (1 + i), true);
            bg.add(rb[i]);
            tagcon.add(rb[i]);
        }
        
        image = new ImageIcon(getClass().getResource("\\anhnen\\" + "anhnen1.png")).getImage();
        ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        labAnhNen.setIcon(imageIcon);
        
        tag1.setLayout(null);
        tag1.add(labAnhNen);
        tag1.add(tagcon);
        
        tagcon.setBounds(0, 0, 260, 260);
        labAnhNen.setBounds(78, 80, 100, 100);
        
        JLabel lbl1 = new JLabel("Tốc độ");
        JLabel lbl2 = new JLabel("Nhanh");
        JLabel lbl3 = new JLabel("Chậm");
        
        JLabel lbl4 = new JLabel("Kích Thước");
        JLabel lbl5 = new JLabel("Nhỏ");
        JLabel lbl6 = new JLabel("To");
        
        tag2.setLayout(null);
        tag2.add(lbl1);
        tag2.add(lbl2);
        tag2.add(lbl3);
        tag2.add(sliTocDo);
        tag2.add(lbl4);
        tag2.add(lbl5);
        tag2.add(lbl6);
        tag2.add(sliKichThuoc);
        
        lbl1.setBounds(15, 10, 100, 34);
        lbl2.setBounds(33, 37, 100, 34);
        lbl3.setBounds(199, 37, 100, 34);
        sliTocDo.setBounds(33, 61, 200, 34);
        lbl4.setBounds(15, 111, 100, 34);
        lbl5.setBounds(33, 138, 100, 34);
        lbl6.setBounds(205, 138, 100, 34);
        sliKichThuoc.setBounds(33, 162, 200, 34);
        
        lbl1.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
        lbl4.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
        
        JTabbedPane tp = new JTabbedPane();
        tp.add("hinh", tag1);
        tp.add("cài đặt", tag2);
        tp.setBounds(5,0, 260,260);
        
        Container cp = this.getContentPane();
        cp.setLayout(null);
        cp.add(tp);
        cp.add(btnOK);
        cp.add(btnCancel);
        
        btnOK.setBounds(170, 270, 55, 37);
        btnCancel.setBounds(230, 270, 75, 37);
    }
    
    boolean dachon = false;
    
    private void initEvent() {
        ActionListener rbAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < sl; ++i)
                {
                    if(e.getSource() == rb[i])
                    {
                        image = lcSprite.luaChon(i + 1).initAnhNen();
                        labAnhNen.setIcon(new ImageIcon(image.getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
                        setIconImage(image);
                    }    
                }
            }
        };
        
        for (int i = 0; i < sl; ++i) {
            rb[i].addActionListener(rbAction);
        }

        sliTocDo.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent event) { 
//                lbl.setText(String.valueOf(sliTocDo.getValue()));
            }
        });
        
        sliKichThuoc.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent event) { 

            }
        });
        
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                for (int i = 0; i < sl; ++i) {
                    if(rb[i].isSelected())
                    {
                        setVisible(false);
                        new Window(lcSprite.luaChon(i + 1), sliTocDo.getValue(), sliKichThuoc.getValue());
                        dachon = true;
                        break;
                    }
                }
                
                if(dachon == false)
                {
                    JOptionPane.showMessageDialog(new JFrame(),"Bạn chưa chọn nhân vật nào.","Cảnh báo",JOptionPane.WARNING_MESSAGE); 
                }
            }
        });
        
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 int a = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc hủy ko?");
                 
                 if(a == JOptionPane.YES_OPTION)
                 {
                     bg.clearSelection();
                     labAnhNen.setIcon(null);
                     setIconImage(null);
                     sliTocDo.setValue(0);
                     sliKichThuoc.setValue(32);
                 }
            }
        });
    }
    
    private void initWindow() {
        this.setIconImage(image);
        this.setLocationRelativeTo(null);
        this.setSize(340, 370);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
}
