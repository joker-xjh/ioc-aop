package furioussoul.core.annotation;

import java.lang.annotation.*;

/**
 * Created by whf on 8/29/15.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface RequestMapping {
	String value();
}
