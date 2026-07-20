package k3;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class d1 {
    public static final int a(bg.c text, bg.h range) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(range, "range");
        int i8 = range.f1324a;
        int i9 = range.f1325b;
        if (i8 < i9 && !CharsKt.isWhitespace(text.charAt(i8))) {
            do {
                i8++;
                if (i8 >= i9) {
                    break;
                }
            } while (!CharsKt.isWhitespace(text.charAt(i8)));
        }
        return i8;
    }

    public static final void b(bg.c text, bg.h range) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(range, "range");
        int i8 = range.f1324a;
        int i9 = range.f1325b;
        if (i8 >= i9 || !CharsKt.isWhitespace(text.charAt(i8))) {
            return;
        }
        do {
            i8++;
            if (i8 >= i9) {
                break;
            }
        } while (CharsKt.isWhitespace(text.charAt(i8)));
        range.f1324a = i8;
    }
}
