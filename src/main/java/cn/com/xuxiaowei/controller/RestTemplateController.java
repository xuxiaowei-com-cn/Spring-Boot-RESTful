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

import cn.com.xuxiaowei.util.RequestUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * RestTemplate 接口
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@RestController
@RequestMapping("/restTemplate")
public class RestTemplateController {

    /**
     * RestTemplate 接口
     *
     * @param request  请求
     * @param response 响应
     * @return 返回页面位置及名称
     */
    @RequestMapping
    public Map<String, Object> restTemplate(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String keyValue = RequestUtils.keyValue(request);
        String inputStream = RequestUtils.getInputStream(request);
        Map<String, String[]> parameterMap = request.getParameterMap();

        Map<String, Object> map = new HashMap<>(4);

        log.info("HttpServletRequest 请求参数：{}", keyValue);
        log.info("HttpServletRequest 请求数据流：{}", inputStream);

        map.put("parameterMap", parameterMap);
        map.put("inputStream", inputStream);

        return map;
    }

}
