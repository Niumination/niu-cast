package kotlin.text;

import java.util.List;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f7065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f7066c;

    public /* synthetic */ d(Object obj, boolean z2, int i8) {
        this.f7064a = i8;
        this.f7066c = obj;
        this.f7065b = z2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i8 = this.f7064a;
        CharSequence charSequence = (CharSequence) obj;
        int iIntValue = ((Integer) obj2).intValue();
        switch (i8) {
            case 0:
                return StringsKt__StringsKt.rangesDelimitedBy$lambda$14$StringsKt__StringsKt((char[]) this.f7066c, this.f7065b, charSequence, iIntValue);
            default:
                return StringsKt__StringsKt.rangesDelimitedBy$lambda$16$StringsKt__StringsKt((List) this.f7066c, this.f7065b, charSequence, iIntValue);
        }
    }
}
