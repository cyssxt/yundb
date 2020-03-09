package com.cyssxt.struct;

import com.cyssxt.exception.YunDbException;
import com.cyssxt.stream.DefaultStream;
import com.cyssxt.stream.StreamUtil;

import java.util.List;

public class RowHeader extends DefaultStream {
    int size;
    byte[] nullPos;
    int dynamicLength;
    List<Integer> columns;

    public RowHeader(StreamUtil streamUtil) {
        super(streamUtil);
    }

    @Override
    public void write() throws YunDbException {
        streamUtil.write(size);
        int length = 0;
        if(nullPos!=null){
            length = nullPos.length;
        }
        streamUtil.write(length);
    }

    @Override
    public void read() throws YunDbException {
        this.size = streamUtil.readInt();
        int length = streamUtil.readInt();

    }
}
