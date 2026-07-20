package ri;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f14497a = "RemoteConfig";

    /* JADX INFO: renamed from: ri.a$a, reason: collision with other inner class name */
    public class C0352a extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f14498a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f14499b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0352a(Handler handler, Context context, String str) {
            super(handler);
            this.f14498a = context;
            this.f14499b = str;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            super.onChange(z10);
            a.this.a(b.c(this.f14498a, this.f14499b));
        }
    }

    public a(Context context, String str) {
        context.getContentResolver().registerContentObserver(b.d(str), false, new C0352a(new Handler(Looper.getMainLooper()), context, str));
    }

    public void a(String str) {
    }
}
