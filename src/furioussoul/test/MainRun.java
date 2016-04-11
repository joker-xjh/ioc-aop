package furioussoul.test;

import java.util.Map;

import org.junit.Test;

import furioussoul.ioc.beans.bean.BeanDefinition;
import furioussoul.ioc.beans.bean.factory.AutowireCapableBeanFactory;
import furioussoul.ioc.beans.bean.factory.BeanFactory;
import furioussoul.ioc.beans.bean.io.ResourceLoader;
import furioussoul.ioc.beans.bean.xml.XmlBeandefinitionReader;

public class MainRun {
	
	@Test
	public void main() throws Exception{
		System.out.println(11);
		BeanFactory beanFactory = new AutowireCapableBeanFactory();
		XmlBeandefinitionReader reader = new XmlBeandefinitionReader(new ResourceLoader());
		reader.loadBeanDefinitions("ioc.xml");
		for(Map.Entry<String,BeanDefinition> beanDefinition : reader.getRegistry().entrySet()){
			beanFactory.registBeanDefinition(beanDefinition.getKey(), beanDefinition.getValue());
		}
		Person p = (Person)beanFactory.getBean("person");
		p.say();
	}
}
