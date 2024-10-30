public class ManagementCompany
{
	private final int MAX_PROPERTY = 5, MGMT_WIDTH = 10, MGMT_DEPTH = 10;
	private String name, taxID;
	private int numberOfProperties;
	private double fee;
	Property[] properties = new Property[MAX_PROPERTY];
	Plot plot = new Plot(0, 0, MGMT_DEPTH, MGMT_WIDTH);
	ManagementCompany()
	{
		name = "";
		taxID = "";
		fee = 0;
		numberOfProperties = 0;
	}
	ManagementCompany(String name, String taxID, double fee)
	{
		this.name = name;
		this.taxID = taxID;
		this.fee = fee;
		numberOfProperties = 0;
	}
	ManagementCompany(String name, String taxID, double fee, int x, int y, int width, int depth)
	{
		this.name = name;
		this.taxID = taxID;
		this.fee = fee;
		numberOfProperties = 0;
	}
	ManagementCompany(ManagementCompany new1)
	{
		name = new1.getName();
		taxID = new1.getTaxID();
		fee = new1.getFee();
		numberOfProperties = new1.getPropertiesCount();
		properties = new1.getProperties();
		plot = new1.getPlot();
	}
	public int addProperty(String name, String city, double rent, String owner)
	{
		Plot plot2 = new Plot(0,0,1,1);
		Property property = new Property(name, city, rent, owner);
		boolean exp = false;
		for (int i = 0; i < numberOfProperties; i++)
		{
			if (properties[i].plot.encompasses(plot2))
			{
				exp = true;
			}
		}
		if (numberOfProperties == 5)
		{
			return -1;
		}
		else if (property == null)
		{
			return -2;
		}
		else if (exp)
		{
			return -4;
		}
		else if (!plot.encompasses(plot2))
		{
			return -3;
		}
		properties[numberOfProperties] = new Property(name, city, rent, owner);
		numberOfProperties++;
		return numberOfProperties - 1;
	}
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth)
	{
		Plot plot2 = new Plot(x,y,depth,width);
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		boolean exp = false;
		for (int i = 0; i < numberOfProperties; i++)
		{
			if (properties[i].plot.encompasses(plot2))
			{
				exp = true;
			}
		}
		if (numberOfProperties == 5)
		{
			return -1;
		}
		else if (property == null)
		{
			return -2;
		}
		else if (exp)
		{
			return -4;
		}
		else if (!plot.encompasses(plot2))
		{
			return -3;
		}
		properties[numberOfProperties] = property;
		numberOfProperties++;
		return numberOfProperties - 1;
	}
	public int addProperty(Property property)
	{
		Plot plot2 = new Plot(property.getPlot());
		boolean exp = false;
		for (int i = 0; i < numberOfProperties; i++)
		{
			if (properties[i].plot.encompasses(plot2))
			{
				exp = true;
			}
		}
		if (numberOfProperties == 5)
		{
			return -1;
		}
		else if (property == null)
		{
			return -2;
		}
		else if (exp)
		{
			return -4;
		}
		else if (!plot.encompasses(plot2))
		{
			return -3;
		}
		properties[numberOfProperties] = new Property(property);
		numberOfProperties++;
		return numberOfProperties - 1;
	}
	public Property getHighestRentProperty()
	{
		int index = 0;
		int i = 0;
		double highestRent = 0;
		for (Property property : properties)
		{
			if (property.getRentAmount() > highestRent)
			{
				index = i;
				highestRent = property.getRentAmount();
			}
			i++;
		}
		return properties[index];
	}
	public double getFee()
	{
		return fee;
	}
	public String getName()
	{
		return name;
	}
	public Plot getPlot()
	{
		return plot;
	}
	public Property[] getProperties()
	{
		return properties;
	}
	public int getPropertiesCount()
	{
		return numberOfProperties;
	}
	public String getTaxID()
	{
		return taxID;
	}
	public double getTotalRent()
	{
		double totalRent = 0;
		for (Property property : properties)
		{
			totalRent += property.getRentAmount();
		}
		return totalRent;
	}
	public boolean isManagementFeeValid()
	{
		if (fee > 0 && fee < 100)
		{
			return true;
		}
		else
		return false;
	}
	public boolean isPropertiesFull()
	{
		if (numberOfProperties == 5)
		{
			return true;
		}
		else
		return false;
	}
	public void removeLastProperty()
	{
		int num = 0;
		for (Property property : properties)
		{
			if (property.getPropertyName() != null)
			{
				num++;
			}
		}
		properties[num - 1] = null;
	}
	public String toString()
	{
		double fee = 0;
		String finalString = "List of the properties for " + name + ", taxID: " + taxID + "\n______________________________________________________\n";
		for (int i = 0; i < numberOfProperties; i++)
		{
			fee += (this.fee/100)*properties[i].getRentAmount();
			finalString += properties[i].getPropertyName() + "," + properties[i].getCity() + "," + properties[i].getOwner() + "," + properties[i].getRentAmount() + "\n";
		}
		finalString += "______________________________________________________";
		finalString += "\n\n total management Fee: " + fee;
		return finalString;
	}
}