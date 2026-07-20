package mj;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.net.ssl.SSLSocket;
import k3.fb;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class f implements m {
    public static final e f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f8102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f8103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Method f8104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Method f8105d;
    public final Class e;

    static {
        Intrinsics.checkNotNullParameter("com.google.android.gms.org.conscrypt", "packageName");
        f = new e();
    }

    public f(Class sslSocketClass) throws NoSuchMethodException {
        Intrinsics.checkNotNullParameter(sslSocketClass, "sslSocketClass");
        this.e = sslSocketClass;
        Method declaredMethod = sslSocketClass.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        Intrinsics.checkNotNullExpressionValue(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.f8102a = declaredMethod;
        this.f8103b = sslSocketClass.getMethod("setHostname", String.class);
        this.f8104c = sslSocketClass.getMethod("getAlpnSelectedProtocol", null);
        this.f8105d = sslSocketClass.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // mj.m
    public final boolean a(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        return this.e.isInstance(sslSocket);
    }

    @Override // mj.m
    public final String b(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        if (!a(sslSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.f8104c.invoke(sslSocket, null);
            if (bArr == null) {
                return null;
            }
            Charset charset = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(charset, "StandardCharsets.UTF_8");
            return new String(bArr, charset);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (NullPointerException e4) {
            if (Intrinsics.areEqual(e4.getMessage(), "ssl == null")) {
                return null;
            }
            throw e4;
        } catch (InvocationTargetException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // mj.m
    public final void c(SSLSocket sslSocket, String str, List protocols) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        if (a(sslSocket)) {
            try {
                this.f8102a.invoke(sslSocket, Boolean.TRUE);
                if (str != null) {
                    this.f8103b.invoke(sslSocket, str);
                }
                Method method = this.f8105d;
                lj.m mVar = lj.m.f7532a;
                method.invoke(sslSocket, fb.b(protocols));
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e4) {
                throw new AssertionError(e4);
            }
        }
    }

    @Override // mj.m
    public final boolean isSupported() {
        int i8 = lj.b.f7517c;
        return false;
    }
}
