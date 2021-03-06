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
package cn.com.xuxiaowei.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MVC配置
 *
 * @author xuxiaowei
 * @see <a href="https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-stereotype-annotations">@Component and Further Stereotype Annotations</a>@Component、@Service、@Controller、@Repository
 * @see <a href="https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-config-enable">Enable MVC Configuration</a>启用MVC配置
 * @since 0.0.1
 */
@Configuration
@EnableWebMvc
public class WebMvcConfigurerConfiguration implements WebMvcConfigurer {

    /**
     * 自动将 {@link RequestMapping} 包括 {@link RequestMapping} 的拓展注解 增加 URL 后缀名，并根据后缀名去请求解析数据
     * <p>
     * 要求：
     * 使用某个后缀名时，需要 {@link RequestMapping} 包括 {@link RequestMapping} 的拓展注解 和 下方的 {@link MediaType} 有相同的值，
     * 或者 {@link RequestMapping} 包括 {@link RequestMapping} 的拓展注解不使用 {@link MediaType}
     *
     * @see <a href="https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-config-content-negotiation">mvc-config-content-negotiation</a>
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        configurer.mediaType("json", MediaType.APPLICATION_JSON);
        configurer.mediaType("xml", MediaType.APPLICATION_XML);

    }

}
