
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JComponent;
import javax.swing.Timer;

public class PacMan extends JComponent implements KeyListener, ActionListener{
    
    private BufferedImage PacManH, PacManD, PacManP, PacManL, PacManC; 
    private AudioInputStream beginning, chomp, death, eatfruit, eatghost;
    private int i;
    private int j;
    protected int newlevel=0; 
    protected boolean gameover = false;
    protected int time=0;
    protected boolean shield = false;
    private String move="L";
    private int animation=1;
    protected int lives=3;
    private String lastmove="L";
    protected int eatGhosts = 0;
    private Frame frame;
    protected boolean paused = false;
    private final Timer timerShield;
    private final Timer timer;
    protected Timer start;
    
    
    public PacMan(int i, int j){
        setBounds(i, j, 40, 40);
        addKeyListener(this);
        setFocusable(true);  
        loadImg();
        loadSounds();
        playBEGINNING();
        timerShield = new Timer(60, this);
        timer = new Timer(60, this);
        start = new Timer(4000,this);
        start.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        if(animation==1 || animation==2){
            switch (lastmove) {
                case "H":
                    g.drawImage(PacManH, 0, 0, this); break;
                case "D":
                    g.drawImage(PacManD, 0, 0, this);  break;
                case "P":
                    g.drawImage(PacManP, 0, 0, this);  break;
                case "L":
                    g.drawImage(PacManL, 0, 0, this);  break;
                default:
                    break;
            }
        }else{
            g.drawImage(PacManC, 0, 0, this);
        }
    }
    
    public void loadImg(){
        try{
            PacManH = ImageIO.read(getClass().getResourceAsStream("/Image/PacManH.png")); 
            PacManD = ImageIO.read(getClass().getResourceAsStream("/Image/PacManD.png")); 
            PacManP = ImageIO.read(getClass().getResourceAsStream("/Image/PacManP.png")); 
            PacManL = ImageIO.read(getClass().getResourceAsStream("/Image/PacManL.png")); 
            PacManC = ImageIO.read(getClass().getResourceAsStream("/Image/PacManC.png")); 
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public int getPositionX(){
        return getX();
    }
    public int getPositionY(){
        return getY();
    }
    
    public void nextLevel(){
        newlevel=1;
        Frame.info.refresh();
        setLocation(360, 600);
        for(Ghost g : Frame.Ghosts){
            g.teleportSpawn();
        }
            
        shield=false;
        Labyrint.Points.clear();
        Labyrint.SpecialPoints.clear();
        setLocation(360, 600);
        for(int i=0; i<Labyrint.row;i++){
            for(int j=0; j<Labyrint.col;j++){
                if(Labyrint.Labyrint.get(i).toString().substring(j,j+1).equals(" ")){
                    Point p = new Point(i, j);
                    add(p);
                    Labyrint.Points.add(p);
                }
            }
        }
        int X[] = {1,17,1,17};
        int Y[] = {3,3,18,18};
        for(int i=0; i<X.length; i++){
            SpecialPoint sp = new SpecialPoint(X[i], Y[i]);
            add(sp);
            Frame.l.SpecialPoints.add(sp);
        }
        
        Graphics g = getGraphics();
        Frame.l.drawPoints(g);
        Frame.l.drawSpecialPoints(g);
        Frame.lvl++;
    }
    
    public void playCHOMP(){
        if(Frame.mm.mute==true){
            return;
        }
        AudioInputStream stream;
        AudioFormat format;
        DataLine.Info info;
        Clip clip;
        try {
            stream = AudioSystem.getAudioInputStream(getClass().getResource("/Sounds/chomp.wav"));
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
         } catch (IOException | LineUnavailableException ex) {
           System.out.println(ex.getMessage());
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(PacMan.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    public void playBEGINNING(){
        if(Frame.mm.mute==true){
            return;
        }
       AudioInputStream stream;
        AudioFormat format;
        DataLine.Info info;
        Clip clip;
        try {
            stream = AudioSystem.getAudioInputStream(getClass().getResource("/Sounds/beginning.wav"));
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
         } catch (IOException | LineUnavailableException ex) {
           System.out.println(ex.getMessage());
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(PacMan.class.getName()).log(Level.SEVERE, null, ex);
        }    
            
      
    }
    public void playDEATH(){
        if(Frame.mm.mute==true){
            return;
        }
         AudioInputStream stream;
        AudioFormat format;
        DataLine.Info info;
        Clip clip;
        try {
            stream = AudioSystem.getAudioInputStream(getClass().getResource("/Sounds/death.wav"));
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
         } catch (IOException | LineUnavailableException ex) {
           System.out.println(ex.getMessage());
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(PacMan.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    public void playEATFRUIT(){
        if(Frame.mm.mute==true){
            return;
        }
         AudioInputStream stream;
        AudioFormat format;
        DataLine.Info info;
        Clip clip;
        try {
            stream = AudioSystem.getAudioInputStream(getClass().getResource("/Sounds/eatfruit.wav"));
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
         } catch (IOException | LineUnavailableException ex) {
           System.out.println(ex.getMessage());
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(PacMan.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    public void playEATGHOST(){
        if(Frame.mm.mute==true){
            return;
        }
         AudioInputStream stream;
        AudioFormat format;
        DataLine.Info info;
        Clip clip;
        try {
            stream = AudioSystem.getAudioInputStream(getClass().getResource("/Sounds/eatghost.wav"));
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
         } catch (IOException | LineUnavailableException ex) {
           System.out.println(ex.getMessage());
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(PacMan.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void loadSounds(){
        try { 
            beginning = AudioSystem.getAudioInputStream(getClass().getResource("/Sounds/beginning.wav"));
            chomp = AudioSystem.getAudioInputStream(getClass().getResource("/Sounds/chomp.wav"));
            death = AudioSystem.getAudioInputStream(getClass().getResource("/Sounds/death.wav"));
            eatfruit = AudioSystem.getAudioInputStream(getClass().getResource("/Sounds/eatfruit.wav"));
            eatghost = AudioSystem.getAudioInputStream(getClass().getResource("/Sounds/eatghost.wav"));           
        } catch(IOException | UnsupportedAudioFileException ex) {
            System.out.println(ex.getMessage());
        }
    } 

    public void eatPoint(){
        for(int a=0; a<Frame.l.Points.size();a++){
            Point p = Frame.l.Points.get(a);
            if(getX()==p.getPositionX() && getY() == p.getPositionY()){
                Frame.l.Points.remove(a);
                this.remove(p);
                Frame.score += 10;
                Frame.info.refresh();
                playCHOMP();
                if(Frame.l.Points.isEmpty()){
                    nextLevel();
                }
            }
        }
        for(int b=0; b<Frame.l.SpecialPoints.size();b++){
            SpecialPoint sp = Frame.l.SpecialPoints.get(b);
            if(getX()==sp.getPositionX() && getY()==sp.getPositionY()){
                time=0;
                Frame.l.SpecialPoints.remove(b);
                this.remove(sp);
                Frame.score += 50;
                timerShield.start();
                timer.stop();
                shield();
                Frame.info.refresh();
            }
        }
        /*if(Frame.Fruits.isEmpty()){
            return;
        }*/
        for(int c=0; c<Frame.Fruits.size();c++){
            Fruit f = Frame.Fruits.get(c);
            if(getX()==f.getPositionX() && getY()==f.getPositionY()){               
               switch (f.getType()) {
                   case "jahoda":
                       Frame.info.jahoda=true; Frame.score += 2000;
                       break; 
                   case "ceresna":
                       Frame.info.ceresna=true; Frame.score += 500;
                       break;
                   case "jablko":
                       Frame.info.jablko=true; Frame.score += 1000;
                       break;
                   case "marhula":
                       Frame.info.marhula=true; Frame.score += 1500;
                       break;
                   default:
                       break;
               }
               Frame.Fruits.remove(c);
               this.remove(f);
               f.removeFruit();
               playEATFRUIT();
           }
           Frame.info.refresh();
        }
    }  
    
    public void reverse(int[] numArray) {
        int n = numArray.length;
    int temp = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 1; j < (n - i); j++) {

            if (numArray[j - 1] < numArray[j]) {
                temp = numArray[j - 1];
                numArray[j - 1] = numArray[j];
                numArray[j] = temp;
            }

        }
    }
    }
    public void saveHighScore(){
        int a=0;
        int hscores[] = new int[11];
        try{
            FileReader fr = new FileReader("Score.txt");
            BufferedReader br = new BufferedReader(fr); 
            String riadok="";
            while(riadok!=null){
                riadok = br.readLine();
                if(riadok!=null){
                    hscores[a]=Integer.parseInt(riadok);
                }
                a++;
            }
            br.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        hscores[10]=Frame.score;
        reverse(hscores);
        try{
            FileWriter fw = new FileWriter("Score.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i=0; i<hscores.length-1;i++){
                bw.write(hscores[i]+"");
                bw.newLine();
            }
            
            bw.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public void gameOver(){
        if(lives==0){
            gameover=true;
            lives=0;
            timer.stop();
            saveHighScore();
            Frame.score=0;
        }else{
            start.start();
            timer.stop();
            lives--;
            move="L";
            lastmove="L";
            animation=1;
            setLocation(360, 600);
            for(Ghost g : Frame.Ghosts){
                g.teleportSpawn();
            }
        }
        playDEATH();
        Frame.info.refresh();
    }
    
    public void eatPacMan(){
        for(Ghost g : Frame.Ghosts){
            g.eat();
        }
    }
    
    public void shield(){
        if(time==0){
            shield=true;
        }else if(time==150){
            timerShield.stop();
            timer.start();
            shield=false;
            time=0;
        }
    }
    
    public void move(){
        int row = getY()/Frame.l.Width;
        int col = getX()/Frame.l.Width;
        
        if(move.equals("H")){
            if(!Frame.l.Labyrint.get(row-1).toString().substring(col, col+1).equals("*")){
                if(getX()%40==0 && getY()%40==0){
                    setLocation(getX(), getY()-8);
                lastmove="H";
                }else lastmove();
            }else lastmove();
            eatPoint();
            shortCut();
        }else if(move.equals("D")){
            if(!Frame.l.Labyrint.get(row+1).toString().substring(col, col+1).equals("*")){
                if(getX()%40==0 && getY()%40==0){
                    setLocation(getX(), getY()+8);
                lastmove="D";
                }else lastmove();
            }else lastmove();
            eatPoint();
            shortCut();
        }else if(move.equals("P")){
            if(!Frame.l.Labyrint.get(row).toString().substring(col+1, col+2).equals("*")){
                if(getX()%40==0 && getY()%40==0){
                    setLocation(getX()+8, getY());
                lastmove="P";
                }else lastmove();
            }else lastmove();
            eatPoint();
            shortCut();
        }else if(move.equals("L")){
           if(!Frame.l.Labyrint.get(row).toString().substring(col-1, col).equals("*")){
                if(getX()%40==0 && getY()%40==0){
                    setLocation(getX()-8, getY());
                    lastmove="L";
                }else lastmove();
            }else lastmove();           
            eatPoint();
            shortCut();
        }
    }
    
    public void lastmove(){
        int row = getY()/Frame.l.Width;
        int col = getX()/Frame.l.Width;      
        if(lastmove.equals("H")){
            if(getX()%40==0 && getY()%40==0){
                if(!Frame.l.Labyrint.get(row-1).toString().substring(col, col+1).equals("*")){
                    setLocation(getX(), getY()-8);
                }    
            }else{
                setLocation(getX(), getY()-8);
            }
            
        }else if(lastmove.equals("D")){
            if(getX()%40==0 && getY()%40==0){
                if(!Frame.l.Labyrint.get(row+1).toString().substring(col, col+1).equals("*")){
                    setLocation(getX(), getY()+8);
                }
            }else{
                setLocation(getX(), getY()+8);
            }
           
        }else if(lastmove.equals("P")){
            if(getX()%40==0 && getY()%40==0){
                if(!Frame.l.Labyrint.get(row).toString().substring(col+1, col+2).equals("*")){
                    setLocation(getX()+8, getY());
                }
            }else{
                setLocation(getX()+8, getY());
            }
            
        }else{
            if(getX()%40==0 && getY()%40==0){
                if(!Frame.l.Labyrint.get(row).toString().substring(col-1, col).equals("*")){
                    setLocation(getX()-8, getY());
                }
            }else{
                setLocation(getX()-8, getY());
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==112 || e.getKeyCode()==80){
            if(gameover==true) return;
            if(start.isRunning()) return;    
            if(paused==false){
                paused = true;
                timerShield.stop();
                timer.stop();
            }else{
                paused = false;
                if(shield==true) timerShield.start();
                else timer.start();
            }
            Frame.info.refresh();
        }
        if(gameover==false){  
                switch (e.getKeyCode()) {
                    case 39:
                        move="P";
                        break;
                    case 37:
                        move="L";
                        break;
                    case 40:
                        move="D";
                        break;
                    case 38:
                        move="H";
                        break;
                    default:
                        break;
                }
            
        }
    }
    
    public void shortCut(){
        if(getX()==680 && getY()==360){
            setLocation(80, 360);
            eatPoint();
        }else if(getX()==40 && getY()==360){
            setLocation(640, 360);
            eatPoint();
        }
    } 
    
    @Override
    public void keyReleased(KeyEvent e) { 
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(newlevel>0){
            newlevel++;
        }
        if(newlevel==20)newlevel=0;
        
        animation++;
        if(animation==4){
            animation=0;
        }
        if(timerShield.isRunning()){
           time++;
           shield();
        }
        repaint();
        move();
        if(start.isRunning()){
            timer.start();
            start.stop();
        }
        eatPacMan();
    }
    
}
