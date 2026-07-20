package lc;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import se.r4;
import se.y4;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7359b;

    public /* synthetic */ a(Object obj, int i8) {
        this.f7358a = i8;
        this.f7359b = obj;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0260  */
    /* JADX WARN: Code duplicated, block: B:122:0x032c  */
    /* JADX WARN: Code duplicated, block: B:132:0x0346 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:135:0x034d  */
    /* JADX WARN: Code duplicated, block: B:65:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:83:0x021b  */
    /* JADX WARN: Multi-variable type inference failed */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r10v12 java.lang.Object, still in use, count: 2, list:
          (r10v12 java.lang.Object) from 0x01c6: PHI (r10 I:??) = (r10v8 java.lang.Object), (r10v12 java.lang.Object) binds: [B:55:0x01c5, B:223:0x01c6] A[DONT_GENERATE, DONT_INLINE]
          (r10v12 java.lang.Object) from 0x01b8: CHECK_CAST (kotlin.Pair) (r10v12 java.lang.Object)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    @Override // kotlin.jvm.functions.Function2
    public final java.lang.Object invoke(java.lang.Object r27, java.lang.Object r28) {
        /*
            Method dump skipped, instruction units count: 1376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: lc.a.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public /* synthetic */ a(b bVar, Function1 function1) {
        this.f7358a = 0;
        this.f7359b = function1;
    }

    public /* synthetic */ a(r4 r4Var, y4 y4Var) {
        this.f7358a = 6;
        this.f7359b = r4Var;
    }
}
