package cn.com.xuxiaowei.controller;

import cn.com.xuxiaowei.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Get 请求
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Controller
public class GetController {

    /**
     * 获取实体类
     *
     * @param request
     * @param response
     * @return 返回实体类，使用 jackson 将 {@link User} 转换为 JSON
     * @see <a href="https://github.com/FasterXML/jackson">jackson</a>
     */
    @ResponseBody
    @GetMapping(value = {"/getUser1"})
    public User getUser1(HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
        user.setUserId(System.currentTimeMillis());
        user.setUsername("徐晓伟");
        user.setPassword(UUID.randomUUID().toString().replace("-", ""));
        return user;
    }

}
