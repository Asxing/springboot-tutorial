package com.holddie.springboot.dataredistutorial.business.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/7/31 10:35
 */
@Entity
@Table(name = "data_user", schema = "data-redis", catalog = "")
public class DataUserEntity implements Serializable {
    private int id;
    private String username;
    private String password;
    private Integer age;
    private String remark;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = true, length = 255)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "age", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 255)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataUserEntity that = (DataUserEntity) o;
        return id == that.id &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(age, that.age) &&
                Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, password, age, remark);
    }
}
