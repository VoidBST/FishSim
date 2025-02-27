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

class MagazineSpawn: CommandExecutor {


    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {

        val magazineName = ChatColor.DARK_GREEN.toString() + "Продавец"

        if (sender is Player && sender.isOp) {

            val player = sender

            val world = Bukkit.getWorld("world")

            if (world != null) {
                val villagerCoordinates = Location(world, player.location.x, player.location.y, player.location.z)
                val magazine = world.spawnEntity(villagerCoordinates, EntityType.VILLAGER) as Villager
                magazine.profession = (Villager.Profession.LIBRARIAN)
                magazine.customName = magazineName
                magazine.setAI(false)
            }



        }

        return true

    }

}