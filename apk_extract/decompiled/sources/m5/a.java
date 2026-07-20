package m5;

import i2.e;
import j3.s;
import j3.w;
import j3.x;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Set;
import o4.c;
import o4.u;
import o5.b;
import p5.d;
import p5.g;
import p5.k;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ a f7938b = new a(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ a f7939c = new a(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ a f7940d = new a(2);
    public static final /* synthetic */ a e = new a(3);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ a f7941h = new a(4);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ a f7942i = new a(5);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ a f7943j = new a(6);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ a f7944k = new a(7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7945a;

    public /* synthetic */ a(int i8) {
        this.f7945a = i8;
    }

    @Override // o4.c
    public final Object a(u uVar) {
        switch (this.f7945a) {
            case 0:
                return new q5.a();
            case 1:
                return new g();
            case 2:
                Set<b> setC = uVar.c(b.class);
                o5.c cVar = new o5.c();
                cVar.f8405a = new HashMap();
                for (b bVar : setC) {
                    HashMap map = (HashMap) cVar.f8405a;
                    bVar.getClass();
                    map.put(o5.a.class, bVar.f8404a);
                }
                return cVar;
            case 3:
                return new d(uVar.b(g.class));
            case 4:
                p5.a aVar = new p5.a();
                ReferenceQueue referenceQueue = aVar.f8664a;
                Set set = aVar.f8665b;
                set.add(new k(aVar, referenceQueue, set));
                Thread thread = new Thread(new e(5, referenceQueue, set), "MlKitCleaner");
                thread.setDaemon(true);
                thread.start();
                return aVar;
            case 5:
                return new p5.b(0);
            case 6:
                synchronized (x.class) {
                    byte b9 = (byte) (((byte) 1) | 2);
                    if (b9 != 3) {
                        StringBuilder sb2 = new StringBuilder();
                        if ((b9 & 1) == 0) {
                            sb2.append(" enableFirelog");
                        }
                        if ((b9 & 2) == 0) {
                            sb2.append(" firelogEventType");
                        }
                        throw new IllegalStateException("Missing required properties:".concat(sb2.toString()));
                    }
                    s sVar = new s();
                    synchronized (x.class) {
                        try {
                            if (x.f6090a == null) {
                                x.f6090a = new w(0);
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    return new n5.a();
                }
                return new n5.a();
            default:
                return new b(uVar.b(n5.a.class));
        }
    }
}
