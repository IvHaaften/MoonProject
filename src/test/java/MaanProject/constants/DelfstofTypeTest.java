package MaanProject.constants;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

class DelfstofTypeTest {

    @Test
    public void concurrencyTest() throws InterruptedException {
        List<String> namenlijst = DelfstofType.values().stream().map(Delfstof::getElementnaam).collect(Collectors.toList());
        for (int n = 0; n < 10; n++) {
            namenlijst.addAll(DelfstofType.values().stream().map(Delfstof::getElementnaam).collect(Collectors.toList()));
        }

        var executorService = Executors.newFixedThreadPool(10);
        executorService.submit(() -> {
            try {
                reverseReplaceAllOverhaul(String::toUpperCase, namenlijst);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            try {
                replaceAllOverhaul(String::toLowerCase, namenlijst);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println(namenlijst);

    }

    private void reverseReplaceAllOverhaul(UnaryOperator<String> operator, List<String> list) throws InterruptedException {
        ListIterator<String> li = list.listIterator(list.size());

        while (li.hasPrevious()) {
            li.set(operator.apply(li.previous()));
        }
    }

    private void replaceAllOverhaul(UnaryOperator<String> operator, List<String> list) throws InterruptedException {
        ListIterator<String> li = list.listIterator();

        while (li.hasNext()) {
            li.set(operator.apply(li.next()));
        }
    }


}