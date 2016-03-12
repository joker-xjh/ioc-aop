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
	 * 注入原对象和插件对象
	 * @param obj     原对象
	 * @param method  插件
	 * @param method
	 */
	public ProxyHandler(Object obj, Inteceptor method) {
		this.target = obj;
		this.method = method;
	}
	
	
	
	//拦截targer内的方法！！！
	//tager 对象的所有方法都要调用这个方法。
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(proxy.getClass());
		//before
		this.method.before(proxy, method, args);
		Bird b = (Bird)target;
		b.fly();
		//after
		this.method.after(proxy, method, args);
		return "这才是返回值！";
	}
}
