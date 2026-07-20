package jf;

import ag.d0;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import li.o1;
import li.p1;
import mf.k;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h {
    public static final d a(k engineFactory, Function1 block) {
        Intrinsics.checkNotNullParameter(engineFactory, "engineFactory");
        Intrinsics.checkNotNullParameter(block, "block");
        e eVar = new e();
        block.invoke(eVar);
        Function1 block2 = eVar.f6268d;
        ((nf.a) engineFactory).getClass();
        Intrinsics.checkNotNullParameter(block2, "block");
        nf.f fVar = new nf.f();
        block2.invoke(fVar);
        nf.e eVar2 = new nf.e(fVar);
        d dVar = new d(eVar2, eVar);
        CoroutineContext.Element element = dVar.f6258d.get(o1.f7483a);
        Intrinsics.checkNotNull(element);
        ((p1) element).A(new d0(eVar2, 16));
        return dVar;
    }
}
