package PP_3_1_2.Project2Boot.controller;

import PP_3_1_2.Project2Boot.model.User;

import PP_3_1_2.Project2Boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/")
    public String getAllUsers(Model model) {
        userService.getAllUsers();
        model.addAttribute("user", userService.getAllUsers());
        return "index";
    }
    @GetMapping("/adduser")
    public String createUserForm(@ModelAttribute("user") User user) {
        return "adduser";
    }

    @PostMapping("/adduser")
    public String addUser(/*@ModelAttribute("user") @Valid */ User user /*, BindingResult bindingResult */) {
        userService.addUser(user);
        return "redirect:/";
    }
    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
    @GetMapping("/updateuser")
    public String getEditUserForm(Model model, @RequestParam("id") long id) {
        model.addAttribute("user", userService.getUser(id));
        return "updateuser";
    }
    @PostMapping("/updateuser")
    public String updateUser(@PathVariable("id") Long id, Model model){
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "redirect:/";
    }
}