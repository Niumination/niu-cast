package xg;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public class u extends mg.c implements k {
    public final u q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final m3.w f10989r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ArrayList f10990s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public mg.c f10991t;
    public final ArrayList u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(u uVar, m3.w selector, boolean z2, qg.b environment) {
        super(z2, environment);
        Intrinsics.checkNotNullParameter(selector, "selector");
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.q = uVar;
        this.f10989r = selector;
        this.f10990s = new ArrayList();
        this.u = new ArrayList();
    }

    @Override // hh.e
    public final void a() {
        u();
    }

    public final u s(m3.w selector) {
        Object next;
        Intrinsics.checkNotNullParameter(selector, "selector");
        ArrayList arrayList = this.f10990s;
        Iterator it = arrayList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((u) next).f10989r, selector));
        u uVar = (u) next;
        if (uVar != null) {
            return uVar;
        }
        u uVar2 = new u(this, selector, this.f8054h, this.f8055i);
        arrayList.add(uVar2);
        return uVar2;
    }

    public final void t(Function2 body) {
        Intrinsics.checkNotNullParameter(body, "body");
        this.u.add(body);
        this.f10991t = null;
    }

    public final String toString() {
        StringBuilder sb2;
        u uVar = this.q;
        String string = uVar != null ? uVar.toString() : null;
        m3.w wVar = this.f10989r;
        if (string == null) {
            if (wVar instanceof p0) {
                return "/";
            }
            return "/" + wVar;
        }
        if (wVar instanceof p0) {
            return StringsKt__StringsKt.endsWith$default((CharSequence) string, '/', false, 2, (Object) null) ? string : string.concat("/");
        }
        if (StringsKt__StringsKt.endsWith$default((CharSequence) string, '/', false, 2, (Object) null)) {
            sb2 = new StringBuilder();
            sb2.append(string);
        } else {
            sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append('/');
        }
        sb2.append(wVar);
        return sb2.toString();
    }

    public final void u() {
        this.f10991t = null;
        Iterator it = this.f10990s.iterator();
        while (it.hasNext()) {
            ((u) it.next()).u();
        }
    }
}
