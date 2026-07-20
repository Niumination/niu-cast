package cg;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import m3.l0;
import m3.z5;
import zf.v;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0 f1678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ag.d f1679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f1680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f1681d;

    public n(Function0 function0, ag.d dVar) {
        this.f1678a = function0;
        this.f1679b = dVar;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        final int i8 = 0;
        this.f1680c = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: cg.k

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ n f1677b;

            {
                this.f1677b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n nVar = this.f1677b;
                switch (i8) {
                    case 0:
                        ag.d dVar2 = nVar.f1679b;
                        String[] strArr = v.f11551a;
                        String value = dVar2.get("Content-Disposition");
                        if (value == null) {
                            return null;
                        }
                        int i9 = zf.e.f11497d;
                        Intrinsics.checkNotNullParameter(value, "value");
                        zf.n nVar2 = (zf.n) CollectionsKt.last(z5.a(value));
                        return new zf.e(nVar2.f11521a, nVar2.f11522b);
                    default:
                        ag.d dVar3 = nVar.f1679b;
                        String[] strArr2 = v.f11551a;
                        String str = dVar3.get("Content-Type");
                        if (str == null) {
                            return null;
                        }
                        zf.i iVar = zf.i.f11505h;
                        return l0.a(str);
                }
            }
        });
        final int i9 = 1;
        this.f1681d = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: cg.k

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ n f1677b;

            {
                this.f1677b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n nVar = this.f1677b;
                switch (i9) {
                    case 0:
                        ag.d dVar2 = nVar.f1679b;
                        String[] strArr = v.f11551a;
                        String value = dVar2.get("Content-Disposition");
                        if (value == null) {
                            return null;
                        }
                        int i10 = zf.e.f11497d;
                        Intrinsics.checkNotNullParameter(value, "value");
                        zf.n nVar2 = (zf.n) CollectionsKt.last(z5.a(value));
                        return new zf.e(nVar2.f11521a, nVar2.f11522b);
                    default:
                        ag.d dVar3 = nVar.f1679b;
                        String[] strArr2 = v.f11551a;
                        String str = dVar3.get("Content-Type");
                        if (str == null) {
                            return null;
                        }
                        zf.i iVar = zf.i.f11505h;
                        return l0.a(str);
                }
            }
        });
    }
}
