package nq;

/* JADX INFO: loaded from: classes3.dex */
public final class d4 {
    @os.m
    public static final Object a(@os.l um.d<? super lm.l2> dVar) {
        Object obj;
        um.g context = dVar.getContext();
        r2.y(context);
        um.d dVarE = wm.c.e(dVar);
        vq.m mVar = dVarE instanceof vq.m ? (vq.m) dVarE : null;
        if (mVar == null) {
            obj = lm.l2.f10208a;
        } else {
            if (mVar.f17863d.isDispatchNeeded(context)) {
                mVar.p(context, lm.l2.f10208a);
            } else {
                c4 c4Var = new c4();
                um.g gVarPlus = context.plus(c4Var);
                lm.l2 l2Var = lm.l2.f10208a;
                mVar.p(gVarPlus, l2Var);
                obj = (!c4Var.f11833a || vq.n.f(mVar)) ? wm.a.COROUTINE_SUSPENDED : l2Var;
            }
            obj = wm.a.COROUTINE_SUSPENDED;
        }
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        if (obj == aVar) {
            xm.h.c(dVar);
        }
        return obj == aVar ? obj : lm.l2.f10208a;
    }
}
