package furioussoul.ioc.beans.bean.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import furioussoul.ioc.beans.bean.BeanDefinition;

public abstract class AbstractBeanFactory implements BeanFactory{
	
	private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
	
	private final List<String> beanDefinitionNames = new ArrayList<>();

	@Override
	public Object getBean(String name) throws Exception {
		BeanDefinition beanDefinition = beanDefinitionMap.get(name);
		Class clazz = beanDefinition.getBeanClass();
		Object object = clazz.newInstance();
		return object;
	}

	@Override
	public void registBeanDefinition(String name, BeanDefinition beanDefinition) {
		beanDefinitionMap.put(name, beanDefinition);
		beanDefinitionNames.add(name);
	}
}
