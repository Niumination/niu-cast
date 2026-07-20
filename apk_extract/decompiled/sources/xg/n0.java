package xg;

import java.util.ArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import qg.y0;

/* JADX INFO: loaded from: classes3.dex */
public final class n0 extends u implements o {
    public static final zg.a A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final se.g f10974x = new se.g(6);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final yf.a f10975y = new yf.a();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final yf.a f10976z = new yf.a();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final mg.a f10977v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList f10978w;

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(n0.class);
        try {
            kTypeTypeOf = Reflection.typeOf(n0.class);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        A = new zg.a("Routing", new ih.a(orCreateKotlinClass, kTypeTypeOf));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(mg.a application) {
        super(null, new j(application.q), application.f8054h, application.f8055i);
        Intrinsics.checkNotNullParameter(application, "application");
        this.f10977v = application;
        ArrayList arrayList = new ArrayList();
        this.f10978w = arrayList;
        arrayList.add(new y0(23));
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    public final Object v(hh.f fVar, u uVar, zf.d0 d0Var, ContinuationImpl continuationImpl) throws Throwable {
        l0 l0Var;
        r rVar;
        n0 n0Var = this;
        if (continuationImpl instanceof l0) {
            l0Var = (l0) continuationImpl;
            int i8 = l0Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                l0Var.label = i8 - Integer.MIN_VALUE;
            } else {
                l0Var = new l0(n0Var, continuationImpl);
            }
        } else {
            l0Var = new l0(n0Var, continuationImpl);
        }
        l0 l0Var2 = l0Var;
        Object obj = l0Var2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = l0Var2.label;
        yf.a aVar = f10976z;
        if (i9 != 0) {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r rVar2 = (r) l0Var2.L$1;
            n0 n0Var2 = (n0) l0Var2.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                rVar = rVar2;
                n0Var = n0Var2;
                n0Var.f10977v.f8043r.a(aVar, rVar);
                return Unit.INSTANCE;
            } catch (Throwable th2) {
                th = th2;
                rVar = rVar2;
                n0Var = n0Var2;
                n0Var.f10977v.f8043r.a(aVar, rVar);
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        mg.c cVar = uVar.f10991t;
        if (cVar == null) {
            cVar = new mg.c(uVar.f8054h, o0.a(uVar).f8055i);
            ArrayList arrayList = new ArrayList();
            for (u uVar2 = uVar; uVar2 != null; uVar2 = uVar2.q) {
                arrayList.add(uVar2);
            }
            for (int lastIndex = CollectionsKt.getLastIndex(arrayList); -1 < lastIndex; lastIndex--) {
                mg.c cVar2 = (mg.c) arrayList.get(lastIndex);
                cVar.q(cVar2);
                cVar.f8056j.q(cVar2.f8056j);
                cVar.f8057k.q(cVar2.f8057k);
            }
            ArrayList arrayList2 = uVar.u;
            int lastIndex2 = CollectionsKt.getLastIndex(arrayList2);
            if (lastIndex2 >= 0) {
                int i10 = 0;
                while (true) {
                    cVar.p(mg.c.f8053o, new t(arrayList2, i10, null));
                    if (i10 == lastIndex2) {
                        break;
                    }
                    i10++;
                }
            }
            uVar.f10991t = cVar;
        }
        mg.c cVar3 = cVar;
        vg.b bVarE = ((mg.r) fVar.f5401a).g().e();
        boolean z2 = bVarE.f5399c == 0;
        boolean z3 = n0Var.f8054h;
        vg.b bVar = cVar3.f8056j;
        if (!z2) {
            if (bVar.f5399c == 0) {
                bVar = bVarE;
            } else {
                vg.b bVar2 = new vg.b(z3);
                bVar2.q(bVarE);
                bVar2.q(bVar);
                bVar = bVar2;
            }
        }
        mg.r rVar3 = (mg.r) fVar.f5401a;
        wg.b bVarE2 = rVar3.k().e();
        boolean z5 = bVarE2.f5399c == 0;
        wg.b bVar3 = cVar3.f8057k;
        if (!z5) {
            if (bVar3.f5399c == 0) {
                bVar3 = bVarE2;
            } else {
                wg.b bVar4 = new wg.b(z3);
                bVar4.q(bVarE2);
                bVar4.q(bVar3);
                bVar3 = bVar4;
            }
        }
        y yVar = new y(rVar3, uVar, fVar.getCoroutineContext(), bVar, bVar3, d0Var);
        rVar = new r(yVar);
        n0Var.f10977v.f8043r.a(f10975y, rVar);
        try {
            k0 k0Var = new k0(cVar3, yVar, null);
            l0Var2.L$0 = n0Var;
            l0Var2.L$1 = rVar;
            l0Var2.label = 1;
            if (dh.c.a(k0Var, l0Var2) == coroutine_suspended) {
                return coroutine_suspended;
            }
            n0Var.f10977v.f8043r.a(aVar, rVar);
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            th = th3;
            n0Var.f10977v.f8043r.a(aVar, rVar);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object x(hh.f fVar, ContinuationImpl continuationImpl) {
        m0 m0Var;
        if (continuationImpl instanceof m0) {
            m0Var = (m0) continuationImpl;
            int i8 = m0Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                m0Var.label = i8 - Integer.MIN_VALUE;
            } else {
                m0Var = new m0(this, continuationImpl);
            }
        } else {
            m0Var = new m0(this, continuationImpl);
        }
        Object objC = m0Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = m0Var.label;
        if (i9 != 0) {
            if (i9 == 1) {
                fVar = (hh.f) m0Var.L$1;
                this = (n0) m0Var.L$0;
                ResultKt.throwOnFailure(objC);
            } else {
                if (i9 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objC);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(objC);
        c0 c0Var = new c0(this, (mg.r) fVar.f5401a, this.f10978w);
        m0Var.L$0 = this;
        m0Var.L$1 = fVar;
        m0Var.label = 1;
        objC = c0Var.c(m0Var);
        if (objC == coroutine_suspended) {
            return coroutine_suspended;
        }
        f0 f0Var = (f0) objC;
        if (!(f0Var instanceof e0)) {
            if (!(f0Var instanceof d0)) {
                throw new NoWhenBranchMatchedException();
            }
            ((mg.r) fVar.f5401a).i().e(o0.f10979a, ((d0) f0Var).f10936c);
            return Unit.INSTANCE;
        }
        u uVar = f0Var.f10943a;
        m0Var.L$0 = null;
        m0Var.L$1 = null;
        m0Var.label = 2;
        if (this.v(fVar, uVar, ((e0) f0Var).f10938b, m0Var) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
