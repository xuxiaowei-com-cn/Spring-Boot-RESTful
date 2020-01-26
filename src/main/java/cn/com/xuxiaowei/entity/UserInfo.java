package cn.com.xuxiaowei.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户测试 XML Bean 转化
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 4191739916188118828L;

    private Long userId;

    private String username;

    private String password;

}
