package com.cinema.users.controller;

import com.cinema.users.domain.Users;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", produces = "application/json")
public class UsersController {

    @GetMapping
    public List<Users> showtimes(){
        return getStaticUser();
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    private List<Users> getStaticUser(){
        List<Users> users = new ArrayList<>();
        users.add(new Users(1L, "Steve Job", "jobs.steve@apple.com", "01923445", "man"));
        users.add(new Users(2L, "Bill Gate", "gate.wilBill@microsoft.com", "0194445", "man"));
        users.add(new Users(2L, "Ellon Musk", "must.ello@tesla.com", "01456645", "man"));
        users.add(new Users(2L, "Larry Page", "page.larry@google.com", "0145555", "man"));
        users.add(new Users(2L, "Larry Ellison", "eslison.larry@oracle.com", "0167788", "man"));
        users.add(new Users(2L, "Mark Zukerberk", "zuk.mark@facebook.com", "01888843", "man"));
        users.add(new Users(2L, "Jack Dorsey", "dorsey.jack@twitter.com", "019955666", "man"));

        return users;
    }
}
