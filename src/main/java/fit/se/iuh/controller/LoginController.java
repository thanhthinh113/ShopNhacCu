package fit.se.iuh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fit.se.iuh.dto.UserDTO;
import fit.se.iuh.global.GlobalData;
import fit.se.iuh.model.Role;
import fit.se.iuh.model.User;
import fit.se.iuh.repository.RoleRepository;
import fit.se.iuh.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/login")
    public String login(){
        GlobalData.cart.clear();
        return "login";
    }//page login

    @GetMapping("/forgotpassword")
    public String forgotPass(Model model){
        model.addAttribute("userDTO", new UserDTO());
        return "forgotpassword";
    }

    @GetMapping("/register")
    public String registerGet(Model model){
        return "register";
    } //page register

    @PostMapping("/register")
    public String registerPost(@ModelAttribute User userModel, HttpServletRequest request, Model model) throws ServletException {
        // Kiểm tra xem email đã tồn tại trong cơ sở dữ liệu chưa
        if (userRepository.findUserByEmail(userModel.getEmail()).isPresent()) {
            // Thêm thông báo lỗi vào model để hiển thị trên giao diện
            model.addAttribute("errorMessage", "Email đã tồn tại. Vui lòng sử dụng email khác.");
            return "register"; // Trả về trang đăng ký
        }
        
        // Chuyển password từ form đăng ký thành dạng mã hóa
        String password = userModel.getPassword();
        userModel.setPassword(bCryptPasswordEncoder.encode(password));
        
        // Set mặc định role user
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findById(2).get());
        userModel.setRoles(roles);
        
        // Lưu người dùng mới vào cơ sở dữ liệu
        userRepository.save(userModel);
        
        // Đăng nhập tự động và chuyển đến trang chủ
        request.login(userModel.getEmail(), password);
        return "redirect:/";
    }
//after register success
}
