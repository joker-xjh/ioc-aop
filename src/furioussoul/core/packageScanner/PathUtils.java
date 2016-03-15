package furioussoul.core.packageScanner;

import java.io.File;
import java.io.IOException;
import java.util.List;

import furioussoul.core.annotation.Component;

public class PathUtils {

	private PathUtils() {}

	/**
	 * 把路径字符串转换为包名. a/b/c/d -> a.b.c.d
	 *
	 * @param path
	 * @return
	 */
	public static String pathToPackage(String path) {
		if (path.startsWith("/")) {
			path = path.substring(1);
		}

		return path.replaceAll("/", ".");
	}

	/**
	 * 包名转换为路径名    separator:/
	 * 
	 * @param pkg
	 * @return
	 */
	public static String packageToPath(String pkg) {
		return pkg.replace(".", File.separator);
	}

	/**
	 * 将多个对象转换成字符串并连接起来
	 * 
	 * @param objs
	 * @return
	 */
	public static String concat(Object... objs) {
		StringBuilder sb = new StringBuilder(30);
		for (int ix = 0; ix < objs.length; ++ix) {
			sb.append(objs[ix]);
		}

		return sb.toString();
	}

	/**
	 * 去掉文件的后缀名
	 * 
	 * @param name
	 * @return
	 */
	public static String trimSuffix(String name) {
		int dotIndex = name.indexOf('.');
		if (-1 == dotIndex) {
			return name;
		}

		return name.substring(0, dotIndex);
	}

	public static String distillPathFromJarURL(String url) {
		int startPos = url.indexOf(':');
		int endPos = url.lastIndexOf('!');

		return url.substring(startPos + 1, endPos);
	}

	public static void main(String[] args) throws IOException {
		String s = "furioussoul.core.annotation";
		PkgScanner scanner = new PkgScanner(s,Component.class);
		List<String> clazzUrlList = scanner.scan();
		if(clazzUrlList == null){
			return ;
		}
		for(String clazzUrl : clazzUrlList){
			System.out.println(clazzUrl);
		}
	
	}

}
