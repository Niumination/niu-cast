package pq;

import ik.y0;
import lm.d1;

/* JADX INFO: loaded from: classes3.dex */
public interface n<E> {

    public static final class a {

        /* JADX INFO: renamed from: pq.n$a$a, reason: collision with other inner class name */
        @xm.f(c = "kotlinx.coroutines.channels.ChannelIterator$DefaultImpls", f = "Channel.kt", i = {0}, l = {589}, m = y0.b.f8223h, n = {"$this"}, s = {"L$0"})
        public static final class C0332a<E> extends xm.d {
            Object L$0;
            int label;
            /* synthetic */ Object result;

            public C0332a(um.d<? super C0332a> dVar) {
                super(dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return a.a(null, this);
            }
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @in.i(name = y0.b.f8223h)
        @lm.k(level = lm.m.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        public static Object a(n nVar, um.d dVar) {
            C0332a c0332a;
            if (dVar instanceof C0332a) {
                c0332a = (C0332a) dVar;
                int i10 = c0332a.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    c0332a.label = i10 - Integer.MIN_VALUE;
                } else {
                    c0332a = new C0332a(dVar);
                }
            } else {
                c0332a = new C0332a(dVar);
            }
            Object objB = c0332a.result;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i11 = c0332a.label;
            if (i11 == 0) {
                d1.n(objB);
                c0332a.L$0 = nVar;
                c0332a.label = 1;
                objB = nVar.b(c0332a);
                if (objB == aVar) {
                    return aVar;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                nVar = (n) c0332a.L$0;
                d1.n(objB);
            }
            if (((Boolean) objB).booleanValue()) {
                return nVar.next();
            }
            throw new v(r.f13314a);
        }
    }

    @in.i(name = y0.b.f8223h)
    @lm.k(level = lm.m.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
    /* synthetic */ Object a(um.d dVar);

    @os.m
    Object b(@os.l um.d<? super Boolean> dVar);

    E next();
}
