package cn.com.xuxiaowei.controller;

import cn.com.xuxiaowei.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Get 请求
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@RestController
public class GetController {

    /**
     * %s：占位符，使用 {@link String#format(String, Object...)} 替换占位符
     */
    private static final String template = "Hello, %s!";

    /**
     * 获取实体类
     *
     * @param request
     * @param response
     * @return 返回实体类，使用 jackson 将 {@link User} 转换为 JSON
     * @see <a href="https://github.com/FasterXML/jackson">jackson</a>
     */
    @GetMapping(value = {"/getUser1"})
    public User getUser1(HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
        user.setUserId(System.currentTimeMillis());
        user.setUsername("徐晓伟");
        user.setPassword(UUID.randomUUID().toString().replace("-", ""));
        return user;
    }

    /**
     * 具有参数的 Get 请求
     *
     * @param request
     * @param response
     * @param name     姓名，如果未传入，默认为：World，
     *                 {@link RequestParam#value()}：接收参数的名称
     *                 {@link RequestParam#defaultValue()}：默认值
     * @return
     */
    @GetMapping(value = {"/getHi"})
    public String getHi(HttpServletRequest request, HttpServletResponse response,
                        @RequestParam(value = "name", defaultValue = "World") String name) {

        return String.format(template, name);
    }

}
