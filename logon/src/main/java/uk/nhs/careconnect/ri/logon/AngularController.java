package uk.nhs.careconnect.ri.logon;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AngularController {


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Object handleLogin() {
        return new ModelAndView
                ("forward:/" );
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public Object handleError() {
        return new ModelAndView
                ("forward:/" );
    }


    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public Object handlePing() {
        return new ModelAndView
                ("forward:/" );
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public Object handleLogout() {
        return new ModelAndView
                ("forward:/" );
    }

    @RequestMapping(value = "/callback", method = RequestMethod.GET)
    public Object handleCallback() {
        return new ModelAndView
                ("forward:/" );
    }


}
