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
import java.util.HashMap;
import java.util.Map;

/**
 * Spring Post {@link Object} 使用示例
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@RestController
public class PostForObjectRestController {

    /**
     * Post 根据 URL（字符串）、实体类 {@link User} 解析返回结果
     *
     * @param request
     * @param response
     * @return
     * @see RestTemplate#postForObject(String, Object, Class, Object...) 字符串类型的 URL
     */
    @PostMapping("/postForObject1")
    public User postForObject1(HttpServletRequest request, HttpServletResponse response) {

        // 创建 RestTemplate 示例
        RestTemplate restTemplate = new RestTemplate();

        // URL
        String url = request.getRequestURL().toString().replace(request.getRequestURI(), "/postUser1");

        // 使用指定实体类解析返回结果
        User user = restTemplate.postForObject(url, null, User.class);

        log.debug(String.valueOf(user));

        return user;
    }

    /**
     * Post 根据 URL（{@link URI}）、实体类 {@link User} 解析返回结果
     *
     * @param request
     * @param response
     * @return
     * @see RestTemplate#postForObject(URI, Object, Class) 字符串类型的 URL
     */
    @PostMapping("/postForObject2")
    public User postForObject2(HttpServletRequest request, HttpServletResponse response) throws URISyntaxException {

        // 创建 RestTemplate 示例
        RestTemplate restTemplate = new RestTemplate();

        // URL
        String url = request.getRequestURL().toString().replace(request.getRequestURI(), "/postUser1");

        // 使用指定实体类解析返回结果
        User user = restTemplate.postForObject(new URI(url), null, User.class);

        log.debug(String.valueOf(user));

        return user;
    }

    /**
     * Post 根据 URL（字符串）、{@link String} 解析返回结果
     *
     * @param request
     * @param response
     * @return
     * @see RestTemplate#postForObject(String, Object, Class, Object...) 字符串类型的 URL
     */
    @PostMapping("/postForObject3")
    public String postForObject3(HttpServletRequest request, HttpServletResponse response) {

        // 创建 RestTemplate 示例
        RestTemplate restTemplate = new RestTemplate();

        // URL
        String url = request.getRequestURL().toString().replace(request.getRequestURI(), "/postUser1");

        // 使用指定实体类解析返回结果
        String postString = restTemplate.postForObject(url, null, String.class);

        log.debug(postString);

        return postString;
    }

    /**
     * Post 根据 URL（字符串）、参数、{@link String} 解析返回结果
     *
     * @param request
     * @param response
     * @return
     * @see RestTemplate#postForObject(String, Object, Class, Map) 字符串类型的 URL
     */
    @PostMapping("/postForObject4")
    public String postForObject4(HttpServletRequest request, HttpServletResponse response) {

        // 创建 RestTemplate 示例
        RestTemplate restTemplate = new RestTemplate();

        // URL，带参数，使用占位符，如果使用了参数，下面的 Map 必须有与之对应的 Key 值
        String url = request.getRequestURL().toString().replace(request.getRequestURI(), "/postUser1?username={username}");

        // 放置参数的 Map
        Map<String, String> uriVariables = new HashMap<>(4);

        // 参数名与上面的占位符相同
        // 如果上面定义了参数了占位符，Map 中必须有与之对应的 key 值
        uriVariables.put("username", "xxw");

        // 使用指定实体类解析返回结果
        String postString = restTemplate.postForObject(url, null, String.class, uriVariables);

        log.debug(postString);

        return postString;
    }

}
