package cn.uncleyumo.chapter02.unit05.practise;

/**
 * @author uncle_yumo
 * @fileName Test02
 * @createDate 2025/4/19 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

public class Test02 {
    public static void main(String[] args) {
        int n = 5;
        int m = 10;
        System.out.println("n+m is " + UseCompute.useCompute(new PlusCompute(), n, m));
        System.out.println("n-m is " + UseCompute.useCompute(new SubtractCompute(), n, m));
        System.out.println("n*m is " + UseCompute.useCompute(new MultiplyCompute(), n, m));
        System.out.println("n/m is " + UseCompute.useCompute(new DivideCompute(), n, m));
    }
}
class UseCompute {
    public static int useCompute(Compute compute, int n, int m) {
        return compute.computer(n, m);
    }
}

class PlusCompute implements Compute {
    @Override
    public int computer(int n, int m) {
        return n + m;
    }
}

class MultiplyCompute implements Compute {
    @Override
    public int computer(int n, int m) {
        return n * m;
    }
}
class DivideCompute implements Compute {
    @Override
    public int computer(int n, int m) {
        return n / m;
    }
}
class SubtractCompute implements Compute {
    @Override
    public int computer(int n, int m) {
        return n - m;
    }
}

interface Compute {
    int computer(int n, int m);
}