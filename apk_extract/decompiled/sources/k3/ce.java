package k3;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ce implements u4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f6400b;

    public /* synthetic */ ce(Object obj, int i8) {
        this.f6399a = i8;
        this.f6400b = obj;
    }

    @Override // u4.a
    public final Object get() {
        switch (this.f6399a) {
            case 0:
                return ((qf.c) this.f6400b).x(new a2.b("json"), fe.e);
            case 1:
                return ((qf.c) this.f6400b).x(new a2.b("proto"), fe.f6447d);
            case 2:
                return ((qf.c) this.f6400b).x(new a2.b("json"), m3.sa.e);
            case 3:
                return ((qf.c) this.f6400b).x(new a2.b("proto"), m3.sa.f7858d);
            default:
                String str = (String) this.f6400b;
                try {
                    Class<?> cls = Class.forName(str);
                    if (o4.d.class.isAssignableFrom(cls)) {
                        return (o4.d) cls.getDeclaredConstructor(null).newInstance(null);
                    }
                    throw new o4.n("Class " + str + " is not an instance of com.google.firebase.components.ComponentRegistrar");
                } catch (ClassNotFoundException unused) {
                    Log.w("ComponentDiscovery", "Class " + str + " is not an found.");
                    return null;
                } catch (IllegalAccessException e) {
                    throw new o4.n(h0.a.j("Could not instantiate ", str, "."), e);
                } catch (InstantiationException e4) {
                    throw new o4.n(h0.a.j("Could not instantiate ", str, "."), e4);
                } catch (NoSuchMethodException e10) {
                    throw new o4.n(h0.a.i("Could not instantiate ", str), e10);
                } catch (InvocationTargetException e11) {
                    throw new o4.n(h0.a.i("Could not instantiate ", str), e11);
                }
        }
    }
}
