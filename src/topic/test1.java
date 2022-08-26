package topic;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author: ywx
 * @description
 * @Date: 2022/07/28
 */

public class test1 {
    private String name;
    private static String desc;

    public test1(String name) {
        this.name = name;
    }

    public test1() {
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("topic.test1");
        Field[] fields = aClass.getDeclaredFields();
        for(Field field:fields){
            if (Modifier.isStatic(field.getModifiers())){
                System.out.println("static:"+field.getName());
            }else {
                System.out.println("gen:"+field.getName());
            }
        }
        test1 o = (test1)aClass.newInstance();
    }
}
