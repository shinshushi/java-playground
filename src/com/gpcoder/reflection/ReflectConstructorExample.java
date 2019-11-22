package com.gpcoder.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectConstructorExample {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException{

        Class<Cat> aClass = Cat.class;
        Constructor<?> cons = aClass.getConstructor(String.class, int.class);
        System.out.println("Params: ");
        Class<?> [] paramClasses = cons.getParameterTypes();
        for(Class<?> paramClass: paramClasses){
            System.out.println("+ " + paramClass.getSimpleName());
        }

        //Khoi tao doi tuong Cat theo cach thong thuong
        Cat tom = new Cat("Tom", 1);
        System.out.println("Cat 1: " + tom.getName() + ", age = " + tom.getAge());

        //Khoi tao doi tuong Cat theo cach cua reflect
        Cat tom2 = (Cat) cons.newInstance("Tom", 2);
        System.out.println("Cat 2: " + tom2.getName() + ", age = " + tom2.getAge());
    }
}
