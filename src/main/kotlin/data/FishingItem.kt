package me.void.data

import org.bukkit.Material
import org.bukkit.inventory.ItemStack

data class FishingItem(
    val material: Material, // Материал
    val itemName: String,    // Название вещи
    val lore: List<Any>,   // Лор (описание) вещи
    val price: String         // Цена вещи
) {
    fun toItemStack(): ItemStack {
        val itemStack = ItemStack(material)
        val meta = itemStack.itemMeta
        meta?.setDisplayName(itemName)
        meta?.lore = lore as MutableList<String>?
        itemStack.itemMeta = meta
        return itemStack
    }
}

