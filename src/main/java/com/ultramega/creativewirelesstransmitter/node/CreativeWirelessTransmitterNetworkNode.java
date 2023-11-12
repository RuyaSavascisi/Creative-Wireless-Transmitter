package com.ultramega.creativewirelesstransmitter.node;

import com.ultramega.creativewirelesstransmitter.CreativeWirelessTransmitter;
import com.ultramega.creativewirelesstransmitter.config.CreativeWirelessTransmitterConfig;
import com.refinedmods.refinedstorage.api.network.IWirelessTransmitter;
import com.refinedmods.refinedstorage.apiimpl.network.node.NetworkNode;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.IItemHandler;

public class CreativeWirelessTransmitterNetworkNode extends NetworkNode implements IWirelessTransmitter {
    public static final ResourceLocation ID = new ResourceLocation(CreativeWirelessTransmitter.MOD_ID, "creative_wireless_transmitter");
    
    public CreativeWirelessTransmitterNetworkNode(Level level, BlockPos pos) {
        super(level, pos);
    }

    @Override
    public int getEnergyUsage() {
        return CreativeWirelessTransmitterConfig.CREATIVE_WIRELESS_TRANSMITTER_ENERGY_CONSUME.get();
    }

    @Override
    public ResourceLocation getId() {
        return ID;
    }
    
    @Override
    public int getRange() {
        return Integer.MAX_VALUE;
    }

    @Override
    public BlockPos getOrigin() {
        return pos;
    }

    @Override
    public ResourceKey<Level> getDimension() {
        return level.dimension();
    }

    @Override
    public IItemHandler getDrops() {
        return null;
    }

    @Override
    public boolean canConduct(Direction direction) {
        return getDirection() == direction;
    }

    @Override
    public void visit(Operator operator) {
        operator.apply(level, pos.relative(Direction.DOWN), Direction.UP);
    }
}