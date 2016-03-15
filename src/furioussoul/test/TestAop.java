package furioussoul.test;

import furioussoul.aop.interceptor.Interceptor;
import furioussoul.aop.jdk_proxy.ProxyFactory;
import furioussoul.aop.jdk_proxy.ProxyHandler;
import furioussoul.core.annotation.AnnotationInjection;
import furioussoul.test.model.Bird;
import furioussoul.test.model.Flamingo;

public class TestAop {
	
	
	public static void main(String[] arg0) throws Throwable{
		
		/**
		 * 我要一个对象,而且我要后期能够扩展他,所以我用了工厂和代理模式
		 * @param 原对象 flamingo
		 * @param 插件     aopMethod
		 * @throws Throwable
		 * 
		 */
		Bird fm = new Flamingo();
		AnnotationInjection aj = new AnnotationInjection();
		//通过注解注入了属性
		fm = (Bird)aj.getBean(fm);
		Bird proxyFl = (Bird) ProxyFactory.newInstance(new ProxyHandler(fm, new Interceptor()));
		System.out.println(proxyFl.fly());
	}
}
