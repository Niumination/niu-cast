package g8;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedBlockingQueue f5118c;

    public b(int i8) {
        this.f5116a = i8;
        switch (i8) {
            case 1:
                this.f5117b = false;
                this.f5118c = new LinkedBlockingQueue(1);
                break;
            case 2:
                this.f5117b = false;
                this.f5118c = new LinkedBlockingQueue(1);
                break;
            default:
                this.f5117b = false;
                this.f5118c = new LinkedBlockingQueue(1);
                break;
        }
    }

    private final void c(ComponentName componentName) {
    }

    private final void d(ComponentName componentName) {
    }

    private final void e(ComponentName componentName) {
    }

    public IBinder a() {
        switch (this.f5116a) {
            case 1:
                if (this.f5117b) {
                    throw new IllegalStateException();
                }
                this.f5117b = true;
                return (IBinder) this.f5118c.poll(10L, TimeUnit.SECONDS);
            default:
                if (this.f5117b) {
                    throw new IllegalStateException();
                }
                this.f5117b = true;
                return (IBinder) this.f5118c.poll(10L, TimeUnit.SECONDS);
        }
    }

    public IBinder b() {
        if (this.f5117b) {
            throw new IllegalStateException();
        }
        this.f5117b = true;
        return (IBinder) this.f5118c.poll(10L, TimeUnit.SECONDS);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        switch (this.f5116a) {
            case 0:
                try {
                    this.f5118c.put(iBinder);
                } catch (InterruptedException unused) {
                    return;
                }
                break;
            case 1:
                LinkedBlockingQueue linkedBlockingQueue = this.f5118c;
                try {
                    if (linkedBlockingQueue.isEmpty()) {
                        linkedBlockingQueue.put(iBinder);
                    }
                } catch (InterruptedException unused2) {
                    return;
                }
                break;
            default:
                LinkedBlockingQueue linkedBlockingQueue2 = this.f5118c;
                try {
                    if (linkedBlockingQueue2.isEmpty()) {
                        linkedBlockingQueue2.put(iBinder);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                break;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        int i8 = this.f5116a;
    }
}
