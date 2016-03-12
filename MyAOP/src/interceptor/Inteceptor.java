package interceptor;

import java.lang.reflect.Method;

import Model.Bird;

/**
 * 这个拦截器才是动态的关键!
 * @author szj
 *
 */
public class Inteceptor {
	
	public void before(Object proxy, Method method, Object[] args){
		System.out.println("-----start------");
		//过滤：bird接口的fly方法才能通过
		if((proxy.getClass().getInterfaces()[0] == Bird.class)
				&&(method.getName() == "fly")){
			System.out.println("caught method fly!");
		}
	}
	
	public void after(Object proxy, Method method, Object[] args){
		if((proxy.getClass() == Bird.class)
				&&(method.getName() == "fly")){
			System.out.println("caught method fly!");
		}
		System.out.println("-----end------");
	}
}
