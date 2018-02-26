package learn.io.byteStream.pushbackStream;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * @author suzheng
 * @version v.1.0
 */
public class TestPushBackStream {
    public static void main(String[] args) throws IOException {
        testPushBack();
    }

    private static void testPushBack() throws IOException {
        String s = "North_Korea_may_be_only_a_few_months_away_from_completing_development_of_a_nuclear-tipped_missile_capable_of_hitting_the_U.S._mainland,_despite_existing_international_sanctions_that,_at_times,_have_been_sidestepped_by_smuggling_and_ship-to-ship_transfers_at_sea_of_banned_goods,_according_to_officials.";

       PushbackInputStream pis = new PushbackInputStream(new ByteArrayInputStream(s.getBytes()), 25);
        byte[] bytes = new byte[24];
        int length = pis.read(bytes,0, bytes.length);
        System.out.println(new String(bytes));

        pis.unread(bytes,0, bytes.length);
        System.out.println(new String(bytes));

        length = pis.read(bytes,0, bytes.length);
        System.out.println(new String(bytes));

        length = pis.read(bytes,0, bytes.length);
        System.out.println(new String(bytes));

        pis.close();
    }
}
