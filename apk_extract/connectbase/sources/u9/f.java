package u9;

import android.os.Looper;
import android.os.ParcelFileDescriptor;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f16231d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f16232e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f16233f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f16234g = "f";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vc.f f16235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d7.e f16236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Looper f16237c;

    public f(Looper looper) {
        this.f16237c = looper;
    }

    public void a() {
        if (fc.a.g()) {
            c(fc.b.a.f6003w).close();
        }
    }

    public void b(BiConsumer<String, Exception> biConsumer) {
        if (fc.a.g()) {
            c(fc.b.a.f6003w).c(biConsumer);
        }
    }

    public of.e c(String str) {
        if (this.f16237c == null) {
            dc.e.c(f16234g, "Looper is null");
        }
        if (fc.b.b(str)) {
            vc.f fVar = this.f16235a;
            if (fVar != null) {
                return fVar;
            }
            vc.f fVar2 = new vc.f(this.f16237c);
            this.f16235a = fVar2;
            return fVar2;
        }
        dc.e.f(f16234g, d7.e.f3623c);
        d7.e eVar = this.f16236b;
        if (eVar != null) {
            return eVar;
        }
        d7.e eVar2 = new d7.e(this.f16237c);
        this.f16236b = eVar2;
        return eVar2;
    }

    public void d(BiConsumer<Integer, Exception> biConsumer) {
        if (fc.a.g()) {
            c(fc.b.a.f6003w).e(biConsumer);
        }
    }

    public void e(BiConsumer<Boolean, Exception> biConsumer) {
        if (fc.a.g()) {
            c(fc.b.a.f6003w).d(biConsumer);
        }
    }

    public boolean f() {
        if (fc.a.g()) {
            return c(fc.b.a.f6003w).open();
        }
        return false;
    }

    public void g(Consumer<Exception> consumer) {
        if (fc.a.g()) {
            c(fc.b.a.f6003w).a(consumer);
        }
    }

    public void h(ParcelFileDescriptor parcelFileDescriptor, String str, Consumer<Exception> consumer) {
        if (fc.a.g()) {
            c(fc.b.a.f6003w).b(parcelFileDescriptor, str, consumer);
        }
    }
}
