package af;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g2 implements a1 {
    static {
        try {
            Class.forName("javax.naming.directory.InitialDirContext");
            Class.forName("com.sun.jndi.dns.DnsContextFactory");
        } catch (ClassNotFoundException | Error | RuntimeException unused) {
        }
    }
}
