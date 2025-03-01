package me.void.commands

import me.void.data.CustomVillager
import me.void.data.EntityVillagersID
import me.void.util.Util
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.entity.Villager


class GuidSpawn: CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (sender is Player && sender.isOp) {

            Util.SpawnVillagers.spawnGuideVillager(sender)

        }
        return true
    }
}