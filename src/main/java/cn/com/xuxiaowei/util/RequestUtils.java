package cn.com.xuxiaowei.util;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * 请求工具类
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
public class RequestUtils {

    /**
     * 请求参数集
     *
     * @param request 请求
     * @return 返回 请求参数集
     */
    public static String keyValue(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        StringBuilder keyValue = new StringBuilder();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            String key = entry.getKey();
            String[] value = entry.getValue();
            keyValue.append(key).append(":").append(Arrays.toString(value)).append("&");
        }
        return keyValue.toString();
    }

    /**
     * 请求参数流
     *
     * @param request 请求
     * @return 返回 请求参数流
     */
    public static String getInputStream(HttpServletRequest request) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        byte[] bytes = new byte[request.getContentLength()];
        String characterEncoding = request.getCharacterEncoding();
        inputStream.read(bytes);
        return new String(bytes, characterEncoding);
    }

}
