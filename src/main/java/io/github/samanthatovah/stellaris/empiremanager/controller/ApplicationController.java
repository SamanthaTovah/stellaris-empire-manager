package io.github.samanthatovah.stellaris.empiremanager.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;

@Log4j2
public abstract class ApplicationController {
    protected static final String MAIN_LAYOUT = "main-layout";
    protected static final String CONTENT = "content";
    @Value("${git.commit.id:unknown}")
    private String gitCommitId;
    @Value("${git.commit.time:unknown}")
    private String gitCommitTime;

    protected void addGitInfo(Model model) {
        String gitCommitIdShort = gitCommitId;
        if (gitCommitId != null && gitCommitId.length() > 7) {
            gitCommitIdShort = gitCommitId.substring(0, 7);
        }

        model.addAttribute("gitCommitId", gitCommitIdShort);
        model.addAttribute("gitCommitTime", gitCommitTime);
    }
}
