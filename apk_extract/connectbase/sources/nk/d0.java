package nk;

import ik.r0;
import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import kn.l0;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 extends s.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.p<Writer, um.d<? super l2>, Object> f11514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final ik.i f11515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public final r0 f11516d;

    @xm.f(c = "io.ktor.http.content.WriterContent$writeTo$2", f = "WriterContent.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends xm.o implements jn.l<um.d<? super l2>, Object> {
        final /* synthetic */ pl.n $channel;
        final /* synthetic */ Charset $charset;
        Object L$0;
        int label;
        final /* synthetic */ d0 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(pl.n nVar, Charset charset, d0 d0Var, um.d<? super a> dVar) {
            super(1, dVar);
            this.$channel = nVar;
            this.$charset = charset;
            this.this$0 = d0Var;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.l um.d<?> dVar) {
            return new a(this.$channel, this.$charset, this.this$0, dVar);
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
                Writer writerE = gl.i.e(this.$channel, this.$charset);
                try {
                    jn.p<Writer, um.d<? super l2>, Object> pVar = this.this$0.f11514b;
                    this.L$0 = writerE;
                    this.label = 1;
                    if (pVar.invoke(writerE, this) == aVar) {
                        return aVar;
                    }
                    closeable = writerE;
                } catch (Throwable th3) {
                    th2 = th3;
                    closeable = writerE;
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

    public /* synthetic */ d0(jn.p pVar, ik.i iVar, r0 r0Var, int i10, kn.w wVar) {
        this(pVar, iVar, (i10 & 4) != 0 ? null : r0Var);
    }

    @Override // nk.s
    @os.l
    public ik.i c() {
        return this.f11515c;
    }

    @Override // nk.s
    @os.m
    public r0 g() {
        return this.f11516d;
    }

    @Override // nk.s.e
    @os.m
    public Object j(@os.l pl.n nVar, @os.l um.d<? super l2> dVar) throws Throwable {
        Charset charsetA = ik.k.a(this.f11515c);
        if (charsetA == null) {
            charsetA = jq.f.f8800b;
        }
        Object objD = nk.a.d(new a(nVar, charsetA, this, null), dVar);
        return objD == wm.a.COROUTINE_SUSPENDED ? objD : l2.f10208a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d0(@os.l jn.p<? super Writer, ? super um.d<? super l2>, ? extends Object> pVar, @os.l ik.i iVar, @os.m r0 r0Var) {
        l0.p(pVar, "body");
        l0.p(iVar, "contentType");
        this.f11514b = pVar;
        this.f11515c = iVar;
        this.f11516d = r0Var;
    }
}
