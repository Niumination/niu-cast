package io.netty.handler.codec.serialization;

import h.a;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.StreamCorruptedException;

/* JADX INFO: loaded from: classes3.dex */
class CompactObjectInputStream extends ObjectInputStream {
    private final ClassResolver classResolver;

    public CompactObjectInputStream(InputStream inputStream, ClassResolver classResolver) throws IOException {
        super(inputStream);
        this.classResolver = classResolver;
    }

    @Override // java.io.ObjectInputStream
    public ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
        int i10 = read();
        if (i10 < 0) {
            throw new EOFException();
        }
        if (i10 == 0) {
            return super.readClassDescriptor();
        }
        if (i10 != 1) {
            throw new StreamCorruptedException(a.a("Unexpected class descriptor type: ", i10));
        }
        return ObjectStreamClass.lookupAny(this.classResolver.resolve(readUTF()));
    }

    @Override // java.io.ObjectInputStream
    public void readStreamHeader() throws IOException {
        int i10 = readByte() & 255;
        if (i10 != 5) {
            throw new StreamCorruptedException(a.a("Unsupported version: ", i10));
        }
    }

    @Override // java.io.ObjectInputStream
    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
        try {
            return this.classResolver.resolve(objectStreamClass.getName());
        } catch (ClassNotFoundException unused) {
            return super.resolveClass(objectStreamClass);
        }
    }
}
