package me.void.commands

import me.void.util.SpawnVillagers
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player


class SellerSpawn: CommandExecutor {


    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {

        if (sender is Player && sender.isOp) {

            SpawnVillagers.spawnVillagerSeller(sender)

        }

        return true

    }

}