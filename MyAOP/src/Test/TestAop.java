package Test;

import Model.Bird;
import Model.Flamingo;
import annotation.AnnotationInjection;
import interceptor.Inteceptor;
import jdk_proxy.ProxyFactory;
import jdk_proxy.ProxyHandler;

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
		Bird proxyFl = (Bird) ProxyFactory.newInstance(new ProxyHandler(fm, new Inteceptor()));
		System.out.println(proxyFl.fly());
	}
}
