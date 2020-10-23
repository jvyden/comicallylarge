package exposed.jvyden.comicallylarge.items;

import exposed.jvyden.comicallylarge.entities.EntityIceCream;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class IceCreamItem extends ItemFood {
    float velocity = 3F;

    public IceCreamItem(String name) {
        super(4, true);
        this.setRegistryName(name);
        this.setTranslationKey(name);
        this.setCreativeTab(CreativeTabs.FOOD);
        this.setMaxStackSize(16);
    }

    public IceCreamItem(String name, float velocity) {
        this(name);
        this.velocity = velocity;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if(!player.isSneaking()) {
            return super.onItemRightClick(world, player, hand); // Only throw if sneaking, otherwise eat
        }
        ItemStack itemStack = player.getHeldItem(hand);
        if (!player.capabilities.isCreativeMode) {
            itemStack.shrink(1); // Consume item if in survival mode
        }

        world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.7F / (itemRand.nextFloat() * 0.7F + 0.8F));

        if (!world.isRemote) {
            EntityIceCream entityIceCream = new EntityIceCream(world, player);
            entityIceCream.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, velocity, 0.5F);
            world.spawnEntity(entityIceCream);
        }

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStack);
    }

    public ModelResourceLocation getModelResourceLocation() {
        return new ModelResourceLocation(this.getRegistryName().toString());
    }
}
