package y4;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Field f11038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11039c;

    public c0(String str, Field field) {
        this.f11037a = str;
        this.f11038b = field;
        this.f11039c = field.getName();
    }

    public abstract void a(d5.d dVar, Object obj);
}
