package fragtone;

import net.minecraft.command.ICommand;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import fragtone.pathfind.TravelCommand;
import fragtone.pathfind.main.LookManager;
import fragtone.pathfind.main.PathRenderer;
import fragtone.pathfind.main.walk.Walker;
import java.util.Arrays;
import java.util.function.Consumer;

@Mod(modid = Fragtone.MODID, version = Fragtone.VERSION)
public class Fragtone
{
    public static final String MODID = "Fragtone";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
        registerCommands(new TravelCommand());
        registerListeners(this, new PathRenderer(), new Walker(), new LookManager());
    }

    private void registerCommands(ICommand... commands) {
        for (ICommand command : commands) {
            ClientCommandHandler.instance.registerCommand(command);
        }
    }

    private void registerListeners(final Object... listeners) {
        Arrays.stream(listeners).forEach(new Consumer<Object>() {
            @Override
            public void accept(Object listener) {
                MinecraftForge.EVENT_BUS.register(listener);
            }
        });
    }
}
