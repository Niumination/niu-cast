package com.transsion.widgetthemes.drawable;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import com.transsion.widgetsThemes.R$color;
import com.transsion.widgetsThemes.R$dimen;
import com.transsion.widgetthemes.util.Utils;
import java.io.IOException;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class OSShadowDrawable extends ShapeDrawable {
    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.os_popup_menu_bg_margin);
        setPadding(0, dimensionPixelOffset, 0, dimensionPixelOffset);
        float[] fArr = new float[8];
        Arrays.fill(fArr, resources.getDimensionPixelOffset(R$dimen.os_popup_menu_bg_radius));
        setShape(new RoundRectShape(fArr, new RectF(), new float[8]));
        boolean zEqualsIgnoreCase = Utils.mOsType[0].equalsIgnoreCase(Utils.getOsType());
        getPaint().setColor(resources.getColor(R$color.os_altitude_secondary_color, theme));
        getPaint().setShadowLayer(resources.getDimensionPixelOffset(R$dimen.os_shadow_radius_level3), 0.0f, resources.getDimensionPixelOffset(R$dimen.os_shadow_dy_level3), resources.getColor(zEqualsIgnoreCase ? R$color.os_shadow_color_level3_hios : R$color.os_shadow_color_level3_xos, theme));
    }

    public void setDefaultShadow() {
        setPadding(0, 27, 0, 27);
        float[] fArr = new float[8];
        Arrays.fill(fArr, 36.0f);
        setShape(new RoundRectShape(fArr, new RectF(), new float[8]));
        getPaint().setColor(Color.parseColor("#FFFFFF"));
        getPaint().setShadowLayer(48.0f, 0.0f, 24, Color.parseColor("#10000000"));
    }
}
