package r2;

import com.transsion.connectx.mirror.source.pad.FloatingWindow;
import kn.l0;
import lm.d1;
import lm.l2;
import pq.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final a f14160e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final String f14161f = "FileDataChannel";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public jn.q<? super byte[], ? super Integer, ? super Integer, l2> f14162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public jn.a<l2> f14163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final pq.l<jn.q<byte[], Integer, Integer, l2>> f14164c = pq.o.d(0, null, null, 7, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14165d;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    @xm.f(c = "com.transsion.airtransfer.filetransfer.bean.FileDataChannel", f = "FileDataChannel.kt", i = {0, 0, 0}, l = {29}, m = "send", n = {"byteArray", FloatingWindow.f2048b0, "length"}, s = {"L$0", "I$0", "I$1"})
    public static final class b extends xm.d {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public b(um.d<? super b> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return g.this.e(null, 0, 0, this);
        }
    }

    public final void a() {
        j3.b.f8554a.e(f14161f, "file data message end " + this.f14163b);
        this.f14165d = true;
        jn.a<l2> aVar = this.f14163b;
        if (aVar != null) {
            aVar.invoke();
        }
        this.f14162a = null;
        this.f14163b = null;
        g0.a.a(this.f14164c, null, 1, null);
    }

    public final boolean b() {
        return this.f14165d;
    }

    public final void c(@os.l jn.a<l2> aVar) {
        l0.p(aVar, "onEndCallback");
        this.f14163b = aVar;
    }

    @os.m
    public final Object d(@os.l jn.q<? super byte[], ? super Integer, ? super Integer, l2> qVar, @os.l um.d<? super l2> dVar) {
        j3.b.f8554a.e(f14161f, "onWrite set callback " + qVar);
        this.f14162a = qVar;
        Object objL = this.f14164c.L(qVar, dVar);
        return objL == wm.a.COROUTINE_SUSPENDED ? objL : l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public final Object e(@os.l byte[] bArr, int i10, int i11, @os.l um.d<? super l2> dVar) {
        b bVar;
        jn.q<? super byte[], ? super Integer, ? super Integer, l2> qVar;
        if (dVar instanceof b) {
            bVar = (b) dVar;
            int i12 = bVar.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                bVar.label = i12 - Integer.MIN_VALUE;
            } else {
                bVar = new b(dVar);
            }
        } else {
            bVar = new b(dVar);
        }
        Object objN = bVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i13 = bVar.label;
        if (i13 == 0) {
            d1.n(objN);
            qVar = this.f14162a;
            if (qVar == null) {
                j3.b.f8554a.e(f14161f, "callback is null");
                pq.l<jn.q<byte[], Integer, Integer, l2>> lVar = this.f14164c;
                bVar.L$0 = bArr;
                bVar.I$0 = i10;
                bVar.I$1 = i11;
                bVar.label = 1;
                objN = lVar.n(bVar);
                if (objN == aVar) {
                    return aVar;
                }
            }
            qVar.invoke(bArr, new Integer(i10), new Integer(i11));
            return l2.f10208a;
        }
        if (i13 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        i11 = bVar.I$1;
        i10 = bVar.I$0;
        bArr = (byte[]) bVar.L$0;
        d1.n(objN);
        qVar = (jn.q) objN;
        qVar.invoke(bArr, new Integer(i10), new Integer(i11));
        return l2.f10208a;
    }
}
