public class Plot
{
	private int x, y, depth, width;
	Plot()
	{
		width = 1;
		depth = 1;
	}
	Plot(int x, int y, int depth, int width)
	{
		this.x = x;
		this.y = y;
		this.depth = depth;
		this.width = width;
	}
	Plot(Plot newPlot)
	{
		x = newPlot.getX();
		y = newPlot.getY();
		depth = newPlot.getDepth();
		width = newPlot.getWidth();
	}
	public void setX(int new1)
	{
		x = new1;
	}
	public void setY(int new1)
	{
		y = new1;
	}
	public void setDepth(int new1)
	{
		depth = new1;
	}
	public void setWidth(int new1)
	{
		width = new1;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public int getDepth()
	{
		return depth;
	}
	public int getWidth()
	{
		return width;
	}
	public boolean overlaps(Plot plot)
	{
		double left1 = x - width / 2;
	    double right1 = x + width / 2;
	    double top1 = y + depth / 2;
	    double bottom1 = y - depth / 2;

	    double left2 = plot.getX() - plot.getWidth() / 2;
	    double right2 = plot.getX() + plot.getWidth() / 2;
	    double top2 = plot.getY() + plot.getDepth() / 2;
	    double bottom2 = plot.getY() - plot.getDepth() / 2;

	    // Check for overlap
	    return !(left1 > right2 || right1 < left2 || bottom1 > top2 || top1 < bottom2);
	}
	public boolean encompasses(Plot plot)
	{
		if (x - 0.5 * width <= plot.getX() - 0.5 * plot.getWidth() && x + 0.5 * width >= plot.getX() + 0.5 * plot.getWidth() && y - 0.5 * depth <= plot.getY() - 0.5 * plot.getDepth() && y + 0.5 * depth >= plot.getY() + 0.5 * plot.getDepth()) 
		{
			return true;
		}
		return false;
	}
	public String toString()
	{
		return x + "," + y + "," + depth + "," + width;
	}
}