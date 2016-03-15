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
	 * 注入原对象和插件对象
	 * @param obj     原对象
	 * @param method  插件
	 * @param method
	 */ 
	public ProxyHandler(Object obj, Interceptor interceptor) {
		this.target = obj;
		this.interceptor = interceptor;
	}
	
	
	
	//拦截targer内的方法！！！
	//target 对象的所有方法都要调用这个方法。
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		this.target = this.interceptor.intercept(target, method, args);//todo 这里处理target
		return "flamingo return";
	}
}
