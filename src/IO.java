import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class IO {

	static public void saveComponent()
	{
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File("."));
		fc.setDialogType(JFileChooser.FILES_ONLY);
		fc.setDialogTitle("Select File");
		fc.setMultiSelectionEnabled(false);
		fc.showSaveDialog(fc);
		if (fc.getSelectedFile()==null) {
			return;
		}
//		return fc.getSelectedFile().getPath();
		System.out.println(fc.getSelectedFile().getPath());
		
		File file = new File(fc.getSelectedFile().getPath());
		FileWriter fw = null;
        BufferedWriter writer = null;
		try {
            fw = new FileWriter(file);
            writer = new BufferedWriter(fw);
            for( BufferedImgData i : My_Panel.imgdata )
            {
            	String temp = null;
            	if( i.type != 4 ) 
            	{
            		temp = i.type+","+i.color+","+i.x1+","+i.y1+","+i.x2+","+i.y2;
            	}
            	else
            	{
            		temp = i.type+","+i.color+","+i.x1+","+i.y1+","+i.str;
            	}
                writer.write(temp);
                writer.newLine();
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                writer.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
	
	static public void loadComponent()
	{
		My_Panel.imgdata.clear();
		
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File("."));
		fc.setAcceptAllFileFilterUsed(false);
		  
		fc.addChoosableFileFilter(new FileFilter() {
			public boolean accept(File file) {
				return true;
			}
			public String getDescription() {
				return "所有文件(*.*)";
			}
		});
		fc.showDialog(null, null);
		
		System.out.println(fc.getSelectedFile().getPath());
		
		File file = new File(fc.getSelectedFile().getPath());
		BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                addimg(tempString);
                line++;
            }
            MiniCAD.panel.repaint();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
	}
	
	public static void addimg(String str)
	{
//		System.out.println(str);
		int type = Integer.parseInt(str.substring(0,str.indexOf(",")));
		str = str.substring(str.indexOf(",")+1);
		
		int color = Integer.parseInt(str.substring(0,str.indexOf(",")));
		str = str.substring(str.indexOf(",")+1);
		
		int x1 = Integer.parseInt(str.substring(0,str.indexOf(",")));
		str = str.substring(str.indexOf(",")+1);
		
		int y1 = Integer.parseInt(str.substring(0,str.indexOf(",")));
		str = str.substring(str.indexOf(",")+1);
		
		if( type == 4 )
		{
			String tempstr = str;//.substring(str.indexOf(",")+1);
			My_Panel.imgdata.add(new BufferedImgData(type, color, x1, y1, tempstr));
		}
		else
		{
			int x2 = Integer.parseInt(str.substring(0,str.indexOf(",")));
			str = str.substring(str.indexOf(",")+1);
			
			int y2 = Integer.parseInt(str);
			My_Panel.imgdata.add(new BufferedImgData(type, color, x1, y1, x2, y2));
		}
	}
}
