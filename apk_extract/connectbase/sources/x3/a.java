package x3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.transsion.athena.data.AppIdData;
import com.transsion.athena.data.TrackData;
import ik.y0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a extends c implements Handler.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @b.a({"StaticFieldLeak"})
    public static volatile a f19998f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20000d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f20001e;

    public a(Context context) {
        super(context);
        this.f19999c = 0;
        this.f20001e = 0L;
        HandlerThread handlerThread = new HandlerThread("Athena-LiteWorker", 10);
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.f20004b = handler;
        handler.sendEmptyMessage(303);
    }

    public static a j(Context context) {
        if (f19998f == null) {
            synchronized (a.class) {
                try {
                    if (f19998f == null) {
                        f19998f = new a(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f19998f;
    }

    @Override // x3.c
    public void c(Message message, long j10) {
        Handler handler = this.f20004b;
        if (handler != null) {
            handler.sendMessageDelayed(message, j10);
        }
    }

    @Override // x3.c
    public void d(Runnable runnable) {
        Handler handler = this.f20004b;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    @Override // x3.c
    public void e(Runnable runnable, long j10) {
        Handler handler = this.f20004b;
        if (handler != null) {
            handler.postDelayed(runnable, j10);
        }
    }

    @Override // x3.c
    public void f(String str, TrackData trackData, long j10) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, str);
            jSONObject.put("tid", j10);
            jSONObject.put(y0.a.f8215h, trackData.t());
            JSONObject jSONObjectA = trackData.a();
            String str2 = s3.g.f14975h;
            jSONObject.put("_eparam", jSONObjectA);
        } catch (JSONException e10) {
            y3.b.d(Log.getStackTraceString(e10));
        }
        String string = jSONObject.toString();
        int i10 = this.f20000d;
        if (i10 < 5000) {
            this.f20000d = i10 + 1;
            Message messageObtainMessage = this.f20004b.obtainMessage(302);
            messageObtainMessage.obj = string;
            this.f20004b.sendMessage(messageObtainMessage);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            int i10 = message.what;
            if (i10 == 302) {
                this.f20000d--;
                l((String) message.obj);
                return false;
            }
            if (i10 != 303) {
                if (i10 == 400) {
                    k(message.arg1, (String) message.obj);
                    return false;
                }
                if (i10 != 405) {
                    return false;
                }
                m((t3.b) message.obj);
                return false;
            }
            y3.b.f20688a.f3600m.w(s3.g.N());
            y3.b.f("Athena SDK Version is 3.1.1.1-sys");
            y3.b.f("Athena is in Lite mode");
            if (t3.d.d() == 0) {
                y3.d.e("HostAppId must be set up in LiteMode");
            }
            n();
            return false;
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
            return false;
        }
    }

    public final void k(int i10, String str) {
        if (this.f19999c != 1) {
            y3.b.b("Failed to connect to DCS service");
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("appId", Integer.valueOf(i10));
        if (TextUtils.isEmpty(str)) {
            contentValues.put("baseInfo", AppIdData.a(this.f20003a, i10).f1813b);
        } else {
            contentValues.put("baseInfo", str);
        }
        this.f20003a.getContentResolver().insert(Uri.parse("content://com.transsion.dataservice.provider/bind"), contentValues);
    }

    public final void l(String str) {
        if (this.f19999c == 1) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("trackObject", str);
            this.f20003a.getContentResolver().insert(Uri.parse("content://com.transsion.dataservice.provider/track"), contentValues);
            return;
        }
        y3.b.b("Failed to connect to DCS service");
        long j10 = this.f20001e + 1;
        this.f20001e = j10;
        long j11 = 20;
        if (j10 % j11 == 0 && j10 / j11 <= 5 && y3.d.j(this.f20003a)) {
            n();
        }
    }

    public final void m(t3.b bVar) {
        if (this.f19999c != 1) {
            y3.b.b("Failed to connect to DCS service");
            return;
        }
        Cursor cursorQuery = this.f20003a.getContentResolver().query(Uri.parse("content://com.transsion.dataservice.provider/property"), null, "prop_key = ?", new String[]{bVar.f15455a}, null);
        if (cursorQuery != null) {
            if (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(0);
                k6.g.f fVar = bVar.f15456b.get();
                if (fVar != null) {
                    fVar.a(bVar.f15455a, string);
                }
            }
            cursorQuery.close();
        }
    }

    public final void n() {
        Cursor cursorQuery = this.f20003a.getContentResolver().query(Uri.parse("content://com.transsion.dataservice.provider/authorize"), null, "pkg = ?", new String[]{y3.e.t(this.f20003a)}, null);
        if (cursorQuery != null) {
            y3.b.b("DCS authorize ".concat(cursorQuery.getCount() == 1 ? hi.b.f7122k : "disable"));
            if (cursorQuery.getCount() == 1) {
                this.f19999c = 1;
            } else {
                this.f19999c = 2;
            }
            cursorQuery.close();
        }
    }
}
