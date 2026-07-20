package f6;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f5889a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Toast f5890b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Field f5891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Field f5892d;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f5893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f5894b;

        public a(int i10, Context context) {
            this.f5893a = i10;
            this.f5894b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (i.f5890b != null) {
                i.f5890b.setText(this.f5893a);
                i.f5890b.setDuration(0);
                i.d(i.f5890b);
            } else {
                i.f5890b = Toast.makeText(this.f5894b.getApplicationContext(), this.f5893a, 0);
            }
            i.f5890b.show();
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f5895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f5896b;

        public b(String str, Context context) {
            this.f5895a = str;
            this.f5896b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (i.f5890b != null) {
                i.f5890b.setText(this.f5895a);
                i.f5890b.setDuration(0);
                i.d(i.f5890b);
            } else {
                i.f5890b = Toast.makeText(this.f5896b.getApplicationContext(), this.f5895a, 0);
            }
            i.f5890b.show();
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f5897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f5898b;

        public c(int i10, Context context) {
            this.f5897a = i10;
            this.f5898b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (i.f5890b != null) {
                i.f5890b.setText(this.f5897a);
                i.f5890b.setDuration(1);
                i.d(i.f5890b);
            } else {
                i.f5890b = Toast.makeText(this.f5898b.getApplicationContext(), this.f5897a, 1);
            }
            i.f5890b.show();
        }
    }

    public static class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f5899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f5900b;

        public d(String str, Context context) {
            this.f5899a = str;
            this.f5900b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (i.f5890b != null) {
                i.f5890b.setText(this.f5899a);
                i.f5890b.setDuration(1);
                i.d(i.f5890b);
            } else {
                i.f5890b = Toast.makeText(this.f5900b.getApplicationContext(), this.f5899a, 1);
            }
            i.f5890b.show();
        }
    }

    public static class e extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Handler f5901a;

        public e(Handler handler) {
            this.f5901a = handler;
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.f5901a.handleMessage(message);
        }
    }

    static {
        try {
            Field declaredField = Toast.class.getDeclaredField("mTN");
            f5891c = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = f5891c.getType().getDeclaredField("mHandler");
            f5892d = declaredField2;
            declaredField2.setAccessible(true);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void d(Toast toast) {
        try {
            Object obj = f5891c.get(toast);
            Handler handler = (Handler) f5892d.get(obj);
            if (handler == null || (handler instanceof e)) {
                return;
            }
            f5892d.set(obj, new e(handler));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void e(int i10) {
        Context contextA = b6.b.a();
        if (i10 <= 0) {
            return;
        }
        f5889a.post(new c(i10, contextA));
    }

    public static void f(String str) {
        Context contextA = b6.b.a();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f5889a.post(new d(str, contextA));
    }

    public static void g(int i10) {
        Context contextA = b6.b.a();
        if (i10 <= 0) {
            return;
        }
        f5889a.post(new a(i10, contextA));
    }

    public static void h(String str) {
        Context contextA = b6.b.a();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f5889a.post(new b(str, contextA));
    }
}
