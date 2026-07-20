package kotlin.text;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7060b;

    public /* synthetic */ a(String str, int i8) {
        this.f7059a = i8;
        this.f7060b = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i8 = this.f7059a;
        String str = this.f7060b;
        String str2 = (String) obj;
        switch (i8) {
            case 0:
                return StringsKt__IndentKt.prependIndent$lambda$5$StringsKt__IndentKt(str, str2);
            default:
                return StringsKt__IndentKt.getIndentFunction$lambda$9$StringsKt__IndentKt(str, str2);
        }
    }
}
