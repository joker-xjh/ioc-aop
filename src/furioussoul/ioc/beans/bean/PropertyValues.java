package furioussoul.ioc.beans.bean;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {
	private final List<PropertyValue> propertyValueList = new ArrayList<>();
	
	public void addPropertyValue(PropertyValue pv){
		this.propertyValueList.add(pv);
	}
	
	public List<PropertyValue> getPropertyValues(){
		return this.propertyValueList;
	}
}
