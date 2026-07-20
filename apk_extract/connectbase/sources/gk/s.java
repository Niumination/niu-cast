package gk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn.l1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class s {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6703a;

        static {
            int[] iArr = new int[nk.b0.values().length];
            iArr[nk.b0.NOT_MODIFIED.ordinal()] = 1;
            iArr[nk.b0.PRECONDITION_FAILED.ordinal()] = 2;
            iArr[nk.b0.OK.ordinal()] = 3;
            f6703a = iArr;
        }
    }

    @os.l
    public static final List<nk.a0> a(@os.l nk.s sVar) {
        kn.l0.p(sVar, "<this>");
        List<nk.a0> listC = nk.c0.c(sVar);
        return !listC.isEmpty() ? listC : c(sVar.e());
    }

    @lm.k(message = "Use versions or headers.parseVersions()")
    public static /* synthetic */ void b(nk.s sVar) {
    }

    @os.l
    public static final List<nk.a0> c(@os.l ik.b0 b0Var) {
        kn.l0.p(b0Var, "<this>");
        ik.j0 j0Var = ik.j0.f8048a;
        j0Var.getClass();
        List<String> listB = b0Var.b(ik.j0.O);
        if (listB == null) {
            listB = nm.k0.INSTANCE;
        }
        j0Var.getClass();
        List<String> listB2 = b0Var.b(ik.j0.A);
        if (listB2 == null) {
            listB2 = nm.k0.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(listB2.size() + listB.size());
        Iterator<T> it = listB.iterator();
        while (it.hasNext()) {
            arrayList.add(new nk.m(ik.r.b((String) it.next())));
        }
        Iterator<T> it2 = listB2.iterator();
        while (it2.hasNext()) {
            arrayList.add(nk.c0.a((String) it2.next()));
        }
        return arrayList;
    }

    @os.m
    @lm.k(message = "Use configuration for ConditionalHeaders or configure block of call.respond function.")
    public static final Object d(@os.l dk.b bVar, @os.l String str, boolean z10, @os.l jn.l<? super um.d<? super l2>, ? extends Object> lVar, @os.l um.d<? super l2> dVar) {
        Object objInvoke;
        nk.b0 b0VarA = nk.c0.a(str).a(bVar.d().b());
        if (z10) {
            vk.a aVarE = bVar.e();
            ik.j0.f8048a.getClass();
            vk.c.m(aVarE, ik.j0.A, str);
        }
        int i10 = a.f6703a[b0VarA.ordinal()];
        if (i10 != 1 && i10 != 2) {
            return (i10 == 3 && (objInvoke = lVar.invoke(dVar)) == wm.a.COROUTINE_SUSPENDED) ? objInvoke : l2.f10208a;
        }
        ik.r0 statusCode = b0VarA.getStatusCode();
        if (!(statusCode instanceof byte[])) {
            try {
                vk.i.b(bVar.e(), l1.A(ik.r0.class));
            } catch (Throwable unused) {
            }
        }
        Object objG = bVar.e().c().g(bVar, statusCode, dVar);
        return objG == wm.a.COROUTINE_SUSPENDED ? objG : l2.f10208a;
    }

    public static /* synthetic */ Object e(dk.b bVar, String str, boolean z10, jn.l lVar, um.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return d(bVar, str, z10, lVar, dVar);
    }
}
