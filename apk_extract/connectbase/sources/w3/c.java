package w3;

import android.os.Handler;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f17912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Thread f17913b;

    public c() {
    }

    public abstract void a();

    public String b() {
        return "Task-Athena-" + c();
    }

    public abstract String c();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public void run() {
        Thread threadCurrentThread = Thread.currentThread();
        this.f17913b = threadCurrentThread;
        String name = threadCurrentThread.getName();
        this.f17913b.setName(b());
        try {
            a();
        } catch (Exception e10) {
            e10.printStackTrace();
        } finally {
            j.d().h(this);
            this.f17913b.setName(name);
        }
    }

    public c(@NonNull Handler handler) {
        this.f17912a = handler;
    }
}
