
import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JComponent;

public class Labyrint extends JComponent{
    
    public static int lvl;
    public static int Width = 40;
    public static ArrayList Labyrint = new ArrayList();
    public static ArrayList<Point> Points = new ArrayList<>();
    public static ArrayList<SpecialPoint> SpecialPoints = new ArrayList<>();
    public static int row = 0;
    public static int col = 0;
    
    public Labyrint(int lvl){
        setBounds(0, 0, 1000, 1000);
        this.lvl = lvl;
        try{
            FileReader fr = new FileReader("LVL"+lvl+".txt");
            BufferedReader bf = new BufferedReader(fr);
            String riadok="";
            while(riadok!=null){ 
               riadok = bf.readLine();
               if(riadok!=null){
                Labyrint.add(riadok);
                row++;
               }
            fr.close();
            col = Labyrint.get(0).toString().length();
        }
        }catch(IOException e){
            e.getMessage();
        }    
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLabyrint(g);
        drawPoints(g);
        drawSpecialPoints(g);
    }
    
    public void drawPoints(Graphics g){   
        g.setColor(Color.WHITE);
        for(int i=0; i<Points.size();i++){
            Point p = Points.get(i);
            g.fillOval(p.getPositionX()+16, p.getPositionY()+16, 7, 7);
        }
    }
    
    public void drawSpecialPoints(Graphics g){
        for(SpecialPoint sp : SpecialPoints){
            g.setColor(Color.WHITE);
            g.fillOval(sp.getPositionX()+15, sp.getPositionY()+15, 16, 16);
        }
    }
    
    public void drawLabyrint(Graphics g){
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(Labyrint.get(i).toString().substring(j, j+1).equals(" ")){
                    g.setColor(Color.BLACK);
                    g.fillRect(j*Width, i*Width, Width, Width);
                }else if(Labyrint.get(i).toString().substring(j, j+1).equals("+")){
                    g.setColor(Color.BLACK);
                    g.fillRect(j*Width, i*Width, Width, Width);
                }else{
                    g.setColor(Color.BLUE);
                    g.fillRect(j*Width, i*Width, Width, Width);
                    g.setColor(Color.black);
                    g.drawRect(j*Width, i*Width, Width, Width);
                    
                }
            }
        }
    }
    
    
}
