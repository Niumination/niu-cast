package wk;

import lm.a1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f19663a;

    @lm.k(message = "quality property is not used anymore and will be removed", replaceWith = @a1(expression = "RouteSelector()", imports = {}))
    public w(double d10) {
        this.f19663a = d10;
    }

    @lm.k(message = "This property is not used anymore and will be removed")
    public static /* synthetic */ void c() {
    }

    @os.l
    public abstract x a(@os.l j0 j0Var, int i10);

    public final double b() {
        return this.f19663a;
    }

    public w() {
        this(0.0d);
    }
}
