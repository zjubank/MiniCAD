import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class My_Panel extends JPanel{
	static int bitmap[][] = new int[800][600];
	static ArrayList<BufferedImgData> imgdata = new ArrayList<BufferedImgData>();
	static int currentcolor = 0;
	static int selectedindex = 0;
	static int delta = 3;
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		int index = 0;
		for( BufferedImgData i : imgdata )
		{
			index++;//from 1 to No.
			switch(i.color)
			{
			case 0: g.setColor(Color.BLACK); break;
			case 1: g.setColor(Color.ORANGE); break;
			case 2: g.setColor(Color.LIGHT_GRAY); break;
			case 3: g.setColor(Color.BLUE); break;
			case 4: g.setColor(Color.cyan); break;
			case 5: g.setColor(Color.MAGENTA); break;
			case 6: g.setColor(Color.PINK); break;
			case 7: g.setColor(Color.GREEN); break;
			case 8: g.setColor(Color.YELLOW); break;
			case 9: g.setColor(Color.RED); break;
			default: break;
			}
			switch(i.type)
			{
				case 1: 
				{
					g.drawLine(i.x1, i.y1, i.x2, i.y2);
					bitmapAddLine(index, i.x1, i.y1, i.x2, i.y2);
					break;
				}
				case 2: 
				{
					g.drawRect(Math.min(i.x1, i.x2), Math.min(i.y1, i.y2), Math.abs(i.x2-i.x1), Math.abs(i.y2-i.y1) );
					bitmapAdd(index, Math.min(i.x1, i.x2), Math.min(i.y1, i.y2), Math.max(i.x1, i.x2), Math.max(i.y1, i.y2) );
					break; 
				}
				case 3:
				{
					g.drawOval(Math.min(i.x1, i.x2), Math.min(i.y1, i.y2), Math.abs(i.x2-i.x1), Math.abs(i.y2-i.y1) );
					bitmapAdd(index, Math.min(i.x1, i.x2), Math.min(i.y1, i.y2), Math.max(i.x1, i.x2), Math.max(i.y1, i.y2) );
					break;
				}
				case 4:
				{
					g.drawString(i.str, i.x1, i.y1);
					
					int h = 0, w = 0;
					FontMetrics metrics;
					Font f = g.getFont();
					JLabel label = new JLabel();
					label.setText(i.str);
					metrics = label.getFontMetrics(f);
					h = metrics.getHeight();
					w = metrics.stringWidth(label.getText());
					
					bitmapAdd(index, i.x1, i.y1-h, i.x1+w, i.y1);
					break;
				}
			}
		}
	}
	
	public static void bitmapAddLine(int index, int x1, int y1, int x2, int y2)
	{
		for( int i = Math.min(x1,x2)-delta; i < Math.max(x1, x2)+delta; i++ )
		{
			for( int j = Math.min(y1, y2)-delta; j < Math.max(y1, y2)+delta; j++ )
			{
				double tan = (double)(x1-x2)/(double)(y1-y2);
				double ishould = (j-y1)*tan + x1;
				if( ishould-delta<=i && i<=ishould+delta)
				{
					bitmap[i][j] = index;
				}
			}
		}
	}
	
	public static void bitmapAdd(int index, int x1, int y1, int x2, int y2)
	{
		for( int i = x1-delta; i < x2+delta; i++ )
		{
			for( int j = y1-delta; j < y2+delta; j++ )
			{
				//Left
				if( (x1-delta<=i && i<=x1+delta) && y1-delta<=j && j<=y2+delta )
				{
					bitmap[i][j] = index;
				}
				//Right
				if( (x2-delta<=i && i<=x2+delta) && y1-delta<=j && j<=y2+delta )
				{
					bitmap[i][j] = index;
				}
				//Upper
				if( (y1-delta<=j && j<=y1+delta) && x1-delta<=i && i<=x2+delta )
				{
					bitmap[i][j] = index;
				}
				//Lower
				if( (y2-delta<=j && j<=y2+delta) && x1-delta<=i && i<=x2+delta )
				{
					bitmap[i][j] = index;
				}
			}
		}
	}
	
	public static void bitmapRemove(int index)
	{
		//index from 1 to No.
		for( int i = 0; i < 800; i++ )
		{
			for( int j = 0; j < 600; j++ )
			{
				if( bitmap[i][j] == index )
				{
					bitmap[i][j] = 0;
				}
				
				if( bitmap[i][j] > index )
				{
					bitmap[i][j]--;
				}
			}
		}
	}
	
}
