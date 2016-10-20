import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MiniCAD {	
	static JFrame frame = new JFrame();
	static My_Panel panel = new My_Panel();
		
	public MiniCAD(){
		makeMenuBar(frame);
		
		panel.setBackground(Color.white);
		frame.add(panel);
		frame.setTitle("MiniCAD");
		frame.setSize(800,600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		panel.addMouseListener(new Mouse_Listener());
		panel.addMouseMotionListener(new Mouse_Listener());
		frame.addKeyListener(new Keyboard_Listener());
	}
		
	
	public static void makeMenuBar(JFrame frame)
	{
	    JMenuBar menubar = new JMenuBar();
	    frame.setJMenuBar(menubar);
	    
	    // create the File menu
	    JMenu fileMenu = new JMenu("File");
	    menubar.add(fileMenu);
	    
	    JMenuItem openItem = new JMenuItem("Open");
	    openItem.addActionListener(new Menu_Listener());
	    fileMenu.add(openItem);
	    JMenuItem saveItem = new JMenuItem("Save");
	    saveItem.addActionListener(new Menu_Listener());
	    fileMenu.add(saveItem);
	    JMenuItem quitItem = new JMenuItem("Quit");
	    quitItem.addActionListener(new Menu_Listener());
	    fileMenu.add(quitItem);
	    
	    // create the Draw menu
	    JMenu drawMenu = new JMenu("Draw");
	    menubar.add(drawMenu);
	    
	    JMenuItem lineDraw = new JMenuItem("Line");
	    lineDraw.addActionListener(new Menu_Listener());
	    drawMenu.add(lineDraw);
	    JMenuItem rectDraw = new JMenuItem("Rectangle");
	    rectDraw.addActionListener(new Menu_Listener());
	    drawMenu.add(rectDraw);
	    JMenuItem ovalDraw = new JMenuItem("Oval");
	    ovalDraw.addActionListener(new Menu_Listener());
	    drawMenu.add(ovalDraw);
	    JMenuItem charDraw = new JMenuItem("Character");
	    charDraw.addActionListener(new Menu_Listener());
	    drawMenu.add(charDraw);
	    
	    JMenu colorMenu = new JMenu("Color");
	    menubar.add(colorMenu);
	    
	    JMenuItem orangeColor = new JMenuItem("果皇橙");
	    orangeColor.addActionListener(new Menu_Listener());
	    colorMenu.add(orangeColor);
	    JMenuItem greyColor = new JMenuItem("小鸟灰");
	    greyColor.addActionListener(new Menu_Listener());
	    colorMenu.add(greyColor);
	    JMenuItem blueColor = new JMenuItem("海爷蓝");
	    blueColor.addActionListener(new Menu_Listener());
	    colorMenu.add(blueColor);
	    JMenuItem cranColor = new JMenuItem("会长青");
	    cranColor.addActionListener(new Menu_Listener());
	    colorMenu.add(cranColor);
	    JMenuItem violetColor = new JMenuItem("希魔紫");
	    violetColor.addActionListener(new Menu_Listener());
	    colorMenu.add(violetColor);
	    JMenuItem pinkColor = new JMenuItem("日香粉");
	    pinkColor.addActionListener(new Menu_Listener());
	    colorMenu.add(pinkColor);
	    JMenuItem greenColor = new JMenuItem("花阳绿");
	    greenColor.addActionListener(new Menu_Listener());
	    colorMenu.add(greenColor);
	    JMenuItem yellowColor = new JMenuItem("凛喵黄");
	    yellowColor.addActionListener(new Menu_Listener());
	    colorMenu.add(yellowColor);
	    JMenuItem redColor = new JMenuItem("真姬红");
	    redColor.addActionListener(new Menu_Listener());
	    colorMenu.add(redColor);
	}
}
