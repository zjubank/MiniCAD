import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu_Listener implements ActionListener{
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		if(command.equals("Open"))
		{
			System.out.println("Open");
			IO.loadComponent();
		}
		else if(command.equals("Save"))
		{
			System.out.println("Save");
			IO.saveComponent();
		}
		else if(command.equals("Quit"))
		{
			System.out.println("Quit");
			System.exit(0);
		}
		else if(command.equals("Line"))
		{
			System.out.println("Draw Line");
			
			if( !My_Panel.imgdata.isEmpty() )
			{
				if( My_Panel.imgdata.get( My_Panel.imgdata.size() - 1 ).IfFinished == false )
				{
					My_Panel.imgdata.remove(My_Panel.imgdata.size() - 1);
				}
			}
			My_Panel.imgdata.add(new BufferedImgData(1,My_Panel.currentcolor));
			MiniCAD.frame.setCursor(Cursor.CROSSHAIR_CURSOR);
//			MiniCAD.panel.paintComponent(MiniCAD.panel.getGraphics());
		}
		else if(command.equals("Rectangle"))
		{
			System.out.println("Draw Rect");
			if( !My_Panel.imgdata.isEmpty() )
			{
				if( My_Panel.imgdata.get( My_Panel.imgdata.size() - 1 ).IfFinished == false )
				{
					My_Panel.imgdata.remove(My_Panel.imgdata.size() - 1);
				}
			}
			My_Panel.imgdata.add(new BufferedImgData(2,My_Panel.currentcolor));
			MiniCAD.frame.setCursor(Cursor.CROSSHAIR_CURSOR);
		}
		else if(command.equals("Oval"))
		{
			System.out.println("Draw Oval");
			if( !My_Panel.imgdata.isEmpty() )
			{
				if( My_Panel.imgdata.get( My_Panel.imgdata.size() - 1 ).IfFinished == false )
				{
					My_Panel.imgdata.remove(My_Panel.imgdata.size() - 1);
				}
			}
			My_Panel.imgdata.add(new BufferedImgData(3,My_Panel.currentcolor));
			MiniCAD.frame.setCursor(Cursor.CROSSHAIR_CURSOR);
		}
		else if(command.equals("Character"))
		{
			System.out.println("Draw Char");
			if( !My_Panel.imgdata.isEmpty() )
			{
				if( My_Panel.imgdata.get( My_Panel.imgdata.size() - 1 ).IfFinished == false )
				{
					My_Panel.imgdata.remove(My_Panel.imgdata.size() - 1);
				}
			}
			My_Panel.imgdata.add(new BufferedImgData(4,My_Panel.currentcolor));
			MiniCAD.frame.setCursor(Cursor.CROSSHAIR_CURSOR);
		}
		else if(command.equals("果皇橙"))
		{
			My_Panel.currentcolor = 1;
		}
		else if(command.equals("小鸟灰"))
		{
			My_Panel.currentcolor = 2;
		}
		else if(command.equals("海爷蓝"))
		{
			My_Panel.currentcolor = 3;
		}
		else if(command.equals("会长青"))
		{
			My_Panel.currentcolor = 4;
		}
		else if(command.equals("希魔紫"))
		{
			My_Panel.currentcolor = 5;
		}
		else if(command.equals("日香粉"))
		{
			My_Panel.currentcolor = 6;
		}
		else if(command.equals("花阳绿"))
		{
			My_Panel.currentcolor = 7;
		}
		else if(command.equals("凛喵黄"))
		{
			My_Panel.currentcolor = 8;
		}
		else if(command.equals("真姬红"))
		{
			My_Panel.currentcolor = 9;
		}
	}

}
