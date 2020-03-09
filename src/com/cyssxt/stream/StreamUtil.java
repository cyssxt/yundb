package com.cyssxt.stream;

import com.cyssxt.constant.ErrorMessage;
import com.cyssxt.exception.YunDbException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class StreamUtil {
    String dbPath;

    RandomAccessFile raf;

    public StreamUtil(String dbPath) throws FileNotFoundException {
        this.dbPath = dbPath;
        this.raf = new RandomAccessFile(new File(dbPath),"wb+");
    }

    public Long readLong() throws YunDbException {
        try {
            return raf.readLong();
        } catch (IOException e) {
            throw new YunDbException(ErrorMessage.RAF_ERROR);
        }
    }

    public short readShort() throws YunDbException {
        try {
            return raf.readShort();
        } catch (IOException e) {
            throw new YunDbException(ErrorMessage.RAF_ERROR);
        }
    }

    public short readByte() throws YunDbException {
        try {
            return raf.readByte();
        } catch (IOException e) {
            throw new YunDbException(ErrorMessage.RAF_ERROR);
        }
    }

    public Integer readInt() throws YunDbException {
        try {
            return raf.readInt();
        } catch (IOException e) {
            throw new YunDbException(ErrorMessage.RAF_ERROR);
        }
    }

    public byte[] readBytes(int length) throws YunDbException {
        try {
            byte[] temp = new byte[length];
            raf.read(temp);
            return temp;
        } catch (IOException e) {
            throw new YunDbException(ErrorMessage.RAF_ERROR);
        }
    }

    public Long getOffset() throws YunDbException {
        try {
            return raf.getFilePointer();
        } catch (IOException e) {
            throw new YunDbException(ErrorMessage.RAF_ERROR);
        }
    }

    public void seek(long offset) throws YunDbException {
        if(offset<0){
            throw new YunDbException(ErrorMessage.OFFSET_MUST_BIGGER_THAN_ZERO);
        }
        try {
            raf.seek(offset);
        } catch (IOException e) {
            throw new YunDbException(ErrorMessage.SEEK_ERROR);
        }
    }

    public void write(int size) throws YunDbException {
        try {
            raf.writeInt(size);
        } catch (IOException e) {
            throw new YunDbException(ErrorMessage.RAF_ERROR);
        }
    }
}
