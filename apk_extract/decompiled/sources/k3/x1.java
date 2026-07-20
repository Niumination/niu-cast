package k3;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class x1 {
    public static void a(ArrayList arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != 1) {
            throw new dk.c(arrayList);
        }
        Throwable th2 = (Throwable) arrayList.get(0);
        if (th2 instanceof RuntimeException) {
            throw ((RuntimeException) th2);
        }
        if (!(th2 instanceof Error)) {
            throw new RuntimeException(th2);
        }
        throw ((Error) th2);
    }

    public static void b(Throwable th2) {
        if (th2 instanceof dk.g) {
            throw ((dk.g) th2);
        }
        if (th2 instanceof dk.f) {
            throw ((dk.f) th2);
        }
        if (th2 instanceof dk.e) {
            throw ((dk.e) th2);
        }
        if (th2 instanceof StackOverflowError) {
            throw ((StackOverflowError) th2);
        }
        if (th2 instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th2);
        }
        if (th2 instanceof ThreadDeath) {
            throw ((ThreadDeath) th2);
        }
        if (th2 instanceof LinkageError) {
            throw ((LinkageError) th2);
        }
    }

    public static void c(Throwable th2, ck.d dVar, Object obj) {
        b(th2);
        dVar.onError(dk.j.addValueAsLastCause(th2, obj));
    }
}
