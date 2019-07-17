package personal.vishu.in28minutes.rest.webservices.restfulwebservices.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about the user.")
@Entity
public class User
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Size(min = 2, max = 50, message = "Name should have minimum 2 and maximum 50 characters")
	@ApiModelProperty(notes = "Name should have minimum 2 and maximum 50 characters.")
	private String name;
	
	@Past(message = "Date of Birth should be of Past Date")
	@ApiModelProperty(notes = "Birth Date should be in the past.")
	private Date birthDate;

	@OneToMany(mappedBy = "user")
	private List<Post> posts;

	protected User() {}
	
	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", birthDate=" + birthDate +
				'}';
	}

}
