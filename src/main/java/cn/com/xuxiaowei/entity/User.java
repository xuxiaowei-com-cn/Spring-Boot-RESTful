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
