package com.mystyk.minecraftmystyk.item;

import com.mystyk.minecraftmystyk.MinecraftMystyk;
import com.mystyk.minecraftmystyk.item.custom.MidasWand;
import com.mystyk.minecraftmystyk.trim.ModTrimMaterials;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;


public class ModItems {

    public static final Item ENDER_SHARD = registerItem("ender_shard",
            settings -> new Item(new Item.Settings().trimMaterial(ModTrimMaterials.ENDER_SHARD).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MinecraftMystyk.MOD_ID, "ender_shard")))));
    public static final Item ENDER_SHARD_FRAGMENT = registerItem("ender_shard_fragment",
            settings -> new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MinecraftMystyk.MOD_ID, "ender_shard_fragment")))));

    /*public static final Item ENDER_INFUSED_HANDLE = registerItem("ender_infused_handle", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MinecraftMystyk.MOD_ID, "ender_infused_handle")))));*/

    public static final Item ADVANCED_ECHO_SHARD = registerItem("advanced_echo_shard",
            settings -> new Item(new Item.Settings().trimMaterial(ModTrimMaterials.ADVANCED_ECHO_SHARD).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MinecraftMystyk.MOD_ID, "advanced_echo_shard")))));
    public static final Item ADVANCED_ECHO_FRAGMENT = registerItem("advanced_echo_fragment",
            settings -> new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MinecraftMystyk.MOD_ID, "advanced_echo_fragment")))));

    public static final Item FENDER_SMITHING_TEMPLATE = registerItem(
            "fender_armor_trim",
            settings -> SmithingTemplateItem.of(settings.rarity(Rarity.RARE))
    );

    public static final Item PULSE_SMITHING_TEMPLATE = registerItem(
            "pulse_armor_trim",
            settings -> SmithingTemplateItem.of(settings.rarity(Rarity.EPIC))
    );

    public static final Item ENDER_UPGRADE_SMITHING_TEMPLATE = registerItem(
            "ender_upgrade",
            settings -> SmithingTemplateItem.of(settings.rarity(Rarity.RARE))
    );

    public static final Item ECHO_UPGRADE_SMITHING_TEMPLATE = registerItem(
            "echo_upgrade",
            settings -> SmithingTemplateItem.of(settings.rarity(Rarity.RARE))
    );

    public static final Item MIDAS_WAND = registerItem("midas_wand",
            settings -> new MidasWand(settings.tool(ModToolMaterials.MIDAS_MATERIAL, null, -4.0f, 0, 0)));


    public static final Item ENDER_INFUSED_SWORD = registerItem("ender_sword",
            setting -> new Item(setting.sword(ModToolMaterials.ENDER_SHARD, 3.0f, -2.4f)));
    public static final Item ENDER_INFUSED_PICKAXE = registerItem("ender_pickaxe",
            setting -> new Item(setting.pickaxe(ModToolMaterials.ENDER_SHARD, 3.0f, -2.4f)));
    public static final Item ENDER_INFUSED_AXE = registerItem("ender_axe",
            setting -> new AxeItem(ModToolMaterials.ENDER_SHARD, 5.0f, -3.0f, setting));
    public static final Item ENDER_INFUSED_SHOVEL = registerItem("ender_shovel",
            setting -> new ShovelItem(ModToolMaterials.ENDER_SHARD, -1.5f, -3.0f, setting));
    public static final Item ENDER_INFUSED_HOE = registerItem("ender_hoe",
            setting -> new HoeItem(ModToolMaterials.ENDER_SHARD, -4.0f, 0, setting));

    /*public static final Item ENDER_INFUSED_SPEAR = registerItem("ender_spear",
            setting -> new Item(setting.spear(ModToolMaterials.ENDER_SHARD,
                    1.15f,
                    1.2f,
                    0.5f,
                    2.0f,
                    0.2f,
                    9.0f,
                    0.25f,
                    9.0f,
                    0.15f)));*/


    public static final Item ENDER_INFUSED_HELM = registerItem("ender_helm",
            setting -> new Item(setting.armor(ModArmorMaterials.ENDER_SHARD_ARMOR_MATERIAL, EquipmentType.HELMET)));
    public static final Item ENDER_INFUSED_BRACERS = registerItem("ender_chest",
            setting -> new Item(setting.armor(ModArmorMaterials.ENDER_SHARD_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)));
    public static final Item ENDER_INFUSED_GREAVES = registerItem("ender_legs",
            setting -> new Item(setting.armor(ModArmorMaterials.ENDER_SHARD_ARMOR_MATERIAL, EquipmentType.LEGGINGS)));
    public static final Item ENDER_INFUSED_HEELS = registerItem("ender_feet",
            setting -> new Item(setting.armor(ModArmorMaterials.ENDER_SHARD_ARMOR_MATERIAL, EquipmentType.BOOTS)));

    public static final Item ECHOING_SWORD = registerItem("echo_sword",
            setting -> new Item(setting.sword(ModToolMaterials.ADVANCED_ECHO_SHARD, 3, -2.4f)));
    public static final Item ECHOING_PICKAXE = registerItem("echo_pickaxe",
            setting -> new Item(setting.pickaxe(ModToolMaterials.ADVANCED_ECHO_SHARD, 3, -2.4f)));
    public static final Item ECHOING_AXE = registerItem("echo_axe",
            setting -> new AxeItem(ModToolMaterials.ADVANCED_ECHO_SHARD, 5, -3f, setting));
    public static final Item ECHOING_SHOVEL = registerItem("echo_shovel",
            setting -> new ShovelItem(ModToolMaterials.ADVANCED_ECHO_SHARD, -1.5f, -3.0f, setting));
    public static final Item ECHOING_HOE = registerItem("echo_hoe",
            setting -> new HoeItem(ModToolMaterials.ADVANCED_ECHO_SHARD, -4, 0, setting));

    /*public static final Item ECHOING_SPEAR = registerItem("echo_spear",
            setting -> new Item(setting.spear(ModToolMaterials.ENDER_SHARD,
                    1.15f,
                    1.2f,
                    0.5f,
                    2.0f,
                    0.2f,
                    9.0f,
                    0.25f,
                    9.0f,
                    0.15f)));*/

    public static final Item ECHOING_HELM = registerItem("echo_helm",
            setting -> new Item(setting.armor(ModArmorMaterials.ADVANCED_ECHO_SHARD_ARMOR_MATERIAL, EquipmentType.HELMET)));
    public static final Item ECHOING_BRACERS = registerItem("echo_chest",
            setting -> new Item(setting.armor(ModArmorMaterials.ADVANCED_ECHO_SHARD_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)));
    public static final Item ECHOING_GREAVES = registerItem("echo_legs",
            setting -> new Item(setting.armor(ModArmorMaterials.ADVANCED_ECHO_SHARD_ARMOR_MATERIAL, EquipmentType.LEGGINGS)));
    public static final Item ECHOING_HEELS = registerItem("echo_feet",
            setting -> new Item(setting.armor(ModArmorMaterials.ADVANCED_ECHO_SHARD_ARMOR_MATERIAL, EquipmentType.BOOTS)));



    /*public static final Item ENDER_MACE = registerItem("ender_mace", new MaceItem( new Item.Settings().maxDamage(750).attributeModifiers(MaceItem.createAttributeModifiers())));
    public static final Item ENDER_STRUNG_BOW = registerItem("ender_bow", new BowItem(new Item.Settings().maxDamage(640)));*/

    private static Item registerItem(String name, Function<Item.Settings, Item> item) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MinecraftMystyk.MOD_ID, name));


        return Items.register(registryKey, item);
    }

    public static void registerModItems() {
        MinecraftMystyk.LOGGER.info("Registering Mod Items for " +MinecraftMystyk.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ENDER_SHARD);
            entries.add(ADVANCED_ECHO_SHARD);
            entries.add(ENDER_SHARD_FRAGMENT);
            entries.add(ADVANCED_ECHO_FRAGMENT);
            //entries.add(ENDER_INFUSED_HANDLE);
            entries.add(FENDER_SMITHING_TEMPLATE);
            entries.add(PULSE_SMITHING_TEMPLATE);
            entries.add(ENDER_UPGRADE_SMITHING_TEMPLATE);
            entries.add(ECHO_UPGRADE_SMITHING_TEMPLATE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(ENDER_INFUSED_SHOVEL);
            entries.add(ENDER_INFUSED_PICKAXE);
            entries.add(ENDER_INFUSED_AXE);
            entries.add(ENDER_INFUSED_HOE);

            entries.add(ECHOING_SHOVEL);
            entries.add(ECHOING_PICKAXE);
            entries.add(ECHOING_AXE);
            entries.add(ECHOING_HOE);

            entries.add(MIDAS_WAND);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(ENDER_INFUSED_HELM);
            entries.add(ENDER_INFUSED_BRACERS);
            entries.add(ENDER_INFUSED_GREAVES);
            entries.add(ENDER_INFUSED_HEELS);
            entries.add(ENDER_INFUSED_SWORD);
            entries.add(ENDER_INFUSED_AXE);
            //entries.add(ENDER_INFUSED_SPEAR);


            entries.add(ECHOING_HELM);
            entries.add(ECHOING_BRACERS);
            entries.add(ECHOING_GREAVES);
            entries.add(ECHOING_HEELS);
            entries.add(ECHOING_SWORD);
            entries.add(ECHOING_AXE);
            //entries.add(ECHOING_SPEAR);

            /*entries.add(ENDER_MACE);
            entries.add(ENDER_STRUNG_BOW);*/
        });
    }
}
