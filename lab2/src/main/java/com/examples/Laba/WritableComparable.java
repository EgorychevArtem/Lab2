package com.examples.Laba;

import java.io.DataInput;
import java.io.IOException;

public class WritableComparable {
    int AiroportID, flag;

    public WritableComparable(int AiroportID, int flag){
        this.AiroportID = AiroportID;
        this.flag = flag;
    }

    public WritableComparable(Class<WritableComparable> writableComparableClass, boolean b) {
    }

    public void read(DataInput d) throws IOException {
        AiroportID = d.readInt();
        flag = d.readInt();
    }

    public int compareAiroport(WritableComparable AiroportID){
        WritableComparable second = AiroportID;
        if (this.AiroportID > second.AiroportID){
            return 1;
        } else {
            return 0;
        }
    }

    public String PrintResult(){
        String str = "AiroportID: " + AiroportID + "flag: " + flag;
        return str;
    }
}
