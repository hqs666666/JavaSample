package pub.hqs.pojo.users;

import pub.hqs.pojo.PagedSearch;

import java.io.Serializable;

public class UserSearch extends PagedSearch implements Serializable {
    private String name;
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
