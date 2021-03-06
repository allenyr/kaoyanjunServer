package Model;

public class UserInfoDataBean {
	private int id;
    private  String username;
    private  String password;
    private  String headurl;
    private  String phone;
    private  String sex;
    private  String address;
    private  int money;
    private  String signa;
    private  int messagenum;
    private String longitude;
    private String latitude;
    private int signNum;
    private String college;
    private String major;
    private String wechat;

    public UserInfoDataBean() {

	}

    public UserInfoDataBean(String username, String password, String headurl, String phone, String sex, String address, int money, String signa, int messagenum, String longitude, String latitude, int signNum, String college, String major, String wechat) {
        this.username = username;
        this.password = password;
        this.headurl = headurl;
        this.phone = phone;
        this.sex = sex;
        this.address = address;
        this.money = money;
        this.signa = signa;
        this.messagenum = messagenum;
        this.longitude = longitude;
        this.latitude = latitude;
        this.signNum = signNum;
        this.college = college;
        this.major = major;
        this.wechat = wechat;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public int getSignNum() {
        return signNum;
    }

    public void setSignNum(int signNum) {
        this.signNum = signNum;
    }

    public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public int getMessagenum() {
		return messagenum;
	}

	public void setMessagenum(int messagenum) {
		this.messagenum = messagenum;
	}

	public String getSigna() {
		return signa;
	}

	public void setSigna(String signa) {
		this.signa = signa;
	}

	public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  String getPhone() {
        return phone;
    }

    public  void setPhone(String phone) {
        this.phone = phone;
    }

    public  String getSex() {
        return sex;
    }

    public  void setSex(String sex) {
        this.sex = sex;
    }

    public  String getAddress() {
        return address;
    }

    public  void setAddress(String address) {
        this.address = address;
    }

    public  String getUsername() {
        return username;
    }

    public  void setUsername(String username) {
        this.username = username;
    }

    public  String getPassword() {
        return password;
    }

    public  void setPassword(String password) {
        this.password = password;
    }

    public  String getHeadurl() {
        return headurl;
    }

    public  void setHeadurl(String headurl) {
        this.headurl = headurl;
    }
}