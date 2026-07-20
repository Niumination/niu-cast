package kotlin.io.path;

import java.nio.file.Path;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f7011b;

    public /* synthetic */ a(boolean z2, int i8) {
        this.f7010a = i8;
        this.f7011b = z2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i8 = this.f7010a;
        CopyActionContext copyActionContext = (CopyActionContext) obj;
        Path path = (Path) obj2;
        Path path2 = (Path) obj3;
        boolean z2 = this.f7011b;
        switch (i8) {
            case 0:
                return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$lambda$1$PathsKt__PathRecursiveFunctionsKt(z2, copyActionContext, path, path2);
            default:
                return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$lambda$0$PathsKt__PathRecursiveFunctionsKt(z2, copyActionContext, path, path2);
        }
    }
}
