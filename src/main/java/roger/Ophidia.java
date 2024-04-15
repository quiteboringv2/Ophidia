package roger;

import net.minecraft.command.ICommand;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import roger.pathfind.TravelCommand;
import roger.pathfind.main.LookManager;
import roger.pathfind.main.PathRenderer;
import roger.pathfind.main.walk.Walker;
import java.util.Arrays;
import java.util.function.Consumer;

@Mod(modid = Ophidia.MODID, version = Ophidia.VERSION)
public class Ophidia
{
    public static final String MODID = "Ophidia";
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
