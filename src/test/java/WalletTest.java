import org.example.Wallet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {
    Wallet wallet;

    @BeforeEach
    void setup() {
        System.out.println("BeforeEach berhasil dijalankan");
        wallet = new Wallet();
        wallet.setOwner("Alfiz");
    }

    @Test
    void testSetOwner() {
        assertEquals("Alfiz", wallet.getOwner());
    }

    @Nested
    class CardTest {

        @Test
        void testAddCard() {
            wallet.addCard("KTP");
            wallet.addCard("ATM");

            assertEquals(2, wallet.getCards().size());
            assertTrue(wallet.getCards().contains("KTP"));
        }

        @Test
        void testTakeCard() {
            wallet.addCard("SIM");
            String card = wallet.takeCard("SIM");

            assertNotNull(card);
            assertFalse(wallet.getCards().contains("SIM"));
        }
    }

    @Nested
    class MoneyTest {

        @Test
        void testAddMoney() {
            wallet.addMoney(50000);
            wallet.addMoney(25000);

            assertEquals(75000, wallet.getTotalMoney());
        }

        @Test
        void testTakeMoney() {
            wallet.addMoney(100000);
            boolean result = wallet.takeMoney(40000);

            assertTrue(result);
            assertEquals(60000, wallet.getTotalMoney());
        }
    }

    @AfterEach
    void teardown() {
        System.out.println("AfterEach berhasil dijalankan");
    }

    @Test
    void testWalletSummary() {
        wallet.addCard("ATM");
        wallet.addMoney(50000);

        assertAll(
                () -> assertEquals("Alfiz", wallet.getOwner()),
                () -> assertEquals(1, wallet.getCards().size()),
                () -> assertEquals(50000, wallet.getTotalMoney())
        );
    }
}
