
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;


public class HighScore extends JComponent implements ActionListener{
    
    private Frame frame;
    private BufferedImage P0, P1, P2, P3,P4,P5,P6,P7,P8,P9, score, score2, rank, st1, nd2, rd3, th4 ,th5, th6,th7, th8, th9, th10;
    private JButton b1;
    private ImageIcon spat;
    
    public HighScore(Frame frame){
        this.frame = frame;
        setBounds(0, 0, frame.getWidth(), frame.getHeight());
        loadImg();
    }
    
    public void loadImg(){
        try {
            spat = new ImageIcon(getClass().getResource("/Image/Back.png"));
            P1 = ImageIO.read(getClass().getResourceAsStream("/Image/1.png")); P2 = ImageIO.read(getClass().getResourceAsStream("/Image/2.png"));
            P3 = ImageIO.read(getClass().getResourceAsStream("/Image/3.png")); P4 = ImageIO.read(getClass().getResourceAsStream("/Image/4.png"));
            P5 = ImageIO.read(getClass().getResourceAsStream("/Image/5.png")); P6 = ImageIO.read(getClass().getResourceAsStream("/Image/6.png"));
            P7 = ImageIO.read(getClass().getResourceAsStream("/Image/7.png")); P8 = ImageIO.read(getClass().getResourceAsStream("/Image/8.png"));
            P9 = ImageIO.read(getClass().getResourceAsStream("/Image/9.png")); P0 = ImageIO.read(getClass().getResourceAsStream("/Image/0.png"));
            st1 = ImageIO.read(getClass().getResourceAsStream("/Image/st1.png")); nd2 = ImageIO.read(getClass().getResourceAsStream("/Image/nd2.png"));
            rd3 = ImageIO.read(getClass().getResourceAsStream("/Image/rd3.png")); th4 = ImageIO.read(getClass().getResourceAsStream("/Image/th4.png"));
            th5 = ImageIO.read(getClass().getResourceAsStream("/Image/th5.png")); th6 = ImageIO.read(getClass().getResourceAsStream("/Image/th6.png"));
            th7 = ImageIO.read(getClass().getResourceAsStream("/Image/th7.png")); th8 = ImageIO.read(getClass().getResourceAsStream("/Image/th8.png"));
            th9 = ImageIO.read(getClass().getResourceAsStream("/Image/th9.png")); th10 = ImageIO.read(getClass().getResourceAsStream("/Image/th10.png"));
            score = ImageIO.read(getClass().getResourceAsStream("/Image/HighScore2.png"));
            score2 = ImageIO.read(getClass().getResourceAsStream("/Image/Score2.png"));
            rank = ImageIO.read(getClass().getResourceAsStream("/Image/Rank.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
        drawScoreBoard(g);
    }
    
    public void drawScoreBoard(Graphics g){
        int row=0;
        g.drawImage(score, (frame.getWidth()/2)-(score.getWidth()/2), 100, this);
        g.drawImage(rank, 150, 200, this);
        g.drawImage(score2, frame.getWidth()-150-score2.getWidth(), 200, this);
        g.drawImage(st1, 150, 250, this); g.drawImage(nd2, 150, 250+50, this); g.drawImage(rd3, 150, 250+100, this);
        g.drawImage(th4, 150, 250+150, this); g.drawImage(th5, 150, 250+200, this); g.drawImage(th6, 150, 250+250, this);
        g.drawImage(th7, 150, 250+300, this); g.drawImage(th8, 150, 250+350, this); g.drawImage(th9, 150, 250+400, this);
        g.drawImage(th10, 150, 250+450, this);
        
        b1 = new JButton("", spat);
        b1.setBounds((frame.getWidth()/2)-55, 800, 10, 10);
        b1.setSize(100,50);
        this.add(b1);
        b1.addActionListener(this);
        
        try{
            FileReader fr = new FileReader("Score.txt");
            BufferedReader br = new BufferedReader(fr);
            String riadok="";
            for(int i=0; i<10;i++){
                if(riadok!=null){
                    riadok = br.readLine();
                    for(int j=0; j<riadok.length();j++){
                        String Char = riadok.substring(j, j+1);
                        switch (Char){
                            case "0": g.drawImage(P0, frame.getWidth()-150-score2.getWidth()+j*23, 250+row*50, this); break;
                            case "1": g.drawImage(P1, frame.getWidth()-150-score2.getWidth()+j*23, 250+row*50, this); break;
                            case "2": g.drawImage(P2, frame.getWidth()-150-score2.getWidth()+j*23, 250+row*50, this); break; 
                            case "3": g.drawImage(P3, frame.getWidth()-150-score2.getWidth()+j*23, 250+row*50, this); break;
                            case "4": g.drawImage(P4, frame.getWidth()-150-score2.getWidth()+j*23, 250+row*50, this); break;
                            case "5": g.drawImage(P5, frame.getWidth()-150-score2.getWidth()+j*23, 250+row*50, this); break;
                            case "6": g.drawImage(P6, frame.getWidth()-150-score2.getWidth()+j*23, 250+row*50, this); break;
                            case "7": g.drawImage(P7, frame.getWidth()-150-score2.getWidth()+j*23, 250+row*50, this);break;
                            case "8": g.drawImage(P8, frame.getWidth()-150-score2.getWidth()+j*23, 250+row*50, this); break;
                            case "9": g.drawImage(P9, frame.getWidth()-150-score2.getWidth()+j*23, 250+row*50, this); break;
                        }
                }
            }  
            row++;
        }
            br.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        } 
            
        }

    @Override
    public void actionPerformed(ActionEvent e) {
            frame.mainMenu();
            frame.remove(this);
            frame.repaint();
    }
      
}
