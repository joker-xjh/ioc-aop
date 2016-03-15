package furioussoul.ioc.beans.bean.factory;

import furioussoul.ioc.beans.bean.BeanDefinition;

public interface BeanFactory {
	
	Object getBean(String name) throws Exception;
	
	void registBeanDefinition(String name, BeanDefinition beanDefinition);
}
