package me.jacobcrofts.simplestructureloader;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.json.simple.JSONObject;

public class SavedBlock {

	private final Material type;
	private final byte data;
	private final int relativeX;
	private final int relativeY;
	private final int relativeZ;
	
	@SuppressWarnings("deprecation")
	public SavedBlock(Location baseLocation, Block block) {
		this.type = block.getType();
		this.data = block.getData();
		Location relativeLocation = block.getLocation().subtract(baseLocation);
		this.relativeX = relativeLocation.getBlockX();
		this.relativeY = relativeLocation.getBlockY();
		this.relativeZ = relativeLocation.getBlockZ();
	}
	
	public SavedBlock(JSONObject savedBlockData) {
		this.type = Material.getMaterial((String) savedBlockData.get("type"));
		this.data = ((Long) savedBlockData.get("data")).byteValue();
		this.relativeX = ((Long) savedBlockData.get("relative-x")).intValue();
		this.relativeY = ((Long) savedBlockData.get("relative-y")).intValue();
		this.relativeZ = ((Long) savedBlockData.get("relative-z")).intValue();
	}
	
	public Material getType() {
		return this.type;
	}
	
	public byte getData() {
		return this.data;
	}
	
	public int getRelativeX() {
		return this.relativeX;
	}
	
	public int getRelativeY() {
		return this.relativeY;
	}
	
	public int getRelativeZ() {
		return this.relativeZ;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject toJSON() {
		JSONObject savedBlockData = new JSONObject();
		savedBlockData.put("type", this.type.toString());
		savedBlockData.put("data", this.data);
		savedBlockData.put("relative-x", this.relativeX);
		savedBlockData.put("relative-y", this.relativeY);
		savedBlockData.put("relative-z", this.relativeZ);
		return savedBlockData;
	}
	
}
