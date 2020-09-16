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
package cn.com.xuxiaowei.header;

import cn.com.xuxiaowei.util.RestTemplateUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.CustomRestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试 自定义 Header
 */
@Slf4j
@SpringBootTest
class GetTests {

    /**
     * 创建 RestTemplate 示例
     */
    private final CustomRestTemplate customRestTemplate = new CustomRestTemplate();

    /**
     * 放置 Header
     */
    private final HttpHeaders httpHeaders = new HttpHeaders();

    /**
     * URL，带参数，使用占位符，如果使用了参数，下面的 Map 必须有与之对应的 Key 值
     */
    private final String url = "http://127.0.0.1:8080/getUser1";

    /**
     * 放置参数的 Map
     */
    private final Map<String, String> uriVariables = new HashMap<>(4);

    @Test
    void getForEntity() {

        httpHeaders.add("testHeaderName", "testHeaderValue");
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);

        // 参数名与上面的占位符相同
        // 如果上面定义了参数了占位符，Map 中必须有与之对应的 key 值
        uriVariables.put("username", "xxw");

        String parameterUrl = RestTemplateUtils.parameterUrl(url, uriVariables);

        // 使用指定实体类解析返回结果
        ResponseEntity<String> forEntity = customRestTemplate.getForEntity(parameterUrl, requestEntity, String.class, uriVariables);

        log.debug(String.valueOf(forEntity));
    }

    @Test
    void getForObject() {

        httpHeaders.add("testHeaderName", "testHeaderValue");
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);

        // 参数名与上面的占位符相同
        // 如果上面定义了参数了占位符，Map 中必须有与之对应的 key 值
        uriVariables.put("username", "xxw");

        String parameterUrl = RestTemplateUtils.parameterUrl(url, uriVariables);

        // 使用指定实体类解析返回结果
        String getString = customRestTemplate.getForObject(parameterUrl, requestEntity, String.class, uriVariables);

        log.debug(getString);
    }

}
