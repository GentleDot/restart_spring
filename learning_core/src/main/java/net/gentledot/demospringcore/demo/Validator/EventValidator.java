package net.gentledot.demospringcore.demo.Validator;

import net.gentledot.demospringcore.demo.book.Event;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EventValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Event.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "notEmpty", "defaultMessage.");
        /*
        Event event = (Event) target;
        if (event.getTitle() == null) {
            // 전반적인 에러 처리
            errors.reject();
            // 특정 field 값의 에러 처리
            errors.rejectValue();
        }
        */
    }
}
