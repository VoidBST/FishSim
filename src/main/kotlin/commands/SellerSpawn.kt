package me.void.commands

import me.void.data.CustomVillager
import me.void.util.Util
import me.void.util.Util.VillagersCreate
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

        if (sender is Player && sender.isOp) {

            Util.SpawnVillagers.spawnVillagerSeller(sender)

        }

        return true

    }

}