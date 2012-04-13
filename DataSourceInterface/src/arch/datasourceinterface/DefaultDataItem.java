package arch.datasourceinterface;

import java.util.ArrayList;
import java.util.List;

public class DefaultDataItem implements IDataItem {

    private String company = "";
    private int revenue = 0;
    private String area = "";
    private List<String> values = new ArrayList<String>();

    public DefaultDataItem(String company, int revenue) {
        this.company = company;
        this.revenue = revenue;
    }
    
    public DefaultDataItem(IDataItem item) {
    	this.company = item.getCompany();
    	this.revenue = item.getRevenue();
    	this.area = item.getArea();
    	this.values = new ArrayList<String>();
    	for(int i = 0; i < item.getValues().size(); i++)
    		this.values.add(new String(item.getValues().get(i)));
    }

    @Override
    public String getCompany() {
        return this.company;
    }

    @Override
    public int getRevenue() {
        return this.revenue;
    }

    @Override
    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

	@Override
	public List<String> getValues() {
		return values;
	}
    
	@Override
    public void addValue(String s) {
    	values.add(s);
    }
}
