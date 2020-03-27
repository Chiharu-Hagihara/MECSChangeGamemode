package mc.mec.mecsgamemodechange.commands

import mc.mec.mecsgamemodechange.commands.GmCommand.setCreative
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player

object ModeCommand : CommandExecutor {
    var _prefix = "§b§l[MGC]"
    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {
        val p = sender as Player
        if (sender is ConsoleCommandSender) {
            sender.sendMessage("This command can only be executed by a player.")
            return false
        }
        if(p.hasPermission("mgc.use")){
            p.sendMessage("$_prefix §4§lYou don't have permission.")
        }
        when(cmd.name){
            "creative" -> {
                setCreative(p)
            }
            "adventure" -> {
                GmCommand.setAdventure(p)
            }
            "spectator" -> {
                GmCommand.setSpectator(p)
            }
            "survival" -> {
                GmCommand.setSurvival(p)
            }
        }
        return true
    }
}