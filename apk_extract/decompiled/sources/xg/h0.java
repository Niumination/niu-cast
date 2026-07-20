package xg;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f10953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f0 f10955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f10956d;

    public h0(u route, int i8, f0 f0Var) {
        Intrinsics.checkNotNullParameter(route, "route");
        this.f10953a = route;
        this.f10954b = i8;
        this.f10955c = f0Var;
    }

    public final void a(int i8, StringBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.append(StringsKt__StringsJVMKt.repeat("  ", i8) + this);
        Intrinsics.checkNotNullExpressionValue(builder, "append(...)");
        builder.append('\n');
        Intrinsics.checkNotNullExpressionValue(builder, "append(...)");
        ArrayList arrayList = this.f10956d;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((h0) it.next()).a(i8 + 1, builder);
            }
        }
    }

    public final String toString() {
        return this.f10953a + ", segment:" + this.f10954b + " -> " + this.f10955c;
    }
}
