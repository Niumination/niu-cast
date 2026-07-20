package qg;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import li.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y0 f9073b;

    static {
        z0 createConfiguration = z0.INSTANCE;
        y0 body = new y0(0);
        Intrinsics.checkNotNullParameter("shutdown.url", "name");
        Intrinsics.checkNotNullParameter(createConfiguration, "createConfiguration");
        Intrinsics.checkNotNullParameter(body, "body");
        new qf.c("shutdown.url", new bh.a(2, createConfiguration), body);
    }

    public g1(String url, y0 exitCode) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(exitCode, "exitCode");
        this.f9072a = url;
        this.f9073b = exitCode;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [qg.g1] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v9, types: [java.lang.Object, kotlin.Unit] */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.Object, mg.b] */
    public final Object a(mg.b bVar, ContinuationImpl continuationImpl) {
        e1 e1Var;
        KType kTypeTypeOf;
        Object obj;
        if (continuationImpl instanceof e1) {
            e1Var = (e1) continuationImpl;
            int i8 = e1Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                e1Var.label = i8 - Integer.MIN_VALUE;
            } else {
                e1Var = new e1(this, continuationImpl);
            }
        } else {
            e1Var = new e1(this, continuationImpl);
        }
        Object obj2 = e1Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = e1Var.label;
        try {
            if (i9 == 0) {
                ResultKt.throwOnFailure(obj2);
                mg.a application = bVar.getApplication();
                Intrinsics.checkNotNullParameter(application, "<this>");
                application.f8055i.f9064b.warn("Shutdown URL was called: server is going down");
                mg.a application2 = bVar.getApplication();
                b bVar2 = application2.f8055i;
                this.f9073b.invoke(bVar);
                Integer num = 0;
                int iIntValue = num.intValue();
                li.r rVarB = li.l0.b();
                li.l0.p(bVar.getApplication(), null, null, new f1(rVarB, application2, bVar2, iIntValue, null), 3);
                zf.z zVar = zf.z.f11575s;
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(zf.z.class);
                try {
                    kTypeTypeOf = Reflection.typeOf(zf.z.class);
                } catch (Throwable unused) {
                    kTypeTypeOf = null;
                }
                ih.a aVar = new ih.a(orCreateKotlinClass, kTypeTypeOf);
                e1Var.L$0 = rVarB;
                e1Var.label = 1;
                obj = rVarB;
                if (bVar.B(zVar, aVar, e1Var) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i9 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                li.q qVar = (li.q) e1Var.L$0;
                ResultKt.throwOnFailure(obj2);
                obj = qVar;
            }
            ((x1) obj).h(null);
            this = Unit.INSTANCE;
            return this;
        } catch (Throwable th2) {
            ((x1) this).h(null);
            throw th2;
        }
    }
}
