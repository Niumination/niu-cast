package androidx.camera.core.impl;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f973a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveDataObservable.LiveDataObserverAdapter f974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f975c;

    public /* synthetic */ a(LiveDataObservable.LiveDataObserverAdapter liveDataObserverAdapter, LiveDataObservable.Result result) {
        this.f974b = liveDataObserverAdapter;
        this.f975c = result;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f973a) {
            case 0:
                ((LiveDataObservable) this.f975c).lambda$removeObserver$3(this.f974b);
                break;
            default:
                this.f974b.lambda$onChanged$0((LiveDataObservable.Result) this.f975c);
                break;
        }
    }

    public /* synthetic */ a(LiveDataObservable liveDataObservable, LiveDataObservable.LiveDataObserverAdapter liveDataObserverAdapter) {
        this.f975c = liveDataObservable;
        this.f974b = liveDataObserverAdapter;
    }
}
