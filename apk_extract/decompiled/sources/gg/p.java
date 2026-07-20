package gg;

import java.nio.channels.SocketChannel;
import jh.g0;
import jh.o0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import li.f0;
import li.v0;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class p implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f5192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ jh.k f5193c;

    public /* synthetic */ p(u uVar, jh.k kVar, int i8) {
        this.f5191a = i8;
        this.f5192b = uVar;
        this.f5193c = kVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f5191a) {
            case 0:
                u selectable = this.f5192b;
                SocketChannel nioChannel = selectable.f5203m;
                Intrinsics.checkNotNullParameter(selectable, "<this>");
                jh.k channel = this.f5193c;
                Intrinsics.checkNotNullParameter(channel, "channel");
                Intrinsics.checkNotNullParameter(nioChannel, "nioChannel");
                Intrinsics.checkNotNullParameter(selectable, "selectable");
                fg.u selector = selectable.e;
                Intrinsics.checkNotNullParameter(selector, "selector");
                v0 v0Var = v0.f7498a;
                return g0.p(selectable, si.e.f10118a.plus(new f0("cio-to-nio-writer")), channel, new j(selectable, selectable.f5198h, channel, selector, nioChannel, null));
            default:
                u selectable2 = this.f5192b;
                selectable2.getClass();
                jh.k channel2 = this.f5193c;
                Intrinsics.checkNotNullParameter(selectable2, "<this>");
                Intrinsics.checkNotNullParameter(channel2, "channel");
                SocketChannel nioChannel2 = selectable2.f5203m;
                Intrinsics.checkNotNullParameter(nioChannel2, "nioChannel");
                Intrinsics.checkNotNullParameter(selectable2, "selectable");
                fg.u selector2 = selectable2.e;
                Intrinsics.checkNotNullParameter(selector2, "selector");
                v0 v0Var2 = v0.f7498a;
                return o0.f(selectable2, si.e.f10118a.plus(new f0("cio-from-nio-reader")), channel2, new f(selectable2, selectable2.f5198h, channel2, nioChannel2, selector2, null));
        }
    }
}
