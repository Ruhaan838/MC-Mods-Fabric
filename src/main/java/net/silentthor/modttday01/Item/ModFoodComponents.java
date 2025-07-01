package net.silentthor.modttday01.Item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents{
    static StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 200);
    public static final FoodComponent CAULIFLOWER = new FoodComponent.Builder().nutrition(3)
            .saturationModifier(0.25f).statusEffect(effect, 0.5f).build();

}
