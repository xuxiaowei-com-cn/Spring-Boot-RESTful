package cn.com.xuxiaowei.controller;

import cn.com.xuxiaowei.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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


}
