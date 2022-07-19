/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.GuiTextField
 *  net.minecraft.client.gui.achievement.GuiStats
 *  net.minecraft.client.gui.inventory.CreativeCrafting
 *  net.minecraft.client.gui.inventory.GuiInventory
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.InventoryEffectRenderer
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.resources.I18n
 *  net.minecraft.client.settings.CreativeSettings
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraft.client.settings.HotbarSnapshot
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.client.util.ITooltipFlag$TooltipFlags
 *  net.minecraft.client.util.SearchTreeManager
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.inventory.Container
 *  net.minecraft.inventory.IContainerListener
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.InventoryBasic
 *  net.minecraft.inventory.Slot
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentTranslation
 *  net.minecraft.util.text.TextFormatting
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 */
package i.gishreloaded.deadcode.excluded;

import com.google.common.collect.Lists;
import excluded.m;
import excluded.s;
import i.gishreloaded.deadcode.managers.HackManager;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.achievement.GuiStats;
import net.minecraft.client.gui.inventory.CreativeCrafting;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.CreativeSettings;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.HotbarSnapshot;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.SearchTreeManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class GuiContainerCreative
extends InventoryEffectRenderer {
    private final ResourceLocation CREATIVE_INVENTORY_TABS = new ResourceLocation("textures/gui/container/creative_inventory/tabs.png");
    private static final InventoryBasic basicInventory = new InventoryBasic("tmp", true, 45);
    private int selectedTabIndex = CreativeTabs.BUILDING_BLOCKS.getIndex();
    private float currentScroll;
    private boolean isScrolling;
    private boolean wasClicking;
    private GuiTextField searchField;
    private List originalSlots;
    private Slot destroyItemSlot;
    private boolean clearSearch;
    private CreativeCrafting listener;
    private static int tabPage = 0;
    private int maxPages = 0;

    public GuiContainerCreative(EntityPlayer entityPlayer) {
        super((Container)new m(entityPlayer));
        entityPlayer.openContainer = this.inventorySlots;
        this.allowUserInput = true;
        this.ySize = 136;
        this.xSize = 195;
    }

    public void a() {
    }

    protected void handleMouseClick(Slot slot, int n2, int n3, ClickType clickType) {
        this.clearSearch = true;
        boolean bl = clickType == ClickType.QUICK_MOVE;
        ClickType clickType2 = clickType = n2 == -999 && clickType == ClickType.PICKUP ? ClickType.THROW : clickType;
        if (slot == null && this.selectedTabIndex != CreativeTabs.INVENTORY.getIndex() && clickType != ClickType.QUICK_CRAFT) {
            InventoryPlayer inventoryPlayer = this.mc.player.inventory;
            if (!inventoryPlayer.getItemStack().isEmpty()) {
                if (n3 == 0) {
                    this.mc.player.dropItem(inventoryPlayer.getItemStack(), true);
                    this.mc.playerController.sendPacketDropItem(inventoryPlayer.getItemStack());
                    inventoryPlayer.setItemStack(ItemStack.EMPTY);
                }
                if (n3 == 1) {
                    ItemStack itemStack = inventoryPlayer.getItemStack().splitStack(1);
                    this.mc.player.dropItem(itemStack, true);
                    this.mc.playerController.sendPacketDropItem(itemStack);
                }
            }
        } else {
            if (slot != null && !slot.canTakeStack((EntityPlayer)this.mc.player)) {
                return;
            }
            if (slot == this.destroyItemSlot && bl) {
                for (int i2 = 0; i2 < this.mc.player.inventoryContainer.getInventory().size(); ++i2) {
                    this.mc.playerController.sendSlotPacket(ItemStack.EMPTY, i2);
                }
            } else if (this.selectedTabIndex == CreativeTabs.INVENTORY.getIndex()) {
                if (slot == this.destroyItemSlot) {
                    this.mc.player.inventory.setItemStack(ItemStack.EMPTY);
                } else if (clickType == ClickType.THROW && slot != null && slot.getHasStack()) {
                    ItemStack itemStack = slot.decrStackSize(n3 == 0 ? 1 : slot.getStack().getMaxStackSize());
                    ItemStack itemStack2 = slot.getStack();
                    this.mc.player.dropItem(itemStack, true);
                    this.mc.playerController.sendPacketDropItem(itemStack);
                    this.mc.playerController.sendSlotPacket(itemStack2, s.a((s)((s)slot)).slotNumber);
                } else if (clickType == ClickType.THROW && !this.mc.player.inventory.getItemStack().isEmpty()) {
                    this.mc.player.dropItem(this.mc.player.inventory.getItemStack(), true);
                    this.mc.playerController.sendPacketDropItem(this.mc.player.inventory.getItemStack());
                    this.mc.player.inventory.setItemStack(ItemStack.EMPTY);
                } else {
                    this.mc.player.inventoryContainer.slotClick(slot == null ? n2 : s.a((s)((s)slot)).slotNumber, n3, clickType, (EntityPlayer)this.mc.player);
                    this.mc.player.inventoryContainer.detectAndSendChanges();
                }
            } else if (clickType != ClickType.QUICK_CRAFT && slot.inventory == basicInventory) {
                InventoryPlayer inventoryPlayer = this.mc.player.inventory;
                ItemStack itemStack = inventoryPlayer.getItemStack();
                ItemStack itemStack3 = slot.getStack();
                if (clickType == ClickType.SWAP) {
                    if (!itemStack3.isEmpty() && n3 >= 0 && n3 < 9) {
                        ItemStack itemStack4 = itemStack3.copy();
                        itemStack4.setCount(itemStack4.getMaxStackSize());
                        this.mc.player.inventory.setInventorySlotContents(n3, itemStack4);
                        this.mc.player.inventoryContainer.detectAndSendChanges();
                    }
                    return;
                }
                if (clickType == ClickType.CLONE) {
                    if (inventoryPlayer.getItemStack().isEmpty() && slot.getHasStack()) {
                        ItemStack itemStack5 = slot.getStack().copy();
                        itemStack5.setCount(itemStack5.getMaxStackSize());
                        inventoryPlayer.setItemStack(itemStack5);
                    }
                    return;
                }
                if (clickType == ClickType.THROW) {
                    if (!itemStack3.isEmpty()) {
                        ItemStack itemStack6 = itemStack3.copy();
                        itemStack6.setCount(n3 == 0 ? 1 : itemStack6.getMaxStackSize());
                        this.mc.player.dropItem(itemStack6, true);
                        this.mc.playerController.sendPacketDropItem(itemStack6);
                    }
                    return;
                }
                if (!itemStack.isEmpty() && !itemStack3.isEmpty() && itemStack.isItemEqual(itemStack3) && ItemStack.areItemStackTagsEqual((ItemStack)itemStack, (ItemStack)itemStack3)) {
                    if (n3 == 0) {
                        if (bl) {
                            itemStack.setCount(itemStack.getMaxStackSize());
                        } else if (itemStack.getCount() < itemStack.getMaxStackSize()) {
                            itemStack.grow(1);
                        }
                    } else {
                        itemStack.shrink(1);
                    }
                } else if (!itemStack3.isEmpty() && itemStack.isEmpty()) {
                    inventoryPlayer.setItemStack(itemStack3.copy());
                    itemStack = inventoryPlayer.getItemStack();
                    if (bl) {
                        itemStack.setCount(itemStack.getMaxStackSize());
                    }
                } else if (n3 == 0) {
                    inventoryPlayer.setItemStack(ItemStack.EMPTY);
                } else {
                    inventoryPlayer.getItemStack().shrink(1);
                }
            } else if (this.inventorySlots != null) {
                ItemStack itemStack = slot == null ? ItemStack.EMPTY : this.inventorySlots.getSlot(slot.slotNumber).getStack();
                this.inventorySlots.slotClick(slot == null ? n2 : slot.slotNumber, n3, clickType, (EntityPlayer)this.mc.player);
                if (Container.getDragEvent((int)n3) == 2) {
                    for (int i3 = 0; i3 < 9; ++i3) {
                        this.mc.playerController.sendSlotPacket(this.inventorySlots.getSlot(45 + i3).getStack(), 36 + i3);
                    }
                } else if (slot != null) {
                    ItemStack itemStack7 = this.inventorySlots.getSlot(slot.slotNumber).getStack();
                    this.mc.playerController.sendSlotPacket(itemStack7, slot.slotNumber - this.inventorySlots.inventorySlots.size() + 9 + 36);
                    int n4 = 45 + n3;
                    if (clickType == ClickType.SWAP) {
                        this.mc.playerController.sendSlotPacket(itemStack, n4 - this.inventorySlots.inventorySlots.size() + 9 + 36);
                    } else if (clickType == ClickType.THROW && !itemStack.isEmpty()) {
                        ItemStack itemStack8 = itemStack.copy();
                        itemStack8.setCount(n3 == 0 ? 1 : itemStack8.getMaxStackSize());
                        this.mc.player.dropItem(itemStack8, true);
                        this.mc.playerController.sendPacketDropItem(itemStack8);
                    }
                    this.mc.player.inventoryContainer.detectAndSendChanges();
                }
            }
        }
    }

    protected void updateActivePotionEffects() {
        int n2 = this.guiLeft;
        super.updateActivePotionEffects();
        if (this.searchField != null && this.guiLeft != n2) {
            this.searchField.x = this.guiLeft + 82;
        }
    }

    public void initGui() {
        super.initGui();
        this.buttonList.clear();
        Keyboard.enableRepeatEvents((boolean)true);
        this.searchField = new GuiTextField(0, this.fontRenderer, this.guiLeft + 82, this.guiTop + 6, 80, this.fontRenderer.FONT_HEIGHT);
        this.searchField.setMaxStringLength(50);
        this.searchField.setEnableBackgroundDrawing(false);
        this.searchField.setVisible(false);
        this.searchField.setTextColor(0xFFFFFF);
        int n2 = this.selectedTabIndex;
        this.selectedTabIndex = -1;
        this.setCurrentCreativeTab(CreativeTabs.CREATIVE_TAB_ARRAY[n2]);
        this.listener = new CreativeCrafting(this.mc);
        this.mc.player.inventoryContainer.addListener((IContainerListener)this.listener);
        int n3 = CreativeTabs.CREATIVE_TAB_ARRAY.length;
        if (n3 > 12) {
            this.buttonList.add(new GuiButton(101, this.guiLeft, this.guiTop - 50, 20, 20, "<"));
            this.buttonList.add(new GuiButton(102, this.guiLeft + this.xSize - 20, this.guiTop - 50, 20, 20, ">"));
            this.maxPages = (int)Math.ceil((double)(n3 - 12) / 10.0);
        }
    }

    public void onGuiClosed() {
        super.onGuiClosed();
        if (this.mc.player != null && this.mc.player.inventory != null) {
            this.mc.player.inventoryContainer.removeListener((IContainerListener)this.listener);
        }
        Keyboard.enableRepeatEvents((boolean)false);
    }

    protected void keyTyped(char c, int n2) {
        if (!CreativeTabs.CREATIVE_TAB_ARRAY[this.selectedTabIndex].hasSearchBar()) {
            if (GameSettings.isKeyDown((KeyBinding)this.mc.gameSettings.keyBindChat)) {
                this.setCurrentCreativeTab(CreativeTabs.SEARCH);
            } else {
                super.keyTyped(c, n2);
            }
        } else {
            if (this.clearSearch) {
                this.clearSearch = false;
                this.searchField.setText("");
            }
            if (!this.checkHotbarKeys(n2)) {
                if (this.searchField.textboxKeyTyped(c, n2)) {
                    this.updateCreativeSearch();
                } else {
                    super.keyTyped(c, n2);
                }
            }
        }
    }

    private /* synthetic */ void updateCreativeSearch() {
        m m2 = (m)this.inventorySlots;
        m2.a.clear();
        CreativeTabs creativeTabs = CreativeTabs.CREATIVE_TAB_ARRAY[this.selectedTabIndex];
        if (creativeTabs.hasSearchBar() && creativeTabs != CreativeTabs.SEARCH) {
            creativeTabs.displayAllRelevantItems(m2.a);
            if (!this.searchField.getText().isEmpty()) {
                String string = this.searchField.getText().toLowerCase(Locale.ROOT);
                Iterator iterator = m2.a.iterator();
                while (iterator.hasNext()) {
                    ItemStack itemStack = (ItemStack)iterator.next();
                    boolean bl = false;
                    for (String string2 : itemStack.getTooltip((EntityPlayer)this.mc.player, (ITooltipFlag)(this.mc.gameSettings.advancedItemTooltips ? ITooltipFlag.TooltipFlags.ADVANCED : ITooltipFlag.TooltipFlags.NORMAL))) {
                        if (!TextFormatting.getTextWithoutFormattingCodes((String)string2).toLowerCase(Locale.ROOT).contains(string)) continue;
                        bl = true;
                        break;
                    }
                    if (bl) continue;
                    iterator.remove();
                }
            }
            this.currentScroll = 0.0f;
            m2.a(0.0f);
            return;
        }
        if (this.searchField.getText().isEmpty()) {
            for (Item item : Item.REGISTRY) {
                item.getSubItems(CreativeTabs.SEARCH, m2.a);
            }
        } else {
            m2.a.addAll((Collection)this.mc.getSearchTree(SearchTreeManager.ITEMS).search(this.searchField.getText().toLowerCase(Locale.ROOT)));
        }
        this.currentScroll = 0.0f;
        m2.a(0.0f);
    }

    protected void drawGuiContainerForegroundLayer(int n2, int n3) {
        CreativeTabs creativeTabs = CreativeTabs.CREATIVE_TAB_ARRAY[this.selectedTabIndex];
        if (creativeTabs != null && creativeTabs.drawInForegroundOfTab()) {
            GlStateManager.disableBlend();
            this.fontRenderer.drawString(I18n.format((String)creativeTabs.getTranslationKey(), (Object[])new Object[0]), 8, 6, creativeTabs.getLabelColor());
        }
    }

    protected void a(int n2, int n3, int n4) {
        if (n4 == 0) {
            int n5 = n2 - this.guiLeft;
            int n6 = n3 - this.guiTop;
            for (CreativeTabs creativeTabs : CreativeTabs.CREATIVE_TAB_ARRAY) {
                if (!this.isMouseOverTab(creativeTabs, n5, n6)) continue;
                return;
            }
        }
        super.mouseClicked(n2, n3, n4);
    }

    protected void mouseClicked(int n2, int n3, int n4) {
        if (n4 == 0) {
            int n5 = n2 - this.guiLeft;
            int n6 = n3 - this.guiTop;
            for (CreativeTabs creativeTabs : CreativeTabs.CREATIVE_TAB_ARRAY) {
                if (creativeTabs == null || !this.isMouseOverTab(creativeTabs, n5, n6)) continue;
                this.setCurrentCreativeTab(creativeTabs);
                return;
            }
        }
        super.mouseReleased(n2, n3, n4);
    }

    private /* synthetic */ boolean needsScrollBars() {
        if (CreativeTabs.CREATIVE_TAB_ARRAY[this.selectedTabIndex] == null) {
            return false;
        }
        return this.selectedTabIndex != CreativeTabs.INVENTORY.getIndex() && CreativeTabs.CREATIVE_TAB_ARRAY[this.selectedTabIndex].hasScrollbar() && ((m)this.inventorySlots).a();
    }

    private /* synthetic */ void setCurrentCreativeTab(CreativeTabs creativeTabs) {
        if (creativeTabs == null) {
            return;
        }
        int n2 = this.selectedTabIndex;
        this.selectedTabIndex = creativeTabs.getIndex();
        m m2 = (m)this.inventorySlots;
        this.dragSplittingSlots.clear();
        m2.a.clear();
        if (creativeTabs == CreativeTabs.HOTBAR) {
            for (int i2 = 0; i2 < 9; ++i2) {
                HotbarSnapshot hotbarSnapshot = this.mc.creativeSettings.getHotbarSnapshot(i2);
                if (hotbarSnapshot.isEmpty()) {
                    for (int i3 = 0; i3 < 9; ++i3) {
                        if (i3 == i2) {
                            ItemStack itemStack = new ItemStack(Items.PAPER);
                            itemStack.getOrCreateSubCompound("CustomCreativeLock");
                            String string = GameSettings.getKeyDisplayString((int)this.mc.gameSettings.keyBindsHotbar[i2].getKeyCode());
                            String string2 = GameSettings.getKeyDisplayString((int)this.mc.gameSettings.keyBindSaveToolbar.getKeyCode());
                            itemStack.setStackDisplayName(new TextComponentTranslation("inventory.hotbarInfo", new Object[]{string2, string}).getUnformattedText());
                            m2.a.add((Object)itemStack);
                            continue;
                        }
                        m2.a.add((Object)ItemStack.EMPTY);
                    }
                    continue;
                }
                m2.a.addAll((Collection)hotbarSnapshot);
            }
        } else if (creativeTabs != CreativeTabs.SEARCH) {
            creativeTabs.displayAllRelevantItems(m2.a);
        }
        if (creativeTabs == CreativeTabs.INVENTORY) {
            Container container = this.mc.player.inventoryContainer;
            if (this.originalSlots == null) {
                this.originalSlots = m2.inventorySlots;
            }
            m2.inventorySlots = Lists.newArrayList();
            for (int i4 = 0; i4 < container.inventorySlots.size(); ++i4) {
                int n3;
                int n4;
                int n5;
                s s2 = new s(this, (Slot)container.inventorySlots.get(i4), i4);
                m2.inventorySlots.add(s2);
                if (i4 >= 5 && i4 < 9) {
                    n5 = i4 - 5;
                    n4 = n5 / 2;
                    n3 = n5 % 2;
                    s2.xPos = 54 + n4 * 54;
                    s2.yPos = 6 + n3 * 27;
                    continue;
                }
                if (i4 >= 0 && i4 < 5) {
                    s2.xPos = -2000;
                    s2.yPos = -2000;
                    continue;
                }
                if (i4 == 45) {
                    s2.xPos = 35;
                    s2.yPos = 20;
                    continue;
                }
                if (i4 >= container.inventorySlots.size()) continue;
                n5 = i4 - 9;
                n4 = n5 % 9;
                n3 = n5 / 9;
                s2.xPos = 9 + n4 * 18;
                s2.yPos = i4 >= 36 ? 112 : 54 + n3 * 18;
            }
            this.destroyItemSlot = new Slot((IInventory)basicInventory, 0, 173, 112);
            m2.inventorySlots.add(this.destroyItemSlot);
        } else if (n2 == CreativeTabs.INVENTORY.getIndex()) {
            m2.inventorySlots = this.originalSlots;
            this.originalSlots = null;
        }
        if (this.searchField != null) {
            if (creativeTabs.hasSearchBar()) {
                this.searchField.setVisible(true);
                this.searchField.setCanLoseFocus(false);
                this.searchField.setFocused(true);
                this.searchField.setText("");
                this.searchField.width = creativeTabs.getSearchbarWidth();
                this.searchField.x = this.guiLeft + 171 - this.searchField.width;
                this.updateCreativeSearch();
            } else {
                this.searchField.setVisible(false);
                this.searchField.setCanLoseFocus(true);
                this.searchField.setFocused(false);
            }
        }
        this.currentScroll = 0.0f;
        m2.a(0.0f);
    }

    public void handleMouseInput() {
        super.handleMouseInput();
        int n2 = Mouse.getEventDWheel();
        if (n2 != 0 && this.needsScrollBars()) {
            int n3 = (((m)this.inventorySlots).a.size() + 9 - 1) / 9 - 5;
            if (n2 > 0) {
                n2 = 1;
            }
            if (n2 < 0) {
                n2 = -1;
            }
            this.currentScroll = (float)((double)this.currentScroll - (double)n2 / (double)n3);
            this.currentScroll = MathHelper.clamp((float)this.currentScroll, (float)0.0f, (float)1.0f);
            ((m)this.inventorySlots).a(this.currentScroll);
        }
    }

    public void drawScreen(int n2, int n3, float f2) {
        this.drawDefaultBackground();
        boolean bl = Mouse.isButtonDown((int)0);
        int n4 = this.guiLeft;
        int n5 = this.guiTop;
        int n6 = n4 + 175;
        int n7 = n5 + 18;
        int n8 = n6 + 14;
        int n9 = n7 + 112;
        if (!this.wasClicking && bl && n2 >= n6 && n3 >= n7 && n2 < n8 && n3 < n9) {
            this.isScrolling = this.needsScrollBars();
        }
        if (!bl) {
            this.isScrolling = false;
        }
        this.wasClicking = bl;
        if (this.isScrolling) {
            this.currentScroll = ((float)(n3 - n7) - 7.5f) / ((float)(n9 - n7) - 15.0f);
            this.currentScroll = MathHelper.clamp((float)this.currentScroll, (float)0.0f, (float)1.0f);
            ((m)this.inventorySlots).a(this.currentScroll);
        }
        super.drawScreen(n2, n3, f2);
        int n10 = tabPage * 10;
        int n11 = Math.min(CreativeTabs.CREATIVE_TAB_ARRAY.length, (tabPage + 1) * 10 + 2);
        if (tabPage != 0) {
            n10 += 2;
        }
        boolean bl2 = false;
        for (CreativeTabs creativeTabs : Arrays.copyOfRange(CreativeTabs.CREATIVE_TAB_ARRAY, n10, n11)) {
            if (creativeTabs == null || !this.renderCreativeInventoryHoveringText(creativeTabs, n2, n3)) continue;
            bl2 = true;
            break;
        }
        if (!bl2 && !this.renderCreativeInventoryHoveringText(CreativeTabs.SEARCH, n2, n3)) {
            this.renderCreativeInventoryHoveringText(CreativeTabs.INVENTORY, n2, n3);
        }
        if (this.destroyItemSlot != null && this.selectedTabIndex == CreativeTabs.INVENTORY.getIndex() && this.isPointInRegion(this.destroyItemSlot.xPos, this.destroyItemSlot.yPos, 16, 16, n2, n3)) {
            this.drawHoveringText(I18n.format((String)"inventory.binSlot", (Object[])new Object[0]), n2, n3);
        }
        if (this.maxPages != 0) {
            String string = String.format("%d / %d", tabPage + 1, this.maxPages + 1);
            int n12 = this.fontRenderer.getStringWidth(string);
            GlStateManager.disableLighting();
            this.zLevel = 300.0f;
            this.itemRender.zLevel = 300.0f;
            this.fontRenderer.drawString(string, this.guiLeft + this.xSize / 2 - n12 / 2, this.guiTop - 44, -1);
            this.zLevel = 0.0f;
            this.itemRender.zLevel = 0.0f;
        }
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.disableLighting();
        if (HackManager.getHack("FakeCreative").isToggledBooleanValue("ShowItemsID")) {
            this.renderCustomHoveredToolTip(n2, n3);
        } else {
            this.renderHoveredToolTip(n2, n3);
        }
    }

    private /* synthetic */ void renderCustomHoveredToolTip(int n2, int n3) {
        if (this.mc.player.inventory.getItemStack().isEmpty() && this.getSlotUnderMouse() != null && this.getSlotUnderMouse().getHasStack()) {
            ItemStack itemStack = this.getSlotUnderMouse().getStack();
            List list = this.getItemToolTip(itemStack);
            list.add(0, Item.getIdFromItem((Item)itemStack.getItem()) + ":" + itemStack.getItem().getMetadata(itemStack));
            this.drawHoveringText(list, n2, n3);
        }
    }

    protected void drawGuiContainerBackgroundLayer(float f2, int n2, int n3) {
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderHelper.enableGUIStandardItemLighting();
        CreativeTabs creativeTabs = CreativeTabs.CREATIVE_TAB_ARRAY[this.selectedTabIndex];
        int n4 = tabPage * 10;
        int n5 = Math.min(CreativeTabs.CREATIVE_TAB_ARRAY.length, (tabPage + 1) * 10 + 2);
        if (tabPage != 0) {
            n4 += 2;
        }
        for (CreativeTabs creativeTabs2 : Arrays.copyOfRange(CreativeTabs.CREATIVE_TAB_ARRAY, n4, n5)) {
            this.mc.getTextureManager().bindTexture(this.CREATIVE_INVENTORY_TABS);
            if (creativeTabs2 == null || creativeTabs2.getIndex() == this.selectedTabIndex) continue;
            this.drawTab(creativeTabs2);
        }
        if (tabPage != 0) {
            if (creativeTabs != CreativeTabs.SEARCH) {
                this.mc.getTextureManager().bindTexture(this.CREATIVE_INVENTORY_TABS);
                this.drawTab(CreativeTabs.SEARCH);
            }
            if (creativeTabs != CreativeTabs.INVENTORY) {
                this.mc.getTextureManager().bindTexture(this.CREATIVE_INVENTORY_TABS);
                this.drawTab(CreativeTabs.INVENTORY);
            }
        }
        this.mc.getTextureManager().bindTexture(creativeTabs.getBackgroundImage());
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        this.searchField.drawTextBox();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        int n6 = this.guiLeft + 175;
        int n7 = this.guiTop + 18;
        int n8 = n7 + 112;
        this.mc.getTextureManager().bindTexture(this.CREATIVE_INVENTORY_TABS);
        if (creativeTabs.hasScrollbar()) {
            this.drawTexturedModalRect(n6, n7 + (int)((float)(n8 - n7 - 17) * this.currentScroll), 232 + (this.needsScrollBars() ? 0 : 12), 0, 12, 15);
        }
        if ((creativeTabs == null || creativeTabs.getTabPage() != tabPage) && creativeTabs != CreativeTabs.SEARCH && creativeTabs != CreativeTabs.INVENTORY) {
            return;
        }
        this.drawTab(creativeTabs);
        if (creativeTabs == CreativeTabs.INVENTORY) {
            GuiInventory.drawEntityOnScreen((int)(this.guiLeft + 88), (int)(this.guiTop + 45), (int)20, (float)(this.guiLeft + 88 - n2), (float)(this.guiTop + 45 - 30 - n3), (EntityLivingBase)this.mc.player);
        }
    }

    protected boolean isMouseOverTab(CreativeTabs creativeTabs, int n2, int n3) {
        if (creativeTabs.getTabPage() != tabPage && creativeTabs != CreativeTabs.SEARCH && creativeTabs != CreativeTabs.INVENTORY) {
            return false;
        }
        int n4 = creativeTabs.getColumn();
        int n5 = 28 * n4;
        int n6 = 0;
        if (creativeTabs.isAlignedRight()) {
            n5 = this.xSize - 28 * (6 - n4) + 2;
        } else if (n4 > 0) {
            n5 += n4;
        }
        n6 = creativeTabs.isOnTopRow() ? (n6 -= 32) : (n6 += this.ySize);
        return n2 >= n5 && n2 <= n5 + 28 && n3 >= n6 && n3 <= n6 + 32;
    }

    protected boolean renderCreativeInventoryHoveringText(CreativeTabs creativeTabs, int n2, int n3) {
        int n4 = creativeTabs.getColumn();
        int n5 = 28 * n4;
        int n6 = 0;
        if (creativeTabs.isAlignedRight()) {
            n5 = this.xSize - 28 * (6 - n4) + 2;
        } else if (n4 > 0) {
            n5 += n4;
        }
        n6 = creativeTabs.isOnTopRow() ? (n6 -= 32) : (n6 += this.ySize);
        if (this.isPointInRegion(n5 + 3, n6 + 3, 23, 27, n2, n3)) {
            this.drawHoveringText(I18n.format((String)creativeTabs.getTranslationKey(), (Object[])new Object[0]), n2, n3);
            return true;
        }
        return false;
    }

    protected void drawTab(CreativeTabs creativeTabs) {
        boolean bl = creativeTabs.getIndex() == this.selectedTabIndex;
        boolean bl2 = creativeTabs.isOnTopRow();
        int n2 = creativeTabs.getColumn();
        int n3 = n2 * 28;
        int n4 = 0;
        int n5 = this.guiLeft + 28 * n2;
        int n6 = this.guiTop;
        if (bl) {
            n4 += 32;
        }
        if (creativeTabs.isAlignedRight()) {
            n5 = this.guiLeft + this.xSize - 28 * (6 - n2);
        } else if (n2 > 0) {
            n5 += n2;
        }
        if (bl2) {
            n6 -= 28;
        } else {
            n4 += 64;
            n6 += this.ySize - 4;
        }
        GlStateManager.disableLighting();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.enableBlend();
        this.drawTexturedModalRect(n5, n6, n3, n4, 28, 32);
        this.zLevel = 100.0f;
        this.itemRender.zLevel = 100.0f;
        n6 = n6 + 8 + (bl2 ? 1 : -1);
        GlStateManager.enableLighting();
        GlStateManager.enableRescaleNormal();
        ItemStack itemStack = creativeTabs.getIcon();
        this.itemRender.renderItemAndEffectIntoGUI(itemStack, n5 += 6, n6);
        this.itemRender.renderItemOverlays(this.fontRenderer, itemStack, n5, n6);
        GlStateManager.disableLighting();
        this.itemRender.zLevel = 0.0f;
        this.zLevel = 0.0f;
    }

    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 1) {
            this.mc.displayGuiScreen((GuiScreen)new GuiStats((GuiScreen)this, this.mc.player.getStatFileWriter()));
        }
        if (guiButton.id == 101) {
            tabPage = Math.max(tabPage - 1, 0);
        } else if (guiButton.id == 102) {
            tabPage = Math.min(tabPage + 1, this.maxPages);
        }
    }

    public int getSelectedTabIndex() {
        return this.selectedTabIndex;
    }

    public static void handleHotbarSnapshots(Minecraft minecraft, int n2, boolean bl, boolean bl2) {
        EntityPlayerSP entityPlayerSP = minecraft.player;
        CreativeSettings creativeSettings = minecraft.creativeSettings;
        HotbarSnapshot hotbarSnapshot = creativeSettings.getHotbarSnapshot(n2);
        if (bl) {
            for (int i2 = 0; i2 < InventoryPlayer.getHotbarSize(); ++i2) {
                ItemStack itemStack = ((ItemStack)hotbarSnapshot.get(i2)).copy();
                entityPlayerSP.inventory.setInventorySlotContents(i2, itemStack);
                minecraft.playerController.sendSlotPacket(itemStack, 36 + i2);
            }
            entityPlayerSP.inventoryContainer.detectAndSendChanges();
        } else if (bl2) {
            for (int i3 = 0; i3 < InventoryPlayer.getHotbarSize(); ++i3) {
                hotbarSnapshot.set(i3, (Object)entityPlayerSP.inventory.getStackInSlot(i3).copy());
            }
            String string = GameSettings.getKeyDisplayString((int)minecraft.gameSettings.keyBindsHotbar[n2].getKeyCode());
            String string2 = GameSettings.getKeyDisplayString((int)minecraft.gameSettings.keyBindLoadToolbar.getKeyCode());
            minecraft.ingameGUI.setOverlayMessage((ITextComponent)new TextComponentTranslation("inventory.hotbarSaved", new Object[]{string2, string}), false);
            creativeSettings.write();
        }
    }

    static /* synthetic */ InventoryBasic g() {
        return basicInventory;
    }
}

