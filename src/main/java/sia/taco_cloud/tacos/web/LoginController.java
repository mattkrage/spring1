package sia.taco_cloud.tacos.web;

import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class LoginController {

    @Autowired
    private InfoEndpoint infoEndpoint;

    @EventListener(ApplicationReadyEvent.class)
    public void printInfo() {
        System.out.println("XXXXXXX");
        System.out.println(infoEndpoint.info());
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", true);
        }
        return "login";
    }
}
