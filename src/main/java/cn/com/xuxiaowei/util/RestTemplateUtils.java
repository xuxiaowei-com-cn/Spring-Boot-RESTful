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

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@link RestTemplate} 工具类
 * <p>
 * 默认：Accept=[text/plain, application/xml, text/xml, application/json, application/*+xml, application/*+json, *\/*]
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

    /**
     * 根据 URL、参数、请求数据类型、响应数据类 发送 POST 请求
     *
     * @param url          URL
     * @param map          Map 类型的参数，如：{@link HashMap}、{@link LinkedMultiValueMap}
     * @param mediaType    请求数据类型，如：{@link MediaType#APPLICATION_JSON}、{@link MediaType#APPLICATION_XML}
     * @param responseType 响应数据类
     * @param <T>          响应数据类泛型
     * @return 返回 根据 URL、参数、请求数据类型、响应数据类 发送 POST 请求 结果
     */
    public static <T> ResponseEntity<T> postForEntityInputStream(String url, Map<?, ?> map, MediaType mediaType, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        // 设置请求参数流格式
        httpHeaders.setContentType(mediaType);

        HttpEntity<Map<?, ?>> httpEntity = new HttpEntity<>(map, httpHeaders);

        return restTemplate.postForEntity(url, httpEntity, responseType);
    }

    /**
     * 根据 URL、参数、请求数据类型、响应数据类 发送 POST 请求
     *
     * @param url          URL
     * @param map          Map 类型的参数，如：{@link HashMap}、{@link LinkedMultiValueMap}
     * @param mediaType    请求数据类型，如：{@link MediaType#APPLICATION_JSON}、{@link MediaType#APPLICATION_XML}
     * @param responseType 响应数据类
     * @param <T>          响应数据类泛型
     * @return 返回 根据 URL、参数、请求数据类型、响应数据类 发送 POST 请求 结果
     */
    public static <T> T postForObjectInputStream(String url, Map<?, ?> map, MediaType mediaType, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        // 设置请求参数流格式
        httpHeaders.setContentType(mediaType);

        HttpEntity<Map<?, ?>> httpEntity = new HttpEntity<>(map, httpHeaders);

        return restTemplate.postForObject(url, httpEntity, responseType);
    }

    /**
     * 根据 URL、参数、请求数据类型、响应数据类 发送 POST 请求
     *
     * @param url          URL
     * @param map          Map 类型的参数，如：{@link HashMap}、{@link LinkedMultiValueMap}
     * @param mediaType    请求数据类型，如：{@link MediaType#APPLICATION_JSON}、{@link MediaType#APPLICATION_XML}
     * @param responseType 响应数据类
     * @param <T>          响应数据类泛型
     * @return 返回 根据 URL、参数、请求数据类型、响应数据类 发送 POST 请求 结果
     */
    public static <T> ResponseEntity<T> postForEntityParameterMap(String url, Map<?, ?> map, MediaType mediaType, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        // 设置请求参数流格式
        httpHeaders.setContentType(mediaType);

        HttpEntity<Map<?, ?>> httpEntity = new HttpEntity<>(httpHeaders);

        String parameterUrl = parameterUrl(url, map);

        return restTemplate.postForEntity(parameterUrl, httpEntity, responseType, map);
    }


    /**
     * 根据 URL、参数、请求数据类型、响应数据类 发送 POST 请求
     *
     * @param url          URL
     * @param map          Map 类型的参数，如：{@link HashMap}、{@link LinkedMultiValueMap}
     * @param mediaType    请求数据类型，如：{@link MediaType#APPLICATION_JSON}、{@link MediaType#APPLICATION_XML}
     * @param responseType 响应数据类
     * @param <T>          响应数据类泛型
     * @return 返回 根据 URL、参数、请求数据类型、响应数据类 发送 POST 请求 结果
     */
    public static <T> T postForObjectParameterMap(String url, Map<?, ?> map, MediaType mediaType, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        // 设置请求参数流格式
        httpHeaders.setContentType(mediaType);

        HttpEntity<Map<?, ?>> httpEntity = new HttpEntity<>(httpHeaders);

        String parameterUrl = parameterUrl(url, map);

        return restTemplate.postForObject(parameterUrl, httpEntity, responseType, map);
    }

    /**
     * 根据 URL、参数、请求数据类型、响应数据类 发送 POST 请求
     *
     * @param url          URL
     * @param map          Map 类型的参数，如：{@link HashMap}、{@link LinkedMultiValueMap}
     * @param mediaType    请求数据类型，如：{@link MediaType#APPLICATION_JSON}、{@link MediaType#APPLICATION_XML}
     * @param responseType 响应数据类
     * @param <T>          响应数据类泛型
     * @return 返回 根据 URL、参数、请求数据类型、响应数据类 发送 POST 请求 结果
     */
    public static <T> ResponseEntity<T> postForEntityInputStreamAndParameterMap(String url, Map<?, ?> map, MediaType mediaType, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        // 设置请求参数流格式
        httpHeaders.setContentType(mediaType);

        HttpEntity<Map<?, ?>> httpEntity = new HttpEntity<>(map, httpHeaders);

        String parameterUrl = parameterUrl(url, map);

        return restTemplate.postForEntity(parameterUrl, httpEntity, responseType, map);
    }


    /**
     * 根据 URL、参数、请求数据类型、响应数据类 发送 POST 请求
     *
     * @param url          URL
     * @param map          Map 类型的参数，如：{@link HashMap}、{@link LinkedMultiValueMap}
     * @param mediaType    请求数据类型，如：{@link MediaType#APPLICATION_JSON}、{@link MediaType#APPLICATION_XML}
     * @param responseType 响应数据类
     * @param <T>          响应数据类泛型
     * @return 返回 根据 URL、参数、请求数据类型、响应数据类 发送 POST 请求 结果
     */
    public static <T> T postForObjectInputStreamAndParameterMap(String url, Map<?, ?> map, MediaType mediaType, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        // 设置请求参数流格式
        httpHeaders.setContentType(mediaType);

        HttpEntity<Map<?, ?>> httpEntity = new HttpEntity<>(map, httpHeaders);

        String parameterUrl = parameterUrl(url, map);
        return restTemplate.postForObject(parameterUrl, httpEntity, responseType, map);
    }

    /**
     * 根据 URL与参数 获取符合发送请求的 URL
     *
     * @param url URL
     * @param map 参数
     * @return 返回 根据 URL与参数 获取符合发送请求的 URL 结果
     */
    public static String parameterUrl(String url, Map<?, ?> map) {

        // 以下为处理参数与URL
        StringBuilder parameterUrlBuilder = new StringBuilder(url);
        parameterUrlBuilder.append("?");
        for (Map.Entry<?, ?> entries : map.entrySet()) {
            Object key = entries.getKey();
            Object value = entries.getValue();
            parameterUrlBuilder.append(key).append("=").append(value).append("&");
        }

        return parameterUrlBuilder.toString();
    }

}
