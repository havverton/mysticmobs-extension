package io.recraft.mysticmobsextension

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import io.lumine.xikage.mythicmobs.api.bukkit.events.MythicConditionLoadEvent;
import io.lumine.xikage.mythicmobs.utils.logging.Log
import org.bukkit.event.player.PlayerInteractEvent


class MysticmobsExtension : JavaPlugin(), Listener {
    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        Log.info("Я родился")
    }


    override fun onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    fun onPlayerInteractEvent(event: PlayerInteractEvent){
       val name =  NMSBiomeUtils.getBiomeName(event.clickedBlock!!.location)
        event.player.sendMessage("$name")
    }

    @EventHandler
    fun onMythicConditionLoad(event: MythicConditionLoadEvent) {
        Log.info("MythicConditionLoadEvent called for condition " + event.conditionName)
        if (event.conditionName.equals("recraftbiome")) {
            val condition: BiomeCondition = BiomeCondition(event.config.line,event.config)
            event.register(condition)
            Log.info("-- Registered recraftBiome condition!")
        }
    }
}