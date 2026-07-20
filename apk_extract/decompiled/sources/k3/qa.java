package k3;

/* JADX INFO: loaded from: classes.dex */
public abstract class qa {
    public static int a(Object obj) {
        return (int) (((long) Integer.rotateLeft((int) (((long) (obj == null ? 0 : obj.hashCode())) * (-862048943)), 15)) * 461845907);
    }
}
