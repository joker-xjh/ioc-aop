package jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import Model.Bird;
import interceptor.Inteceptor;

public class ProxyHandler implements InvocationHandler{

	private Object target;
	
	private	Inteceptor method;
	
	public Object getTarget(){
		return this.target;
	}
	
	/**
	 * ע��ԭ����Ͳ������
	 * @param obj     ԭ����
	 * @param method  ���
	 * @param method
	 */
	public ProxyHandler(Object obj, Inteceptor method) {
		this.target = obj;
		this.method = method;
	}
	
	
	
	//����targer�ڵķ���������
	//tager ��������з�����Ҫ�������������
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(proxy.getClass());
		//before
		this.method.before(proxy, method, args);
		Bird b = (Bird)target;
		b.fly();
		//after
		this.method.after(proxy, method, args);
		return "����Ƿ���ֵ��";
	}
}
