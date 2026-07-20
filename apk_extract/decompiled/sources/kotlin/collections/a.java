package kotlin.collections;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6997b;

    public /* synthetic */ a(Object obj, int i8) {
        this.f6996a = i8;
        this.f6997b = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i8 = this.f6996a;
        Object obj = this.f6997b;
        switch (i8) {
            case 0:
                return ArraysKt___ArraysKt.withIndex$lambda$111$ArraysKt___ArraysKt((int[]) obj);
            case 1:
                return ArraysKt___ArraysKt.withIndex$lambda$114$ArraysKt___ArraysKt((double[]) obj);
            case 2:
                return ArraysKt___ArraysKt.withIndex$lambda$116$ArraysKt___ArraysKt((char[]) obj);
            case 3:
                return ArraysKt___ArraysKt.withIndex$lambda$110$ArraysKt___ArraysKt((short[]) obj);
            case 4:
                return ArraysKt___ArraysKt.withIndex$lambda$113$ArraysKt___ArraysKt((float[]) obj);
            case 5:
                return ArraysKt___ArraysKt.withIndex$lambda$115$ArraysKt___ArraysKt((boolean[]) obj);
            case 6:
                return ArraysKt___ArraysKt.withIndex$lambda$112$ArraysKt___ArraysKt((long[]) obj);
            case 7:
                return ArraysKt___ArraysKt.withIndex$lambda$109$ArraysKt___ArraysKt((byte[]) obj);
            case 8:
                return ArraysKt___ArraysKt.withIndex$lambda$108$ArraysKt___ArraysKt((Object[]) obj);
            default:
                return CollectionsKt___CollectionsKt.withIndex$lambda$17$CollectionsKt___CollectionsKt((Iterable) obj);
        }
    }
}
