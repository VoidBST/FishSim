package me.void.commands

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.entity.Villager
import org.bukkit.util.EulerAngle

class SellerSpawn: CommandExecutor {


    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {

        val sellerName = ChatColor.DARK_RED.toString() + "Скупщик"

        if (sender is Player && sender.isOp) {

            val player = sender as Player

            val world = Bukkit.getWorld("world")

            if (world != null) {
                val villagerCoordinates = Location(world, player.location.x, player.location.y, player.location.z)
                val seller = world.spawnEntity(villagerCoordinates, EntityType.VILLAGER) as Villager
                seller.profession = (Villager.Profession.FARMER)
                seller.customName = sellerName
                seller.setAI(false)
            }



        }

        return true

    }

}