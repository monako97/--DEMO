package blog.monako.domain;

import java.util.Date;
/**
 * 这是学生对象封装的对象bean
 * @author monako
 **/
public class Student {
    private int id;
    private String name;
    private String gender;
    private String phone;
    private String hobby;
    private String info;
    private Date birthday;

    public Student() {
        super();
    }
    public Student(String name, String gender, String phone, String hobby, String info, Date birthday,int id) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.hobby = hobby;
        this.info = info;
        this.birthday = birthday;
        this.id = id;
    }
    public Student(String name, String gender, String phone, String hobby, String info, Date birthday) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.hobby = hobby;
        this.info = info;
        this.birthday = birthday;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
