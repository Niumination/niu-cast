package kotlin.text;

import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CharSequence f7063b;

    public /* synthetic */ c(CharSequence charSequence, int i8) {
        this.f7062a = i8;
        this.f7063b = charSequence;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i8 = this.f7062a;
        CharSequence charSequence = this.f7063b;
        IntRange intRange = (IntRange) obj;
        switch (i8) {
            case 0:
                return StringsKt__StringsKt.splitToSequence$lambda$20$StringsKt__StringsKt(charSequence, intRange);
            default:
                return StringsKt__StringsKt.splitToSequence$lambda$18$StringsKt__StringsKt(charSequence, intRange);
        }
    }
}
