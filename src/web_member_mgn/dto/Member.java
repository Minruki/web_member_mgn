package web_member_mgn.dto;

public class Member {
	private String id;
	private String passwd;
	private String name;
	private int age;
	private String gender;
	private String email;

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String id) {
		this.id = id;
	}

	public Member(String id, String passwd) {
		this.id = id;
		this.passwd = passwd;
	}

	public Member(String id, String name, int age, String gender, String email) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.email = email;
	}

	//회원 가입을 위한 DTO
	public Member(String id, String passwd, String name, int age, String gender, String email) {
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", passwd=" + passwd + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", email=" + email + "]";
	}

}
