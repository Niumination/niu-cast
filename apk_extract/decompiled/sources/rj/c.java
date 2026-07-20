package rj;

import kotlin.jvm.internal.Intrinsics;
import qj.w;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    /* JADX WARN: Code duplicated, block: B:12:0x002e  */
    /* JADX WARN: Code duplicated, block: B:21:? A[RETURN, SYNTHETIC] */
    public static final int a(w wVar, int i8) {
        int i9;
        Intrinsics.checkNotNullParameter(wVar, "<this>");
        int[] directory$okio = wVar.getDirectory$okio();
        int i10 = i8 + 1;
        int length = wVar.getSegments$okio().length;
        Intrinsics.checkNotNullParameter(directory$okio, "<this>");
        int i11 = length - 1;
        int i12 = 0;
        while (i12 <= i11) {
            i9 = (i12 + i11) >>> 1;
            int i13 = directory$okio[i9];
            if (i13 < i10) {
                i12 = i9 + 1;
            } else {
                if (i13 <= i10) {
                    if (i9 >= 0) {
                        return i9;
                    }
                    return ~i9;
                }
                i11 = i9 - 1;
            }
        }
        i9 = (-i12) - 1;
        if (i9 >= 0) {
            return i9;
        }
        return ~i9;
    }
}
