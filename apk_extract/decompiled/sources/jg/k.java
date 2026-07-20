package jg;

import hg.p0;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f6277a;

    static {
        b bVar = b.SHA384;
        j jVar = j.ECDSA;
        hg.i iVar = hg.i.f5361b;
        c cVar = new c(bVar, jVar, hg.i.f5361b);
        b bVar2 = b.SHA256;
        c cVar2 = new c(bVar2, jVar, hg.i.f5362c);
        b bVar3 = b.SHA512;
        j jVar2 = j.RSA;
        f6277a = CollectionsKt.listOf((Object[]) new c[]{cVar, cVar2, new c(bVar3, jVar2, hg.i.f5363d), new c(bVar, jVar2, hg.i.e), new c(bVar2, jVar2, hg.i.f), new c(b.SHA1, jVar2, hg.i.f5364g)});
    }

    public static final c a(byte b9, byte b10) throws p0 {
        Object next;
        b next2;
        j next3;
        Intrinsics.checkNotNullParameter(c.e, "<this>");
        if (b10 == j.ANON.getCode()) {
            throw new IllegalStateException("Anonymous signature not allowed.");
        }
        Iterator it = f6277a.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            c cVar = (c) next;
            if (cVar.f6271a.getCode() == b9 && cVar.f6272b.getCode() == b10) {
                break;
            }
        }
        c cVar2 = (c) next;
        if (cVar2 != null) {
            return cVar2;
        }
        b.Companion.getClass();
        Iterator<b> it2 = b.getEntries().iterator();
        do {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
        } while (next2.getCode() != b9);
        b bVar = next2;
        if (bVar == null) {
            throw new p0(a1.a.o(b9, "Unknown hash algorithm: "), null, 2, null);
        }
        j.Companion.getClass();
        Iterator<j> it3 = j.getEntries().iterator();
        do {
            if (!it3.hasNext()) {
                next3 = null;
                break;
            }
            next3 = it3.next();
        } while (next3.getCode() != b10);
        j jVar = next3;
        return jVar != null ? new c(bVar, jVar, null) : null;
    }
}
