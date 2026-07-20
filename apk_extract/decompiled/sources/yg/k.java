package yg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import m3.w;
import m3.z5;
import xg.c0;
import zf.v;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11207a;

    public k(String requiredProtocol) {
        Intrinsics.checkNotNullParameter(requiredProtocol, "requiredProtocol");
        this.f11207a = requiredProtocol;
    }

    @Override // m3.w
    public final xg.n a(c0 c0Var, int i8) {
        zf.r rVarA = c0Var.f10928b.g().a();
        String[] strArr = v.f11551a;
        String str = rVarA.get("Sec-WebSocket-Protocol");
        if (str == null) {
            r.f11223a.trace("Skipping WebSocket plugin because no Sec-WebSocket-Protocol header provided.");
            return xg.n.f10970c;
        }
        List listA = z5.a(str);
        ArrayList arrayList = new ArrayList(CollectionsKt.i(listA));
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            arrayList.add(((zf.n) it.next()).f11521a);
        }
        String str2 = this.f11207a;
        if (arrayList.contains(str2)) {
            return xg.n.e;
        }
        r.f11223a.trace("Skipping WebSocket plugin because no Sec-WebSocket-Protocol header " + str + " is not matching " + str2 + '.');
        return xg.n.f10970c;
    }
}
