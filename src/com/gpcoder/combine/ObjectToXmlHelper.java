package com.gpcoder.combine;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ObjectToXmlHelper {
    //Chuyen doi tuong sang chuoi xml
    public static <T> String convertToXml(T obj){
        StringBuilder sb  = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
        sb.append(convertToXml(obj, 0));
        return sb.toString();
    }

    //Chuyen doi tuong sang chuoi xml
    private static <T> String convertToXml(T obj, int numOfTab){
        StringBuilder sb = new StringBuilder();

        //Get Class of obj
        Class<?> clazz = obj.getClass();
        boolean isXmlDoc = clazz.isAnnotationPresent(XmlRootElement.class);
        List<Field> fields;
        String name;
        String value;
        if(isXmlDoc){
            //Lấy ra đối tượng XmlRootElement, chú thích trên lớp này
            XmlRootElement rootNode = clazz.getAnnotation(XmlRootElement.class);

            sb.append(getTab(numOfTab)); //Add tab
            sb.append("<" + rootNode.name());
            sb.append("\n");


        }
        return sb.toString();
    }

    //Kiểm tra chuỗi không rỗng
    private static boolean isNotEmpty(String str){
        return str != null && !str.isEmpty();
    }
    //Lấy danh sách field có sử dụng Annotation ann
    private static List<Field> getFields(Class<?> clazz, Class<? extends Annotation> ann){
        List<Field> fieldAttributes = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        if(ann == null){
            fieldAttributes.addAll(Arrays.asList(fields));
        }
        else{
            for(Field field : fields){
                if(field.isAnnotationPresent(ann)){
                    fieldAttributes.add(field);
                }
            }
        }
        return fieldAttributes;
    }

    //Lấy giá trị kiểu chuỗi
    private static String getValueOfField(Field field, Object obj){
        String value = "";
        try{

        }
    }
}
