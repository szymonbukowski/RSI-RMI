import java.io.Serializable;

public class ResultType implements Serializable {

    private static final long serialVersionUID = 102L;
    long count;
    long max;
    long med;

    long duration;
    String time;

    public ResultType() {
    }

    public ResultType(long count, long max, long med, long duration, String time) {
        this.count = count;
        this.max = max;
        this.med = med;
        this.duration = duration;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Rezultat:\n" +
                "ile liczb pierwszych: " + count +
                "\nnajwieksza liczba pierwsza: " + max +
                "\nmediana losowań: " + med +
                "\nczas trwania w ms: " + duration +
                "\nkoniec wykonywania: " + time + '\n';
    }
}
