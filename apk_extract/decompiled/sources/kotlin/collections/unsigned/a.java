package kotlin.collections.unsigned;

import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7000b;

    public /* synthetic */ a(Object obj, int i8) {
        this.f6999a = i8;
        this.f7000b = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i8 = this.f6999a;
        Object obj = this.f7000b;
        switch (i8) {
            case 0:
                return UIntArray.m318iteratorimpl((int[]) obj);
            case 1:
                return ULongArray.m397iteratorimpl((long[]) obj);
            case 2:
                return UByteArray.m239iteratorimpl((byte[]) obj);
            default:
                return UShortArray.m502iteratorimpl((short[]) obj);
        }
    }
}
