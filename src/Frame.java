
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;


public class Frame extends javax.swing.JFrame implements ActionListener{

    public static Labyrint l;
    public static ArrayList<Ghost> Ghosts = new ArrayList<Ghost>();
    public static ArrayList<Fruit> Fruits = new ArrayList<>();
    public static PacMan p;
    public static int lvl=1;
    public static int score=0;
    public static int highscore=0;
    public static Frame frame;
    public static Info info;
    public static MainMenu mm;
    public static Fruit Ceresna, Jablko, Marhula, Jahoda;
    public static boolean jablko = false, ceresna = false, marhula = false, jahoda = false;
    private Timer t;
            
    public Frame() {
        initComponents();
        mainMenu();
    }
    
    public void mainMenu(){
        setWindow();
        mm = new MainMenu(this);
        add(mm);
    }
    
    public void startGame(){
        info = new Info();
        add(info);
        t = new Timer(5000, this);
        //t.start();
        spawnGhosts();
        p = new PacMan(360,600);
        add(p);
        generateSpecialPoints();
        generatePoints();
        l = new Labyrint(1);
        add(l);
        generateSpecialPoints();
        generatePoints();
    }  
    
    public void spawnGhosts(){
        String names[]={"Blinky","Inky","Clyde","Pinky"};
        for(int i = 0; i < 4; i++){
            Ghost m = new Ghost(360, 360,names[i], "H");
            Ghosts.add(m);
            add(m);
        }
    }
    
    public void HighScore(){
        HighScore hs = new HighScore(this);
        add(hs);
    }
    
    public void setWindow(){
        JFrame jframe = this;
        jframe.setVisible(true);
        jframe.setPreferredSize(new Dimension(767, 927));
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
        this.setIconImage(new ImageIcon(getClass().getResource("/Image/IconS.png")).getImage());
        this.setTitle("PACMAN");
        jframe.setResizable(false);
    }
    
    public void generateFruits(){
            if(lvl==1){
                if(ceresna==false){
                    Ceresna.setLocation(240, 600);
                    Ceresna = new Fruit(0, 0, "ceresna", this); 
                    add(Ceresna); Fruits.add(Ceresna);  
                } 
            }else if(lvl==2){
                if(jablko==false){
                    Jablko = new Fruit(200, 600, "jablko", this);
                    Fruits.add(Jablko); add(Jablko); jablko=true; 
                } 
            }else if(lvl==3){
                if(marhula==false){
                    Marhula = new Fruit(320, 600, "marhula", this);
                    Fruits.add(Marhula); add(Marhula); marhula=true; 
                } 
            }else if(lvl==4){
                if(jahoda==false){
                    Jahoda = new Fruit(400, 600, "jahoda", this);
                    Fruits.add(Jahoda); add(Jahoda); jahoda=true;
                } 
            }
    }
    
    public void generateSpecialPoints(){
        int X[] = {1,17,1,17};
        int Y[] = {3,3,18,18};
        for(int i=0; i<X.length; i++){
            SpecialPoint sp = new SpecialPoint(X[i], Y[i]);
            add(sp);
            Frame.l.SpecialPoints.add(sp);
        }
    }
    
    public void generatePoints(){
        for(int i=0; i<Frame.l.row;i++){
            for(int j=0; j<Frame.l.col;j++){
                if(Labyrint.Labyrint.get(i).toString().substring(j,j+1).equals(" ")){
                    Point p = new Point(i, j);
                    add(p);
                    Labyrint.Points.add(p);
                }
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int random = (int)(1+Math.random()*5);
        if(random==1) generateFruits();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
