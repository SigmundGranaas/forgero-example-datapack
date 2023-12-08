package net.fabricmc.example;

import com.sigmundgranaas.forgero.core.state.Identifiable;
import com.sigmundgranaas.forgero.fabric.api.entrypoint.ForgeroInitializedEntryPoint;
import com.sigmundgranaas.forgero.minecraft.common.service.StateService;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

public class ExampleMod implements ModInitializer, ForgeroInitializedEntryPoint {
	public static final String MOD_ID = "modid";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello from a Forgero extension pack!");
	}

	@Override
	public void onInitialized(StateService service) {
		LOGGER.info("Hello from an initialized Forgero! Here are all registered and initialized items managed by Forgero:");
		service.all()
				.stream()
				.map(Supplier::get)
				.map(Identifiable::identifier)
				.forEach(LOGGER::info);
	}
}
