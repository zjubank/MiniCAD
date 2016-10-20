
public class BufferedImgData {
	int type = 0;
	int color = 0;
	int x1 = -1, y1 = -1;
	int x2 = -1, y2 = -1;
	String str = "";
	boolean FirstPoint = false;
	boolean SecondPoint = false;
	boolean IfFinished = false;
	
	public BufferedImgData(int type, int color )
	{
		this.type = type;
		this.color = color;
	}
	
	public BufferedImgData(int type, int color, int x1, int y1, int x2, int y2)
	{
		this.type = type;
		this.color = color;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.FirstPoint = true;
		this.SecondPoint = true;
		this.IfFinished = true;
		System.out.println("Add:"+type+","+x1+","+y1+","+x2+","+y2);
	}
	
	public BufferedImgData(int type, int color, int x1, int y1, String str)
	{
		this.type = type;
		this.color = color;
		this.x1 = x1;
		this.y1 = y1;
		this.str = str;
		this.FirstPoint = true;
		this.IfFinished = true;
		System.out.println("Add:"+type+","+x1+","+y1+","+str);
	}
	
	public void SetFirstPoint( int x, int y )
	{
		x1 = x;
		y1 = y;
		FirstPoint = true;
	}
	
	public void SetScondPoint( int x, int y )
	{
		x2 = x;
		y2 = y;
		SecondPoint = true;
	}
	
	public void SetString(String str)
	{
		this.str = str;
	}
	
	public boolean CheckFinished()
	{
		switch(type)
		{
			case 1:
				if( FirstPoint && SecondPoint )
				{
					IfFinished = true;
					return true;
				}
				else
				{
					return false;
				}
			case 2:
				if( FirstPoint && SecondPoint )
				{
					IfFinished = true;
					return true;
				}
				else
				{
					return false;
				}
			case 3:
				if( FirstPoint && SecondPoint )
				{
					IfFinished = true;
					return true;
				}
				else
				{
					return false;
				}
			case 4:
				if( FirstPoint && !str.equals(""))
				{
					IfFinished = true;
					return true;
				}
				else
				{
					return false;
				}
			default:
				return false;
		}
	}
	/*
	public boolean CheckFirstPoint()
	{
		switch(type)
		{
			case 1:
				if( x1>=0 && y1>=0 )
				{
					FirstPoint = true;
					return true;
				}
				else
				{
					return false;
				}
			case 2:
				if( x1>=0 && y1>=0 )
				{
					FirstPoint = true;
					return true;
				}
				else
				{
					return false;
				}
			case 3:
				if( x1>=0 && y1>=0 )
				{
					FirstPoint = true;
					return true;
				}
				else
				{
					return false;
				}
			case 4:
				if( x1>=0 && y1>=0 )
				{
					FirstPoint = true;
					return true;
				}
				else
				{
					return false;
				}
			default:
				return false;
		}
	}
	
	public boolean CheckSecondPoint()
	{
		switch(type)
		{
			case 1:
				if( x2>=0 && y2>=0 )
				{
					SecondPoint = true;
					return true;
				}
				else
				{
					return false;
				}
			case 2:
				if( x2>=0 && y2>=0 )
				{
					SecondPoint = true;
					return true;
				}
				else
				{
					return false;
				}
			case 3:
				if( x2>=0 && y2>=0 )
				{
					SecondPoint = true;
					return true;
				}
				else
				{
					return false;
				}
			case 4:
				return false;
			default:
				return false;
		}
	}
	*/
	
}
