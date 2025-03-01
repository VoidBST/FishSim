package me.void.listeners


import me.void.util.ItemsToFish
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerFishEvent
import org.bukkit.inventory.ItemStack


class FishEvent: Listener {


    @EventHandler
    fun fishEventListener(event: PlayerFishEvent) {

        if (event.state == PlayerFishEvent.State.CAUGHT_FISH) {

            val player = event.player

            val boots: ItemStack = ItemsToFish.fishItems[0].toItemStack()
            val vine: ItemStack = ItemsToFish.fishItems[1].toItemStack()
            val paint: ItemStack = ItemsToFish.fishItems[2].toItemStack()

            val randomListFish = listOf(boots, vine, paint)
            val randomLoot = randomListFish.random()

            player.inventory.addItem(randomLoot)
            event.caught.remove()

            val newExp = player.totalExperience - 5
            player.totalExperience = if (newExp < 0) 0 else newExp

            player.sendMessage(ChatColor.GREEN.toString() + "Вы успешно поймали предмет!")

        }

    }
}