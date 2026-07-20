package rh;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends RuntimeException {
    static final String MESSAGE = "Chain of Causes for CompositeException In Order Received =>";
    private static final long serialVersionUID = 3875212506787802066L;

    @Override // java.lang.Throwable
    public String getMessage() {
        return MESSAGE;
    }
}
