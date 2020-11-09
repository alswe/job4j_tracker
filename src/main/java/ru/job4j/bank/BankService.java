package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
//        for (User user : users.keySet()) {
//            if (user.getPassport().equals(passport)) {
//                return user;
//            }
//        }
       return users.keySet().stream()
               .filter(user -> user.getPassport().equals(passport))
               .findFirst()
               .orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
//            List<Account> accounts = users.get(user);
//            for (Account account : accounts) {
//                if (account.getRequisite().equals(requisite)) {
//                    return account;
//                }
//            }
            return users.get(user).stream()
                    .filter(account -> account
                            .getRequisite()
                            .equals(requisite))
                    .findFirst().orElse(null);
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean result = false;
        Account source = findByRequisite(srcPassport, srcRequisite);
        Account destination = findByRequisite(destPassport, destRequisite);
        if (source != null && destination != null && source.getBalance() - amount >= 0) {
            source.setBalance(source.getBalance() - amount);
            destination.setBalance(destination.getBalance() + amount);
            result = true;
        }
        return result;
    }
}