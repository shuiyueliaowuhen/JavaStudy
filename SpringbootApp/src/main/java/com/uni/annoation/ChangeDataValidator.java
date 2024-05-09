package com.uni.annoation;

import com.uni.model.Person;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ChangeDataValidator implements ConstraintValidator<ChangeData, List<Person>> {

    private final Set<Integer> values = new HashSet<>();
    private String msg = null;

    @Override
    public void initialize(ChangeData constraintAnnotation) {

    }

    @Override
    public boolean isValid(List<Person> list, ConstraintValidatorContext context) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if(list.get(i).getAge() >  10){
                list.remove(i);
            }

        }

        return true;
    }

}
