package AIOFisher;

import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Npc;

public class Fish extends Task<ClientContext> {
    private int FISHING_SPOT_ID = 1522;

    public Fish(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().count() < 28
                && ctx.players.local().animation() == -1;
    }

    @Override
    public void execute() {
        Npc fishing_spot = ctx.npcs.select().id(FISHING_SPOT_ID).nearest().poll();
        if (fishing_spot.inViewport() && !ctx.players.local().inMotion()){
            System.out.println("in view");
            fishing_spot.interact("Cage", "Fishing spot");
            Condition.sleep(Random.nextInt(50,800));
            ctx.input.move(-3,Random.nextInt(15,400)); // moves mouse outside of play window(anti-anti-cheat??)
        } else {
            System.out.println("not in view");
            ctx.camera.turnTo(fishing_spot);
            Condition.sleep(Random.nextInt(50,800));
        }
    }
}