package de.tu_berlin.ise.open_data.service;

import de.tu_berlin.ise.open_data.model.Schema;
import org.joda.time.DateTime;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class ApplicationServiceImpl implements ApplicationService {

    @Override
    public String[] getFields(Class<? extends Object> aClass) {

        Field[] aClassDeclaredFields = aClass.getDeclaredFields();

        String[] fieldsArray = new String[aClassDeclaredFields.length];

        for (int index = 0; index < aClassDeclaredFields.length; index++)
            fieldsArray[index] = aClassDeclaredFields[index].getName();

        return fieldsArray;
    }

    @Override
    public Double parseToDouble(String number) {

        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException e) {
            return null;
        }

    }

    @Override
    public String toISODateFormat(String date) {

        DateTime dateTime = new DateTime(date);

        return dateTime.toDateTimeISO().toString();
    }

    @Override
    public String toISODateFormat(String simpleISODate, String appendableTimeAndOffset) {

        DateTime dateTime = new DateTime(simpleISODate + appendableTimeAndOffset);

        return dateTime.toDateTimeISO().toString();
    }

    @Override
    public LineMapper createLineMapper(Class<? extends Schema> aClass) throws IllegalAccessException, InstantiationException {
        return new DefaultLineMapper<Schema>() {{
            setLineTokenizer(new DelimitedLineTokenizer(aClass.newInstance().getDelimiter()) {{
                setNames(getFields(aClass));
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Schema>() {{
                setTargetType(aClass);
            }});
        }};
    }
}
