package spittr.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by hg_yi on 17-11-7.
 */
public class Spitter {
    private Integer id;

    @NotNull
    @Size(min=5, max=16, message="{username.size}")
    private String username;

    @NotNull
    @Size(min=5, max=25, message="{password.size}")
    private String password;

    @NotNull
    @Size(min=2, max=30, message="{firstName.size}")
    private String firstName;

    @NotNull
    @Size(min=2, max=30, message="{lastName.size}")
    private String lastName;

    private MultipartFile profilePicture;

    public Spitter() {

    }

    public Spitter(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Spitter(Integer id, String username, String password, String firstName,
                   String lastName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setProfilePicture(MultipartFile profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public MultipartFile getProfilePicture() {
        return profilePicture;
    }

    public Spitter toSpitter() {
        return new Spitter(username, password, firstName, lastName);
    }

    //重写equal方法，用于比较两个对象的内容是否相等
    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "id", "time");
    }

    //对每个对象重新生成hash码
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id", "time");
    }
}
