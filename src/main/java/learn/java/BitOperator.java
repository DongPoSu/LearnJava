package learn.java;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.java
 * company: SiBu
 * create_date: 2017/02/24
 * description :
 */
public class BitOperator {

    /**
     * db index 存储位置为，short的第二个字节（高7位）高第8位为符号位0 最大值为127
     */
    private static final short DB_INDEX_HEX = (short) 0x7F00;
    private static final short DB_INDEX_POSITION = (short) 8;

    /**
     * table index 存储位置为，short的第一个字节（低8位）最大值为255
     */
    private static final short TABLE_INDEX_HEX = (short) 0x00FF;

    public static void main(String[] args) {
        System.out.println(test());

    }

    public static int test() {
        try {
            System.out.println(1542>>8);
            System.out.println(1542&TABLE_INDEX_HEX);
            String i=null;
            i.getBytes();
            return 1 ;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            int i = 0;
            do {
                i++;
                System.out.println("finally" + i);
            } while (i>100);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread.sleep(10000)");
            return 2;
        }
    }
    public static void testShortMark() {
        short dbIndex = 6;
        short tableIndex = 6;
        short dbTableShortMark = (short) (((dbIndex << DB_INDEX_POSITION) & DB_INDEX_HEX) | (tableIndex & TABLE_INDEX_HEX));
        System.out.println(dbTableShortMark);
        System.out.println((short) (dbTableShortMark >> DB_INDEX_POSITION));
        System.out.println(getDbIndex(dbTableShortMark));
        System.out.println(getTableIndex(dbTableShortMark));
    }

    /**
     * 获取tableIndex(低8位)>>最大值为255
     *
     * @param dbTableShortMark 高7位为dbIndex,低8位为tableIndex 高第8位为符号位
     * @return
     */
    public static short getTableIndex(short dbTableShortMark) {
        return (short) (dbTableShortMark & TABLE_INDEX_HEX);
    }

    /**
     * 获取dbIndex(高7位)>>最大值为127 高第8位为符号位
     *
     * @param dbTableShortMark 高7位为dbIndex,低8位为tableIndex 高第8位为符号位
     * @return
     */
    public static short getDbIndex(short dbTableShortMark) {
        return (short) (dbTableShortMark >> DB_INDEX_POSITION);
    }
}
