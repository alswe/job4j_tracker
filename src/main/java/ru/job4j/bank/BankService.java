package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    public Optional<User> findByPassport(String passport) {
//        for (User user : users.keySet()) {
//            if (user.getPassport().equals(passport)) {
//                return user;
//            }
//        }
       return users.keySet().stream()
               .filter(user -> user.getPassport().equals(passport))
               .findFirst();
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        //            List<Account> accounts = users.get(user);
        //            for (Account account : accounts) {
        //                if (account.getRequisite().equals(requisite)) {
        //                    return account;
        //                }
        //            }
        return user.flatMap(value -> users.get(value).stream()
                .filter(account -> account
                        .getRequisite()
                        .equals(requisite))
                .findFirst());
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean result = false;
        Optional<Account> source = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destination = findByRequisite(destPassport, destRequisite);
        if (source.isPresent() && destination.isPresent()
                && source.get().getBalance() - amount >= 0) {
            source.get().setBalance(source.get().getBalance() - amount);
            destination.get().setBalance(destination.get().getBalance() + amount);
            result = true;
        }
        return result;
    }
}