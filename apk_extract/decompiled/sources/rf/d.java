package rf;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import jh.o;
import jh.o0;
import jh.y0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import li.j1;
import li.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f9432b = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "content");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f9433a;
    private volatile /* synthetic */ Object content;

    public d(o origin) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.f9433a = origin;
        this.content = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object, rf.b] */
    /* JADX WARN: Type inference failed for: r6v9, types: [T, java.lang.Object] */
    public final o a() throws Throwable {
        if (this.f9433a.c() != null) {
            Throwable thC = this.f9433a.c();
            Intrinsics.checkNotNull(thC);
            throw thC;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? r7 = this.content;
        objectRef.element = r7;
        j1 j1Var = j1.f7459a;
        if (r7 == 0) {
            ?? bVar = new b(this);
            objectRef.element = bVar;
            if (f9432b.compareAndSet(this, null, bVar)) {
                b bVar2 = (b) objectRef.element;
                bVar2.getClass();
                y0 y0VarG = o0.g(j1Var, v0.f7500c, false, new a(bVar2.f9431c, bVar2, null), 2);
                Intrinsics.checkNotNullParameter(y0VarG, "<set-?>");
                bVar2.f9430b = y0VarG;
                return y0VarG.f6311a;
            }
            objectRef.element = this.content;
        }
        return o0.g(j1Var, null, false, new c(objectRef, null), 3).f6311a;
    }
}
