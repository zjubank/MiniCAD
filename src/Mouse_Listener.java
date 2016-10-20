import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Mouse_Listener extends JFrame implements MouseListener,MouseMotionListener{

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Drag:("+e.getX()+", "+e.getY()+")");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Move:("+e.getX()+", "+e.getY()+")");
		if( My_Panel.bitmap[e.getX()][e.getY()] != 0 )
		{
			//Select
			if( My_Panel.imgdata.isEmpty() || ( !My_Panel.imgdata.isEmpty() && My_Panel.imgdata.get( My_Panel.imgdata.size()-1 ).IfFinished) )
			{
				MiniCAD.frame.setCursor(Cursor.HAND_CURSOR);
//				My_Panel.selectedindex = My_Panel.bitmap[e.getX()][e.getY()];
//				System.out.println("Set SelectedInedx:"+My_Panel.bitmap[e.getX()][e.getY()]);
			}
		}
		else 
		{
			//Unselect
			if( My_Panel.imgdata.isEmpty() || ( !My_Panel.imgdata.isEmpty() && My_Panel.imgdata.get( My_Panel.imgdata.size()-1 ).IfFinished) )
			{
				MiniCAD.frame.setCursor(Cursor.DEFAULT_CURSOR);
//				My_Panel.selectedindex = 0;
//				System.out.println("Set SelectedInedx:"+My_Panel.bitmap[e.getX()][e.getY()]);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Click:("+e.getX()+", "+e.getY()+")");
		
		//Select
		if( My_Panel.bitmap[e.getX()][e.getY()] != 0 )
		{
			//Select
			if( My_Panel.imgdata.isEmpty() || ( !My_Panel.imgdata.isEmpty() && My_Panel.imgdata.get( My_Panel.imgdata.size()-1 ).IfFinished) )
			{
//				MiniCAD.frame.setCursor(Cursor.HAND_CURSOR);
				My_Panel.selectedindex = My_Panel.bitmap[e.getX()][e.getY()];
				System.out.println("Set SelectedInedx:"+My_Panel.bitmap[e.getX()][e.getY()]);
			}
		}
		else 
		{
			//Unselect
			if( My_Panel.imgdata.isEmpty() || ( !My_Panel.imgdata.isEmpty() && My_Panel.imgdata.get( My_Panel.imgdata.size()-1 ).IfFinished) )
			{
//				MiniCAD.frame.setCursor(Cursor.DEFAULT_CURSOR);
				My_Panel.selectedindex = 0;
				System.out.println("Set SelectedInedx:"+My_Panel.bitmap[e.getX()][e.getY()]);
			}
		}
		//Create
		if( !My_Panel.imgdata.isEmpty() )
		{
			BufferedImgData imgdata = My_Panel.imgdata.get(My_Panel.imgdata.size() - 1);
			if( imgdata.IfFinished == false )
			{
				if( imgdata.FirstPoint == false )
				{
					imgdata.SetFirstPoint(e.getX(), e.getY());
					
					if(imgdata.type == 4)
					{
						JTextField jt=new JTextField("");
			            
			            MiniCAD.panel.add(jt);
			            jt.setSize(100,20);
			            jt.setCaretPosition(0);
			            jt.setLocation(e.getX()-5,e.getY()-13);
			            jt.addKeyListener(new KeyListener() {
							
							@Override
							public void keyTyped(KeyEvent e) {
								// TODO Auto-generated method stub
								if(e.getKeyChar()==KeyEvent.VK_ENTER)
								{
									jt.setVisible(false);
									imgdata.SetString(jt.getText());
									if( imgdata.CheckFinished() )
									{
										My_Panel.imgdata.set(My_Panel.imgdata.size() - 1, imgdata);
										MiniCAD.frame.setCursor(Cursor.DEFAULT_CURSOR);
										MiniCAD.panel.repaint();
										System.out.println("No."+My_Panel.imgdata.size());										
									}
								}
							}

							@Override
							public void keyPressed(KeyEvent e) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void keyReleased(KeyEvent e) {
								// TODO Auto-generated method stub
								
							}
						});
//						String str = "Hello";
//						imgdata.SetString(str);
					}
					MiniCAD.frame.setFocusable(true);

				}
				else if( imgdata.SecondPoint == false )
				{
					imgdata.SetScondPoint(e.getX(), e.getY());
					
					if( imgdata.CheckFinished() )
					{
						My_Panel.imgdata.set(My_Panel.imgdata.size() - 1, imgdata);
						MiniCAD.frame.setCursor(Cursor.DEFAULT_CURSOR);
						MiniCAD.panel.repaint();
						System.out.println("No."+My_Panel.imgdata.size());
					}
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Press:("+e.getX()+", "+e.getY()+")");
		System.out.println("Bitmap:" + My_Panel.bitmap[e.getX()][e.getY()]);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Release:("+e.getX()+", "+e.getY()+")");
//		if( !My_Panel.imgdata.isEmpty() )
//		{
//			if( My_Panel.imgdata.get( My_Panel.imgdata.size() - 1 ).IfFinished )
//			{
//				MiniCAD.frame.setCursor(Cursor.DEFAULT_CURSOR);
//			}
//			//else: Drawing
//		}
//		else
//		{
//			MiniCAD.frame.setCursor(Cursor.DEFAULT_CURSOR);
//		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Enter:("+e.getX()+", "+e.getY()+")");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Exit:("+e.getX()+", "+e.getY()+")");
	}

}
