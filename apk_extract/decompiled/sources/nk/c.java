package nk;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f8331d = new c();
    public static final b e = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f8332a = new AtomicReference();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f8333b = new AtomicReference();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f8334c;

    public c() {
        new AtomicReference();
        this.f8334c = new AtomicReference();
    }

    public static Object c(Class cls, Properties properties) {
        Properties properties2 = (Properties) properties.clone();
        String simpleName = cls.getSimpleName();
        String property = properties2.getProperty("rxjava.plugin." + simpleName + ".implementation");
        if (property == null) {
            for (Map.Entry entry : properties2.entrySet()) {
                String string = entry.getKey().toString();
                if (string.startsWith("rxjava.plugin.") && string.endsWith(".class") && simpleName.equals(entry.getValue().toString())) {
                    String strJ = h0.a.j("rxjava.plugin.", string.substring(0, string.length() - 6).substring(14), ".impl");
                    String property2 = properties2.getProperty(strJ);
                    if (property2 == null) {
                        throw new RuntimeException(h0.a.k("Implementing class declaration for ", simpleName, " missing: ", strJ));
                    }
                    property = property2;
                    break;
                }
            }
        }
        if (property == null) {
            return null;
        }
        try {
            return Class.forName(property).asSubclass(cls).newInstance();
        } catch (ClassCastException unused) {
            throw new RuntimeException(simpleName + " implementation is not an instance of " + simpleName + ": " + property);
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException(o.d.l(simpleName, " implementation class not found: ", property), e4);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(o.d.l(simpleName, " implementation not able to be accessed: ", property), e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException(o.d.l(simpleName, " implementation not able to be instantiated: ", property), e11);
        }
    }

    public final b a() {
        AtomicReference atomicReference = this.f8332a;
        if (atomicReference.get() == null) {
            Object objC = c(b.class, System.getProperties());
            if (objC == null) {
                atomicReference.compareAndSet(null, e);
            } else {
                atomicReference.compareAndSet(null, (b) objC);
            }
        }
        return (b) atomicReference.get();
    }

    public final a b() {
        AtomicReference atomicReference = this.f8333b;
        if (atomicReference.get() == null) {
            Object objC = c(a.class, System.getProperties());
            if (objC == null) {
                atomicReference.compareAndSet(null, a.f8330a);
            } else {
                atomicReference.compareAndSet(null, (a) objC);
            }
        }
        return (a) atomicReference.get();
    }

    public final d d() {
        AtomicReference atomicReference = this.f8334c;
        if (atomicReference.get() == null) {
            Object objC = c(d.class, System.getProperties());
            if (objC == null) {
                atomicReference.compareAndSet(null, d.f8335a);
            } else {
                atomicReference.compareAndSet(null, (d) objC);
            }
        }
        return (d) atomicReference.get();
    }
}
