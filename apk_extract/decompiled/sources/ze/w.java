package ze;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
public abstract class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f11460a;

    static {
        x w2Var;
        AtomicReference atomicReference = new AtomicReference();
        try {
            w2Var = (x) Class.forName("io.grpc.override.ContextStorageOverride").asSubclass(x.class).getConstructor(null).newInstance(null);
        } catch (ClassNotFoundException e) {
            atomicReference.set(e);
            w2Var = new w2();
        } catch (Exception e4) {
            throw new RuntimeException("Storage override failed to initialize", e4);
        }
        f11460a = w2Var;
        Throwable th2 = (Throwable) atomicReference.get();
        if (th2 != null) {
            y.f11473d.log(Level.FINE, "Storage override doesn't exist. Using default", th2);
        }
    }
}
