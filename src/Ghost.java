
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.Timer;

public class Ghost extends JComponent implements ActionListener{
    
    private BufferedImage BlinkyH1, BlinkyD1, BlinkyP1, BlinkyL1, BlinkyH2, BlinkyD2, BlinkyP2, BlinkyL2,
                    InkyH1, InkyD1, InkyP1, InkyL1, InkyH2, InkyD2, InkyP2, InkyL2,
                    ClydeH1, ClydeD1, ClydeP1, ClydeL1, ClydeH2, ClydeD2, ClydeP2, ClydeL2,
                    PinkyH1, PinkyD1, PinkyP1, PinkyL1, PinkyH2, PinkyD2, PinkyP2, PinkyL2,
                    Ghost11, Ghost21, Ghost12, Ghost22;
    private final int i;
    private final int j;
    private final String name;
    private String lastMove="H";
    private String move;
    private int anima = 1;
    Timer t;
    
    public Ghost(int i, int j, String name, String move){
        this.i = i;
        this.j = j;
        this.move = move;
        this.name = name;
        setBounds(0, 0, 1000, 1000);
        loadImg();
        t = new Timer(60, this);
        t.start();
        setLocation(i, j);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);   
        if(Frame.p.shield==false){
            if(name.equals("Blinky")){
                if(anima==1){
                    if(move.equals("H")) g.drawImage(BlinkyH1, 0, 0, this);  
                    else if(move.equals("D")) g.drawImage(BlinkyD1, 0, 0, this);
                    else if(move.equals("L")) g.drawImage(BlinkyL1, 0, 0, this);
                    else if(move.equals("P")) g.drawImage(BlinkyP1, 0, 0, this);
                }else{
                    if(move.equals("H")) g.drawImage(BlinkyH2, 0, 0, this);  
                    else if(move.equals("D")) g.drawImage(BlinkyD2, 0, 0, this);
                    else if(move.equals("L")) g.drawImage(BlinkyL2, 0, 0, this);
                    else if(move.equals("P")) g.drawImage(BlinkyP2, 0, 0, this);
                }
            }else if(name.equals("Inky")){
                if(anima==1){
                    if(move.equals("H")) g.drawImage(InkyH1, 0, 0, this);  
                    else if(move.equals("D")) g.drawImage(InkyD1, 0, 0, this);
                    else if(move.equals("L")) g.drawImage(InkyL1, 0, 0, this);
                    else if(move.equals("P")) g.drawImage(InkyP1, 0, 0, this);
                }else{
                    if(move.equals("H")) g.drawImage(InkyH2, 0, 0, this);  
                    else if(move.equals("D")) g.drawImage(InkyD2, 0, 0, this);
                    else if(move.equals("L")) g.drawImage(InkyL2, 0, 0, this);
                    else if(move.equals("P")) g.drawImage(InkyP2, 0, 0, this);
                }
            }else if(name.equals("Clyde")){
                if(anima==1){
                     if(move.equals("H")) g.drawImage(ClydeH1, 0, 0, this);  
                    else if(move.equals("D")) g.drawImage(ClydeD1, 0, 0, this);
                    else if(move.equals("L")) g.drawImage(ClydeL1, 0, 0, this);
                    else if(move.equals("P")) g.drawImage(ClydeP1, 0, 0, this);
                }else{
                     if(move.equals("H")) g.drawImage(ClydeH2, 0, 0, this);  
                    else if(move.equals("D")) g.drawImage(ClydeD2, 0, 0, this);
                    else if(move.equals("L")) g.drawImage(ClydeL2, 0, 0, this);
                    else if(move.equals("P")) g.drawImage(ClydeP2, 0, 0, this);
                }
            }else if(name.equals("Pinky")){
                if(anima==1){
                     if(move.equals("H")) g.drawImage(PinkyH1, 0, 0, this);  
                    else if(move.equals("D")) g.drawImage(PinkyD1, 0, 0, this);
                    else if(move.equals("L")) g.drawImage(PinkyL1, 0, 0, this);
                    else if(move.equals("P")) g.drawImage(PinkyP1, 0, 0, this);
                }else{
                     if(move.equals("H")) g.drawImage(PinkyH2, 0, 0, this);  
                    else if(move.equals("D")) g.drawImage(PinkyD2, 0, 0, this);
                    else if(move.equals("L")) g.drawImage(PinkyL2, 0, 0, this);
                    else if(move.equals("P")) g.drawImage(PinkyP2, 0, 0, this);
                }
               
            } 
        }else{
            if(Frame.p.time==130 ||Frame.p.time==135 || Frame.p.time==140 || Frame.p.time==180 || Frame.p.time==145 || Frame.p.time==150){
                if(anima==1){
                    g.drawImage(Ghost21, 0, 0, this);
                }else{
                    g.drawImage(Ghost22, 0, 0, this);
                }
            }else{
                if(anima==1){
                    g.drawImage(Ghost11, 0, 0, this);
                }else{
                    g.drawImage(Ghost12, 0, 0, this);
                }
            }
            
        }
    }

    public void loadImg(){
        try{
            BlinkyH1 = ImageIO.read(getClass().getResourceAsStream("/Image/BlinkyH1.png"));  BlinkyD1 = ImageIO.read(getClass().getResourceAsStream("/Image/BlinkyD1.png"));  BlinkyP1 = ImageIO.read(getClass().getResourceAsStream("/Image/BlinkyP1.png")); BlinkyL1 = ImageIO.read(getClass().getResourceAsStream("/Image/BlinkyL1.png"));
            ClydeH1 = ImageIO.read(getClass().getResourceAsStream("/Image/ClydeH1.png"));  ClydeD1 = ImageIO.read(getClass().getResourceAsStream("/Image/ClydeD1.png")); ClydeP1 = ImageIO.read(getClass().getResourceAsStream("/Image/ClydeP1.png"));  ClydeL1 = ImageIO.read(getClass().getResourceAsStream("/Image/ClydeL1.png"));
            InkyH1 = ImageIO.read(getClass().getResourceAsStream("/Image/InkyH1.png")); InkyD1 = ImageIO.read(getClass().getResourceAsStream("/Image/InkyD1.png")); InkyP1 = ImageIO.read(getClass().getResourceAsStream("/Image/InkyP1.png")); InkyL1 = ImageIO.read(getClass().getResourceAsStream("/Image/InkyL1.png"));
            PinkyH1 = ImageIO.read(getClass().getResourceAsStream("/Image/PinkyH1.png")); PinkyD1 = ImageIO.read(getClass().getResourceAsStream("/Image/PinkyD1.png")); PinkyP1 = ImageIO.read(getClass().getResourceAsStream("/Image/PinkyP1.png")); PinkyL1 = ImageIO.read(getClass().getResourceAsStream("/Image/PinkyL1.png"));                        
            Ghost11 = ImageIO.read(getClass().getResourceAsStream("/Image/Ghost11.png")); Ghost21 = ImageIO.read(getClass().getResourceAsStream("/Image/Ghost21.png")); 
            BlinkyH2 = ImageIO.read(getClass().getResourceAsStream("/Image/BlinkyH2.png"));  BlinkyD2 = ImageIO.read(getClass().getResourceAsStream("/Image/BlinkyD2.png"));  BlinkyP2 = ImageIO.read(getClass().getResourceAsStream("/Image/BlinkyP2.png")); BlinkyL2 = ImageIO.read(getClass().getResourceAsStream("/Image/BlinkyL2.png"));
            ClydeH2 = ImageIO.read(getClass().getResourceAsStream("/Image/ClydeH2.png"));  ClydeD2 = ImageIO.read(getClass().getResourceAsStream("/Image/ClydeD2.png")); ClydeP2 = ImageIO.read(getClass().getResourceAsStream("/Image/ClydeP2.png"));  ClydeL2 = ImageIO.read(getClass().getResourceAsStream("/Image/ClydeL2.png"));
            InkyH2 = ImageIO.read(getClass().getResourceAsStream("/Image/InkyH2.png")); InkyD2 = ImageIO.read(getClass().getResourceAsStream("/Image/InkyD2.png")); InkyP2 = ImageIO.read(getClass().getResourceAsStream("/Image/InkyP2.png")); InkyL2 = ImageIO.read(getClass().getResourceAsStream("/Image/InkyL2.png"));
            PinkyH2 = ImageIO.read(getClass().getResourceAsStream("/Image/PinkyH2.png")); PinkyD2 = ImageIO.read(getClass().getResourceAsStream("/Image/PinkyD2.png")); PinkyP2 = ImageIO.read(getClass().getResourceAsStream("/Image/PinkyP2.png")); PinkyL2 = ImageIO.read(getClass().getResourceAsStream("/Image/PinkyL2.png"));                        
            Ghost11 = ImageIO.read(getClass().getResourceAsStream("/Image/Ghost11.png")); Ghost21 = ImageIO.read(getClass().getResourceAsStream("/Image/Ghost21.png")); 
            Ghost12 = ImageIO.read(getClass().getResourceAsStream("/Image/Ghost12.png")); Ghost22 = ImageIO.read(getClass().getResourceAsStream("/Image/Ghost22.png")); 
        }catch(IOException e){
            e.getMessage();
        }
    }
    
    public void continueInMove(){
            switch(lastMove){
            case "H": setLocation(getX(), getY()-8); break;
            case "D": setLocation(getX(), getY()+8); break;
            case "L": setLocation(getX()-8, getY()); break;
            case "P": setLocation(getX()+8, getY()); break; 
            default: break;
        }
    }
    
    public void move(){ 
        String vyhodit="";
        move = "";
        int riadok = getY()/Frame.l.Width;
        int stlpec= getX()/Frame.l.Width;    
        
        if(!Frame.l.Labyrint.get(riadok-1).toString().substring(stlpec, stlpec+1).equals("*")){
            move="H"+move;             
        } if(!Frame.l.Labyrint.get(riadok+1).toString().substring(stlpec, stlpec+1).equals("*")){
            move="D"+move;  
        }if(!Frame.l.Labyrint.get(riadok).toString().substring(stlpec+1, stlpec+2).equals("*")){
            move="P"+move;
        }if(!Frame.l.Labyrint.get(riadok).toString().substring(stlpec-1, stlpec).equals("*")){
            move="L"+move;
        }      
        switch(lastMove){
            case "H": vyhodit="D"; break;  
            case "D": vyhodit="H"; break;  
            case "P": vyhodit="L"; break;  
            case "L": vyhodit="P"; break;  
            default: break;  
        }       
        if(move.length()==4){
            int pom=0;
            int index = move.indexOf(vyhodit);
            if(index!=-1){
                move=move.substring(0, index)+move.substring(index+1, move.length());
                pom = (int) (Math.random()*5);
            }else{
                pom = (int) (Math.random()*6);
            }
            move=move+lastMove+lastMove;
            move = move.substring(pom,pom+1); 
            lastMove = move;
        }else if(move.length()==3){ 
            int pom=0;
            int index = move.indexOf(vyhodit);
            if(index!=-1){
                move=move.substring(0, index)+move.substring(index+1, move.length());
                if(move.indexOf(lastMove, 0)!=-1){ 
                    pom = (int) (Math.random()*3);
                    move = move+lastMove; 
                }else{
                    pom = (int) (Math.random()*2);
                }
            }else{
                if(move.indexOf(lastMove, 0)!=-1){ 
                    pom = (int) (Math.random()*4);
                    move = move+lastMove; 
                }else{
                    pom = (int) (Math.random()*3);
                }
            }
            move = move.substring(pom,pom+1); 
            lastMove = move;    
        }else if(move.length()==2){
            int pom=0;
            int index = move.indexOf(vyhodit);
            if(index!=-1){
                move=move.substring(0, index)+move.substring(index+1, move.length());
                if(move.indexOf(lastMove, 0)!=-1){
                    pom = (int) (Math.random()*2);
                    move = move+lastMove;
                }else{
                    pom = (int) (Math.random()*1); 
                }
            }else{
                if(move.indexOf(lastMove, 0)!=-1){
                    pom = (int) (Math.random()*3);
                    move = move+lastMove;
                }else{
                    pom = (int) (Math.random()*2); 
                } 
            }
                move = move.substring(pom,pom+1); 
                lastMove = move;    
        }else if(move.length()==1){            
            lastMove = move;
        }
        switch(move){
            case "H": setLocation(getX(), getY()-8); lastMove="H"; break;
            case "D": setLocation(getX(), getY()+8); lastMove="D"; break;
            case "L": setLocation(getX()-8, getY()); lastMove="L"; break;
            case "P": setLocation(getX()+8, getY()); lastMove="P"; break;
            default: break;
        } 
    }

    public void find(){
        int row = getY()/Frame.l.Width;
        int col= getX()/Frame.l.Width; 
        //SKRATKA
        if(getX()==680 && getY()==360){
            setLocation(80, 360);
        }else if(getX()==40 && getY()==360){
            setLocation(640, 360);
        }
        //AK NEVIDIM 
       if(see()==false){
            if(getX()%40==0 && getY()%40==0){
                move();
            }else{
                continueInMove();
            }
            //AK VIDIM----------------------------------------------------------
            
            
        }else{ 
           if(getX()==Frame.p.getPositionX()){
               if(getY()>Frame.p.getPositionY()){
               //VIDIM HO HORE
                        if(!Frame.l.Labyrint.get(row-1).toString().substring(col, col+1).equals("*")){
                            setLocation(getX(), getY()-8); lastMove="H"; move="H";
                        }else{
                            move();
                        }
               }else{
               //VIDIM HO DOLE 
                        if(!Frame.l.Labyrint.get(row+1).toString().substring(col, col+1).equals("*")){
                            setLocation(getX(), getY()+8); lastMove="D"; move="D";
                        }else{
                            move();
                        }
                    }
               
               
               
           }else{
                if(getX()>Frame.p.getPositionX()){
                //VIDIM HO VLAVO
                    if(!Frame.l.Labyrint.get(row).toString().substring(col-1, col).equals("*")){
                        setLocation(getX()-8, getY()); lastMove="L"; move="L";
                    }else{
                        move();
                        }
                }else{
                //VIDIM HO VPRAVO
                    if(!Frame.l.Labyrint.get(row).toString().substring(col+1, col+2).equals("*")){
                            setLocation(getX()+8, getY()); lastMove="P"; move="P";
                    }else{
                        move();
                    }
                }
           } 
       }
    }
    
    public boolean see(){
        int riadok = getY()/Frame.l.Width;
        int stlpec= getX()/Frame.l.Width;  
        if(Frame.p.shield==true){
            return false;
        }
        if(Frame.p.getPositionX()%40!=0 && Frame.p.getPositionY()%40!=0){
            return false;
        }
        if(getX()==Frame.p.getPositionX()){
            
            if(getY()>Frame.p.getPositionY()){
                if(getY()/40-Frame.p.getPositionY()/40<20+Frame.lvl)return true;
            }else{
                if(Frame.p.getPositionY()/40-getY()/40<20+Frame.lvl)return true;
            }
        }else if(getY()==Frame.p.getPositionY()){
            
             if(getX()>Frame.p.getPositionX()){
                if(getX()/40-Frame.p.getPositionX()/40<20+Frame.lvl)return true;
            }else{
                if(Frame.p.getPositionX()/40-getX()/40<20+Frame.lvl)return true;
            }
        }
            return false;    
    }
    
    public void eat(){
        if((getX()+16 == Frame.p.getPositionX() || getX()+24== Frame.p.getPositionX() || getX()+32== Frame.p.getPositionX() || getX()+8==Frame.p.getPositionX() || getX()==Frame.p.getPositionX()) && 
                (getY()+8==Frame.p.getPositionY() || getY()+16==Frame.p.getPositionY() || getY()+24==Frame.p.getPositionY() || getY()+32==Frame.p.getPositionY() || getY()==Frame.p.getPositionY())){
            if(Frame.p.shield==false){
                Frame.p.gameOver();
            }else{
                teleportSpawn();
                Frame.p.playEATGHOST();
                Frame.score+=200;
                Frame.p.eatGhosts++;
                if(Frame.p.eatGhosts==4+Frame.lvl){
                    if(Frame.p.lives<3){
                        Frame.p.lives++;
                    }
                    Frame.p.eatGhosts=0;
                }
            }
        }  
        Frame.info.refresh();
    }
    
    public void teleportSpawn(){
        setLocation(360, 360);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(Frame.p.paused==true){
            return;
        }
        if(Frame.p.shield==true){
            t.setDelay(100);
        }else{
            t.setDelay(60);
        }
        if(Frame.p.start.isRunning()){
            return; 
        }
        eat();
        if(getX()%40==0 && getY()%40==0){
            find();
        }else{
            continueInMove();
        }
        if(anima==1)anima=2;
        else anima=1;
        if(Frame.p.gameover==true){
            t.stop();
        }
        repaint();
    }
    
}
