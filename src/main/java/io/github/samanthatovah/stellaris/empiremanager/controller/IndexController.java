package io.github.samanthatovah.stellaris.empiremanager.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Value("${git.commit.id:unknown}")
    private String gitCommitId;

    @Value("${git.commit.time:unknown}")
    private String gitCommitTime;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("gitCommitId", gitCommitId);
        model.addAttribute("gitCommitTime", gitCommitTime);
        return "index";
    }
}
