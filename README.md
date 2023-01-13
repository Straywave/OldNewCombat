Old New Combat
==============

A mod that ports Minecraft's abandoned [Combat Tests][1] as a mod for 1.16 and 1.18.

## Current Features

For a comprehensive list of changes, see the [Combat Tests][1] wiki page (Features under To-Do are obviously not
implemented yet). Some notable changes:

- Attack Damage and Attack Speed has been tweaked for all weapons
- Axes always disable shields, new "Cleaving" enchantment increases stun duration. No more durability penalty.
- Bow accuracy increased, however decreases the longer you hold it (Animation temporarily disabled)
- Natural regeneration doesn't get a boost from saturation, however regenerates twice as fast and until 7 hunger instead 
  of 18. Also causes less exhaustion.
- Players always get knocked back, even by 0-damage hits like Snowballs.
- Shields only block up to 5 damage. However, they block all non-player explosion (e.g. Creepers)
- Shields only block damage in a 100-degree arc, instead of a full 180 degrees.
- Potions stack to 16, snowballs to 64.
- Potions and milk buckets consume twice as fast.

## To-Do

- [ ] Fix bow accuracy animation
- [ ] 200% attacks, attack indicator tweaks
  - [ ] Charge resets quicker when attack missed
- [ ] Sweeping on Axes (can be enchanted, doesn't work)
- [ ] Shield blocks only 50% knockback
- [ ] Shield indicator
- [ ] Shield automatically activating upon crouching
  - [ ] Toggle under accessibility options
- [ ] Attack reach implementation
- [ ] Sprint critical attack
- [ ] Trident with Impaling deals damage in rain/water

[1]: https://minecraft.fandom.com/wiki/Java_Edition_Combat_Tests
