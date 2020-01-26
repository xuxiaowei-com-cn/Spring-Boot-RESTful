package cn.com.xuxiaowei.controller;

import cn.com.xuxiaowei.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Post 请求
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@RestController
public class PostRestController {

    /**
     * 自增序列号
     */
    private final AtomicLong counter = new AtomicLong();

    /**
     * 获取实体类
     *
     * @param request
     * @param response
     * @return 返回实体类，使用 jackson 将 {@link User} 转换为 JSON
     * @see <a href="https://github.com/FasterXML/jackson">jackson</a>
     */
    @PostMapping(value = {"/postUser1"})
    public User postUser1(HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
        user.setUserId(counter.incrementAndGet());
        user.setUsername("徐晓伟");
        user.setPassword(UUID.randomUUID().toString().replace("-", ""));
        return user;
    }

}
