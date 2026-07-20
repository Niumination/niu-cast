package hg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.UShort;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f5386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f5387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f5388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f5389d;

    public x0(f1 version, byte[] serverSeed, byte[] sessionId, short s2, List extensions) throws p0 {
        Object next;
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(serverSeed, "serverSeed");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(extensions, "extensions");
        this.f5386a = serverSeed;
        this.f5387b = extensions;
        Iterator it = a.f5333a.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((c) next).f5334a != s2);
        c cVar = (c) next;
        if (cVar == null) {
            throw new IllegalStateException(("Server cipher suite is not supported: " + ((int) s2)).toString());
        }
        this.f5388c = cVar;
        ArrayList arrayList = new ArrayList();
        for (jg.l lVar : this.f5387b) {
            if (w0.$EnumSwitchMapping$0[lVar.f6278a.ordinal()] == 1) {
                List list = jg.k.f6277a;
                wi.a aVar = lVar.f6279b;
                Intrinsics.checkNotNullParameter(aVar, "<this>");
                int iA = aVar.a() & UShort.MAX_VALUE;
                ArrayList arrayList2 = new ArrayList();
                while (lh.a.e(aVar) > 0) {
                    Intrinsics.checkNotNullParameter(aVar, "<this>");
                    jg.c cVarA = jg.k.a(aVar.readByte(), aVar.readByte());
                    if (cVarA != null) {
                        arrayList2.add(cVarA);
                    }
                }
                if (((int) lh.a.e(aVar)) != iA) {
                    StringBuilder sbU = a1.a.u(iA, "Invalid hash and sign packet size: expected ", ", actual ");
                    sbU.append(arrayList2.size());
                    throw new p0(sbU.toString(), null, 2, null);
                }
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, arrayList2);
            }
        }
        this.f5389d = arrayList;
    }
}
