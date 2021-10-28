package com.sk.controller;

import com.sk.domain.User;
import com.sk.service.UserService;
import com.sk.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@SessionAttributes(value = {"loginUser"})
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/update")
    public String updateSysUser(User user,Integer updateRoleId, Model model) {
        user.setRoleId(updateRoleId);
        userService.updateUser(user);
        List<User> users = userService.queryUserByUsername(user.getUserName());
        model.addAttribute("users", users);
        return "user/user_list";
    }

    @GetMapping("/toUpdate")
    public String toUpdateUserPage(String username, Model model) {
        User user = userService.queryUserByUsername(username).get(0);
        model.addAttribute("user2", user);
        return "user/user_modify";
    }


    @GetMapping("/delete")
    @ResponseBody
    public CommonResult deleteById(Integer id) {
        if (userService.deleteUserById(id) > 0) {
            return CommonResult.success();
        }
        return CommonResult.fail();
    }

    @PostMapping("/add")
    public String addUser(Integer addRoleId,User user, Model model) {
        //检查账户是否存在
        List<User> checkUser = userService.queryUserByLoginAccount(user.getLoginAccount());
        if (!checkUser.isEmpty()) {
            model.addAttribute("addUserMsg", "该账户已存在");
            return "user/user_add";
        }
        user.setRoleId(addRoleId);
        userService.addUser(user);
        List<User> users = userService.queryUserByUsername(user.getUserName());
        model.addAttribute("users", users);
        return "user/user_list";
    }


    @GetMapping("/toManagerPage")
    public String toUserManagerPage(String userName, Model model) {
        if (userName == null) {
            List<User> users = userService.queryAllUser();
            model.addAttribute("users", users);
            return "user/user_list";
        }
        List<User> users = userService.queryUserByUsername(userName);
        model.addAttribute("users", users);
        return "user/user_list";
    }

    @PostMapping("/check")
    public String checkUser(User user, Model model) {
        List<User> users = userService.queryUser(user);
        if (!users.isEmpty()) {
            model.addAttribute("loginUser", users.get(0));
            return "index/index";
        }
        model.addAttribute("msg", "用户名或密码错误！");
        return "user/login";
    }

    @GetMapping("/exit")
    public String exitUser(HttpSession session) {
        session.invalidate();
        return "user/auth-sign-in";
    }


}
