package androidx.versionedparcelable;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.NetworkOnMainThreadException;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.transsion.connectx.sdk.ErrorConstant;
import h0.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class VersionedParcel {
    private static final int EX_BAD_PARCELABLE = -2;
    private static final int EX_ILLEGAL_ARGUMENT = -3;
    private static final int EX_ILLEGAL_STATE = -5;
    private static final int EX_NETWORK_MAIN_THREAD = -6;
    private static final int EX_NULL_POINTER = -4;
    private static final int EX_PARCELABLE = -9;
    private static final int EX_SECURITY = -1;
    private static final int EX_UNSUPPORTED_OPERATION = -7;
    private static final String TAG = "VersionedParcel";
    private static final int TYPE_BINDER = 5;
    private static final int TYPE_FLOAT = 8;
    private static final int TYPE_INTEGER = 7;
    private static final int TYPE_PARCELABLE = 2;
    private static final int TYPE_SERIALIZABLE = 3;
    private static final int TYPE_STRING = 4;
    private static final int TYPE_VERSIONED_PARCELABLE = 1;
    protected final ArrayMap<String, Class> mParcelizerCache;
    protected final ArrayMap<String, Method> mReadCache;
    protected final ArrayMap<String, Method> mWriteCache;

    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable th2) {
            super(th2);
        }
    }

    public VersionedParcel(ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        this.mReadCache = arrayMap;
        this.mWriteCache = arrayMap2;
        this.mParcelizerCache = arrayMap3;
    }

    private Exception createException(int i8, String str) {
        switch (i8) {
            case EX_PARCELABLE /* -9 */:
                return (Exception) readParcelable();
            case ErrorConstant.ERROR_REPARENT_CURRENT_APP_FORBIDDEN /* -8 */:
            default:
                return new RuntimeException("Unknown exception code: " + i8 + " msg " + str);
            case -7:
                return new UnsupportedOperationException(str);
            case EX_NETWORK_MAIN_THREAD /* -6 */:
                return new NetworkOnMainThreadException();
            case -5:
                return new IllegalStateException(str);
            case -4:
                return new NullPointerException(str);
            case -3:
                return new IllegalArgumentException(str);
            case -2:
                return new BadParcelableException(str);
            case -1:
                return new SecurityException(str);
        }
    }

    private Class findParcelClass(Class<? extends VersionedParcelable> cls) throws ClassNotFoundException {
        Class cls2 = this.mParcelizerCache.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(cls.getPackage().getName() + "." + cls.getSimpleName() + "Parcelizer", false, cls.getClassLoader());
        this.mParcelizerCache.put(cls.getName(), cls3);
        return cls3;
    }

    private Method getReadMethod(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.mReadCache.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
        this.mReadCache.put(str, declaredMethod);
        return declaredMethod;
    }

    @NonNull
    public static Throwable getRootCause(@NonNull Throwable th2) {
        while (th2.getCause() != null) {
            th2 = th2.getCause();
        }
        return th2;
    }

    private <T> int getType(T t3) {
        if (t3 instanceof String) {
            return 4;
        }
        if (t3 instanceof Parcelable) {
            return 2;
        }
        if (t3 instanceof VersionedParcelable) {
            return 1;
        }
        if (t3 instanceof Serializable) {
            return 3;
        }
        if (t3 instanceof IBinder) {
            return 5;
        }
        if (t3 instanceof Integer) {
            return 7;
        }
        if (t3 instanceof Float) {
            return 8;
        }
        throw new IllegalArgumentException(t3.getClass().getName().concat(" cannot be VersionedParcelled"));
    }

    private Method getWriteMethod(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.mWriteCache.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class clsFindParcelClass = findParcelClass(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsFindParcelClass.getDeclaredMethod("write", cls, VersionedParcel.class);
        this.mWriteCache.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    private <T, S extends Collection<T>> S readCollection(S s2) {
        int i8 = readInt();
        if (i8 < 0) {
            return null;
        }
        if (i8 != 0) {
            int i9 = readInt();
            if (i8 < 0) {
                return null;
            }
            if (i9 == 1) {
                while (i8 > 0) {
                    s2.add(readVersionedParcelable());
                    i8--;
                }
            } else if (i9 == 2) {
                while (i8 > 0) {
                    s2.add(readParcelable());
                    i8--;
                }
            } else if (i9 == 3) {
                while (i8 > 0) {
                    s2.add(readSerializable());
                    i8--;
                }
            } else if (i9 == 4) {
                while (i8 > 0) {
                    s2.add(readString());
                    i8--;
                }
            } else if (i9 == 5) {
                while (i8 > 0) {
                    s2.add(readStrongBinder());
                    i8--;
                }
            }
        }
        return s2;
    }

    private int readExceptionCode() {
        return readInt();
    }

    private <T> void writeCollection(Collection<T> collection, int i8) {
        setOutputField(i8);
        writeCollection(collection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeVersionedParcelableCreator(VersionedParcelable versionedParcelable) {
        try {
            writeString(findParcelClass(versionedParcelable.getClass()).getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(versionedParcelable.getClass().getSimpleName().concat(" does not have a Parcelizer"), e);
        }
    }

    public abstract void closeField();

    public abstract VersionedParcel createSubParcel();

    public boolean isStream() {
        return false;
    }

    public <T> T[] readArray(T[] tArr, int i8) {
        return !readField(i8) ? tArr : (T[]) readArray(tArr);
    }

    public abstract boolean readBoolean();

    public boolean readBoolean(boolean z2, int i8) {
        return !readField(i8) ? z2 : readBoolean();
    }

    public boolean[] readBooleanArray(boolean[] zArr, int i8) {
        return !readField(i8) ? zArr : readBooleanArray();
    }

    public abstract Bundle readBundle();

    public Bundle readBundle(Bundle bundle, int i8) {
        return !readField(i8) ? bundle : readBundle();
    }

    public byte readByte(byte b9, int i8) {
        return !readField(i8) ? b9 : (byte) (readInt() & 255);
    }

    public abstract byte[] readByteArray();

    public byte[] readByteArray(byte[] bArr, int i8) {
        return !readField(i8) ? bArr : readByteArray();
    }

    public char[] readCharArray(char[] cArr, int i8) {
        if (!readField(i8)) {
            return cArr;
        }
        int i9 = readInt();
        if (i9 < 0) {
            return null;
        }
        char[] cArr2 = new char[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            cArr2[i10] = (char) readInt();
        }
        return cArr2;
    }

    public abstract CharSequence readCharSequence();

    public CharSequence readCharSequence(CharSequence charSequence, int i8) {
        return !readField(i8) ? charSequence : readCharSequence();
    }

    public abstract double readDouble();

    public double readDouble(double d7, int i8) {
        return !readField(i8) ? d7 : readDouble();
    }

    public double[] readDoubleArray(double[] dArr, int i8) {
        return !readField(i8) ? dArr : readDoubleArray();
    }

    public Exception readException(Exception exc, int i8) {
        int exceptionCode;
        return (readField(i8) && (exceptionCode = readExceptionCode()) != 0) ? readException(exceptionCode, readString()) : exc;
    }

    public abstract boolean readField(int i8);

    public abstract float readFloat();

    public float readFloat(float f, int i8) {
        return !readField(i8) ? f : readFloat();
    }

    public float[] readFloatArray(float[] fArr, int i8) {
        return !readField(i8) ? fArr : readFloatArray();
    }

    public <T extends VersionedParcelable> T readFromParcel(String str, VersionedParcel versionedParcel) {
        try {
            return (T) getReadMethod(str).invoke(null, versionedParcel);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e4);
        } catch (NoSuchMethodException e10) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e10);
        } catch (InvocationTargetException e11) {
            if (e11.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e11.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e11);
        }
    }

    public abstract int readInt();

    public int readInt(int i8, int i9) {
        return !readField(i9) ? i8 : readInt();
    }

    public int[] readIntArray(int[] iArr, int i8) {
        return !readField(i8) ? iArr : readIntArray();
    }

    public <T> List<T> readList(List<T> list, int i8) {
        return !readField(i8) ? list : (List) readCollection(new ArrayList());
    }

    public abstract long readLong();

    public long readLong(long j8, int i8) {
        return !readField(i8) ? j8 : readLong();
    }

    public long[] readLongArray(long[] jArr, int i8) {
        return !readField(i8) ? jArr : readLongArray();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K, V> Map<K, V> readMap(Map<K, V> map, int i8) {
        if (!readField(i8)) {
            return map;
        }
        int i9 = readInt();
        if (i9 < 0) {
            return null;
        }
        ArrayMap arrayMap = new ArrayMap();
        if (i9 == 0) {
            return arrayMap;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        readCollection(arrayList);
        readCollection(arrayList2);
        for (int i10 = 0; i10 < i9; i10++) {
            arrayMap.put(arrayList.get(i10), arrayList2.get(i10));
        }
        return arrayMap;
    }

    public abstract <T extends Parcelable> T readParcelable();

    public <T extends Parcelable> T readParcelable(T t3, int i8) {
        return !readField(i8) ? t3 : (T) readParcelable();
    }

    public Serializable readSerializable() {
        String string = readString();
        if (string == null) {
            return null;
        }
        try {
            return (Serializable) new ObjectInputStream(new ByteArrayInputStream(readByteArray())) { // from class: androidx.versionedparcelable.VersionedParcel.1
                @Override // java.io.ObjectInputStream
                public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException, IOException {
                    Class<?> cls = Class.forName(objectStreamClass.getName(), false, getClass().getClassLoader());
                    return cls != null ? cls : super.resolveClass(objectStreamClass);
                }
            }.readObject();
        } catch (IOException e) {
            throw new RuntimeException(a.j("VersionedParcelable encountered IOException reading a Serializable object (name = ", string, ")"), e);
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException(a.j("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = ", string, ")"), e4);
        }
    }

    public <T> Set<T> readSet(Set<T> set, int i8) {
        return !readField(i8) ? set : (Set) readCollection(new ArraySet());
    }

    @RequiresApi(api = 21)
    public Size readSize(Size size, int i8) {
        if (!readField(i8)) {
            return size;
        }
        if (readBoolean()) {
            return new Size(readInt(), readInt());
        }
        return null;
    }

    @RequiresApi(api = 21)
    public SizeF readSizeF(SizeF sizeF, int i8) {
        if (!readField(i8)) {
            return sizeF;
        }
        if (readBoolean()) {
            return new SizeF(readFloat(), readFloat());
        }
        return null;
    }

    public SparseBooleanArray readSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int i8) {
        if (!readField(i8)) {
            return sparseBooleanArray;
        }
        int i9 = readInt();
        if (i9 < 0) {
            return null;
        }
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray(i9);
        for (int i10 = 0; i10 < i9; i10++) {
            sparseBooleanArray2.put(readInt(), readBoolean());
        }
        return sparseBooleanArray2;
    }

    public abstract String readString();

    public String readString(String str, int i8) {
        return !readField(i8) ? str : readString();
    }

    public abstract IBinder readStrongBinder();

    public IBinder readStrongBinder(IBinder iBinder, int i8) {
        return !readField(i8) ? iBinder : readStrongBinder();
    }

    public <T extends VersionedParcelable> T readVersionedParcelable(T t3, int i8) {
        return !readField(i8) ? t3 : (T) readVersionedParcelable();
    }

    public abstract void setOutputField(int i8);

    public void setSerializationFlags(boolean z2, boolean z3) {
    }

    public <T> void writeArray(T[] tArr, int i8) {
        setOutputField(i8);
        writeArray(tArr);
    }

    public abstract void writeBoolean(boolean z2);

    public void writeBoolean(boolean z2, int i8) {
        setOutputField(i8);
        writeBoolean(z2);
    }

    public void writeBooleanArray(boolean[] zArr, int i8) {
        setOutputField(i8);
        writeBooleanArray(zArr);
    }

    public abstract void writeBundle(Bundle bundle);

    public void writeBundle(Bundle bundle, int i8) {
        setOutputField(i8);
        writeBundle(bundle);
    }

    public void writeByte(byte b9, int i8) {
        setOutputField(i8);
        writeInt(b9);
    }

    public abstract void writeByteArray(byte[] bArr);

    public void writeByteArray(byte[] bArr, int i8) {
        setOutputField(i8);
        writeByteArray(bArr);
    }

    public abstract void writeByteArray(byte[] bArr, int i8, int i9);

    public void writeCharArray(char[] cArr, int i8) {
        setOutputField(i8);
        if (cArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(cArr.length);
        for (char c9 : cArr) {
            writeInt(c9);
        }
    }

    public abstract void writeCharSequence(CharSequence charSequence);

    public void writeCharSequence(CharSequence charSequence, int i8) {
        setOutputField(i8);
        writeCharSequence(charSequence);
    }

    public abstract void writeDouble(double d7);

    public void writeDouble(double d7, int i8) {
        setOutputField(i8);
        writeDouble(d7);
    }

    public void writeDoubleArray(double[] dArr, int i8) {
        setOutputField(i8);
        writeDoubleArray(dArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void writeException(Exception exc, int i8) {
        int i9;
        setOutputField(i8);
        if (exc == 0) {
            writeNoException();
            return;
        }
        if ((exc instanceof Parcelable) && exc.getClass().getClassLoader() == Parcelable.class.getClassLoader()) {
            i9 = EX_PARCELABLE;
        } else if (exc instanceof SecurityException) {
            i9 = -1;
        } else if (exc instanceof BadParcelableException) {
            i9 = -2;
        } else if (exc instanceof IllegalArgumentException) {
            i9 = -3;
        } else if (exc instanceof NullPointerException) {
            i9 = -4;
        } else if (exc instanceof IllegalStateException) {
            i9 = -5;
        } else if (exc instanceof NetworkOnMainThreadException) {
            i9 = EX_NETWORK_MAIN_THREAD;
        } else {
            i9 = exc instanceof UnsupportedOperationException ? -7 : 0;
        }
        writeInt(i9);
        if (i9 == 0) {
            if (!(exc instanceof RuntimeException)) {
                throw new RuntimeException(exc);
            }
            throw ((RuntimeException) exc);
        }
        writeString(exc.getMessage());
        if (i9 != EX_PARCELABLE) {
            return;
        }
        writeParcelable((Parcelable) exc);
    }

    public abstract void writeFloat(float f);

    public void writeFloat(float f, int i8) {
        setOutputField(i8);
        writeFloat(f);
    }

    public void writeFloatArray(float[] fArr, int i8) {
        setOutputField(i8);
        writeFloatArray(fArr);
    }

    public abstract void writeInt(int i8);

    public void writeInt(int i8, int i9) {
        setOutputField(i9);
        writeInt(i8);
    }

    public void writeIntArray(int[] iArr, int i8) {
        setOutputField(i8);
        writeIntArray(iArr);
    }

    public <T> void writeList(List<T> list, int i8) {
        writeCollection(list, i8);
    }

    public abstract void writeLong(long j8);

    public void writeLong(long j8, int i8) {
        setOutputField(i8);
        writeLong(j8);
    }

    public void writeLongArray(long[] jArr, int i8) {
        setOutputField(i8);
        writeLongArray(jArr);
    }

    public <K, V> void writeMap(Map<K, V> map, int i8) {
        setOutputField(i8);
        if (map == null) {
            writeInt(-1);
            return;
        }
        int size = map.size();
        writeInt(size);
        if (size == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        writeCollection(arrayList);
        writeCollection(arrayList2);
    }

    public void writeNoException() {
        writeInt(0);
    }

    public abstract void writeParcelable(Parcelable parcelable);

    public void writeParcelable(Parcelable parcelable, int i8) {
        setOutputField(i8);
        writeParcelable(parcelable);
    }

    public void writeSerializable(Serializable serializable, int i8) {
        setOutputField(i8);
        writeSerializable(serializable);
    }

    public <T> void writeSet(Set<T> set, int i8) {
        writeCollection(set, i8);
    }

    @RequiresApi(api = 21)
    public void writeSize(Size size, int i8) {
        setOutputField(i8);
        writeBoolean(size != null);
        if (size != null) {
            writeInt(size.getWidth());
            writeInt(size.getHeight());
        }
    }

    @RequiresApi(api = 21)
    public void writeSizeF(SizeF sizeF, int i8) {
        setOutputField(i8);
        writeBoolean(sizeF != null);
        if (sizeF != null) {
            writeFloat(sizeF.getWidth());
            writeFloat(sizeF.getHeight());
        }
    }

    public void writeSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int i8) {
        setOutputField(i8);
        if (sparseBooleanArray == null) {
            writeInt(-1);
            return;
        }
        int size = sparseBooleanArray.size();
        writeInt(size);
        for (int i9 = 0; i9 < size; i9++) {
            writeInt(sparseBooleanArray.keyAt(i9));
            writeBoolean(sparseBooleanArray.valueAt(i9));
        }
    }

    public abstract void writeString(String str);

    public void writeString(String str, int i8) {
        setOutputField(i8);
        writeString(str);
    }

    public abstract void writeStrongBinder(IBinder iBinder);

    public void writeStrongBinder(IBinder iBinder, int i8) {
        setOutputField(i8);
        writeStrongBinder(iBinder);
    }

    public abstract void writeStrongInterface(IInterface iInterface);

    public void writeStrongInterface(IInterface iInterface, int i8) {
        setOutputField(i8);
        writeStrongInterface(iInterface);
    }

    public <T extends VersionedParcelable> void writeToParcel(T t3, VersionedParcel versionedParcel) {
        try {
            getWriteMethod(t3.getClass()).invoke(null, t3, versionedParcel);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e4);
        } catch (NoSuchMethodException e10) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e10);
        } catch (InvocationTargetException e11) {
            if (!(e11.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e11);
            }
            throw ((RuntimeException) e11.getCause());
        }
    }

    public void writeVersionedParcelable(VersionedParcelable versionedParcelable, int i8) {
        setOutputField(i8);
        writeVersionedParcelable(versionedParcelable);
    }

    private <T> void writeCollection(Collection<T> collection) {
        if (collection == null) {
            writeInt(-1);
        }
        int size = collection.size();
        writeInt(size);
        if (size > 0) {
            int type = getType(collection.iterator().next());
            writeInt(type);
            switch (type) {
                case 1:
                    Iterator<T> it = collection.iterator();
                    while (it.hasNext()) {
                        writeVersionedParcelable((VersionedParcelable) it.next());
                    }
                    break;
                case 2:
                    Iterator<T> it2 = collection.iterator();
                    while (it2.hasNext()) {
                        writeParcelable((Parcelable) it2.next());
                    }
                    break;
                case 3:
                    Iterator<T> it3 = collection.iterator();
                    while (it3.hasNext()) {
                        writeSerializable((Serializable) it3.next());
                    }
                    break;
                case 4:
                    Iterator<T> it4 = collection.iterator();
                    while (it4.hasNext()) {
                        writeString((String) it4.next());
                    }
                    break;
                case 5:
                    Iterator<T> it5 = collection.iterator();
                    while (it5.hasNext()) {
                        writeStrongBinder((IBinder) it5.next());
                    }
                    break;
                case 7:
                    Iterator<T> it6 = collection.iterator();
                    while (it6.hasNext()) {
                        writeInt(((Integer) it6.next()).intValue());
                    }
                    break;
                case 8:
                    Iterator<T> it7 = collection.iterator();
                    while (it7.hasNext()) {
                        writeFloat(((Float) it7.next()).floatValue());
                    }
                    break;
            }
        }
    }

    private void writeSerializable(Serializable serializable) {
        if (serializable == null) {
            writeString(null);
            return;
        }
        String name = serializable.getClass().getName();
        writeString(name);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            writeByteArray(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(a.j("VersionedParcelable encountered IOException writing serializable object (name = ", name, ")"), e);
        }
    }

    public <T> T[] readArray(T[] tArr) {
        int i8 = readInt();
        if (i8 < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(i8);
        if (i8 != 0) {
            int i9 = readInt();
            if (i8 < 0) {
                return null;
            }
            if (i9 == 1) {
                while (i8 > 0) {
                    arrayList.add(readVersionedParcelable());
                    i8--;
                }
            } else if (i9 == 2) {
                while (i8 > 0) {
                    arrayList.add(readParcelable());
                    i8--;
                }
            } else if (i9 == 3) {
                while (i8 > 0) {
                    arrayList.add(readSerializable());
                    i8--;
                }
            } else if (i9 == 4) {
                while (i8 > 0) {
                    arrayList.add(readString());
                    i8--;
                }
            } else if (i9 == 5) {
                while (i8 > 0) {
                    arrayList.add(readStrongBinder());
                    i8--;
                }
            }
        }
        return (T[]) arrayList.toArray(tArr);
    }

    public boolean[] readBooleanArray() {
        int i8 = readInt();
        if (i8 < 0) {
            return null;
        }
        boolean[] zArr = new boolean[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            zArr[i9] = readInt() != 0;
        }
        return zArr;
    }

    public double[] readDoubleArray() {
        int i8 = readInt();
        if (i8 < 0) {
            return null;
        }
        double[] dArr = new double[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            dArr[i9] = readDouble();
        }
        return dArr;
    }

    public float[] readFloatArray() {
        int i8 = readInt();
        if (i8 < 0) {
            return null;
        }
        float[] fArr = new float[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            fArr[i9] = readFloat();
        }
        return fArr;
    }

    public int[] readIntArray() {
        int i8 = readInt();
        if (i8 < 0) {
            return null;
        }
        int[] iArr = new int[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            iArr[i9] = readInt();
        }
        return iArr;
    }

    public long[] readLongArray() {
        int i8 = readInt();
        if (i8 < 0) {
            return null;
        }
        long[] jArr = new long[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            jArr[i9] = readLong();
        }
        return jArr;
    }

    public <T extends VersionedParcelable> T readVersionedParcelable() {
        String string = readString();
        if (string == null) {
            return null;
        }
        return (T) readFromParcel(string, createSubParcel());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void writeArray(T[] tArr) {
        if (tArr == 0) {
            writeInt(-1);
            return;
        }
        int length = tArr.length;
        writeInt(length);
        if (length > 0) {
            int i8 = 0;
            int type = getType(tArr[0]);
            writeInt(type);
            if (type == 1) {
                while (i8 < length) {
                    writeVersionedParcelable((VersionedParcelable) tArr[i8]);
                    i8++;
                }
                return;
            }
            if (type == 2) {
                while (i8 < length) {
                    writeParcelable((Parcelable) tArr[i8]);
                    i8++;
                }
                return;
            }
            if (type == 3) {
                while (i8 < length) {
                    writeSerializable((Serializable) tArr[i8]);
                    i8++;
                }
            } else if (type == 4) {
                while (i8 < length) {
                    writeString((String) tArr[i8]);
                    i8++;
                }
            } else {
                if (type != 5) {
                    return;
                }
                while (i8 < length) {
                    writeStrongBinder((IBinder) tArr[i8]);
                    i8++;
                }
            }
        }
    }

    public void writeBooleanArray(boolean[] zArr) {
        if (zArr != null) {
            writeInt(zArr.length);
            for (boolean z2 : zArr) {
                writeInt(z2 ? 1 : 0);
            }
            return;
        }
        writeInt(-1);
    }

    public void writeByteArray(byte[] bArr, int i8, int i9, int i10) {
        setOutputField(i10);
        writeByteArray(bArr, i8, i9);
    }

    public void writeDoubleArray(double[] dArr) {
        if (dArr != null) {
            writeInt(dArr.length);
            for (double d7 : dArr) {
                writeDouble(d7);
            }
            return;
        }
        writeInt(-1);
    }

    public void writeFloatArray(float[] fArr) {
        if (fArr != null) {
            writeInt(fArr.length);
            for (float f : fArr) {
                writeFloat(f);
            }
            return;
        }
        writeInt(-1);
    }

    public void writeIntArray(int[] iArr) {
        if (iArr != null) {
            writeInt(iArr.length);
            for (int i8 : iArr) {
                writeInt(i8);
            }
            return;
        }
        writeInt(-1);
    }

    public void writeLongArray(long[] jArr) {
        if (jArr != null) {
            writeInt(jArr.length);
            for (long j8 : jArr) {
                writeLong(j8);
            }
            return;
        }
        writeInt(-1);
    }

    public void writeVersionedParcelable(VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            writeString(null);
            return;
        }
        writeVersionedParcelableCreator(versionedParcelable);
        VersionedParcel versionedParcelCreateSubParcel = createSubParcel();
        writeToParcel(versionedParcelable, versionedParcelCreateSubParcel);
        versionedParcelCreateSubParcel.closeField();
    }

    private Exception readException(int i8, String str) {
        return createException(i8, str);
    }
}
