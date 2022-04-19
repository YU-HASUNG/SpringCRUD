package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostController {

    // HTML <Form>
    // ajax 검색
    // http 통신을 할때 post의 body에다가 data를 집어넣어서 보내겠다
    // produces를 통해 보낼 파일의 형태를 지정할 수 있다. json, xml, multipart-form, text-plain 등 (기본적으로 JSON)
    // ex) @PostMapping(value = "/postMethod", produces = {"application-json"})

    @PostMapping("/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam){ //RequestBody에 SeachParam이라는 값을 매칭시켜 주세요

        return searchParam;
    }
}
