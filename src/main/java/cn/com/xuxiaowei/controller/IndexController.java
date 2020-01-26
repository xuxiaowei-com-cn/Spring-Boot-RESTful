package cn.com.xuxiaowei.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 主页
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@Controller
public class IndexController {

    /**
     * 主页、域名
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = {"", "/index"})
    public String index(HttpServletRequest request, HttpServletResponse response, Model model) {

        return "index";
    }

}
