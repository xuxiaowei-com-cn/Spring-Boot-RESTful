package cn.com.xuxiaowei.entity;

import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 用户 实体类
 * <p>
 * 本实体类牵扯到返回 XML 类型的数据，需要在 Get 方法上使用注解 {@link XmlElement}，并且不能使用 {@link Getter}，
 * 其中包含 {@link Getter} 的 {@link Data} 也不能使用
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Setter
@ToString
@EqualsAndHashCode
@XmlRootElement
public class User implements Serializable {

    private static final long serialVersionUID = -1029883185127417055L;

    private Long userId;

    private String username;

    private String password;

    @XmlElement
    public Long getUserId() {
        return userId;
    }

    @XmlElement
    public String getUsername() {
        return username;
    }

    @XmlElement
    public String getPassword() {
        return password;
    }

}
