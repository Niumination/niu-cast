package ka;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f6807a;

    static {
        boolean z2;
        b bVar = new b();
        bVar.f6808a = null;
        bVar.f6809b = true;
        bVar.f6810c = true;
        bVar.f6811d = true;
        char[] cArr = c.f6812b;
        int i8 = 0;
        while (true) {
            if (i8 >= 12) {
                z2 = true;
                break;
            } else {
                if (!Character.isWhitespace("gateway_core".charAt(i8))) {
                    z2 = false;
                    break;
                }
                i8++;
            }
        }
        if (z2) {
            bVar.f6808a = "";
            bVar.f6809b = true;
        } else {
            bVar.f6808a = "gateway_core";
            bVar.f6809b = false;
        }
        bVar.f6810c = false;
        bVar.f6811d = false;
        f6807a = new c(bVar);
    }
}
