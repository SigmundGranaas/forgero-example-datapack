# Forgero example extension pack

This is an example extension pack for the [Forgero project](https://github.com/SigmundGranaas/forgero), a Minecraft mod made for Fabric.

In this pack you can add materials from other mods, make custom tools like our own extended package and someday you can also add custom code interactions. 

Why do we do it this way? Stuff from forgero needs to be loaded in at a certain time to work with the mod, datapacks get loaded to late into the cycle meaning your stuff won't work. 

## Setup

For setup instructions please see the [fabric wiki page](https://fabricmc.net/wiki/tutorial:setup) that relates to the IDE that you are using.

1. Update the `fabric.mod.json` file to have your own attributes, like sources, contact, authors, contributors, Discord, etc
2. Make sure to rename the main `net.fabricmc` packages to your own domain like `io.github.yourgithubusername`, and rename the `ExampleMod` class, as well as the entrypoints (in `fabric.mod.json`)
3. Plop a custom icon into `/src/main/resources/assets/modid/icon.png`
(Optional)
4. The example pack will be updated from 1.19.2 and onward. Other versions should work but you need to edit the fabric.mod.json yourself!

You're good to go! Enjoy, and good luck, making a Forgero extension pack!

## Materials

Forgero is split into modules called packs. Even base forgero has these packs thats why you can disable basically everything from forgero in the settings. The packs from base Forgero also provide a good example when you want to make something yourself. 

Every material consists of a material file (oak.json) and a palette file (oak.png). Both in their respective pack in data and assets. Important things in the material file are the: Type, ID, Parent (if possible) and Properties. 

The type defines which type of material it is. This also affects what you can do with it. If the material is classified as tool material like wood you can create tools with it and use it as upgrade material. Is it classified as upgrade material you can only use it as upgrade. There are more types but you should look into the forgero itself for that. 

The ID should correspond to the material ID in game. Like "minecraft:birch_planks" or "betternether:cincinassite". 

If the material has a parent it means it inherints stats from it, as example I put in the oak.json that has no stats in its file. This means is basically copies the stats from the wood_base file in material-baseline. The Birch.json also has the same parent but does have some of its own stats. The stats in birch.json override the same stats in wood_base. 

Properties are basically stats of the item. More of this is explained on the wiki. 

The palette file consists of 7 different colours which are colorcoded to the material itself. The system uses this to create the textures, do keep in mind that a dark tone around 20/30 is needed to let it fit with vanilla minecrafts dark edges. It doesnt matter if the palette is sorted by colour as the system will choose what to pick for which pixel very carefully. 

## Tools/schematics

Just like materials tools also have their own Type, Parent, Properties etc. But instead of having a 7 color palette the tool uses a model file in data. That model file refers to png files in assets. The grayscaled png file then determines the shape/look of the tool. 

Model files are a bit complicated. Take a look at the one in this pack. It has a model for the axe head, has a order in it (basically which layer it is, a low number will be overriden by a higher number) and a palette. The palette is pretty important, as it defines with which material type this tool can be made (this needs to be the same in the schematic file or it won't work). 

The material/upgrade and the dye slot are also set up the same as the main model. These have a higher order meaning the override the main file when used/upgraded. 

To let these work models work we need to target them. This specifies when to use them, what kind of model it is and which template to use (template refers to the name of the models). Once again the type here needs to match the palette and you need to specific the schematic so the system knows you make this when using a axe_head_schematic. THE TARGETS NEED TO BE CAPSLOCK!!!!!!!!!!

ModelType would be BASED_COMPOSITE for tools and UPGRADE for upgrade slots. 

To get a feeling for this look into the main forgero repo or use or discord to ask questions down below. 

## Discord

Feel free to join the [Discord](https://discord.gg/v6sDsftE9N) for any questions you may have.

## License

This template is available under the CC0 license. Feel free to learn from it and incorporate it in your own projects.
