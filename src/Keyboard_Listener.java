import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Keyboard_Listener extends JFrame implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Type:"+e.getKeyChar());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Press:"+e.getKeyChar()+"|Code:"+e.getKeyCode());
		//Backspace:8, Delete:127
		if(e.getKeyCode() == 8 || e.getKeyCode() == 127)
		{
			System.out.println("Remove Command");
			if( My_Panel.selectedindex > 0 )
			{
				System.out.println("Reomve:"+(My_Panel.selectedindex-1));
				My_Panel.imgdata.remove( My_Panel.selectedindex - 1 );
				My_Panel.bitmapRemove( My_Panel.selectedindex );
				MiniCAD.panel.repaint();
				My_Panel.selectedindex = 0;
			}
		}
		else
		{
			//Press any key to Reselect
			 My_Panel.selectedindex = 0;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Release:"+e.getKeyChar());
	}

}
