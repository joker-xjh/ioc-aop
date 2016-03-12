package interceptor;

import java.lang.reflect.Method;

import Model.Bird;

/**
 * ������������Ƕ�̬�Ĺؼ�!
 * @author szj
 *
 */
public class Inteceptor {
	
	public void before(Object proxy, Method method, Object[] args){
		System.out.println("-----start------");
		//���ˣ�bird�ӿڵ�fly��������ͨ��
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
