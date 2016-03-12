package annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationInjection {

	public Object getBean(Object obj) {
		try {
			// 获得类属性
			Field f[] = obj.getClass().getDeclaredFields();
			// 遍历属性
			for (Field ff : f) {
				// 获得属性上的注解
				AOP a = ff.getAnnotation(AOP.class);
				if ( a != null) {
					System.err.println("注入" + ff.getName() + "属性" + "\t\t" +  a.name());
					// 反射调用public set方法,如果为访问级别private,那么可以直接使用属性的set(obj,
					// value);
					System.out.println("set" + ff.getName().substring(0, 1).toUpperCase() + ff.getName().substring(1));
					obj.getClass()
							.getMethod("set" + ff.getName().substring(0, 1).toUpperCase() + ff.getName().substring(1),
									new Class<?>[] { String.class })
							.invoke(obj, a.name());
				}
			}
			// 获得所有方法
			Method m[] = obj.getClass().getDeclaredMethods();
			for (Method mm : m) {
				// 获得方法注解
				AOP a = mm.getAnnotation(AOP.class);
				if (a != null) {
					System.err.println("注入" + mm.getName() + "方法" + "\t" + a.name());
					mm.invoke(obj, a.name());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
}
