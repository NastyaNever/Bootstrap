package com.example.Boot.controller;

import com.example.Boot.entity.User;
import com.example.Boot.service.RoleService;
import com.example.Boot.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/admin")
public class AdminController {

  private final UserService userService;
  private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String listUsers(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("allUsers", userService.getAllUsers());
        model.addAttribute("allRoles", roleService.getListRole());
        return "pages/users";
    }

    @PostMapping("/newUser")
    public String addUser(@ModelAttribute("user") User user, @RequestParam("roles") String [] role) {
        user.setRoles(roleService.getRoleSet(role));
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @PostMapping(value = "/edit/{id}")
    public String update(@ModelAttribute("user") User user, @RequestParam("roles") String [] role) {
        user.setRoles(roleService.getRoleSet(role));
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.removeUserById(id);
        return "redirect:/admin";
    }
}
