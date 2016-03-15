package furioussoul.ioc.beans.bean.xml;

import java.io.InputStream;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import furioussoul.ioc.beans.bean.BeanDefinition;
import furioussoul.ioc.beans.bean.PropertyValue;
import furioussoul.ioc.beans.bean.injection.BeanRefrence;
import furioussoul.ioc.beans.bean.io.ResourceLoader;

/**
 * Read XML,regist beandefinition here.
 * @author sunzhengjie
 * 
 */
public class XmlBeandefinitionReader extends AbstractBeanDefinitionReader{

	/**
	 * set resourceLoader which responses to get inputstream from xml
	 * @param resourceLoader
	 */
	public XmlBeandefinitionReader(ResourceLoader resourceLoader) {
		super(resourceLoader);
	}

	/**
	 * load beandefinition where xml located
	 * use resourceLoader to get inputstream of xml
	 * load inputstream
	 * @param location
	 */
	@Override
	public void loadBeanDefinitions(String location) throws Exception {
		InputStream inputStream = this.getResourceLoader().getResource(location).getInputStream();
		doLoadBeanDefinitions(inputStream);
	}

	/**
	 * get xml document builder and parse it
	 * extract beandefinition from inputstream and regist it here
	 * @param inputStream
	 * @throws Exception
	 */
	protected void doLoadBeanDefinitions(InputStream inputStream) throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(inputStream);
		registBeanDefinitions(doc);
		inputStream.close();
	}
	
	/**
	 * get root document and do registry
	 * @param document
	 */
	protected void registBeanDefinitions(Document document){
		Element root = document.getDocumentElement();
		parseBeanDefinitions(root);
	}
	
	/**
	 * traverse document from root
	 * get elements and do registry
	 * @param root
	 */
	protected void parseBeanDefinitions(Element root){
		NodeList nl = root.getChildNodes();
		for(int i = 0; i < nl.getLength(); i++){
			Node node = nl.item(i);
			if(node instanceof Element){
				Element ele = (Element) node;
				processBeanDefinition(ele);
			}
		}	
	}
	
	/**
	 * extract beandefinition from element
	 * set injection in beandefinition 
	 * do registry
	 * @param ele
	 */
	protected void processBeanDefinition(Element ele){
		String id = ele.getAttribute("id");
		String className = ele.getAttribute("class");
		BeanDefinition beanDefinition = new BeanDefinition();
		processProperty(ele, beanDefinition);
		beanDefinition.setBeanClassName(className);
		this.getRegistry().put(id, beanDefinition);
	}
	
	/**
	 * get element whose tag name is "property" and extract beandefinition
	 * if element "property" has attribute "ref",add beanreference in beandifinition,
	 * do registry
	 * @param ele
	 * @param beanDefinition
	 */
	protected void processProperty(Element ele, BeanDefinition beanDefinition){
		NodeList propertyNode = ele.getElementsByTagName("property");
		for(int i = 0; i < propertyNode.getLength(); i++){
			Node node = propertyNode.item(i);
			if(node instanceof Element){
				Element propertyEle = (Element) node;
				String name  = propertyEle.getAttribute("name");
				String value = propertyEle.getAttribute("value");
				if(value != null && value.length() > 0){
					beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
				}else{
					String ref = propertyEle.getAttribute("ref");
					if(ref == null || ref.length() == 0){
						throw new IllegalArgumentException("u must specify a ref or value");
					}
					BeanRefrence beanRefrence = new BeanRefrence(ref);
					beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,beanRefrence));
				}
			}
		}
	}
}
