public class Property
{
	private String propertyName, city, owner;
	private double rentAmount;
	Plot plot;
	Property()
	{
		propertyName = "";
		city = "";
		owner = "";
		rentAmount = 0;
		plot = new Plot(0, 0, 1, 1);
	}
	Property(String propertyName, String city, double rentAmount, String owner)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot(0, 0, 1, 1);
	}
	Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot(x, y, depth, width);
	}
	Property(Property otherProperty)
	{
		propertyName = otherProperty.getPropertyName();
		city = otherProperty.getCity();
		rentAmount = otherProperty.getRentAmount();
		owner = otherProperty.getOwner();
		plot = otherProperty.getPlot();
	}
	public String getCity()
	{
		return city;
	}
	public String getOwner()
	{
		return owner;
	}
	public Plot getPlot()
	{
		return plot;
	}
	public String getPropertyName()
	{
		return propertyName;
	}
	public double getRentAmount()
	{
		return rentAmount;
	}
	public String toString()
	{
		return propertyName + "," +  city + "," + owner + "," + rentAmount;
	}
}