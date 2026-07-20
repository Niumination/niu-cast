package androidx.core.util;

import b.a;
import kn.l0;
import lm.t0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class PairKt {
    @a({"UnknownNullness"})
    public static final <F, S> F component1(@l Pair<F, S> pair) {
        l0.p(pair, "<this>");
        return pair.first;
    }

    @a({"UnknownNullness"})
    public static final <F, S> S component2(@l Pair<F, S> pair) {
        l0.p(pair, "<this>");
        return pair.second;
    }

    @l
    public static final <F, S> android.util.Pair<F, S> toAndroidPair(@l t0<? extends F, ? extends S> t0Var) {
        l0.p(t0Var, "<this>");
        return new android.util.Pair<>(t0Var.getFirst(), t0Var.getSecond());
    }

    @l
    public static final <F, S> Pair<F, S> toAndroidXPair(@l t0<? extends F, ? extends S> t0Var) {
        l0.p(t0Var, "<this>");
        return new Pair<>(t0Var.getFirst(), t0Var.getSecond());
    }

    @l
    public static final <F, S> t0<F, S> toKotlinPair(@l Pair<F, S> pair) {
        l0.p(pair, "<this>");
        return new t0<>(pair.first, pair.second);
    }

    @a({"UnknownNullness"})
    public static final <F, S> F component1(@l android.util.Pair<F, S> pair) {
        l0.p(pair, "<this>");
        return (F) pair.first;
    }

    @a({"UnknownNullness"})
    public static final <F, S> S component2(@l android.util.Pair<F, S> pair) {
        l0.p(pair, "<this>");
        return (S) pair.second;
    }

    @l
    public static final <F, S> t0<F, S> toKotlinPair(@l android.util.Pair<F, S> pair) {
        l0.p(pair, "<this>");
        return new t0<>(pair.first, pair.second);
    }
}
