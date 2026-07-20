package vc;

import android.os.Looper;
import android.os.ParcelFileDescriptor;
import com.transsion.hubsdk.graphics.TranTypefaceManager;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public class f implements of.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f16897b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f16898c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f16899d = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranTypefaceManager f16900a;

    public f(Looper looper) {
        this.f16900a = new TranTypefaceManager(bc.a.a(), looper);
    }

    @Override // of.e
    public void a(Consumer<Exception> consumer) {
        TranTypefaceManager tranTypefaceManager = this.f16900a;
        if (tranTypefaceManager != null) {
            tranTypefaceManager.setOSFont(consumer);
        }
    }

    @Override // of.e
    public void b(ParcelFileDescriptor parcelFileDescriptor, String str, Consumer<Exception> consumer) {
        TranTypefaceManager tranTypefaceManager = this.f16900a;
        if (tranTypefaceManager != null) {
            tranTypefaceManager.setSystemFont(parcelFileDescriptor, str, consumer);
        }
    }

    @Override // of.e
    public void c(BiConsumer<String, Exception> biConsumer) {
        TranTypefaceManager tranTypefaceManager = this.f16900a;
        if (tranTypefaceManager != null) {
            tranTypefaceManager.getCurrentSystemFontHashCode(biConsumer);
        }
    }

    @Override // of.e
    public void close() {
        TranTypefaceManager tranTypefaceManager = this.f16900a;
        if (tranTypefaceManager != null) {
            tranTypefaceManager.close();
        }
    }

    @Override // of.e
    public void d(BiConsumer<Boolean, Exception> biConsumer) {
        TranTypefaceManager tranTypefaceManager = this.f16900a;
        if (tranTypefaceManager != null) {
            tranTypefaceManager.hasOSFont(biConsumer);
        }
    }

    @Override // of.e
    public void e(BiConsumer<Integer, Exception> biConsumer) {
        TranTypefaceManager tranTypefaceManager = this.f16900a;
        if (tranTypefaceManager != null) {
            tranTypefaceManager.getSystemFontConfig(biConsumer);
        }
    }

    @Override // of.e
    public boolean open() {
        TranTypefaceManager tranTypefaceManager = this.f16900a;
        if (tranTypefaceManager != null) {
            return tranTypefaceManager.open();
        }
        return false;
    }
}
