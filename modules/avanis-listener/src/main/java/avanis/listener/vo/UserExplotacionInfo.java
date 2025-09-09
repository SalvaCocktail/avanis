package avanis.listener.vo;

import com.liferay.portal.kernel.model.User;

public class UserExplotacionInfo {
    private User user;
    private String explotacionName;

    public UserExplotacionInfo(User user, String explotacionName) {
        this.user = user;
        this.explotacionName = explotacionName;
    }

    public User getUser() {
        return user;
    }

    public String getExplotacionName() {
        return explotacionName;
    }
}
