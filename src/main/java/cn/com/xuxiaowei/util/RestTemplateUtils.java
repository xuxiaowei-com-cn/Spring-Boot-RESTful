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
package cn.com.xuxiaowei.util;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.List;

/**
 * {@link RestTemplate} 工具类
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
public class RestTemplateUtils {

    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

    /**
     * 获取指定编码类型的响应数据返回
     *
     * @param charset 编码
     * @return 返回 获取指定编码类型的响应数据
     */
    public static RestTemplate charset(Charset charset) {
        List<HttpMessageConverter<?>> messageConverters = REST_TEMPLATE.getMessageConverters();
        messageConverters.set(1, new StringHttpMessageConverter(charset));
        return REST_TEMPLATE;
    }

    /**
     * 获取 GBK 编码类型的响应数据返回
     *
     * @return 返回 获取 GBK 编码类型的响应数据
     */
    public static RestTemplate charsetGbk() {
        return charset(Charset.forName("GBK"));
    }

}
