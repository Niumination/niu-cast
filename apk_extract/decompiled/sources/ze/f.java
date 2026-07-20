package ze;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import k3.t8;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final f f11346i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f11347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f11348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object[][] f11350d;
    public final List e;
    public final Boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f11351g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f11352h;

    static {
        d dVar = new d();
        dVar.f11338d = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);
        dVar.e = Collections.emptyList();
        f11346i = new f(dVar);
    }

    public f(d dVar) {
        this.f11347a = dVar.f11335a;
        this.f11348b = dVar.f11336b;
        this.f11349c = dVar.f11337c;
        this.f11350d = dVar.f11338d;
        this.e = dVar.e;
        this.f = dVar.f;
        this.f11351g = dVar.f11339g;
        this.f11352h = dVar.f11340h;
    }

    public static d b(f fVar) {
        d dVar = new d();
        dVar.f11335a = fVar.f11347a;
        dVar.f11336b = fVar.f11348b;
        dVar.f11337c = fVar.f11349c;
        dVar.f11338d = fVar.f11350d;
        dVar.e = fVar.e;
        dVar.f = fVar.f;
        dVar.f11339g = fVar.f11351g;
        dVar.f11340h = fVar.f11352h;
        return dVar;
    }

    public final Object a(e eVar) {
        v8.i(eVar, "key");
        int i8 = 0;
        while (true) {
            Object[][] objArr = this.f11350d;
            if (i8 >= objArr.length) {
                return null;
            }
            if (eVar.equals(objArr[i8][0])) {
                return objArr[i8][1];
            }
            i8++;
        }
    }

    public final f c(int i8) {
        v8.b(i8, "invalid maxsize %s", i8 >= 0);
        d dVarB = b(this);
        dVarB.f11339g = Integer.valueOf(i8);
        return new f(dVarB);
    }

    public final f d(int i8) {
        v8.b(i8, "invalid maxsize %s", i8 >= 0);
        d dVarB = b(this);
        dVarB.f11340h = Integer.valueOf(i8);
        return new f(dVarB);
    }

    public final f e(e eVar, Object obj) {
        Object[][] objArr;
        v8.i(eVar, "key");
        v8.i(obj, "value");
        d dVarB = b(this);
        int i8 = 0;
        while (true) {
            objArr = this.f11350d;
            if (i8 >= objArr.length) {
                i8 = -1;
                break;
            }
            if (eVar.equals(objArr[i8][0])) {
                break;
            }
            i8++;
        }
        Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, objArr.length + (i8 == -1 ? 1 : 0), 2);
        dVarB.f11338d = objArr2;
        System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        if (i8 == -1) {
            dVarB.f11338d[objArr.length] = new Object[]{eVar, obj};
        } else {
            dVarB.f11338d[i8] = new Object[]{eVar, obj};
        }
        return new f(dVarB);
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.d(this.f11347a, "deadline");
        aVarA.d(null, "authority");
        aVarA.d(null, "callCredentials");
        Executor executor = this.f11348b;
        aVarA.d(executor != null ? executor.getClass() : null, "executor");
        aVarA.d(this.f11349c, "compressorName");
        aVarA.d(Arrays.deepToString(this.f11350d), "customOptions");
        aVarA.f("waitForReady", Boolean.TRUE.equals(this.f));
        aVarA.d(this.f11351g, "maxInboundMessageSize");
        aVarA.d(this.f11352h, "maxOutboundMessageSize");
        aVarA.d(this.e, "streamTracerFactories");
        return aVarA.toString();
    }
}
