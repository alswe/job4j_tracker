package ru.job4j.stream;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    private List<Profile> profiles;

    @Before
    public void setUp() {
        Profile profile1 = new Profile(new Address("Moscow", "Sadovaya", 2, 3));
        Profile profile2 = new Profile(new Address("Saint Petersburg", "Nevsky Prospect", 22, 31));
        Profile profile3 = new Profile(new Address("Moscow", "Lenina", 23, 21));
        Profile profile4 = new Profile(new Address("Saint Petersburg", "Stachek Prospekt", 231, 13));
        Profile profile5 = new Profile(new Address("Moscow", "Leningradskoe Shosse", 323, 323));
        Profile profile6 = new Profile(new Address("Kaliningrad", "Lesnaya", 12, 33));
        Profile profile7 = new Profile(new Address("Kaliningrad", "Lesnaya", 12, 33));
        profiles = List.of(profile1, profile2, profile3, profile4, profile5, profile6, profile7);
    }

    @Test
    public void profilesTest() {
        List<Address> expected = List.of(new Address("Kaliningrad", "Lesnaya", 12, 33),
                new Address("Moscow", "Sadovaya", 2, 3),
                new Address("Moscow", "Lenina", 23, 21),
                new Address("Moscow", "Leningradskoe Shosse", 323, 323),
                new Address("Saint Petersburg", "Nevsky Prospect", 22, 31),
                new Address("Saint Petersburg", "Stachek Prospekt", 231, 13));
        List<Address> rsl = Profiles.collect(profiles);
        assertThat(rsl, is(expected));
    }
}