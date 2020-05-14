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
package org.springframework.web.client;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.net.URI;
import java.util.Map;

/**
 * 重写 {@link RestTemplate}，使 {@link HttpMethod#GET} 支持设置 Header
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
public class CustomRestTemplate extends RestTemplate {

    /**
     * @see super#postForObject(String, Object, Class, Map)
     */
    @Nullable
    public <T> T getForObject(String url, @Nullable Object request, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
        RequestCallback requestCallback = httpEntityCallback(request, responseType);
        HttpMessageConverterExtractor<T> responseExtractor =
                new HttpMessageConverterExtractor<>(responseType, getMessageConverters(), logger);
        return execute(url, HttpMethod.GET, requestCallback, responseExtractor, uriVariables);
    }

    /**
     * @see super#postForObject(URI, Object, Class)
     */
    @Nullable
    public <T> T getForObject(URI url, @Nullable Object request, Class<T> responseType) throws RestClientException {
        RequestCallback requestCallback = httpEntityCallback(request, responseType);
        HttpMessageConverterExtractor<T> responseExtractor =
                new HttpMessageConverterExtractor<>(responseType, getMessageConverters());
        return execute(url, HttpMethod.GET, requestCallback, responseExtractor);
    }

    /**
     * @see super#postForObject(String, Object, Class, Object...)
     */
    @Nullable
    public <T> T getForObject(String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RequestCallback requestCallback = httpEntityCallback(request, responseType);
        HttpMessageConverterExtractor<T> responseExtractor =
                new HttpMessageConverterExtractor<>(responseType, getMessageConverters(), logger);
        return execute(url, HttpMethod.GET, requestCallback, responseExtractor, uriVariables);
    }

    /**
     * @see super#postForEntity(String, Object, Class, Map)
     */
    public <T> ResponseEntity<T> getForEntity(String url, @Nullable Object request,
                                              Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {

        RequestCallback requestCallback = httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = responseEntityExtractor(responseType);
        return nonNull(execute(url, HttpMethod.GET, requestCallback, responseExtractor, uriVariables));
    }

    /**
     * @see super#postForEntity(URI, Object, Class)
     */
    public <T> ResponseEntity<T> getForEntity(URI url, @Nullable Object request, Class<T> responseType)
            throws RestClientException {

        RequestCallback requestCallback = httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = responseEntityExtractor(responseType);
        return nonNull(execute(url, HttpMethod.GET, requestCallback, responseExtractor));
    }

    /**
     * @see super#postForEntity(String, Object, Class, Object...)
     */
    public <T> ResponseEntity<T> getForEntity(String url, @Nullable Object request,
                                              Class<T> responseType, Object... uriVariables) throws RestClientException {

        RequestCallback requestCallback = httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = responseEntityExtractor(responseType);
        return nonNull(execute(url, HttpMethod.GET, requestCallback, responseExtractor, uriVariables));
    }

    private static <T> T nonNull(@Nullable T result) {
        Assert.state(result != null, "No result");
        return result;
    }

}
