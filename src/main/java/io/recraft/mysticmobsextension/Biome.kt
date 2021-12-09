package io.recraft.mysticmobsextension

import io.lumine.xikage.mythicmobs.adapters.AbstractBiome
import io.lumine.xikage.mythicmobs.adapters.AbstractLocation
import io.lumine.xikage.mythicmobs.io.MythicLineConfig
import io.lumine.xikage.mythicmobs.skills.SkillCondition
import io.lumine.xikage.mythicmobs.skills.conditions.ILocationCondition
import io.lumine.xikage.mythicmobs.util.annotations.MythicField
import java.util.*

class BiomeCondition(line: String?, mlc: MythicLineConfig) : SkillCondition(line),
    ILocationCondition {
    @MythicField(name = "biome", aliases = ["b"], description = "A list of biomes to check")
    private val biome: MutableSet<AbstractBiome?> = HashSet<AbstractBiome?>()
    override fun check(l: AbstractLocation): Boolean {
        return biome.contains(l.biome)
    }

    init {
        val  b = mlc.getString(arrayOf("biome", "b"), "PLAINS", *arrayOf(conditionVar))
        val var4: Array<String> = b.split(",", ignoreCase = true, limit = 1).toTypedArray()
        val var5 = var4.size
        for (var6 in 0..var5) {
            val s = var4[var6]
            biome.add(AbstractBiome(s))
        }
    }
}
