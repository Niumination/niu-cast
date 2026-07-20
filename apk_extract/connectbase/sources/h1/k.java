package h1;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@e
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f6951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f6952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f6953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Method f6954d;

    public k(f eventBus, Object event, Object subscriber, Method subscriberMethod) {
        eventBus.getClass();
        this.f6951a = eventBus;
        event.getClass();
        this.f6952b = event;
        subscriber.getClass();
        this.f6953c = subscriber;
        subscriberMethod.getClass();
        this.f6954d = subscriberMethod;
    }

    public Object a() {
        return this.f6952b;
    }

    public f b() {
        return this.f6951a;
    }

    public Object c() {
        return this.f6953c;
    }

    public Method d() {
        return this.f6954d;
    }
}
