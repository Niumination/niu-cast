package wc;

import com.transsion.message.cast.ChatActivity;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ChatActivity f10711b;

    public /* synthetic */ c(ChatActivity chatActivity, int i8) {
        this.f10710a = i8;
        this.f10711b = chatActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8 = this.f10710a;
        ChatActivity chatActivity = this.f10711b;
        switch (i8) {
            case 0:
                ChatActivity.onCreate$lambda$2(chatActivity);
                break;
            default:
                ChatActivity.addMessage$lambda$9(chatActivity);
                break;
        }
    }
}
