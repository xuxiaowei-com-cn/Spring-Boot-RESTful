package cn.com.xuxiaowei.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户 实体类
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -1029883185127417055L;

    private Long userId;

    private String username;

    private String password;

}
