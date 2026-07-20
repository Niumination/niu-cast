package com.transsion.tranradionet.tce;

import android.hardware.SensorEvent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
public class TceEvent implements Parcelable {
    public static final int ACCURACY_HIGH = 3;
    public static final int ACCURACY_LOW = 1;
    public static final int ACCURACY_MEDIUM = 2;
    public static final int ACCURACY_UNRELIABLE = 0;
    public static final Parcelable.Creator<TceEvent> CREATOR = new Parcelable.Creator<TceEvent>() { // from class: com.transsion.tranradionet.tce.TceEvent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TceEvent createFromParcel(Parcel parcel) {
            return new TceEvent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TceEvent[] newArray(int i8) {
            return new TceEvent[i8];
        }
    };
    public static final int TYPE_ELEVATOR_MODE = 1;
    public static final int TYPE_SENSOR = 4;
    public static final int TYPE_VEHICLE_MODE = 2;
    public static final int TYPE_VEHICLE_MOTION = 3;
    public final int accuracy;
    private int errorCode;
    private String errorMessage;
    public final long timestamp;
    public final int type;
    public final float[] values;

    public TceEvent() {
        this.errorCode = 0;
        this.errorMessage = null;
        this.type = 0;
        this.timestamp = SystemClock.elapsedRealtimeNanos();
        this.accuracy = 0;
        this.values = new float[0];
    }

    public static TceEvent createFromSensorEvent(SensorEvent sensorEvent) {
        return new TceEvent(sensorEvent.sensor.getHandle(), sensorEvent.timestamp, sensorEvent.accuracy, sensorEvent.values);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public float getValue(int i8) {
        if (i8 >= 0) {
            float[] fArr = this.values;
            if (i8 < fArr.length) {
                return fArr[i8];
            }
        }
        return 0.0f;
    }

    public void setErrorInfo(int i8, String str) {
        this.errorCode = i8;
        this.errorMessage = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("TceEvent{type=");
        sb2.append(this.type);
        sb2.append(", timestamp=");
        sb2.append(this.timestamp);
        sb2.append(", accuracy=");
        sb2.append(this.accuracy);
        sb2.append(", values=[");
        for (int i8 = 0; i8 < this.values.length; i8++) {
            if (i8 > 0) {
                sb2.append(", ");
            }
            sb2.append(this.values[i8]);
        }
        sb2.append("]");
        if (this.errorCode != 0) {
            sb2.append(", errorCode=");
            sb2.append(this.errorCode);
            if (this.errorMessage != null) {
                sb2.append(", errorMessage='");
                sb2.append(this.errorMessage);
                sb2.append("'");
            }
        }
        sb2.append("}");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeInt(this.type);
        parcel.writeLong(this.timestamp);
        parcel.writeInt(this.accuracy);
        parcel.writeFloatArray(this.values);
        parcel.writeInt(this.errorCode);
        parcel.writeString(this.errorMessage);
    }

    public TceEvent(int i8, int i9, float[] fArr) {
        this.errorCode = 0;
        this.errorMessage = null;
        this.type = i8;
        this.timestamp = SystemClock.elapsedRealtimeNanos();
        this.accuracy = i9;
        this.values = fArr != null ? (float[]) fArr.clone() : new float[0];
    }

    public TceEvent(int i8, long j8, int i9, float[] fArr) {
        this.errorCode = 0;
        this.errorMessage = null;
        this.type = i8;
        this.timestamp = j8;
        this.accuracy = i9;
        this.values = fArr != null ? (float[]) fArr.clone() : new float[0];
    }

    public TceEvent(Parcel parcel) {
        this.errorCode = 0;
        this.errorMessage = null;
        this.type = parcel.readInt();
        this.timestamp = parcel.readLong();
        this.accuracy = parcel.readInt();
        this.values = parcel.createFloatArray();
        this.errorCode = parcel.readInt();
        this.errorMessage = parcel.readString();
    }
}
