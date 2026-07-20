package p6;

import android.app.Application;

/* JADX INFO: loaded from: classes2.dex */
public class m implements bf.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13003a = "m";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f13004b = cc.a.a("android.app.ActivityThread");

    @Override // bf.h
    public Application a() {
        Object objJ = cc.a.j(cc.a.g(f13004b, "getApplication", new Class[0]), cc.a.j(cc.a.g(f13004b, "currentActivityThread", new Class[0]), null, new Object[0]), new Object[0]);
        if (objJ instanceof Application) {
            return (Application) objJ;
        }
        return null;
    }

    @Override // bf.h
    public Application b() {
        Object objJ = cc.a.j(cc.a.g(f13004b, "currentApplication", new Class[0]), null, new Object[0]);
        if (objJ instanceof Application) {
            return (Application) objJ;
        }
        return null;
    }
}
