package org.example.plugin;

import org.example.plugin.Plugin;

public class PluginNew implements Plugin {
    @Override
    public String name() {
        return "PluginNew";
    }

    @Override
    public void execute() {
        System.out.println("PluginNew executed");
    }
}
