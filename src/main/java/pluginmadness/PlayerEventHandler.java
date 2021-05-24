package pluginmadness;

import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;


public class PlayerEventHandler implements Listener {

     /* TODO add in "Deficating" command system */

    @EventHandler
    public void onSneak (PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        Location location = player.getLocation();

        if(location.subtract(0, 1, 0).getBlock().getType().isSolid() && event.isSneaking()) {

            ItemStack bean = new ItemStack(Material.COCOA_BEANS);
            ItemMeta beanMeta = bean.getItemMeta();

            beanMeta.displayName(Component.text("Strange Substance"));
            bean.setItemMeta(beanMeta);

            Item item = player.getWorld().dropItem(location.add(0,1.5,0), bean);
            item.setVelocity(new Vector(-location.getDirection().getX(), 0, -location.getDirection().getZ()));

            player.sendMessage(player.getName() + " has deficated themselves!");
        }
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        if(Thor.isRunning()) {
            Player player = event.getPlayer();
            ItemStack inHand = player.getInventory().getItemInMainHand();

            if (Thor.targetHand().equals(inHand) && event.getAction() == Action.LEFT_CLICK_AIR) {
                player.getWorld().strikeLightning(player.getTargetBlock(null, 64).getLocation());
            }
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if(Scaffold.isRunning()) {
            Player player = event.getPlayer();
            if(Scaffold.getPlayers().contains(player)) {
                Location location = player.getLocation();
                World world = player.getWorld();

                if (event.getTo() != event.getFrom()) {
                    world.getBlockAt(location.subtract(0, 1, 0)).setType(Scaffold.curMaterial());
                }
            }
        }
    }
/*TODO Make creeper explosions double (if possible)
    @EventHandler
    public void creeperExplosion(EntitySpawnEvent event) {
        if(event.isCancelled()) {
            return;
        }
        Entity entity = event.getEntity();


    }*/
/* TODO Change to specific player targeted for the big funny using UUIDs */
    @EventHandler
    public void onBlockBreak(BlockDamageEvent event) {
        if (BigFunni.isRunning()) {

            int delay = 1; //# of ticks
            Location blockLocal = event.getBlock().getLocation();
            World world = blockLocal.getWorld();

            new BukkitRunnable() {
                @Override
                public void run() {
                    if (event.getBlock().getType().equals(Material.DIAMOND_ORE)) {
                        world.getBlockAt(blockLocal).setType(Material.STONE);
                    }
                }
            }.runTaskLater(PluginMadness.getPlugin(), delay);
        }
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
        if(BigFunni.isRunning()) {
            ItemStack item = event.getCurrentItem();
            if(item != null) {
                ItemStack replace = new ItemStack(Material.AIR, item.getAmount());
                ItemStack check = new ItemStack(Material.DIAMOND, item.getAmount());

                if (item.equals(check)) {
                    event.setCurrentItem(replace);
                }
            }
        }
    }
}
