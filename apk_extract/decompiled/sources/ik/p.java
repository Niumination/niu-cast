package ik;

import java.security.PrivilegedAction;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements PrivilegedAction {
    @Override // java.security.PrivilegedAction
    public final Object run() {
        return ClassLoader.getSystemClassLoader();
    }
}
