package me.void.data

import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

data class Rods(
    val material: Material,
    val itemName: String,
    val lore: List<String>,
    val enchants: Map<Enchantment, Int> // Зачарование и его уровень
) {

    fun toItemStack(): ItemStack {
        val itemStack = ItemStack(material)
        val meta = itemStack.itemMeta ?: return itemStack

        meta.displayName = itemName
        meta.lore = lore
        for ((enchantment, level) in enchants) {
            meta.addEnchant(enchantment, level, true)
        }
        itemStack.itemMeta = meta

        return itemStack
    }
}

