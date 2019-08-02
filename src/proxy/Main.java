package proxy;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Base {
    static int num = 1;
    
    static {
        System.out.println("Base " + num);
    }
}
public class Main {
   // public static void main(String[] args) throws ClassNotFoundException {
        // 不会初始化静态块
        Class clazz1 = Base.class;
    //    System.out.println("------");
        // 会初始化
   //     Class clazz2 = Class.forName("proxy.Base");
   // }
    public static void main(String[] args) throws Exception {
   	 Person person = new Person("luoxn28", 23);
   	 Class clazz = person.getClass();
   	//Method[] methods = clazz.getDeclaredMethods();
   	PropertyDescriptor descriptor = new PropertyDescriptor("name", clazz);
		Method m1 = descriptor.getReadMethod();
		String s = (String)m1.invoke(person);
		System.out.println(s);
   	/*clazz.getField("fid")
   	    Field[] fields = clazz.getDeclaredFields();
   	    for (Field field : fields) {
   	        String key = field.getName();
   	        PropertyDescriptor descriptor = new PropertyDescriptor(key, clazz);
   	        Method method = descriptor.getReadMethod();
   	        Object value = method.invoke(person);

   	        System.out.println(key + ":" + value);

   	    }*/
	}
}