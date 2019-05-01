package example.pojo;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private int id;

    @NotBlank(message = "姓名不能为空")
    private String name;
    @NotBlank(message = "昵称不能为空")
    private String nickname;
    @Range(min = 0, max = 2, message = "性别超出范围（0~1）")
    private int gender;
    @NotBlank(message = "密码不能为空")
    private String password;

    private List<UserBook> userBooks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserBook> getUserBooks() {
        return userBooks;
    }

    public void setUserBooks(List<UserBook> userBooks) {
        this.userBooks = userBooks;
    }

}
