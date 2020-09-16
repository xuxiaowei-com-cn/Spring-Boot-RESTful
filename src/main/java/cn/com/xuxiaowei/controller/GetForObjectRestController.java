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

import cn.com.xuxiaowei.entity.User;
import cn.com.xuxiaowei.util.RestTemplateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Spring Get {@link Object} 使用示例
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@RestController
public class GetForObjectRestController {

    /**
     * Get 根据 URL（字符串）、实体类 {@link User} 解析返回结果
     *
     * @param request  请求
     * @param response 响应
     * @return 返回实体类
     * @see RestTemplate#getForObject(String, Class, Object...) 字符串类型的 URL
     */
    @GetMapping("/getForObject1")
    public User getForObject1(HttpServletRequest request, HttpServletResponse response) {

        // 创建 RestTemplate 示例
        RestTemplate restTemplate = new RestTemplate();

        // URL
        String url = request.getRequestURL().toString().replace(request.getRequestURI(), "/getUser1");

        // 使用指定实体类解析返回结果
        User user = restTemplate.getForObject(url, User.class);

        log.debug(String.valueOf(user));

        return user;
    }

    /**
     * Get 根据 URL（{@link URI}）、实体类 {@link User} 解析返回结果
     *
     * @param request  请求
     * @param response 响应
     * @return 返回实体类
     * @see RestTemplate#getForObject(URI, Class) {@link URI} 类型的 URL
     */
    @GetMapping("/getForObject2")
    public User getForObject2(HttpServletRequest request, HttpServletResponse response) throws URISyntaxException {

        // 创建 RestTemplate 示例
        RestTemplate restTemplate = new RestTemplate();

        // URL
        String url = request.getRequestURL().toString().replace(request.getRequestURI(), "/getUser1");

        // 使用指定实体类解析返回结果
        User user = restTemplate.getForObject(new URI(url), User.class);

        log.debug(String.valueOf(user));

        return user;
    }

    /**
     * Get 根据 URL（字符串）、{@link String} 解析返回结果
     *
     * @param request  请求
     * @param response 响应
     * @return 返回实体类
     * @see RestTemplate#getForObject(String, Class, Object...) 字符串类型的 URL
     */
    @GetMapping("/getForObject3")
    public String getForObject3(HttpServletRequest request, HttpServletResponse response) {

        // 创建 RestTemplate 示例
        RestTemplate restTemplate = new RestTemplate();

        // URL
        String url = request.getRequestURL().toString().replace(request.getRequestURI(), "/getUser1");

        // 使用指定实体类解析返回结果
        String getString = restTemplate.getForObject(url, String.class);

        log.debug(getString);

        return getString;
    }

    /**
     * Get 根据 URL（字符串）、参数、{@link String} 解析返回结果
     *
     * @param request  请求
     * @param response 响应
     * @return 返回实体类
     * @see RestTemplate#getForObject(String, Class, Map) 字符串类型的 URL
     */
    @GetMapping("/getForObject4")
    public String getForObject4(HttpServletRequest request, HttpServletResponse response) throws URISyntaxException {

        // 创建 RestTemplate 示例
        RestTemplate restTemplate = new RestTemplate();

        // URL，带参数，使用占位符，如果使用了参数，下面的 Map 必须有与之对应的 Key 值
        String url = request.getRequestURL().toString().replace(request.getRequestURI(), "/getUser1");

        // 放置参数的 Map
        Map<String, String> uriVariables = new HashMap<>(4);

        // 参数名与上面的占位符相同
        // 如果上面定义了参数了占位符，Map 中必须有与之对应的 key 值
        uriVariables.put("username", "xxw");

        String parameterUrl = RestTemplateUtils.parameterUrl(url, uriVariables);

        // 使用指定实体类解析返回结果
        String getString = restTemplate.getForObject(parameterUrl, String.class, uriVariables);

        log.debug(String.valueOf(getString));

        return getString;
    }

}
