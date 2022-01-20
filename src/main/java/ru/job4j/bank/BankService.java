package ru.job4j.bank;

import java.util.*;

/**
 * Класс реализует модель банковской системы.
 *
 * @author VLAD KROTOV
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей, с привязанными к ним счетами,
     * осуществляется в коллекции типа HashMap.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод регистрирует пользователя в системе.
     *
     * @param user регистрируемый пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет пользователю банковский счет.
     * У пользователя может быть несколько банковских счетов.
     *
     * @param passport паспортные данные пользователя
     * @param account  данные добавляемого счета
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по паспортным данным.
     *
     * @param passport паспортные данные клиента
     * @return возвращает найденного пользователя или null, если пользователь не найден
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> passport.equals(u.getPassport()))
                .findFirst();
    }

    /**
     * Метод осуществляет поиск счета пользователя по паспортным данным и реквизитам.
     *
     * @param passport  паспортные данные пользователя
     * @param requisite данные счета пользователя
     * @return возвращает счет пользователя если такой найдет. Если пользователь не найден или не найден
     * счет, то возвращается null.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        Optional<Account> rsl = Optional.empty();
        if (user.isPresent()) {
           rsl = users.get(user.get())
                    .stream()
                    .filter(ac -> requisite.equals(ac.getRequisite()))
                    .findFirst();
        }
            return rsl;
    }

    /**
     * Метод переводит средств с одного счета на другой.
     *
     * @param srcPassport   паспортные данные пользователя, со счета которого осуществляется перевод
     * @param srcRequisite  номер счета, с которого выполняется перевод
     * @param destPassport  паспортные данные пользователя, на счет которого осуществляется перевод
     * @param destRequisite номер счета, на который выполняется перевод
     * @param amount        переводимая сумма
     * @return возвращает true, если перевод удался и false если перевод не был выполнен: не найдены
     * пользователи, не найдены счета пользователей либо недостаточно средств для перевода.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent()
                && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            return true;
        }
        return false;
    }
}