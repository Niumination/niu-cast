package kf;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.ResultKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import li.g0;
import li.h0;
import li.l0;
import pf.s;

/* JADX INFO: loaded from: classes3.dex */
public class c implements g0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6854d;
    public static final zg.a e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jf.d f6855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public vf.b f6856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public wf.b f6857c;
    private volatile /* synthetic */ int received;

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        try {
            kTypeTypeOf = Reflection.typeOf(Object.class);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        e = new zg.a("CustomResponse", new ih.a(orCreateKotlinClass, kTypeTypeOf));
        f6854d = AtomicIntegerFieldUpdater.newUpdater(c.class, "received");
    }

    public c(jf.d client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.f6855a = client;
        this.received = 0;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:50:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f3 A[Catch: all -> 0x0039, TryCatch #1 {all -> 0x0039, blocks: (B:13:0x0034, B:47:0x00e3, B:52:0x00f3, B:55:0x0106, B:56:0x0119), top: B:61:0x0034 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0105  */
    /* JADX WARN: Code duplicated, block: B:55:0x0106 A[Catch: all -> 0x0039, TryCatch #1 {all -> 0x0039, blocks: (B:13:0x0034, B:47:0x00e3, B:52:0x00f3, B:55:0x0106, B:56:0x0119), top: B:61:0x0034 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(ih.a aVar, ContinuationImpl continuationImpl) throws Throwable {
        b bVar;
        c cVar;
        Throwable th2;
        ih.a aVar2;
        Object obj;
        KClass type;
        if (continuationImpl instanceof b) {
            bVar = (b) continuationImpl;
            int i8 = bVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                bVar.label = i8 - Integer.MIN_VALUE;
            } else {
                bVar = new b(this, continuationImpl);
            }
        } else {
            bVar = new b(this, continuationImpl);
        }
        Object objD = bVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = bVar.label;
        try {
            if (i9 == 0) {
                ResultKt.throwOnFailure(objD);
                wf.b bVarE = e();
                KClass type2 = aVar.f5872a;
                Intrinsics.checkNotNullParameter(bVarE, "<this>");
                Intrinsics.checkNotNullParameter(type2, "type");
                if (JvmClassMappingKt.getJavaClass(type2).isInstance(bVarE)) {
                    return e();
                }
                if (!b()) {
                    wf.b bVarE2 = e();
                    zg.a aVar3 = s.f8865a;
                    Intrinsics.checkNotNullParameter(bVarE2, "<this>");
                    zg.h hVarI = bVarE2.b().i();
                    zg.a key = s.f8866b;
                    hVarI.getClass();
                    Intrinsics.checkNotNullParameter(key, "key");
                    if (!hVarI.c().containsKey(key) && !f6854d.compareAndSet(this, 0, 1)) {
                        throw new a(this);
                    }
                }
                objD = i().d(e);
                if (objD == null) {
                    bVar.L$0 = this;
                    bVar.L$1 = aVar;
                    bVar.label = 1;
                    objD = f();
                    if (objD == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i9 != 1) {
                    if (i9 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    aVar2 = (ih.a) bVar.L$1;
                    cVar = (c) bVar.L$0;
                    try {
                        ResultKt.throwOnFailure(objD);
                        obj = ((wf.c) objD).f10743b;
                        if (!Intrinsics.areEqual(obj, cg.e.f1675a)) {
                            obj = null;
                        }
                        if (obj != null) {
                            type = aVar2.f5872a;
                            Intrinsics.checkNotNullParameter(obj, "<this>");
                            Intrinsics.checkNotNullParameter(type, "type");
                            if (JvmClassMappingKt.getJavaClass(type).isInstance(obj)) {
                                throw new d(cVar.e(), Reflection.getOrCreateKotlinClass(obj.getClass()), aVar2.f5872a);
                            }
                        }
                        return obj;
                    } catch (Throwable th3) {
                        th2 = th3;
                        h0.b(cVar.e(), l0.a("Receive failed", th2));
                        throw th2;
                    }
                }
                aVar = (ih.a) bVar.L$1;
                this = (c) bVar.L$0;
                ResultKt.throwOnFailure(objD);
            }
            wf.c cVar2 = new wf.c(aVar, objD);
            wf.f fVar = this.f6855a.f6259h;
            bVar.L$0 = this;
            bVar.L$1 = aVar;
            bVar.label = 2;
            objD = fVar.b(this, cVar2, bVar);
            if (objD == coroutine_suspended) {
                return coroutine_suspended;
            }
            ih.a aVar4 = aVar;
            cVar = this;
            aVar2 = aVar4;
            obj = ((wf.c) objD).f10743b;
            if (!Intrinsics.areEqual(obj, cg.e.f1675a)) {
                obj = null;
            }
            if (obj != null) {
                type = aVar2.f5872a;
                Intrinsics.checkNotNullParameter(obj, "<this>");
                Intrinsics.checkNotNullParameter(type, "type");
                if (JvmClassMappingKt.getJavaClass(type).isInstance(obj)) {
                    throw new d(cVar.e(), Reflection.getOrCreateKotlinClass(obj.getClass()), aVar2.f5872a);
                }
            }
            return obj;
        } catch (Throwable th4) {
            cVar = this;
            th2 = th4;
        }
    }

    public boolean b() {
        return false;
    }

    public final vf.b d() {
        vf.b bVar = this.f6856b;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("request");
        return null;
    }

    public final wf.b e() {
        wf.b bVar = this.f6857c;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    public Object f() {
        return e().d();
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return e().getCoroutineContext();
    }

    public final zg.h i() {
        return d().i();
    }

    public final String toString() {
        return "HttpClientCall[" + d().getUrl() + ", " + e().h() + ']';
    }
}
