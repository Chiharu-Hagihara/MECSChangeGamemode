package mc.mec.mecsgamemodechange.commands

import org.bukkit.GameMode
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player

object GmCommand : CommandExecutor {
    var _prefix = "§b§l[MGC]"
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        val p = sender as Player
        if (sender is ConsoleCommandSender) {
            sender.sendMessage("This command can only be executed by a player.")
            return false
        }
        if(p.hasPermission("mgc.use")){
            p.sendMessage("$_prefix §4§lYou don't have permission.")
        }
        if (command.name == "gm") {
            val cmd = args[0]
            if (args != null&& args.isEmpty()) {
                showHelp(p)
            }
            when (cmd) {
                "c" -> {
                    setCreative(p)
                }
                "a" -> {
                    setAdventure(p)
                }
                "sp" -> {
                    setSpectator(p)
                }
                "s" -> {
                    setSurvival(p)
                }
                "creative" -> {
                    setCreative(p)
                }
                "adventure" -> {
                    setAdventure(p)
                }
                "spectator" -> {
                    setSpectator(p)
                }
                "survival" -> {
                    setSurvival(p)
                }
            }
        }
        return true
    }
    fun showHelp(p: Player){
        p.sendMessage("$_prefix §f/<1/2/3/0>")
        p.sendMessage("$_prefix §f/gm <1/2/3/0>")
        p.sendMessage("$_prefix §f/gm <c/a/sp/s>")
        p.sendMessage("$_prefix §f/gm creative")
        p.sendMessage("$_prefix §f/gm adventure")
        p.sendMessage("$_prefix §f/gm spectator")
        p.sendMessage("$_prefix §f/gm survival")
        p.sendMessage("$_prefix §f/creative")
        p.sendMessage("$_prefix §f/adventure")
        p.sendMessage("$_prefix §f/spectator")
        p.sendMessage("$_prefix §f/spectator")
    }

    fun setCreative(p: Player) {
        p.gameMode = GameMode.CREATIVE
        p.sendMessage(NumberCommand._prefix + "ゲームモードをクリエイティブに変更しました。")
    }

    fun setSurvival(p: Player) {
        p.gameMode = GameMode.SURVIVAL
        p.sendMessage(NumberCommand._prefix + "ゲームモードをサバイバルに変更しました。")
    }

    fun setAdventure(p: Player) {
        p.gameMode = GameMode.ADVENTURE
        p.sendMessage(NumberCommand._prefix + "ゲームモードをアドベンチャーに変更しました。")
    }

    fun setSpectator(p: Player) {
        p.gameMode = GameMode.SPECTATOR
        p.sendMessage(NumberCommand._prefix + "ゲームモードをスペクテイターに変更しました。")
    }
}