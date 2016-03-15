package furioussoul.aop.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import furioussoul.aop.interceptor.Interceptor;

public class ProxyHandler implements InvocationHandler{

	private Object target;
	
	private	Interceptor interceptor;
	
	public Object getTarget(){
		return this.target;
	}
	
	/**
	 * ע��ԭ����Ͳ������
	 * @param obj     ԭ����
	 * @param method  ���
	 * @param method
	 */ 
	public ProxyHandler(Object obj, Interceptor interceptor) {
		this.target = obj;
		this.interceptor = interceptor;
	}
	
	
	
	//����targer�ڵķ���������
	//target ��������з�����Ҫ�������������
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		this.target = this.interceptor.intercept(target, method, args);//todo ���ﴦ��target
		return "flamingo return";
	}
}
