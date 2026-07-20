package c3;

import kn.l0;
import kn.r1;
import kn.w;
import lm.d1;
import lm.l2;
import r2.t;
import r2.u;
import r2.v;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nFileDataProcessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileDataProcessor.kt\ncom/transsion/airtransfer/filetransfer/process/file/FileDataProcessor\n+ 2 DataBus.kt\ncom/transsion/airtransfer/filetransfer/databus/DataBus\n*L\n1#1,79:1\n45#2,2:80\n44#2,3:82\n45#2,2:85\n*S KotlinDebug\n*F\n+ 1 FileDataProcessor.kt\ncom/transsion/airtransfer/filetransfer/process/file/FileDataProcessor\n*L\n45#1:80,2\n63#1:82,3\n69#1:85,2\n*E\n"})
public final class g extends b3.a<v, r2.g> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final a f1277f = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final String f1278g = "FileDataProcessor";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final i f1279e = new i();

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    @xm.f(c = "com.transsion.airtransfer.filetransfer.process.file.FileDataProcessor", f = "FileDataProcessor.kt", i = {}, l = {82}, m = "getSendData", n = {}, s = {})
    public static final class b extends xm.d {
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
            return g.this.g(this);
        }
    }

    @xm.f(c = "com.transsion.airtransfer.filetransfer.process.file.FileDataProcessor", f = "FileDataProcessor.kt", i = {0}, l = {81}, m = "sendData", n = {"fileTaskInfo"}, s = {"L$0"})
    public static final class c extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public c(um.d<? super c> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return g.this.b(null, this);
        }
    }

    @Override // b3.a
    @os.m
    public Object f(@os.l um.d<? super r2.g> dVar) {
        u2.b bVar = u2.b.f16175b;
        return bVar.g(r2.g.class).b(new Integer(2), dVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // b3.a
    @os.m
    public Object g(@os.l um.d<? super v> dVar) {
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
        Object objB = bVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = bVar.label;
        if (i11 == 0) {
            d1.n(objB);
            w2.a aVarG = u2.b.f16175b.g(v.class);
            bVar.label = 1;
            objB = aVarG.b(null, bVar);
            if (objB == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(objB);
        }
        v vVar = (v) objB;
        j3.b.f8554a.e(f1278g, "get send data " + vVar);
        return vVar;
    }

    @Override // y2.b
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public void c(@os.l r2.g gVar) {
        l0.p(gVar, "data");
        j3.b.f8554a.e(f1278g, "receiveData file data message");
        this.f1279e.J(gVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // y2.b
    @os.m
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public Object b(@os.l v vVar, @os.l um.d<? super l2> dVar) {
        c cVar;
        r2.k kVar;
        if (dVar instanceof c) {
            cVar = (c) dVar;
            int i10 = cVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                cVar.label = i10 - Integer.MIN_VALUE;
            } else {
                cVar = new c(dVar);
            }
        } else {
            cVar = new c(dVar);
        }
        Object obj = cVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = cVar.label;
        if (i11 == 0) {
            d1.n(obj);
            r2.k kVar2 = vVar.f14210g;
            if (kVar2.m()) {
                return l2.f10208a;
            }
            j3.b.f8554a.e(f1278g, "send data " + vVar);
            u2.b bVar = u2.b.f16175b;
            r2.p.b(bVar, new t(kVar2.f14187a, kVar2.f14189c, kVar2.f14190d), null, 2, null);
            Integer num = new Integer(2);
            w2.a aVarG = bVar.g(u.class);
            cVar.L$0 = kVar2;
            cVar.label = 1;
            Object objB = aVarG.b(num, cVar);
            if (objB == aVar) {
                return aVar;
            }
            kVar = kVar2;
            obj = objB;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kVar = (r2.k) cVar.L$0;
            d1.n(obj);
        }
        u uVar = (u) obj;
        if (kVar.m()) {
            return l2.f10208a;
        }
        j3.b.f8554a.e(f1278g, "send data receive reply msg " + uVar);
        q2.c.f13803b.getClass();
        q qVar = q2.c.f13806e;
        if (qVar != null) {
            qVar.e(kVar.f14187a, uVar.f14208i, uVar.f14209j);
        }
        if (uVar.f14208i) {
            new j(kVar).L();
        }
        return l2.f10208a;
    }
}
