package com.example.refactoring2.ch08.ex1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AccountTest {

    @DisplayName("초과 인출이 없는 경우")
    @Test
    void test1() {
        Account account = new Account(0, new AccountType(false));

        double actual = account.bankCharge();
        
        assertThat(actual).isEqualTo(4.5);
    }

    @DisplayName("일반 계좌에서 초과 인출")
    @Test
    void test2() {
        Account account = new Account(5, new AccountType(false));

        double actual = account.bankCharge();

        assertThat(actual).isEqualTo(4.5 + (5 * 1.75), offset(0.1));
    }

    @DisplayName("프리미엄 계좌에서 7일 이하 초과 인출")
    @Test
    void test3() {
        Account account = new Account(7, new AccountType(true));

        double actual = account.bankCharge();

        assertThat(actual).isEqualTo(14.5, offset(0.1));
    }

    @DisplayName("프리미엄 계좌에서 7일 초과하여 초과 인출")
    @Test
    void test4() {
        Account account = new Account(10, new AccountType(true));

        double actual = account.bankCharge();

        assertThat(actual).isEqualTo(17.05, offset(0.1));
    }

}
