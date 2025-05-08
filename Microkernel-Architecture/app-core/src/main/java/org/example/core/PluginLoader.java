package org.example.core;

import jakarta.annotation.PostConstruct;
import org.example.plugin.Plugin;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ServiceLoader;

@Component
@Description("Scan plugin in folder 'plugins' and load plugins")
public class PluginLoader {

    @PostConstruct
    private void loadAndRunPlugins() throws IOException {
        Path pluginDir = Paths.get("plugins");
        List<URL> jarUrls = Files.walk(pluginDir)
                .filter(p -> p.toString().endsWith(".jar"))
                .map(p -> {
                    try {
                        return p.toUri().toURL();
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                }).toList();

        URLClassLoader pluginClassLoader = new URLClassLoader(
                jarUrls.toArray(new URL[0]),
                Plugin.class.getClassLoader() // hoặc null nếu muốn sandboxing
        );

        // Load plugin bằng classloader mới
        ServiceLoader<Plugin> loader = ServiceLoader.load(Plugin.class, pluginClassLoader);
        for (Plugin plugin : loader) {
            System.out.println(">>> Loaded plugin: " + plugin.getClass().getName());
            plugin.execute();
        }

    }
}
