package gk;

import ik.l1;
import java.util.Iterator;
import java.util.List;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final fl.b<q0> f6707a = new fl.b<>("MutableOriginConnectionPointKey");

    public static final class a extends kn.n0 implements jn.a<q0> {
        final /* synthetic */ dk.b $this_mutableOriginConnectionPoint;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(dk.b bVar) {
            super(0);
            this.$this_mutableOriginConnectionPoint = bVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final q0 invoke() {
            return new q0(new t0(this.$this_mutableOriginConnectionPoint));
        }
    }

    public static final void a(dk.b bVar, List<String> list, jn.l<? super String, l2> lVar) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String strQ = uk.e.q(bVar.d(), it.next());
            if (strQ != null) {
                lVar.invoke(strQ);
            }
        }
    }

    @os.l
    public static final q0 b(@os.l dk.b bVar) {
        kn.l0.p(bVar, "<this>");
        return (q0) bVar.c().a(f6707a, new a(bVar));
    }

    @os.l
    public static final fl.b<q0> c() {
        return f6707a;
    }

    @lm.k(message = "This API will be redesigned as per https://youtrack.jetbrains.com/issue/KTOR-2657")
    public static /* synthetic */ void d() {
    }

    @os.l
    public static final l1 e(@os.l uk.d dVar) {
        kn.l0.p(dVar, "<this>");
        q0 q0Var = (q0) dVar.f().c().b(f6707a);
        return q0Var == null ? dVar.g() : q0Var;
    }
}
