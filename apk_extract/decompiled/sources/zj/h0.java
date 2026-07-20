package zj;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 extends s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h0 f11637b = new h0();

    @Override // zj.s
    public final void a(l0 l0Var, Object obj) {
        dj.y part = (dj.y) obj;
        if (part != null) {
            u6.a aVar = l0Var.f11652i;
            aVar.getClass();
            Intrinsics.checkNotNullParameter(part, "part");
            ((ArrayList) aVar.f10380d).add(part);
        }
    }
}
