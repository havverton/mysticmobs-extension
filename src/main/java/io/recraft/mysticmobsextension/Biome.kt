//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package io.recraft.mysticmobsextension

import io.lumine.xikage.mythicmobs.adapters.AbstractBiome
import io.lumine.xikage.mythicmobs.adapters.AbstractLocation
import io.lumine.xikage.mythicmobs.io.MythicLineConfig
import io.lumine.xikage.mythicmobs.skills.SkillCondition
import io.lumine.xikage.mythicmobs.skills.conditions.ILocationCondition
import io.lumine.xikage.mythicmobs.util.annotations.MythicCondition
import io.lumine.xikage.mythicmobs.util.annotations.MythicField
import org.bukkit.block.Biome


@MythicCondition(
    author = "Egorka",
    name = "recraftbiome",
    aliases = [],
    description = "Tests if the target is within the given list of biomes"
)
class BiomeCondition(line: String?, mlc: MythicLineConfig) : SkillCondition(line),
    ILocationCondition {
    @MythicField(name = "recraftbiome", aliases = ["b"], description = "A list of biomes to check")
    private val biome: MutableSet<Biome?> = HashSet<Biome?>()

    init {
      /*  val b = mlc.getString(arrayOf("biome", "b"), "PLAINS", *arrayOf(conditionVar))
        val var4 = b.split(",").toTypedArray()
        val var5 = var4.size
        for (var6 in 0 until var5) {
            val s = var4[var6]
            biome.add(Biome().)
        }*/
    }

    override fun check(l: AbstractLocation): Boolean {
        return false
    }
}