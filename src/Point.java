
import javax.swing.JComponent;

public class Point extends JComponent{
    
    private final int i;
    private final int j;
    
    public Point(int i, int j) {
        this.i=i;
        this.j=j;   
    }

    public int getPositionX(){
        return j*Frame.l.Width;
    }
    
    public int getPositionY(){
        return i*Frame.l.Width;
    }
}
