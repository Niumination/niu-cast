package androidx.core.util;

import android.util.Half;
import androidx.annotation.RequiresApi;
import b.a;
import kn.l0;
import kn.r1;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nHalf.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Half.kt\nandroidx/core/util/HalfKt\n*L\n1#1,60:1\n43#1:61\n*S KotlinDebug\n*F\n+ 1 Half.kt\nandroidx/core/util/HalfKt\n*L\n51#1:61\n*E\n"})
@a({"ClassVerificationFailure"})
public final class HalfKt {
    @RequiresApi(26)
    @l
    public static final Half toHalf(short s10) {
        Half halfValueOf = Half.valueOf(s10);
        l0.o(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }

    @RequiresApi(26)
    @l
    public static final Half toHalf(float f10) {
        Half halfValueOf = Half.valueOf(f10);
        l0.o(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }

    @RequiresApi(26)
    @l
    public static final Half toHalf(@l String str) {
        l0.p(str, "<this>");
        Half halfValueOf = Half.valueOf(str);
        l0.o(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }

    @RequiresApi(26)
    @l
    public static final Half toHalf(double d10) {
        Half halfValueOf = Half.valueOf((float) d10);
        l0.o(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }
}
