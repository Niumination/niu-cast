package th;

import com.transsion.iotcardsdk.bean.IotCardTemplatePublisherWrapper;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends qh.a implements Callable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IotCardTemplatePublisherWrapper f10218b;

    public a(IotCardTemplatePublisherWrapper iotCardTemplatePublisherWrapper) {
        this.f10218b = iotCardTemplatePublisherWrapper;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f10218b;
    }
}
