package example.controller;

import example.pojo.User;
import example.pojo.PagedList;
import example.pojo.UserSearch;
import example.service.IUserService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/index")
    public String Index(Model model, UserSearch search) {
        PagedList<User> users = userService.findAll(search);
        model.addAttribute("users", users);
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

        int result = userService.addOrUpdateUser(user);
        return "redirect:/user/index";
    }

    @RequestMapping("/delete/{id}")
    public String Delete(@PathVariable int id) {
        int result = userService.deleteUser(id);
        return "redirect:/user/index";
    }

    @RequestMapping("/json")
    @ResponseBody
    public String Json() throws IOException {
        User user = userService.getById(1);
        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(user);
        return str;
    }
}
