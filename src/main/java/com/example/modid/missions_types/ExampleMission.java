package com.example.modid.missions_types;

import com.kryeit.Missions;
import com.kryeit.missions.MissionDifficulty;
import com.kryeit.missions.MissionManager;
import com.kryeit.missions.MissionType;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.UUID;

public class ExampleMission implements MissionType {
	private static final Identifier IDENTIFIER = Missions.asResource("votes");

	@Override
	public Text description() {
		return Text.literal("Send %s messages in chat");
	}

	public static void handleVote(UUID player) {
		MissionManager.incrementMission(player, ExampleMission.class, IDENTIFIER, 1);
	}

	@Override
	public String id() {
		return "message";
	}

	@Override
	public MissionDifficulty difficulty() {
		return MissionDifficulty.HARD;
	}

	@Override
	public int getProgress(UUID player, Identifier item) {
		return getData(player).getInt("messages");
	}

	@Override
	public void reset(UUID player, Identifier item) {
		getData(player).remove("messages");
	}

	@Override
	public void increment(int amount, Identifier item, NbtCompound data) {
		data.putInt("messages", data.getInt("messages") + 1);
	}

	@Override
	public ItemStack getItemStack(Identifier item) {
		return Items.AIR.getDefaultStack();
	}

	@Override
	public ItemStack getPreviewStack(Identifier item) {
		return Blocks.BAMBOO_SIGN.asItem().getDefaultStack();
	}
}
