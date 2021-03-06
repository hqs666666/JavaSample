package pub.hqs.controller;

import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pub.hqs.pojo.users.User;
import pub.hqs.pojo.users.UserSearch;
import pub.hqs.service.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/index")
    public String Index(Model model, UserSearch search) {
        logger.debug("1231231");
        PageInfo<User> pageInfo = userService.getUserList(search);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("search",search);
        return "user_index";
    }

    @RequestMapping("/detail")
    public String Details(@RequestParam(value = "id",required = false, defaultValue = "1") int id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "user_add";
    }

    @RequestMapping("/add")
    public String Add(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user_add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String Save(@Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            return "user_add";
        }

        userService.addOrUpdateUser(user);
        return "redirect:/user/index";
    }

    @RequestMapping("/delete/{id}")
    public String Delete(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/user/index";
    }

    @RequestMapping("/json")
    @ResponseBody
    public User Json() {
        User user = userService.getById(1);
        return user;
    }
}
