package ad;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;
import com.transsion.atomiccore.support.host.AtomicDefaultSizeData;
import dj.k0;
import dj.m0;
import dj.x;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import k3.ya;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import v4.p0;
import v4.q;
import v4.v;
import zj.j;
import zj.k;
import zj.o0;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements j, q3.b, zj.f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile b f91c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f92a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f93b;

    public /* synthetic */ b(Object obj, Object obj2) {
        this.f93b = obj;
        this.f92a = obj2;
    }

    public static void c(Context context) {
        i iVar;
        if (context != null && f91c == null) {
            synchronized (b.class) {
                try {
                    if (f91c == null) {
                        b bVar = new b();
                        bVar.f93b = context;
                        bVar.f92a = i.a(context.getApplicationContext());
                        Context applicationContext = context.getApplicationContext();
                        if (ya.f6726a == null) {
                            ya.f6726a = applicationContext.getApplicationContext();
                        }
                        f91c = bVar;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        b bVar2 = f91c;
        if (((Context) bVar2.f93b) == null || (iVar = (i) bVar2.f92a) == null) {
            return;
        }
        c.g("Check appId record : 7800");
        HandlerThread handlerThread = iVar.f104b;
        if (handlerThread == null || !handlerThread.isAlive()) {
            return;
        }
        Message messageObtain = Message.obtain(iVar.f103a, 304);
        messageObtain.obj = 7800;
        if (iVar.f114o.get()) {
            iVar.f103a.sendMessage(messageObtain);
        } else {
            iVar.f103a.sendMessageDelayed(messageObtain, ((long) 0) * 1000);
        }
    }

    @Override // q3.b
    public void a(q3.f fVar) {
        ((Map) ((f5.a) this.f93b).f4985b).remove((q3.g) this.f92a);
    }

    public int b() {
        ga.c cVar;
        if (l9.b.a(l9.a.f7351l)) {
            j9.a.c("b", "TranThubWindowManager");
            cVar = (v9.c) this.f92a;
            if (cVar == null) {
                cVar = new v9.c();
                this.f92a = cVar;
            }
        } else {
            j9.a.c("b", "TranAospWindowManager");
            cVar = (q8.c) this.f93b;
            if (cVar == null) {
                cVar = new q8.c();
                this.f93b = cVar;
            }
        }
        return cVar.a();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0055  */
    @Override // zj.j
    public Object convert(Object obj) {
        Charset charsetForName;
        String str;
        m0 m0Var = (m0) obj;
        k0 k0Var = m0Var.f4613a;
        if (k0Var == null) {
            qj.h hVarG = m0Var.g();
            x xVarC = m0Var.c();
            if (xVarC != null) {
                charsetForName = Charsets.UTF_8;
                Intrinsics.checkNotNullParameter("charset", "name");
                String[] strArr = xVarC.f4644c;
                IntProgression intProgressionStep = RangesKt.step(ArraysKt.getIndices(strArr), 2);
                int first = intProgressionStep.getFirst();
                int last = intProgressionStep.getLast();
                int step = intProgressionStep.getStep();
                if (step < 0 ? first >= last : first <= last) {
                    while (true) {
                        if (!StringsKt__StringsJVMKt.equals(strArr[first], "charset", true)) {
                            if (first == last) {
                                str = null;
                                break;
                            }
                            first += step;
                        } else {
                            str = strArr[first + 1];
                            break;
                        }
                    }
                } else {
                    str = null;
                    break;
                }
                if (str != null) {
                    try {
                        charsetForName = Charset.forName(str);
                    } catch (IllegalArgumentException unused) {
                    }
                }
                if (charsetForName == null) {
                    charsetForName = Charsets.UTF_8;
                }
            } else {
                charsetForName = Charsets.UTF_8;
            }
            k0Var = new k0(hVarG, charsetForName);
            m0Var.f4613a = k0Var;
        }
        d5.b bVarNewJsonReader = ((q) this.f92a).newJsonReader(k0Var);
        try {
            Object obj2 = ((p0) this.f93b).read(bVarNewJsonReader);
            if (bVarNewJsonReader.peek() != d5.c.END_DOCUMENT) {
                throw new v("JSON document was not fully consumed.");
            }
            m0Var.close();
            return obj2;
        } catch (Throwable th2) {
            m0Var.close();
            throw th2;
        }
    }

    @Override // zj.f
    public void d(zj.c cVar, o0 o0Var) {
        ((k) this.f93b).f11639a.execute(new a0.g(this, 28, (zj.f) this.f92a, o0Var));
    }

    @Override // zj.f
    public void onFailure(Throwable th2) {
        ((k) this.f93b).f11639a.execute(new a0.g(this, 29, (zj.f) this.f92a, th2));
    }

    public b(y6.g gVar) {
        this.f92a = (AtomicDefaultSizeData) gVar.f11095a;
        this.f93b = (AtomicDefaultSizeData) gVar.f11096b;
    }

    public b(int i8) {
        switch (i8) {
            case 6:
                this.f92a = Choreographer.getInstance();
                this.f93b = Looper.myLooper();
                break;
            default:
                this.f92a = new AtomicLong();
                this.f93b = new AtomicLong();
                break;
        }
    }
}
