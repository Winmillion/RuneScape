package AutoFighter;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Game;

public class Food extends Task<ClientContext> {

    public Food(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate(DataBean data) {
        return ctx.players.local().healthPercent() <= data.getHealPercent();
    }

    @Override
    public void execute(DataBean data) {
        System.out.println("heal now omfg aaaaaaa");
        // switch to invenotry tab if not on it before trying to eat fish
        if (ctx.game.tab() == Game.Tab.INVENTORY){
            if (ctx.players.local().animation() != 829 && ctx.players.local().healthPercent() <= data.getHealPercent()){ // checks if already eating && recheck if hp is lower than selected amount
                ctx.inventory.select().action("Eat").poll().interact("Eat");
            }
        }
        else {
            ctx.game.tab(Game.Tab.INVENTORY);
        }
    }
}
