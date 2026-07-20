package ka;

import t7.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f9164b = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f9165a;

    /* JADX INFO: renamed from: ka.a$a, reason: collision with other inner class name */
    public interface InterfaceC0239a {
        void onContentChanged();
    }

    public void a(InterfaceC0239a interfaceC0239a) {
        if (interfaceC0239a == null) {
            throw new IllegalArgumentException("TranOnContentChangedListener is null.");
        }
        b().a(interfaceC0239a);
    }

    public eg.a b() {
        b bVar = this.f9165a;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        this.f9165a = bVar2;
        return bVar2;
    }

    public void c(int i10) {
        b().b(i10);
    }
}
