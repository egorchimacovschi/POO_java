import java.util.Vector;

public class Table {
    private final Vector<Vector<Object>> rows = new Vector<>();

    public Table(Object[][] data) {
        for (Object[] line : data) {
            Vector<Object> row = new Vector<>();
            for (Object cell : line) {
                row.add(cell);
            }
            rows.add(row);
        }
    }

    public void print(MyPrinter p) {
        p.print(rows);
    }

    public class CsvPrinter implements MyPrinter {
        private final String delimiter;

        public CsvPrinter() {
            this(",");
        }

        public CsvPrinter(String delimiter) {
            this.delimiter = delimiter;
        }

        @Override
        public void print(Vector<Vector<Object>> rows) {
            for (Vector<Object> row : rows) {
                for (int i = 0; i < row.size(); i++) {
                    if (i > 0) {
                        System.out.print(delimiter);
                    }
                    System.out.print(row.get(i));
                }
                System.out.println();
            }
        }
    }

    public class AsciiPrinter implements MyPrinter {
        private final int[] sizes;

        public AsciiPrinter(int[] sizes) {
            this.sizes = sizes;
        }

        @Override
        public void print(Vector<Vector<Object>> rows) {
            for (Vector<Object> row : rows) {
                for (int i = 0; i < row.size(); i++) {
                    System.out.format("%-" + sizes[i] + "s|", row.get(i));
                }
                System.out.println();
            }
        }
    }
}
