package me.void.util


import me.void.data.FishingItem
import me.void.data.Rods
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Util {

    companion object {
        fun openVillagerGuide(player: Player) {

            val inventoryGuide = Bukkit.createInventory(null, 9, ChatColor.AQUA.toString() + "Меню гида")

            val firstRod = FishingData.fishingItems[0]

            inventoryGuide.setItem(4, firstRod.toItemStack())
            player.openInventory(inventoryGuide)
        }

        fun sellerVillagerMenu(player: Player) {

            val sellerMenu = Bukkit.createInventory(null, 27, ChatColor.DARK_PURPLE.toString() + "Меню скупщика")


            val boots: ItemStack = ItemsToFish.fishItems[0].toItemStack()
            val vine: ItemStack = ItemsToFish.fishItems[1].toItemStack()
            val paint: ItemStack = ItemsToFish.fishItems[2].toItemStack()

            sellerMenu.setItem(12, boots)
            sellerMenu.setItem(13, vine)
            sellerMenu.setItem(14, paint)

            player.openInventory(sellerMenu)

        }

        fun openVillagerMagazine(player: Player) {

            val inventoryMagazine = Bukkit.createInventory(null, 36, ChatColor.AQUA.toString() + "Магазин")

            val secondRod = FishingData.fishingItems[1]
            val thirdRod = FishingData.fishingItems[2]


            inventoryMagazine.setItem(12, secondRod.toItemStack())
            inventoryMagazine.setItem(14, thirdRod.toItemStack())

            player.openInventory(inventoryMagazine)
        }


    }

    object FishingData {

        private val rodMaterial = Material.FISHING_ROD
        private val rodName = ChatColor.GREEN.toString() + "Начальная удочка"
        private val rodLore = listOf(
            ChatColor.DARK_RED.toString() + "Это просто начальная удочка!",
        )

        private val rodMaterial1 = Material.FISHING_ROD
        private val rodName1 = ChatColor.GREEN.toString() + "Крутая удочка"
        private val rodLore1 = listOf(
            ChatColor.DARK_RED.toString() + "Это уже более крутая удочка, чем начальная!",
            ChatColor.GOLD.toString() + "Цена покупки: 15 изумрудов"
        )

        private val rodMaterial2 = Material.FISHING_ROD
        private val rodName2 = ChatColor.BLUE.toString() + "Очень крутая удочка"
        private val rodLore2 = listOf(
            ChatColor.DARK_AQUA.toString() + "Это самая крутая удочка из всех!",
            ChatColor.GOLD.toString() + "Цена покупки: 25 изумрудов"
        )

        private val enchantmentsSecondRod = mapOf(
            Enchantment.LUCK to 3,
            Enchantment.DAMAGE_ALL to 2
        )
        private val enchantmentsThirdRod = mapOf(
            Enchantment.DURABILITY to 5,
            Enchantment.DAMAGE_ALL to 5
        )

        private val enchant = mapOf(
            Enchantment.DURABILITY to 1,
            Enchantment.DAMAGE_ALL to 1
        )

        val fishingItems = listOf(
            Rods(rodMaterial, rodName, rodLore, enchant),
            Rods(rodMaterial1, rodName1, rodLore1, enchantmentsSecondRod),
            Rods(rodMaterial2, rodName2, rodLore2, enchantmentsThirdRod),
        )

    }

    object ItemsToFish {

        private val bootsMaterial = Material.LEATHER_BOOTS
        private val bootsName = ChatColor.DARK_GRAY.toString() + "Старые ботинки"
        private val bootsLore = listOf(
            ChatColor.DARK_PURPLE.toString() + "Это старые кожаные ботинки",
            ChatColor.DARK_PURPLE.toString() + "Кто их вообще мог забыть тут? И как?",
            ChatColor.DARK_PURPLE.toString() + "Цена продажи: " + ChatColor.GOLD.toString() + "10" + ChatColor.GREEN.toString() + " Изумрудов"
        )
        private val vineChance: Double = 0.5

        private val vineMaterial = Material.VINE
        private val vineName =
            ChatColor.DARK_GREEN.toString() + "Водоросли? Или же что-то" + ChatColor.RED.toString() + " другое?"
        private val vineLore = listOf(
            ChatColor.GREEN.toString() + "Возможно это водоросли...",
            ChatColor.GREEN.toString() + "А может быть эта была другая органика",
            ChatColor.DARK_PURPLE.toString() + "Цена продажи: " + ChatColor.GOLD.toString() + "5" + ChatColor.GREEN.toString() + " Изумрудов"
        )
        private val bootsChance: Double = 0.8

        private val paintMaterial = Material.PAINTING
        private val paintName = ChatColor.GOLD.toString() + "Старая картина"
        private val paintLore = listOf(
            ChatColor.BLUE.toString() + "Какая-то старая картина",
            ChatColor.BLUE.toString() + "Возможно она была когда-то даже дорогой...",
            ChatColor.DARK_PURPLE.toString() + "Цена продажи: " + ChatColor.GOLD.toString() + "15" + ChatColor.GREEN.toString() + " Изумрудов"
        )
        private val paintChance: Double = 0.2

        val fishItems = listOf(
            FishingItem(bootsMaterial, bootsName, bootsLore, bootsChance.toString()),
            FishingItem(vineMaterial, vineName, vineLore, vineChance.toString()),
            FishingItem(paintMaterial, paintName, paintLore, paintChance.toString())

        )
    }
}

