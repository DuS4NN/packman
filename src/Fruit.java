
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.Timer;


public class Fruit extends JComponent implements ActionListener{
    
    private final int i;
    private final int j;
    Frame frame;
    private final String type;
    protected BufferedImage jahoda, ceresna, jablko, marhula;
    Timer t;
    
    public Fruit(int i, int j, String type, Frame frame){
        this.type = type;
        this.frame = frame;
        this.i = i;
        this.j = j;
        setBounds(i, j, Frame.l.Width, Frame.l.Width);
        t = new Timer(15000, this);
        t.start();
        loadImg();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch (type){
            case "jahoda": g.drawImage(jahoda, 0, 0, this); break;
            case "ceresna": g.drawImage(ceresna, 0, 0, this); break;
            case "jablko": g.drawImage(jablko, 0, 0, this); break;
            case "marhula": g.drawImage(marhula, 0, 0, this); break;
            default: break;
        }
    }
    
    public void loadImg(){
        try{
            jahoda = ImageIO.read(getClass().getResourceAsStream("/Image/Jahoda.png"));
            ceresna = ImageIO.read(getClass().getResourceAsStream("/Image/Ceresna.png"));
            jablko = ImageIO.read(getClass().getResourceAsStream("/Image/jablko.png"));
            marhula = ImageIO.read(getClass().getResourceAsStream("/Image/Marhula.png"));
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public int getPositionX(){
        return i;
    }
    public int getPositionY(){
        return j;
    }
    public String getType(){
        return type;
    }
    
    public void removeFruit(){
        frame.remove(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) { 
        if(Frame.Fruits.isEmpty()){
            return;
        }
        removeFruit();
        t.stop();
    }
    
    
    
}
