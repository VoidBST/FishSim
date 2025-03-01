package me.void

import me.void.commands.GuidSpawn
import me.void.commands.MagazineSpawn
import me.void.commands.SellerSpawn
import me.void.listeners.FishEvent
import me.void.menus.MenuVillager
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.ArmorStand
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {

    companion object {
        lateinit var instance: Main
            private set
    }

    init {
        instance = this
    }

    override fun onEnable() {

        instance = this

        server.pluginManager.registerEvents(FishEvent(), this)

        getCommand("spawnSeller").executor = SellerSpawn()
        getCommand("spawnMagazine").executor = MagazineSpawn()
        getCommand("spawnGuid").executor = GuidSpawn()

        server.pluginManager.registerEvents(MenuVillager(), this)

        saveDefaultConfig()

    }

    override fun onDisable() {
        server.onlinePlayers.forEach { player ->
            player.world.entities.forEach { entity ->
                if (entity !is Player) {
                    entity.remove()
                }
            }
        }
    }

}




