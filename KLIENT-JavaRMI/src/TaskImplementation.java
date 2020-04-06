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
    public ResultType work() {
        ResultType res = new ResultType();
        long start=System.currentTimeMillis();


        long stop=System.currentTimeMillis();

        prime(res);
        med(res);
        res.duration = stop - start;
        res.time = LocalDateTime.now().toString();
        return res;
    }


    private ResultType prime(ResultType res) {

        long max_prime = 0;
        long count = 0;
        for(long i=x; i<=y; i++){
            if(isPrime(i)){
                count++;
                max_prime = Math.max(max_prime, i);
            }
        }
        res.count = count;
        res.max = max_prime;
        return res;
    }

    private ResultType med(ResultType res) {

        Random rd = new Random();

        LongStream ls = rd.longs(10000001, x, y+1);
        long[] randoms = ls.sorted().toArray();
        long mediana = randoms[randoms.length/2];

        res.med = mediana;
        return res;
    }

    private boolean isPrime(long suspect){
        for (int i = 2; i < suspect/2; i++) {
            if(suspect%i==0)return false;
        }
        return true;
    }
}
