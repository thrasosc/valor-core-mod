```json
{
  "title": "Thirst",
  "icon": "minecraft:potion{Potion:purified_water}",
  "category": "valor_core:game_mechanics",
  "associated_items": [
    "dehydration:leather_flask",
    "dehydration:iron_leather_flask",
    "dehydration:golden_leather_flask",
    "dehydration:diamond_leather_flask",
    "dehydration:netherite_leather_flask",
    "dehydration:copper_cauldron",
    "dehydration:campfire_cauldron",
    "dehydration:bamboo_pump",
    "minecraft:potion{Potion:purified_water}"
  ],
  "ordinal": 0
}
```

In addition to satisfying hunger, you also have to quench your thirst.

---

You can drink water from any water source by holding <keybind;key.use>, but fresh water may only be found in rivers.

;;;;;

A %{item.dehydration.leather_flask}% can be crafted to store purified water. Be careful not to mix it with dirty water,
otherwise it will become dirty too.

<recipe;dehydration:leather_flask>

;;;;;

The flask can be upgraded to the following tiers.

<recipe;dehydration:iron_leather_flask>

<recipe;dehydration:golden_leather_flask>

;;;;;

<recipe;dehydration:diamond_leather_flask>

<recipe;dehydration:netherite_leather_flask>

Additionally, you can purify water yourself with a number of different methods.

;;;;;

1. Place a %{item.minecraft.potion.effect.water}% onto a campfire to obtain a
   %{item.minecraft.potion.effect.purified_water}%.

2. Additionally, you can build a %{block.dehydration.campfire_cauldron}% to heat up dirty water and purify it. First
   craft a %{block.dehydration.copper_cauldron}%.

<recipe;dehydration:copper_cauldron>

;;;;;

Then craft a %{block.dehydration.campfire_cauldron}%.

<recipe;dehydration:campfire_cauldron>

;;;;;

Then, place the %{block.dehydration.copper_cauldron}% above a %{block.minecraft.campfire}%.

<structure;valor_core:campfire_cauldron>

;;;;;

3. Finally, you can make a %{block.dehydration.bamboo_pump}%, which pumps out fresh water straight from the ground.

<recipe;dehydration:bamboo_pump>

;;;;;

Simply place the %{block.dehydration.bamboo_pump}% on a flat surface, attach an empty bottle or bucket, press <keybind;key.use> to turn on and off the pump, then <keybind;key.sneak>-<keybind;key.use> to obtain your purified water
container.