package qh;

import m3.a0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f9127a = 0;

    static {
        Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());
    }

    public final void a(b bVar) {
        try {
            ((uh.a) bVar).onSubscribe(new vh.a(bVar, ((th.a) this).f10218b));
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th2) {
            if (th2 instanceof VirtualMachineError) {
                throw ((VirtualMachineError) th2);
            }
            if (th2 instanceof ThreadDeath) {
                throw ((ThreadDeath) th2);
            }
            if (th2 instanceof LinkageError) {
                throw ((LinkageError) th2);
            }
            a0.a(th2);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }
}
