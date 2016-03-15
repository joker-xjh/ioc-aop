package furioussoul.aop.interceptor;

import java.lang.reflect.Method;

import furioussoul.test.model.Bird;

/**
 * ������������Ƕ�̬�Ĺؼ�!
 * @author szj
 *
 */
public class Interceptor {
	
	private void before(Object target, Method method, Object[] args){
		System.out.println("-----start------");
		//���ˣ�bird�ӿڵ�fly��������ͨ��
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
		// todo ���ﴦ��target���󲢷���(reflect)
		after(target, method, args);
		return target;
	}
}
