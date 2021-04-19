
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Info extends JComponent{
    
    protected BufferedImage gameover, level, ready, score, lives, paused, pacman,P0, P1, P2, P3, P4, P5, P6, P7, P8, P9;
    private BufferedImage ceresnaO, jablkoO, jahodaO, marhulaO;
    protected boolean ceresna = false, jablko = false, jahoda = false, marhula = false;

    public Info(){
        setBounds(0, 0, 761, 900);
        loadImg();
    }
    
    public void loadImg(){
        try { 
            gameover = ImageIO.read(getClass().getResourceAsStream("/Image/GameOver.png"));
            ready = ImageIO.read(getClass().getResourceAsStream("/Image/Ready.png"));
            score = ImageIO.read(getClass().getResourceAsStream("/Image/Score.png"));
            lives = ImageIO.read(getClass().getResourceAsStream("/Image/Lives.png"));
            paused = ImageIO.read(getClass().getResourceAsStream("/Image/Paused.png"));
            level = ImageIO.read(getClass().getResourceAsStream("/Image/Level.png"));
            pacman = ImageIO.read(getClass().getResourceAsStream("/Image/PacManLives.png"));
            P1 = ImageIO.read(getClass().getResourceAsStream("/Image/1.png")); P2 = ImageIO.read(getClass().getResourceAsStream("/Image/2.png"));
            P3 = ImageIO.read(getClass().getResourceAsStream("/Image/3.png")); P4 = ImageIO.read(getClass().getResourceAsStream("/Image/4.png")); 
            P5 = ImageIO.read(getClass().getResourceAsStream("/Image/5.png")); P6 = ImageIO.read(getClass().getResourceAsStream("/Image/6.png")); 
            P7 = ImageIO.read(getClass().getResourceAsStream("/Image/7.png")); P8 = ImageIO.read(getClass().getResourceAsStream("/Image/8.png")); 
            P9 = ImageIO.read(getClass().getResourceAsStream("/Image/9.png")); P0 = ImageIO.read(getClass().getResourceAsStream("/Image/0.png"));
            ceresnaO = ImageIO.read(getClass().getResourceAsStream("/Image/Ceresna.png")); jablkoO = ImageIO.read(getClass().getResourceAsStream("/Image/Jablko.png"));
            jahodaO = ImageIO.read(getClass().getResourceAsStream("/Image/Jahoda.png")); marhulaO = ImageIO.read(getClass().getResourceAsStream("/Image/Marhula.png"));        
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        if(Frame.p.gameover==true){
            g.drawImage(gameover, 283, 450, this);
        }
       if(Frame.p.paused==true){
            g.drawImage(paused, 317, 450, this);
        }
        if(Frame.p.start.isRunning()){
            g.drawImage(ready, 328, 450, this);
        }
        g.setColor(Color.BLACK);
        g.fillRect(0, 840, 761, 60);
        if(Frame.p.newlevel>0){
            g.drawImage(level, 315, 450, this);
            String lvl=Frame.lvl+"";
            for(int i=0; i<lvl.length();i++){
            String Char = lvl.substring(i, i+1);
            switch (Char){
                case "0": g.drawImage(P0, 315+120+i*20, 450, this); break;
                case "1": g.drawImage(P1, 315+120+i*20, 450, this); break;
                case "2": g.drawImage(P2, 315+120+i*20, 450, this); break; 
                case "3": g.drawImage(P3, 315+120+i*20, 450, this); break;
                case "4": g.drawImage(P4, 315+120+i*20, 450, this); break;
                case "5": g.drawImage(P5, 315+120+i*20, 450, this); break;
                case "6": g.drawImage(P6, 315+120+i*20, 450, this); break;
                case "7": g.drawImage(P7, 315+120+i*20, 450, this);break;
                case "8": g.drawImage(P8, 315+120+i*20, 450, this); break;
                case "9": g.drawImage(P9, 315+120+i*20, 450, this); break;
            }
        }
        }
        
        g.drawImage(score, 10, 859, this);
        String Score = Frame.score+"";
        for(int i=0; i<Score.length();i++){
            String Char = Score.substring(i, i+1);
            switch (Char){
                case "0": g.drawImage(P0, 150+i*20, 859, this); break;
                case "1": g.drawImage(P1, 150+i*20, 859, this); break;
                case "2": g.drawImage(P2, 150+i*20, 859, this); break; 
                case "3": g.drawImage(P3, 150+i*20, 859, this); break;
                case "4": g.drawImage(P4, 150+i*20, 859, this); break;
                case "5": g.drawImage(P5, 150+i*20, 859, this); break;
                case "6": g.drawImage(P6, 150+i*20, 859, this); break;
                case "7": g.drawImage(P7, 150+i*20, 859, this);break;
                case "8": g.drawImage(P8, 150+i*20, 859, this); break;
                case "9": g.drawImage(P9, 150+i*20, 859, this); break;
            }
        }
        g.drawImage(lives, 300, 859, this);
        for(int i=0; i<Frame.p.lives;i++){
            g.drawImage(pacman, 435+i*40, 852, this);
        }
        drawFruits(g);
    }
    
    public void drawFruits(Graphics g){
        int p=0;
        if(ceresna==true){
            g.drawImage(ceresnaO, 720, 852, this);
            p++;
        }
        if(jablko==true){
            g.drawImage(jablkoO, 720-p*50, 852, this);
            p++;
        }
        if(marhula==true){
            g.drawImage(marhulaO, 720-p*50, 852, this);
            p++;
        }
        if(jahoda==true){
            g.drawImage(jahodaO, 720-p*50, 852, this);
            p++;
        }
    }
    
    public void refresh(){
        Frame.info.repaint();
    }
    
}
