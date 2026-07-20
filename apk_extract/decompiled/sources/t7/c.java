package t7;

import kotlin.coroutines.CoroutineContext;
import li.g0;
import li.h0;
import li.i2;
import li.l0;
import li.v0;
import na.g;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements g0 {
    public static long e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ qi.c f10194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f10195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f10196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f10197d;

    public c() {
        i2 i2VarD = l0.d();
        v0 v0Var = v0.f7498a;
        this.f10194a = h0.a(CoroutineContext.Element.DefaultImpls.plus(i2VarD, si.e.f10118a));
        this.f10195b = new String[]{"screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};
        this.f10196c = new String[]{"camera"};
        this.f10197d = new g(this);
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f10194a.f9137a;
    }
}
