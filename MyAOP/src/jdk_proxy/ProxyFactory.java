package jdk_proxy;

import java.lang.reflect.Proxy;

public class ProxyFactory {

	public static Object newInstance(ProxyHandler handler){
		
		Object target = handler.getTarget();// 这个对象这里只是为了getClass(),调用的已经注入进handler了
		
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
									  target.getClass().getInterfaces(), handler);
	}
}
