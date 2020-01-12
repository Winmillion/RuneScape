package AutoFighter;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public class Walk extends Task<ClientContext>  {
    public Walk(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate(Tile initial_loc) {
        return !ctx.movement.running() &&
                ctx.movement.energyLevel() == 100;
    }

    @Override
    public void execute(Tile initial_loc) {
        ctx.movement.running(true);
    }
}
