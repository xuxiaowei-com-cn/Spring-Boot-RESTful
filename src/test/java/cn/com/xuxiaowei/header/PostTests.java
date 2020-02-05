package cn.com.xuxiaowei.header;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试 自定义 Header
 */
@Slf4j
@SpringBootTest
class PostTests {

    /**
     * 创建 RestTemplate 示例
     */
    private RestTemplate restTemplate = new RestTemplate();

    /**
     * 放置 Header
     */
    private HttpHeaders httpHeaders = new HttpHeaders();

    /**
     * URL，带参数，使用占位符，如果使用了参数，下面的 Map 必须有与之对应的 Key 值
     */
    private String url = "http://127.0.0.1:8080/postUser1?username={username}";

    /**
     * 放置参数的 Map
     */
    private Map<String, String> uriVariables = new HashMap<>(4);

    @Test
    void postForEntity() {

        httpHeaders.add("testHeaderName", "testHeaderValue");
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);

        // 参数名与上面的占位符相同
        // 如果上面定义了参数了占位符，Map 中必须有与之对应的 key 值
        uriVariables.put("username", "xxw");

        // 使用指定实体类解析返回结果
        ResponseEntity<String> forEntity = restTemplate.postForEntity(url, requestEntity, String.class, uriVariables);

        log.debug(String.valueOf(forEntity));
    }

    @Test
    void postForObject() {

        httpHeaders.add("testHeaderName", "testHeaderValue");
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);

        // 参数名与上面的占位符相同
        // 如果上面定义了参数了占位符，Map 中必须有与之对应的 key 值
        uriVariables.put("username", "xxw");

        // 使用指定实体类解析返回结果
        String postString = restTemplate.postForObject(url, requestEntity, String.class, uriVariables);

        log.debug(postString);
    }

}
