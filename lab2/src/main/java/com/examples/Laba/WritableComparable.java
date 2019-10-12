package com.examples.Laba;

import java.io.DataInput;
import java.io.IOException;

public class WritableComparable {
    int AiroportID, flag;

    public WritableComparable(int AiroportID, int flag){
        this.AiroportID = AiroportID;
        this.flag = flag;
    }

    public void read(DataInput d) throws IOException {
        AiroportID = d.readInt();
        flag = d.readInt();
    }

    public void compareAiroport(int AiroportID){
        WritableComparable second;
        if (this.AiroportID > second.AiroportID){
            return 1;
        } else {
            return 0;
        }
    }
}
