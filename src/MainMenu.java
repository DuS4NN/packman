
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dusan
 */
public class MainMenu extends JComponent implements ActionListener{
    
    protected boolean mute = false;
    private final Frame frame;
    private BufferedImage Logo;
    private Image Gif;
    private JButton b1, b2, b3;
    private ImageIcon B1, B2, B3, B4;
    
    public MainMenu(Frame frame){
        this.frame = frame;
        setBounds(0, 0, frame.getWidth(), frame.getHeight());
        loadImg();
        createButton();
    }
    
    public void loadImg(){
        try {
            Logo = ImageIO.read(getClass().getResourceAsStream("/Image/Logo2.png"));
            Gif = new ImageIcon(getClass().getResource("/Image/Gif.gif")).getImage();
            B1 = new ImageIcon(getClass().getResource("/Image/Button1.png"));
            B2 = new ImageIcon(getClass().getResource("/Image/Mute.png"));
            B3 = new ImageIcon(getClass().getResource("/Image/Unmute.png"));
            B4 = new ImageIcon(getClass().getResource("/Image/HighScore.png"));
        } catch (IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public void createButton(){
        b1 = new JButton("", B1);
        b1.setBounds((frame.getWidth()/2)-75, 500, 150, 70);
        b1.setSize(150,70);
        this.add(b1);
        b1.setActionCommand("Start");
        b1.addActionListener(this);
        
        b2 = new JButton("", B2);
        b2.setBounds((frame.getWidth()/2)-85, 600, 170, 100);
        b2.setSize(170,70);
        this.add(b2);
        b2.setActionCommand("Mute");
        b2.addActionListener(this);
        
        b3 = new JButton("", B4);
        b3.setBounds((frame.getWidth()/2)-145, 700, 290, 70);
        b3.setSize(290,70);
        this.add(b3);
        b3.setActionCommand("HighScore");
        b3.addActionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
        g.drawImage(Logo, frame.getWidth()/2-Logo.getWidth()/2, 100, this);
        g.drawImage(Gif, 65, 250, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Start")){
            frame.startGame();
            frame.remove(this);
            frame.repaint();
        }
        if(e.getActionCommand().equals("Mute")){           
            mute=!mute;
            if(mute){
                b2.setIcon(B3);
            }else{
                b2.setIcon(B2);
            }
        }
        if(e.getActionCommand().equals("HighScore")){
            frame.HighScore();
            frame.remove(this);
            frame.repaint();
        }
    }
    
    
    
}
