package io.github.samanthatovah.stellaris.empiremanager.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController extends ApplicationController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute(CONTENT, "fragment/welcome");
        addGitInfo(model);

        return MAIN_LAYOUT;
    }
}
