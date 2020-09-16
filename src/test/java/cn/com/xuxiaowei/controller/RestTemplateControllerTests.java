package cn.com.xuxiaowei.controller;

import cn.com.xuxiaowei.util.RestTemplateUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

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
    void parameterMap() {

        // Parameter 参数
        Map<String, Object> map = new HashMap<>();
        map.put("UUID", UUID.randomUUID().toString());

        // 以下为处理参数与URL
        StringBuilder parameterURLBuilder = new StringBuilder(APPLICATION_JSON_URL);
        parameterURLBuilder.append("?");
        for (Map.Entry<String, Object> entries : map.entrySet()) {
            String key = entries.getKey();
            parameterURLBuilder.append(key).append("={").append(key).append("}&");
        }
        String parameterURL = parameterURLBuilder.toString();
        // 以上为处理参数与URL

        RestTemplate restTemplate = new RestTemplate();

        // 默认：Accept=[text/plain, application/xml, text/xml, application/json, application/*+xml, application/*+json, */*]
        HttpHeaders httpHeaders = new HttpHeaders();
        // 设置请求参数流格式
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

        // 使用处理好的 URL
        // URL 参数格式：?parameterName1={mapKey1}&parameterName2={mapKey2}&
        // 其中：parameterName1 代表参数名，{mapKey1} 代表 Map 中的键
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(parameterURL, httpEntity, String.class, map);

        log.info("StatusCode：{}", responseEntity.getStatusCode());
        log.info("Headers：{}", responseEntity.getHeaders());
        log.info("Body：{}", responseEntity.getBody());

    }

    /**
     * 将数据使用键值对与流发送
     */
    @Test
    void inputStreamAndParameterMap() {

        // Parameter 参数
        Map<String, Object> map = new HashMap<>();
        map.put("UUID", UUID.randomUUID().toString());

        // 以下为处理参数与URL
        StringBuilder parameterURLBuilder = new StringBuilder(APPLICATION_JSON_URL);
        parameterURLBuilder.append("?");
        for (Map.Entry<String, Object> entries : map.entrySet()) {
            String key = entries.getKey();
            parameterURLBuilder.append(key).append("={").append(key).append("}&");
        }
        String parameterURL = parameterURLBuilder.toString();
        // 以上为处理参数与URL

        RestTemplate restTemplate = new RestTemplate();

        // 默认：Accept=[text/plain, application/xml, text/xml, application/json, application/*+xml, application/*+json, */*]
        HttpHeaders httpHeaders = new HttpHeaders();
        // 设置请求参数流格式
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(map, httpHeaders);

        // 使用处理好的 URL
        // URL 参数格式：?parameterName1={mapKey1}&parameterName2={mapKey2}&
        // 其中：parameterName1 代表参数名，{mapKey1} 代表 Map 中的键
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(parameterURL, httpEntity, String.class, map);

        log.info("StatusCode：{}", responseEntity.getStatusCode());
        log.info("Headers：{}", responseEntity.getHeaders());
        log.info("Body：{}", responseEntity.getBody());

    }


}
