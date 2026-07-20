package com.transsion.message.cast.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.message.cast.transfer.e.EAudioOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0002\u0012\u0015\u0018\u0000 !2\u00020\u0001:\u0002 !B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fJ\u0006\u0010\u001a\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0010J\b\u0010\u001c\u001a\u00020\u0010H\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016¨\u0006\""}, d2 = {"Lcom/transsion/message/cast/audio/AudioOutputMonitor;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mAppContext", "mAudioManager", "Landroid/media/AudioManager;", "mHandler", "Landroid/os/Handler;", "mListener", "Lcom/transsion/message/cast/audio/AudioOutputMonitor$Listener;", "mStarted", "", "mLastOutput", "Lcom/transsion/message/cast/transfer/e/EAudioOutput;", "mAudioDeviceCallback", "com/transsion/message/cast/audio/AudioOutputMonitor$mAudioDeviceCallback$1", "Lcom/transsion/message/cast/audio/AudioOutputMonitor$mAudioDeviceCallback$1;", "mHeadsetPlugReceiver", "com/transsion/message/cast/audio/AudioOutputMonitor$mHeadsetPlugReceiver$1", "Lcom/transsion/message/cast/audio/AudioOutputMonitor$mHeadsetPlugReceiver$1;", "start", "", "onChanged", "stop", "getCurrentAudioOutput", "resolveCurrentOutput", "notifyIfChanged", "reason", "", "Listener", "Companion", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nAudioOutputMonitor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudioOutputMonitor.kt\ncom/transsion/message/cast/audio/AudioOutputMonitor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,149:1\n1#2:150\n11165#3:151\n11500#3,3:152\n1755#4,3:155\n1755#4,3:158\n*S KotlinDebug\n*F\n+ 1 AudioOutputMonitor.kt\ncom/transsion/message/cast/audio/AudioOutputMonitor\n*L\n125#1:151\n125#1:152,3\n128#1:155,3\n129#1:158,3\n*E\n"})
public final class AudioOutputMonitor {
    private static final String TAG = "AudioOutputMonitor";
    private final Context mAppContext;
    private final AudioOutputMonitor$mAudioDeviceCallback$1 mAudioDeviceCallback;
    private final AudioManager mAudioManager;
    private final Handler mHandler;
    private final AudioOutputMonitor$mHeadsetPlugReceiver$1 mHeadsetPlugReceiver;
    private EAudioOutput mLastOutput;
    private Listener mListener;
    private boolean mStarted;
    private static final Set<Integer> BLUETOOTH_TYPES = SetsKt.setOf((Object[]) new Integer[]{8, 7, 26, 27, 30});
    private static final Set<Integer> WIRED_TYPES = SetsKt.setOf((Object[]) new Integer[]{4, 3, 22, 11});

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/transsion/message/cast/audio/AudioOutputMonitor$Listener;", "", "onAudioOutputChanged", "", "output", "Lcom/transsion/message/cast/transfer/e/EAudioOutput;", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public interface Listener {
        void onAudioOutputChanged(EAudioOutput output);
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.transsion.message.cast.audio.AudioOutputMonitor$mAudioDeviceCallback$1] */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.transsion.message.cast.audio.AudioOutputMonitor$mHeadsetPlugReceiver$1] */
    public AudioOutputMonitor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.mAppContext = applicationContext;
        Object systemService = applicationContext.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.mAudioManager = (AudioManager) systemService;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mAudioDeviceCallback = new AudioDeviceCallback() { // from class: com.transsion.message.cast.audio.AudioOutputMonitor$mAudioDeviceCallback$1
            @Override // android.media.AudioDeviceCallback
            public void onAudioDevicesAdded(AudioDeviceInfo[] addedDevices) {
                Intrinsics.checkNotNullParameter(addedDevices, "addedDevices");
                this.this$0.notifyIfChanged("devicesAdded");
            }

            @Override // android.media.AudioDeviceCallback
            public void onAudioDevicesRemoved(AudioDeviceInfo[] removedDevices) {
                Intrinsics.checkNotNullParameter(removedDevices, "removedDevices");
                this.this$0.notifyIfChanged("devicesRemoved");
            }
        };
        this.mHeadsetPlugReceiver = new BroadcastReceiver() { // from class: com.transsion.message.cast.audio.AudioOutputMonitor$mHeadsetPlugReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (Intrinsics.areEqual("android.intent.action.HEADSET_PLUG", intent != null ? intent.getAction() : null)) {
                    this.this$0.notifyIfChanged("ACTION_HEADSET_PLUG");
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyIfChanged(String reason) {
        EAudioOutput eAudioOutputResolveCurrentOutput = resolveCurrentOutput();
        if (eAudioOutputResolveCurrentOutput != this.mLastOutput) {
            this.mLastOutput = eAudioOutputResolveCurrentOutput;
            Listener listener = this.mListener;
            if (listener != null) {
                listener.onAudioOutputChanged(eAudioOutputResolveCurrentOutput);
            }
        }
        Log.d(TAG, "audio output=" + eAudioOutputResolveCurrentOutput + " reason=" + reason);
    }

    private final EAudioOutput resolveCurrentOutput() {
        AudioDeviceInfo[] devices = this.mAudioManager.getDevices(2);
        Intrinsics.checkNotNull(devices);
        ArrayList arrayList = new ArrayList(devices.length);
        for (AudioDeviceInfo audioDeviceInfo : devices) {
            arrayList.add(Integer.valueOf(audioDeviceInfo.getType()));
        }
        Set set = CollectionsKt.toSet(arrayList);
        if (set == null || !set.isEmpty()) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (BLUETOOTH_TYPES.contains(Integer.valueOf(((Number) it.next()).intValue()))) {
                    return EAudioOutput.BLUETOOTH;
                }
            }
        }
        if (set == null || !set.isEmpty()) {
            Iterator it2 = set.iterator();
            while (it2.hasNext()) {
                if (WIRED_TYPES.contains(Integer.valueOf(((Number) it2.next()).intValue()))) {
                    return EAudioOutput.WIRED;
                }
            }
        }
        if (set.contains(1)) {
            return EAudioOutput.EARPIECE;
        }
        if (!set.contains(2) && !this.mAudioManager.isSpeakerphoneOn()) {
            return EAudioOutput.EARPIECE;
        }
        return EAudioOutput.SPEAKER;
    }

    public final EAudioOutput getCurrentAudioOutput() {
        return resolveCurrentOutput();
    }

    public final void start(Listener onChanged) {
        Object objM159constructorimpl;
        Object objM159constructorimpl2;
        Intrinsics.checkNotNullParameter(onChanged, "onChanged");
        this.mListener = onChanged;
        if (this.mStarted) {
            notifyIfChanged("alreadyStarted");
            return;
        }
        this.mStarted = true;
        try {
            Result.Companion companion = Result.INSTANCE;
            this.mAudioManager.registerAudioDeviceCallback(this.mAudioDeviceCallback, this.mHandler);
            objM159constructorimpl = Result.m159constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            objM159constructorimpl = Result.m159constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable thM162exceptionOrNullimpl = Result.m162exceptionOrNullimpl(objM159constructorimpl);
        if (thM162exceptionOrNullimpl != null) {
            Log.w(TAG, "registerAudioDeviceCallback failed: " + thM162exceptionOrNullimpl.getMessage());
        }
        try {
            objM159constructorimpl2 = Result.m159constructorimpl(this.mAppContext.registerReceiver(this.mHeadsetPlugReceiver, new IntentFilter("android.intent.action.HEADSET_PLUG")));
        } catch (Throwable th3) {
            Result.Companion companion3 = Result.INSTANCE;
            objM159constructorimpl2 = Result.m159constructorimpl(ResultKt.createFailure(th3));
        }
        Throwable thM162exceptionOrNullimpl2 = Result.m162exceptionOrNullimpl(objM159constructorimpl2);
        if (thM162exceptionOrNullimpl2 != null) {
            Log.w(TAG, "registerReceiver failed: " + thM162exceptionOrNullimpl2.getMessage());
        }
        notifyIfChanged("start");
    }

    public final void stop() {
        Object objM159constructorimpl;
        Object objM159constructorimpl2;
        if (this.mStarted) {
            this.mStarted = false;
            try {
                Result.Companion companion = Result.INSTANCE;
                this.mAudioManager.unregisterAudioDeviceCallback(this.mAudioDeviceCallback);
                objM159constructorimpl = Result.m159constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                objM159constructorimpl = Result.m159constructorimpl(ResultKt.createFailure(th2));
            }
            Throwable thM162exceptionOrNullimpl = Result.m162exceptionOrNullimpl(objM159constructorimpl);
            if (thM162exceptionOrNullimpl != null) {
                Log.w(TAG, "unregisterAudioDeviceCallback failed: " + thM162exceptionOrNullimpl.getMessage());
            }
            try {
                this.mAppContext.unregisterReceiver(this.mHeadsetPlugReceiver);
                objM159constructorimpl2 = Result.m159constructorimpl(Unit.INSTANCE);
            } catch (Throwable th3) {
                Result.Companion companion3 = Result.INSTANCE;
                objM159constructorimpl2 = Result.m159constructorimpl(ResultKt.createFailure(th3));
            }
            Throwable thM162exceptionOrNullimpl2 = Result.m162exceptionOrNullimpl(objM159constructorimpl2);
            if (thM162exceptionOrNullimpl2 != null) {
                Log.w(TAG, "unregisterReceiver failed: " + thM162exceptionOrNullimpl2.getMessage());
            }
        }
    }
}
