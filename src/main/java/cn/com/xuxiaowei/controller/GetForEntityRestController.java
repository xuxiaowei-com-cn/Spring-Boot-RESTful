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
import java.util.HashMap;
import java.util.Map;

/**
 * Spring Get {@link ResponseEntity} 使用示例
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
     * @see RestTemplate#getForEntity(URI, Class) {@link URI} 类型的 URL
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
    public ResponseEntity<String> getForEntity3(HttpServletRequest request, HttpServletResponse response) {

        // 创建 RestTemplate 示例
        RestTemplate restTemplate = new RestTemplate();

        // URL
        String url = request.getRequestURL().toString().replace(request.getRequestURI(), "/getUser1");

        // 使用指定实体类解析返回结果
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);

        log.debug(String.valueOf(forEntity));

        return forEntity;
    }

    /**
     * Get 根据 URL（字符串）、参数、{@link String} 解析返回结果
     *
     * @param request
     * @param response
     * @return
     * @see RestTemplate#getForEntity(String, Class, Map) 字符串类型的 URL
     */
    @GetMapping("/getForEntity4")
    public ResponseEntity<String> getForEntity4(HttpServletRequest request, HttpServletResponse response) {

        // 创建 RestTemplate 示例
        RestTemplate restTemplate = new RestTemplate();

        // URL，带参数，使用占位符，如果使用了参数，下面的 Map 必须有与之对应的 Key 值
        String url = request.getRequestURL().toString().replace(request.getRequestURI(), "/getUser1?username={username}");

        // 放置参数的 Map
        Map<String, String> uriVariables = new HashMap<>(4);

        // 参数名与上面的占位符相同
        // 如果上面定义了参数了占位符，Map 中必须有与之对应的 key 值
        uriVariables.put("username", "xxw");

        // 使用指定实体类解析返回结果
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class, uriVariables);

        log.debug(String.valueOf(forEntity));

        return forEntity;
    }

}
