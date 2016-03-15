package furioussoul.ioc.beans.bean.xml;

import java.util.HashMap;
import java.util.Map;

import furioussoul.ioc.beans.bean.BeanDefinition;
import furioussoul.ioc.beans.bean.io.Resource;
import furioussoul.ioc.beans.bean.io.ResourceLoader;

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{
	
	private Map<String,BeanDefinition> registry;
	
	private ResourceLoader resourceLoader;

	public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
		this.registry = new HashMap<>();
	}
	
	protected ResourceLoader getResourceLoader(){
		return resourceLoader;
	}
	
	public Map<String,BeanDefinition> getRegistry(){
		return registry;
	}	
}
