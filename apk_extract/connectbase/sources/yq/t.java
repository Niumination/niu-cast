package yq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kn.r1;
import lm.z0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nSelectUnbiased.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectUnbiased.kt\nkotlinx/coroutines/selects/UnbiasedSelectImplementation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,68:1\n1855#2,2:69\n*S KotlinDebug\n*F\n+ 1 SelectUnbiased.kt\nkotlinx/coroutines/selects/UnbiasedSelectImplementation\n*L\n63#1:69,2\n*E\n"})
@z0
public class t<R> extends l<R> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final List<l<R>.a> f21744g;

    public t(@os.l um.g gVar) {
        super(gVar);
        this.f21744g = new ArrayList();
    }

    @z0
    public static <R> Object O(t<R> tVar, um.d<? super R> dVar) {
        tVar.P();
        return l.z(tVar, dVar);
    }

    public final void P() {
        try {
            Collections.shuffle(this.f21744g);
            Iterator<T> it = this.f21744g.iterator();
            while (it.hasNext()) {
                l.I(this, (l.a) it.next(), false, 1, null);
            }
            this.f21744g.clear();
        } catch (Throwable th2) {
            this.f21744g.clear();
            throw th2;
        }
    }

    @Override // yq.l, yq.c
    public <P, Q> void a(@os.l i<? super P, ? extends Q> iVar, P p10, @os.l jn.p<? super Q, ? super um.d<? super R>, ? extends Object> pVar) {
        this.f21744g.add(new l.a(iVar.d(), iVar.a(), iVar.c(), p10, pVar, iVar.b()));
    }

    @Override // yq.l, yq.c
    public void b(@os.l e eVar, @os.l jn.l<? super um.d<? super R>, ? extends Object> lVar) {
        this.f21744g.add(new l.a(eVar.d(), eVar.a(), eVar.c(), o.l(), lVar, eVar.b()));
    }

    @Override // yq.l, yq.c
    public <Q> void e(@os.l g<? extends Q> gVar, @os.l jn.p<? super Q, ? super um.d<? super R>, ? extends Object> pVar) {
        this.f21744g.add(new l.a(gVar.d(), gVar.a(), gVar.c(), null, pVar, gVar.b()));
    }

    @Override // yq.l
    @os.m
    @z0
    public Object x(@os.l um.d<? super R> dVar) {
        return O(this, dVar);
    }
}
