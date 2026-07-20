package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class QuantizerCelebi {
    private QuantizerCelebi() {
    }

    public static Map<Integer, Integer> quantize(int[] iArr, int i8) {
        Set<Integer> setKeySet = new QuantizerWu().quantize(iArr, i8).colorToCount.keySet();
        int[] iArr2 = new int[setKeySet.size()];
        Iterator<Integer> it = setKeySet.iterator();
        int i9 = 0;
        while (it.hasNext()) {
            iArr2[i9] = it.next().intValue();
            i9++;
        }
        return QuantizerWsmeans.quantize(iArr, iArr2, i8);
    }
}
