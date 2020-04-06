import java.time.LocalDateTime;
import java.util.Random;
import java.util.stream.LongStream;

public class TaskImplementation implements Task {

    private static final long serialVersionUID = 102L;

    long x;
    long y;

    public TaskImplementation(long x, long y) {
        if (x < 0 || y < 0){
            throw new IllegalArgumentException("params should be positive");
        }
        if(y-x < 100){
            throw new IllegalArgumentException("y should be greater than x by 100 at least");
        }
        this.x = x;
        this.y = y;

    }

    @Override
    public ResultType prime() {
        ResultType res = new ResultType();

        long start=System.currentTimeMillis();

        long max_prime = 0;
        long count = 0;
        for(long i=x; i<=y; i++){
            if(isPrime(i)){
                count++;
                max_prime = Math.max(max_prime, i);
            }
        }

        long stop=System.currentTimeMillis();

        res.count = count;
        res.max = max_prime;
        res.duration = stop - start;
        res.time = LocalDateTime.now().toString();
        return res;
    }

    @Override
    public ResultType med() {
        ResultType res = new ResultType();
        Random rd = new Random();
        long start=System.currentTimeMillis();

        LongStream ls = rd.longs(10000001, x, y+1);

        long[] randoms = ls.sorted().toArray();
        long mediana = randoms[randoms.length/2];

        long stop=System.currentTimeMillis();

        res.med = mediana;
        res.duration = stop - start;
        res.time = LocalDateTime.now().toString();
        return res;
    }

    private boolean isPrime(long suspect){
        for (int i = 2; i < suspect/2; i++) {
            if(suspect%i==0)return false;
        }
        return true;
    }
}
