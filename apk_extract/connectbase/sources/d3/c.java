package d3;

import c3.p;
import java.util.ArrayList;
import kn.l0;
import kn.r1;
import kn.w;
import lm.d1;
import lm.l2;
import nm.y;
import os.m;
import r2.e;
import r2.k;
import r2.l;
import r2.n;
import r2.o;
import r2.q;
import r2.t;
import r2.u;
import xm.d;
import xm.f;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nMessageDataProcessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageDataProcessor.kt\ncom/transsion/airtransfer/filetransfer/process/message/MessageDataProcessor\n+ 2 DataBus.kt\ncom/transsion/airtransfer/filetransfer/databus/DataBus\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,91:1\n45#2,2:92\n1#3:94\n*S KotlinDebug\n*F\n+ 1 MessageDataProcessor.kt\ncom/transsion/airtransfer/filetransfer/process/message/MessageDataProcessor\n*L\n61#1:92,2\n*E\n"})
public final class c extends b3.a<o, l<?>> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final a f3524e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final String f3525f = "MessageDataProcessor";

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    @f(c = "com.transsion.airtransfer.filetransfer.process.message.MessageDataProcessor", f = "MessageDataProcessor.kt", i = {}, l = {45}, m = "getSendData", n = {}, s = {})
    public static final class b extends d {
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
            return c.this.g(this);
        }
    }

    @Override // b3.a
    @m
    public Object f(@os.l um.d<? super l<?>> dVar) {
        j3.b.f8554a.e(f3525f, "getReceiveData call");
        u2.b bVar = u2.b.f16175b;
        return bVar.g(l.class).b(new Integer(2), dVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // b3.a
    @m
    public Object g(@os.l um.d<? super o> dVar) {
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
        Object objL = bVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = bVar.label;
        if (i11 == 0) {
            d1.n(objL);
            u2.b bVar2 = u2.b.f16175b;
            Integer num = new Integer(1);
            ArrayList arrayListS = y.s(t.class, u.class, r2.d.class, e.class, r2.b.class, r2.c.class, q.class, n.class);
            bVar.label = 1;
            objL = bVar2.l(num, arrayListS, bVar);
            if (objL == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(objL);
        }
        o oVar = objL instanceof o ? (o) objL : null;
        return oVar == null ? new o(0, 0L, 3, null) : oVar;
    }

    public final void k(t tVar) {
        k kVarR = d3.b.r(tVar);
        s2.c.d(kVarR);
        c3.m.f1313a.e(kVarR);
        q2.c.f13803b.getClass();
        p pVar = q2.c.f13805d;
        if (pVar != null) {
            pVar.c(kVarR.f14187a, kVarR.f14189c, kVarR.f14190d);
        }
    }

    @Override // y2.b
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public void c(@os.l l<?> lVar) {
        l0.p(lVar, "data");
        r2.m mVarC = d3.a.f3522a.a(lVar);
        if (mVarC instanceof t) {
            k((t) mVarC);
            return;
        }
        if (mVarC instanceof n) {
            q2.c.f13803b.getClass();
            c3.q qVar = q2.c.f13806e;
            if (qVar != null) {
                qVar.f(((n) mVarC).f14194h);
                return;
            }
            return;
        }
        if (mVarC != null) {
            k kVarD = c3.m.f1313a.d(mVarC.b());
            if (!(mVarC instanceof r2.d) || kVarD == null || !kVarD.p()) {
                r2.p.b(u2.b.f16175b, r2.p.c(mVarC), null, 2, null);
                return;
            }
            q2.c.f13803b.getClass();
            p pVar = q2.c.f13805d;
            if (pVar != null) {
                pVar.onCancel(mVarC.b(), true);
            }
        }
    }

    @Override // y2.b
    @m
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public Object b(@os.l o oVar, @os.l um.d<? super l2> dVar) {
        j3.b.f8554a.e(f3525f, "send data type : " + oVar.c() + " data:" + oVar);
        if (oVar instanceof r2.m) {
            l<?> lVarD = d3.a.f3522a.b((r2.m) oVar);
            lVarD.f14200c = oVar.f14200c;
            r2.p.b(u2.b.f16175b, lVarD, null, 2, null);
        }
        return l2.f10208a;
    }
}
