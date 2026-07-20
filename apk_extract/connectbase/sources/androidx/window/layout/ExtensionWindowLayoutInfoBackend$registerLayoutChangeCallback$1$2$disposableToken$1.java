package androidx.window.layout;

import jn.l;
import kn.l0;
import kn.n0;
import lm.l2;

/* JADX INFO: loaded from: classes.dex */
public final class ExtensionWindowLayoutInfoBackend$registerLayoutChangeCallback$1$2$disposableToken$1 extends n0 implements l<androidx.window.extensions.layout.WindowLayoutInfo, l2> {
    final /* synthetic */ ExtensionWindowLayoutInfoBackend.MulticastConsumer $consumer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtensionWindowLayoutInfoBackend$registerLayoutChangeCallback$1$2$disposableToken$1(ExtensionWindowLayoutInfoBackend.MulticastConsumer multicastConsumer) {
        super(1);
        this.$consumer = multicastConsumer;
    }

    @Override // jn.l
    public /* bridge */ /* synthetic */ l2 invoke(androidx.window.extensions.layout.WindowLayoutInfo windowLayoutInfo) {
        invoke2(windowLayoutInfo);
        return l2.f10208a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@os.l androidx.window.extensions.layout.WindowLayoutInfo windowLayoutInfo) {
        l0.p(windowLayoutInfo, "value");
        this.$consumer.accept(windowLayoutInfo);
    }
}
