package net.thehunter365.botloaderapi.loader;

import net.thehunter365.botloaderapi.api.Bot;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

final class BotClassLoader extends URLClassLoader{

    private Bot bot;

    protected BotClassLoader(String main, ClassLoader parent, File file) throws Exception{
        super(new URL[]{file.toURI().toURL()}, parent);
        Class<?> clazz = Class.forName(main, true, this);
        bot = clazz.asSubclass(Bot.class).getDeclaredConstructor().newInstance();
    }

    public Bot getBot() {
        return bot;
    }
}
