package util;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String,Date> {
    @Override
    public Date convert(String s) {
        System.out.println("转换器");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
           parse = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }
}
