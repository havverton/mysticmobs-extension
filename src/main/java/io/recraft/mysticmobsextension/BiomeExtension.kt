package io.recraft.mysticmobsextension

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import io.lumine.xikage.mythicmobs.api.bukkit.events.MythicConditionLoadEvent;
import io.lumine.xikage.mythicmobs.skills.SkillCondition;
import io.lumine.xikage.mythicmobs.skills.conditions.all.BiomeCondition
import io.lumine.xikage.mythicmobs.utils.logging.Log


class MysticmobsExtension : JavaPlugin(), Listener {
    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }


    @EventHandler
    fun onMythicConditionLoad(event: MythicConditionLoadEvent) {
        Log.info("MythicConditionLoadEvent called for condition " + event.conditionName)
        if (event.conditionName.equals("INVEHICLE")) {
            val condition: BiomeCondition = BiomeCondition("kek",event.config)
            event.register(condition)
            Log.info("-- Registered InVehicle condition!")
        }
    }
}