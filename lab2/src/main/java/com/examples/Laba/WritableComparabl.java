package com.examples.Laba;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.WritableComparable;

public class WritableComparabl implements WritableComparable {
    int AiroportID, flag;

    public WritableComparabl(int AiroportID, int flag){
        this.AiroportID = AiroportID;
        this.flag = flag;
    }

    public WritableComparabl() {
    }

    public void read(DataInput d) throws IOException {
        AiroportID = d.readInt();
        flag = d.readInt();
    }

    public int compareAiroport(WritableComparabl AiroportID){
        WritableComparabl second = AiroportID;
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

    @Override
    public int compareTo(Object o) {
        WritableComparabl a = (WritableComparabl) o;
        if (this.AiroportID > a.AiroportID){
            return 1;
        } else if (this.AiroportID < a.AiroportID) {
            return -1;
        }
        return 0;
    }

    @Override
    public void write(DataOutput d) throws IOException {
        d.writeInt(AiroportID);
        d.writeInt(flag);
    }

    @Override
    public void readFields(DataInput d) throws IOException {
        AiroportID = d.readInt();
        flag = d.readInt();
    }
}
