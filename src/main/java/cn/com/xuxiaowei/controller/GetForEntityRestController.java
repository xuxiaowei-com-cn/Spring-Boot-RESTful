package cn.com.xuxiaowei.controller;

import cn.com.xuxiaowei.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Spring Get 使用示例
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@RestController
public class GetForEntityRestController {

    /**
     * Get 根据 URL（字符串）、实体类 {@link User} 解析返回结果
     *
     * @param request
     * @param response
     * @return
     * @see RestTemplate#getForEntity(String, Class, Object...) 字符串类型的 URL
     */
    @GetMapping("/getForEntity1")
    public ResponseEntity<User> getForEntity1(HttpServletRequest request, HttpServletResponse response) {

        // 创建 RestTemplate 示例
        RestTemplate restTemplate = new RestTemplate();

        // URL
        String url = request.getRequestURL().toString().replace(request.getRequestURI(), "/getUser1");

        // 使用指定实体类解析返回结果
        ResponseEntity<User> forEntity = restTemplate.getForEntity(url, User.class);

        log.debug(String.valueOf(forEntity));

        return forEntity;
    }

    /**
     * Get 根据 URL（{@link URI}）、实体类 {@link User} 解析返回结果
     *
     * @param request
     * @param response
     * @return
     * @see RestTemplate#getForEntity(URI, Class)  {@link URI} 类型的 URL
     */
    @GetMapping("/getForEntity2")
    public ResponseEntity<User> getForEntity2(HttpServletRequest request, HttpServletResponse response) throws URISyntaxException {

        // 创建 RestTemplate 示例
        RestTemplate restTemplate = new RestTemplate();

        // URL
        String url = request.getRequestURL().toString().replace(request.getRequestURI(), "/getUser1");

        // 使用指定实体类解析返回结果
        ResponseEntity<User> forEntity = restTemplate.getForEntity(new URI(url), User.class);

        log.debug(String.valueOf(forEntity));

        return forEntity;
    }

    /**
     * Get 根据 URL（字符串）、{@link String} 解析返回结果
     *
     * @param request
     * @param response
     * @return
     * @see RestTemplate#getForEntity(String, Class, Object...) 字符串类型的 URL
     */
    @GetMapping("/getForEntity3")
    public ResponseEntity<String> getForEntity3(HttpServletRequest request, HttpServletResponse response) throws URISyntaxException {

        // 创建 RestTemplate 示例
        RestTemplate restTemplate = new RestTemplate();

        // URL
        String url = request.getRequestURL().toString().replace(request.getRequestURI(), "/getUser1");

        // 使用指定实体类解析返回结果
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);

        log.debug(String.valueOf(forEntity));

        return forEntity;
    }

}
