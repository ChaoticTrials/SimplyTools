package de.melanx.simplytools.compat;

import net.minecraft.world.item.Tier;
import net.neoforged.bus.api.Event;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class RegisterTiersEvent extends Event {

    private final Map<String, Map<String, Tier>> tiersByModid = new HashMap<>();

    /**
     * Used to create the entries for easily creating own aiots.
     *
     * @param modid           The mod id of the mod which is required to use the aiot
     * @param tiersToRegister A map with a {@link String} which defines the material and a {@link Supplier} with a tool tier for the aiot
     */
    public void add(String modid, Map<String, Tier> tiersToRegister) {
        this.tiersByModid.put(modid, Map.copyOf(tiersToRegister));
    }

    protected Map<String, Map<String, Tier>> getTiersByModid() {
        return Map.copyOf(this.tiersByModid);
    }
}
