package h4;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class t implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f5256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ sj.a f5257b;

    public t(sj.a aVar, String str) {
        this.f5257b = aVar;
        this.f5256a = str;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        sj.a aVar = this.f5257b;
        return new s((se.e) aVar.f10138c, aVar, this.f5256a);
    }

    public final String toString() {
        o5.c cVar = new o5.c(", ");
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        cVar.a(sb2, iterator());
        sb2.append(']');
        return sb2.toString();
    }
}
