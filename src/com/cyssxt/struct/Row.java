package com.cyssxt.struct;

import com.cyssxt.exception.YunDbException;
import com.cyssxt.stream.DefaultStream;

public class Row<T> extends DefaultStream {
    int size;
    T data;
    RowHeader header;

    public Row() {
        header = new RowHeader();
    }

    @Override
    public void write() throws YunDbException {
        header.write();
    }

    @Override
    public void read() throws YunDbException {
        header.read();
    }
}
