package annotionTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
@ClassAnnotation
public class Test {
	
	private int age;
	
	@FieldAnnotation
	private String name;
	
	@FieldAnnotation(description="23423432432")
	private String description;
	
	@MethodAnnotation
	public String getString(){
		return "2222222222222";
	}

	public static void main(String[] args) {
		try {
			 Method method = Test.class.getMethod("getString");
			 boolean b = method.isAnnotationPresent(MethodAnnotation.class);
			 System.out.println(b);
			 System.out.println(method.isAnnotationPresent(ClassAnnotation.class));
			 System.out.println(Test.class.isAnnotationPresent(ClassAnnotation.class));
			 System.out.println("---------------classAnnotation");
			Annotation[]  ans = Test.class.getAnnotations();
			for(Annotation a : ans){
				if(a instanceof ClassAnnotation){
					int age = ((ClassAnnotation)a).age();
					System.out.println("age:"+age);
				}
				if(a instanceof FieldAnnotation){
					String name = ((FieldAnnotation)a).name();
					String description = ((FieldAnnotation)a).description();
					System.out.println("name:"+name +" description:"+description);
					
					
				}
			}
			System.out.println("---------------MethodAnnotation");
			Annotation[]  ansm = method.getAnnotations();
			for(Annotation a : ansm){
				if(a instanceof MethodAnnotation){
					String name = ((MethodAnnotation)a).name();
					String value = ((MethodAnnotation)a).value();
					System.out.println("name:"+name +" value:"+value);	
				}
				
			}
			System.out.println("---------------FieldAnnotation");
			Field field = Test.class.getDeclaredField("name");
			Annotation[]  ansf = field.getAnnotations();
			for(Annotation a : ansf){
				if(a instanceof FieldAnnotation){
					String name = ((FieldAnnotation)a).name();
					String description = ((FieldAnnotation)a).description();
					System.out.println("name:"+name +" description:"+description);	
				}
				
			}
			Class<?> test = Class.forName("annotionTest.Test");
			Field[]  fe  = test.getDeclaredFields();
			for(Field f: fe){
				System.out.println(f.getName());
				
			}
			Test t = (Test) test.newInstance();
			t.age = 11;
			System.out.println("setAge:" + t.age);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
