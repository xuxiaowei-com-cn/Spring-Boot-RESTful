package cn.com.xuxiaowei.controller;

import cn.com.xuxiaowei.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Spring Post 使用示例
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@RestController
public class PostForObjectRestController {

    /**
     * Post 根据 URL（字符串）、实体类解析返回结果
     *
     * @param request
     * @param response
     * @return
     * @see RestTemplate#postForObject(String, Object, Class, Object...)   字符串类型的 URL
     */
    @PostMapping("/postForObject1")
    public User postForObject1(HttpServletRequest request, HttpServletResponse response) {

        // 创建 RestTemplate 示例
        RestTemplate restTemplate = new RestTemplate();

        // URL
        String url = request.getRequestURL().toString().replace(request.getRequestURI(), "/postUser1");

        // 使用指定实体类解析返回结果
        User postUser1 = restTemplate.postForObject(url, null, User.class);

        log.debug(String.valueOf(postUser1));

        return postUser1;
    }

    /**
     * Post 根据 URL（{@link URI}）、实体类解析返回结果
     *
     * @param request
     * @param response
     * @return
     * @see RestTemplate#postForObject(URI, Object, Class)  字符串类型的 URL
     */
    @PostMapping("/postForObject2")
    public User postForObject2(HttpServletRequest request, HttpServletResponse response) throws URISyntaxException {

        // 创建 RestTemplate 示例
        RestTemplate restTemplate = new RestTemplate();

        // URL
        String url = request.getRequestURL().toString().replace(request.getRequestURI(), "/postUser1");

        // 使用指定实体类解析返回结果
        User postUser1 = restTemplate.postForObject(new URI(url), null, User.class);

        log.debug(String.valueOf(postUser1));

        return postUser1;
    }

}
