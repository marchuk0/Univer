package com.marchuk0.commands;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.shell.jline.PromptProvider;

@ConfigurationProperties(prefix = "shell")
public class CommandConfiguration implements PromptProvider {

    @Override
    public AttributedString getPrompt() {
        return new AttributedString(">", AttributedStyle.DEFAULT);
    }
}
