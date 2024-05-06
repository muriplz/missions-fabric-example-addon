package com.example.modid.listener;

import com.example.modid.missions_types.ExampleMission;

import net.fabricmc.fabric.api.message.v1.ServerMessageEvents;
import net.minecraft.network.message.MessageType;
import net.minecraft.network.message.SignedMessage;
import net.minecraft.server.network.ServerPlayerEntity;

public class OnSendChatMessage implements ServerMessageEvents.ChatMessage {
	@Override
	public void onChatMessage(SignedMessage message, ServerPlayerEntity sender, MessageType.Parameters params) {
		ExampleMission.handleVote(sender.getUuid());
	}
}
