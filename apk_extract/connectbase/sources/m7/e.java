package m7;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
public class e implements xf.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f10583b = "e";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f10584c = cc.a.a("com.android.internal.app.AssistUtils");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f10585a = bc.a.a();

    public class a implements d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ da.c.a f10586a;

        public a(da.c.a aVar) {
            this.f10586a = aVar;
        }

        @Override // m7.d.a
        public void a() {
            da.c.a aVar = this.f10586a;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // m7.d.a
        public void onShown() {
            da.c.a aVar = this.f10586a;
            if (aVar != null) {
                aVar.onShown();
            }
        }
    }

    @Override // xf.b
    public boolean a(Bundle bundle, int i10, da.c.a aVar, IBinder iBinder) {
        return b(bundle, i10, aVar, iBinder);
    }

    @Override // xf.b
    public boolean b(Bundle bundle, int i10, da.c.a aVar, IBinder iBinder) {
        return new d(this.f10585a).a(bundle, i10, new a(aVar), iBinder);
    }
}
