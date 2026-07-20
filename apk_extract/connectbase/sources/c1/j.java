package c1;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@b1.d
@k
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Double f1190a = Double.valueOf(0.0d);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Float f1191b = Float.valueOf(0.0f);

    @gm.a
    public static <T> T a(Class<T> cls) {
        cls.getClass();
        if (!cls.isPrimitive()) {
            return null;
        }
        if (cls == Boolean.TYPE) {
            return (T) Boolean.FALSE;
        }
        if (cls == Character.TYPE) {
            return (T) (char) 0;
        }
        if (cls == Byte.TYPE) {
            return (T) (byte) 0;
        }
        if (cls == Short.TYPE) {
            return (T) (short) 0;
        }
        if (cls == Integer.TYPE) {
            return (T) 0;
        }
        if (cls == Long.TYPE) {
            return (T) 0L;
        }
        if (cls == Float.TYPE) {
            return (T) f1191b;
        }
        if (cls == Double.TYPE) {
            return (T) f1190a;
        }
        return null;
    }
}
