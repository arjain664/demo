package controller;

import entity.PortalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.AdminService;
import service.UserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;

    @PostMapping(value = "/user/save", consumes = "application/json")
    public int saveUser(@RequestBody PortalUser user) {
        user.setAdmin(true);
        System.out.println(user);
        PortalUser portalUser = userService.saveUser(user);
        return portalUser.getUserId();
    }

    @PostMapping(value = "/updateCovidResult", consumes = "application/json")
    public boolean updateCovidResult(@RequestBody CovidResult result) {
        return adminService.updateCovidResult(result);
    }
}
