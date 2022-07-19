/*
 * Decompiled with CFR 0.152.
 */
package i.gishreloaded.deadcode.ui.theme;

import i.gishreloaded.deadcode.ui.ComponentRenderer;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import i.gishreloaded.deadcode.ui.components.ComponentBind;
import i.gishreloaded.deadcode.ui.components.ComponentColorPicker;
import i.gishreloaded.deadcode.ui.components.ComponentComboBox;
import i.gishreloaded.deadcode.ui.components.ComponentModuleSwitcher;
import i.gishreloaded.deadcode.ui.components.ComponentPointSelector;
import i.gishreloaded.deadcode.ui.components.ComponentSlider;
import java.util.HashMap;

public class Theme {
    public HashMap rendererHashMap = new HashMap();

    public Theme() {
        this.addComponentRenderer(ComponentType.a, new bd(this));
        this.addComponentRenderer(ComponentType.c, new dx_0(this));
        this.addComponentRenderer(ComponentType.d, new k(this));
        this.addComponentRenderer(ComponentType.e, new bf(this));
        this.addComponentRenderer(ComponentType.b, new da(this));
        this.addComponentRenderer(ComponentType.f, new ez(this));
        this.addComponentRenderer(ComponentType.g, new fr(this));
        this.addComponentRenderer(ComponentType.h, new ae_0(this));
        this.addComponentRenderer(ComponentType.i, new dz(this));
        this.addComponentRenderer(ComponentType.j, new dx(this));
        this.addComponentRenderer(ComponentType.n, new eU(this));
        this.addComponentRenderer(ComponentType.o, new aG(this));
        this.addComponentRenderer(ComponentType.l, new j(this));
        this.addComponentRenderer(ComponentType.k, new ae(this));
        this.addComponentRenderer(ComponentType.m, new L(this));
        this.addComponentRenderer(ComponentType.MODULE_SWITCHER, new ComponentModuleSwitcher(this));
        this.addComponentRenderer(ComponentType.COMBO_BOX, new ComponentComboBox(this));
        this.addComponentRenderer(ComponentType.BIND, new ComponentBind(this));
        this.addComponentRenderer(ComponentType.v, new eW(this));
        this.addComponentRenderer(ComponentType.SLIDER, new ComponentSlider(this));
        this.addComponentRenderer(ComponentType.POINT, new ComponentPointSelector(this));
        this.addComponentRenderer(ComponentType.r, new cb_0(this));
        this.addComponentRenderer(ComponentType.COLOR_PICKER, new ComponentColorPicker(this));
    }

    public void addComponentRenderer(ComponentType componentType, ComponentRenderer componentRenderer) {
        this.rendererHashMap.put(componentType, componentRenderer);
    }

    public HashMap getRenderer() {
        return this.rendererHashMap;
    }
}

