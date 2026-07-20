package ag;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringBuilderJVMKt;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends nh.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f772h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(int i8, int i9) {
        super(i8);
        this.f772h = i9;
    }

    @Override // nh.c
    public Object a(Object obj) {
        switch (this.f772h) {
            case 0:
                StringBuilder instance = (StringBuilder) obj;
                Intrinsics.checkNotNullParameter(instance, "instance");
                StringsKt__StringBuilderJVMKt.clear(instance);
                return instance;
            default:
                super.a(obj);
                return obj;
        }
    }

    @Override // nh.c
    public final Object c() {
        switch (this.f772h) {
            case 0:
                return new StringBuilder(128);
            case 1:
                return new int[512];
            case 2:
                return new char[2048];
            default:
                return new byte[4096];
        }
    }
}
