/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.com.xuxiaowei.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 主页
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@Controller
public class IndexController {

    /**
     * 主页、域名
     *
     * @param request  请求
     * @param response 响应
     * @param model    页面范围
     * @return 返回页面位置及名称
     */
    @RequestMapping(value = {"", "/index"})
    public String index(HttpServletRequest request, HttpServletResponse response, Model model) throws InterruptedException {

        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setConnectTimeout(1000);
//        simpleClientHttpRequestFactory.setReadTimeout(1000);

        RestTemplate restTemplate = new RestTemplate(simpleClientHttpRequestFactory);

        restTemplate.wait(1, 1);

        HttpHeaders httpHeaders = new HttpHeaders();
        // 设置请求参数流格式
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> map = new HashMap<>(4);

        HttpEntity<Map<?, ?>> httpEntity = new HttpEntity<>(map, httpHeaders);

        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://127.0.0.1:8080/restTemplate.json", httpEntity, String.class);

        log.info(stringResponseEntity.getBody());

        return "index";
    }

}
