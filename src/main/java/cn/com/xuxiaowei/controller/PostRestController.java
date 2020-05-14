/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.com.xuxiaowei.controller;

import cn.com.xuxiaowei.entity.User;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
public class PostRestController {

    /**
     * 自增序列号
     */
    private final AtomicLong counter = new AtomicLong();

    /**
     * 获取实体类
     *
     * @param request  请求
     * @param response 响应
     * @param username 参数
     * @return 返回实体类，使用 jackson 将 {@link User} 转换为 JSON
     * @see <a href="https://github.com/FasterXML/jackson">jackson</a>
     */
    @PostMapping("/postUser1")
    public User postUser1(HttpServletRequest request, HttpServletResponse response, String username) {

        String testHeaderName = request.getHeader("testHeaderName");
        log.debug("接收到的 Header：testHeaderName：{}", testHeaderName);

        log.debug("username：{}", username);
        User user = new User();
        user.setUserId(counter.incrementAndGet());
        user.setUsername("徐晓伟");
        user.setPassword(UUID.randomUUID().toString().replace("-", ""));
        log.debug("user：{}", user);
        return user;
    }

}
