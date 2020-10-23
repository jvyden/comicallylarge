package exposed.jvyden.comicallylarge.items;

import com.mojang.realmsclient.gui.ChatFormatting;
import exposed.jvyden.comicallylarge.ItemHandler;
import exposed.jvyden.comicallylarge.entities.EntityIceCream;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class SpoonfulItem extends SpoonItem {
    public SpoonfulItem(String name) {
        super(name);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(ChatFormatting.DARK_PURPLE + I18n.format("lore.spoonful"));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.7F / (itemRand.nextFloat() * 0.7F + 0.8F));

        ItemStack itemStack = player.getHeldItem(hand);
        if (!world.isRemote) {
            EntityIceCream entityIceCream = new EntityIceCream(world, player);
            entityIceCream.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 3F, 0.5F);
            world.spawnEntity(entityIceCream);
        }

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStack);
    }
}
