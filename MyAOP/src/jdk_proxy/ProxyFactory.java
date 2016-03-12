package jdk_proxy;

import java.lang.reflect.Proxy;

public class ProxyFactory {

	public static Object newInstance(ProxyHandler handler){
		
		Object target = handler.getTarget();// �����������ֻ��Ϊ��getClass(),���õ��Ѿ�ע���handler��
		
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
									  target.getClass().getInterfaces(), handler);
	}
}
