package oq;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import nq.o0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends um.a implements o0 {

    @m
    private volatile Object _preHandler;

    public b() {
        super(o0.f11887j);
        this._preHandler = this;
    }

    public final Method f0() {
        Object obj = this._preHandler;
        if (obj != this) {
            return (Method) obj;
        }
        Method method = null;
        try {
            Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", null);
            if (Modifier.isPublic(declaredMethod.getModifiers()) && Modifier.isStatic(declaredMethod.getModifiers())) {
                method = declaredMethod;
            }
        } catch (Throwable unused) {
        }
        this._preHandler = method;
        return method;
    }

    @Override // nq.o0
    public void g0(@l um.g gVar, @l Throwable th2) {
    }
}
