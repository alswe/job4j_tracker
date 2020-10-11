package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameDescAndProrityDesc() {
        Comparator<Job> cmpNamePriority = new JobComparatorNameDesc().thenComparing(new JobComparatorPriorityDesc());
        int rsl = cmpNamePriority.compare(
                new Job("B", 0),
                new Job("A", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByProrityDescAndNameDesc() {
        Comparator<Job> cmpNamePriority = new JobComparatorPriorityDesc().thenComparing(new JobComparatorNameDesc());
        int rsl = cmpNamePriority.compare(
                new Job("B", 1),
                new Job("A", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByProrityDescAndNameAsc() {
        Comparator<Job> cmpNamePriority = new JobComparatorPriorityDesc().thenComparing(new JobComparatorNameAsc());
        int rsl = cmpNamePriority.compare(
                new Job("B", 1),
                new Job("A", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByProrityAscAndNameAsc() {
        Comparator<Job> cmpNamePriority = new JobComparatorPriorityAsc().thenComparing(new JobComparatorNameAsc());
        int rsl = cmpNamePriority.compare(
                new Job("B", 1),
                new Job("B", 1)
        );
        assertThat(rsl, equalTo(0));
    }

    @Test
    public void whenCompatorByProrityAsc() {
        Comparator<Job> cmpNamePriority = new JobComparatorPriorityAsc();
        int rsl = cmpNamePriority.compare(
                new Job("A", 1),
                new Job("B", 2)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByProrityDesc() {
        Comparator<Job> cmpNamePriority = new JobComparatorPriorityDesc();
        int rsl = cmpNamePriority.compare(
                new Job("A", 2),
                new Job("B", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameDesc() {
        Comparator<Job> cmpNamePriority = new JobComparatorNameDesc();
        int rsl = cmpNamePriority.compare(
                new Job("B", 2),
                new Job("A", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAsc() {
        Comparator<Job> cmpNamePriority = new JobComparatorNameAsc();
        int rsl = cmpNamePriority.compare(
                new Job("A", 2),
                new Job("B", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}