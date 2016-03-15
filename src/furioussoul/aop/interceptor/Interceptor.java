package furioussoul.aop.interceptor;

import java.lang.reflect.Method;

import furioussoul.test.model.Bird;

/**
 * 这个拦截器才是动态的关键!
 * @author szj
 *
 */
public class Interceptor {
	
	private void before(Object target, Method method, Object[] args){
		System.out.println("-----start------");
		//过滤：bird接口的fly方法才能通过
		if((target.getClass().getInterfaces()[0] == Bird.class)
				&&(method.getName() == "fly")){
			System.out.println("caught method fly!");
		}
	}
	
	private void after(Object target, Method method, Object[] args){
		if((target.getClass() == Bird.class)
				&&(method.getName() == "fly")){
			System.out.println("caught method fly!");
		}
		System.out.println("-----end------");
	}
	
	public Object intercept(Object target, Method method, Object[] args){
		before(target, method, args);
		// todo 这里处理target对象并返回(reflect)
		after(target, method, args);
		return target;
	}
}
