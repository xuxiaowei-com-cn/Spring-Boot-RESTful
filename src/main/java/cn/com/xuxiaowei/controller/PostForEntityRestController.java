package cn.com.xuxiaowei.controller;

import cn.com.xuxiaowei.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Spring Post {@link ResponseEntity} 使用示例
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@RestController
public class PostForEntityRestController {

    /**
     * Post 根据 URL（字符串）、实体类 {@link User} 解析返回结果
     *
     * @param request
     * @param response
     * @return
     * @see RestTemplate#postForEntity(String, Object, Class, Object...)  字符串类型的 URL
     */
    @PostMapping("/postForEntity1")
    public ResponseEntity<User> postForEntity1(HttpServletRequest request, HttpServletResponse response) {

        // 创建 RestTemplate 示例
        RestTemplate restTemplate = new RestTemplate();

        // URL
        String url = request.getRequestURL().toString().replace(request.getRequestURI(), "/postUser1");

        // 使用指定实体类解析返回结果
        ResponseEntity<User> forEntity = restTemplate.postForEntity(url, null, User.class);

        log.debug(String.valueOf(forEntity));

        return forEntity;
    }

    /**
     * Post 根据 URL（{@link URI}）、实体类 {@link User} 解析返回结果
     *
     * @param request
     * @param response
     * @return
     * @see RestTemplate#postForEntity(URI, Object, Class)  {@link URI} 类型的 URL
     */
    @PostMapping("/postForEntity2")
    public ResponseEntity<User> postForEntity2(HttpServletRequest request, HttpServletResponse response) throws URISyntaxException {

        // 创建 RestTemplate 示例
        RestTemplate restTemplate = new RestTemplate();

        // URL
        String url = request.getRequestURL().toString().replace(request.getRequestURI(), "/postUser1");

        // 使用指定实体类解析返回结果
        ResponseEntity<User> forEntity = restTemplate.postForEntity(new URI(url), null, User.class);

        log.debug(String.valueOf(forEntity));

        return forEntity;
    }

    /**
     * Post 根据 URL（字符串）、{@link String} 解析返回结果
     *
     * @param request
     * @param response
     * @return
     * @see RestTemplate#postForEntity(String, Object, Class, Object...)  字符串类型的 URL
     */
    @PostMapping("/postForEntity3")
    public ResponseEntity<String> postForEntity3(HttpServletRequest request, HttpServletResponse response) {

        // 创建 RestTemplate 示例
        RestTemplate restTemplate = new RestTemplate();

        // URL
        String url = request.getRequestURL().toString().replace(request.getRequestURI(), "/postUser1");

        // 使用指定实体类解析返回结果
        ResponseEntity<String> forEntity = restTemplate.postForEntity(url, null, String.class);

        log.debug(String.valueOf(forEntity));

        return forEntity;
    }

}
