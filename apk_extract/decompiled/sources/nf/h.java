package nf;

import java.util.HashMap;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fg.e f8218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vi.i f8219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bh.c f8220c;

    public h(fg.e selector, int i8) {
        Intrinsics.checkNotNullParameter(selector, "selector");
        this.f8218a = selector;
        int i9 = vi.j.f10602a;
        this.f8219b = new vi.i(i8, 0);
        this.f8220c = new bh.c();
    }

    /* JADX WARN: Code duplicated, block: B:36:0x012d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x012e  */
    /* JADX WARN: Code duplicated, block: B:7:0x001d  */
    public final Object a(gg.n nVar, ig.d dVar, ContinuationImpl continuationImpl) throws Throwable {
        g gVar;
        h hVar;
        gg.n nVar2;
        Function1 function1;
        Object obj;
        gg.n nVar3;
        Object obj2;
        h hVar2;
        if (continuationImpl instanceof g) {
            gVar = (g) continuationImpl;
            int i8 = gVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                gVar.label = i8 - Integer.MIN_VALUE;
            } else {
                gVar = new g(this, continuationImpl);
            }
        } else {
            gVar = new g(this, continuationImpl);
        }
        Object objB = gVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = gVar.label;
        try {
            if (i9 == 0) {
                ResultKt.throwOnFailure(objB);
                gVar.L$0 = this;
                nVar2 = nVar;
                gVar.L$1 = nVar2;
                gVar.L$2 = dVar;
                gVar.label = 1;
                if (this.f8219b.a(gVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                hVar = this;
                function1 = dVar;
            } else {
                if (i9 != 1) {
                    if (i9 != 2) {
                        if (i9 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        obj2 = (vi.e) gVar.L$1;
                        hVar2 = (h) gVar.L$0;
                        try {
                            ResultKt.throwOnFailure(objB);
                            return (gg.s) objB;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                ((vi.h) obj2).c();
                                throw th;
                            } catch (Throwable th3) {
                                th = th3;
                                hVar = hVar2;
                                hVar.f8219b.c();
                                throw th;
                            }
                        }
                    }
                    vi.e eVar = (vi.e) gVar.L$3;
                    Function1 function2 = (Function1) gVar.L$2;
                    nVar3 = (gg.n) gVar.L$1;
                    hVar = (h) gVar.L$0;
                    ResultKt.throwOnFailure(objB);
                    obj = eVar;
                    function1 = function2;
                    try {
                        fg.e selector = hVar.f8218a;
                        Intrinsics.checkNotNullParameter(selector, "selector");
                        HashMap customOptions = new HashMap();
                        Intrinsics.checkNotNullParameter(customOptions, "customOptions");
                        gg.v from = new gg.v(customOptions);
                        Intrinsics.checkNotNullParameter(selector, "selector");
                        Intrinsics.checkNotNullParameter(from, "options");
                        gg.w options = new gg.w(new HashMap(customOptions));
                        Intrinsics.checkNotNullParameter(from, "from");
                        Intrinsics.checkNotNullParameter(selector, "selector");
                        Intrinsics.checkNotNullParameter(options, "options");
                        gVar.L$0 = hVar;
                        gVar.L$1 = obj;
                        gVar.L$2 = null;
                        gVar.L$3 = null;
                        gVar.label = 3;
                        HashMap customOptions2 = new HashMap(options.f5207a);
                        Intrinsics.checkNotNullParameter(customOptions2, "customOptions");
                        gg.x xVar = new gg.x(customOptions2);
                        xVar.f5204b = true;
                        xVar.f5205c = -1;
                        xVar.f5206d = Long.MAX_VALUE;
                        options.c(options);
                        function1.invoke(xVar);
                        objB = gg.l.b(selector, nVar3, xVar, gVar);
                        if (objB == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj2 = obj;
                        hVar2 = hVar;
                        return (gg.s) objB;
                    } catch (Throwable th4) {
                        th = th4;
                        obj2 = obj;
                        hVar2 = hVar;
                        ((vi.h) obj2).c();
                        throw th;
                    }
                }
                function1 = (Function1) gVar.L$2;
                gg.n nVar4 = (gg.n) gVar.L$1;
                hVar = (h) gVar.L$0;
                ResultKt.throwOnFailure(objB);
                nVar2 = nVar4;
            }
            bh.c cVar = hVar.f8220c;
            bb.s block = new bb.s(hVar);
            cVar.getClass();
            Intrinsics.checkNotNullParameter(block, "block");
            obj = (vi.e) cVar.f1330a.computeIfAbsent(nVar2, new bh.b(new bh.a(0, block), 0));
            gVar.L$0 = hVar;
            gVar.L$1 = nVar2;
            gVar.L$2 = function1;
            gVar.L$3 = obj;
            gVar.label = 2;
            if (((vi.h) obj).a(gVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            nVar3 = nVar2;
            fg.e selector2 = hVar.f8218a;
            Intrinsics.checkNotNullParameter(selector2, "selector");
            HashMap customOptions3 = new HashMap();
            Intrinsics.checkNotNullParameter(customOptions3, "customOptions");
            gg.v from2 = new gg.v(customOptions3);
            Intrinsics.checkNotNullParameter(selector2, "selector");
            Intrinsics.checkNotNullParameter(from2, "options");
            gg.w options2 = new gg.w(new HashMap(customOptions3));
            Intrinsics.checkNotNullParameter(from2, "from");
            Intrinsics.checkNotNullParameter(selector2, "selector");
            Intrinsics.checkNotNullParameter(options2, "options");
            gVar.L$0 = hVar;
            gVar.L$1 = obj;
            gVar.L$2 = null;
            gVar.L$3 = null;
            gVar.label = 3;
            HashMap customOptions4 = new HashMap(options2.f5207a);
            Intrinsics.checkNotNullParameter(customOptions4, "customOptions");
            gg.x xVar2 = new gg.x(customOptions4);
            xVar2.f5204b = true;
            xVar2.f5205c = -1;
            xVar2.f5206d = Long.MAX_VALUE;
            options2.c(options2);
            function1.invoke(xVar2);
            objB = gg.l.b(selector2, nVar3, xVar2, gVar);
            if (objB == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj2 = obj;
            hVar2 = hVar;
            return (gg.s) objB;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public final void b(gg.n address) {
        Intrinsics.checkNotNullParameter(address, "address");
        Object obj = this.f8220c.f1330a.get(address);
        Intrinsics.checkNotNull(obj);
        ((vi.h) ((vi.e) obj)).c();
        this.f8219b.c();
    }
}
