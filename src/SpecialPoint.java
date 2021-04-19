
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
public class SpecialPoint extends JComponent{
    
    private final int i;
    private final int j;
    
    public SpecialPoint(int i, int j){
        this.i = i;
        this.j = j;
    }
    
    public int getPositionX(){
        return i*Frame.l.Width;
    }
    
    public int getPositionY(){
        return j*Frame.l.Width;
    }
    
}
