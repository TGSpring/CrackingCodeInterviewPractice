/**
 * Tyler Spring
 * 12/4/2024
 * Chapter 5 Question 5.7
 * Draw line.
 */
public class Q5_8 {
    public static void drawLine (byte[] screen, int width, int x1, int x2, int y) {
        //Calculate the starting and ending byte indices.
        int startByte = x1 % 8;
        int endByte = x2 / 8;

        //Calculate the row offset
        int rowOffset = y * (width / 8);

        //Handle the start byte(partial bits)
        int startBit = x1 % 8;
        if (startByte == endByte) {
            //If x1 and x2 are in the same byte, handle the range within one byte.
            screen[rowOffset + startByte] |= ((0xFF >> startBit) & (0xFF << (7 - (x2 % 8))));
        } else {
            //Turn on the bits from x1 to the end of startByte
            screen[rowOffset + startByte] |= (0xFF >> startBit);
        }

        //Handle the end byte(partial bits)
        int endBit = x2 % 8;
        if (startByte != endByte) {
            //Turn on the bits from the start of endByte to x2
            screen[rowOffset + endByte] |= (0xFF << (7 - endBit));
        }

        //Fill full bytes between startByte and endByte
        for(int i = startByte + 1; i < endByte; i++) {
            screen[rowOffset + i] = (byte) 0xFF;
        }
    }
    public static void main(String[] args) {
    // Example usage:
    int width = 32; // Screen width in pixels
    int height = 2; // Number of rows
    byte[] screen = new byte[width * height / 8]; // Total bytes = (width * height) / 8

    // Draw a line from x1=2 to x2=25 on row y=1
    drawLine(screen, width, 2, 25, 1);

    // Print the screen in binary
    for (int i = 0; i < screen.length; i++) {
        if (i % (width / 8) == 0) {
            System.out.println(); // New row
        }
        System.out.print(String.format("%8s", Integer.toBinaryString(screen[i] & 0xFF)).replace(' ', '0') + " ");
    }
 }   
}
/**
 * Explanation:
 * Start Byte:
 * Use a mask to set only the required bits.
 * If x1 and x2 are in the same byte, combine start and end masks.
 * 
 * End Byte:
 * Use a mask to set only the required bits.
 * 
 * Full Bytes:
 * Any byte fully covered by the line is set to 0xFF.
 * 
 * Row Offset:
 * Compute the row where the line is drawn using y * (width / 8)
 * 
 * Edge Cases:
 * If x1 == x2, only one bit is set.
 * If the entire line fits in one byte, the start and end masks handle it.
 * 
 * Time complexity: O(n), where n is the number of bytes spanned by the line (endByte - startByte).
 */