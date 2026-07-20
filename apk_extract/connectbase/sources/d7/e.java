package d7;

import android.content.Context;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import java.lang.reflect.Method;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public class e implements of.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f3623c = "TranAospTypefaceManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Class<?> f3624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f3625b;

    public e(Looper looper) {
        Class<?> clsA = cc.a.a("com.transsion.hubsdk.graphics.TranTypefaceManager");
        this.f3624a = clsA;
        this.f3625b = null;
        if (clsA != null) {
            try {
                this.f3625b = cc.a.c(clsA, new Class[]{Context.class, Looper.class}).newInstance(bc.a.a(), looper);
            } catch (Exception e10) {
                p6.b.a("Instance TranTypefaceManager fail : ", e10, f3623c);
            }
        }
    }

    @Override // of.e
    public void a(Consumer<Exception> consumer) {
        Class<?> cls;
        Method methodG;
        if (this.f3625b == null || (cls = this.f3624a) == null || (methodG = cc.a.g(cls, "setOSFont", Consumer.class)) == null) {
            return;
        }
        cc.a.j(methodG, this.f3625b, consumer);
    }

    @Override // of.e
    public void b(ParcelFileDescriptor parcelFileDescriptor, String str, Consumer<Exception> consumer) {
        Class<?> cls;
        Method methodG;
        if (this.f3625b == null || (cls = this.f3624a) == null || (methodG = cc.a.g(cls, "setSystemFont", ParcelFileDescriptor.class, String.class, Consumer.class)) == null) {
            return;
        }
        cc.a.j(methodG, this.f3625b, parcelFileDescriptor, str, consumer);
    }

    @Override // of.e
    public void c(BiConsumer<String, Exception> biConsumer) {
        Class<?> cls;
        Method methodG;
        if (this.f3625b == null || (cls = this.f3624a) == null || (methodG = cc.a.g(cls, "getCurrentSystemFontHashCode", BiConsumer.class)) == null) {
            return;
        }
        cc.a.j(methodG, this.f3625b, biConsumer);
    }

    @Override // of.e
    public void close() {
        Class<?> cls;
        Method methodG;
        if (this.f3625b == null || (cls = this.f3624a) == null || (methodG = cc.a.g(cls, "close", new Class[0])) == null) {
            return;
        }
        cc.a.j(methodG, this.f3625b, new Object[0]);
    }

    @Override // of.e
    public void d(BiConsumer<Boolean, Exception> biConsumer) {
        Class<?> cls;
        Method methodG;
        if (this.f3625b == null || (cls = this.f3624a) == null || (methodG = cc.a.g(cls, "hasOSFont", BiConsumer.class)) == null) {
            return;
        }
        cc.a.j(methodG, this.f3625b, biConsumer);
    }

    @Override // of.e
    public void e(BiConsumer<Integer, Exception> biConsumer) {
        Class<?> cls;
        Method methodG;
        if (this.f3625b == null || (cls = this.f3624a) == null || (methodG = cc.a.g(cls, "getSystemFontConfig", BiConsumer.class)) == null) {
            return;
        }
        cc.a.j(methodG, this.f3625b, biConsumer);
    }

    @Override // of.e
    public boolean open() {
        Class<?> cls;
        Method methodG;
        if (this.f3625b == null || (cls = this.f3624a) == null || (methodG = cc.a.g(cls, "open", new Class[0])) == null) {
            return false;
        }
        return ((Boolean) cc.a.j(methodG, this.f3625b, new Object[0])).booleanValue();
    }
}
