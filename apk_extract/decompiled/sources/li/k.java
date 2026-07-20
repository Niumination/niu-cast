package li;

import com.transsion.message.cast.MessageCastService;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class k implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7461b;

    public /* synthetic */ k(Object obj, int i8) {
        this.f7460a = i8;
        this.f7461b = obj;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, final Object obj3) {
        switch (this.f7460a) {
            case 0:
                ((gi.a) this.f7461b).invoke((Throwable) obj);
                return Unit.INSTANCE;
            case 1:
                final ti.f fVar = (ti.f) obj;
                final ni.m mVar = (ni.m) this.f7461b;
                return new Function3() { // from class: ni.e
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj4, Object obj5, Object obj6) {
                        a8.a aVar = o.f8315l;
                        Object obj7 = obj3;
                        if (obj7 != aVar) {
                            qi.g.a(mVar.f8304b, obj7, ((ti.e) fVar).f10228a);
                        }
                        return Unit.INSTANCE;
                    }
                };
            case 2:
                ((vi.h) this.f7461b).c();
                return Unit.INSTANCE;
            default:
                return MessageCastService.setupSmsReplyDispatcher$lambda$0((MessageCastService) this.f7461b, (String) obj, (String) obj2, (String) obj3);
        }
    }
}
