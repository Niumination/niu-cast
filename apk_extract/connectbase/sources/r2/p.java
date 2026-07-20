package r2;

import androidx.core.app.NotificationCompat;
import kn.l0;
import kn.r1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nMessage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Message.kt\ncom/transsion/airtransfer/filetransfer/bean/MessageKt\n+ 2 DataBus.kt\ncom/transsion/airtransfer/filetransfer/databus/DataBus\n*L\n1#1,100:1\n39#2,4:101\n*S KotlinDebug\n*F\n+ 1 Message.kt\ncom/transsion/airtransfer/filetransfer/bean/MessageKt\n*L\n43#1:101,4\n*E\n"})
public final class p {
    public static final void a(@os.l u2.b bVar, @os.l o oVar, @os.m jn.a<l2> aVar) {
        l0.p(bVar, "<this>");
        l0.p(oVar, NotificationCompat.CATEGORY_MESSAGE);
        if (aVar != null) {
            oVar.f14200c = aVar;
        }
        nq.k.f(bVar, null, null, new u2.b.e(oVar, Integer.valueOf(oVar.c()), null), 3, null);
    }

    public static /* synthetic */ void b(u2.b bVar, o oVar, jn.a aVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            aVar = null;
        }
        a(bVar, oVar, aVar);
    }

    @os.l
    public static final <T extends o> T c(@os.l T t10) {
        l0.p(t10, "<this>");
        t10.g(2);
        return t10;
    }

    @os.l
    public static final <T extends o> T d(@os.l T t10) {
        l0.p(t10, "<this>");
        t10.g(1);
        return t10;
    }
}
