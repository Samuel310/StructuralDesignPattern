package com.dp.Bridge;

interface internal {
    int cal_internal();
    void setMarks();
}

class theory implements internal {
    int m1,m2,m3;
    public int cal_internal() {
        return ((m1+m2+m3)/3);
    }
    @Override
    public void setMarks() {
        m1 = m2 = m3 = 20;  // setting all marks to 20 by default.
    }
}

class Lab implements internal {
    int arr[]=new int[10];
    public int cal_internal() {
        int sum=0;
        for(int i=0;i<10;i++)
            sum+=arr[i];
        return (sum/10);
    }
    @Override
    public void setMarks() {
        for(int i=0;i<10;i++)
            arr[i]=20;  // setting all marks to 20 by default.
    }
}

abstract class Test {
    internal obj;
    Test (String x) {
        if(x.endsWith("Lab"))
            obj=new Lab();
        else
            obj=new theory();
    }
    abstract int calculate();
}

class Internal3 extends Test {
    String name;
    Internal3(String x) {
        super(x);
        name=x;
    }
    @Override
    public int calculate() {
        obj.setMarks();
        System.out.println("the average mark of " + name+ " in test 3");
        return obj.cal_internal();
    }
}

public class Main {
    public static void main(String[] args) {
        Test t = new Internal3("Java Programming");
        System.out.println(t.calculate());
    }
}
