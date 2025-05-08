package org.example.plugin.impl;

import org.example.plugin.Plugin;

public class HelloPlugin implements Plugin {
    @Override
    public String name() {
        return "HelloPlugin";
    }

    @Override
    public void execute() {
        System.out.println("HelloPlugin executed");
    }
}
