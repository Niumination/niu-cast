package nf;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import li.i2;
import li.j0;
import li.j1;
import li.l0;
import li.o1;
import li.p1;
import li.r1;
import pf.z0;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends mf.h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f8209d;
    public final Set e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final bh.c f8210h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final h f8211i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CoroutineContext f8212j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CoroutineContext f8213k;

    public e(f config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.f8209d = config;
        this.e = SetsKt.setOf((Object[]) new mf.i[]{z0.f8882a, uf.f.f10427a, uf.i.f10430a, tf.a.f10216a});
        this.f8210h = new bh.c();
        li.a0 dispatcher = (li.a0) this.f8035a.getValue();
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        fg.e eVar = new fg.e(dispatcher);
        this.f8211i = new h(eVar, config.f8216c);
        CoroutineContext coroutineContext = super.getCoroutineContext();
        o1 o1Var = o1.f7483a;
        CoroutineContext.Element element = coroutineContext.get(o1Var);
        Intrinsics.checkNotNull(element);
        CoroutineContext coroutineContextPlus = CoroutineContext.Element.DefaultImpls.plus(new i2((p1) element), new zg.i(li.b0.f7433a));
        this.f8212j = coroutineContextPlus;
        this.f8213k = coroutineContext.plus(coroutineContextPlus);
        CoroutineContext.Element element2 = coroutineContextPlus.get(o1Var);
        Intrinsics.checkNotNull(element2);
        l0.o(j1.f7459a, coroutineContext, j0.ATOMIC, new c((p1) element2, eVar, null));
    }

    @Override // mf.h, mf.f
    public final Set V() {
        return this.e;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v14, types: [nf.p] */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v2, types: [nf.p] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v8, types: [nf.p] */
    /* JADX WARN: Type inference failed for: r14v15, types: [kotlin.coroutines.CoroutineContext] */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v4, types: [java.lang.Object, kotlin.coroutines.CoroutineContext] */
    /* JADX WARN: Type inference failed for: r14v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r15v16, types: [java.lang.Object, nf.p] */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v18, types: [nf.p] */
    /* JADX WARN: Type inference failed for: r15v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:48:0x00fe
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public final java.lang.Object a(vf.d r14, kotlin.coroutines.jvm.internal.ContinuationImpl r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: nf.e.a(vf.d, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // mf.h, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        super.close();
        Iterator it = this.f8210h.entrySet().iterator();
        while (it.hasNext()) {
            ((p) ((Map.Entry) it.next()).getValue()).close();
        }
        CoroutineContext.Element element = this.f8212j.get(o1.f7483a);
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type kotlinx.coroutines.CompletableJob");
        ((r1) ((li.s) element)).r0();
    }

    @Override // mf.h, li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f8213k;
    }
}
