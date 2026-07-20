package nk;

import ik.r0;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import kn.l0;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends s.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.p<OutputStream, um.d<? super l2>, Object> f11541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final ik.i f11542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public final r0 f11543d;

    @xm.f(c = "io.ktor.http.content.OutputStreamContent$writeTo$2", f = "OutputStreamContent.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends xm.o implements jn.l<um.d<? super l2>, Object> {
        final /* synthetic */ pl.n $channel;
        Object L$0;
        int label;
        final /* synthetic */ t this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(pl.n nVar, t tVar, um.d<? super a> dVar) {
            super(1, dVar);
            this.$channel = nVar;
            this.this$0 = tVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.l um.d<?> dVar) {
            return new a(this.$channel, this.this$0, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) throws IllegalAccessException, IOException, InvocationTargetException {
            Throwable th2;
            Closeable closeable;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                OutputStream outputStreamH = yl.b.h(this.$channel, null, 1, null);
                try {
                    jn.p<OutputStream, um.d<? super l2>, Object> pVar = this.this$0.f11541b;
                    this.L$0 = outputStreamH;
                    this.label = 1;
                    if (pVar.invoke(outputStreamH, this) == aVar) {
                        return aVar;
                    }
                    closeable = outputStreamH;
                } catch (Throwable th3) {
                    th2 = th3;
                    closeable = outputStreamH;
                    throw th2;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                closeable = (Closeable) this.L$0;
                try {
                    d1.n(obj);
                } catch (Throwable th4) {
                    th2 = th4;
                    try {
                        throw th2;
                    } catch (Throwable th5) {
                        dn.c.a(closeable, th2);
                        throw th5;
                    }
                }
            }
            l2 l2Var = l2.f10208a;
            dn.c.a(closeable, null);
            return l2Var;
        }

        @Override // jn.l
        @os.m
        public final Object invoke(@os.m um.d<? super l2> dVar) {
            return ((a) create(dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t(@os.l jn.p<? super OutputStream, ? super um.d<? super l2>, ? extends Object> pVar, @os.l ik.i iVar, @os.m r0 r0Var) {
        l0.p(pVar, "body");
        l0.p(iVar, "contentType");
        this.f11541b = pVar;
        this.f11542c = iVar;
        this.f11543d = r0Var;
    }

    @Override // nk.s
    @os.l
    public ik.i c() {
        return this.f11542c;
    }

    @Override // nk.s
    @os.m
    public r0 g() {
        return this.f11543d;
    }

    @Override // nk.s.e
    @os.m
    public Object j(@os.l pl.n nVar, @os.l um.d<? super l2> dVar) throws Throwable {
        Object objD = nk.a.d(new a(nVar, this, null), dVar);
        return objD == wm.a.COROUTINE_SUSPENDED ? objD : l2.f10208a;
    }

    public /* synthetic */ t(jn.p pVar, ik.i iVar, r0 r0Var, int i10, kn.w wVar) {
        this(pVar, iVar, (i10 & 4) != 0 ? null : r0Var);
    }
}
