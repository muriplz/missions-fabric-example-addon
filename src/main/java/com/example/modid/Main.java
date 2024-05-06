package com.example.modid;

import com.kryeit.missions.MissionTypeRegistry;
import com.example.modid.listener.OnSendChatMessage;
import com.example.modid.missions_types.ExampleMission;
import com.kryeit.votifier.model.VotifierEvent;
import net.fabricmc.api.DedicatedServerModInitializer;

import net.fabricmc.fabric.api.message.v1.ServerMessageEvents;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements DedicatedServerModInitializer {
	public static final String ID = "modid";
	public static final String NAME = "Example Name";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	@Override
	public void onInitializeServer() {

		// It's a "Send X messages in chat" mission
		// Register the mission type
		MissionTypeRegistry.INSTANCE.register(new ExampleMission());

		// Register the event
		ServerMessageEvents.CHAT_MESSAGE.register(new OnSendChatMessage());

		// IMPORTANT: the config.json in the resources folder is just to have it written somewhere,
		// but you need to copy it and paste it in your server's missions.json
	}
}
