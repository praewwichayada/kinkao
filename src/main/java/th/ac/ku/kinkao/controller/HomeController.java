package th.ac.ku.kinkao.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getHomePage(Model model, @AuthenticationPrincipal OAuth2User principal) {
        model.addAttribute("greeting", "Sawaddee");

        if (principal != null) // ถ้ามีการ login ส่งชื่อเข้าไป
            model.addAttribute("user", principal.getAttribute("name"));
        else // ถ้าไม่มีการ login ส่งคำว่า Guest เข้าไป
            model.addAttribute("user", "Guest");

        // return home.html
        return "home";
    }
}
