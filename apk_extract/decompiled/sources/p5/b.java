package p5;

import android.content.Context;
import android.util.Log;
import o4.u;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements q3.c, o4.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ b f8666b = new b(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ b f8667c = new b(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ b f8668d = new b(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8669a;

    public /* synthetic */ b(int i8) {
        this.f8669a = i8;
    }

    @Override // o4.c
    public Object a(u uVar) {
        return new i((Context) uVar.a(Context.class));
    }

    @Override // q3.c
    public void b(Exception exc) {
        switch (this.f8669a) {
            case 1:
                Log.e("OptionalModuleUtils", "Failed to check feature availability", exc);
                break;
            default:
                Log.e("OptionalModuleUtils", "Failed to request modules install request", exc);
                break;
        }
    }
}
