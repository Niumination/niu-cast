package com.transsion.core.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.transsion.core.CoreUtil;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class ToastUtil {
    private static Field sField_TN;
    private static Field sField_TN_Handler;
    private static Handler mHandler = new Handler(Looper.getMainLooper());
    private static Toast toast = null;

    public static class SafelyHandlerWrapper extends Handler {
        private Handler impl;

        public SafelyHandlerWrapper(Handler handler) {
            this.impl = handler;
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.impl.handleMessage(message);
        }
    }

    static {
        try {
            Field declaredField = Toast.class.getDeclaredField("mTN");
            sField_TN = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = sField_TN.getType().getDeclaredField("mHandler");
            sField_TN_Handler = declaredField2;
            declaredField2.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hook(Toast toast2) {
        try {
            Object obj = sField_TN.get(toast2);
            Handler handler = (Handler) sField_TN_Handler.get(obj);
            if (handler == null || (handler instanceof SafelyHandlerWrapper)) {
                return;
            }
            sField_TN_Handler.set(obj, new SafelyHandlerWrapper(handler));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showLongToast(final int i8) {
        final Context context = CoreUtil.getContext();
        if (i8 <= 0) {
            return;
        }
        mHandler.post(new Runnable() { // from class: com.transsion.core.utils.ToastUtil.3
            @Override // java.lang.Runnable
            public void run() {
                if (ToastUtil.toast != null) {
                    ToastUtil.toast.setText(i8);
                    ToastUtil.toast.setDuration(1);
                    ToastUtil.hook(ToastUtil.toast);
                } else {
                    Toast unused = ToastUtil.toast = Toast.makeText(context.getApplicationContext(), i8, 1);
                }
                ToastUtil.toast.show();
            }
        });
    }

    public static void showToast(final int i8) {
        final Context context = CoreUtil.getContext();
        if (i8 <= 0) {
            return;
        }
        mHandler.post(new Runnable() { // from class: com.transsion.core.utils.ToastUtil.1
            @Override // java.lang.Runnable
            public void run() {
                if (ToastUtil.toast != null) {
                    ToastUtil.toast.setText(i8);
                    ToastUtil.toast.setDuration(0);
                    ToastUtil.hook(ToastUtil.toast);
                } else {
                    Toast unused = ToastUtil.toast = Toast.makeText(context.getApplicationContext(), i8, 0);
                }
                ToastUtil.toast.show();
            }
        });
    }

    public static void showLongToast(final String str) {
        final Context context = CoreUtil.getContext();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        mHandler.post(new Runnable() { // from class: com.transsion.core.utils.ToastUtil.4
            @Override // java.lang.Runnable
            public void run() {
                if (ToastUtil.toast != null) {
                    ToastUtil.toast.setText(str);
                    ToastUtil.toast.setDuration(1);
                    ToastUtil.hook(ToastUtil.toast);
                } else {
                    Toast unused = ToastUtil.toast = Toast.makeText(context.getApplicationContext(), str, 1);
                }
                ToastUtil.toast.show();
            }
        });
    }

    public static void showToast(final String str) {
        final Context context = CoreUtil.getContext();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        mHandler.post(new Runnable() { // from class: com.transsion.core.utils.ToastUtil.2
            @Override // java.lang.Runnable
            public void run() {
                if (ToastUtil.toast != null) {
                    ToastUtil.toast.setText(str);
                    ToastUtil.toast.setDuration(0);
                    ToastUtil.hook(ToastUtil.toast);
                } else {
                    Toast unused = ToastUtil.toast = Toast.makeText(context.getApplicationContext(), str, 0);
                }
                ToastUtil.toast.show();
            }
        });
    }
}
