package com.my;

import com.my.entity.ThirdInfo;
import com.my.entity.ThirdList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

@SpringBootApplication
@RestController
@CrossOrigin
public class ThirdServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThirdServiceApplication.class, args);
    }


    @GetMapping("/thirdApiGet")
    public Map<String, Object> thirdApi() throws InterruptedException {
        int i = 0;
        while (true) {
            System.out.println("当前业务 - " + i + " 正在执行!!!!!!!!");
            Thread.sleep(1000);
            i++;
            if (i > 10) {
                break;
            }
        }

        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", "success");
        return result;
    }

    /**
     * Post
     */
    @PostMapping("/thirdApiPost")
    public String thirdApi(@RequestParam Map<String, Object> map, HttpServletRequest request) throws InterruptedException {
        System.out.println(map);
        return "OK";
    }

    @PostMapping("/thirdApiPost2")
    public String thirdApi2(@RequestBody List<ThirdInfo> params, HttpServletRequest request) throws InterruptedException {
        System.out.println(params);
        return "OK";
    }

//    @PostMapping("/thirdApiPost3")
//    public String thirdApi3(@RequestBody @Validated ThirdList thirdList, HttpServletRequest request) throws InterruptedException {
//        System.out.println(thirdList);
//        return "OK";
//    }

    @PostMapping(value = "/thirdApiPost3")
    public String thirdApi3(@RequestBody @Validated ThirdList thirdList, HttpServletRequest request) throws InterruptedException {
        System.out.println(thirdList);
        return "OK";
    }

    @PostMapping("/thirdApiPostManyParam")
    public String thirdApiPostManyParam(@RequestParam Map<String, Object> map, HttpServletRequest request) throws InterruptedException {
        System.out.println(map);
        return "OK";
    }

    @PostMapping("/thirdApi1")
    public Map<String, Object>  thirdApi1(@Valid ThirdInfo thirdInfo, BindingResult bindingResult) {
        Map<String, Object> result = new HashMap<>();
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
            StringBuffer sb = new StringBuffer();
            for (FieldError fieldError : fieldErrorList) {
                sb.append(fieldError.getDefaultMessage() + "  ");
            }
            result.put("code", 100);
            result.put("msg", sb.toString());
            return result;
        }

        result.put("code", 200);
        result.put("msg", "success");
        return result;
    }


}
