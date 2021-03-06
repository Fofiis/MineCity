package br.com.gamemods.minecity.api.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class CommandInfo<R>
{
    public String commandId;
    public CommandFunction<R> function;
    public Arg[] args;
    public String description;
    public String permission;
    public String syntax;
    public Set<String> aliases;
    public boolean async;
    public boolean translatedArg;

    public CommandInfo(String name, CommandFunction<R> function, String... aliases)
    {
        this.function = function;
        ArrayList<String> list = new ArrayList<>(aliases.length + 1);
        list.add(name);
        list.addAll(Arrays.asList(aliases));
        this.aliases = new LinkedHashSet<>(list);
    }

    public CommandInfo(String name, String... aliases)
    {
        this(name, null, aliases);
    }

    public String getName()
    {
        return aliases.iterator().next();
    }

    @Override
    public String toString()
    {
        return "CommandInfo{" +
                "description='" + description + '\'' +
                ", permission='" + permission + '\'' +
                ", syntax='" + syntax + '\'' +
                '}';
    }
}
