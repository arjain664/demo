package controller;

import entity.PortalUser;
import entity.UserSelfAssessment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;


    /**
     * register
     * @param user
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
    public int saveUser(@RequestBody PortalUser user) {
        user.setAdmin(false);
        System.out.println(user);
        PortalUser portalUser = userService.saveUser(user);
        return portalUser.getUserId();
    }

    @RequestMapping(value = "/selfAssessment/save", method = RequestMethod.POST, consumes = "application/json")
    public int saveSelfAssessment(@RequestBody UserSelfAssessment userSelfAssessment) {
        return userService.saveAssessment(userSelfAssessment);
    }
}
