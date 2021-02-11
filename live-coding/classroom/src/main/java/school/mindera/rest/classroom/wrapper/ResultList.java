package school.mindera.rest.classroom.wrapper;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultList<T> extends LinkedList<T> {

    public ResultList() {
    }

    public ResultList(Collection<? extends T> c) {
        super(c);
    }

    public List<T> paginate(int results, int page) {
        return super.stream()
                .skip((long) results * page)
                .limit(results)
                .collect(Collectors.toList());
    }
}
