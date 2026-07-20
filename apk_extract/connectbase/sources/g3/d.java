package g3;

import kn.w;
import lm.d1;
import lm.l2;
import os.m;
import r2.l;
import r2.p;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends f3.a<l<?>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final a f6400c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final String f6401d = "GrpcDataReceiver";

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    @xm.f(c = "com.transsion.airtransfer.filetransfer.transmission.grpc.GrpcDataReceiver", f = "GrpcDataReceiver.kt", i = {0}, l = {30}, m = "read", n = {"this"}, s = {"L$0"})
    public static final class b extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public b(um.d<? super b> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return d.this.b(this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    @Override // z2.a
    @m
    public Object b(@os.l um.d<? super l<?>> dVar) {
        b bVar;
        if (dVar instanceof b) {
            bVar = (b) dVar;
            int i10 = bVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                bVar.label = i10 - Integer.MIN_VALUE;
            } else {
                bVar = new b(dVar);
            }
        } else {
            bVar = new b(dVar);
        }
        Object objF = bVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = bVar.label;
        try {
            if (i11 == 0) {
                d1.n(objF);
                h3.b bVar2 = h3.b.f6969a;
                bVar.L$0 = this;
                bVar.label = 1;
                objF = bVar2.f(bVar);
                if (objF == aVar) {
                    return aVar;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(objF);
            }
            j3.b.f8554a.e(f6401d, "read data " + objF);
            return p.c(new l(objF));
        } catch (Exception e10) {
            e10.printStackTrace();
            this.f5840b = true;
            return new l(l2.f10208a);
        }
    }

    @Override // f3.a
    @m
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object f(@os.l l<?> lVar, @os.l um.d<? super l2> dVar) {
        j3.b.f8554a.e(f6401d, "sendData " + lVar.f14198a + "  " + lVar.f14192g);
        p.b(u2.b.f16175b, lVar, null, 2, null);
        return l2.f10208a;
    }
}
