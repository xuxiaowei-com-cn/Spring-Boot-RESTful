package cn.com.xuxiaowei.controller;

import cn.com.xuxiaowei.entity.User;
import lombok.extern.slf4j.Slf4j;
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
public class GetForObjectRestController {

    /**
     * Get 根据实体类解析返回结果
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/getForObject1")
    public User getForObject1(HttpServletRequest request, HttpServletResponse response) {

        // 创建 RestTemplate 示例
        RestTemplate restTemplate = new RestTemplate();

        // URL
        String url = request.getRequestURL().toString().replace(request.getRequestURI(), "/getUser1");

        // 使用指定实体类解析返回结果
        User getUser1 = restTemplate.getForObject(url, User.class);

        log.debug(String.valueOf(getUser1));

        return getUser1;
    }


}
