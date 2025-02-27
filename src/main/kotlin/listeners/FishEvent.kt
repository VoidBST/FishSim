package me.void.listeners


import me.void.util.Util
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

            val boots: ItemStack = Util.ItemsToFish.fishItems[0].toItemStack()
            val vine: ItemStack = Util.ItemsToFish.fishItems[1].toItemStack()
            val paint: ItemStack = Util.ItemsToFish.fishItems[2].toItemStack()
            val randomListFish = listOf(boots, vine, paint)

            // Выбор случайного предмета
            val randomLoot = randomListFish.random()


            // Добавление предмета в инвентарь игрока
            player.inventory.addItem(randomLoot)
            event.caught.remove()

            // Убираем определенное количество опыта (например, 5)
            val newExp = player.totalExperience - 5
            player.totalExperience = if (newExp < 0) 0 else newExp

            // Уведомление игрока о получении предмета
            player.sendMessage(ChatColor.GREEN.toString() + "Вы успешно поймали предмет!")




        }

    }
}