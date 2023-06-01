package ra.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class User implements Validator {
    private int id;
    private String userName;
    private String firstName;
    private String lastName;

    private String password;
    private String phoneNumber;
    private int age;
    private String email;


    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        String userName = user.userName;
        ValidationUtils.rejectIfEmpty(errors, "userName", "userName.empty");
        if (userName.trim().length() > 12 || userName.trim().length() < 4) {
            errors.rejectValue("userName", "userName.length");
        }
        if (!userName.matches("^[a-zA-Z0-9!@#$%^&*()]+$")) {
            errors.rejectValue("userName", "userName.matches");
        }
        String firstName = user.firstName;
        ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName.empty");

        String lastName = user.lastName;
        ValidationUtils.rejectIfEmpty(errors, "lastName", "lastName.empty");

        String password = user.password;
        ValidationUtils.rejectIfEmpty(errors, "password", "password.empty");
        if (password.trim().length() > 12 || password.trim().length() < 4) {
            errors.rejectValue("password", "password.length");
        }
        if (!password.matches("^[a-zA-Z0-9!@#$%^&*()]+$")) {
            errors.rejectValue("password", "password.matches");
        }
        String phoneNumber = user.phoneNumber;
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "phoneNumber.empty");
        if (phoneNumber.trim().length() > 11 || phoneNumber.trim().length() < 9) {
            errors.rejectValue("phoneNumber", "phoneNumber.length");
        }
        if (!phoneNumber.matches("^[0-9]+$")) {
            errors.rejectValue("phoneNumber", "phoneNumber.matches");
        }
        int age = user.age;
        if (age < 18) {
            errors.rejectValue("age", "age.checkAge");
        }
        String email = user.email;
        ValidationUtils.rejectIfEmpty(errors, "email", "email.empty");
        if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            errors.rejectValue("email", "email.matches");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
