package ja;

import android.content.Context;
import fc.b;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f8628c = 1000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kd.a f8629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s7.a f8630b;

    public String a(int i10) {
        return c(b.a.f5992l).b(i10);
    }

    public Locale b(Context context, int i10, String str) {
        if (context == null || i10 < 0 || i10 >= 1000) {
            throw new IllegalArgumentException("arguement is illegal");
        }
        if (this.f8630b == null) {
            this.f8630b = new s7.a();
        }
        return this.f8630b.a(context, i10, str);
    }

    public dg.a c(String str) {
        if (b.b(str)) {
            kd.a aVar = this.f8629a;
            if (aVar != null) {
                return aVar;
            }
            kd.a aVar2 = new kd.a();
            this.f8629a = aVar2;
            return aVar2;
        }
        s7.a aVar3 = this.f8630b;
        if (aVar3 != null) {
            return aVar3;
        }
        s7.a aVar4 = new s7.a();
        this.f8630b = aVar4;
        return aVar4;
    }
}
