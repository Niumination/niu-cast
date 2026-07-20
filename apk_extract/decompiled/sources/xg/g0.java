package xg;

import af.t1;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f10947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t1 f10948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h0 f10949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f0 f10950d;
    public final ArrayList e;

    public g0(mg.r call, List segments) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(segments, "segments");
        this.f10947a = segments;
        this.f10948b = new t1(2);
        this.e = new ArrayList();
    }

    public final void a(h0 item) {
        t1 t1Var = this.f10948b;
        if (t1Var.f594b.isEmpty()) {
            this.f10949c = item;
            return;
        }
        ArrayList arrayList = t1Var.f594b;
        if (arrayList.isEmpty()) {
            throw new NoSuchElementException("Unable to peek an element into empty stack");
        }
        h0 h0Var = (h0) CollectionsKt.last((List) arrayList);
        h0Var.getClass();
        Intrinsics.checkNotNullParameter(item, "item");
        ArrayList arrayList2 = h0Var.f10956d;
        if (arrayList2 == null) {
            arrayList2 = new ArrayList();
            h0Var.f10956d = arrayList2;
        }
        arrayList2.add(item);
    }

    public final void b(u route, int i8, d0 result) {
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(result, "result");
        a(new h0(route, i8, result));
    }

    public final String toString() {
        return "Trace for " + this.f10947a;
    }
}
