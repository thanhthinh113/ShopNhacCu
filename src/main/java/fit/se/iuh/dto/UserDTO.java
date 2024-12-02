package fit.se.iuh.dto;

import lombok.Data;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
public class UserDTO {
    private Integer id;

    @NotBlank(message = "Email is required") // Kiểm tra email không rỗng
    @Email(message = "Invalid email format") // Kiểm tra định dạng email
    private String email;

    @NotBlank(message = "Password is required") // Kiểm tra mật khẩu không rỗng
    @Size(min = 6, message = "Password must be at least 6 characters") // Kiểm tra độ dài mật khẩu
    private String password;

    private List<Integer> roleIds;

    @NotBlank(message = "First Name is required") // Kiểm tra tên không rỗng
    private String firstName;

    @NotBlank(message = "Last Name is required") // Kiểm tra họ không rỗng
    private String lastName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Integer> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Integer> roleIds) {
		this.roleIds = roleIds;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
