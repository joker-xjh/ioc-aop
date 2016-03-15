package furioussoul.test;

import furioussoul.aop.interceptor.Interceptor;
import furioussoul.aop.jdk_proxy.ProxyFactory;
import furioussoul.aop.jdk_proxy.ProxyHandler;
import furioussoul.core.annotation.AnnotationInjection;
import furioussoul.test.model.Bird;
import furioussoul.test.model.Flamingo;

public class TestAop {
	
	
	public static void main(String[] arg0) throws Throwable{
		
		/**
		 * ��Ҫһ������,������Ҫ�����ܹ���չ��,���������˹����ʹ���ģʽ
		 * @param ԭ���� flamingo
		 * @param ���     aopMethod
		 * @throws Throwable
		 * 
		 */
		Bird fm = new Flamingo();
		AnnotationInjection aj = new AnnotationInjection();
		//ͨ��ע��ע��������
		fm = (Bird)aj.getBean(fm);
		Bird proxyFl = (Bird) ProxyFactory.newInstance(new ProxyHandler(fm, new Interceptor()));
		System.out.println(proxyFl.fly());
	}
}
