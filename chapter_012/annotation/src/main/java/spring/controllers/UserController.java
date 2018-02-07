package spring.controllers;

import org.springframework.stereotype.Controller;
import spring.models.User;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * Created by Андрей on 07.02.2018.
 */
@Controller
public class UserController {

    final List<User> users = new CopyOnWriteArrayList<>();

    /*@RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showItems(ModelMap model) {
        model.addAttribute("users", this.users);
        return "users";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String addItem(@ModelAttribute User user) {
        this.users.add(user);
        return "redirect:users.do";
    }*/
}

