package annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationInjection {

	public Object getBean(Object obj) {
		try {
			// ���������
			Field f[] = obj.getClass().getDeclaredFields();
			// ��������
			for (Field ff : f) {
				// ��������ϵ�ע��
				AOP a = ff.getAnnotation(AOP.class);
				if ( a != null) {
					System.err.println("ע��" + ff.getName() + "����" + "\t\t" +  a.name());
					// �������public set����,���Ϊ���ʼ���private,��ô����ֱ��ʹ�����Ե�set(obj,
					// value);
					System.out.println("set" + ff.getName().substring(0, 1).toUpperCase() + ff.getName().substring(1));
					obj.getClass()
							.getMethod("set" + ff.getName().substring(0, 1).toUpperCase() + ff.getName().substring(1),
									new Class<?>[] { String.class })
							.invoke(obj, a.name());
				}
			}
			// ������з���
			Method m[] = obj.getClass().getDeclaredMethods();
			for (Method mm : m) {
				// ��÷���ע��
				AOP a = mm.getAnnotation(AOP.class);
				if (a != null) {
					System.err.println("ע��" + mm.getName() + "����" + "\t" + a.name());
					mm.invoke(obj, a.name());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
}
