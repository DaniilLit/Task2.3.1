package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.DAO.UserDAO;
import web.model.User;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserDAO userDAO;


    @GetMapping("/")
    public String getAllUser(Model model) {

        List<User> users = userDAO.getAllUsers();
        model.addAttribute("userList", users);

        return "users";
    }
    @GetMapping("/addUser")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }




    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userDAO.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/updateUser")
    public String updateUser(@RequestParam("userId") int userId, Model model) {
        User user = userDAO.getUser(userId);
        model.addAttribute("user", user);
        return "addUser";
    }
    @PostMapping("/deleteUser")
    public String deleteUser (@RequestParam("userId") int id) {
        userDAO.deleteUser(id);
        return "redirect:/";
    }
}
