package com.my.controller;

import com.my.entity.Users;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author hutf
 * @createTime 2020年10月22日 11:05:00
 */
@RestController
@CrossOrigin
public class TestApi {

    /**
     * Annotation method validate
     */
    @RequestMapping("/testAnnotation")
    public String testAnnotation(@RequestBody @Valid Users users) {
        return "OK";
    }

    /**
     * BindingResult Method validate
     */
    @RequestMapping("/testBindingResult")
    public String testBindingResult(@RequestBody @Valid Users users, BindingResult bindingResult) {
        StringBuffer sb = new StringBuffer();
        if (bindingResult.hasErrors()) {
            List<ObjectError> errorList = bindingResult.getAllErrors();
            for (ObjectError error : errorList) {
                sb.append(error.getDefaultMessage());
                sb.append(";");
            }
        }
        return sb.toString();
    }

    /**
     * validation buildDefault
     */
    @RequestMapping("/buildDefault")
    public String buildDefault(@RequestBody @Valid Users users) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Users>> validate = validator.validate(users, Users.class);
        Iterator<ConstraintViolation<Users>> iterator = validate.iterator();

        StringBuffer sb = new StringBuffer();
        while (iterator.hasNext()) {
            ConstraintViolation<Users> next = iterator.next();
            sb.append(next.getMessage());
        }

        return sb.toString();
    }
    /**
     *
     * {
     *   "id": 0,
     *   "name": "",
     *   "age": 0,
     *   "createTime": "2020-10-55T03:31:15.448+00:00"
     * }
     * http://localhost:8002/buildDefault
     *
     */


}
