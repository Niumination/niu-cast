package dk;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends RuntimeException {
    private static final long serialVersionUID = -3454462756050397899L;
    private final Object value;

    public i(Object obj) {
        super("OnError while emitting onNext value: " + renderValue(obj));
        this.value = obj;
    }

    public static String renderValue(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (h.f4656a.contains(obj.getClass())) {
            return obj.toString();
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Enum) {
            return ((Enum) obj).name();
        }
        nk.c.f8331d.a().getClass();
        return obj.getClass().getName().concat(".class");
    }

    public Object getValue() {
        return this.value;
    }
}
