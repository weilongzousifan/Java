package cn.itcast.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName StringToDateConverter.java
 * @Description TODO
 * @createTime 2020年02月18日 16:40:00
 *
 * 字符串转日期类型
 */
public class StringToDateConverter implements Converter<String,Date> {

//  source：传入的字符串
    @Override
    public Date convert(String source) {

        if (source==null){
            throw  new RuntimeException("内容为空");
        }
//        字符串转日期
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        try {
           return  df.parse(source);
        } catch (Exception e) {
            throw  new RuntimeException("类型转换错误");
        }

    }


}
