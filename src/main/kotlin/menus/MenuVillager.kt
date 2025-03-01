package me.void.menus


import me.void.util.Util
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.entity.Villager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.PlayerInteractAtEntityEvent
import org.bukkit.event.player.PlayerInteractEntityEvent
import org.bukkit.inventory.ItemStack

class MenuVillager: Listener {


    @EventHandler
    fun onVillagerMenuClick(event: PlayerInteractAtEntityEvent) {

        val player = event.player

        val entity = event.rightClicked

        val seller = Util.VillagersCreate.entityVillagers[0]
        val guide = Util.VillagersCreate.entityVillagers[1]
        val magazine = Util.VillagersCreate.entityVillagers[2]

        when {
            entity.name == seller.villagerName -> {

                Util.VillagerMenu.sellerVillagerMenu(player)

            }
            entity.name == guide.villagerName -> {

                Util.VillagerMenu.openVillagerGuide(player)

            }
            entity.name == magazine.villagerName && entity.type == magazine.typeEntity -> {

                Util.VillagerMenu.openVillagerMagazine(player)

            }
        }

    }

    @EventHandler
    fun onPlayerInteractVillager(event: PlayerInteractEntityEvent) {
        val entity = event.rightClicked
        event.isCancelled = entity is Villager
    }

        @EventHandler
        fun sell(event: InventoryClickEvent) {

            val player = event.whoClicked as Player

            val boots: ItemStack = Util.ItemsToFish.fishItems[0].toItemStack()
            val vine: ItemStack = Util.ItemsToFish.fishItems[1].toItemStack()
            val paint: ItemStack = Util.ItemsToFish.fishItems[2].toItemStack()

            val emeraldBoots = ItemStack(Material.EMERALD, 10)
            val emeraldVine = ItemStack(Material.EMERALD, 5)
            val emeraldPicture = ItemStack(Material.EMERALD, 15)

            val sellerGUI: String = ChatColor.DARK_PURPLE.toString() + "Меню скупщика"

            if (event.clickedInventory.title == sellerGUI) {

                if (hasItemInInventory(player, Material.LEATHER_BOOTS, 1)) {
                    player.inventory.removeItem(boots)
                    player.inventory.addItem(emeraldBoots)
                    player.sendMessage(ChatColor.GREEN.toString() + "Вы успешно продали вещь!")
                    event.isCancelled = true
                } else if (hasItemInInventory(player, Material.VINE, 1)) {
                    player.inventory.removeItem(vine)
                    player.inventory.addItem(emeraldVine)
                    event.isCancelled = true
                    player.sendMessage(ChatColor.GREEN.toString() + "Вы успешно продали вещь!")
                } else if (hasItemInInventory(player, Material.PAINTING, 1)) {
                    player.inventory.removeItem(paint)
                    player.inventory.addItem(emeraldPicture)
                    event.isCancelled = true
                    player.sendMessage(ChatColor.GREEN.toString() + "Вы успешно продали вещь!")
                } else {
                    player.sendMessage(ChatColor.RED.toString() + "Нет вещей на продажу")
                    event.isCancelled = true
                }

            }

        }

        @EventHandler
        fun buy(event: InventoryClickEvent) {

            val magazineGUI: String = ChatColor.AQUA.toString() + "Магазин"
            val player = event.whoClicked as Player

            val secondRod: ItemStack = Util.FishingData.fishingItems[1].toItemStack()
            val thirdRod: ItemStack = Util.FishingData.fishingItems[2].toItemStack()

            val emeraldFirstRod = ItemStack(Material.EMERALD, 15)
            val emeraldSecondRod = ItemStack(Material.EMERALD, 25)

            if (event.clickedInventory.title == magazineGUI) {
                if (event.currentItem.equals(secondRod)) {

                    if (hasItemInInventory(player, Material.EMERALD, 15)) {
                        player.inventory.removeItem(emeraldFirstRod)
                        player.inventory.addItem(secondRod)
                        player.closeInventory()
                        player.sendMessage(ChatColor.GREEN.toString() + "Вы успешно купили Крутую удочку!")
                    } else {
                        player.sendMessage(ChatColor.RED.toString() + "У Вас недостаточно средств")
                        player.closeInventory()
                    }

                } else if (event.currentItem.equals(thirdRod)) {
                    if (hasItemInInventory(player, Material.EMERALD, 25)) {
                        player.inventory.removeItem(emeraldSecondRod)
                        player.inventory.addItem(thirdRod)
                        player.closeInventory()
                        player.sendMessage(ChatColor.GREEN.toString() + "Вы успешно купили  Очень крутую удочку !")
                    } else {
                        player.sendMessage(ChatColor.RED.toString() + "У Вас недостаточно средств")
                        player.closeInventory()
                    }

                }

            }


        }

        @EventHandler
        fun guide(event: InventoryClickEvent) {

            val guideGUI: String = ChatColor.AQUA.toString() + "Меню гида"
            val player = event.whoClicked as Player

            val firstRod: ItemStack = Util.FishingData.fishingItems[0].toItemStack()

            if (event.clickedInventory.title == guideGUI) {
                if (event.currentItem.equals(firstRod)) {
                    if (!hasItemInInventory(player, Material.FISHING_ROD, 1)) {
                        player.inventory.addItem(firstRod)
                        player.closeInventory()
                        player.sendMessage(ChatColor.GREEN.toString() + "Вы успешно получили Начальную удочку!")
                    } else {
                        player.sendMessage(ChatColor.RED.toString() + "У Вас уже есть какая-либо удочка")
                        player.closeInventory()
                    }
                }
            }
        }

        fun hasItemInInventory(player: Player, material: Material, amount: Int): Boolean {
            val inventory = player.inventory
            var totalAmount = 0
            val contents = inventory.contents

            for (item in contents) {
                if (item != null && item.type == material) {
                    totalAmount += item.amount
                    if (totalAmount >= amount) {
                        return true
                    } else {
                        return false
                    }
                }
            }
            return totalAmount >= amount
        }






}


