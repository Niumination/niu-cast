package yd;

import android.util.Log;
import androidx.dynamicanimation.animation.FloatPropertyCompat;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends FloatPropertyCompat {
    @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
    public final float getValue(Object obj) {
        return ((j) obj).f11140b;
    }

    @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
    public final void setValue(Object obj, float f) {
        j jVar = (j) obj;
        jVar.getClass();
        jVar.f11140b = (int) f;
        Log.d("OverScroller", "setValue: 卡顿过滤 SPRING_PROPERTY value = " + f);
    }
}
