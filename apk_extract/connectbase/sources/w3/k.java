package w3;

import android.os.Handler;
import android.os.Message;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: loaded from: classes2.dex */
public class k extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f17926d = {"https://time1.google.com", "https://time.cloudflare.com", "https://www.pool.ntp.org"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17927c;

    public k(Handler handler) {
        super(handler);
        this.f17927c = 0;
    }

    @Override // w3.c
    public void a() throws Throwable {
        Message messageObtainMessage = this.f17912a.obtainMessage(TypedValues.PositionType.TYPE_PERCENT_WIDTH);
        messageObtainMessage.obj = 0L;
        while (true) {
            int i10 = this.f17927c;
            if (i10 >= 3) {
                break;
            }
            l<Long> lVarC = d.c(f17926d[i10]);
            if (lVarC.f17928a == 0) {
                messageObtainMessage.obj = lVarC.f17929b;
                break;
            }
            this.f17927c++;
        }
        this.f17912a.sendMessageAtFrontOfQueue(messageObtainMessage);
    }

    @Override // w3.c
    public String c() {
        return "Retrieve-Time";
    }
}
