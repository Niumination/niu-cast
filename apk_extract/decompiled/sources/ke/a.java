package ke;

import android.R;
import android.content.Context;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;
import com.transsion.widgetslistitemlayout.R$attr;
import com.transsion.widgetslistitemlayout.R$color;
import com.transsion.widgetslistitemlayout.R$dimen;
import com.transsion.widgetslistitemlayout.R$drawable;
import pd.e;
import pd.j;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends e {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Path f6843l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RectF f6844m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float[] f6845n;

    public final Drawable b(int i8, int i9, boolean z2, ColorDrawable colorDrawable, boolean z3) {
        InsetDrawable insetDrawable;
        int i10 = R$color.os_press_primary_color;
        Context context = this.f8734a;
        int color = ContextCompat.getColor(context, i10);
        if (i8 == 0) {
            color = 0;
        }
        if (z2) {
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
            shapeDrawable.getPaint().setColor(color);
            if (i9 == 1) {
                insetDrawable = new InsetDrawable((Drawable) shapeDrawable, 0, 0, 0, 0);
            } else if (i9 == 2) {
                insetDrawable = new InsetDrawable((Drawable) shapeDrawable, 0, 0, 0, z3 ? (int) context.getResources().getDimension(R$dimen.os_list_item_bottom_divide_height) : 0);
            } else if (i9 == 3) {
                insetDrawable = new InsetDrawable((Drawable) shapeDrawable, 0, 0, 0, 0);
            } else {
                insetDrawable = new InsetDrawable((Drawable) shapeDrawable, 0, 0, 0, z3 ? (int) context.getResources().getDimension(R$dimen.os_list_item_bottom_divide_height) : 0);
            }
            ContextCompat.getDrawable(context, R$drawable.os_list_item_view_bg_rectangle_normal);
            setDrawableNormal(colorDrawable);
            setDrawablePress(insetDrawable);
        } else {
            new ColorDrawable(j.e(context, R$attr.os_bg_secondary, R$color.os_bg_secondary_hios));
            setDrawableNormal(colorDrawable);
            TypedValue typedValue = new TypedValue();
            setDrawablePress(new LayerDrawable(new Drawable[]{new ColorDrawable(context.getTheme().resolveAttribute(com.transsion.widgetslib.R$attr.OsBgPrimary, typedValue, true) ? context.getColor(typedValue.resourceId) : -1), new ColorDrawable(color)}));
        }
        if (i8 != 2) {
            return getBackground();
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_selected}, new ColorDrawable(ContextCompat.getColor(context, R$color.os_liv_selected)));
        stateListDrawable.addState(new int[0], colorDrawable);
        return stateListDrawable;
    }
}
