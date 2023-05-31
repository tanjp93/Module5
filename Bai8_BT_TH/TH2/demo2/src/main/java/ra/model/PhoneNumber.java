package ra.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;
import java.util.Set;

@Component
public class PhoneNumber implements Validator {
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

//    @Override
//    public boolean supports(Class<?> clazz) {
//        return PhoneNumber.class.isAssignableFrom(clazz);
//    }

//    @Override
//    public void validate(Object target, Errors errors) {
//
//        PhoneNumber phoneNumber = (PhoneNumber) target;
//        String number = phoneNumber.getNumber();
//        ValidationUtils.rejectIfEmpty(errors, "number", "number.empty");
//        if (number.length()>11 || number.length()<10){
//            errors.rejectValue("number", "number.length");
//        }
//        if (!number.startsWith("0")){
//            errors.rejectValue("number", "number.startsWith");
//        }
//        if (!number.matches("(^$|[0-9]*$)")){
//            errors.rejectValue("number", "number.matches");
//        }
//    }

    @Override
    public <T> Set<ConstraintViolation<T>> validate(T object, Class<?>... groups) {
        return null;
    }

    @Override
    public <T> Set<ConstraintViolation<T>> validateProperty(T object, String propertyName, Class<?>... groups) {
        return null;
    }

    @Override
    public <T> Set<ConstraintViolation<T>> validateValue(Class<T> beanType, String propertyName, Object value, Class<?>... groups) {
        return null;
    }

    @Override
    public BeanDescriptor getConstraintsForClass(Class<?> clazz) {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> type) {
        return null;
    }

    @Override
    public ExecutableValidator forExecutables() {
        return null;
    }
}
