package AutoFighter;

import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public class Delay extends Task<ClientContext> {

    public Delay(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate(Tile initial_loc) {
        return ctx.players.local().animation() == -1
                && !ctx.players.local().inMotion();
    }

    @Override
    public void execute(Tile initial_loc) {
        System.out.println("delay");
        if (ctx.players.local().healthPercent() > 30){
            Condition.sleep(Random.nextInt(700, 2400));
        }
    }
}