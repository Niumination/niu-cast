package js;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f8900a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<Object, b> f8901b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: js.a$a, reason: collision with other inner class name */
    public interface InterfaceC0232a extends b {
        List<String> protocols();

        void selected(String str) throws SSLException;

        void unsupported();
    }

    public interface b {
    }

    public interface c extends b {
        String select(List<String> list) throws SSLException;

        void unsupported();
    }

    public static b a(SSLEngine sSLEngine) {
        return f8901b.get(sSLEngine);
    }

    public static b b(SSLSocket sSLSocket) {
        return f8901b.get(sSLSocket);
    }

    public static void c(SSLEngine sSLEngine, b bVar) {
        f8901b.put(sSLEngine, bVar);
    }

    public static void d(SSLSocket sSLSocket, b bVar) {
        f8901b.put(sSLSocket, bVar);
    }

    public static b e(SSLEngine sSLEngine) {
        return f8901b.remove(sSLEngine);
    }

    public static b f(SSLSocket sSLSocket) {
        return f8901b.remove(sSLSocket);
    }
}
