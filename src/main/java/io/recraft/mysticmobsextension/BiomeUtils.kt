
package io.recraft.mysticmobsextension

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.chunk.LevelChunk;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import org.bukkit.craftbukkit.v1_18_R1.CraftServer;
import org.bukkit.craftbukkit.v1_18_R1.CraftWorld;


object NMSBiomeUtils {
   // private val BIOME_REGISTRY_RESOURCE_KEY: ResourceKey<Registry<Biome>> = Registry.BIOME_REGISTRY

    fun getBiomeName(location: Location): Pair<String, String> {
        val key: ResourceLocation = getBiomeKey(location)
        return Pair(key.getNamespace(), key.getPath())
    }

    val biomeRegistry: Registry<Biome>
        get() {
            val dedicatedServer: DedicatedServer = (Bukkit.getServer() as CraftServer).server
            return dedicatedServer.registryAccess().registry(Registry.BIOME_REGISTRY).get()
        }

    fun getBiomeKey(location: Location): ResourceLocation {
        val registry: Registry<Biome> = biomeRegistry
        val resourceKey = getBiomeBase(location)
        return registry.getKey(resourceKey)!!
    }

    fun getBiomeBase(location: Location): Biome {
        val pos = BlockPos(location.blockX, 0, location.blockZ)
        val nmsChunk: LevelChunk = (location.world as CraftWorld).handle.getChunkAt(pos)
        return  nmsChunk.getNoiseBiome(pos.getX(), 0, pos.getZ())
    }
}

