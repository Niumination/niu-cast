package dk;

import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends RuntimeException {
    private static final long serialVersionUID = -569558213262703934L;
    private final boolean hasValue;
    private final Object value;

    public j(Throwable th2) {
        super(th2);
        this.hasValue = false;
        this.value = null;
    }

    public static Throwable addValueAsLastCause(Throwable th2, Object obj) {
        if (th2 == null) {
            th2 = new NullPointerException();
        }
        int i8 = 0;
        Throwable runtimeException = th2;
        int i9 = 0;
        while (runtimeException.getCause() != null) {
            int i10 = i9 + 1;
            if (i9 >= 25) {
                runtimeException = new RuntimeException("Stack too deep to get final cause");
                break;
            }
            runtimeException = runtimeException.getCause();
            i9 = i10;
        }
        if ((runtimeException instanceof i) && ((i) runtimeException).getValue() == obj) {
            return th2;
        }
        i iVar = new i(obj);
        HashSet hashSet = new HashSet();
        Throwable cause = th2;
        try {
            while (cause.getCause() != null) {
                int i11 = i8 + 1;
                if (i8 < 25) {
                    cause = cause.getCause();
                    if (hashSet.contains(cause.getCause())) {
                        break;
                    }
                    hashSet.add(cause.getCause());
                    i8 = i11;
                }
                return th2;
            }
            cause.initCause(iVar);
        } catch (Throwable unused) {
        }
        return th2;
    }

    public static j from(Throwable th2) {
        if (th2 == null) {
            th2 = new NullPointerException();
        }
        int i8 = 0;
        Throwable runtimeException = th2;
        while (runtimeException.getCause() != null) {
            int i9 = i8 + 1;
            if (i8 >= 25) {
                runtimeException = new RuntimeException("Stack too deep to get final cause");
                break;
            }
            runtimeException = runtimeException.getCause();
            i8 = i9;
        }
        return runtimeException instanceof i ? new j(th2, ((i) runtimeException).getValue()) : new j(th2);
    }

    public Object getValue() {
        return this.value;
    }

    public boolean isValueNull() {
        return this.hasValue;
    }

    public j(Throwable th2, Object obj) {
        super(th2);
        this.hasValue = true;
        this.value = obj;
    }
}
