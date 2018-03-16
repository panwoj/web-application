package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message) {

        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allow sending tasks to Trello");

        List<String> seeTasks = new ArrayList<>();
        seeTasks.add("Go to application");
        seeTasks.add("Look for your tasks");
        seeTasks.add("Do them and delete tasks from the list.");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("short_message", "PREVIEW: " + message.substring(0, 10) + "...");
        context.setVariable("tasks_url", "http://localhost:8888/crud");
        context.setVariable("button", "Visit website");
        context.setVariable("tasks_url_trello", "https://trello.com");
        context.setVariable("button_trello", "Visit directly Trello");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("show_button", true);
        context.setVariable("is_friend", true);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality", functionality);
        context.setVariable("application_functionality_database", seeTasks);
        context.setVariable("see_you", "See you next day!");
        context.setVariable("goodbye", "Bye!");
        context.setVariable("company_name", adminConfig.getCompanyName());
        context.setVariable("company_phone", adminConfig.getCompanyPhone());
        context.setVariable("company_mail", adminConfig.getCompanyEmail());
        context.setVariable("admin_config", adminConfig);

        if (message.substring(0,8).equals("New card")) {
            return templateEngine.process("mail/created-trello-card-mail", context);
        } else {
            return templateEngine.process("mail/tasks-number-in-db-mail", context);
        }
    }
}


