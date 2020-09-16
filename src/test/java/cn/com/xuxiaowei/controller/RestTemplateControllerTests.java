package cn.com.xuxiaowei.controller;

import cn.com.xuxiaowei.util.RestTemplateUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * RestTemplate 接口 测试类
 * <p>
 * 注意：若参数值为数组，请使用 {@link MultiValueMap}，
 * 如：<code>MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();</code>
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@SpringBootTest
public class RestTemplateControllerTests {

    /**
     * 响应 默认 数据
     */
    private static final String APPLICATION_URL = "http://127.0.0.1:8080/restTemplate";

    /**
     * 响应 json 数据
     */
    private static final String APPLICATION_JSON_URL = "http://127.0.0.1:8080/restTemplate.json";

    /**
     * 响应 xml 数据
     */
    private static final String APPLICATION_JSON_XML = "http://127.0.0.1:8080/restTemplate.xml";

    @Autowired
    private RestTemplateController restTemplateController;

    /**
     * 将数据使用流发送
     */
    @Test
    void postForEntityInputStream() {
        Map<String, Object> map = new HashMap<>();
        map.put("UUID", UUID.randomUUID().toString());

        ResponseEntity<String> responseEntity = RestTemplateUtils.postForEntityInputStream(APPLICATION_JSON_URL, map, MediaType.APPLICATION_JSON, String.class);

        log.info("StatusCode：{}", responseEntity.getStatusCode());
        log.info("Headers：{}", responseEntity.getHeaders());
        log.info("Body：{}", responseEntity.getBody());
    }

    /**
     * 将数据使用流发送
     */
    @Test
    void postForObjectInputStream() {
        Map<String, Object> map = new HashMap<>();
        map.put("UUID", UUID.randomUUID().toString());

        String response = RestTemplateUtils.postForObjectInputStream(APPLICATION_JSON_URL, map, MediaType.APPLICATION_JSON, String.class);

        log.info("response：{}", response);
    }

    /**
     * 将数据使用键值对发送
     */
    @Test
    void postForEntityParameterMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("UUID", UUID.randomUUID().toString());

        ResponseEntity<String> responseEntity = RestTemplateUtils.postForEntityParameterMap(APPLICATION_JSON_URL, map, MediaType.APPLICATION_JSON, String.class);

        log.info("StatusCode：{}", responseEntity.getStatusCode());
        log.info("Headers：{}", responseEntity.getHeaders());
        log.info("Body：{}", responseEntity.getBody());
    }


    /**
     * 将数据使用键值对发送
     */
    @Test
    void postForObjectParameterMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("UUID", UUID.randomUUID().toString());

        String response = RestTemplateUtils.postForObjectParameterMap(APPLICATION_JSON_URL, map, MediaType.APPLICATION_JSON, String.class);

        log.info("response：{}", response);
    }

    /**
     * 将数据使用键值对与流发送
     */
    @Test
    void postForEntityInputStreamAndParameterMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("UUID", UUID.randomUUID().toString());

        ResponseEntity<String> responseEntity = RestTemplateUtils.postForEntityInputStreamAndParameterMap(APPLICATION_JSON_URL, map, MediaType.APPLICATION_JSON, String.class);

        log.info("StatusCode：{}", responseEntity.getStatusCode());
        log.info("Headers：{}", responseEntity.getHeaders());
        log.info("Body：{}", responseEntity.getBody());
    }

    /**
     * 将数据使用键值对与流发送
     */
    @Test
    void postForObjectInputStreamAndParameterMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("UUID", UUID.randomUUID().toString());

        String response = RestTemplateUtils.postForObjectInputStreamAndParameterMap(APPLICATION_JSON_URL, map, MediaType.APPLICATION_JSON, String.class);

        log.info("response：{}", response);
    }


}
